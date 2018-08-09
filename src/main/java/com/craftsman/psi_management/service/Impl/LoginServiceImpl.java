package com.craftsman.psi_management.service.Impl;

import com.craftsman.psi_management.dao.UserDao;
import com.craftsman.psi_management.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yongdunyang on 30/4/18.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    /**
     * Created by craftsman on 30/4/18.
     * 用户判断 服务接口实现
     *
     */
    public boolean isUser(String userId, String passWord){
        return userDao.isUser(userId,passWord);
    }
}
