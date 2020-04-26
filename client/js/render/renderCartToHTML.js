let renderCartToHTML = async (cartJson) => {
    const table = document.getElementById('table_blur');
    await cartJson.then((data) => {
        clearElementsBeforeInserting();
        if(data.length > 0) {
            renderTotalSumToHTML(calcTotalSum(data));
            const result = cartTemplate(data);
            table.insertAdjacentHTML('beforeend', result);
        } else {
            renderErrorMessageToHTML('Empty Cart!');
        }
    });
};