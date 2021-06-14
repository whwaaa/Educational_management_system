package com.xiaojumao.bean;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:49
 * @Modified By:
 */
public class Users {
    private Integer userId;
    private String password;
    private String realName;
    private String loginName;
    private Integer sex;
    private String email;
    private String address;
    private String phone;
    private String cardId;
    private String desc;
    private Integer roleId;

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Users(){}

    public Users(Integer userId, String password, String realName, String loginName, Integer sex, String email, String address, String phone, String cardId, String desc, Integer roleId, String roleName) {
        this.userId = userId;
        this.password = password;
        this.realName = realName;
        this.loginName = loginName;
        this.sex = sex;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.cardId = cardId;
        this.desc = desc;
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
