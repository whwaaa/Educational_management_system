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

    /**
     * roleId查询信息
     */
    public Role queryByRoleId(String roleId);

    /**
     * 获取role总条数
     */
    public Integer getIndexTotal();

    /**
     * 分页查询role
     */
    public List<Role> getRoles(Integer start, Integer size);

    /**
     * 更新role通过roleId
     */
    public Integer updateByRoleId(Role role);

    /**
     * 通过roleId删除role
     */
    public Integer deleteByRoleId(Integer roleId);

    /**
     * 新增role
     */
    public Integer addRole(Role role);

    /**
     * 通过RoleNmae查询role
     */
    public Role getRoleByRoleName(String roleName);

    /**
     *  通过RoleId修改role_State
     */
    public Integer updateStateByRoleId(Integer roleState, Integer roleId);
}




