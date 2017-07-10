<%@ tag import="com.whr.utils.ConfigUtils" %>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="propName" required="true"%>
<%=ConfigUtils.getString(propName)%>

