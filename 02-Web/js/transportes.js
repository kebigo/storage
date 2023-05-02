import { boton, parametros } from "./buscador.js";
import { obtenerFiltros } from "./filtros.js";

var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function () {
    if (this.readyState === XMLHttpRequest.DONE && this.status == 200) {
        cargarXML(this);

    }
};

var lista;

xhr.open("GET", "./xml/transportes.xml", true);
xhr.send();

let todosLosFiltros = "";
function cargarXML(xml) {

    let filtros = "";
    let todosLosFiltros = "and (@type='avion' or @type='autobus' or @type='tren')";

    const btnFiltros = document.querySelector(".filters .info-button")

    btnFiltros.addEventListener("click", e=>{
        let filterTipo= "";
        let  filterInstalaciones= "";
     
          filtros = obtenerFiltros();

          console.log(filtros)
     
         const todosVacios = filtros.every(arr => arr.length === 0);
         if (!todosVacios) {
     
           //Filtrar por tipo de alojamiento
           console.log(filtros[0])
           filtros[0].forEach(e =>{
             
             filterTipo += "@type="+"'"+e+"'";
             filterTipo =  filterTipo + " or ";
     
           })
     
           filterTipo = filterTipo.slice(0, -4);
           filterTipo = "and (" + filterTipo + ")"
     
           //Filtrar por instalaciones
           filtros[1].forEach(e =>{
             filterInstalaciones = "//alojamiento[instalaciones/" +piscina + "= 'true']"
           })

           console.log(filterTipo)
           
         }else{
           console.log("Selecciona un filtro")
         }
     
        
         todosLosFiltros = filterTipo;
         let ciudad = "'"+parametros[0]+"'";
     
         cargarcontenido(ciudad)

    })

    boton.addEventListener("click", e => {
        let ciudad = "'" + parametros[0] + "'";
        cargarcontenido(ciudad)
    })

    cargarcontenido("'" + "Barcelona, ES" + "'");

}


function cargarcontenido(destino) {




    //Listar las cards
    var docXML = xhr.responseXML;

    // Utilizar XPath para seleccionar los nodos de transporte con destino correspondiente
    lista = docXML.evaluate("//transporte[destino=" + destino + todosLosFiltros + "]", docXML, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);


    document.querySelector(".content .transportes").innerHTML = "";

    for (let i = 0; i < lista.snapshotLength; i++) {
        //Crear nueva card
        const nuevaCard = document.createElement("article");
        nuevaCard.classList.add("transporte", "p-4", "d-none", "px-lg-3", "px-xl-4", "d-flex", "flex-column", "flex-md-row", "position-relative");



        //Crear hijos de las cards
        crearHijos(nuevaCard);



        nuevaCard.querySelector(".info-transporte .logo-compañia span").innerText = lista.snapshotItem(i).getElementsByTagName("compañia")[0].children[0].textContent;
        nuevaCard.querySelector(".info-salida h2").innerText = lista.snapshotItem(i).getElementsByTagName("salida")[0].children[1].textContent;
        nuevaCard.querySelector(".info-salida span").innerText = lista.snapshotItem(i).getElementsByTagName("salida")[0].children[0].textContent;
        nuevaCard.querySelector(".info-llegada h2").innerText = lista.snapshotItem(i).getElementsByTagName("llegada")[0].children[1].textContent;
        nuevaCard.querySelector(".info-trayecto span").innerText = lista.snapshotItem(i).getElementsByTagName("duracion")[0].textContent;
        nuevaCard.querySelector(".precio-transporte h5").innerText = lista.snapshotItem(i).getElementsByTagName("precio")[0].textContent;


        //Capturar destino y calcular su diminutivo
        let origen = "";
        if (destino.includes("Barcelona")) {
            origen = "BCN •"
        } else if (destino.includes("Praga")) {
            origen = "PRG •"
        } else if (destino.includes("Berlin")) {
            origen = "BER •"
        } else if (destino.includes("Roma")) {
            origen = "FCO •"
        } else if (destino.includes("Londres")) {
            origen = "LCY •"

        }



        nuevaCard.querySelector(".info-llegada span").innerText = origen + " " + lista.snapshotItem(i).getElementsByTagName("llegada")[0].children[0].textContent;


        //Obtener ruta de la imagen mediante el nombre
        let texto = "";
        const ruta = lista.snapshotItem(i).getElementsByTagName("nombre")[0].textContent.split(" ")
        ruta.forEach(e => {
            texto += e + "_";


        });

        texto = texto.slice(0, -1).toLowerCase();
        nuevaCard.querySelector(".logo-compañia img",nuevaCard).setAttribute("src", "./assets/img/logo_compañia/" + texto + ".png") ;


        document.querySelector(".content .transportes").appendChild(nuevaCard);
        paginacion();

    }

}


//Crear nuevas cards
function crearHijos(nuevaCard) {

    const info_tranporte = document.createElement("div");
    info_tranporte.classList.add("info-transporte", "col-12", "col-md-8", "d-flex");

    const logo_compañia = document.createElement("div");
    logo_compañia.classList.add("logo-compañia", "w-auto", "d-flex", "flex-column", "align-items-center");

    const img = document.createElement("img");
    const nombre_compañia = document.createElement("span")
    nombre_compañia.classList.add("mt-3", "ms-1", "fw-semibold");

    logo_compañia.appendChild(img);
    logo_compañia.appendChild(nombre_compañia);

    const info_salida = document.createElement("div");
    info_salida.classList.add("info-salida", "col", "ps-2", "ps-sm-4");

    const hora_salida = document.createElement("h2");
    hora_salida.classList.add("fs-5", "fw-bold");
    const origen = document.createElement("span");
    origen.classList.add("d-block")

    origen.insertBefore = "BIO"

    info_salida.appendChild(hora_salida);
    info_salida.appendChild(origen);

    const info_trayecto = document.createElement("div");
    info_trayecto.classList.add("info-trayecto", "col", "col-sm-5", "d-flex", "flex-column", "align-items-center");

    const duracion = document.createElement("span");
    const divider_horizontal = document.createElement("div");
    divider_horizontal.classList.add("divider-horizontal", "my-1");

    const tipo_trayecto = document.createElement("span");
    tipo_trayecto.textContent = "Directo"

    info_trayecto.appendChild(duracion);
    info_trayecto.appendChild(divider_horizontal);
    info_trayecto.appendChild(tipo_trayecto);

    const info_llegada = document.createElement("div");
    info_llegada.classList.add("info-llegada", "col", "d-flex", "flex-column", "align-items-end", "pe-md-2");

    const hora_llegada = document.createElement("h2");
    hora_llegada.classList.add("fs-5", "fw-bold");

    const destino = document.createElement("span");
    destino.classList.add("d-block");

    info_llegada.appendChild(hora_llegada);
    info_llegada.appendChild(destino);

    const divider_vertical = document.createElement("div");
    divider_vertical.classList.add("divider-vertical", "d-none", "d-md-block", "position-absolute");

    const divider_horizontal2 = document.createElement("div");
    divider_horizontal2.classList.add("divider-horizontal", "mt-4", "d-md-none");


    const precio_transporte = document.createElement("div");
    precio_transporte.classList.add("precio-transporte", "w-100", "d-flex", "flex-md-column", "justify-content-end", "align-items-center", "align-items-md-end", "mt-4", "mt-md-0");

    const icono = document.createElement("i");
    icono.classList.add("fa-solid", "fa-credit-card", "fs-3", "mb-md-4", "col", "sub-title");

    const precio = document.createElement("h5");
    precio.classList.add("fs-3", "title", "me-3", "me-md-0")

    const texto = document.createElement("span");
    texto.classList.add("d-block", "fw-semibold", "text-end", "mt-2", "mb-3", "d-none", "d-md-block");
    texto.textContent = "Precio por pasajero unico";

    const boton = document.createElement("a");
    boton.classList.add("col-6", "mt-md-4", "d-block", "info-button", "w-auto", "text-center", "py-2", "px-4", "px-xl-5", "text-decoration-none", "text-white", "text-center", "rounded-pill")
    boton.textContent = "Reservar";

    precio_transporte.appendChild(icono)
    precio_transporte.appendChild(precio)
    precio_transporte.appendChild(texto)
    precio_transporte.appendChild(boton)

    info_tranporte.appendChild(logo_compañia);
    info_tranporte.appendChild(info_salida);
    info_tranporte.appendChild(info_trayecto);
    info_tranporte.appendChild(info_llegada);


    nuevaCard.appendChild(info_tranporte)
    nuevaCard.appendChild(divider_vertical);
    nuevaCard.appendChild(divider_horizontal2);
    nuevaCard.appendChild(precio_transporte);


}

//Paginacion
function paginacion() {
    const cards = document.querySelectorAll('.transporte');
    const arrayCards = Array.from(cards);



    const primeraPagina = arrayCards.slice(0, 4);
    primeraPagina.forEach(card => {
        card.classList.add("visible");
    })

    function mostrarPagina(numPagina) {
        const inicio = (numPagina - 1) * 4;
        const fin = inicio + 4;
        const pagina = arrayCards.slice(inicio, fin);

        arrayCards.forEach(card => {
            card.classList.remove('visible')
        });

        pagina.forEach(card => {
            card.classList.add('visible')
        })

    }

    const paginacion = document.getElementById('listPage');
    const botonera = document.createElement('ul');

    while (paginacion.firstChild) {
        paginacion.removeChild(paginacion.firstChild);
    }

    // Agregar los nuevos elementos de paginación
    for (let i = 1; i <= Math.ceil(arrayCards.length / 4); i++) {
        const boton = document.createElement('li');
        boton.innerHTML = i;
        boton.addEventListener('click', () => mostrarPagina(i));
        paginacion.appendChild(boton);
    }
}