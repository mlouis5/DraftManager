/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function () {
    function PlayerTab(_tabId, _observableId, _headingClass) {

        var tabId = _tabId;
        var tabTitle = $("#" + _observableId);
        var parent = $("#" + _tabId);
        var isOpen = parent.width() > 1100;
        var otherTabs = [];
        var statelisteners = [];
        var headinglisteners = [];

        $(parent.find(_headingClass)).children().each(function (index, elem) {
            $("#" + elem.id).click(function () {
                headinglisteners.forEach(function (element, index, array) {
                    element.headingClicked(parent.attr("id"), elem, index);
                });
            });
        });

        if (!isOpen) {
            $(parent.find(_headingClass)).children().each(function (index, elem) {
                $("#" + elem.id).css({
                    display: "none"
                });
            });

            $(parent.find(".pContainer")).animate({
                opacity: 0
            }, 200);
        }

        tabTitle.click(function () {
            if (!isOpen) {
                open();
            }
        });

        function close() {
            parent.animate({
                width: "65px"
            }, 600);
            $(parent.find(_headingClass)).children().each(function (index, elem) {
                $("#" + elem.id).animate({
                    display: "none",
                    opacity: 0
                }, 200);
            });

            $(parent.find(".pContainer")).animate({
                opacity: 0
            }, 200);

            isOpen = false;

//            statelisteners.forEach(function(element, index, array){
//                element.tabClosed(tabId);
//            });
        }

        function open() {
            parent.animate({
                width: "1190px"
            }, 600);

            $(otherTabs).each(function (index, obj) {
                if (obj.isOpen() && obj.getId() !== tabId) {
                    obj.close();
                }
            });
            $(parent.find(_headingClass)).children().each(function (index, elem) {
                $("#" + elem.id).css({
                    display: "inline-block",
                    opacity: 0
                }).animate({
                    opacity: 1
                }, 1200);
            });

            $(parent.find(".pContainer")).animate({
                opacity: 1
            }, 1200);
            isOpen = true;

            statelisteners.forEach(function (element, index, array) {
                element.tabOpened(tabId);
            });
        }

        return{
            close: function () {
                close();
            },
            isOpen: function () {
                return isOpen;
            },
            setTabs: function (_tabs) {
                otherTabs = _tabs;
            },
            getId: function () {
                return tabId;
            },
            addStateListener: function (listener) {
                if (listener !== null && listener !== undefined) {
                    statelisteners.push(listener);
                }
            },
            addHeadingListener: function (listener) {
                if (listener !== null && listener !== undefined) {
                    headinglisteners.push(listener);
                }
            }
        };
    }
    return PlayerTab;
});

