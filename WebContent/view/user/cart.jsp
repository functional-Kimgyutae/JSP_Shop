<%@page import="java.text.DecimalFormat"%>
<%@page import="vo.CartVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/cart.css">    
    <% 
    	ArrayList<CartVO> list = (ArrayList)request.getAttribute("list");
	    DecimalFormat formatter = new DecimalFormat("###,###");
     %>
    <section class="con cart">
        <h2>장바구니</h2>
        <form action="">
            <div class="cart_box">
            <% if(list != null) {
           	  	for(CartVO data : list) {
           	%>
            	<div class="item">
            		<input type="hidden" name="c_id" value="<%= data.getC_id() %>">
                    <div class="img">
                        <img src="<%= data.getP_img() %>" alt="">
                    </div>
                    <span class="name"><a href="<%= request.getContextPath() %>/shop/product?p_id=<%= data.getP_id()  %>"><%= data.getP_name() %></a></span>
                    <div class="count">
									<button type="button" data-idx="<%= data.getC_id() %>"" class="down">-</button><input type="number" class="cnt"
                           value="<%= data.getC_cnt() %>" readonly><button type="button" data-idx="<%= data.getC_id() %>"class="up">+</button>
                    </div>
                    <span class="pay"><span class="cost"><%= formatter.format(data.getP_price() * data.getC_cnt()) %></span>원</span>
                    <span class="close" data-idx="<%= data.getC_id() %>">X</span>
                </div>
            <%
           	  	}
            	}else {%>
            	<h2>쇼핑카트가 비여있습니다.</h2>
              <%}%>   
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
    <script>
    
    </script>
   	<%@ include file="../../layout/footer.jsp" %>