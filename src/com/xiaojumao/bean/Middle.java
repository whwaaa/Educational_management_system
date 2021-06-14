package com.xiaojumao.bean;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-14 9:56
 * @Modified By:
 */
public class Middle {
    private Integer middleId;
    private Integer roleId;
    private Integer menuId;

    public Integer getMiddleId() {
        return middleId;
    }

    public void setMiddleId(Integer middleId) {
        this.middleId = middleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Middle(){}

    public Middle(Integer middleId, Integer roleId, Integer menuId) {
        this.middleId = middleId;
        this.roleId = roleId;
        this.menuId = menuId;
    }
}
