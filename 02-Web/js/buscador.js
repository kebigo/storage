export class Buscador extends HTMLElement {
    constructor() {
      super();
      this.innerHTML = `
      <section class="buscador container-lg mx-auto d-flex justify-content-center align-items-center py-4 py-lg-0">
      <div id="buscador-filters" class="buscador-filters  d-lg-flex justify-content-center align-items-center ">
          <div class="filter destino col d-flex flex-column align-items-start pb-3 pb-lg-0 position-relative">
              <label class="label-buscador fs-5 fw-semibold" for="destinoList">Destino&nbsp;<i class="label-icono fa-solid fa-location-dot"></i></label>
              <input value="Barcelona, ES" id="input-buscador" class="input-buscador border-0 text-capitalize " autocomplete="off" type="text" id="destino" placeholder="Barcelona, ESP">
              <div id="opciones-destinos" class="flex-column position-absolute p-3 gap-3">
                    <span class="pb-2">Berlín, DE</span>
                    <span class="pb-2">Praga, CZ</span>
                    <span class=" pb-2">Londres, UK</span>
                    <span class="pb-2">Barcelona, ES</span>
                    <span class="">Roma, IT</span>
              </div>
         
          </div>
            
          <div class="filter fechas col d-flex flex-column pb-3 pb-lg-0 mt-3 mt-lg-0 me-5 me-lg-0">
              <label class="label-buscador fs-5 fw-semibold" for="transportes">Fecha&nbsp;<i class="label-icono fa-solid fa-route"></i></label>
              <input value="03/05 - 12/05" class="input-buscador border-0 text-capitalize" list="transportesList" type="text" id="fechas" placeholder="03/05 - 12/05">
           
          </div>

          <div class="filter pasajeros position-relative col d-flex flex-column pb-3 pb-lg-0 mt-3 mt-lg-0">
              <label class="label-buscador fs-5 fw-semibold" for="pasajeros">Pasajeros&nbsp;<i class="label-icono fa-solid fa-user"></i></label>
              <input value="Adultos,1" class="input-buscador border-0 text-capitalize"  type="text" id="pasajeros" placeholder="Adulto, 1" autocomplete="off">
              <div id="seleccionarPasajeros" class=" p-3 gap-3 position-absolute flex-column">
                <div class="pasajero d-flex align-items-center">
                    <h2 class="col-5 fs-6 fw-semibold mb-0">Adultos</h2>
                    <div class="col-7 controls border d-flex justify-content-between p-2">
                        <i class="btnRestar bi bi-dash fs-5 fw-semibold"></i>
                        <input type="number" class="w-25 text-center" value="1">
                        <i class="btnSumar bi bi-plus fs-5 fw-semibold"></i>

                    </div>
                  
                </div>

                <div class="pasajero d-flex align-items-center">
                    <h2 class="col-5 fs-6 fw-semibold mb-0">Niños</h2>
                    <div class="col-7 controls border d-flex justify-content-between p-2">
                        <i class="btnRestar bi bi-dash fs-5 fw-semibold"></i>
                        <input type="number" class="w-25 text-center" value="0">
                        <i class="btnSumar bi bi-plus fs-5 fw-semibold"></i>
                    </div>
                  
                </div>

                <div class="pasajero d-flex align-items-center">
                    <h2 class="col-5 fs-6 fw-semibold mb-0"><br>Jubilados</h2>
                    <div class="col-7 controls border d-flex justify-content-between p-2">
                        <i class="btnRestar bi bi-dash fs-5 fw-semibold"></i>
                        <input type="number" class="w-25 text-center" value="0">
                        <i class=" btnSumar bi bi-plus fs-5 fw-semibold"></i>

                    </div>
                  
                </div>

                <a class="info-button d-block text-center w-100 py-2 px-3 mt-3 text-decoration-none text-white rounded-pill" href="#">Listo</a>
              </div>
          </div>

          <div class="col d-flex justify-content-center buscador_boton mt-5 mt-lg-0">
          <a id ="boton-buscador" class="d-block w-100 text-center py-2 px-4 text-decoration-none text-white text-center rounded-pill" href="#">Buscar viajes</a>
          </div>
      </div>
    
     
  </section>
    
        
       
     `
    }

  }
  
  customElements.define('buscador-personalizado', Buscador);

//Recoger filtros buscador
export const boton = document.getElementById("boton-buscador");
const filtros = document.querySelectorAll(".filter > input");

export const parametros = [];

parametros[0] = "Barcelona, ES";

//Guardar filtros al hacer click
boton.addEventListener("click", ()=>{
  
  
//Limpiar array parametros
parametros.length = 0;

//Introducir destino al array
parametros.push(filtros[0].value);

//Sacar fechaIda/fechaVuelta y meter al array
let fechas = filtros[1].value.split(" - ");

parametros.push(fechas);

//Sacar tipo pasajero y meter al array
let pasajeros = filtros[2].value.split(" ");

//Eliminar ultimo elemento (" - ") si hay mas de 1
if(pasajeros.length > 1){
    pasajeros.pop();
}


parametros.push(pasajeros);

console.log(parametros);

})





//Filtro de fecha
flatpickr("#fechas",{
    mode:"range",
    dateFormat: "d/m",
    onChange: function(selectedDates, dateStr, instance) {
        instance.element.value = dateStr.replace('to', '-');
    },      
    defaultDate: [new Date(), new Date().fp_incr(4)],
    locale: {
        firstDayOfWeek: 1,
        weekdays: {
          shorthand: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
          longhand: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],         
        }, 
        months: {
          shorthand: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Оct', 'Nov', 'Dic'],
          longhand: ['Enero', 'Febreo', 'Мarzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        },
      },
});

let stringMal = document.getElementById("fechas").value;
document.getElementById("fechas").value = stringMal.replace("to", "-");

//Panel para seleccionar pasajeros
let pasajeros = filtros[2];
let panelSelect = document.getElementById("seleccionarPasajeros");


//Panel para seleccionar destino
let destinos = filtros[0];
let panelDestinos = document.getElementById("opciones-destinos");


//Controlar que aparezcan y desaparezcan
pasajeros.addEventListener("click", ()=>{
     panelSelect.style.display = "flex";
})

destinos.addEventListener("click", ()=>{
    panelDestinos.style.display = "flex";
})

// Verificar si el clic se hace fuera del div que se muestra
document.addEventListener('click', function(event) {
    if (!panelSelect.contains(event.target) && event.target != pasajeros && !panelDestinos.contains(event.target) && event.target != destinos) {
        panelSelect.style.display = 'none';
        panelDestinos.style.display = 'none';

    }
  });



  let actualNum = null;
//Incrementar o disminuir numero
const btnSumar = document.querySelectorAll(".btnSumar");
const btnRestar = document.querySelectorAll(".btnRestar")

btnSumar.forEach(e =>{
    e.addEventListener("click", ()=>{
        actualNum = parseInt(e.previousElementSibling.value);
        e.previousElementSibling.value =  actualNum +1 ;
    })
})


btnRestar.forEach(e =>{
    e.addEventListener("click", ()=>{
        actualNum = parseInt(e.nextElementSibling.value);
        if(actualNum > 0){
            e.nextElementSibling.value =  actualNum -1 ;
        }
    })
})

//Añadir destino
const destOpc = panelDestinos.querySelectorAll("span");
const inputDest = destinos.querySelector("input");

destOpc.forEach(e =>{
    e.addEventListener("click", ()=>{
       destinos.value = e.textContent;
       panelDestinos.style.display = 'none';

    })
})

//Insertar datos de pasajeros
function cargarPasajeros(){

    let texto = "";
    const inputs = panelSelect.querySelectorAll(".pasajero .controls input");
    const inputPasajeros = document.querySelector(".pasajeros .input-buscador");


    inputs.forEach(e =>{
        if(e.value > 0){
            let tipoPasajero = e.parentElement.previousElementSibling.textContent;
            let numPasajero = e.value;
    
            let seleccion = tipoPasajero + "," + numPasajero;
    
           
            texto += tipoPasajero + "," + numPasajero+ " ";
        }

        
    })

    inputPasajeros.value = texto;
}

//Controlar boton
const btn = panelSelect.querySelector(".info-button");

btn.addEventListener("click", ()=>{
    cargarPasajeros();
     panelSelect.style.display = 'none';
});