package com.xiaojumao.dao;

import com.xiaojumao.bean.Role;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-14 17:51
 * @Modified By:
 */
public interface RoleDao {
    /**
     * 查询所有role信息
     */
    public List<Role> getRoles();

    /**
     * roleName查询信息
     */
    public Role queryByRoleName(String roleName);
}
