let filterTemplate = (name) => {
    return `
     <div id="searchDiv"> 
            <form action="" id="searchForm">  
                <input type="search" id="searchInput">
                <button onclick="showFoundItemsByName('${name}')">
                    <i class="fa fa-search"></i>
                </button>
            </form>
     </div>
     <div id="sortDiv">
        <input type="radio" name="sortBy" value="price">Price<br>
        <input type="radio" name="sortBy" value="weight">Weight<br> 
        <input type="radio" name="sortBy" value="name">Name<br>
        <button type="button" onclick="showSortedList('${name}')">Submit </button><br> 
     </div>`;
};