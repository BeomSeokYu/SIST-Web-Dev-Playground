<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/header.jsp"/>
<title>list.jsp</title>
</head>
<body>
<jsp:include page="../include/navBar.jsp"/>
	<div class="wrapper">
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board List Page</h1>
                </div>
            </div>
			<div class="row">
		        <div class="col-lg-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    Board List
		                    <button class="btn btn-xs pull-right btn-info" type="button" id="regBtn">register new board</button>
		                </div>
		                <div class="panel-body">
							<table class="table table-striped table-bordered table-hover">
							    <thead>
							        <tr>
							            <th>no.</th>
							            <th>제목</th>
							            <th>내용</th>
							            <th>작성자</th>
							            <th>작성일</th>
							        </tr>
							    </thead>
							    <tbody>
								<c:forEach items="${ list }" var="bvo">
									<tr>
							            <td>${ bvo.bno }</td>
							            <td>${ bvo.title }</td>
							            <td>${ bvo.content }</td>
							            <td>${ bvo.writer }</td>
							            <td><fmt:formatDate type="date" value="${ bvo.regDate }"/></td>
							        </tr>
								</c:forEach>
						        </tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="../include/footer.jsp"/>
</body>
</html>