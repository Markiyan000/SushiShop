let showOrderForm = () => {
    renderOrderFormToHTML();
};

let makeOrder = async () => {
    const formData = new FormData(document.getElementById('orderForm'));
    const user = {
        name: formData.get('name'),
        surname: formData.get('surname'),
        email: formData.get('email')
    };
    const response = await fetch(`http://localhost:3000/api/order`, {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    if (response.ok) {
        alert('Order is sent successfully!');
    } else {
        await response.json().then((data) => {
            const errors = Object.values(data).filter(e => e !== null);
            alert(errors);
        });
    }
};