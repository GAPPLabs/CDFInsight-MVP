const form = document.getElementById('conversionForm');
let xmlContent = document.getElementById("xmlContent");
// TODO  Definir variable para la lectura de archivos
// const xmlFile
form.addEventListener('submit', function (event) {
    event.preventDefault(); // Evita que el navegador haga submit tradicional
    console.log(document.getElementById("xmlContent").value)
    establishConnection();
    validateXmlContent();
    validateXmlContent() ? sendRequest(xmlContent.value) : alert("Contenido en área de texto no tiene un formato XML válido");


});
// TODO Validar si hay contenido en archivos o en text area
// TODO Validar que solamente un componente sea analizado y enviado, ya sea por archivo o text area
function validateXmlContent() {
    if (xmlContent.value == '') {
        console.log("No Content detected in text area")
        return false;
    } else {
        console.log("Content detected in text area")
        return true;
    }
}
