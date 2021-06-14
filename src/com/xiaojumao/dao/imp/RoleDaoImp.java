package com.xiaojumao.dao.imp;

import com.xiaojumao.bean.Role;
import com.xiaojumao.dao.DBUtils;
import com.xiaojumao.dao.RoleDao;
import com.xiaojumao.dao.UsersDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-14 17:52
 * @Modified By:
 */
public class RoleDaoImp extends DBUtils implements RoleDao{
    @Override
    public List<Role> getRoles() {
        String sql = "SELECT * FROM `role`";
        ResultSet resultSet = query(sql, null);
        List<Role> roleList = new ArrayList<>();
        try {
            while(resultSet.next()){
                Role role = new Role();
                role.setRoleId(resultSet.getInt("roleid"));
                role.setRoleName(resultSet.getString("rolename"));
                role.setRoleState(resultSet.getInt("rolestate"));
                roleList.add(role);
            }
            return roleList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }

        return null;
    }

    @Override
    public Role queryByRoleName(String roleName) {
        List list = new ArrayList();
        list.add(roleName);
        String sql = "SELECT * FROM `role` WHERE `rolename`=?";
        ResultSet resultSet = query(sql, list);
        Role role = new Role();
        try {
            while(resultSet.next()){
                role.setRoleName(resultSet.getString("rolename"));
                role.setRoleId(resultSet.getInt("roleid"));
                role.setRoleState(resultSet.getInt("rolestate"));
            }
            return role;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }

        return null;
    }

}
















