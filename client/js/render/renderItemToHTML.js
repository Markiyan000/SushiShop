let renderItemToHTML = async (itemJson, name) => {
    const div = document.getElementById('productItem');
    await itemJson.then((data) => {
        const result = itemTemplate(data, name);
        clearElementsBeforeInserting();
        div.insertAdjacentHTML('beforeend', result);
    });
};