package com.craftsman.psi_management.dao;

import com.craftsman.psi_management.pojo.UserPojo;
import org.springframework.stereotype.Repository;

/**
 * Created by craftsman on 30/4/18.
 */
@Repository
public interface UserDao {

    /**
     * Created by craftsman on 30/4/18.
     * 用户判断 DAO接口
     * 参数【用户ID】:userId
     * 参数【密码】:passWord
     */
    public boolean isUser(String userId, String passWord);

    /**
     * Created by craftsman on 30/4/18.
     * 获取用户信息 DAO接口
     * 参数【用户ID】:userId
     */
    public UserPojo findByUserId(String userId);
}
