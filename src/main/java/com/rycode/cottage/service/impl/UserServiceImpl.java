package com.rycode.cottage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rycode.cottage.model.User;
import com.rycode.cottage.service.UserService;
import com.rycode.cottage.mapper.UserMapper;
import com.rycode.cottage.utils.MD5Util;
import com.rycode.cottage.utils.StrUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ry
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-08-16 14:29:56
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 用户登陆
     *
     * @param name     用户名
     * @param password 明文密码
     * @return Obj
     */
    @Override
    public Object login(String name, String password) {
        // 根据用户名获取salt
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        try {
            String salt = userMapper.selectByMap(map).get(0).getSalt();
            String passwordHash = MD5Util.encrypt(password + salt);
            map.put("password", passwordHash);
            try {
                List<User> users = userMapper.selectByMap(map);
                return users.get(0);
            } catch (Exception e) {
                log.error("****************************************\n" +
                        "[ERROR] please check your password\n" +
                        "***********************************");
                return "密码错误";
            }
        } catch (Exception e) {
            log.error("****************************************\n" +
                    "[ERROR] please check your username\n" +
                    "***********************************");
            return "用户名不存在";
        }
    }

    /**
     * 用户注册
     * 判定用户名是否存在 => 不存在则注册
     *
     * @param name     用户名
     * @param password 明文密码
     * @return Obj
     */
    @SneakyThrows
    @Override
    public Object register(String name, String password) {
        // 验证用户名是否已存在
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        List<User> users = userMapper.selectByMap(map);
        if (users.isEmpty()) {
            // 生成salt
            String salt = StrUtil.getComplexRandomString(10);
            String passwordHash = MD5Util.encrypt(password + salt);
            // 不存在则注册
            User user = new User();
            user.setName(name);
            user.setPassword(passwordHash);
            user.setSalt(salt);
            user.setCreatedAt(new Date());
            // 考虑到用户信息被软删除的情况
            try {
                userMapper.insert(user);
            } catch (Exception e) {
                // todo 软删除的用户信息被重新注册
                userMapper.recovery(name);
                return "用户信息已恢复";
            }
            return user;
        } else {
            return "用户名已存在";
        }
    }
}




