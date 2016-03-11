<%@tag import="org.apache.commons.lang3.time.DurationFormatUtils"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="value" required="true" type="java.lang.Long"%>
<%@ attribute name="pattern" required="true" type="java.lang.String"%>
<%
String result = "";

if(value != null){
	result = DurationFormatUtils.formatDuration(value, pattern);
}
out.print(result);
%>

