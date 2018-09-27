<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bootstrap4/css/bootstrap.min.css" rel="stylesheet">
<link href="font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
<title>学生信息表</title>
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="select.do">学生表</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
	 
	    <form action="inserte.do" method="post" class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="search" name="name" placeholder="请输入姓名" aria-label="Search">
	      <input class="form-control mr-sm-2" type="search" name="sex" placeholder="请输入性别" aria-label="Search">
	      <input class="form-control mr-sm-2" type="search" name="age" placeholder="请输入年龄" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">提交</button>
	    </form>
		</nav>
		<c:if test="${result == 'SUCCESS' }">
			<div class="alert alert-success" role="alert">提示：操作成功</div>
		</c:if>
		<c:if test="${result == 'ERROR' }">
			<div class="alert alert-danger" role="alert">警告：操作失败</div>
		</c:if>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>SEX</th>
							<th>AGE</th>
							<th>操作</th>
						</tr>
					</thead>
					<c:forEach items="${result }" var="rs">
					<tbody>
						<tr>
							<td>${rs.studentId }</td>
							<td>${rs.studentName }</td>
							<td>${rs.studentSex }</td>
							<td>${rs.studentAge }</td>
							<td><a href="removeStudent.do?studentId=${rs.studentId }"><i class="fa fa-times"></i>删除</a></td>
						</tr>
					</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="bootstrap4/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="bootstrap4/js/bootstrap.min.js"></script>
</html>