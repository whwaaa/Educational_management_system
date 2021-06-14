package com.xiaojumao.service.imp;

import com.xiaojumao.bean.Data;
import com.xiaojumao.bean.Role;
import com.xiaojumao.bean.Users;
import com.xiaojumao.dao.RoleDao;
import com.xiaojumao.dao.imp.RoleDaoImp;
import com.xiaojumao.dao.imp.UsersDaoImp;
import com.xiaojumao.service.UsersService;
import com.xiaojumao.utils.PageInfo;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public class UsersServiceImp implements UsersService {
    UsersDaoImp daoImp = new UsersDaoImp();
    @Override
    public Users loginVerfi(String username, String password) {
        return daoImp.loginVerfi(username, password);
    }

    @Override
    public List<Users> getUser(Integer pageIndex, Integer pageSize) {
        // 分页查询
        List<Users> users = daoImp.getUser((pageIndex-1)*pageSize, pageSize);
        return users;
    }

    @Override
    public Data getListData(String pageIndex) {
        PageInfo pageInfo = new PageInfo();

        // 查询总条数
        pageInfo.setIndexTotal(daoImp.getIndexTotal());

        if(pageIndex != null){
            pageInfo.setPageIndex(Integer.parseInt(pageIndex));
        }

        // 查询当前页user信息
        List<Users> users = getUser(pageInfo.getPageIndex(), pageInfo.getPageSize());

        // 封装到data
        Data data = new Data();
        data.setUsersList(users);
        data.setPageInfo(pageInfo);

        return data;
    }

    @Override
    public Data getEditorData(String userId, String pageIndex) {
        // 查询users
        Users users = new Users();
        if (userId != null) {
            users = daoImp.getUser(Integer.parseInt(userId));
        }
        // 查询所有role信息
        RoleDao roleDao = new RoleDaoImp();
        List<Role> roleList = roleDao.getRoles();
        // 封装data
        Data data = new Data();
        List<Users> userlist = new ArrayList<>();
        userlist.add(users);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageIndex(Integer.parseInt(pageIndex));
        data.setUsersList(userlist);
        data.setRoleList(roleList);
        data.setPageInfo(pageInfo);
        return data;
    }

    @Override
    public String checkLoginName(String loginName) {
        Integer integer = daoImp.queryLoginName(loginName);
        if (integer == null) {
            return "ok";
        }
        return null;
    }

    @Override
    public String checkEmail(String email) {
        Integer integer = daoImp.queryEmail(email);
        if (integer == null) {
            return "ok";
        }
        return null;
    }

    @Override
    public String checkPhone(String phone) {
        Integer integer = daoImp.queryPhone(phone);
        if (integer == null) {
            return "ok";
        }
        return null;
    }

    @Override
    public String checkCardId(String cardId) {
        Integer integer = daoImp.queryCardId(cardId);
        if (integer == null) {
            return "ok";
        }
        return null;
    }


    @Override
    public void editSave(Users users) {
        // 1.根据roleName查询roleId
        RoleDaoImp roleDaoImp = new RoleDaoImp();
        Role role = roleDaoImp.queryByRoleName(users.getRoleName());
        users.setRoleId(role.getRoleId());
        // 2.更新数据
        daoImp.updateUsers(users);
    }

    @Override
    public void delete(String userIds) {
        if (userIds != null) {
            String[] userIdArr = userIds.split(",");
            for (String userId : userIdArr) {
                daoImp.delete(Integer.parseInt(userId));
            }
        }
    }

    @Override
    public Data add() {
        // 查询所有role信息
        RoleDao roleDao = new RoleDaoImp();
        List<Role> roleList = roleDao.getRoles();
        // 封装信息
        Data data = new Data();
        data.setRoleList(roleList);
        return data;
    }

    @Override
    public Data addSave(Users users) {
        // 添加数据
        daoImp.add(users);
        // 查询总条数
        PageInfo pageInfo = new PageInfo();
        pageInfo.setIndexTotal(daoImp.getIndexTotal());
        // 封装信息
        Data data = new Data();
        data.setPageInfo(pageInfo);
        return data;
    }

}
