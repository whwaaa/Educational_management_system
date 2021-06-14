package com.xiaojumao.dao;

import com.xiaojumao.bean.Users;

import java.util.List;


/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public interface UsersDao {
    /**
     * 验证数据库账号密码是否正确
     */
    public Users loginVerfi(String username, String password);

    /**
     * 数据库查询所有用户数据
     */
    public List<Users> getUser(Integer start, Integer size);

    /**
     * 获取总页数
     */
    public Integer getIndexTotal();

    /**
     * 数据库查询某个用户数据
     */
    public Users getUser(Integer userId);

    /**
     * 查询用户名是否重复
     */
    public Integer queryLoginName(String loginName);

    /**
     * 查询邮件是否重复
     */
    public Integer queryEmail(String email);

    /**
     * 查询电话是否重复
     */
    public Integer queryPhone(String phone);

    /**
     * 查询身份证是否重复
     */
    public Integer queryCardId(String cardId);

    /**
     * 更新users数据
     */
    public Integer updateUsers(Users users);

    /**
     * 删除数据
     */
    public Integer delete(Integer userIds);

    /**
     * 添加数据
     */
    public Integer add(Users users);
}

















