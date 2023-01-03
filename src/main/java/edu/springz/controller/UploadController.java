package edu.springz.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import edu.springz.domain.AttachFileDTO;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Log4j
@Controller
public class UploadController {
	
	// 현재 시점의 '연/월/일' 폴더 경로 문자열 생성하여 반환
	public String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(new Date());
		
		return str.replace("-", File.separator);
	}
	
	// 이미지 파일 여부 확인
	public boolean checkImgType(File file) {
		String contextType;
		try {
			contextType = Files.probeContentType(file.toPath());
			return contextType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 파일 업로드 처리
	public List<AttachFileDTO> uploadFile(MultipartFile[] files) {
		List<AttachFileDTO> attachList = new ArrayList<>();
		String uploadPath = "c:\\dev\\upload\\";
		
		// 연/월/일 폴더 생성
		File upFolder = new File(uploadPath, getFolder());
		log.info("upFolder : " + upFolder);
		
		// 업로드 경로에 해당 폴더가 없는 경우에는 생성
		if (!upFolder.exists()) {
			upFolder.mkdirs();
		}
		
		for(MultipartFile file : files) {
			log.info("==============================");
			log.info("file name : " + file.getOriginalFilename());
			log.info("file size : " + file.getSize());
			
			// UUID 설정
			UUID uuid = UUID.randomUUID();
			log.info(uuid);
			String upFileName = uuid + "_" + file.getOriginalFilename();
			log.info(upFileName);
			File saveFile = new File(upFolder, upFileName);
			
			AttachFileDTO afDto = new AttachFileDTO();
			afDto.setUuid(uuid.toString());
			afDto.setUpFolder(getFolder());
			afDto.setFileName(file.getOriginalFilename());
			afDto.setImage(false);
			
			try {
				file.transferTo(saveFile);	// 파일 업로드 처리
				
				// 이미지 파일일 경우 썸네일 만들기
				if (checkImgType(saveFile)) {
					FileOutputStream fos = new FileOutputStream(new File(upFolder, "s_" + upFileName));
					Thumbnailator.createThumbnail(file.getInputStream(), fos, 100, 100);
					fos.close();
					
					afDto.setImage(true);
				}
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			attachList.add(afDto);
		}
		
		return attachList;
	}
	
	// 파일 삭제 처리
	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName, String type) {
		log.info("deleteFile : " + fileName);
		try {
			File file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();	// 파일 삭제
			
			if (type.equals("image")) {
				String originFile = file.getAbsolutePath().replace("s_", "");	// 원본 파일명
				file = new File(originFile);
				file.delete();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}
	
	// 파일 다운로드
	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> download(String fileName) {
		Resource resource = new FileSystemResource("c:\\dev\\upload\\" + fileName);
		log.info("resource : " + resource);
		
		if (resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		String fileNm = resource.getFilename();
		fileNm = fileNm.substring(fileNm.indexOf("_") + 1); // UUID 제거
		
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Content-Disposition", "attachment; filename=" + new String(fileNm.getBytes("UTF-8"), "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	
	// 파일 미리보기
	@GetMapping("/display")
	public ResponseEntity<byte[]> display(String fileName) {
		File file = new File("c:\\dev\\upload\\" + fileName);
		ResponseEntity<byte[]> result = null;
		
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// ajax로 업로드
	@GetMapping("/upload/ajaxAction")
	public void uploadAjax() {
		log.info("upload formAction Ajax");
	}
	
	@PostMapping("/upload/ajaxAction")
	public ResponseEntity<List<AttachFileDTO>> uploadActionAjax(MultipartFile[] files) {
		log.info("upload action Ajax");
		List<AttachFileDTO> attachList = uploadFile(files);
		
		return new ResponseEntity<List<AttachFileDTO>>(attachList, HttpStatus.OK);
	}
	
	// form 태그로 업로드
	@GetMapping("/upload/formAction")
	public void uploadForm() {
		log.info("upload formAction");
	}
	
	@PostMapping("/upload/formAction")
	public void uploadAction(MultipartFile[] files) {
		log.info("upload action");
//		uploadFile(files);
	}
}
