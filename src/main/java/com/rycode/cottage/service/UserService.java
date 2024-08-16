package com.rycode.cottage.service;

import com.rycode.cottage.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ry
* @description 针对表【user】的数据库操作Service
* @createDate 2024-08-16 14:29:56
*/
public interface UserService extends IService<User> {

    Object login(String name, String password);

    Object register(String name, String password);
}
