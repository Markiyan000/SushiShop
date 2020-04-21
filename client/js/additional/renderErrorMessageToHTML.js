let renderErrorMessageToHTML = (message) => {
    document.getElementById('errorDiv').insertAdjacentHTML('beforeend', errorTemplate(message));
};