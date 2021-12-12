<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../layout/header.jsp" %>

<!-- visual 영역 -->
    <div id="visual">
        <div id="img_con">
            <img src="<%= request.getContextPath() %>/data/design/visual_11.webp" alt="">
            <img src="<%= request.getContextPath() %>/data/design/visual_2.jpg" alt="">
            <img src="<%= request.getContextPath() %>/data/design/visual_3.webp" alt="">
            <img src="<%= request.getContextPath() %>/data/design/visual_11.webp" alt="">
        </div>
    </div>
    <!-- visual 영역 -->

    <!-- suggest 영역 -->
    <div class="suggest">
        <div class="con">
            <h2>이런 상품은 어떠신가요?</h2>
            <div class="card_box">
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="text">
                        <h2>[우리밀]</h2>
                        <p><span class="count">4%</span>1720원</p>                    			    	
                        <span class="before">1800원</span>                       			    	 
                     </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="text">
                        <h2>[우리밀]</h2>
                        <p><span class="count">4%</span>1720원</p>                    			    	
                        <span class="before">1800원</span>                       			    	 
                     </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="text">
                        <h2>[우리밀]</h2>
                        <p><span class="count">4%</span>1720원</p>                    			    	
                        <span class="before">1800원</span>                       			    	 
                     </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="text">
                        <h2>[우리밀]</h2>
                        <p><span class="count">4%</span>1720원</p>                    			    	
                        <span class="before">1800원</span>                       			    	 
                     </div>
                </div>
            </div>
        </div>
    </div>
    <!-- suggest 영역  -->
    <!-- banner -->
    <div class="banner">
        <img src="<%= request.getContextPath() %>/data/design/banner_2.webp" alt="">
    </div>
    <!-- banner -->
    <!-- suggest 영역 -->
    <div class="suggest">
        <div class="con">
            <h2>할인 상품 </h2>
            <div class="card_box">
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- suggest 영역  -->

    <!-- suggest 영역 -->
    <div class="suggest">
        <div class="con">
            <h2>새로 만나는 신상품</h2>
            <div class="card_box">
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- suggest 영역  -->
    <!-- grid 영역 -->
    <div class="tag_box">
        <h2>카테고리</h2>
        <div class="grid_box con">
            <div class="grid_card"><img src="<%= request.getContextPath() %>/data/design/img_1.png" alt=""><a href="<%= request.getContextPath() %>/shop/tag?tag=0">패션의류·잡화·뷰티</a></div>
            <div class="grid_card"><img src="<%= request.getContextPath() %>/data/design/img_2.png" alt=""><a href="<%= request.getContextPath() %>/shop/tag?tag=1">컴퓨터·디지털·가전</a></div>
            <div class="grid_card"><img src="<%= request.getContextPath() %>/data/design/img_3.png" alt=""><a href="<%= request.getContextPath() %>/shop/tag?tag=2">스포츠·건강·렌탈</a></div>
            <div class="grid_card"><img src="<%= request.getContextPath() %>/data/design/img_4.png" alt=""><a href="<%= request.getContextPath() %>/shop/tag?tag=3">자동차·공구</a></div>
            <div class="grid_card"><img src="<%= request.getContextPath() %>/data/design/img_5.png" alt=""><a href="<%= request.getContextPath() %>/shop/tag?tag=4">홈데코·문구</a></div>
            <div class="grid_card"><img src="<%= request.getContextPath() %>/data/design/img_6.png" alt=""><a href="<%= request.getContextPath() %>/shop/tag?tag=5">취미·반려</a></div>
            <div class="grid_card"><img src="<%= request.getContextPath() %>/data/design/img_7.png" alt=""><a href="<%= request.getContextPath() %>/shop/tag?tag=6">식품·생필품</a></div>
        </div>
    </div>
    <!-- grid 영역 -->
    <!-- suggest 영역 -->
    <div class="suggest">
        <div class="con">
            <h2>후기가 가장 많은 상품</h2>
            <div class="card_box">
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
                <div class="card">
                    <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
                <div class="card">
                <img src="<%= request.getContextPath() %>/data/productImg.jpg" alt="">
                    <div class="info">
                        <h2>우리밀</h2>
                        <p>4% 1,720월</p>
                        <p>1,800원</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- suggest 영역  -->

<%@ include file = "../layout/footer.jsp" %>
