package com.xiaojumao.service;

import com.xiaojumao.bean.Data;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-06-15 18:20
 * @Modified By:
 */
public interface LoginService {
    /**
     * 登录请求
     */
    public Data login(String username, String password);
}
