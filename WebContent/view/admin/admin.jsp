<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">    
    
    <section class="con admin">
        <div class="top_admin">
            <div class="profile">
                <img src="<%= request.getContextPath() %>/data/user.png" alt="">
                <div>
                    <h2>어드민님</h2>
                </div>
            </div>
        </div>
        <div class="under_admin">
            
            <div class="menu_bar">
                <h2>관리</h2>
                <ul>
                    <li class="active"><a href="#">회원관리</a></li>
                    <li><a href="#">상품관리</a></li>
                    <li><a href="#">상품추가</a></li>
                    <li><a href="#">1대1문의</a></li>
                </ul>
            </div>
            <div class="admin_table">
                <div class="user_list active">
                    <h2>유저관리<form action=""><input type="text"><button>검색</button></form></h2>
                    <table>
                        <p>주문내역이 없습니다.</p>
                    </table>
                </div>
                <div class="product_list">
                    <h2>상품관리<form action=""><input type="text"><button>검색</button></form></h2>
                </div>
                <div class="question_list">

                </div>
                <div class="coupon_list">

                </div>
            </div>
        </div>
    </section>
    <%@ include file="../../layout/footer.jsp" %>