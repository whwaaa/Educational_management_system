package com.xiaojumao.dao.imp;

import com.mysql.cj.PreparedQuery;
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

    @Override
    public Role queryByRoleId(String roleId) {
        String sql = "SELECT * FROM `role` WHERE `roleid`=?";
        List list = new ArrayList();
        list.add(roleId);
        ResultSet resultSet = query(sql, list);
        Role role = new Role();
        try {
            while(resultSet.next()){
                role.setRoleState(resultSet.getInt("rolestate"));
                role.setRoleId(resultSet.getInt("roleid"));
                role.setRoleName(resultSet.getString("rolename"));
            }
            return role;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Integer getIndexTotal() {
        String sql = "SELECT COUNT(*) FROM `role`";
        ResultSet resultSet = query(sql, null);
        Integer number = 0;
        try {
            while(resultSet.next()){
                number = resultSet.getInt(1);
            }
            return number;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }

        return null;
    }

    @Override
    public List<Role> getRoles(Integer start, Integer size) {
        List list = new ArrayList();
        list.add(start);
        list.add(size);
        String sql = "SELECT * FROM `role` LIMIT ?,?";
        ResultSet resultSet = query(sql, list);
        List<Role> roleList = new ArrayList<>();
        try {
            while(resultSet.next()){
                Role role = new Role();
                role.setRoleName(resultSet.getString("rolename"));
                role.setRoleId(resultSet.getInt("roleid"));
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
    public Integer updateByRoleId(Role role) {
        String sql = "UPDATE `role` SET `rolename`=?,rolestate=? WHERE `roleid`=?";
        List list = new ArrayList();
        list.add(role.getRoleName());
        list.add(role.getRoleState());
        list.add(role.getRoleId());
        try {
            int update = update(sql, list);
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Integer deleteByRoleId(Integer roleId) {
        String sql = "DELETE FROM `role` WHERE `roleid`=?";
        List list = new ArrayList();
        list.add(roleId);
        try {
            int update = update(sql, list);
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Integer addRole(Role role) {
        String sql = "INSERT INTO `role`(`rolename`,`rolestate`) VALUES(?,?)";
        List list = new ArrayList();
        list.add(role.getRoleName());
        list.add(role.getRoleState());
        try {
            int update = update(sql, list);
            return update;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        String sql = "SELECT * FROM `role` WHERE `rolename`=?";
        List list = new ArrayList();
        list.add(roleName);
        ResultSet resultSet = query(sql, list);
        Role role = new Role();
        try {
            while(resultSet.next()){
                role.setRoleState(resultSet.getInt("rolestate"));
                role.setRoleName(resultSet.getString("rolename"));
                role.setRoleId(resultSet.getInt("roleid"));
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
















