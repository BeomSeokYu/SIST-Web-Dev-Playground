<%@page import="java.io.IOException"%>
<%@page import="market.dao.ProductDAO"%>
<%@page import="market.vo.ProductVO, java.lang.Integer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.oreilly.servlet.MultipartRequest, com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%
String uploadPath = application.getInitParameter("uploadPath");
String savePath = application.getRealPath(uploadPath);

int maxSize = 5242880;
String encType = "UTF-8";
MultipartRequest multiReq = null;
ProductVO p = null;
try {
	multiReq = new MultipartRequest(request, savePath, maxSize, encType, new DefaultFileRenamePolicy());
	String fileName = multiReq.getFilesystemName("pimage");
	System.out.println(fileName +" | " + multiReq.getParameter("pimage2"));
	pageContext.setAttribute("pimg", fileName);
	pageContext.setAttribute("pid_old", multiReq.getParameter("pid_old"));

	p = new ProductVO();
	p.setPid(multiReq.getParameter("pid"));
	p.setCategory(multiReq.getParameter("category"));
	p.setCondition(multiReq.getParameter("condition"));
	p.setDescription(multiReq.getParameter("description"));
	p.setMaker(multiReq.getParameter("maker"));
	p.setPname(multiReq.getParameter("pname"));
	p.setPrice(Integer.parseInt(multiReq.getParameter("price")));
	p.setStock(Integer.parseInt(multiReq.getParameter("stock")));
	p.setPimage(fileName != null ? fileName : multiReq.getParameter("pimage2"));
} catch (IOException e) {
	
}
	//String fileName = multiReq.getOriginalFileName("pimage");
pageContext.setAttribute("pvo", p);
%>
<sql:setDataSource	var="dataSource"
					driver="oracle.jdbc.OracleDriver"
					url="jdbc:oracle:thin:@localhost:1521:xe"
					user="madang"
					password="1111" />
<sql:update var="rs" dataSource="${ dataSource }">
	UPDATE product SET pid=?, pname=?, price=?, description=?, maker=?, 
					category=?, stock=?, condition=?, pimage=? 
				WHERE pid=?
	<sql:param value="${ pvo.pid }"/>
	<sql:param value="${ pvo.pname }"/>
	<sql:param value="${ pvo.price }"/>
	<sql:param value="${ pvo.description }"/>
	<sql:param value="${ pvo.maker }"/>
	<sql:param value="${ pvo.category }"/>
	<sql:param value="${ pvo.stock }"/>
	<sql:param value="${ pvo.condition }"/>
	<sql:param value="${ pvo.pimage }"/>
	<sql:param value="${ pid_old }"/>
</sql:update>

<c:choose>
	<c:when test="${ rs == 0 }">
		<c:redirect url="productEdit.jsp?edit=modify&msg=modFail"/>
	</c:when>
	<c:otherwise>
		<c:redirect url="productEdit.jsp?edit=modify&msg=modSuccess"/>
	</c:otherwise>
</c:choose>
<%-- <c:redirect url="productEdit.jsp?edit=modify&msg=modSuccess"/> --%>


<%-- <jsp:useBean id="pdao" class="market.dao.ProductDAO"/> --%>
<%-- <%
	if(pdao.insert(p)) { 
		response.sendRedirect("productList.jsp");
	} else {
%>
	<script>
		alert("이미 존재하는 상품코드입니다."); // unique constraint 위반인 경우
		history.back();
	</script>
<%
	}
%> --%>