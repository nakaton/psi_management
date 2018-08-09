package com.craftsman.psi_management.dao.Impl;

import com.craftsman.psi_management.dao.UserDao;
import com.craftsman.psi_management.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by craftsman on 30/4/18.
 * 用户Dao接口实现
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private DataSource dataSource;

//    public void setDataSource(){
//        this.dataSource = dataSource;
//    }

    /**
     * Created by craftsman on 30/4/18.
     * 获取用户信息 DAO接口实现
     * 参数【用户ID】:userId
     */
    public UserPojo findByUserId(String userId){

        String sql = "SELECT * FROM USER WHERE USER_ID = ?";

        Connection conn = null;

        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            UserPojo userPojo = null;
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                userPojo = new UserPojo(
                        rs.getString("userId"),
                        rs.getString("userName"),
                        rs.getString("passWord"),
                        rs.getString("userGroupCd")
                );
            }
            rs.close();
            ps.close();
            return userPojo;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            if(conn != null){
                try {
                    conn.close();
                }catch (SQLException e){

                }
            }
        }
    }

    /**
     * Created by craftsman on 30/4/18.
     * 用户判断 DAO接口实现
     * 参数【用户ID】:userId
     * 参数【密码】:passWord
     */
    public boolean isUser(String userId, String passWord){

        String sql = "SELECT count(*) FROM USER WHERE USER_ID = ? AND PASSWORD = ? ";

        Connection conn = null;

        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, passWord);
            int count = 0;
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
            rs.close();
            ps.close();

            if(count != 0) {
                return true;
            }else {
                return false;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            if(conn != null){
                try {
                    conn.close();
                }catch (SQLException e){

                }
            }
        }
    }
}
