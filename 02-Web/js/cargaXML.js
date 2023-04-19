var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function(){
    if(this.readyState === XMLHttpRequest.DONE && this.status == 200){
        cargarXML(this);
    }
};

xhr.open("GET", "./xml/alojamiento.xml", true);
xhr.send();



function cargarXML(xml){
    
    const padre = document.querySelector(".content");
    const hijo = document.querySelector(".content .alojamiento")

    var docXML = xml.responseXML;
    var lista = docXML.getElementsByTagName("alojamiento");
   
    for(let i = 0; i<lista.length; i++){
        var clone = hijo.cloneNode(true);
        padre.appendChild(clone);
        document.querySelector(".alojamiento-info .title").innerText = lista[i].getElementsByTagName("nombre")[0].textContent;
        document.querySelector(".alojamiento-info .sub-title").innerText = lista[i].getElementsByTagName("ciudad")[0].textContent;

    }

    padre.removeChild(document.getElementById("padre").children[1]);

   
}

