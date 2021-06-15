package com.xiaojumao.service;

import com.xiaojumao.bean.Data;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-15 14:45
 * @Modified By:
 */
public interface MenuService {
    /**
     * 返回List数据
     */
    public Data getMenuListData(String pageIndex);

    /**
     * 查询详细信息
     */
    public Data query(String pageIndex, String menuId);

    /**
     * 保存menu信息
     */
    public Data save(String pageIndex, String menuName, String menuId, String url, String state, String desc, String upMenuId);

    /**
     * 删除数据
     */
    public Data delete(String pageIndex, String menuIds);

    /**
     * 修改state
     */
    public Data chageState(String pageIndex, String state, String menuId);
}
