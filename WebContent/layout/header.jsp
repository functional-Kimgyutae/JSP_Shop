<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>규붕</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/font.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/app.css">
        <script src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
</head>
<body>
  <script>   
  	<%
		if(session.getAttribute("alert") != null) {
  			String data = (String)session.getAttribute("alert");
  		%>
  			alert('<%= data %>');		
		<%
			session.removeAttribute("alert");
		}
	%>
  	
  </script> 
    <!-- header 영역 -->
    <header>
        <div id="user_menu" class="con">
            <ul id="list_menu">
            	<% if(session.getAttribute("user_id") != null){ %>
            		<% if(session.getAttribute("user_id").equals("admin")) {%>
                		<li class="menu after_bar"><a href="<%= request.getContextPath() %>/admin/admin">어드민</a></li>
                	<% }else{ %>
                		<li class="menu after_bar"><a href="<%= request.getContextPath() %>/user/user"><%= session.getAttribute("user_id") %>님</a></li>
                	<% } %> 
                		<li class="menu after_bar"><a href="<%= request.getContextPath() %>/user/logout">로그아웃</a></li>
                <% } else { %>
                <li class="menu after_bar"><a href="<%= request.getContextPath() %>/view/user/register.jsp">회원가입</a></li>
                <li class="menu after_bar"><a href="<%= request.getContextPath() %>/view/user/login.jsp">로그인</a></li>
                <% } %>
                <li class="menu"><a href="#">고객센터</a></li>
            </ul>
        </div>  
        <div id="header_logo" class="con">
	   		<a href="<%= request.getContextPath()%>/index"><img src="<%= request.getContextPath() %>/data/design/logo.png" alt=""></a>         
        </div>
        <div id="gnb" class="con">
            <ul class="gnb">
                <li><a href="#">전체 카테고리</a>
                    <ul class="slide">
                        <li><a href="<%= request.getContextPath() %>/shop/tag?tag=0">패션의류·잡화·뷰티</a></li>
                        <li><a href="<%= request.getContextPath() %>/shop/tag?tag=1">컴퓨터·디지털·가전</a></li>
                        <li><a href="<%= request.getContextPath() %>/shop/tag?tag=2">스포츠·건강·렌탈</a></li>
                        <li><a href="<%= request.getContextPath() %>/shop/tag?tag=3">자동차·공구</a></li>
                        <li><a href="<%= request.getContextPath() %>/shop/tag?tag=4">홈데코·문구</a></li>
                        <li><a href="<%= request.getContextPath() %>/shop/tag?tag=5">취미·반려</a></li>
                        <li><a href="<%= request.getContextPath() %>/shop/tag?tag=6">식품·생필품</a></li>
                    </ul>    
                </li>
                <li><a href="<%= request.getContextPath() %>/shop/tag?tag=7">핫 딜</a></li>
                <li><a href="<%= request.getContextPath() %>/shop/tag?tag=8">베스트</a></li>
                <li><a href="<%= request.getContextPath() %>/shop/tag?tag=9">빠른 배송</a></li>
                <li><a href="<%= request.getContextPath() %>/shop/tag?tag=10">알뜰 쇼핑</a></li>
            </ul>
            <div id="search">
                <form action="<%= request.getContextPath() %>/shopping/search" method="get">
                    <input type="text" id="keyword_search"name="keyword">
                    <img src="<%= request.getContextPath() %>/data/design/search.png" alt="">
                </form>
            </div>
            <div id="location_set">
                <img src="<%= request.getContextPath() %>/data/design/map.png" alt="">
            </div>
            <div id="cart">
            	<a href="<%= request.getContextPath() %>/shop/cart"><img src="<%= request.getContextPath() %>/data/design/shopping_cart.png" alt=""></a>
            </div>
        </div>
    </header>
    <!-- header 영역 -->