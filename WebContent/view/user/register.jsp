<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/register.css">
    <section class="register con">
      <h2>회원가입</h2>
        <form action="<%= request.getContextPath() %>/user/register" method="post" name="frm" onsubmit="return checkForm()">
            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="id" id="id" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합" maxlength='20'><a href="#" class="register_btn">중복확인</a>
                        <p class="txt_guide">
                            <span class="txt txt_case1">6자 이상의 영문 혹은 영문과 숫자를 조합</span>
                            <span class="txt txt_case1">아이디 중복확인</span>
                        </p>
                    </td>
                </tr>
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
                <button type="submit">가입하기</button>
            </div>
        </form>
    </section>
        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        <script src="<%= request.getContextPath() %>/js/register.js"></script>
   	<%@ include file="../../layout/footer.jsp" %>