<div class="easyui-navpanel" style="position:relative;padding:20px">
    <header>
        <div class="m-toolbar">
            <div class="m-title">Basic Form</div>
            <div class="m-right">
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" outline="true" onclick="$('#ff').form('reset')" style="width:60px">Reset</a>
            </div>
        </div>
    </header>
    <form id="ff">
        <div style="margin-bottom:10px">
            <input class="easyui-textbox" label="Full name:" prompt="Full name" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input class="easyui-datebox" label="Birthday:" prompt="Birthday" data-options="editable:false,panelWidth:220,panelHeight:240,iconWidth:30" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input class="easyui-passwordbox" label="Password:" prompt="Password" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input class="easyui-numberbox" label="Number:" prompt="Number" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <label class="textbox-label">Switch:</label><!--
				--><input class="easyui-switchbutton">
        </div>
    </form>
</div>
