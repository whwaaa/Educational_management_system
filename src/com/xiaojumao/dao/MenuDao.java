package com.xiaojumao.dao;

import com.xiaojumao.bean.Menu;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-15 9:15
 * @Modified By:
 */
public interface MenuDao {
    /**
     * Menus全查
     */
    public List<Menu> getMenus();

    /**
     * Menus分页查
     */
    public List<Menu> getMenus(Integer start, Integer size);

    /**
     * 多表联查ByRoleId
     */
    public List<Menu> getMenusByRoleId(Integer roleId);

    /**
     * ByroleId删除Middle
     */
    public Integer deleteByRoleId(Integer roleId);

    /**
     * ByroleId新增Middle
     */
    public Integer add(Integer roleId, Integer menuId);

    /**
     * 获取menu所有条数
     */
    public Integer getAllTotal();

    /**
     * 查询一级menu
     */
    public List<Menu> getMenusPre();

    /**
     * menuId查询menu
     */
    public Menu getMenuByMenuId(Integer menuId);

    /**
     * 通过MenuId修改menu
     */
    public Integer updateByMenuId(Menu menu);

    /**
     * 新增数据
     */
    public Integer addMenu(Menu menu);

    /**
     * 通过menuId删除menu
     */
    public Integer deleteByMenuId(Integer menuId);

    /**
     * 通过MenuId修改menu_State
     */
    public Integer updateStateByMenuId(Integer state, Integer menuId);

}















