import {boton, parametros} from "./buscador.js";
import { obtenerFiltros } from "./filtros.js";

var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function(){
    if(this.readyState === XMLHttpRequest.DONE && this.status == 200){
     cargarXML(this);
     
    }
};

var lista;

xhr.open("GET", "./xml/alojamiento.xml", true);
xhr.send();

function cargarXML(xml){


  let todosLosFiltros = "and (@type='hotel' or @type='camping' or @type='casa_rural' or @type='apartamento')";
  //Filtrar el contenido

  let filtros = [];
  
  const btnFiltros = document.querySelector(".filters .info-button");
  btnFiltros.addEventListener("click", ()=>{
    
    let filterTipo= "";
   let  filterInstalaciones= "";

     filtros = obtenerFiltros();


    const todosVacios = filtros.every(arr => arr.length === 0);
    if (!todosVacios) {

      //Filtrar por tipo de alojamiento
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
      
    }else{
      console.log("Selecciona un filtro")
    }

   
    todosLosFiltros = filterTipo;
    let ciudad = "'"+parametros[0]+"'";

    cargarcontenido(ciudad)

  })

  boton.addEventListener("click", ()=>{

    todosLosFiltros = "";
    let ciudad = "'"+parametros[0]+"'";
    cargarcontenido(ciudad);
    


  })

  cargarcontenido("'"+"Barcelona, ES"+"'")
  
  function cargarcontenido(ciudad) {


 

    //Listar las cards
    var docXML = xhr.responseXML;
    // Utilizar XPath para seleccionar los nodos de alojamiento con ciudad correspondiente
    lista = docXML.evaluate("//alojamiento[ciudad=" + ciudad + todosLosFiltros +"]" ,docXML,null,XPathResult.ORDERED_NODE_SNAPSHOT_TYPE,null);    
  
    document.querySelector(".alojamientos").innerHTML="";
     
    for (let i = 0; i < lista.snapshotLength; i++) {
      //Crear nueva card
      const nuevaCard = document.createElement("article");
      nuevaCard.classList.add("alojamiento" ,"p-4", "p-lg-3", "p-xl-4" ,"mb-5", "align-items-center", "justify-content-between" , "flex-wrap",  "flex-md-nowrap");


    
      //Crear hijos de las cards
      crearHijos(nuevaCard);
  

      //Insertar contenido dinamico
      nuevaCard.querySelector(".alojamiento-info .title", nuevaCard).innerText = lista.snapshotItem(i).getElementsByTagName("nombre")[0].textContent;
      nuevaCard.querySelector(".alojamiento-info .sub-title", nuevaCard).innerText = lista.snapshotItem(i).getElementsByTagName("ciudad")[0].textContent;
      nuevaCard.querySelector(".alojamiento-info .text", nuevaCard).innerText = lista.snapshotItem(i).getElementsByTagName("texto")[0].textContent;
      nuevaCard.querySelector(".alojamiento-extra .num span",nuevaCard).innerText = lista.snapshotItem(i).getElementsByTagName("puntuacion")[0].textContent;
      nuevaCard.querySelector(".puntuacion .num span",nuevaCard).innerText = lista.snapshotItem(i).getElementsByTagName("puntuacion")[0].textContent + "";
      nuevaCard.querySelector(".alojamiento-extra .title", nuevaCard).innerText = lista.snapshotItem(i).getElementsByTagName("precio")[0].textContent + "€";
      nuevaCard.querySelector(".alojamiento-extra .puntuacion-subtitle",nuevaCard).innerText =lista.snapshotItem(i).getElementsByTagName("comentarios")[0].textContent +" comentarios";
      var nuevoSpan = document.createElement("span");

    //  Asignar una clase y un contenido al span
    nuevoSpan.className = "sub-title fw-semibold fs-6";
    nuevoSpan.innerText = "/noche";

    // Agregar el span como hijo del elemento title
    nuevaCard.querySelector(".alojamiento-extra .title").appendChild(nuevoSpan);

      //Obtener ruta de la imagen mediante el nombre
      let texto = "";
      const ruta = lista.snapshotItem(i).getElementsByTagName("nombre")[0].textContent.split(" ")
      ruta.forEach(e => {
        texto += e + "_";
       
        
      });

    //Evaluar puntuacion
    let puntuacion = parseFloat(lista.snapshotItem(i).getElementsByTagName("puntuacion")[0].textContent);
    let puntuacionText = "";
    if(puntuacion >= 5 && puntuacion <= 6){
      puntuacionText = "Meh"
    }else if(puntuacion > 6 && puntuacion < 8){
      puntuacionText="Bien";
    }else if(puntuacion >= 8 && puntuacion <= 9){
      puntuacionText="Muy bien";

    }else if(puntuacion >= 9){
      puntuacionText="Excelente";

    }

    nuevaCard.querySelector(".alojamiento-extra .puntuacion-title",nuevaCard).innerText = puntuacionText;


      texto = texto.slice(0, -1).toLowerCase();
      nuevaCard.querySelector(".alojamiento-image img",nuevaCard).setAttribute("src", "./assets/img/alojamiento_main/" + texto + ".jpg") ;

      //Insertar enlace por id al boton
      nuevaCard.querySelector(".alojamiento-extra .info-button", nuevaCard).setAttribute("href", "query.html?id="+lista.snapshotItem(i).getAttribute("id"));
      


      

      document.querySelector(".alojamientos").appendChild(nuevaCard);
      paginacion();
    
    }

  }

  //Paginacion
  function paginacion(){
    const cards = document.querySelectorAll('.alojamiento');
    const arrayCards = Array.from(cards);


  
    const primeraPagina = arrayCards.slice(0, 4);
    primeraPagina.forEach(card =>{
      card.classList.add("visible");
    })
    
    function mostrarPagina(numPagina){
      const inicio = (numPagina - 1) * 4;
      const fin = inicio + 4;
      const pagina = arrayCards.slice(inicio, fin);
      
      arrayCards.forEach(card =>{
        card.classList.remove('visible')
      });
  
      pagina.forEach(card =>{
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
  

  

  
  //Crear nuevas cards
  function crearHijos(nuevaCard){
  //Alojamiento-image
  const alojamiento_image = document.createElement("div");
  alojamiento_image.classList.add("alojamiento-image", "col-12", "col-md-3", "me-4", "me-lg-5", "me-xl-4" , "me-xxl-0")
  const img = document.createElement("img");
  img.classList.add("object-fit-cover", "rounded")
  alojamiento_image.appendChild(img)

  //Puntuacion
  const puntuacion = document.createElement("div")
  puntuacion.classList.add("puntuacion", "d-flex" ,"justify-content-center",  "h-auto", "d-sm-none" , "ms-2",  "mt-4")
  const reviews = document.createElement("div");
  reviews.classList.add("reviews",  "col",  "ps-xxl-5");
  const puntuacion_title = document.createElement("h4");
  puntuacion_title.classList.add("puntuacion-title", "fw-bold");
 const  puntuacion_subtitle = document.createElement("h5");
  puntuacion_subtitle.classList.add("puntuacion-subtitle");

  reviews.appendChild(puntuacion_title);
  reviews.appendChild(puntuacion_subtitle);

  const num_col = document.createElement("div");
  num_col.classList.add("num",  "col");
  const card_review = document.createElement("span");
  card_review.classList.add("card-review",  "d-flex",  "align-items-center", "justify-content-center",  "text-white",  "fw-bold")

  num_col.appendChild(card_review);

  puntuacion.appendChild(reviews);
  puntuacion.appendChild(num_col);


  //Alojamiento info
  const alojamiento_info = document.createElement("div");
  alojamiento_info.classList.add("alojamiento-info" , "col-12",  "col-sm-7",  "col-md-6",  "ms-md-3" , "ms-xl-0",  "mt-4" , "mt-md-0");
  const titlee = document.createElement("h2");
  titlee.classList.add("title",  "fw-semibold",  "fs-3");
  const sub_titlee = document.createElement("span");
  sub_titlee.classList.add("sub-title",  "fw-bold");
  const text = document.createElement("p");
  text.classList.add("text" , "mt-2",  "pe-md-5");

  alojamiento_info.appendChild(titlee);
  alojamiento_info.appendChild(sub_titlee);
  alojamiento_info.appendChild(text);



  //Alojamiento extra
  const alojamiento_extra = document.createElement("div");
  alojamiento_extra.classList.add("alojamiento-extra",  "col-12",  "col-sm-3",  "col-md",  "d-flex",  "flex-column",  "pt-4",  "pt-md-0")
  const puntuacion2 = document.createElement("div");
  puntuacion2.classList.add("puntuacion",  "d-flex",  "justify-content-center",  "h-auto",  "d-none",  "d-sm-flex");
  const reviews2 = document.createElement("div");
  reviews2.classList.add("reviews",  "col-10",  "ps-xxl-5");
  const puntuacion_title2 = document.createElement("h4");
  puntuacion_title2.classList.add("puntuacion-title",  "fw-bold");
  const puntuacion_subtitle2 = document.createElement("h5");
  puntuacion_subtitle2.classList.add("puntuacion-subtitle");

  reviews2.appendChild(puntuacion_title2);
  reviews2.appendChild(puntuacion_subtitle2);



  const num_col2 = document.createElement("div");
  num_col2.classList.add("num",  "col");
  const card_review2 = document.createElement("span");
  card_review2.classList.add("card-review" , "d-flex",  "align-items-center",  "justify-content-center",  "text-white",  "fw-bold");

  num_col2.appendChild(card_review2);

  puntuacion2.appendChild(reviews2);
  puntuacion2.appendChild(num_col2);


  const title = document.createElement("h2");
  title.classList.add("title", "fs-2", "align-self-end",  "mt-sm-4",  "col-12",  "col-sm",  "text-sm-end");
  const sub_title = document.createElement("span");
  sub_title.classList.add("sub-title",  "fw-semibold",  "fs-6");

  const buttons = document.createElement("div");
  buttons.classList.add("buttons",  "d-flex",  "flex-sm-column" , "align-items-end",  "justify-content-sm-end",  "mt-3");
  const info_button = document.createElement("a");
  info_button.classList.add("info-button",  "col-1",  "d-block",  "text-center",  "py-2",  "px-3",  "mt-sm-3",  "text-decoration-none",  "text-white",  "rounded-pill");
  info_button.innerText="Ver mas";

  buttons.appendChild(info_button);

  alojamiento_extra.appendChild(puntuacion2);
  alojamiento_extra.appendChild(title);
  alojamiento_extra.appendChild(buttons);

  nuevaCard.appendChild(alojamiento_image)
  nuevaCard.appendChild(puntuacion)
  nuevaCard.appendChild(alojamiento_info);
  nuevaCard.appendChild(alojamiento_extra);

  

  }
}