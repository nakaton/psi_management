package com.craftsman.psi_management.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by craftsman on 30/4/18.
 * 用户实体类
 */
public class UserPojo implements Serializable{

    private int id;
    private String userId;
    private String userName;
    private String passWord;
    private String userGroupCd;
    private Date updDate;
    private String updPerson;
    private Date registDate;
    private String registPerson;
    private String comment;

    public UserPojo(){

    }

    public UserPojo(String userId, String userName, String passWord, String userGroupCd){
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.userGroupCd = userGroupCd;
    }

    public UserPojo(int id, String userId, String userName, String passWord, String userGroupCd, Date updDate, String updPerson, Date registDate, String registPerson, String comment){
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.userGroupCd = userGroupCd;
        this.updDate = updDate;
        this.updPerson = updPerson;
        this.registDate = registDate;
        this.registPerson = registPerson;
        this.comment = comment;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public String getPassWord(){
        return passWord;
    }

    public void setUserGroupCd(String userGroupCd){
        this.userGroupCd = userGroupCd;
    }

    public String getUserGroupCd(){
        return userGroupCd;
    }

    public void setUpdDate(Date updDate){
        this.updDate = updDate;
    }

    public Date getUpdDate(){
        return updDate;
    }

    public void setUpdPerson(String updPerson){
        this.updPerson = updPerson;
    }

    public String getUpdPerson(){
        return updPerson;
    }

    public void setRegistDate(Date registDate){
        this.registDate = registDate;
    }

    public Date getRegistDate(){
        return registDate;
    }

    public void setRegistPerson(String registPerson){
        this.registPerson = registPerson;
    }

    public String getRegistPerson(){
        return registPerson;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public String getComment(){
        return comment;
    }

    @Override
    public String toString(){
        return "UserPojo [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", userGroupCd=" + userGroupCd +"]";
    }

}
