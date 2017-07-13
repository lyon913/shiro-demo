<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lyon
  Date: 2017/7/12
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="_ctx" value="${pageContext.request.contextPath}" scope="session"/>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login_check" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input name="username"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
