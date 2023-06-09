import { boton } from "./buscador.js";


//Inicio filtros top
const checkbox = document.querySelectorAll(".tipo-viaje input[type=checkbox]");


checkbox.forEach(e => {
    e.addEventListener("click", () => {
        checkbox.forEach((e) => {
            e.checked = false;
        })

        e.checked = true;
    })

})

//Inicio filtro busqueda
const filters = document.querySelectorAll(".boton-filtros-main");

filters.forEach(e => {
    e.addEventListener("click", () => {
        document.querySelector(".boton-active").classList.remove("boton-active");

        e.classList.add("boton-active");
    })
})


//Inicio filtro precio
const inputRange = document.querySelectorAll(".input-range input");
const progress = document.querySelectorAll(".slider .progress");
const rangeText = document.querySelectorAll(".range-text");

const inputRangeMax = parseInt(inputRange[0].max);

var minVal, maxVal;
var mediaQuery = window.matchMedia("(min-width: 992px)")


minVal = parseInt(inputRange[0].value),
    maxVal = parseInt(inputRange[1].value);


rangeText.forEach(rangeText => {
    rangeText.innerHTML = "<span>Rango: <strong>" + minVal + "€</strong> - <strong>" + maxVal + "€</strong></span>";

})

inputRange.forEach(input => {

    input.addEventListener("input", () => {

        if (mediaQuery.matches) {

            minVal = parseInt(inputRange[2].value),
                maxVal = parseInt(inputRange[3].value);

            progress.forEach(progress => {
                progress.style.left = (minVal / inputRange[2].max) * 100 + "%";
                progress.style.right = 100 - (maxVal / inputRange[3].max) * 100 + "%";
            })


        } else {

            minVal = parseInt(inputRange[0].value),
                maxVal = parseInt(inputRange[1].value);

            progress.forEach(progress => {
                progress.style.left = (minVal / inputRange[0].max) * 100 + "%";
                progress.style.right = 100 - (maxVal / inputRange[1].max) * 100 + "%";
            })
        }

        rangeText.forEach(rangeText => {
            rangeText.innerHTML = "<span>Rango: <strong>" + minVal + "€</strong> - <strong>" + maxVal + "€</strong></span>";

        })
    })
});



export function obtenerFiltros() {
    const elementosFiltros = document.querySelectorAll(".filters label input");
    const filtros = [];
    const filtroTipo = [];
    const filtroInstalaciones = [];
    const filtroPuntuacion = [];
    const filtroTipoT = [];
    const filtroCategoria = [];
    const filtroPuntuacionT = [];

    let paginaActual = window.location.href;

  

    elementosFiltros.forEach(e => {
        if(paginaActual.includes("alojamiento")){
            if (e.checked == true) {
                if (e.classList.contains("tipo")) {
                    filtroTipo.push(e.value);
                } else if (e.classList.contains("instalaciones")) {
                    filtroInstalaciones.push(e.value);
                } else if (e.classList.contains("puntuacion")) {
                    filtroPuntuacion.push(e.value);
                }
            }

            filtros.push(filtroTipo, filtroInstalaciones, filtroPuntuacion);


        }else{
            if (e.checked == true) {
                if (e.classList.contains("tipoT")) {
                    filtroTipoT.push(e.value);
                } else if (e.classList.contains("categoria")) {
                    filtroCategoria.push(e.value);
                } else if (e.classList.contains("puntuacionT")) {
                    filtroPuntuacionT.push(e.value);
                }

                filtros.push(filtroTipoT, filtroCategoria, filtroPuntuacionT);

            }
        }
        

    })

    return filtros;

}




//Añadir el tipo