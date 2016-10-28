<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="resources/js/easyui/themes/icon.css">
    <script type="text/javascript" src="resources/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resources/js/app/register.js"></script>
    <script type="text/javascript" src="resources/js/app/sj/sjcl.js"></script>
    <script type="text/javascript" src="resources/js/app/cf/cfdj_search.js"></script>
    <script type="text/javascript">
        $(function () {
            var d = new SjclDialog('FZKM201609190001', '存量房买卖');

            var data = new Array();
            var onSelected = function (rows) {
                $.each(rows, function (index, value) {
                    var result = $.grep(data, function (e) {
                        return e.fid == value.fid;
                    });
                    if (result.length == 0) {
                        data.push(value);
                    }
                });
                $("#_grid_djf").datagrid({
                    data: data
                });
            };

            var _d_CfdjSearch = new CfdjSearchDialog('FCKM201601010001', onSelected);


            $("#sjcl").click(function () {
                d.open();
            });

            $("#cfsearch").click(function () {
                _d_CfdjSearch.open();
            });
        });
    </script>
</head>
<body>
<button id="sjcl">收件材料</button>
<button id="cfsearch">查封信息查询</button>
<table id="_grid_djf" class="easyui-datagrid" data-options="fit:true">
    <thead>
    <th data-options="field:'fid',width:80,checkbox:true"></th>
    <th data-options="field:'ywh',width:80">查封业务号</th>
    <th data-options="field:'bdcqzh',width:80">不动产权证号</th>
    </thead>
</table>

</body>
</html>
