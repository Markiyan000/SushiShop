let renderCartToHTML = async (cartJson) => {
    const table = document.getElementById('table_blur');
    await cartJson.then((data) => {
        clearElementsBeforeInserting();
        renderTotalSumToHTML(calcTotalSum(data));
        const result = cartTemplate(data);
        table.insertAdjacentHTML('beforeend', result);
    });
};