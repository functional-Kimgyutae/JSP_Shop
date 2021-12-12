<%@page import="java.text.DecimalFormat"%>
<%@page import="vo.PaginationVO"%>
<%@page import="vo.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/search.css">
    <%
    	ArrayList<ProductVO> list = (ArrayList)request.getAttribute("list");
		String search =  (String)request.getAttribute("search");
		int start =  Integer.parseInt(String.valueOf(request.getAttribute("start")));
	    PaginationVO pVO = (PaginationVO)request.getAttribute("pVO");
		DecimalFormat formatter = new DecimalFormat("###,###");
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
        <span class="total"><%= pVO.getTotal() %>개(<%= start %>/<%= pVO.getTotal()>start+8?start+8 : pVO.getTotal() %>)</span>
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
                       			    		<p><%= formatter.format(data.getPrice()) %>원</p>
                      					<%}else{%>
                      						<p><span class="count"><%= data.getCount() %>%</span><%= formatter.format(Math.round(data.getPrice()-(data.getPrice()*((float)data.getCount()/100)))) %>원</p>                    			    	
                      		 	    		<span class="before"><%= formatter.format(data.getPrice()) %>원</span>                       			    	
                       			    	<%}%>
                			   		</div>
                			   		</a>
                			 	</div>
                			</li>
						<%}%>
		            </ul>
						<div class="pg">
              			    <ul>
              			    	<% if(pVO.isPrev()){ %>
               				     <li><a href="<%= request.getContextPath() %>/shop/search?search=<%= search %>&page=<%= pVO.getStart()-1 %>">&lt;</a></li>              			    	
              			    	<%}
              			    	for(int i= pVO.getStart();i <= pVO.getEnd();i++){
                  			    %>
                			    	<li><a href="<%= request.getContextPath() %>/shop/search?search=<%= search %>&page=<%= i %>"><%= i %></a></li>
              			    	<%
              			    	}
              			    	if(pVO.isNext()){ 
                  			    %> 
            			        <li><a href="<%= request.getContextPath() %>/shop/search?search=<%= search %>&page=<%= pVO.getEnd()+1 %>">&gt;</a></li>
              			    	<%} %>                			    
            			    </ul>
            			</div>
					<%}else {%>
					<h2>"<%= search %>"에 검색된 상품이 없습니다.</h2>
    			<% } %>            

        </div>
    </section>

   	<%@ include file="../../layout/footer.jsp" %>