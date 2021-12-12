let check = 0;
    document.querySelector(".register_btn").addEventListener("click",()=> {
        let id_reg = /^[A-Z0-9a-z]{6,}$/;
    	if(document.frm.id.value.trim() == "")return;
    	if(!id_reg.test(document.frm.id.value))return;
    	$.ajax(
    		{
    			type:"POST",
    			url:"/Shop/ajax/check_id",
    			data:{id:document.frm.id.value},
    			dataType:"json",
    			success :  res => {
					if(res.same == "true") alert("아이디가 이미 사용중입니다.")
					else{
						alert("아이디가 사용가능합니다.");
						check = 1
					}
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

    	return true;
    }