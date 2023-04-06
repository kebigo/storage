export class HeaderPersonalizado extends HTMLElement {
  constructor() {
    super();
    this.innerHTML = `

        
        <nav class="navbar navbar-expand-md bg-body-tertiary flex justify-content-center">
        <div class="container-lg">
          <button class="navbar-toggler" type="button" data-bs-toggle="modal" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>


<!-- Modal -->
<div class="modal fade" id="navbarNav" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
        <div class="modal-header">
          <img class= "logo_mobile" src="./assets/img/logo_header.png" alt="">
          <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <ul class="list-unstyled text-white">
          <li class="py-3 d-flex align-items-center">
            <i class="icono_mobile bi bi-house-door-fill fs-2 me-2"></i>
            <a class="text-decoration-none text-white" href="#">Inicio</a>
          </li>

          <li class="py-3 d-flex align-items-center">
            <i class="icono_mobile bi bi-people-fill fs-2 me-2"></i>
            <a class="text-decoration-none text-white href="#">Sobre nosotros</a>
          </li>

          <li class="py-3 d-flex align-items-center">
            <i class=" icono_mobile bi bi-building fs-2 me-2"></i>
            <a class="text-decoration-none text-white href="#">Alojamiento</a>
          </li>

          <li class="py-3 d-flex align-items-center">
            <i class="icono_mobile bi bi-airplane-fill fs-2 me-2"></i>
            <a class="text-decoration-none text-white href="#">Transporte</a>
          </li>
          
          <li class="py-3 d-flex align-items-center">
            <i class=" icono_mobile bi bi-gift-fill fs-2 me-2"></i>
            <a class="text-decoration-none text-white href="#">Ofertas</a>
          </li>
          
         
        </ul>

        <ul class="d-flex list-unstyled ">
       
          <a class="boton_login_mobile rounded-pill d-flex justify-content-center align-items-center" href="#">
            <i class="bi bi-person"></i>
          </a>

          <a class="boton_carrito_mobile rounded-pill ms-2 d-flex justify-content-center align-items-center" href="#">
            <i class="bi bi-cart"></i>
          </a>

          <a class="boton_favoritos_mobile rounded-pill ms-2 d-flex justify-content-center align-items-center" href="#">
            <i class="bi bi-heart"></i>
          </a>
        </ul>

        <input class="contacto_mobile mt-5 text-white py-2 px-3 rounded-pill fw-semibold" type="button" value="Contactanos">
      </div>
      
    </div>
  </div>
</div>
          <div class="navbar-brand d-block ">
            <a href="#">
                <img class= "logo_header" src="./assets/img/logo_header.png" alt="">
            </a>
         </div>
          <div class="collapse navbar-collapse d-md-flex justify-content-md-center " id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Inicio</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Sobre nosotros</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="#">Alojamiento</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="#">Transporte</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="#">Ofertas</a>
              </li>
            </ul>
          </div>

          <a class="boton_login rounded-pill d-flex justify-content-center align-items-center" href="#">
            <i class="bi bi-person"></i>
          </a>
          <a class="boton_carrito rounded-pill ms-2 d-flex justify-content-center align-items-center" href="#">
            <i class="bi bi-cart"></i>
          </a>
          <a class="boton_favoritos rounded-pill ms-2 d-flex justify-content-center align-items-center" href="#">
            <i class="bi bi-heart"></i>
          </a>
        </div>
      </nav>

    
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>`
  }
}

customElements.define('header-personalizado', HeaderPersonalizado);