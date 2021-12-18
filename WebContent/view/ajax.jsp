<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<%
		Enumeration<String> list = request.getAttributeNames();
		<!-- request객체에 담아둔 속성 다 가져오기 -->
		JSONObject ob = new JSONObject();
		
		while(list.hasMoreElements()){
			String name = list.nextElement();
			String value = String.valueOf(request.getAttribute(name));
			ob.put(name,value);
			<!-- json으로 변경 -->
		}	
		out.print(ob);
		%>