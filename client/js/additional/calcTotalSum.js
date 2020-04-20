let calcTotalSum = (cart) => {
    return cart.map(el => el.price).reduce((a, b) => a + b, 0);
};