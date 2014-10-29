/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function () {
    function PlayerContainer(_containerId) {

        var container = $("#" + _containerId);
        var allPlayers = [];
        var allAdded = false;

        function appendPlayers() {
            if (allPlayers !== undefined) {
                $(allPlayers).each(function (index, elem) {
                    elem.appendTo(container);
                });
                //.allAdded = true;
            }
        }

        return{
            setPlayers: function (players) {
                $("#" + _containerId).removeClass(".playerContainer");
                container.removeClass(".playerContainer"); 
                allPlayers = [];
                allPlayers = players;
                appendPlayers();
            },
            removePlayer: function (playerAthlete) {
                container.find("#" + playerAthlete.getId()).animate({
                    opacity: 0
                }, 500).remove();
            }
        };
    }
    return PlayerContainer;
});

