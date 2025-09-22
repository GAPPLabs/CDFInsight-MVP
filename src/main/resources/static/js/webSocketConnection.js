let stompClient = null;
let socket = null;
stompClient = null;


function initSocketConnection() {
    console.log("Initializing Socket and StompClient")
    socket = new SockJS("http://localhost:8080/stomp");
    stompClient = Stomp.over(socket);
}

function connectSocket() {
    stompClient.connect({}, function (frame) {
        // console.log("Connected: " + frame);
        stompClient.subscribe("/todo/convertedXml", function (data) {
            // console.log(">>> " + data.body);

        });
    });
    console.log("socket connected successfully")
}

function establishConnection() {
    if (socket == null) {
        initSocketConnection();
    }
    connectSocket();
}

function sendRequest(xmlContent){
    console.log("Sending request")
    stompClient.send('/todo-api-ws/sendMessage', {}, xmlContent);
}


// XML DE PRUEBA. PUEDE SER SUSTITUIDO DIRECTAMENTE EN LA FUNCION PARA EVITAR EJECUCION MANUAL
// <?xml version="1.0" encoding="UTF-8"?>
// <catalog>
// <book id="1">
//     <title>Introduction to XML</title>
// <author>Jane Doe</author>
// <genre>Technology</genre>
// <price>29.99</price>
// <publish_date>2025-01-15</publish_date>
// </book>
// <book id="2">
//     <title>Learning Python</title>
//     <author>John Smith</author>
//     <genre>Programming</genre>
//     <price>39.99</price>
//     <publish_date>2024-11-10</publish_date>
// </book>
// </catalog>