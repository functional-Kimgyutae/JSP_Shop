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
                    <td><input type="text" name="id" id="id" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합"><a href="#" class="register_btn">중복확인</a>
                        <p class="txt_guide">
                            <span class="txt txt_case1">6자 이상의 영문 혹은 영문과 숫자를 조합</span>
                            <span class="txt txt_case1">아이디 중복확인</span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요">
                        <p class="txt_guide">
                            <span class="txt txt_case1">10자 이상 입력</span>
                            <span class="txt txt_case1">영문/숫자/특수문자(!@#$%^&*())만 허용</span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호확인</th>
                    <td><input type="password" id="passwordc" name="passwordc" placeholder="비밀번호를 한번 더 입력해주세요">
                        <p class="txt_guide">
                            <span class="txt txt_case1">동일한 비밀번호를 입력해주세요</span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="name" id="name" placeholder="이름을 입력해주세요">
                    </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="text" name="email" id="email" placeholder="예:gyubung@gyu.com">
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
                        <input type="text"placeholder="상세주소" name="addr2" id="addr2" class="Detail">
                    </td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>
                        <label for=""><input name="gender" id="gender" type="radio">남자</label>
                        <label for=""><input name="gender" id="gender" type="radio">여자</label>
                        <label for=""><input name="gender" id="gender" checked type="radio" checked>선택안함</label>
                    </td>
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td><input name="date" id="date" type="date">
                    </td>
                </tr>
            </table>
            <div>
                <button type="submit">가입하기</button>
            </div>
        </form>
    </section>
    

    <script>
    let check = 0;
    document.querySelector(".register_btn").addEventListener("click",()=> {
    	console.log("aaa");
    	$.ajax(
    		{
    			type:"POST",
    			url:"<%= request.getContextPath() %>/ajax/check_id",
    			data:{id:document.frm.id.value},
    			dataType:"json",
    			success :  res => {
					if(res.name == 0) alert("중복값이 있음")
					else check = 1
    			},error: log =>{console.log("실패"+log)}
    		}		
    	)
    });
    
    function kakaopost() {
        new daum.Postcode({
            oncomplete: function (data) {
                document.frm.addr.value = data.address;
                document.frm.addr1.value = data.zonecode;
            }
        }).open();
    }
    function checkForm(){
  
    	if(document.frm.id.value.trim() == ""){
    	alert("아이디가 입력되지 않았습니다.");
    	document.frm.id.focus();
    	return false;
    	}
    	if(document.frm.password.value.trim() == ""){
    	alert("비밀번호가 입력되지 않았습니다.");
    	document.frm.password.focus();
    	return false;
    	}
        if(document.frm.passwordc.value.trim() == ""){
    	alert("확인용 비밀번호가 입력되지 않았습니다.");
    	document.frm.passwordc.focus();
    	return false;
    	}
        if(document.frm.name.value.trim() == ""){
    	alert("회원성명이 입력되지 않았습니다.");
    	document.frm.name.focus();
    	return false;
    	}
        if(document.frm.email.value.trim() == ""){
    	alert("이메일이 입력되지 않았습니다.");
    	document.frm.email.focus();
    	return false;
    	}
        if(document.frm.number.value.trim() == ""){
    	alert("전화번호가 입력되지 않았습니다.");
    	document.frm.number.focus();
    	return false;
    	}
        if(document.frm.addr.value.trim() == ""){
    	alert("배송지가 입력되지 않았습니다.");
    	document.frm.addr.focus();
    	return false;
    	}
        if(document.frm.addr2.value.trim() == ""){
    	alert("상세배송지가 입력되지 않았습니다.");
    	document.frm.addr2.focus();
    	return false;
    	}
    	if(document.frm.date.value.trim() == ""){
    	alert("생년월일이 입력되지 않았습니다.");
    	document.frm.date.focus();
    	return false;
    	}
        let email_reg = /(^[A-Za-z_0-9]+@[a-zA-Z_0-9]+(\.[a-z]{2,3}))$/;
        let password_reg = /^[A-Z0-9a-z!@#$%^&*()]{10,}$/;
        let id_reg = /^[A-Z0-9a-z]{6,}$/;
    	if(!id_reg.test(document.frm.id.value)){
    		alert("아이디 형식이 맞지 않습니다.");
        	document.frm.id.focus();
        	return false;
    	}
    	if(!email_reg.test(document.frm.email.value)){
    		alert("이메일 형식이 맞지 않습니다.");
        	document.frm.email.focus();
        	return false;
    	}
    	if(!password_reg.test(document.frm.password.value)){
    		alert("비밀번호 형식이 맞지 않습니다.");
        	document.frm.password.focus();
        	return false;
    	}
    	if(document.frm.password.value != document.frm.passwordc.value){
    		alert("비밀번호가 일치하지 않습니다.");
        	document.frm.passwordc.focus();
        	return false;
    	}
    	if(check == 0){
    		alert("아이디 중복 검사를 안했거나, 아이디가 중복됩니다.");
    		return false;
    	}
    	alert("회원등록이 완료되었습니다!");
    	return false;
    }
    </script>
        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   	<%@ include file="../../layout/footer.jsp" %>