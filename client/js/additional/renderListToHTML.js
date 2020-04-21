let renderListToHTML = async (jsonList, name, isFullList) => {
    const listDiv = document.querySelector('.row');
    await jsonList.then((data) => {
        clearElementsBeforeInserting();
        if(data.length > 0) {
            const result = listTemplate(data, name);
            if (isFullList) {
                document.getElementById('searchDiv').insertAdjacentHTML('beforeend', searchTemplate(name));
                document.getElementById('sortDiv').insertAdjacentHTML('beforeend', sortTemplate(name));
            }
            listDiv.insertAdjacentHTML('beforeend', result);
        }else {
            renderErrorMessageToHTML('Nothing found!');
        }
    });
};