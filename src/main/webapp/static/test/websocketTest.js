/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function () {
    var wsUri = "ws://" + document.location.host + document.location.pathname + "draftmanager/board";

    setTimeout(function () {

        //your code to be executed after 1 seconds

        var websocket = new WebSocket(wsUri);

// For testing purposes
//        var output = document.getElementById("output");
        websocket.onopen = function (evt) {
            console.log(evt);
        };
        
        websocket.onmessage = function(evt){
            console.log(evt.data);
        };

        function writeToScreen(message) {
            console.log(message);
        }

        websocket.onerror = function (evt) {
            console.log(evt);
        };
    }, 5000);
};
