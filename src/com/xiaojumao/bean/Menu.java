package com.xiaojumao.bean;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-14 9:53
 * @Modified By:
 */
public class Menu {
    private Integer menuId;
    private String menuName;
    private Integer upMenuId;
    private Integer state;
    private String desc;
    private String url;
    private boolean use;
    private String upMenuName;
    private List<Menu> upMenuList;

    public List<Menu> getUpMenuList() {
        return upMenuList;
    }

    public void setUpMenuList(List<Menu> upMenuList) {
        this.upMenuList = upMenuList;
    }

    public String getUpMenuName() {
        return upMenuName;
    }

    public void setUpMenuName(String upMenuName) {
        this.upMenuName = upMenuName;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getUpMenuId() {
        return upMenuId;
    }

    public void setUpMenuId(Integer upMenuId) {
        this.upMenuId = upMenuId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Menu(){}

    public Menu(Integer menuId, String menuName, Integer upMenuId, Integer state, String desc, String url, boolean use, String upMenuName, List<Menu> upMenuList) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.upMenuId = upMenuId;
        this.state = state;
        this.desc = desc;
        this.url = url;
        this.use = use;
        this.upMenuName = upMenuName;
        this.upMenuList = upMenuList;
    }
}
