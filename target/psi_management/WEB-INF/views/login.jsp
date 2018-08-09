<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录画面</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../easyui/demo.css">
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
    <div style="justify-content:center;align-items:center;display:-webkit-flex;">
        <div class="easyui-panel" title="输入账号及密码" style="width:100%;max-width:400px;padding:30px 60px;">
            <form id="login" method="post">
                <div style="margin-bottom:20px">
                    <input class="easyui-textbox" prompt="User ID" name="userId" style="width:100%; font-size: 11px;" data-options="label:'账号:',iconCls:'icon-man',required:true">
                </div>
                <div style="margin-bottom:20px">
                    <input class="easyui-textbox" type="password" prompt="Password" name="passWord" style="width:100%" data-options="label:'密码:',iconCls:'icon-lock',required:true">
                </div>
            </form>
            <div style="text-align:center;padding:5px 0">
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">登录</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清空</a>
            </div>
        </div>
    </div>
    <br>
    <div id="message" style="justify-content:center;align-items:center;display:-webkit-flex;"></div>

    <script>
        /**
         * Created by craftsman on 29/4/18.
         * 提交登录表单
         * error：提示登录失败
         * success：跳转到PSI菜单画面
         */
        function submitForm(){
            debugger
            $('#login').form('submit',{
                url:"/psi/loginCheck",
                success:function(r){
                    debugger
                    if(r == "false"){
                        $("#message").html('<b style="background: mistyrose;color: red;">出错啦，请再次检查输入用户ID和密码是否正确!</b>');
                    }else{
                        window.location.href = "/psi/menu";
                    }
                }
            });
        }

        /**
         * Created by craftsman on 29/4/18.
         * 清空登录表单
         */
        function clearForm(){
            $('#login').form('clear');
            $("#message").html('');
        }
    </script>
</body>
</html>