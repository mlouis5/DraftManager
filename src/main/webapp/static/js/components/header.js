/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function () {
    function Header(id) {

        var thisId = id;
        var ownerContainer = {
            owners: []
        };
        
//        var ractive = new Ractive({
//            // The `el` option can be a node, an ID, or a CSS selector.
//            el: 'summary',
//            // We could pass in a string, but for the sake of convenience
//            // we're passing the ID of the <script> tag above.
//            template: markup.toString(),
//            // Here, we're passing in some initial data
//            data: pick
//        });

        return{
            setOwner: function (owner) {
                if (!$.inArray(owner, ownerContainer.owners)) {
                    var own = ownerContainer.owners;
                    own.push(owner);
                    owner.id = '#owner' + own.length;
                    
                    owner.setHiddenPos();
                    $(thisId).append(owner.getMarkup());
                    //bind with rivets here
                    owner.element().animate({
                        crSpline: $.crSpline.buildSequence([[owner.getStartingX(), owner.getStartingY()],
                            [owner.getEndingX(), owner.getEndingY()]]),
                        duration: 1000
                    });
                    owner.setFinalPosition();
                }
            },
            flashOwner: function (owner) {
                owner.element()
                        .fadeOut(250).fadeIn(250)
                        .fadeOut(250).fadeIn(250)
                        .fadeOut(250).fadeIn(250)
                        .fadeOut(250).fadeIn(250)
                        .fadeOut(250).fadeIn(250);
            }
        };
    }
    return Header;
});

