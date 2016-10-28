<%--
  Created by IntelliJ IDEA.
  User: Lyon
  Date: 2016/10/19
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="_grid_cfdj" class="easyui-datagrid" toolbar="#_tb_cfsearch"
       data-options="url:'cf/search.json',method:'post',queryParams:{ywh:'${param.ywh}'},fit:true">

    <thead>
        <th data-options="field:'fid',width:80,checkbox:true"></th>
        <th data-options="field:'ywh',width:80">查封业务号</th>
        <th data-options="field:'bdcqzh',width:80">不动产权证号</th>

    </thead>
</table>

<div id="_tb_cfsearch">
    <label for="_print_no">不动产权证号:</label>
    <input id="_print_no" class="easyui-validatebox" data-options="required:false">
    <a id="_btn_cf_search" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
    <a id="_btn_cf_done" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
</div>
<script>
    $("#_btn_cf_search").click(function(){
        if($("#_print_no").validatebox('isValid')){
            $("#_grid_cfdj").datagrid('load',{
                ywh:'${param.ywh}',
                bdcqzh:$("#_print_no").val()
            });
        }
    });

    $("#_btn_cf_done").click(function(){
       var rows = $("#_grid_cfdj").datagrid('getSelections');
        if(!rows){
            alert('请选择要解封的房屋');
        }else{
            var parent = _findReg('CfdjSearchDialog');
            parent.selected(rows);
        }
    });

</script>