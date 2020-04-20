let renderListToHTML = async (jsonList, name, isFullList) => {
    const listDiv = document.querySelector('.row');
    await jsonList.then((data) => {
        const result = listTemplate(data, name);
        clearElementsBeforeInserting();
        if (isFullList) {
            document.getElementById('searchDiv').insertAdjacentHTML('beforeend', searchTemplate(name));
            document.getElementById('sortDiv').insertAdjacentHTML('beforeend', sortTemplate(name));
        }
        listDiv.insertAdjacentHTML('beforeend', result);
    });
};