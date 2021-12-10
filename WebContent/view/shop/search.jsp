<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file=../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/search.css">
    
    <section class="con search">
        <h2>상품검색</h2>
        <form action="">
            <div class="tit">검색조건</div>
            <div class="inpuut">
                <input type="text">
                <button>검색하기</button>
            </div>
        </form>
        <div class="list">
            <ul>
                <li>
                    <div class="item">
                        <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                        <div class="text">
                            <h2>[]</h2>
                            <p>15,700원</p>
                            <span>ㅁㄴㅇ</span>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item">
                        <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                        <div class="text">
                            <h2>[]</h2>
                            <p>15,700원</p>
                            <span>ㅁㄴㅇ</span>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item">
                        <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                        <div class="text">
                            <h2>[]</h2>
                            <p>15,700원</p>
                            <span>ㅁㄴㅇ</span>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item">
                        <img src="data/productImg.jpg" alt="">
                        <div class="text">
                            <h2>[]</h2>
                            <p>15,700원</p>
                            <span>ㅁㄴㅇ</span>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </section>

   	<%@ include file="../../layout/footer.jsp" %>