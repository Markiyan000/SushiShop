let cartTemplate = (cart) => {
    let result = `
         <tr>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
    `;
    for(let i = 0; i < cart.length; i++) {
        result += `
            <tr>
                <td>${cart[i].name}</td>
                <td>${cart[i].quantity}</td>
                <td>${cart[i].price} $</td>
                <td><button type="button" class="submit" onclick="deleteItem(${cart[i].id})">Delete</button></td>
            </tr>
        `;
    }
    result += "<button type='button' class='submit' onclick='clearCart()'>Clear All</button>"
    return result;
};