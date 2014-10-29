/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function () {

    function Owner(_owner, _num) {

        var owner = {
            persistence: _owner,
            number: _num,
            players: []
        };
        
        var ownerWidth = 151;

        var getX = function () {
            return (((owner.number + 1) * 8.3) + (ownerWidth * owner.number));
        };
        
        var markup = '<section style="left:' + getX() + 'px" id="owner' + (owner.number + 1) + '" class="owner">\
                    <section id="teamName" class="teamName">' + owner.persistence.teamName + '</section>\
                    <section id="ownerName" class="ownerName">' + owner.persistence.ownerName + '</section>\
                    </section>';        

        return{
            addPlayer: function (athlete) {
                owner.players.push(athlete);
            },
            element: function(){
                return $("#owner" + (owner.number + 1));
            },
            markup: function(){
                return markup;
            },
            fadeIn: function(){
                this.element().animate({
                    opacity: "1.0"
                }, 1500);
            },
            appendTo: function(parent){
                parent.append(markup);
                this.element().css({
                    opacity: '0'
                });
                this.fadeIn();
            }
        };
    }
    return Owner;
});

