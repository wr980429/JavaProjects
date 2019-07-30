package com.shixun.spring.model;

import java.util.Arrays;

/**
 * 业务模型类（也叫模型类）
 * 该类中的各个属性对应了与“用户”相关的所有数据
 */
public class User {

    // 用户名称
    private Long id;

    // 用户名称
    private String username;

    // 登录密码
    private String password;

    // 重复密码
    private String repeatPassword;

    // 电子邮箱
    private String email;

    // 性别
    private String gender;

    // 职业
    private String profession;

    // 爱好
    private String[] hobby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    /**
     * hobby 转换为,分隔的字符串
     * @return 字符串
     */
    public String getHobbyString() {
        if (hobby != null && hobby.length > 0) {
            String hobbyStr = Arrays.toString(hobby);
            return hobbyStr.substring(1, hobbyStr.length() - 1);
        }
        return "";
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", repeatPassword=" + repeatPassword + ", email=" + email + ", gender=" + gender + ", profession=" + profession + ", hobby=" + Arrays.toString(hobby) + "]";
    }
}
