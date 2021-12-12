<%@page import="vo.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/search.css">
    <%
    	ArrayList<ProductVO> list = (ArrayList)request.getAttribute("list");
		String search =  (String)request.getAttribute("search");
	    
    %>
    
    <section class="con search product_list">
        <h2>상품검색</h2>
        <form action="<%= request.getContextPath() %>/shop/search" method="get">
            <div class="tit">검색조건</div>
            <div class="inpuut">
                <input type="text" name="search" id="keyword_search" value="<%= search %>" maxlength='20'>
                <button>검색하기</button>
            </div>
        </form>
        <span class="total">255개</span>
        <div class="list">
            	<% if(!list.isEmpty()) {%>
	            	<ul>            		
						<% for(ProductVO data : list) {%>
							<li>
                   				<div class="item">
                    		    <img src="<%= data.getImage_list().get("0") %>" alt="">
                    		    	<a href="<%= request.getContextPath() %>/shop/product?p_id=<%= data.getP_id()  %>">
                     		    	<div class="text">
                      					<h2>[<%= data.getName() %>]</h2>
                      					<% if(data.getCount() == 0){ %>
                       			    		<p><%= data.getPrice() %>원</p>
                      					<%}else{%>
                      						<p><span class="count"><%= data.getCount() %>%</span><%= Math.ceil(data.getPrice()-(data.getPrice()*((float)data.getCount()/100))) %>원</p>                    			    	
                      		 	    		<span class="before"><%= data.getPrice() %></span>                       			    	
                       			    	<%}%>
                			   		</div>
                			   		</a>
                			 	</div>
                			</li>
						<%}%>
		            </ul>
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
					<%}else {%>
					<h2>"<%= search %>"에 검색된 상품이 없습니다.</h2>
    			<% } %>            

        </div>
    </section>

   	<%@ include file="../../layout/footer.jsp" %>