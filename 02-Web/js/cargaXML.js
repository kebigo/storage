var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function(){
    if(this.readyState === XMLHttpRequest.DONE && this.status == 200){
        cargarXML(this);
    }
};

xhr.open("GET", "./xml/alojamiento.xml", true);
xhr.send();

function cargarXML(xml){
    
    var docXML = xml.responseXML;
    var lista = docXML.getElementsByTagName("alojamiento");

    const padre = document.querySelectorAll(".content");
    const hijo = document.querySelectorAll(".content article")
    let clone = hijo.cloneNode(true);
        padre.innerHTML(clone);

        console.log(padre);

    for(let i = 0; i<lista.length; i++){

        

        document.querySelector(".ciudad").innerText = lista[i].getElementsByTagName("ciudad")[0].textContent;
        
    }
 
   
}