<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/product.css">
    <section class="con product">
        <div class="inner_view">
            <div class="img_box">
                <img src="<%= request.getContextPath() %>data/productImg.jpg" alt="">
            </div>
            <div class="text">
                <h2>소버스 면역엔 알로에 베라<br><span>알로에 젤리로 맛있게</span></h2>
                <p><span class="price">7,500원</span><span class="sale">30%</span><br><span class="before">7,500원</span></p>
                <div class="goods_info">
                    <dl>
                        <dt>판매단위</dt>
                        <dd>1통</dd>
                    </dl>
                    <dl>
                        <dt>중량/용량</dt>
                        <dd>1L</dd>
                    </dl>
                    <dl>
                        <dt>포장타입</dt>
                        <dd>상온</dd>
                    </dl>
                    <dl>
                        <dt>설명</dt>
                        <dd>ㅁㄴㅇㄻㄴㅇbr ㄹ</dd>
                    </dl>
                    <dl>
                        <dt>구매수량</dt>
                        <dd><input type="number"></dd>
                    </dl>
                </div>
                <p>총 상품금액:<span>25,000</span>원</p>
                <button>장바구니 담기</button>
            </div>
        </div>
        <div class="product_img">
            <img src="d" alt="">
            <img src="" alt="">
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
            <div class="board_pg_area">
                1234567679890
            </div>
        </div>
    </section>

   	<%@ include file="../../layout/footer.jsp" %>