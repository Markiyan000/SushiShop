let getChosenValueFromRadio = (name) => {
    let radioButtons = document.getElementsByName(name);
    for(let elem of radioButtons) {
        if (elem.checked) {
            return elem.value;
            break;
        }
    }
};