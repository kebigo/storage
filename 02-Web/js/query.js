var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function(){
    if(this.readyState === XMLHttpRequest.DONE && this.status == 200){
     cargarXML(this);
     
    }
};

xhr.open("GET", "./xml/alojamiento.xml", true);
xhr.send();

function cargarXML(xml){

    var docXML = xhr.responseXML;

        lista = docXML.evaluate("//alojamiento",docXML,null,XPathResult.ORDERED_NODE_SNAPSHOT_TYPE,null);

    for(let i = 0; i <lista.snapshotLength; i++){

        lista.snapshotItem(i).setAttribute("id", i);
    }
}