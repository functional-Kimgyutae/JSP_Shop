<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">    
    
    <section class="con admin">
        <div class="top_admin">
            <div class="profile">
                <img src="<%= request.getContextPath() %>/data/design/user.png" alt="">
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
                <div class="product_upload active">
                    <h2>상품 등록</h2>
                    <form action="<%= request.getContextPath() %>/shop/product_insert" method="post" name="frm" class="frm" enctype="multipart/form-data">
                        <table>
                            <!-- 제목,소제목,가격,할인율,판매단위,중량.포장타입,설명,메인이미지,클릭시 이미지업로드파일복사 -->
                            <tr>
                                <th>제목</th>
                                <td><input type="text" name="title" id="title" maxlength='20'></td>
                            </tr>
                            <tr>
                                <th>소제목</th>
                                <td><input type="text" name="l_title" id="l_title" maxlength='15'></td>
                            </tr>
                            <tr>
                                <th>태그</th>
                                <td>
                                	<select name="tag" id="tag">
									    <option value="0">패션의류·잡화·뷰티</option>
    									<option value="1">컴퓨터·디지털·가전</option>
									    <option value="2">스포츠·건강·렌탈</option>
									    <option value="3">자동차·공구</option>
									    <option value="4">홈데코·문구</option>
									    <option value="5">취미·반려</option>
									    <option value="6">식품·생필품</option>
									</select>
								</td>
                            </tr>
                            <tr>
                                <th>가격</th>
                                <td><input type="number" name="price" id="price"></td>
                            </tr>
                            <tr>
                                <th>할인율</th>
                                <td><input type="number" name="count" id="count"></td>
                            </tr>
                            <tr>
                                <th>판매단위</th>
                                <td><input type="text" name="unit" id="unit" maxlength='10'></td>
                            </tr>
                            <tr>
                                <th>포장타입</th>
                                <td><input type="text" name="packaging" id="packaging" maxlength='10'></td>
                            </tr>
                            <tr>
                                <th>설명</th>
                                <td><textarea name="text" id="text" cols="30" rows="5" maxlength='100'></textarea></td>
                            </tr>
                            <tr>
                                <th>메인이미지</th>
                                <td><input type="file" name="img0" id="img0">
                                <input type="hidden" name="cnt" id="cnt" value="0">
                            </td>
                            </tr>
                        </table>
                        <button class="img_add" type='button'>이미지 추가</button>
                        <button class="img_del" type='button'>이미지 삭제</button>
                        <div><button>등록하기</button></div>                       
                    </form>
                </div>            
                <% if(false) { %>
                <div class="user_list active">
                    <h2>유저관리<form action=""><input type="text"><button>검색</button></form></h2>
                    <table>
                        <p>검색을 해주세요.</p>
                    </table>
                    <div class="pg ">
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
                <div class="product_list">
                    <h2>상품관리<form action=""><input type="text"><button>검색</button></form></h2>
                    
                </div>

                <div class="coupon_list">

                </div>
                <%  } %>
            </div>
        </div>
    </section>
    <script>
    let idx = 0;
    let arr = [];
    document.querySelector(".img_add").addEventListener("click",() => {
        if(idx==5) {
            alert("6개 이상은 안됩니다.");
            return;
        }   
        let dom = document.createElement("tr");
		let idd =(idx+1)+"";
        dom.classList.add("idx"+idd);
        dom.innerHTML = '<th>이미지'+idd+'</th><td><input type="file" onchange="fileCheck(this)" name="img'+idd+'" id="img'+idd+'"></td>';
        document.querySelector(".frm>table>tbody").append(dom);
        arr.push(dom);
        idx++;
        document.querySelector(".frm #cnt").value = idx;
    })
    document.querySelector(".img_del").addEventListener("click",() => {
        if(idx==0) {
            alert("삭제할 이미지가 없습니다.");
            return;
        }   
        arr.pop().remove();
        idx--;
        document.querySelector(".frm>table #cnt").value = idx;
    })
                    function fileCheck(obj){
                        pathpoint = obj.value.lastIndexOf(".");
                        filepoint = obj.value.substring(pathpoint+1,obj.length);
                        filetype = filepoint.toLowerCase();
                        if(filetype !="jpg"&&filetype !="gif"&&filetype !="png"&&filetype!="jpeg"){
                            alert("이미지 파일만 넣을수 있습니다.");
                            obj.value = "";
                        }
                    }


                </script>
    <%@ include file="../../layout/footer.jsp" %>