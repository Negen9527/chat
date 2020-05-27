package com.negen.service;

import com.negen.common.ServerResponse;
import com.negen.entity.User;

public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    ServerResponse userRegister(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    ServerResponse userLogin(User user);
}
