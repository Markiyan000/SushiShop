let addToCart = async (name, price) => {
    let quantity = +prompt('Please, enter quantity');
    const data = {
        name: name,
        quantity: quantity,
        price: price * quantity
    };
    await fetch(`http://localhost:3000/api/cart`, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    });
};