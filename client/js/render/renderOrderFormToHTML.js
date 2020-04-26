let renderOrderFormToHTML = () => {
    clearElementsBeforeInserting();
    document.getElementById('orderDiv').insertAdjacentHTML('beforeend', orderTemplate());
};