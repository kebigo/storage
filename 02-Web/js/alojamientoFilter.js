const inputRange = document.querySelectorAll(".input-range input");
progress = document.querySelector(".slider .progress");
rangeText = document.querySelector(".range-text");

var minVal, maxVal;

minVal = parseInt(inputRange[0].value),
maxVal = parseInt(inputRange[1].value);

rangeText.innerHTML = "<span>Rango: <strong>" + minVal + "€</strong> - <strong>" + maxVal + "€</strong></span>";


inputRange.forEach(input => {
    input.addEventListener("input", ()=>{
        minVal = parseInt(inputRange[0].value),
        maxVal = parseInt(inputRange[1].value);

        
        progress.style.left = (minVal / inputRange[0].max) *100 + "%";
        progress.style.right = 100 - (maxVal / inputRange[1].max) *100 + "%";

        rangeText.innerHTML = "<span>Rango: <strong>" + minVal + "€</strong> - <strong>" + maxVal + "€</strong></span>";

    })
});

