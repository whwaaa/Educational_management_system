package com.xiaojumao.dao.imp;

import com.xiaojumao.bean.Users;
import com.xiaojumao.dao.DBUtils;
import com.xiaojumao.dao.UsersDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public class UsersDaoImp extends DBUtils implements UsersDao {
    public static final List list = new ArrayList();

    @Override
    public Users loginVerfi(String username, String password) {
        ArrayList<String> list = new ArrayList<>();
        list.add(username);
        list.add(password);
        String sql = "select * from users where loginname=? and password=?";
        ResultSet resultSet = query(sql, list);
        Users users = null;
        if (resultSet != null) {
            try {
                while(resultSet.next()){
                    users = new Users();
                    users.setAddress(resultSet.getString("address"));
                    users.setSex(resultSet.getInt("sex"));
                    users.setUserId(resultSet.getInt("userid"));
                    users.setEmail(resultSet.getString("email"));
                    users.setPassword(resultSet.getString("password"));
                    users.setPhone(resultSet.getString("phone"));
                    users.setRealName(resultSet.getString("realname"));
                    users.setCardId(resultSet.getString("cardid"));
                    users.setLoginName(resultSet.getString("loginname"));
                    users.setRoleId(resultSet.getInt("roleid"));
                    users.setDesc(resultSet.getString("desc"));
                }
                return users;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeAll();
            }
        }
        return null;
    }

    @Override
    public List<Users> getUser(Integer start, Integer size) {
        String sql = "SELECT * FROM `users` AS `u` ,`role` AS `r` WHERE `u`.`roleid`=`r`.`roleid`  LIMIT ?,?";
        List list = new ArrayList();
        list.add(start);
        list.add(size);
        ResultSet resultSet = query(sql, list);
        List<Users> usersList = new ArrayList<>();
        if(resultSet != null){
            try {
                while(resultSet.next()){
                    Users users = new Users();
                    users.setAddress(resultSet.getString("address"));
                    users.setSex(resultSet.getInt("sex"));
                    users.setUserId(resultSet.getInt("userid"));
                    users.setEmail(resultSet.getString("email"));
                    users.setPassword(resultSet.getString("password"));
                    users.setPhone(resultSet.getString("phone"));
                    users.setRealName(resultSet.getString("realname"));
                    users.setCardId(resultSet.getString("cardid"));
                    users.setLoginName(resultSet.getString("loginname"));
                    users.setRoleId(resultSet.getInt("roleid"));
                    users.setDesc(resultSet.getString("desc"));
                    users.setRoleName(resultSet.getString("rolename"));
                    usersList.add(users);
                }
                return usersList;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeAll();
            }
        }

        return null;
    }

    @Override
    public Integer getIndexTotal() {
        String sql = "SELECT COUNT(*) FROM `users` where 1=1";
        ResultSet resultSet = query(sql, null);
        Integer pagesize = 0;
        try {
            while(resultSet.next()){
                pagesize = resultSet.getInt(1);
            }
            return pagesize;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Users getUser(Integer userId) {
        List list = new ArrayList();
        list.add(userId);
        String sql = "SELECT * FROM `users` AS `u` ,`role` AS `r` WHERE `u`.`roleid`=`r`.`roleid` AND `u`.`userid`=?";
        ResultSet resultSet = query(sql, list);
        Users users = new Users();
        try {
            while(resultSet.next()){
                users.setAddress(resultSet.getString("address"));
                users.setSex(resultSet.getInt("sex"));
                users.setUserId(resultSet.getInt("userid"));
                users.setEmail(resultSet.getString("email"));
                users.setPassword(resultSet.getString("password"));
                users.setPhone(resultSet.getString("phone"));
                users.setRealName(resultSet.getString("realname"));
                users.setCardId(resultSet.getString("cardid"));
                users.setLoginName(resultSet.getString("loginname"));
                users.setRoleId(resultSet.getInt("roleid"));
                users.setDesc(resultSet.getString("desc"));
                users.setRoleName(resultSet.getString("rolename"));
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }

        return null;
    }

    @Override
    public Integer queryLoginName(String loginName) {
        List list = new ArrayList();
        list.add(loginName);
        String sql = "SELECT * FROM `users` WHERE `loginname`=?";
        ResultSet resultSet = query(sql, list);
        try {
            if(resultSet.next()){
                return 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Integer queryEmail(String email) {
        List list = new ArrayList();
        list.add(email);
        String sql = "SELECT * FROM `users` WHERE `email`=?";
        ResultSet resultSet = query(sql, list);
        try {
            if(resultSet.next()){
                return 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Integer queryPhone(String phone) {
        List list = new ArrayList();
        list.add(phone);
        String sql = "SELECT * FROM `users` WHERE `phone`=?";
        ResultSet resultSet = query(sql, list);
        try {
            if(resultSet.next()){
                return 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Integer queryCardId(String cardId) {
        List list = new ArrayList();
        list.add(cardId);
        String sql = "SELECT * FROM `users` WHERE `cardid`=?";
        ResultSet resultSet = query(sql, list);
        try {
            if(resultSet.next()){
                return 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Integer updateUsers(Users users) {
        String sql = "UPDATE `users` SET `loginname`=?,`password`=?," +
                "`realname`=?,`sex`=?,`email`=?,`address`=?,`phone`=?," +
                "`cardid`=?,`desc`=?,`roleid`=? WHERE `userid`=?";
        List list = new ArrayList();
        list.add(users.getLoginName());
        list.add(users.getPassword());
        list.add(users.getRealName());
        list.add(users.getSex());
        list.add(users.getEmail());
        list.add(users.getAddress());
        list.add(users.getPhone());
        list.add(users.getCardId());
        list.add(users.getDesc());
        list.add(users.getRoleId());
        list.add(users.getUserId());
        int update = 0;
        try {
            update = update(sql, list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return update;
    }

    @Override
    public Integer delete(Integer userIds) {
        String sql = "DELETE FROM `users` WHERE `userid`=?";
        List list = new ArrayList();
        list.add(userIds);
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
    public Integer add(Users users) {
        String sql = "INSERT INTO `users`(`loginname`,`password`,`realname`,`sex`,`email`,`address`," +
                "`phone`,`cardid`,`desc`,`roleid`) VALUES(?,?,?,?,?,?,?,?,?,?)";
        List list = new ArrayList();
        list.add(users.getLoginName());
        list.add(users.getPassword());
        list.add(users.getRealName());
        list.add(users.getSex());
        list.add(users.getEmail());
        list.add(users.getAddress());
        list.add(users.getPhone());
        list.add(users.getCardId());
        list.add(users.getDesc());
        list.add(users.getRoleId());
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
}
