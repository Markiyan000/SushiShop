let renderTotalSumToHTML = (sum) => {
    document.getElementById('totalSum').insertAdjacentHTML('beforeend', `All Total: ${sum} $`);
};