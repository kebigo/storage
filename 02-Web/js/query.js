var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function () {
    if (this.readyState === XMLHttpRequest.DONE && this.status == 200) {
        cargarXML(this);

    }
};

xhr.open("GET", "./xml/alojamiento.xml", true);
xhr.send();

function cargarXML(xml) {

    //Obtener el id mediante la url
    let currentUrl = (window.location.href);

    currentUrl = currentUrl.split("?");

    const id = currentUrl[1];
    var docXML = xhr.responseXML;

    lista = docXML.evaluate("//alojamiento[@" + id + "]", docXML, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);


    for (let i = 0; i < lista.snapshotLength; i++) {


        document.querySelector(".container-lg .sub-title").innerText = lista.snapshotItem(i).getElementsByTagName("ciudad")[0].textContent;
        document.querySelector(".container-lg .main-title ").innerText = lista.snapshotItem(i).getElementsByTagName("nombre")[0].textContent;
        
        //Obtener instalaciones
        var instalaciones = lista.snapshotItem(i).getElementsByTagName('instalacion');

        var instalaciones_array = Array.from(instalaciones, function (elemento) {
            return elemento.textContent;
        });

        instalaciones_array.forEach(e=>{
            
            const info_servicios = document.querySelector(".info-servicios ul")
            const label = document.createElement("label")
            const icono = document.createElement("i");

            label.textContent= e ;

            label.insertBefore(icono, label.childNodes[0]);


            if(label.textContent == "Piscina"){
                icono.classList.add("fa-solid",  "fa-water-ladder" , "fw-bold", "me-2")
            }else if(label.textContent == "Gimnasio"){
                icono.classList.add("fa-solid",  "fa-dumbbell", "me-2");
            }else if(label.textContent == "Wifi"){
                icono.classList.add("fa-solid", "fa-wifi", "me-2");
            }else if(label.textContent == "Cocina"){
                icono.classList.add("fa-solid" , "fa-kitchen-set", "me-2");

            }
            
            
            info_servicios.appendChild(label)

        })



        //Obtener ruta de la imagen mediante el nombre
        let texto = "";
        const ruta = lista.snapshotItem(i).getElementsByTagName("nombre")[0].textContent.split(" ")
        ruta.forEach(e => {
            texto += e + "_";
        });

        texto = texto.slice(0, -1).toLowerCase();
        document.querySelector(".imagen-hotel img").setAttribute("src", "./assets/img/alojamiento_main/" + texto + ".jpg");

        document.querySelector(".title").innerText = lista.snapshotItem(i).getElementsByTagName("nombre")[0].textContent;
        document.querySelector(".info-text p").innerText = lista.snapshotItem(i).getElementsByTagName("descripcion")[0].textContent
    }



}


let reservedDates = [1];

//Calendario disponibilidad
const daysTag = document.querySelector(".days"),
    currentDate = document.querySelector(".current-date"),
    prevNextIcon = document.querySelectorAll(".icons span");

// getting new date, current year and month
let date = new Date(),
    currYear = date.getFullYear(),
    currMonth = date.getMonth();

// storing full name of all months in array
const months = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
    "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];

const renderCalendar = () => {
    let firstDayofMonth = new Date(currYear, currMonth, 1).getDay(), // getting first day of month
        lastDateofMonth = new Date(currYear, currMonth + 1, 0).getDate(), // getting last date of month
        lastDayofMonth = new Date(currYear, currMonth, lastDateofMonth).getDay(), // getting last day of month
        lastDateofLastMonth = new Date(currYear, currMonth, 0).getDate(); // getting last date of previous month
    let liTag = "";

    

    for (let i = firstDayofMonth; i > 0; i--) { // creating li of previous month last days
        liTag += `<li class="inactive ">${lastDateofLastMonth - i + 1}</li>`;
    }

    for (let i = 1; i <= lastDateofMonth; i++) {
        let isToday = i === date.getDate() && currMonth === new Date().getMonth()
            && currYear === new Date().getFullYear() ? "active" : "";

        // Adding "reserved" class to li element if the date is reserved
        let isReserved = reservedDates.includes(`${currYear}-${currMonth + 1}-${i}`);
        if (isReserved) {
            isToday += "reserved";
        }

        liTag += `<li class="${isToday}">${i}</li>`;
    }

    for (let i = lastDayofMonth; i < 6; i++) { // creating li of next month first days
        liTag += `<li class="inactive">${i - lastDayofMonth + 1}</li>`
    }
    currentDate.innerText = `${months[currMonth]} ${currYear}`; // passing current mon and yr as currentDate text
    daysTag.innerHTML = liTag;
}
renderCalendar();

prevNextIcon.forEach(icon => { // getting prev and next icons
    icon.addEventListener("click", () => { // adding click event on both icons
        // if clicked icon is previous icon then decrement current month by 1 else increment it by 1
        currMonth = icon.id === "prev" ? currMonth - 1 : currMonth + 1;

        if (currMonth < 0 || currMonth > 11) { // if current month is less than 0 or greater than 11
            // creating a new date of current year & month and pass it as date value
            date = new Date(currYear, currMonth, new Date().getDate());
            currYear = date.getFullYear(); // updating current year with new date year
            currMonth = date.getMonth(); // updating current month with new date month
        } else {
            date = new Date(); // pass the current date as date value
        }
        renderCalendar(); // calling renderCalendar function
    });
});