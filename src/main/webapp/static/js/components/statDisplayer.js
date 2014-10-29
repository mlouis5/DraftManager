/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function () {
    function StatDisplayer() {
        var id = '#statisticsDiv';
        var statContainer=".statContainer";
        var element = $(id);
        
        function clearElement(){
            element.remove(statContainer);
        }
        
        return{
            setAthlete: function(playerAthlete){
                clearElement();
            }
        }
    }
    return StatDisplayer;
});

