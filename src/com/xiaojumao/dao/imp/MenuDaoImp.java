package com.xiaojumao.dao.imp;

import com.xiaojumao.bean.Menu;
import com.xiaojumao.dao.DBUtils;
import com.xiaojumao.dao.MenuDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-15 9:17
 * @Modified By:
 */
public class MenuDaoImp extends DBUtils implements MenuDao{

    @Override
    public List<Menu> getMenus() {
        String sql = "SELECT * FROM `menu`";
        ResultSet resultSet = query(sql, null);
        List<Menu> menuList = new ArrayList<>();
        try {
            while(resultSet.next()){
                Menu menu = new Menu();
                menu.setUrl(resultSet.getString("url"));
                menu.setMenuId(resultSet.getInt("menuid"));
                menu.setMenuName(resultSet.getString("menuname"));
                menu.setState(resultSet.getInt("state"));
                menu.setUpMenuId(resultSet.getInt("upmenuid"));
                menu.setDesc(resultSet.getString("desc"));
                menuList.add(menu);
            }
            return menuList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public List<Menu> getMenus(Integer start, Integer size) {
        String sql = "SELECT * FROM `menu` LIMIT ?,?";
        List list = new ArrayList();
        list.add(start);
        list.add(size);
        ResultSet resultSet = query(sql, list);
        List<Menu> menuList = new ArrayList<>();
        try {
            while(resultSet.next()){
                Menu menu = new Menu();
                menu.setUrl(resultSet.getString("url"));
                menu.setMenuId(resultSet.getInt("menuid"));
                menu.setMenuName(resultSet.getString("menuname"));
                menu.setState(resultSet.getInt("state"));
                menu.setUpMenuId(resultSet.getInt("upmenuid"));
                menu.setDesc(resultSet.getString("desc"));
                menuList.add(menu);
            }
            return menuList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public List<Menu> getMenusByRoleId(Integer roleId) {
        String sql = "SELECT * FROM `menu`,`middle` WHERE `middle`.`roleid`=? AND `middle`.`menuid`=`menu`.`menuid`";
        List list = new ArrayList();
        list.add(roleId);;
        ResultSet resultSet = query(sql, list);
        List<Menu> menuList = new ArrayList<>();
        try {
            while (resultSet.next()){
                Menu menu = new Menu();
                menu.setUrl(resultSet.getString("url"));
                menu.setMenuId(resultSet.getInt("menuid"));
                menu.setMenuName(resultSet.getString("menuname"));
                menu.setState(resultSet.getInt("state"));
                menu.setUpMenuId(resultSet.getInt("upmenuid"));
                menu.setDesc(resultSet.getString("desc"));
                menuList.add(menu);
            }
            return menuList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Integer deleteByRoleId(Integer roleId) {
        String sql = "DELETE FROM `middle` WHERE `roleid`=?";
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
    public Integer add(Integer roleId, Integer menuId) {
        String sql = "INSERT INTO `middle`(`roleid`,`menuid`) VALUES(?,?)";
        List list = new ArrayList();
        list.add(roleId);
        list.add(menuId);
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
    public Integer getAllTotal() {
        String sql = "SELECT COUNT(*) FROM `menu`";
        ResultSet resultSet = query(sql, null);
        Integer count = 0;
        try {
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public List<Menu> getMenusPre() {
        String sql = "SELECT * FROM `menu` WHERE `upmenuid`=0";
        ResultSet resultSet = query(sql, null);
        List<Menu> menuList = new ArrayList();
        try {
            while(resultSet.next()){
                Menu menu = new Menu();
                menu.setUrl(resultSet.getString("url"));
                menu.setMenuId(resultSet.getInt("menuid"));
                menu.setMenuName(resultSet.getString("menuname"));
                menu.setState(resultSet.getInt("state"));
                menu.setUpMenuId(resultSet.getInt("upmenuid"));
                menu.setDesc(resultSet.getString("desc"));
                menuList.add(menu);
            }
            return menuList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Menu getMenuByMenuId(Integer menuId) {
        String sql = "SELECT * FROM `menu` WHERE `menuid`=?";
        List list = new ArrayList();
        list.add(menuId);
        ResultSet resultSet = query(sql, list);
        Menu menu = new Menu();
        try {
            while(resultSet.next()){
                menu.setUrl(resultSet.getString("url"));
                menu.setMenuId(resultSet.getInt("menuid"));
                menu.setMenuName(resultSet.getString("menuname"));
                menu.setState(resultSet.getInt("state"));
                menu.setUpMenuId(resultSet.getInt("upmenuid"));
                menu.setDesc(resultSet.getString("desc"));
            }
            return menu;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Integer updateByMenuId(Menu menu) {
        String sql = "UPDATE `menu` SET `menuname`=?,`upmenuid`=?,`state`=?,`desc`=?,`url`=? WHERE `menuid`=?";
        List list = new ArrayList();
        list.add(menu.getMenuName());
        list.add(menu.getUpMenuId());
        list.add(menu.getState());
        list.add(menu.getDesc());
        list.add(menu.getUrl());
        list.add(menu.getMenuId());
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
    public Integer addMenu(Menu menu) {
        String sql = "INSERT INTO `menu`(`menuname`,`upmenuid`,`state`,`desc`,`url`) VALUES(?,?,?,?,?)";
        List list = new ArrayList();
        list.add(menu.getMenuName());
        list.add(menu.getUpMenuId());
        list.add(menu.getState());
        list.add(menu.getDesc());
        list.add(menu.getUrl());
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
    public Integer deleteByMenuId(Integer menuId) {
        String sql = "DELETE FROM `menu` WHERE `menuid`=?";
        List list = new ArrayList();
        list.add(menuId);
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
