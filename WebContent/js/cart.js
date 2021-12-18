			for(let div of document.querySelectorAll(".item")) {
	            div.querySelector(".down").addEventListener("click", (e) => {
	                let dat = e.target.dataset.idx;
	                let data = "c_"+dat;
	            	console.log(data);
	                let cnt = div.querySelector(`#${data} .cnt`).value;
	                let price = div.querySelector(`#${data} .p_price`).value;
	                if (cnt == 1) {
	                    alert("수량은 최소 1개 이상이여야 합니다.");
	                    return;
	                }
	                cnt--;
	                div.querySelector(`#${data} .cnt`).value = cnt;
	                let str = cnt * price;
	                div.querySelector(`#${data} .cost`).innerHTML = str.toLocaleString();
	                mod(dat,cnt);
	                calc();
	            });
	            
	            div.querySelector(".up").addEventListener("click", (e) => {
	                let dat = e.target.dataset.idx;
	                let data = "c_"+dat;
	                let cnt = div.querySelector(`#${data} .cnt`).value;
	                let price = div.querySelector(`#${data} .p_price`).value;
	                if (cnt == 100) {
	                    alert("수량은 최대 100개 까지입니다.");
	                    return;
	                }
	                cnt++;
	                div.querySelector(`#${data} .cnt`).value = cnt;
	                let str = cnt * price;
	                div.querySelector(`#${data} .cost`).innerHTML = str.toLocaleString();
	                mod(dat,cnt);
	                calc();
	            });
	            div.querySelector(".close").addEventListener("click", (e) => {
	            	del(e.target.dataset.idx);
	            	div.remove();
	                calc();
	            });
	            
			}
			
				
            function calc(){
                let dom = document.querySelectorAll(".item");
                let total = 0;
                let cnt = 0;
                let price = 0;
                for(let item of dom) {
                    cnt = item.querySelector(".cnt").value;
                    price = item.querySelector(".p_price").value;
                    total = total + (cnt*price);
                }
                document.querySelector(".total").innerHTML = total.toLocaleString()+"원";
                document.querySelector(".total").dataset.money = total;
                document.querySelector(".final").innerHTML = (total+3000).toLocaleString()+"원";
            }

            calc();
            
            function mod(data,cnt) {
            	console.log("mod");
                $.ajax(
                    {
                        type: "POST",
                        url: "/Shop/ajax/mod_cart",
                        data: { 
                                "c_id": data,
                                "cnt":cnt
                              },
                        dataType: "json",
                        success: res => {

                        }, error: log => { console.log("실패" + log) }
                    }
                )
            }
            function del(data) {
                $.ajax(
                    {
                        type: "POST",
                        url: "/Shop/ajax/del_cart",
                        data: { 
                                "c_id": data
                              },
                        dataType: "json",
                        success: res => {
                            
                        }, error: log => { console.log("실패" + log) }
                    }
                )
            }
            
            document.querySelector(".purchase").addEventListener("click",(e)=> {          
            	let dom = document.querySelectorAll(".item");
            	console.log("tbr");
            	let productArray = [];
            	let cntArray = [];
                let total = 0;
                let cnt = 0;
                let price = 0;
                for(let item of dom) {
                	let c_id = item.dataset.idx;
                    cnt = item.querySelector(".cnt").value;
                    price = item.querySelector(".p_price").value;
                    total = total + (cnt*price);
                    productArray.push(c_id);
                    cntArray.push(cnt);
                }
            	$.ajax(
                        {
                            type: "POST",
                            url: "/Shop/ajax/order_cart",
                            data: { 
                                    "total" : total,
                                    "productArray" : productArray,
                                    "cntArray" : cnt
                                  },
                            dataType: "json",
                            success: res => {
                                alert("주문이 완료되었습니다.");
                                location.href("/Shop/index");
                            }, error: log => { console.log("실패" + log) }
                        }
                    )
            });
            