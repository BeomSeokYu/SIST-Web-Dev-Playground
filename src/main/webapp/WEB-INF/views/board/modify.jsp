<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp"/>
<body>
<jsp:include page="../include/navBar.jsp"/>
<body>
	<div id="page-wrapper">
	    <div class="row">
	        <div class="col-lg-12">
	            <h1 class="page-header">Board Modify</h1>
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    <!-- /.row -->
	    <div class="row">
	        <div class="col-lg-12">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    Board Modify Page
	                </div>
	                <div class="panel-body">
	                    <div class="row">
	                        <div class="col-lg-12">
	                            <form id="modifyForm" method="post">
	                            	<div class="row">
	                            		<span class="text-left col-lg-6">
	                                     <label>#No</label>
	                            		</span>
	                            		<span class="text-right col-lg-6">
	                            			<label>작성일 :</label>
	                                    	<span><fmt:formatDate value="${ bvo.regDate }" pattern="yyyy.MM.dd (E)"/></span>
	                            		</span>
	                            		<div class="col-lg-12">
	                                    	<input class="form-control" name="bno" value="${ bvo.bno }" readonly>
	                                    </div>
	                                </div>
	                                <div class="row">
	                                	<div class="col-lg-12">
		                                    <label>Title</label>
		                                    <input class="form-control" name="title" value="${ bvo.title }">
	                                    </div>
	                                </div>
	                                <div class="row">
	                                	<div class="col-lg-12">
		                                    <label>Content</label>
		                                    <textarea class="form-control" rows="5" name="content">${ bvo.content }</textarea>
	                                    </div>
	                                </div>
	                                <div class="row">
	                                	<div class="col-lg-12">
		                                    <label>Writer</label>
		                                    <input class="form-control" name="writer" value="${ bvo.writer }" readonly>
	                                    </div>
	                                </div>
	                                <p></p>
	                                <div class="row">
	                                	<div class="col-lg-12">
			                                <button class="btn btn-danger" id="rmBtn" type="button">Remove</button>
			                                <button class="btn btn-info" data-oper="modify" formaction="/board/modify">Modify</button>
											<button class="btn btn-primary" data-oper="list" formaction="/board/list">List</button>
		                                </div>
	                                </div>
	                            </form>
	                        </div>
	                        <!-- /.col-lg-6 (nested) -->
	                    </div>
	                    <!-- /.row (nested) -->
	                </div>
	                <!-- /.panel-body -->
	            </div>
	            <!-- /.panel -->
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    <!-- /.row -->
	</div>
	<!-- /#page-wrapper -->

<jsp:include page="../include/footer.jsp"/>
<script>
	$('#rmBtn').click(function () {
		if(window.confirm('정말로 삭제하시겠습니까?')) {
			$('#modifyForm').attr('action', '/board/remove')
			$('#modifyForm').submit();
		}
	});
</script>
</body>
</html>