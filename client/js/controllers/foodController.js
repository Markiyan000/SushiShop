let showList = async (name) => {
    const response = await fetch(`http://localhost:3000/api/${name}`, {
        method: 'GET'
    });
    const resultInJson = response.json();
    const div = document.querySelector('.row');
    await resultInJson.then((data) => {
        const result = filterTemplate(name) + listTemplate(data, name);
        clearElementsBeforeInserting();
        div.insertAdjacentHTML('beforeend', result);
    });
};

let showOneItem = async(id, name) => {
    const response = await fetch(`http://localhost:3000/api/${name}/${id}`, {
        method: 'GET'
    });
    const resultInJson = response.json();
    const div = document.getElementById('productItem');
    await resultInJson.then((data) => {
        const result = itemTemplate(data, name);
        clearElementsBeforeInserting();
        div.insertAdjacentHTML('beforeend', result);
    });
};

let showFoundItemsByName = async (name) => {
    const formData = document.getElementById('searchInput').value;
    const response = await fetch(`http://localhost:3000/api/${name}?searchName=${formData}`, {
        method: 'GET'
    });
    const resultInJson = response.json();
    const div = document.querySelector('.row');
    await resultInJson.then((data) => {
        const result = listTemplate(data, name);
        clearElementsBeforeInserting();
        div.insertAdjacentHTML('beforeend', result);
    });
};

let showSortedList = async (name) => {
    let radioButtons = document.getElementsByName('sortBy');
    let sortBy;
    for(let elem of radioButtons) {
        if (elem.checked) {
            sortBy = elem.value;
            break;
        }
    }
    const response = await fetch(`http://localhost:3000/api/${name}?sortBy=${sortBy}`, {
        method: 'GET'
    });
    const resultInJson = response.json();
    const div = document.querySelector('.row');
    await resultInJson.then((data) => {
        const result = listTemplate(data, name);
        clearElementsBeforeInserting();
        div.insertAdjacentHTML('beforeend', result);
    });
};

let itemTemplate = (item, name) => {
    let result = `
    <div>
          <img src="http://localhost:63342/SushiShop/client/images/${item.image}" alt="" title="${item.name}" class="product-image">
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
           <div class="tabs-list product-tabs-list">
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

let listTemplate = (list, name) => {
    let result = '';
    for (let i = 0; i < list.length; i++) {
        result += `
        <div class="product-card cell-xs-12 cell-sm-6 cell-lg-4 cell-xl-fifth">
            <div class="card-inner">
                <div class="product-photo">
                    <a title=${list[i].name} class="product-link with-object-fit">
                        <img src="http://localhost:63342/SushiShop/client/images/${list[i].image}" onclick="showOneItem(${list[i].id}, '${name}')" class="product-image" alt="">
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
                </div>
            </div>
        </div>`;
    }
    return result;
};

let filterTemplate = (name) => {
    return `
     <div id="searchDiv"> 
            <form action="" id="searchForm">  
                <input type="search" id="searchInput">
                <button onclick="showFoundItemsByName('${name}')">
                    <i class="fa fa-search"></i>
                </button>
            </form>
     </div>
     <div id="sortDiv">
        <input type="radio" name="sortBy" value="price">Price<br>
        <input type="radio" name="sortBy" value="weight">Weight<br> 
        <input type="radio" name="sortBy" value="name">Name<br>
        <button type="button" onclick="showSortedList('${name}')">Submit </button><br> 
     </div>`;
};

let clearElementsBeforeInserting = () => {
    document.querySelector('.row').innerHTML = "";
    document.getElementById('productItem').innerHTML = "";
};





