package com.xiaojumao.bean;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-14 9:52
 * @Modified By:
 */
public class Role {
    private Integer roleId;
    private String roleName;
    private Integer roleState;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleState() {
        return roleState;
    }

    public void setRoleState(Integer roleState) {
        this.roleState = roleState;
    }

    public Role(){}

    public Role(Integer roleId, String roleName, Integer roleState) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleState = roleState;
    }
}
