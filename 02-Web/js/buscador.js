export class Buscador extends HTMLElement {
    constructor() {
      super();
      this.innerHTML = `
      <section class="buscador container-lg mx-auto d-flex justify-content-center align-items-center py-4 py-lg-0">
      <div class="buscador-filters  d-lg-flex justify-content-center align-items-center ">
          <div class="filter destino col d-flex flex-column align-items-start pb-3 pb-lg-0">
              <label class="label-buscador fs-5 fw-semibold" for="destinoList">Destino&nbsp;<i class="label-icono fa-solid fa-location-dot"></i></label>
              <input class="input-buscador border-0 text-capitalize" list="destinos" type="text" id="destinoList" placeholder="Los Angeles, CA">
              <datalist id="destinos">
                  <option value="platano"></option>
                  <option value="mandarina"></option>
                  <option value="platanito"></option>
              </datalist>
          </div>
            
          <div class="filter transporte col d-flex flex-column pb-3 pb-lg-0 mt-3 mt-lg-0 me-5 me-lg-0">
              <label class="label-buscador fs-5 fw-semibold" for="transportes">Fecha&nbsp;<i class="label-icono fa-solid fa-route"></i></label>
              <input class="input-buscador border-0 text-capitalize" list="transportesList" type="text" id="transportes" placeholder="03/05 - 12/05">
              <datalist id="transportesList">
                  <option value="Avion"></option>
                  <option value="Autobus"></option>
                  <option value="Crucero"></option>
              </datalist>
          </div>

          <div class="filter pasajeros col d-flex flex-column pb-3 pb-lg-0 mt-3 mt-lg-0">
              <label class="label-buscador fs-5 fw-semibold" for="pasajeros">Pasajeros&nbsp;<i class="label-icono fa-solid fa-user"></i></label>
              <input class="input-buscador border-0 text-capitalize" list="pasajerosList" type="text" id="pasajeros" placeholder="Adultos, 2">
              <datalist id="pasajerosList">
                  <option value="Avion"></option>
                  <option value="Autobus"></option>
                  <option value="Crucero"></option>
              </datalist>
          </div>

          <div class="col d-flex justify-content-center buscador_boton mt-5 mt-lg-0">
          <a class=" d-block w-100 text-center py-2 px-4 text-decoration-none text-white text-center rounded-pill" href="#">Buscar viajes</a>
          </div>
      </div>
    
     
  </section>
     
     `
    }
  }
  
  customElements.define('buscador-personalizado', Buscador);