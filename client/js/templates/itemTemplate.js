let itemTemplate = (item, name) => {
    let result = `
    <div>
          <img src="http://localhost:63343/SushiShop/client/images/${item.image}" alt="" title="${item.name}" class="product-image">
          <div class="product-title on-page"><h1 class="js-product-title">${item.name}</h1></div>
          <div class="product-introtext on-page">
                <p>
                    <span>${item.description}</span><br>
                    Weight: <span>${item.weight} g.</span>
                </p>
          </div>
          <div class="product-prices on-page">
                <div class="price js-product-price">${item.price} $</div>
          </div>
          <div class="buy cell-xl-4 cell-lg-6 cell-sm-4 cell-xs-12">
                <div class="product-order-variant js-variant-available">
                    <button class="button button-buy button-primary" type="submit" data-item-add>
                         <i class="icon button-icon buy-icon ion-ios-cart-outline"></i>
                         <span class="button-text">Add To Cart</span>
                    </button>
                </div>
          </div>
          <br><br>
    </div>
    `;
    if(name === 'sets') {
        result += `
           <div class="tabs-list product-tabs-list" id="ingredientsDiv">
                <div id="product-characteristics" class="tab-block active ">
                        <div class="editor with-styled-table">
                                <table class="table properties-table table-bordered table-striped table-hover">
                                     <tr>
                                        <td>Weight</td>
                                        <td><span class="property-value">${item.weight}</span> </td>
                                    </tr>
                                    <tr>
                                        <td>Composition</td>
                                        <td><span class="property-value">${item.ingredients}</span></td>
                                    </tr>
                                </table>
                        </div>
                </div>
           </div>
  
        `;
    }
    return result;
};