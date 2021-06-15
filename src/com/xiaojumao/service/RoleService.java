package com.xiaojumao.service;

import com.xiaojumao.bean.Data;
import com.xiaojumao.bean.Role;
import com.xiaojumao.bean.Users;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-15 8:13
 * @Modified By:
 */
public interface RoleService {

    /**
     * 返回显示roleList数据
     */
    public Data RoleListData(String pageIndex);

    /**
     * 获取role详细信息
     */
    public Data RoleInofData(String roleId, String pageIndex);

    /**
     * 保存Role修改信息
     */
    public Data save(String roleId, String menuIds, String roleName, String roleState, String pageIndex);

    /**
     * 删除role
     */
    public void deleteByRoleId(String roleId);

    /**
     *  修改state
     */
    public Data chageState(String pageIndex, String roleState, String roleId);

}
