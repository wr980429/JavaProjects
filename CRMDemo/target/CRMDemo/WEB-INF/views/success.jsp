<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>用户注册信息</h2>
	<hr>
	<p>
		用户名称：${user.username}
	</p>
	<p>
		登录密码：${user.password}
	</p>
	<p>
		重复密码：${user.repeatPassword}
	</p>
	<p>
		电子邮箱：${user.email}
	</p>
	<p>
		性别：${user.gender}
	</p>
	<p>
		职业：${user.profession}
	</p>
	<p>
		爱好：${user.hobbyString}
	</p>
</body>
</html>