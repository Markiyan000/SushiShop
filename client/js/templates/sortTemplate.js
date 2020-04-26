let sortTemplate = (name) => {
  return `
        Sort By<br>
        <input type="radio" name="sortBy" value="price" checked>Price<br>
        <input type="radio" name="sortBy" value="weight">Weight<br> 
        <input type="radio" name="sortBy" value="name">Name<br>
        <button type="button" class="submit" onclick="showSortedList('${name}')">Submit</button>
  `;
};