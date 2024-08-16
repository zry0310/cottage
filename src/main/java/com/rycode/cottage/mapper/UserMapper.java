package com.rycode.cottage.mapper;

import com.rycode.cottage.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author ry
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-08-16 14:29:56
* @Entity com.rycode.cottage.model.User
*/
public interface UserMapper extends BaseMapper<User> {

    Integer recovery(String name);
}




