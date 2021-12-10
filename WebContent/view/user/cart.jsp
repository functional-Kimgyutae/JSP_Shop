<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/cart.css">    

    <section class="con cart">
        <h2>장바구니</h2>
        <form action="">
            <div class="cart_box">
                <div class="item">
                    <div class="img">
                        <img src="<%= request.getContextPath() %>/data/cart_img1.webp" alt="">
                    </div>
                    <span class="name"><a href="#">참크레커</a></span>
                    <div class="count">
                        <input type="number">
                    </div>
                    <span class="pay">19,000원</span>
                    <span>X</span>
                </div>
            </div>
            <div class="inner_result">
                <div><span>상품금액</span><span>19,000원</span></div>
                <div><span>상품할인금액</span><span>-1,000원</span></div>
                <div><span>배송비</span><span>+3,000원</span></div>
                <div class="sp"><span>결제예정금액</span><span>21,000원</span></div>
                <div><button>결제하기</button></div>
            </div>
        </form>
    </section>
   	<%@ include file="../../layout/footer.jsp" %>