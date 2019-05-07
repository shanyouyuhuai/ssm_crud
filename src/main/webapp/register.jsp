<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 1.要使用Bootstrap的话，必须是html5文档-->
<meta charset="UTF-8">
<!-- 2.移动设备优先 -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- 3.导入核心的CSS文件 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrapValidator.css" />
<!-- 4.需要引入jQuery文件 -->
<script type="text/javascript" src="bootstrap/js/jQuery.js"></script>
<!-- 5.引入Bootstrap的核心JS文件 -->
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrapValidator.js"></script>
<title>用户注册界面</title>

<script type="text/javascript">
$(function(){
	  $(".form-horizontal").bootstrapValidator({
		  
		  feedbackIcons:{
			  
			  valid : "glyphicon glyphicon-ok",
				invalid : "glyphicon glyphicon-remove",
				validating : "glyphicon glyphicon-refresh"
		  },
		  
		  fields:{
			  
			  username:{
				  
				  validators :{
					  
					  notEmpty : {

							message : '用户名不能为空'

						},

						regexp : {

							regexp : /^[A-z0-9_]{3,12}$/,
							message : '用户名必须由3-12个英文字母、数字和下划线组成'

						},
					  
						remote:{
						  message:'该用户已被注册，请重新输入',
						  url:"validate.action",
						
						  type:'post',
						  
						  data:function(validator){
							  
							  return{
								  
								  username:$("input[name=username]").val()
							  }
						  }
					  }
					 
				  }
			  }
		  }
	  });
 });


</script>

</head>
<body background="image/04.jpg">
	<div class="container">

		<h2 align="center">用户注册信息</h2>
		<hr width="1000px">
		<form action="register" class="form-horizontal" method="post">

			<div class="form-group">
				<label for="username" class="col-sm-4 control-label">用户名</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="username"
						name="username">
				</div>
			</div>
			
			<div class="form-group">
				<label for="password" class="col-sm-4 control-label">登录密码</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="password"
						name="password">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="submit" class="btn btn-primary">立即注册</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>