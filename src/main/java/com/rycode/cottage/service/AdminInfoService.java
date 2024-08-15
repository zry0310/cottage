package com.rycode.cottage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rycode.cottage.model.AdminInfo;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author ry
 * @description 针对表【admin_info】的数据库操作Service
 * @createDate 2024-08-15 15:39:16
 */
public interface AdminInfoService extends IService<AdminInfo> {

    List<AdminInfo> getAdminInfoList(Map<String, Object> map);
    String getSalt(String name);
}
