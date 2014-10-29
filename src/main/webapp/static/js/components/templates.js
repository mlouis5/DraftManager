/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function () {
    function Template() {
        var temp = {
            choice: '<p class="instruction">Please select a league</p>{{#leagues:num}}\\n\
                    <section id="league{{num}}" class="choice">{{leagueName}}</section>\\n\
                    {{/each}}'
        };
    }
    return Template;
});

