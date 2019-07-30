package com.shixun.spring.controller;

import com.shixun.spring.model.User;
import com.shixun.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class RegisterController {
    // 实例化 UserService，因为下方会调用它的方法
    UserService userService = new UserService();

    /**
     * 将访问路径定义为默认路径，即 http:/localhost:8080/Register 就可以调用这个方法
     *
     * @return 将请求会转发到 register.jsp 文件，再将该页面的解析结果（也就是注册页面）响应给客户端进行显示
     */
    @RequestMapping("")
    public String index() {

        return "register";

    }

    /**
     * 访问 http:/localhost:8080/Register/save 就可以调用这个方法，需要跟注册表单的提交地址一致
     *
     * @param user
     *            表单中参数名如果能依次跟 User 对象的属性名一致，则会自动将全部数据封装到一个 User 对象中
     * @param model
     *            表示请求过程中的模型数据，功能跟 request 类似，更好用
     * @return 注册成功则请求转发到 success.jsp，否则到 fail.jsp
     */
    @RequestMapping("save")
    public String saveUser(User user, Model model) {
        try {
            // 调用 userService 的 saveUser 方法保存新的用户数据，实现注册
            boolean result = userService.saveUser(user);
            // 判断是否注册成功
            if (result) {
                // 将请求转发到 success.jsp，并且结束当前方法的调用，后面的代码不会被执行了
                return "success";
            }
        } catch (SQLException e) {
            // 当代码进入到这个区域时，表示抛出了 SQLException 异常，也就是 SQL 语句执行错误
            e.printStackTrace();
            // 将错误信息放入到 model 中去，就类似于放入了 request 中，可以让转发之后的 jsp 文件读取并显示
            model.addAttribute("error", "SQL语句拼写错误");
        }
        // 如果代码运行到这个地方，说明注册失败，在 model 中加入一个键值对数据，用来告诉用户他注册失败了
        model.addAttribute("msg", "注册失败，可能因为用户名已存在");
        // 将请求转发到 fail.jsp
        return "fail";

    }
}
