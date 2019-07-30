<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>实训在线-注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keywords" content="实训,教育,IT">
    <meta name="description" content="实训在线用户注册案例">
    <meta name="author" content="实训在线">
    <!-- 引入自定义CSS样式 -->
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<div class="register-container">
    <header>
        <h1>用户注册</h1>
    </header>
    <!-- 用户注册表单 -->
    <form name="registerForm" action="save" onsubmit="return verifyRegisterBeforeSave()" method="post">
        <div class="input-group ">
            <label class="input-label">用户名称：</label> <input id="username" name="username" type="text" class="input" placeholder="请输入您的用户名！">
        </div>
        <div class="input-group ">
            <label class="input-label">登录密码：</label> <input id="password" name="password" type="password" class="input" placeholder="请输入您的密码！">
        </div>
        <div class="input-group ">
            <label class="input-label">重复密码：</label> <input id="repeatPassword" name="repeatPassword" type="password" class="input" placeholder="请输入您的确认密码！">
        </div>
        <div class="input-group ">
            <label class="input-label">电子邮箱：</label> <input id="email" name="email" type="email" class="input" placeholder="请输入您的邮箱！">
        </div>
        <div class="input-group">
            <label class="radio-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
            <div class="radio-group">
                <input type="radio" name="gender" id="male" value="男" checked="checked" required><label for="male">男</label> <input type="radio" name="gender" id="female" value="女" required><label for="female">女</label>
            </div>
        </div>
        <div class="input-group clr">
            <label class="">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</label>
            <select class="select" name="profession">
                <option value="student">学生</option>
                <option value="teacher">老师</option>
                <option value="coder">程序猿</option>
                <option value="engineer">攻城狮</option>
                <option value="ui">UI设计</option>
            </select>
        </div>
        <div class="input-group">
            <label class="input-label">爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好：</label>
            <!-- 多选框（按住 Shift 键） -->
            <select class="multiple-select" name="hobby" multiple="multiple" size="4">
                <option value="书法">书法</option>
                <option value="乐器">乐器</option>
                <option value="运动">运动</option>
                <option value="编程">编程</option>
            </select>
        </div>
        <br>
        <hr>
        <div class="register-control">
            <button type="submit">注册</button>
            <button type="reset">重置</button>
        </div>
    </form>
    <footer id="footer"> Copyright © 2018.实训在线版权所有 </footer>
</div>
<!-- 引入自定义 js 脚本 -->
<script type="text/javascript" src="js/register.js"></script>
</body>
</html>