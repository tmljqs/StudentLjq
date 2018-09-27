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
			  <a class="navbar-brand" href="#">学生表</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
	    <form  class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="search" id="name" name="name" placeholder="请输入姓名" aria-label="Search">
	      <input class="form-control mr-sm-2" type="search" id="sex" name="sex" placeholder="请输入性别" aria-label="Search">
	      <input class="form-control mr-sm-2" type="search" id="age" name="age" placeholder="请输入年龄" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" onclick="inserte()">提交</button>
	    </form>
		</nav>
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
					<tbody id="student"></tbody>
				</table>
			</div>
		</div>
	</div>
</body>
	<script type="text/javascript" src="bootstrap4/js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
	$(function(){
		selectStudent();
	})
		function inserte(){
			var name = $("#name").val();
			var sex = $("#sex").val();
			var age = $("#age").val();
			$.ajax({
				url:'ajaxinsert.do',
				type:'post',
				data:{ name:name,
					sex:sex,
					age:age
				},
				dataType:'text',
				success:function(result){
					if(result == "SUCCESS"){
						selectStudent();
					}
				},
				error:function(){
					alert("提交失败");
				}
			})
		}
	function selectStudent(){
				var name = $("#name").val();
				var sex = $("#sex").val();
				var age = $("#age").val();
				$.ajax({
					url:'ajaxselect.do',
					data:{ name:name,
						sex:sex,
						age:age
					},type:'post',
					dataType:'text',
					success:function(res){
						var json = eval("(" + res + ")");//执行输入的代码并返回执行结果，把返回的Json字符串转化为货真价实的Json对象
						for (var i = 0; i < json.length; i++) {//对于Json数组遍历并在页面上添加元素
							$("#student").append("<tr><td>"+json[i].studentId+"</td><td>"+json[i].studentName+"</td><td>"+json[i].studentSex+"</td><td>"+json[i].studentAge+"</td></tr>");
						}
					},
					error:function(){
						alert("提交失败");
					}
			})
	}
	</script>
</html>