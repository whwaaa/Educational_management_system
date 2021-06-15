package com.xiaojumao.service.imp;

import com.xiaojumao.bean.Data;
import com.xiaojumao.bean.Menu;
import com.xiaojumao.bean.Role;
import com.xiaojumao.dao.MenuDao;
import com.xiaojumao.dao.imp.MenuDaoImp;
import com.xiaojumao.service.MenuService;
import com.xiaojumao.utils.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-15 14:47
 * @Modified By:
 */
public class MenuServiceImp implements MenuService {

    MenuDao menuDao = new MenuDaoImp();

    @Override
    public Data getMenuListData(String pageIndex) {
        // 获取menu所有条数
        PageInfo pageInfo = new PageInfo();
        pageInfo.setIndexTotal(menuDao.getAllTotal());
        if(pageIndex != null && !pageIndex.equals("")){
            pageInfo.setPageIndex(Integer.parseInt(pageIndex));
        }
        // 分页查询menu
        List<Menu> menus = menuDao.getMenus((pageInfo.getPageIndex()-1)*pageInfo.getPageSize(), pageInfo.getPageSize());
        Data data = new Data();
        data.setMenuList(menus);
        data.setPageInfo(pageInfo);
        return data;
    }

    @Override
    public Data query(String pageIndex, String menuId) {
        // 获取menu所有条数
        PageInfo pageInfo = new PageInfo();
        pageInfo.setIndexTotal(menuDao.getAllTotal());
        if(pageIndex != null && !pageIndex.equals("")){
            pageInfo.setPageIndex(Integer.parseInt(pageIndex));
        }else{
            pageInfo.setPageIndex(pageInfo.getIndexTotal());
        }
        // 查询一级menu
        List<Menu> menuPers = menuDao.getMenusPre();
        // menuId查询menu
        Menu menu = new Menu();
        if (menuId != null && !menuId.equals("")) {
            menu = menuDao.getMenuByMenuId(Integer.parseInt(menuId));
        }
        menu.setUpMenuList(menuPers);
        // 封装data
        List<Menu> menuList = new ArrayList<>();
        menuList.add(menu);
        Data data = new Data();
        data.setMenuList(menuList);
        data.setPageInfo(pageInfo);
        return data;
    }

    @Override
    public Data save(String pageIndex, String menuName, String menuId, String url, String state, String desc, String upMenuId) {
        Menu menu = new Menu();
        menu.setMenuName(menuName);
        menu.setUrl(url);
        if (state != null && !state.equals("")) {
            menu.setState(Integer.parseInt(state));
        }
        menu.setDesc(desc);
        if (upMenuId != null && !upMenuId.equals("")) {
            menu.setUpMenuId(Integer.parseInt(upMenuId));
        }
        // 修改
        if (menuId != null && !menuId.equals("")) {
            menu.setMenuId(Integer.parseInt(menuId));
            // 通过menuId修改menu
            menuDao.updateByMenuId(menu);
        }else{  // 新增
            // 新增menu
            menuDao.addMenu(menu);
        }
        PageInfo pageInfo = new PageInfo();
        pageInfo.setIndexTotal(menuDao.getAllTotal());
        if (pageIndex!=null && !pageIndex.equals("")) {
            pageInfo.setPageIndex(Integer.parseInt(pageIndex));
        }else{
            pageInfo.setPageIndex(pageInfo.getPageTotal());
        }
        Data data = new Data();
        data.setPageInfo(pageInfo);
        return data;
    }

    @Override
    public Data delete(String pageIndex, String menuIds) {
        if (menuIds!=null && !menuIds.equals("")) {
            String[] menuIdarr = menuIds.split(",");
            // 通过MenuId删除menu
            for (String menuId : menuIdarr) {
                menuDao.deleteByMenuId(Integer.parseInt(menuId));
            }
        }
        // 获取menu所有条数
        PageInfo pageInfo = new PageInfo();
        pageInfo.setIndexTotal(menuDao.getAllTotal());
        if(pageIndex != null && !pageIndex.equals("")){
            Integer temp = Integer.parseInt(pageIndex);
            if(temp<=pageInfo.getIndexTotal()){
                pageInfo.setPageIndex(temp);
            }else{
                pageInfo.setPageIndex(pageInfo.getIndexTotal());
            }
        }
        Data data = new Data();
        data.setPageInfo(pageInfo);
        return data;
    }

    @Override
    public Data chageState(String pageIndex, String state, String menuId) {
        PageInfo pageInfo = new PageInfo();
        if(menuId != null && !menuId.equals("")){
            menuDao.updateStateByMenuId(Integer.parseInt(state), Integer.parseInt(menuId));
            pageInfo.setPageIndex(Integer.parseInt(pageIndex));
        }
        Data data = new Data();
        data.setPageInfo(pageInfo);
        return data;
    }
}


















