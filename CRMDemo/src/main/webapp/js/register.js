//验证用户注册数据有效性
function verifyRegisterBeforeSave() {
    // 利用 document.getElementById 获取 html 中的注册输入数据
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var repeatPassword = document.getElementById("repeatPassword").value;
    var email = document.getElementById("email").value;

    // 验证注册信息有效性
    if (username == "") {
        alert("用户不允许为空！");
        return false;
    } else if (password == "") {
        alert("密码不允许为空！");
        return false;
    } else if (repeatPassword == "") {
        alert("重复密码不允许为空！");
        return false;
    } else if (email == "") {
        alert("电子邮件不允许为空！");
        return false;
    } else if (username.length < 6 || username.length > 20) {
        alert("用户名长度应在6到20个字符之间！");
        return false;
    } else if (username == password || username == repeatPassword) {
        alert("密码或重复密码不能和用户名相同！");
        return false;
    } else if (password.length < 6 || password.length > 20 || repeatPassword.length < 6 || repeatPassword.length > 20) {
        alert("密码或重复密码长度应在6到20个字符之间！");
        return false;
    } else if (password != repeatPassword) {
        alert("密码和重复密码不同，请重新输入！");
        return false;
    } else {
        return true;
    }
}
