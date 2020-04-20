let showList = async (name) => {
    const response = await fetch(`http://localhost:3000/api/${name}`, {
        method: 'GET'
    });
    await renderListToHTML(response.json(), name, true);
};

let showOneItem = async(id, name) => {
    const response = await fetch(`http://localhost:3000/api/${name}/${id}`, {
        method: 'GET'
    });
    await renderItemToHTML(response.json(), name);
};

let showFoundItemsByName = async (name) => {
    const formData = document.getElementById('searchInput').value;
    const response = await fetch(`http://localhost:3000/api/${name}?searchName=${formData}`, {
        method: 'GET'
    });
    await renderListToHTML(response.json(), name, false);
};

let showSortedList = async (name) => {
    let sortBy = getChosenValueFromRadio('sortBy');
    const response = await fetch(`http://localhost:3000/api/${name}?sortBy=${sortBy}`, {
        method: 'GET'
    });
    await renderListToHTML(response.json(), name, false);
};

let showByType = async (name, type) => {
    const response = await fetch(`http://localhost:3000/api/${name}?searchType=${type}`, {
        method: 'GET'
    });
    await renderListToHTML(response.json(), name, false);
};





