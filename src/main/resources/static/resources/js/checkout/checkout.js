
let customer = {}, product = {}, code;
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
	if(customer !== undefined) {
		fetch("/manage/cart", {
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(getAllProductInLocalStorage()),
		}).then(response => response.json())
			.then(data => {
				for(var d of data) {
					d.quantity = 1;
					d.totalPrice = Number((d.price).toFixed());
					d.cid = d.categoryDTO.id;
					delete d.categoryDTO;
				}
				listProduct = data;
			});
	} else {
		fetch("/product/get-by-code?code=" + params.code, {
			method: 'GET',
		}).then(resp => {
			if(resp.status === 200) {
				return resp.json();
			}
		}).then(data => {
			console.log(data);
			product = data;
			product.quantity = 1;
			product.cid = product.categoryDTO.id;
			delete product.categoryDTO;
			delete product.quantityStock;
		});
	}
});

let countStep = 0;

$(function(){
	$("#wizard").steps({
		headerTag: "h4",
		bodyTag: "section",
		transitionEffect: "fade",
		enableAllSteps: true,
		transitionEffectSpeed: 300,
		labels: {
			next: "Continue",
			previous: "Back",
			finish: 'Proceed to checkout'
		},
		onStepChanging: function (event, currentIndex, newIndex) {
			if ( newIndex >= 1 ) {
				$('.steps ul li:first-child a img').attr('src','../resources/images/step-1.png');
				step.step_one.firstname = $('#wizard .first-name').val();
				step.step_one.lastname = $('#wizard .last-name').val();
				step.step_one.email = $('#wizard .email').val();
				step.step_one.residence = $('#wizard .residence').val();
				step.step_one.district = $('#wizard .district').val();
				step.step_one.city = $('#wizard .city').val();
				step.step_one.phone = $('#wizard .phone').val();
			} else {
				$('.steps ul li:first-child a img').attr('src','../resources/images/step-1-active.png');
			}

			if ( newIndex === 1) {
				console.log(step);
				$('.steps ul li:nth-child(2) a img').attr('src','../resources/images/step-3-active.png');
				if(params.code !== null) {
					if(step.step_two.length > 0) {
						for(var o of step.step_two) {
							if(o.code !== product.code) {
								step.step_two[step.step_two.length++] = product;
							}
						}
					} else {
						step.step_two[step.step_two.length++] = product;
					}
					product.totalPrice = Number((product.price).toFixed())*product.quantity;
				} else {
					countStep++;
					update(listProduct);
					step.step_two = listProduct;
					if(countStep > 0) {
						update(listProduct);
					}
				}
			} else {
				$('.steps ul li:nth-child(2) a img').attr('src','../resources/images/step-3.png');
			}

			if ( newIndex === 2 ) {
				$('.steps ul li:nth-child(3) a img').attr('src','../resources/images/step-4-active.png');
				$('.actions ul').addClass('step-4');
				var objectStepThree = {
					"price": 0,
					"quantity": 0,
					"sale": 0,
					"total": 0
				};
				for(var o of step.step_two) {
					objectStepThree.price += o.totalPrice;
					objectStepThree.quantity += o.quantity;
					objectStepThree.sale += o.quantity;
				}
				if(customer === undefined) {
					objectStepThree.sale = 0;
				}
				document.querySelector(".cart_totals .cart_sub_total").innerHTML = '$' + objectStepThree.price;
				document.querySelector(".cart_totals .cart_shipping").innerHTML = '$' + objectStepThree.quantity;
				document.querySelector(".cart_totals .cart_sales").innerHTML = objectStepThree.sale + '%';
				document.querySelector(".cart_totals .cart_total").innerHTML = '$' + (objectStepThree.price + objectStepThree.quantity - (objectStepThree.price*objectStepThree.sale)/100).toFixed();
				objectStepThree.total = (objectStepThree.price + objectStepThree.quantity - (objectStepThree.sale*objectStepThree.price)/100).toFixed();
				objectStepThree.total = parseInt(objectStepThree.total);
				step.step_three = objectStepThree;
			} else {
				$('.steps ul li:nth-child(3) a img').attr('src','../resources/images/step-4.png');
				$('.actions ul').removeClass('step-4');
			}
			return true;
		},
		onFinished: function (event, currentIndex) {
			console.log(step);
			fetch("/orders/check-out", {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json; charset=UTF-8',
				},
				body: JSON.stringify(step),
			}).then(response => {
				if(response.status === 200) {
					alert("Đặt hàng thành công!!");
					if(customer !== undefined) {
						clearLocalStorageByUsername();
					}
					window.location.replace("/home");
				} else {
					alert("Đặt hàng thất bại!!");
					window.location.replace("/home");
				}

			})
			/*						.then(data => {
                                        console.log(data);
                                        if(data == 1) {
                                            if(customer !== undefined) {
                                                clearLocalStorageByUsername();
                                            }
                                            alert("Đặt hàng thành công!!");
                                            window.location.replace("/myspring/home");
                                        } else {
                                            alert("Đặt hàng thất bại!!");
                                            window.location.replace("/myspring/home");
                                        }
                                    });*/
		}
	});
	// Custom Button Jquery Steps
	$('.forward').click(function(){
		$("#wizard").steps('next');
	})
	$('.backward').click(function(){
		$("#wizard").steps('previous');
	})
	// Create Steps Image
	$('.steps ul li:first-child').append('<img src="../resources/images/step-arrow.png" alt="" class="step-arrow">').find('a').append('<img src="../resources/images/step-1-active.png" alt=""> ').append('<span class="step-order">Step 01</span>');
	$('.steps ul li:nth-child(2)').append('<img src="../resources/images/step-arrow.png" alt="" class="step-arrow">').find('a').append('<img src="../resources/images/step-3.png" alt="">').append('<span class="step-order">Step 02</span>');
	$('.steps ul li:last-child a').append('<img src="../resources/images/step-4.png" alt="">').append('<span class="step-order">Step 03</span>');
});

const params = new Proxy(new URLSearchParams(window.location.search), {
	get: (searchParams, prop) => searchParams.get(prop),
});

let step = {
    "step_one": {

    },
    "step_two": [
	
	],
    "step_three": {
        
    }
};

function getAllProductInLocalStorage() {
	var values = [];
	var keys = Object.keys(localStorage);
	for(var k of keys) {
		if(localStorage.getItem(k) == customer.username) {
			values[values.length++] = {
				"key": k,
				"value": localStorage.getItem(k),
				"quantity": 1
			}
		}
	}
	return values;
}

function clearLocalStorageByUsername() {
	var keys = Object.keys(localStorage);

	for(var k of keys) {
		if(localStorage.getItem(k) == customer.username) {
			localStorage.removeItem(k);
		}
	}
}
function deleteProduct(element) {
    element.parentElement.parentElement.remove();
}

function quantityPlus(element, price, index) {
	var quantity = parseInt(element.parentElement.children[1].value);
	quantity = quantity < 10 ? quantity + 1 : quantity;
	element.parentElement.children[1].value = quantity;
	element.parentElement.parentElement.parentElement.children[3].children[0].children[0].innerHTML = (quantity*price) + '$';
	if(customer === undefined) {
		product.quantity  = quantity;
		product.totalPrice = (quantity*price);
	} else {
		listProduct[index].quantity = quantity;
		listProduct[index].totalPrice = quantity*price;
	}
}

function quantityMinus(element, price, index) {
	var quantity = parseInt(element.parentElement.children[1].value);
	quantity = quantity > 1 ? quantity - 1 : quantity;
	element.parentElement.children[1].value = quantity;
	element.parentElement.parentElement.parentElement.children[3].children[0].children[0].innerHTML = (quantity*price) + '$';
	if(customer === undefined) {
		product.quantity  = quantity;
		product.totalPrice = (quantity*price);
	} else {
		listProduct[index].quantity = quantity;
		listProduct[index].totalPrice = quantity*price;
	}
}

function update(data) {
	var dataHTML = '';
	var index = 0;
	for(var d of data) {
		dataHTML += "<tr>\r\n"
					+ "	                                <td class=\"product-thumb\">\r\n"
					+ "	                                    <a href=\"#\" class=\"item-thumb\">\r\n"
					+ "	                                        <img src=\""+ d.image +"\" >\r\n"
					+ "	                                    </a>\r\n"
					+ "	                                </td>\r\n"
					+ "	                                <td class=\"product-detail\" data-title=\"Product Detail\">\r\n"
					+ "	                                    <div style=\"margin-left: 24px\">\r\n"
					+ "	                                        <a href=\"#\">"+ d.name +"</a>\r\n"
					+ "	                                        <span>$ "+ d.price +"</span>\r\n"
					+ "	                                    </div>\r\n"
					+ "	                                </td>\r\n"
					+ "	                                <td class=\"product-quantity\" data-title=\"Quantity\">\r\n"
					+ "	                                    <div class=\"quantity\">\r\n"
					+ "	                                    	<span class=\"plus\" onclick = \"quantityPlus(this, "+ (d.price).toFixed() +", "+ index +")\">+</span>\r\n"
					+ "	                                        <input type=\"number\" id=\"quantity_index\" class=\"input-text qty text\" step=\"1\" min=\"0\" max=\"\" name=\"cart[5934c1ec0cd31e12bd9084d106bc2e32][qty]\" value=\""+ d.quantity +"\" title=\"Qty\" size=\"4\" pattern=\"[0-9]*\" inputmode=\"numeric\" />\r\n"
					+ "	                                    	<span class=\"minus\" onclick = \"quantityMinus(this, "+ (d.price).toFixed() +", "+ index +")\">-</span>\r\n"
					+ "	                                    </div>\r\n"
					+ "	                                </td>\r\n"
					+ "	                                <td class=\"total-price\" data-title=\"Total Price\">\r\n"
					+ "	                                    <span class=\"woocommerce-Price-amount amount\">\r\n"
					+ "	                                        <span class=\"woocommerce-Price-currencySymbol\">$ "+ d.totalPrice +"</span>\r\n"
					+ "	                                    </span>\r\n"
					+ "	                                </td>\r\n"
					+ "	                            </tr>";
					index++;
	}
	document.querySelector(".list-product table tbody").innerHTML = dataHTML;
}

let listProduct = null;



