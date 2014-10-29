/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function () {
    function Board(id) {
        var thisId = id;
        var boardElement = $(thisId);

        return{
            setPick: function (pick) {
                if (pick !== undefined && pick !== null) {
                    pick.setHiddenPos();
                    $(thisId).append(pick.getMarkup());
                    pick.bind();

                    pick.element().animate({
                        crSpline: $.crSpline.buildSequence([[pick.getStartingX(), pick.getStartingY()],
                            [pick.getEndingX(), pick.getEndingY()]]),
                        duration: 1000
                    });
                    pick.setFinalPosition();
                }
            }
        };
    }
    return Board;
});

