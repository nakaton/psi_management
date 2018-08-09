package com.craftsman.psi_management.controller;

import com.craftsman.psi_management.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by craftsman on 29/4/18.
 * 登录控制器类
 */
@Controller
@RequestMapping("/psi")
public class HomeController {

    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class.getName());

    @Autowired
    private LoginService loginService;

    /**
     * Created by craftsman on 29/4/18.
     * 检查登录表单（用户存在性check）
     */
    @RequestMapping("/loginCheck")
    @ResponseBody
    public String loginCheck(HttpServletRequest request){
        logger.info("登录check处理");
        String userId = request.getParameter("userId");
        String passWord = request.getParameter("passWord");

        //确认输入用户ID和密码是否正确
        boolean isUser = loginService.isUser(userId, passWord);

        if(isUser){
            return "true";
        }else{
            return "false";
        }

    }

    @RequestMapping("/menu")
    public String index(){
        logger.info("返回一个index画面");
        return "menu";
    }

    @RequestMapping("/customerManage")
    public String customerManage(){
        logger.info("返回一个客户管理画面");
        return "customerManage";
    }

    @RequestMapping("/supplierManage")
    public String supplierManage(){
        logger.info("返回一个供应商管理画面");
        return "supplierManage";
    }

    @RequestMapping("/productManage")
    public String productManage(){
        logger.info("返回一个产品型号管理画面");
        return "productManage";
    }

    @RequestMapping("/loginError")
    public String loginError(){
        logger.info("返回一个loginError画面");
        return "loginError";
    }
}
