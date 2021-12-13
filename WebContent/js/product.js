let price = document.querySelector(".p_price").value;
let cnt = document.querySelector(".cnt").value;

document.querySelector(".down").addEventListener("click", () => {
    cnt = document.querySelector(".cnt").value;
    if (cnt == 1) {
        alert("수량은 최소 1개 이상이여야 합니다.");
        return;
    }
    cnt--;
    document.querySelector(".cnt").value = cnt;
    let str = cnt * price;
    document.querySelector(".cost").innerHTML = str.toLocaleString();
});

document.querySelector(".up").addEventListener("click", () => {
    cnt = document.querySelector(".cnt").value;
    if (cnt == 100) {
        alert("수량은 최대 100개 까지입니다.");
        return;
    }
    cnt++;
    document.querySelector(".cnt").value = cnt;
    let str = cnt * price;
    document.querySelector(".cost").innerHTML = str.toLocaleString();
});
if(document.querySelector(".not_login")) {
	document.querySelector(".not_login").addEventListener("click", () => {
	    let con = confirm("장바구니에 넣으실려면 로그인을 해야합니다. 로그인하시겠습니까?");
	    if (con) {
	        location.href = "/Shop/view/user/login.jsp";
	    }
	});	
}

if(document.querySelector(".add_cart")){
	document.querySelector(".add_cart").addEventListener("click", () => {
	    cnt = document.querySelector(".cnt").value;
	    p_id = document.querySelector(".p_id").value;

	    $.ajax(
	        {
	            type: "POST",
	            url: "/Shop/ajax/add_cart",
	            data: {
	                "p_id": p_id,
	                "cnt": cnt
	            },
	            dataType: "json",
	            success: res => {
	                if (res.upload == "true") {
	                    let con = confirm("장바구니에 추가되었습니다. 장바구니로 이동하시겠습니까?");
	                    if (con) {
	                        location.href = "/Shop/view/user/cart.jsp";
	                    } else {
	                        document.querySelector(".cnt").value = 1;
	                        let str = Math.ceil(price);
	                        document.querySelector(".cost").innerHTML = str.toLocaleString();
	                    }
	                }
	                else {
	                    alert("이미 장바구니에 등록된 상품입니다.");
	                }
	            }, error: log => { console.log("실패" + log) }
	        }
	    )
	});
}
