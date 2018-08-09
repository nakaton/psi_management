package com.craftsman.psi_management.service;

import org.springframework.stereotype.Service;

/**
 * Created by craftsman on 30/4/18.
 */
@Service
public interface LoginService {

    /**
     * Created by craftsman on 30/4/18.
     * 用户判断 服务接口
     *
     */
    public boolean isUser(String userId, String passWord);
}
