<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">

    <section class="login con">
        <div class="form_box">
            <h2>로그인</h2>
            <form action="<%= request.getContextPath() %>/user/login" method="post">
                <input type="text" name="id" placeholder="아이디를 입력해주세요">
                <input type="password" name="password" placeholder="비밀번호를 입력해주세요">
                <div>
                    <ul>
                        <li><a href="#">아이디 찾기</a></li>|
                        <li><a href="#">비밀번호 찾기</a></li>
                    </ul>
                </div>
                <button type="submit">로그인</button>
            </form>
            <a href="<%= request.getContextPath() %>/view/user/register.jsp"><button type="button">회원가입</button></a>
        </div>
    </section>
   	<%@ include file="../../layout/footer.jsp" %>
   	
   	
