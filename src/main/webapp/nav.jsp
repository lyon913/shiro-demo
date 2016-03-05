<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="_ctx" value="/" scope="session"/>
<ul>
	<li style="display: inline-block;"><a href="user/switch"
		target="_frame">切换用户</a></li>
	<li style="display: inline-block;"><a href="p/repo"
		target="_frame">流程仓库</a></li>
	<li style="display: inline-block;"><a href="p/todoList"
		target="_frame">待办任务</a></li>
</ul>
