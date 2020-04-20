let listTemplate = (list, name) => {
    let result = '';
    for (let i = 0; i < list.length; i++) {
        result += `
        <div class="product-card cell-xs-12 cell-sm-6 cell-lg-4 cell-xl-fifth">
            <div class="card-inner">
                <div class="product-photo">
                    <a title=${list[i].name} class="product-link with-object-fit">
                        <img src="http://localhost:63343/SushiShop/client/images/${list[i].image}" onclick="showOneItem(${list[i].id}, '${name}')" class="product-image" alt="">
                    </a>
                    <div class="product-labels labels-list">
                        <span class="js-label-discount"></span>
                    </div>
                </div>
                <div class="product-caption">
                    <div class="product-title">
                        <a class="product-link">
                            ${list[i].name}
                        </a>
                    </div>
                    <div class="product-introtext"><small><p><span>${list[i].description}</span></p></small></div>
                    <div id="productPrice">${list[i].price} $</div>
                </div>
            </div>
        </div>`;
    }
    return result;
};