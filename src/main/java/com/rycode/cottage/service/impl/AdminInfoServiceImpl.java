package com.rycode.cottage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;;
import com.rycode.cottage.model.AdminInfo;
import com.rycode.cottage.service.AdminInfoService;
import com.rycode.cottage.mapper.AdminInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ry
 * @description 针对表【admin_info】的数据库操作Service实现
 * @createDate 2024-08-15 15:39:16
 */
@Service
public class AdminInfoServiceImpl extends ServiceImpl<AdminInfoMapper, AdminInfo> implements AdminInfoService {

    @Autowired
    AdminInfoMapper adminInfoMapper;

    public List<AdminInfo> getAdminInfoList(Map<String,Object> map) {
        return adminInfoMapper.selectByMap(map);
    }

    @Override
    public String getSalt(String name) {
        return adminInfoMapper.searchSalt(name);
    }
}
