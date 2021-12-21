<%@page import="vo.UserVO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/product.css">
    <% 
    	ProductVO data = (ProductVO)request.getAttribute("data");
    	String[] tags = {"패션의류·잡화·뷰티","컴퓨터·디지털·가전","스포츠·건강·렌탈","자동차·공구","홈데코·문구","취미·반려","식품·생필품","핫 딜","베스트","빠른 배송","알뜰 쇼핑"};
		DecimalFormat formatter = new DecimalFormat("###,###");
    %>
    <section class="con product">
        <div class="inner_view">
            <div class="img_box">
                <img src="<%= data.getImageList_value("0") %>" alt="">
            </div>
            <input type="hidden" class="pId" value="<%= data.getpId() %>">
            <input type="hidden" class="pPrice" value="<%= data.getPrice() %>">

            <div class="text">
                <h2><%= data.getName() %><br><span><%= data.getLName() %></span></h2>
                <p><span class="price"><%= formatter.format(data.getPrice()) %>원</span>
                <div class="goods_info">
                    <dl>
                        <dt>태그</dt>
                        <dd><%= tags[data.getTag()] %></dd>
                    </dl>
                    <dl>
                        <dt>판매단위</dt>
                        <dd><%= data.getUnit() %></dd>
                    </dl>
                    <dl>
                        <dt>포장타입</dt>
                        <dd><%= data.getPackaging() %></dd>
                    </dl>
                    <dl>
                        <dt>설명</dt>
                        <dd><%= data.getText() %></dd>
                    </dl>
                    <dl>
                        <dt>구매수량</dt>
                        <dd><span class="count"><button class="down">-</button><input type="number" class="cnt"
                                    value="1" readonly><button class="up">+</button></span></dd>
                    </dl>
                </div>
                <p>총 상품금액:<span class="cost"><%= formatter.format(data.getPrice()) %></span>원</p>
                <button class="<%= session.getAttribute("userVO") != null? "add_cart": "not_login" %>">장바구니 담기</button>
            </div>
        </div>
        <div class="product_img">
			<% for(int i = 0; i<= data.getCnt(); i++){ %>
				<img alt="" src="<%= data.getImageList_value(i+"") %>">
			<% } %>
        </div>
        <div class="review_table">
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>공지</td>
                        <td>공asfasfas</td>
                        <td>asdfas</td>
                        <td>2020-12-12</td>
                    </tr>
                </tbody>
            </table>
            <button>후기쓰기</button>
 			<div class="pg">
            	<ul>
               		<li><a href="#">&lt;</a></li>
					<li><a href="#">1</a></li>
            		<li><a href="#">2</a></li>
			        <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                	<li><a href="#">5</a></li>
            		<li><a href="#">&gt;</a></li>
            	</ul>
            </div>
        </div>
    </section>
	<script src="<%= request.getContextPath() %>/js/product.js"></script>
   	<%@ include file="../../layout/footer.jsp" %>
