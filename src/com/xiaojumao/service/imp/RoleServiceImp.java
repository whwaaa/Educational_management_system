package com.xiaojumao.service.imp;

import com.xiaojumao.bean.Data;
import com.xiaojumao.bean.Menu;
import com.xiaojumao.bean.Role;
import com.xiaojumao.bean.Users;
import com.xiaojumao.dao.MenuDao;
import com.xiaojumao.dao.RoleDao;
import com.xiaojumao.dao.imp.MenuDaoImp;
import com.xiaojumao.dao.imp.RoleDaoImp;
import com.xiaojumao.service.RoleService;
import com.xiaojumao.utils.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-15 8:13
 * @Modified By:
 */
public class RoleServiceImp implements RoleService {
    RoleDao roleImp = new RoleDaoImp();
    @Override
    public Data RoleListData(String pageIndex) {
        PageInfo pageInfo = new PageInfo();
        // 查询总条数
        pageInfo.setIndexTotal(roleImp.getIndexTotal());
        if(pageIndex != null && !pageIndex.equals("")){
            pageInfo.setPageIndex(Integer.parseInt(pageIndex));
        }
        // 分页查询当前页roles信息
        List<Role> roles = roleImp.getRoles((pageInfo.getPageIndex()-1)*pageInfo.getPageSize(), pageInfo.getPageSize());
        // 封装Data
        Data data = new Data();
        data.setRoleList(roles);
        data.setPageInfo(pageInfo);
        return data;
    }

    @Override
    public Data RoleInofData(String roleId, String pageIndex) {
        Role role = null;
        List<Menu> menus;
        MenuDao menuDao = new MenuDaoImp();
        // Menu全查
        List<Menu> allMenus = menuDao.getMenus();
        if(roleId != null && !roleId.equals("")){
            // 查询role信息
            role = roleImp.queryByRoleId(roleId);
            // 多表联查获取Menus
            menus = menuDao.getMenusByRoleId(Integer.parseInt(roleId));
            for (Menu allMenu : allMenus) {
                for (Menu menu : menus) {
                    if(allMenu.getMenuId().equals(menu.getMenuId())){
                        allMenu.setUse(true);
                        break;
                    }
                }
            }
        }
        // 获取pageIndex
        PageInfo pageInfo = new PageInfo();
        if (pageIndex != null && !pageIndex.equals("")) {
            pageInfo.setPageIndex(Integer.parseInt(pageIndex));
        }
        // 封装Data
        Data data = new Data();
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        data.setRoleList(roleList);
        data.setMenuList(allMenus);
        data.setPageInfo(pageInfo);
        return data;
    }

    @Override
    public Data save(String roleId, String menuIds, String roleName, String roleState, String pageIndex) {
        Role role = new Role();
        // 修改
        if (roleId != null && !roleId.equals("")) {
            role.setRoleId(Integer.parseInt(roleId));
            role.setRoleName(roleName);
            role.setRoleState(Integer.parseInt(roleState));
            // 更新role表
            roleImp.updateByRoleId(role);
        }else{ // 新增
            role.setRoleName(roleName);
            role.setRoleState(Integer.parseInt(roleState));
            // 新增role表
            roleImp.addRole(role);
            // 查询role
            role = roleImp.getRoleByRoleName(roleName);
        }
        // 更新middle表
        MenuDao menuDao = new MenuDaoImp();
        // ByroleId删除Middle
        menuDao.deleteByRoleId(role.getRoleId());
        if (menuIds != null && !menuIds.equals("")) {
            String[] menuIdArr = menuIds.split(",");
            // ByroleId新增Middle
            for (String menuId : menuIdArr) {
                menuDao.add(role.getRoleId(), Integer.parseInt(menuId));
            }
        }
        // 查询总条数
        PageInfo pageInfo = new PageInfo();
        pageInfo.setIndexTotal(roleImp.getIndexTotal());
        if(pageIndex!=null && !pageIndex.equals("")){
            pageInfo.setPageIndex(Integer.parseInt(pageIndex));
        }else{
            pageInfo.setPageIndex(pageInfo.getPageTotal());
        }
        Data data = new Data();
        data.setPageInfo(pageInfo);
        return data;
    }

    @Override
    public void deleteByRoleId(String roleId) {
        if (roleId != null && !roleId.equals("")) {
            // 通过roleId删除role
            roleImp.deleteByRoleId(Integer.parseInt(roleId));
        }
    }


}
