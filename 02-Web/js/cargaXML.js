import {boton, parametros} from "./buscador.js";

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

  boton.addEventListener("click", ()=>{
    let ciudad = "'"+parametros[0]+"'";
    cargarcontenido(ciudad);

  })

  cargarcontenido("'"+"Barcelona, ES"+"'")
  
  function cargarcontenido(ciudad) {

    //Iniciar paginacion a 1
    const botones = document.querySelectorAll(".pagination .page-link")
    botones.forEach(e =>{
      e.classList.remove("link-active");
      botones[0].classList.add("link-active");
      

    })
 
    //Encontrar cards y su contenedor
    const abuelo = document.querySelector(".container-lg");
    const hijo = document.querySelector(".content #articuloOriginal");
  
       // Limpiar contenido existente
       while (page.lastChild && page.lastChild !== hijo) {
        page.removeChild(page.lastChild);
      }

    //Listar las cards
    var docXML = xhr.responseXML;
  
    // Utilizar XPath para seleccionar los nodos de alojamiento con ciudad correspondiente
    lista = docXML.evaluate("//alojamiento[ciudad=" + ciudad + "]",docXML,null,XPathResult.ORDERED_NODE_SNAPSHOT_TYPE,null);


      page4.innerHTML = "";
      page2.innerHTML = "";
      page3.innerHTML = "";
     

    for (let i = 0; i < lista.snapshotLength; i++) {
      //Clonar el elemento original
      var cloneCard = hijo.cloneNode(true);
  
      //Añadir id a las cards
      lista.snapshotItem(i).setAttribute("id", i);

      //Insertar contenido dinamico
      document.querySelector(".alojamiento-info .title", cloneCard).innerText = lista.snapshotItem(i).getElementsByTagName("nombre")[0].textContent;
      document.querySelector(".alojamiento-info .sub-title", cloneCard).innerText = lista.snapshotItem(i).getElementsByTagName("ciudad")[0].textContent;
      document.querySelector(".alojamiento-info .text", cloneCard).innerText = lista.snapshotItem(i).getElementsByTagName("texto")[0].textContent;
      document.querySelector(".alojamiento-extra .num span",cloneCard).innerText = lista.snapshotItem(i).getElementsByTagName("puntuacion")[0].textContent + "";
      document.querySelector(".alojamiento-extra .puntuacion-subtitle",cloneCard).innerText =lista.snapshotItem(i).getElementsByTagName("comentarios")[0].textContent +" comentarios";

      //Obtener ruta de la imagen mediante el nombre
      let texto = "";
      const ruta = lista.snapshotItem(i).getElementsByTagName("nombre")[0].textContent.split(" ")
      ruta.forEach(e => {
        texto += e + "_";
       
        
      });

      texto = texto.slice(0, -1).toLowerCase();
      document.querySelector(".alojamiento-image img",cloneCard).setAttribute("src", "./assets/img/alojamiento_main/" + texto + ".jpg") ;

      //Insertar enlace por id al boton
      document.querySelector(".alojamiento-extra .info-button", cloneCard).setAttribute("href", "query.html?id="+lista.snapshotItem(i).getAttribute("id"));
      

      //Mostrar solo 4 cards por pagina
      if(i < 4){
        page.appendChild(cloneCard);
      }else if(i>= 5 && i < 9){
        page2.appendChild(cloneCard);
      }else if(i >= 9 && i < 13){
        page3.appendChild(cloneCard);
      }else{
        page4.appendChild(cloneCard);
      }

      
    }

  
    //Ocultar card original

    page.querySelector("#articuloOriginal").nextElementSibling.classList.replace("d-flex", "d-none")

}

  //Capturar click de botones de paginacion
  const botones = document.querySelectorAll(".pagination .page-link")
  botones[0].classList.add("link-active");
  botones.forEach(e =>{
    e.addEventListener("click", ()=>{

      let numBtn = e.textContent;
      
      if(numBtn == 1){
        page.classList.replace("d-none", "d-flex")
        page2.classList.replace("d-flex", "d-none")
        page3.classList.replace("d-flex", "d-none")
        page4.classList.replace("d-flex", "d-none")
      }else if(numBtn == 2){
        page2.classList.replace("d-none", "d-flex")
        page.classList.replace("d-flex", "d-none")
        page3.classList.replace("d-flex", "d-none")
        page4.classList.replace("d-flex", "d-none")
      }else if(numBtn == 3){
        page3.classList.replace("d-none", "d-flex")
        page2.classList.replace("d-flex", "d-none")
        page.classList.replace("d-flex", "d-none")
        page4.classList.replace("d-flex", "d-none")
      }else if(numBtn == 4){
        page4.classList.replace("d-none", "d-flex")
        page2.classList.replace("d-flex", "d-none")
        page3.classList.replace("d-flex", "d-none")
        page.classList.replace("d-flex", "d-none")
      }

      //Capturar boton activo

      document.querySelector(".link-active").classList.remove("link-active");
        
      e.classList.add("link-active");


    })
  })

  



}


  

  
  
