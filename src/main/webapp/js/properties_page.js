 (function renderPriceAndLocation(){
    const buyButton = document.querySelector('button');
    const propertyLocation = document.querySelector('.ziwani-location');
    const propertyPrice = document.querySelector('.ziwani-price');

    //const convertedLocation = Array.from(propertyLocation);

    // buyButton.addEventListener("click",function(event){
    //     console.log(event)
    //     console.log('clicked');
    //     window.location.href = 'http://127.0.0.1:5500/src/main/webapp/buy/buy.html'
    // })

    // convertedLocation.forEach(
    //     (location) =>{
    //         console.log(location.textContent);
    //     }
    // );
    const price = propertyPrice.textContent;
    const location = propertyLocation.textContent;

    localStorage.setItem('propertyLocation',location);
    localStorage.setItem('propertyPrice',price)

    //console.log();
   // console.log(location);

})();