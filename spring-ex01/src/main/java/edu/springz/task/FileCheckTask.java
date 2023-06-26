package edu.springz.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.springz.domain.BoardAttachVO;
import edu.springz.mapper.BoardAttachMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Component
@Log4j
@AllArgsConstructor
public class FileCheckTask {
	private BoardAttachMapper boardAttachMapper;
	
	public String getYesterdayFolder() {
		
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		calendar.add(Calendar.DATE, -1);		
		String yesterday = sdf.format(calendar.getTime());		
		
		yesterday = yesterday.replace("-", File.separator);
		
		return yesterday;
	}
	
					 //초 분 시 일 월 요일 [연도]
	@Scheduled( cron = "0 0 9 * * *" )	// 매일 아침 9시 실행
	public void checkFiles() throws Exception {
		Date now = new Date();
		log.warn("checkFiles()....................:" + now.toLocaleString());
		log.warn("=================================");
		log.warn("================================= " + getYesterdayFolder());
		
		List<BoardAttachVO> attachList = boardAttachMapper.yesterdayFiles();
		
		List<Path> folderList = attachList.stream()
				.map(bavo -> Paths.get("c:\\dev\\upload\\", bavo.getUpFolder(), bavo.getUuid() + "_" + bavo.getFileName()))
				.collect(Collectors.toList());
		
		attachList.stream()
		.filter(bavo -> bavo.getImage().equals("Y"))
		.map(bavo -> Paths.get("c:\\dev\\upload\\", bavo.getUpFolder(), "s_" + bavo.getUuid() + "_" + bavo.getFileName()))
		.forEach(path -> folderList.add(path));
		
		// 업로드 폴더에서 어제 날짜 폴더의 실제 파일 가져오기
		File realFile = Paths.get("c:\\dev\\upload\\", getYesterdayFolder()).toFile();
		log.warn("REAL FILE : " + realFile);
		
		// 삭제 대상 파일들 추출 - 데이터 베이스에 X
		File[] removeFiles = realFile.listFiles(file -> folderList.contains(file.toPath()) == false);
		
		// 삭제 대상 파일들 제거
		for ( File file : removeFiles ) {
			log.warn(file.getAbsoluteFile());
			file.delete();
		}
	}
}
