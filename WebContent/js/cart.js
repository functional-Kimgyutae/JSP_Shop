			for(let div of document.querySelectorAll(".item")) {
	            div.querySelector(".down").addEventListener("click", (e) => {
	                let data = e.target.dataset.idx;
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
	                calc();
	            });
	            
	            div.querySelector(".up").addEventListener("click", (e) => {
	                let data = e.target.dataset.idx;
	                console.log(data);
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
	                calc();
	            });
	            div.querySelector(".close").addEventListener("click", (e) => {
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