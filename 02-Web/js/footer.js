export class FooterPersonalizado extends HTMLElement {
    constructor() {
      super();
      this.innerHTML = `

     
      <head>
      
      </head>
  
      <footer class="d-flex flex-column">
        
     
      <div class="footer container-lg py-2 text-white d-flex  align-items-start flex-column flex-md-row justify-content-center">

          <div class="footer__about col-12 col-md-3 ps-3 pb-3">
              <img class= "footer__logo" src="./assets/img/logo_header.png" alt="">
              <p class="footer__about">Viaja con Kebigo, la mejor agencia de viajes de toda España. 4 veces ganadora de los premios Leonardo.
              </p>
              <ul class="d-flex list-unstyled ">
                  <li>
                      <a class= "icono_rrss rounded-pill d-flex justify-content-center align-items-center" href="#"><i class="fa-brands fa-instagram"></i></a>
                  </li>
                  <li>
                      <a class= "icono_rrss rounded-pill d-flex justify-content-center align-items-center" href="#"><i class="fa-brands fa-facebook-f"></i></i></a>
                  </li>
                  <li>
                      <a class= "icono_rrss rounded-pill d-flex justify-content-center align-items-center" href="#"><i class="bi bi-twitter"></i></a>
                  </li>
              
                
              </ul>
          </div>
          <div class="footer__services col-12 col-md-3 pb-3">
              <div class="container-lg">
                  <h2 class="fs-5 text-uppercase fw-bold">Servicios</h2>
                  <ul class="list-unstyled">
                      <li class="py-2">Alojamiento</li>
                      <li class="py-2">Transporte</li>
                      <li class="py-2">Actividades</li>
                      <li class="py-2">Ofertas</li>

                  </ul>
              </div>
              
          </div>
          <div class="footer__account col-12 col-md-3 pb-3">
              <div class="container-lg">
                  <h2 class="fs-5 text-uppercase fw-bold">Cuenta</h2>
                  <ul class="list-unstyled">
                      <li class="py-2">Carrito</li>
                      <li class="py-2">Mi cuenta</li>
                      <li class="py-2">Reservas</li>
                      <li class="py-2">Atencion al cliente</li>

                  </ul>
              </div>
          </div>
          <div class="footer__newsletter col-12 col-md-3 pb-3">
              <div class="container-lg">
                  <h2 class="fs-5 text-uppercase fw-bold">Newsletter</h2>
                  <p class="text-start">Subscribete a nuestar Newsletter de viajes y recibe un 15% de descuento.</p>
                  <form action="">
                      <input class="mt-3 rounded-pill py-2 ps-3" type="email" placeholder="Email">
                      <input class="py-2 px-3 rounded-pill ms-2 fw-semibold" type="button" value="Enviar">
                  </form>
                 
              </div>
            

          </div>

          
      </div>

      <div class="container legal col-7 text-center border-top mt-3 pt-4">
          <p class="text-white">Creado con 🤪   por Kevin P. y Bittor G.</p>
      </div>
     
      

  </footer>`
    }
  }
  
  customElements.define('footer-personalizado', FooterPersonalizado);