
////////////////////////////////////////////////////////////
//lay 8 dien thoai gia cao nhat
fetch("/phone-tab/phone/get-by?count=8&type=desc", {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(data => {
	updateHome(document.querySelector("#phone .list_products ul"), data);
});

function updateHome(element, data) {
	let dataHTML = "";
	for(let d of data) {
		dataHTML += "<li>\r\n"
					+ "              <div class=\"product__header\">\r\n"
					+ "                <img src=\""+ d.image +"\" alt=\"product\">\r\n"
					+ "              </div>\r\n"
					+ "              <div class=\"product__footer\">\r\n"
					+ "                <h3>"+ d.name +"</h3>\r\n"
					+ "                <div class=\"rating\">\r\n"
					+ "                  <svg>\r\n"
					+ "                    <use xlink:href=../resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "                  </svg>\r\n"
					+ "                  <svg>\r\n"
					+ "                    <use xlink:href=../resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "                  </svg>\r\n"
					+ "                  <svg>\r\n"
					+ "                    <use xlink:href=../resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "                  </svg>\r\n"
					+ "                  <svg>\r\n"
					+ "                    <use xlink:href=../resources/images/sprite.svg#icon-star-full\" />\"></use>\r\n"
					+ "                  </svg>\r\n"
					+ "                  <svg>\r\n"
					+ "                    <use xlink:href=../resources/images/sprite.svg#icon-star-empty\" />\"></use>\r\n"
					+ "                  </svg>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"product__price\">\r\n"
					+ "                  <h4>"+ d.price +"$</h4>\r\n"
					+ "                </div>\r\n"
					+ "                <a href=\"/home/product-detail?code="+ d.code +"\"><button type=\"submit\" class=\"product__btn\">Watch Now</button></a>\r\n"
					+ "              </div>\r\n"
					+ "            </li>";
	}
	element.innerHTML += dataHTML;
}

////////////////////////////////////////////////////////
//lay 8 laptop gia cao nhat
fetch("/laptop/item/get-by?count=8&type=desc", {
    method: 'GET',
}).then(resp => {
    if(resp.status === 200) {
        return resp.json();
    }
}).then(data => {
	updateHome(document.querySelector("#laptop .list_products ul"), data);
});