package com.rycode.cottage.mapper;

import com.rycode.cottage.model.AdminInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;;import java.io.Serializable;

/**
* @author ry
* @description 针对表【admin_info】的数据库操作Mapper
* @createDate 2024-08-15 15:39:16
* @Entity com.rycode.cottage.model.AdminInfo
*/
public interface AdminInfoMapper extends BaseMapper<AdminInfo> {

    String searchSalt(String name);

    AdminInfo selectByName(String name);

}
