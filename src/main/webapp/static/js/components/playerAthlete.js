/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function () {
    function PlayerAthlete(_athlete) {
        
        var athlete = _athlete;
        
        
        var markup = '<section id="' + athlete.id + '" data-position="' + athlete.pos + '" class="playerContainer">\
                       <section data-position="name" class="pStatDisp">' + athlete.name + '</section>\
                       <section data-position="team" class="pStatDisp">' + athlete.team + '</section>';
        if(athlete.pos === 'QB'){
            markup += '<section data-position="att" class="pStatDisp">' + athlete.passingAtt + '</section>\
                       <section data-position="comp" class="pStatDisp">' + athlete.passingCmp + '</section>\
                       <section data-position="lng" class="pStatDisp">' + athlete.passingInts + '</section>\
                       <section data-position="yds" class="pStatDisp">' + athlete.passingYds + '</section>\
                       <section data-position="td" class="pStatDisp">' + athlete.passingTds + '</section>';
        }else if(athlete.pos === 'RB'){
            markup += '<section data-position="att" class="pStatDisp">' + athlete.rushingAtt + '</section>\
                       <section data-position="comp" class="pStatDisp">' + athlete.rushingLng + '</section>\
                       <section data-position="lng" class="pStatDisp">' + athlete.rushingLngtd + '</section>\
                       <section data-position="yds" class="pStatDisp">' + athlete.rushingYds + '</section>\
                       <section data-position="td" class="pStatDisp">' + athlete.rushingTds + '</section>';
        }else if(athlete.pos === 'WR' || athlete.pos ==='TE'){
            markup += '<section data-position="att" class="pStatDisp">' + athlete.receivingRec + '</section>\
                       <section data-position="comp" class="pStatDisp">' + athlete.receivingLng + '</section>\
                       <section data-position="lng" class="pStatDisp">' + athlete.receivingLngtd + '</section>\
                       <section data-position="yds" class="pStatDisp">' + athlete.receivingYds + '</section>\
                       <section data-position="td" class="pStatDisp">' + athlete.receivingTds + '</section>';
        }        
        markup += '</section>';
        
        return{
            markup: function(){
                return markup;
            },
            element: function(){
                return $("#" + athlete.id);
            },
            getId: function(){
                return athlete.id;
            },
            appendTo: function(parent){
                parent.append(markup);
            },
            pos: function(){
                return athlete.pos;
            },
            name: function(){
                return athlete.name;
            },
            team: function(){
                return athlete.team;
            }
        };
    }
    return PlayerAthlete;
});