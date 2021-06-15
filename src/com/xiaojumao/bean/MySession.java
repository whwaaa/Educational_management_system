package com.xiaojumao.bean;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-15 18:18
 * @Modified By:
 */
public class MySession {
    private boolean login;      // 登录状态
    private Users user;
    private List<Menu> menuList;    // 权限表

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public MySession() {
    }

    public MySession(boolean login, Users user, List<Menu> menuList) {
        this.login = login;
        this.user = user;
        this.menuList = menuList;
    }
}
