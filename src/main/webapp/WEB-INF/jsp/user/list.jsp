<%--
  Created by IntelliJ IDEA.
  User: Lyon
  Date: 2017/7/11
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="a" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<s:form modelAttribute="key" method="post">
    <label>登录名：</label>
    <s:input path="loginName"/>
    &nbsp;&nbsp;
    <label>姓名：</label>
    <s:input path="staffName"/>
    &nbsp;&nbsp;
    <label>员工编号：</label>
    <s:input path="staffNo"/>

    <button type="submit">查询</button>
</s:form>
<table>
    <thead>
    <th>登录名</th>
    <th>姓名</th>
    <th>员工编号</th>
    <th>账户启用</th>
    <th>职位</th>
    <th>入职日期</th>
    <th>离职日期</th>
    <th>操作</th>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="user">

        <tr>
            <td>${user.loginName}</td>
            <td>${user.staffInfo.staffName}</td>
            <td>${user.staffNo}</td>
            <td>${user.accEnabled}</td>
            <td>${user.staffInfo.staffPosition}</td>
            <td><fmt:formatDate value="${user.staffInfo.entryDate}" pattern="yyyy-MM-dd"/> </td>
            <td><fmt:formatDate value="${user.staffInfo.leaveDate}" pattern="yyyy-MM-dd"/></td>
            <td>
                <a href="/admin/user/${user.id}/edit">编辑</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
