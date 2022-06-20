
fetch("/customer/get-logged", {
	method: 'GET',
}).then(resp => {
	if(resp.status === 200) {
		return resp.json();
	} else {
		return undefined;
	}
}).then(data => {
	customer = data;
});

function addToCart() {
	if(customer === undefined) {
		alert("Vui lòng đăng nhập!!");
		window.location.replace("/login");
	} else {
		var values = [], count = 0;
		var keys = Object.keys(localStorage);
		for(var k of keys) {
			values[values.length++] = {
				"key": k,
				"value": localStorage.getItem(k)
			}
		}
		var o = {
			"key": code,
			"value": customer.username
		}
		for(var v of values) {
			if(JSON.stringify(v) === JSON.stringify(o)) {
				count++;
			}
		}
		if(count === 0) {
			localStorage.setItem(o.key, o.value);
			alert("Thêm sản phẩm vào giỏ hàng thành công!!");
			window.location.replace("/cart");
		} else {
			alert("Sản phẩm đã có trong giỏ hàng!!");
		}
		/*var values = [];
		var keys = Object.keys(localStorage);

		for(var k of keys) {
			values[values.length++] = {
				"key": k,
				"value": localStorage.getItem(k)
			}
		}

		fetch("/orders/add-to-cart?code=" + code, {
			method: 'GET',
		}).then(resp => {
			if(resp.status === 200) {
				return resp.json();
			}
		}).then(data => {
			var o = {
				"key": code,
				"value": customer.username
			}
			localStorage.setItem(o.key, o.value);
			var count = 0;
			for(var v of values) {
				if(JSON.stringify(v) === JSON.stringify(o)) {
					count++;
				}
			}
			console.log(data);
			if(data === 200) {
				alert("Thêm sản phẩm vào giỏ hàng thành công!!")
			} else {
				alert("Vui lòng đăng nhập!!");
				window.location.replace("/login?status=401");
			}
		});*/
	}
}

function shopNow() {
	localStorage.clear();
}