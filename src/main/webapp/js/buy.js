(function fetchPriceAndLocation(){
    const buyPrice = document.querySelector('.price');
    const buyLocation = document.querySelector('.location');

    const price = localStorage.getItem('propertyPrice');
    const location = localStorage.getItem('propertyLocation');

    buyPrice.value = price;
    buyLocation.value = location;
})();

function clearLocalStorage(){
    return localStorage.clear()
}

setTimeout(clearLocalStorage, 500);

clearLocalStorage();