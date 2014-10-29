/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
require.config({
    paths: {
        jquery: '../libs/jquery/jquery',
        fadePlugin: '../libs/ractive/ractive-fade_plgn',
        ractive: '../libs/ractive/ractive',
        crSpline: '../libs/crspline/crSpline',
        board: 'board',
        header: 'header',
        owner: 'owner',
        pick: 'pick'
    },
    shim: {
        'jquery': {
            exports: '$'
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
        'board': {
            deps: ['jquery'],
            exports: 'Board'
        },
        'header': {
            deps: ['jquery'],
            exports: 'Header'
        },
        'owner': {
            deps: ['jquery'],
            exports: 'Owner'
        },
        'pick': {
            deps: ['jquery'],
            exports: 'Pick'
        }
    }
});
require(['jquery', 'fadePlugin', 'ractive', 'crSpline', 'board', 'header', 'owner', 'pick'],
        function ($, fadePlugin, ractive, crSpline, Board, Header, Owner, Pick) {
            $(document).ready(function () {
                //console.log(Header);
                var message;
                var jsonObject;
                var leagueName;
                var draftSocket;

                var header = new Header('#summary');
                var board = new Board('#board');
                var owners = [];

                initSockets();
                function initSockets() {
                    var socketLink = "ws://" + document.location.host + document.location.pathname + "draftmanager/board";
                    console.log(socketLink);
                    draftSocket = new WebSocket(socketLink);
                    draftSocket.onopen = function (evt) {

                    };
                    draftSocket.onmessage = function (evt) {
                        console.log(evt.data);
                        decypherMessage(evt.data);
                    };
                    draftSocket.onerror = function (evt) {
                        //onMessage(evt.data);
                    };
                    draftSocket.onclose = function (evt) {
                        //onMessage(evt.data);
                    };
                }

                function decypherMessage(message) {
                    if (message !== null && message !== undefined) {
                        message = JSON.parse(message);
                        console.log(message);
                        routeMessage(message);
                    }
                }
                ;
                function routeMessage(msg) {
                    var purpose = msg.purpose;
                    if (purpose === 'init') {
                        var jsonObj = msg.jsonObj;
                        jsonObject = jsonObj;
                        displayLeagueOptions(jsonObj);
                    }
                }
                ;

                function displayLeagueOptions(jsonObj) {
                    $("#leagueOptions").animate({
                        height: "200px"
                    }, 700);

                    var templateStr = '<p class="instruction">Please select a league</p>{{#leagues:num}}<section id="league{{num}}" class="choice">{{leagueName}}</section>{{/each}}';
                    var choices = new Ractive({
                        el: 'leagueOptions',
                        template: templateStr,
                        data: {leagues: jsonObj}
                    });

                    jsonObj.forEach(setSelectedLeagueListener);
                }

                function setSelectedLeagueListener(element, index, array) {
                    $('#league' + index).on('click', setLeague);
                }

                function setLeague() {
                    if ($(this) !== undefined) {
                        console.log($(this).text());
                        leagueName = $(this).text();
                        var leagueObject;

                        for (var i = 0; i < jsonObject.length; i++) {
                            var obj = jsonObject[i];
                            if (obj !== undefined) {
                                if (obj.leagueName === leagueName) {
                                    leagueObject = obj;
                                    if (draftSocket.readyState === 1) {
                                        message = {
                                            name: "setup",
                                            routedTo: ["DraftManager"],
                                            routedFrom: "BoardController",
                                            purpose: "set league name",
                                            responseMsg: "setLeagueName",
                                            jsonObj: leagueObject
                                        };
                                        draftSocket.send(JSON.stringify(message));
                                    }
                                    break;
                                }
                            }
                        }

                        if (leagueObject !== undefined) {
                            $("#leagueOptions").animate({
                                height: "0"
                            }, 700);

                            var templateStr = '<div id="leagueInfo">\
                            <section id="leagueName" class="leagueDisc">League Name: ' + leagueObject.leagueName + '</section>\
                            <section id="numTeams" class="leagueDisc">Teams: ' + leagueObject.numTeams + '</section>\
                            <section id="numRounds" class="leagueDisc">Rounds: ' + leagueObject.numRounds + '</section>\
                            <section id="secPerPick" class="leagueDisc">Time/Pick: ' + leagueObject.secPerPick + '</section>\
                            <section id="draftType" class="leagueDisc">Draft Type: ' + leagueObject.draftType + '</section>\
                            </div>';

                            var summary = $("#summary");
                            summary.append(templateStr);
                            var ownerList = leagueObject.ownerList;

                            for (var i = 0; i < ownerList.length; i++) {
                                var owner = new Owner(ownerList[i], i);
                                owners[i] = owner;
                                owner.appendTo(summary);
                            }
                        }
                    }
                }
            });
        })
        ;

