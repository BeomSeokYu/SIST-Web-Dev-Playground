<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.oreilly.servlet.MultipartRequest, com.oreilly.servlet.multipart.DefaultFileRenamePolicy"
%>
<%
	String uploadPath = application.getInitParameter("uploadPath");
	String savePath = application.getRealPath(uploadPath);
	int maxSize = 5242880;
	String encType = "UTF-8";
	
	out.print(uploadPath + "<br>");
	out.print(savePath + "<br><br>");
	
	MultipartRequest multiReq = new MultipartRequest(request, savePath, maxSize, encType, new DefaultFileRenamePolicy());
	String userName = multiReq.getParameter("usernm");
	/* String userFileName = multiReq.getOriginalFileName("userfile");
	String userFileSysName = multiReq.getFilesystemName("userfile");
	
	if(userFileName != null) {
		out.print("파일 업로드 성공 <br>");
		
		out.print("이름 : " + userName + "<br>");
		out.print("원본 파일 : " + userFileName + "<br>");
		out.print("첨부 파일 : " + userFileSysName + "<br>");
		out.print("파일 크기 : " + multiReq.getFile("userfile").length() + "<br>");
		
		out.print("<img src=\"../upload/"+ userFileName +"\">");
	} */
	Enumeration e = multiReq.getFileNames();
	while(e.hasMoreElements()) {
		String name = (String) e.nextElement();
		System.out.println(name);
		out.print("<img src=\"../upload/"+ multiReq.getFilesystemName(name) +"\">");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadResult.jsp</title>
</head>
<body>
</body>
</html>