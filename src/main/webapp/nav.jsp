<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="_ctx" value="/" scope="session" />
<ul style="width: 100%; text-align: center;">
	<li style="display: inline-block;"><a href="user/switch"
		target="_frame">切换用户</a></li>
	<li style="display: inline-block;"><a href="p/repo"
		target="_frame">流程仓库</a></li>
	<li style="display: inline-block;"><a href="p/todoList"
		target="_frame">待办任务</a></li>
	<li style="display: inline-block;"><a href="p/search"
		target="_frame">任务查询</a></li>
</ul>
