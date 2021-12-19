<%@page import="java.text.DecimalFormat"%>
<%@page import="vo.PaginationVO"%>
<%@page import="vo.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../layout/header.jsp" %>
    <%
    	ArrayList<ProductVO> list = (ArrayList)request.getAttribute("list");
	    String[] tags = {"패션의류·잡화·뷰티","컴퓨터·디지털·가전","스포츠·건강·렌탈","자동차·공구","홈데코·문구","취미·반려","식품·생필품","핫 딜","베스트","빠른 배송","알뜰 쇼핑"};
		int tag =  Integer.parseInt(String.valueOf(request.getAttribute("tag")));
		int start =  Integer.parseInt(String.valueOf(request.getAttribute("start")));
		PaginationVO pVO = (PaginationVO)request.getAttribute("pVO");
		DecimalFormat formatter = new DecimalFormat("###,###");
    %>
    <section class="con tag product_list">
        <h2><%= tags[tag] %></h2>
        <span class="total"><%= pVO.getTotal() %>개(<%= start %>/<%= pVO.getTotal()>start+8?start+8 : pVO.getTotal() %>)</span>
        <div class="list">

            	<% if(!list.isEmpty()) {%>
	            	<ul>            		
						<% for(ProductVO data : list) {%>
							<li>
                   				<div class="item">
                    		    <img src="<%= data.getImageList().get("0") %>" alt="">
                    		    	<a href="<%= request.getContextPath() %>/shop/product?pId=<%= data.getpId()  %>">
                     		    	<div class="text">
                      					<h2>[<%= data.getName() %>]</h2>
                       			    		<p><%= formatter.format(data.getPrice()) %>원</p>
                			   		</div>
                			   		</a>
                			 	</div>
                			</li>
						<%}%>
		            </ul>
						<div class="pg">
              			    <ul>
              			    	<% if(pVO.isPrev()){ %>
               				     <li><a href="<%= request.getContextPath() %>/shop/tag?tag=<%= tag %>&page=<%= pVO.getStart()-1 %>">&lt;</a></li>              			    	
              			    	<%}
              			    	for(int i= pVO.getStart();i <= pVO.getEnd();i++){
              			    	%>
                			    	<li><a href="<%= request.getContextPath() %>/shop/tag?tag=<%= tag %>&page=<%= i %>"><%= i %></a></li>
              			    	<%
              			    	}
              			    	if(pVO.isNext()){ 
                  			    %> 
            			        <li><a href="<%= request.getContextPath() %>/shop/tag?tag=<%= tag %>&page=<%= pVO.getEnd()+1 %>">&gt;</a></li>
              			    	<%} %>                			    
            			    </ul>
            			</div>
					<%}else {%>
					<h2>해당 태그 품목이 없습니다.</h2>
    			<% } %>            

        </div>
    </section>
   	<%@ include file="../../layout/footer.jsp" %>