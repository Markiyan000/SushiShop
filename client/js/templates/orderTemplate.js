let orderTemplate = () => {
  return `
     <form id="orderForm">
            <div class="first">
                <fieldset>
                    <legend><span class="number">1</span> User Info</legend>
                    <input type="text" name="name" placeholder="Enter name...">
                    <input type="text" name="surname" placeholder="Enter surname...">
                    <input type="text" name="email" placeholder="Enter email...">
                </fieldset>
            </div>
            <button type="button" class="submit" onclick="makeOrder()">Submit</button>
    </form>
  `;
};