<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/user.css">
    <section class="con user">
        <div class="top_user">
            <div class="profile">
                <img src="<%= request.getContextPath() %>/data/design/user.png" alt="">
                <div>
                    <h2>김규태님</h2>
                    <p>2004/08/06</p>
                </div>
            </div>
        </div>
        <div class="under_user">
            
            <div class="menu_bar">
                <h2>마이규붕</h2>
                <ul>
                	<% 
                	String cls = "class=\"active\"";
                	int show = Integer.parseInt(String.valueOf(request.getAttribute("show")));
                	%>
                    <li <%= show == 0? cls:"" %>><a href="<%= request.getContextPath() %>/user/user?show=0">주문내역</a></li>
                    <li <%= show == 1? cls:"" %>><a href="<%= request.getContextPath() %>/user/user?show=1">후기</a></li>
                    <li <%= show == 2? cls:"" %>><a href="<%= request.getContextPath() %>/user/user?show=2">1대1문의</a></li>
                    <li <%= show == 3? cls:"" %>><a href="<%= request.getContextPath() %>/user/user?show=3">개인정보수정</a></li>
                </ul>
            </div>
            <div class="user_table">
            	 
            	<% 
            		
            		if(show == 0) { %>
                <div class="order_list active">
                    <h2>주문 내역<span>지난 기간의 주문 내역 조회가 가능합니다.</span></h2>
                    <table>
                        <p>주문내역이 없습니다.</p>
                    </table>
                </div>
                <% }else if(show == 1) { %>
                <div class="review_list active">
					<h2>구현중입니다.</h2>
                </div>
                <% }else if(show == 2) { %>
                <div class="question_list active">
					<h2>구현중입니다.</h2>
                </div>
                <% }else { %>
                <div class="edit_list active">
					<form action="<%= request.getContextPath() %>/user/register" method="post" name="frm" onsubmit="return checkForm()">
            		<table>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요" maxlength='20'>
                        <p class="txt_guide">
                            <span class="txt txt_case1">10자 이상 입력</span>
                            <span class="txt txt_case1">영문/숫자/특수문자(!@#$%^&*())만 허용</span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호확인</th>
                    <td><input type="password" id="passwordc" name="passwordc" placeholder="비밀번호를 한번 더 입력해주세요" maxlength='20'>
                        <p class="txt_guide">
                            <span class="txt txt_case1">동일한 비밀번호를 입력해주세요</span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="name" id="name" placeholder="이름을 입력해주세요" maxlength='20'>
                    </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="text" name="email" id="email" placeholder="예:gyubung@gyu.com" maxlength='40'>
                    </td>
                </tr>
                <tr>
                    <th>휴대폰</th>
                    <td><input type="text" name="number" id="number" placeholder="숫자만 입력해주세요">
                    </td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td><input type="text" name="addr" id="addr" readonly>
	                    <input type="text" name="addr1" id="addr1" readonly style="margin-top:10px">
                        <input type="button" class="add" value="주소 검색" target="_blank" onclick="kakaopost()"style="margin-top:10px">
                        <input type="text"placeholder="상세주소" name="addr2" id="addr2" class="Detail" maxlength='100'>
                    </td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>
                        <label for=""><input name="gender" id="gender" value="1" type="radio">남자</label>
                        <label for=""><input name="gender" id="gender" value="2" type="radio">여자</label>
                        <label for=""><input name="gender" id="gender" value="0" checked type="radio" checked>선택안함</label>
                    </td>
                </tr>
            </table>
            <div>
                <button type="submit">수정하기</button>
            </div>
        </form>
                </div>                
                <% } %>
            </div>
        </div>
    </section>


<%@ include file="../../layout/footer.jsp" %>