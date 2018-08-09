<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>PSI系统菜单页</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../easyui/demo.css">
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>
<body id="myLayOut" class="easyui-layout">
    <div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
        <label style="font-size: 21px">进销存管理平台</label>
    </div>
    <div id="menu" data-options="region:'west',split:true,title:'功能菜单'" style="width:150px;padding:10px;">
        <div id="order-menu">
            <ul id="order-manage" class="easyui-datalist" data-options="iconCls:'icon-edit'" title="订单管理" lines="true" style="width:100%;">
                <li value="POI">采购单录入</li>
                <li value="POS">采购单查询</li>
                <li value="SOI">销售单录入</li>
                <li value="SOS">销售单查询</li>
            </ul>
        </div>
        <hr>
        <div id="inventory-menu">
            <ul id="inventory-manage" class="easyui-datalist" data-options="iconCls:'icon-search'" title="库存管理" lines="true" style="width:100%;">
                <li value="CM">库存出入库管理</li>
                <li value="SM">全年进出库查询</li>
            </ul>
        </div>
        <hr>
        <div id="manage-menu">
            <ul id="basic-manage" class="easyui-datalist" data-options="iconCls:'icon-man'" title="基础数据管理" lines="true" style="width:100%;">
                <li value="CM">客户管理</li>
                <li value="SM">供应商管理</li>
                <li value="PM">产品型号管理</li>
            </ul>
        </div>
    </div>
    <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">
        south region
    </div>
    <div id="center" class="easyui-tabs" data-options="region:'center',title:'功能页面'" fit="true" border="true" style="border-width: 0px"></div>

    <script>


        /**
         * Created by craftsman on 29/4/18.
         * 菜单页面初期化
         */
        $(function(){
            debugger
            $('#order-manage').datagrid({
                onSelect: function(){
                    $('#inventory-manage').datagrid('clearSelections');
                    $('#basic-manage').datagrid('clearSelections');
                }
            });
            $('#inventory-manage').datagrid({
                onSelect: function(){
                    $('#order-manage').datagrid('clearSelections');
                    $('#basic-manage').datagrid('clearSelections');
                }
            });
            $('#basic-manage').datagrid({
                onSelect: function(){
                    debugger
                    var selected = $('#basic-manage').datalist('getSelected');

                    $('#order-manage').datagrid('clearSelections');
                    $('#inventory-manage').datagrid('clearSelections');

                    if(selected.value == 'CM'){
                        $('#myLayOut').layout('panel', 'center').panel({ title: '基础数据管理>> 客户管理' });
                        var url = "/psi/customerManage";
//                        loadSubHtml(url);
                        addTab("客户管理",url);

                    }else if(selected.value == 'SM'){
                        $('#myLayOut').layout('panel', 'center').panel({ title: '基础数据管理>> 供应商管理' });
                        var url = "/psi/supplierManage";
//                        loadSubHtml(url);
                        addTab("供应商管理",url);

                    }else if(selected.value == 'PM'){
                        $('#myLayOut').layout('panel', 'center').panel({ title: '基础数据管理>> 产品型号管理' });
                        var url = "/psi/productManage";
//                        loadSubHtml(url);
                        addTab("产品型号管理",url);

                    }
                }
            });
        })

        /**
         * Created by craftsman on 29/4/18.
         * 加载Center子画面
         */
        function loadSubHtml(url){
            debugger

            $.ajax({
                url:url,
                type : "GET",
                async:false,
                success : function(data) {
                    $('#center').html(data);
                },
                error : function(data) {
                    $('#center').html(data);
                }
            });
        }

        /**
         * Created by craftsman on 13/5/18.
         * 在Center布局追加tab子画面
         */
        function addTab(title, url){
            if ($('#center').tabs('exists', title)){
                $('#center').tabs('select', title);
            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;" border="false"></iframe>';
                $('#center').tabs('add',{
                    border:true,
                    title:title,
                    content:content,
                    closable:true
                });
            }
        }

    </script>
</body>
</html>