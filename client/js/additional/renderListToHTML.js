let renderListToHTML = async (jsonList, name, isFullList) => {
    const div = document.querySelector('.row');
    await jsonList.then((data) => {
        const result = isFullList ? filterTemplate(name) + listTemplate(data, name) : listTemplate(data, name);
        clearElementsBeforeInserting();
        div.insertAdjacentHTML('beforeend', result);
    });
};