let showList = async (name) => {
    const response = await fetch(`http://localhost:3000/api/${name}`, {
        method: 'GET'
    });
    const resultInJson = response.json();
    const div = document.querySelector('.row');
    await resultInJson.then((data) => {
        const result = listTemplate(data);
        div.innerHTML = "";
        div.insertAdjacentHTML('beforeend', result);
    });
};

let listTemplate = (list) => {
    let result = '';
    for (let i = 0; i < list.length; i++) {
        result += ` 
        <div class="product-card cell-xs-12 cell-sm-6 cell-lg-4 cell-xl-fifth">
            <div class="card-inner">
                <div class="product-photo">
                    <a  title=${list[i].name} class="product-link with-object-fit">
                        <img src=${list[i].image} alt="" title="" class="product-image">
                    </a>
                    <div class="product-labels labels-list">
                        <span class="js-label-discount"></span>
                    </div>
                </div>
                <div class="product-caption">
                    <div class="product-title">
                        <a href="/product/set-segun" class="product-link">
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