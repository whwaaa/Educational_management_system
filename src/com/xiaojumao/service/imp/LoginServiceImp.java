package com.xiaojumao.service.imp;

import com.xiaojumao.bean.Data;
import com.xiaojumao.bean.Menu;
import com.xiaojumao.bean.MySession;
import com.xiaojumao.bean.Users;
import com.xiaojumao.dao.imp.MenuDaoImp;
import com.xiaojumao.service.LoginService;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-15 18:20
 * @Modified By:
 */
public class LoginServiceImp implements LoginService {
    @Override
    public Data login(String username, String password) {
        Data data = new Data();
        // 登陆验证
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        Users users = usersServiceImp.loginVerfi(username, password);
        MySession mySession = new MySession();
        data.setMySession(mySession);
        if(users != null) {
            // 验证成功
            mySession.setLogin(true);
            mySession.setUser(users);
            // 通过roleId查询menu权限表
            MenuDaoImp menuDaoImp = new MenuDaoImp();
            Integer roleId = users.getRoleId();
            List<Menu> menuList = menuDaoImp.getMenusByRoleId(roleId);
            mySession.setMenuList(menuList);
        }
        return data;
    }
}
