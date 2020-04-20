let searchTemplate = (name) => {
  return `
        <form action="" id="searchForm">  
             <input type="search" id="searchInput">
             <button onclick="showFoundItemsByName('${name}')">
                   <i class="fa fa-search"></i>
             </button>
        </form>
  `;
};