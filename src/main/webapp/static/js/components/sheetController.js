/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
require.config({
    paths: {
        jquery: '../libs/jquery/jquery',
        timeCircles: '../libs/timecircles/TimeCircles',
        fadePlugin: '../libs/ractive/ractive-fade_plgn',
        ractive: '../libs/ractive/ractive',
        crSpline: '../libs/crspline/crSpline',
        playerTab: 'playerTab',
        playerAthlete: 'playerAthlete',
        playerContainer: 'playerContainer',
        sheet: 'sheet'

    },
    shim: {
        'jquery': {
            exports: '$'
        },
        'timeCircles': {
            deps: ['jquery'],
            exports: 'TimeCircles'
        },
        'fadePlugin': {
            deps: ['jquery'],
            exports: 'fadePlugin'
        },
        'ractive': {
            deps: ['jquery'],
            exports: 'ractive'
        },
        'crSpline': {
            deps: ['jquery'],
            exports: 'crSpline'
        },
        'playerTab': {
            deps: ['jquery'],
            exports: 'PlayerTab'
        },
        'playerAthlete': {
            deps: ['jquery'],
            exports: 'PlayerAthlete'
        },
        'playerContainer': {
            deps: ['jquery'],
            exports: 'PlayerContainer'
        },
        'sheet': {
            deps: ['jquery', 'playerContainer'],
            exports: 'Sheet'
        }
    }
});
require(['jquery', 'timeCircles', 'fadePlugin', 'ractive', 'crSpline', 'playerTab', 'playerContainer', 'playerAthlete', 'sheet'],
        function ($, TimeCircles, fadePlugin, ractive, crSpline, PlayerTab, PlayerContainer, PlayerAthlete, Sheet) {
            $(document).ready(function () {

                var sheet = new Sheet(PlayerContainer);

                init();
                initSockets();

                function init() {
                    var tabs = [];
                    var index = 0;
                    $(".positionDiv").each(function () {
                        var tab = new PlayerTab($(this).attr("id"), $(this).find(".title").attr("id"), ".heading");
                        tabs[index++] = tab;
                        tab.addStateListener(sheet);
                        tab.addHeadingListener(sheet);
                        sheet.addPlayerTab(tab);
                    });
                    $(tabs).each(function (index, obj) {
                        obj.setTabs(tabs);
                    });


                    $("#clock").TimeCircles({
                        time: {
                            Days: {show: false},
                            Hours: {show: false},
                            Minutes: {show: false}
                        }
                    });
                }

                function initSockets() {
                    var socketLink = "ws://" + document.location.host + "/DraftManager/draftmanager/macdersonlouis@gmail.com";
                    draftSocket = new WebSocket(socketLink);
                    console.log(draftSocket);
                    draftSocket.onopen = function (evt) {
                        console.log(evt.data);
                    };
                    draftSocket.onmessage = function (evt) {
                        var msg = JSON.parse(evt.data);

                        var players = msg.secondMsg;
                        //console.log(players);
                        for (var i = 0; i < players.length; i++) {
                            var plyr = players[i];
                            var athlete = new PlayerAthlete(plyr);

                            sheet.addAthlete(athlete);
                        }
                        sheet.set();
                    };
                    draftSocket.onerror = function (evt) {
                        //onMessage(evt.data);
                    };
                    draftSocket.onclose = function (evt) {
                        //onMessage(evt.data);
                    };
                }

            });
        });

