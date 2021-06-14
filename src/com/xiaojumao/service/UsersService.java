package com.xiaojumao.service;

import com.xiaojumao.bean.Data;
import com.xiaojumao.bean.Role;
import com.xiaojumao.bean.Users;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public interface UsersService {

    /**
     * 查询数据库用户信息
     */
    public Users loginVerfi(String username, String password);

    /**
     * 数据库查询所有用户数据
     */
    public List<Users> getUser(Integer pageIndex, Integer pageSize);

    /**
     * 返回userlist所有显示信息
     */
    public Data getListData(String pageIndex);

    /**
     * 返回某个用户信息
     */
    public Data getEditorData(String userId, String pageIndex);

    /**
     * 查询用户名是否重复
     */
    public String checkLoginName(String loginName);

    /**
     * 查询邮件是否重复
     */
    public String checkEmail(String email);

    /**
     * 查询电话是否重复
     */
    public String checkPhone(String phone);

    /**
     * 查询身份证是否重复
     */
    public String checkCardId(String cardId);

    /**
     * 保存修改信息
     */
    public void editSave(Users users);

    /**
     * 删除数据
     */
    public void delete(String userIds);

    /**
     * 添加数据
     */
    public Data add();

    /**
     * 保存添加数据
     */
    public Data addSave(Users users);

}
















