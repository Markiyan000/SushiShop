let sortTemplate = (name) => {
  return `
        Sort By<br>
        <input type="radio" name="sortBy" value="price" checked>Price<br>
        <input type="radio" name="sortBy" value="weight">Weight<br> 
        <input type="radio" name="sortBy" value="name">Name<br>
        <button type="button" id="submitSort" onclick="showSortedList('${name}')">Submit</button>
  `;
};