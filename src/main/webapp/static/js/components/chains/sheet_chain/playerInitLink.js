/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function (_nextLink, _pSheets) {
    function PlayerInitLink() {
        var handleMsg = 'init';
        var nextLink = _nextLink;
        var pSheets = _pSheets; //object map of pos/playerAthlete objects
        
        function handleMessage(message){
            
        }
        
        return{
            haveMessage: function(msg){
                if(msg.purpose === handleMsg){
                    handleMessage(msg);
                }else if(nextLink !== undefined && nextLink !== null){
                    nextLink.haveMessage(msg);
                }
            }
        };
    }
});

