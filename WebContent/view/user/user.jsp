<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/user.css">
    <section class="con user">
        <div class="top_user">
            <div class="profile">
                <img src="<%= request.getContextPath() %>/data/user.png" alt="">
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
                    <li class="active"><a href="#">주문내역</a></li>
                    <li><a href="#">후기</a></li>
                    <li><a href="#">1대1문의</a></li>
                    <li><a href="#">개인정보수정</a></li>
                </ul>
            </div>
            <div class="user_table">
                <div class="order_list active">
                    <h2>주문 내역<span>지난 기간의 주문 내역 조회가 가능합니다.</span></h2>
                    <table>
                        <p>주문내역이 없습니다.</p>
                    </table>
                </div>
                <div class="review_list">

                </div>
                <div class="question_list">

                </div>
                <div class="coupon_list">

                </div>
            </div>
        </div>
    </section>


<%@ include file="../../layout/footer.jsp" %>