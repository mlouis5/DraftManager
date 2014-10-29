/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function () {

    function Pick(_pick, _pickNum, _numTeams, _numRounds) {

        var pick = {
            persistance: _pick,
            pos: _pickNum
        };
        
        var pickWidth = 150;
        var pickHeight = 62;
        var margin = 8.3;

        var numTeams = _numTeams;
        var numRounds = _numRounds;

        var id = 'pick' + (pick.pos + 1);
        var markup = '<section style="left:' + getX() + 'px; top:' + getY() + 'px" id="' + id + '" class="pick">\
            <section id="pos' + (pick.pos + 1) + '" class="pos" data-pos="' + pick.persistance.draftedAthlete.pos + '">' + pick.persistance.draftedAthlete.pos + '</section>\
            <section id="topline' + (pick.pos + 1) + '" class="topline">' + pick.persistance.draftedAthlete.name + '</section>\
            <section id="bottomline' + (pick.pos + 1) + '" class="bottomline">\
                <section id="team' + (pick.pos + 1) + '" class="team">' + pick.persistance.draftedAthlete.team + '</section>\
                <section id="proj' + (pick.pos + 1) + '" class="proj">' + pick.persistance.draftedAthlete.proj + '</section>\
            </section>\
        </section>';

        var getX = function () {            
            var mod = pick.pos >= numTeams ? pick.pos % numTeams : pick.pos;
            return (((mod + 1) * margin) + (pickWidth * mod));
        };

        var getY = function () { //must be zero(0) base 0...n, n = numRounds
            var row = Math.floor(pick.pos / numTeams);
            return (((row + 1) * margin) + (pickHeight * row));
        };

        return{
            getMarkup: function () {
                return markup;
            },
            element: function () {
                return $('#' + id);
            },
            getPickId: function () {
                return id;
            },
            appendTo: function(parent){
                parent.append(markup);
                this.element().css({
                    opacity: 0
                });
                this.fadeIn();
            },
            fadeIn: function(){
                this.element().animate({
                    opacity: "1.0"
                }, 1500);
            }
        };
    }
    return Pick;
});