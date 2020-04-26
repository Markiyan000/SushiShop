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

let showCart = async () => {
    const response = await fetch('http://localhost:3000/api/cart', {
        method: 'GET'
    });
    await renderCartToHTML(response.json());
};

let deleteItem = async (id) => {
    await fetch(`http://localhost:3000/api/cart/${id}`, {
        method: 'DELETE'
    });
    await showCart();
};

let clearCart = async () => {
    await fetch(`http://localhost:3000/api/cart/`, {
        method: 'DELETE'
    });
    await showCart();
};