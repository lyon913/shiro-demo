<%--
  Created by IntelliJ IDEA.
  User: Lyon
  Date: 2016/10/26
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收件材料</title>
    <script type="text/javascript" src="resources/js/boot.js"></script>
</head>
<body>
<div id="uitb" class="mini-datagrid" style="width:100%;height:400px;"
     pageSize="10"
     allowCellEdit="true" allowCellSelect="true" multiSelect="true"
     showPager="false" virtualScroll="true"
>
    <div property="columns">
        <div type="indexcolumn" width="20"></div>

        <div field="fid" width="250">材料名称</div>
        <div field="ywh" width="80">类型</div>
        <div field="bdcqzh" width="80">份数</div>

    </div>
</div>
</body>
</html>
