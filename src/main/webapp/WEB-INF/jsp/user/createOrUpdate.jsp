<%--
  Created by IntelliJ IDEA.
  User: Lyon
  Date: 2017/7/11
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="a" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>创建用户</title>
</head>
<body>
    <s:form modelAttribute="user" method="post">
        <a:inputField name="loginName" label="登录名："/>
        <a:inputField name="pwd" label="密码："/>
        <a:inputField name="staffNo" label="员工编号："/>
        <div>
        <s:checkbox path="accEnabled" label="启用账户" />
        </div>
        <a:inputField name="expireDate" label="账户有效期："/>
        <a:inputField name="ipAddr" label="IP绑定："/>
        <a:inputField name="macAddr" label="mac绑定："/>

        <button type="submit">保存</button>
    </s:form>
</body>
</html>
