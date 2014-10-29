/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([], function () {
    function Sheet(_PlayerContainer) {
        var PlayerContainer = _PlayerContainer;
        var players = {
            pageSize: 18,
            singlePage: undefined,
            sort: function (tabId, heading, index) {
                console.log("tabId: " + tabId);
                console.log("heading: " + heading);
                console.log("index: " + index);
                console.log("singlePage len: " + players.singlePage.length);
                
                if (players.singlePage.length > 1) {
                    var tabPos = players.getPositionByTab(tabId);
                    switch (heading) {
                        case 'name':{
                            var bool = tabPos.sortOrderForIndex(index);
                            console.log("sortOrder: " + bool);
                            players.singlePage.sort(function (a, b) {
                                console.log(a.name() + " vs " + b.name());
                                return a.name().localeCompare(b.name());
                            });
                            
                            for(var i = 0; i < players.singlePage.length; i++){
                                console.log(players.singlePage[i]);
                                console.log(players.singlePage[i].name());
                            }
                            
                            if(!bool){
                                players.singlePage.reverse();
                            }
                            break;
                        }
                        case 'team':{
                              players.singlePage.sort(function (a, b) {
                                return a.team().localeCompare(b.team());
                            });
                            break;  
                        }

                    }
                    tabPos.setContainer(false );
                }
            },
            getPositionByTab: function (tabId) {
                switch (tabId.toUpperCase()) {
                    case 'ALL':
                        return this.all;
                    case 'QB':
                        return this.qbs;
                    case 'RB':
                        return this.rbs;
                    case 'WR':
                        return this.wrs;
                    case 'TE':
                        return this.tes;
                    case 'DEF':
                        return this.def;
                    case 'K':
                        return this.k;
                }
            },
            add: function (athlete) {
                this.all.add(athlete);
                this.qbs.add(athlete);
                this.rbs.add(athlete);
                this.wrs.add(athlete);
                this.tes.add(athlete);
                this.def.add(athlete);
                this.k.add(athlete);
            },
            addTab: function (playerTab) {
                this.all.addTab(playerTab);
                this.qbs.addTab(playerTab);
                this.rbs.addTab(playerTab);
                this.wrs.addTab(playerTab);
                this.tes.addTab(playerTab);
                this.def.addTab(playerTab);
                this.k.addTab(playerTab);
            },
            setPlayers: function () {
                this.all.setContainer(true);
                this.qbs.setContainer(true);
                this.rbs.setContainer(true);
                this.wrs.setContainer(true);
                this.tes.setContainer(true);
                this.def.setContainer(true);
                this.k.setContainer(true);
            },
            all: {
                page: 1,
                playerTab: undefined,
                list: [],
                container: undefined,
                sortOrder: [true, false, false, false, false, false, false],
                sortOrderForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        return this.sortOrder[index];
                    }
                    return null;
                },
                negateSortForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        this.sortOrder[index] = !this.sortOrder[index];
                    }
                },
                pageUp: function () {
                    this.page = this.page < Math.ceil(this.list.length / pageSize) ? this.page + 1 : this.page;
                },
                add: function (athlete) {
                    this.list[this.list.length] = athlete;
                },
                addTab: function (pTab) {
                    if (pTab !== undefined) {
                        if (pTab.getId().toUpperCase() === "ALL") {
                            this.playerTab = pTab;
                        }
                    }
                },
                setContainer: function (setPage) {
                    if (this.container === undefined) {
                        this.container = new PlayerContainer('allContainer');
                    }
                    if (this.playerTab.isOpen()) {
                        if(setPage){
                            this.setSinglePage();
                        }
                        this.container.setPlayers(players.singlePage);
                    }
                },
                setSinglePage: function () {
                    var end = (this.page * players.pageSize) <= this.list.length ? ((this.page * players.pageSize)) : this.list.length;
                    var start = (end - (players.pageSize)) >= 0 ? (end - (players.pageSize)) : 0;
                    players.singlePage = this.list.slice(start, end);
                }
            },
            qbs: {
                page: 1,
                playerTab: undefined,
                list: [],
                container: undefined,
                sortOrder: [true, false, false, false, false, false, false],
                sortOrderForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        return this.sortOrder[index];
                    }
                    return null;
                },
                negateSortForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        this.sortOrder[index] = !this.sortOrder[index];
                    }
                },
                add: function (athlete) {
                    if (athlete.pos() === 'QB') {
                        this.list[this.list.length] = athlete;
                    }
                },
                addTab: function (pTab) {
                    if (pTab !== undefined) {
                        if (pTab.getId().toUpperCase() === "QB") {
                            this.playerTab = pTab;
                        }
                    }
                },
                setContainer: function (setPage) {
                    if (this.container === undefined) {
                        this.container = new PlayerContainer('qbContainer');
                    }
                    if (this.playerTab.isOpen()) {
                        if(setPage){
                            this.setSinglePage();
                        }
                        this.container.setPlayers(players.singlePage);
                    }
                },
                setSinglePage: function () {
                    var end = (this.page * players.pageSize) <= this.list.length ? ((this.page * players.pageSize)) : this.list.length;
                    var start = (end - (players.pageSize)) >= 0 ? (end - (players.pageSize)) : 0;
                    players.singlePage = this.list.slice(start, end);
                }
            },
            rbs: {
                page: 1,
                playerTab: undefined,
                list: [],
                container: undefined,
                sortOrder: [true, false, false, false, false, false, false],
                sortOrderForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        return this.sortOrder[index];
                    }
                    return null;
                },
                negateSortForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        this.sortOrder[index] = !this.sortOrder[index];
                    }
                },
                add: function (athlete) {
                    if (athlete.pos() === 'RB') {
                        this.list[this.list.length] = athlete;
                    }
                },
                addTab: function (pTab) {
                    if (pTab !== undefined) {
                        if (pTab.getId().toUpperCase() === "RB") {
                            this.playerTab = pTab;
                        }
                    }
                },
                setContainer: function (setPage) {
                    if (this.container === undefined) {
                        this.container = new PlayerContainer('rbContainer');
                    }
                    if (this.playerTab.isOpen()) {
                        if(setPage){
                            this.setSinglePage();
                        }
                        this.container.setPlayers(players.singlePage);
                    }
                },
                setSinglePage: function () {
                    var end = (this.page * players.pageSize) <= this.list.length ? ((this.page * players.pageSize)) : this.list.length;
                    var start = (end - (players.pageSize)) >= 0 ? (end - (players.pageSize)) : 0;
                    players.singlePage = this.list.slice(start, end);
                }
            },
            wrs: {
                page: 1,
                playerTab: undefined,
                list: [],
                container: undefined,
                sortOrder: [true, false, false, false, false, false, false],
                sortOrderForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        return this.sortOrder[index];
                    }
                    return null;
                },
                negateSortForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        this.sortOrder[index] = !this.sortOrder[index];
                    }
                },
                add: function (athlete) {
                    if (athlete.pos() === 'WR') {
                        this.list[this.list.length] = athlete;
                    }
                },
                addTab: function (pTab) {
                    if (pTab !== undefined) {
                        if (pTab.getId().toUpperCase() === "WR") {
                            this.playerTab = pTab;
                        }
                    }
                },
                setContainer: function (setPage) {
                    console.log("setContainer called: " + setPage);
                    if (this.container === undefined) {
                        this.container = new PlayerContainer('wrContainer');
                    }
                    if (this.playerTab.isOpen()) {
                        if(setPage){
                            this.setSinglePage();
                        }
                        this.container.setPlayers(players.singlePage);
                    }
                },
                setSinglePage: function () {
                    var end = (this.page * players.pageSize) <= this.list.length ? ((this.page * players.pageSize)) : this.list.length;
                    var start = (end - (players.pageSize)) >= 0 ? (end - (players.pageSize)) : 0;
                    players.singlePage = this.list.slice(start, end);
                }
            },
            tes: {
                page: 1,
                playerTab: undefined,
                list: [],
                container: undefined,
                sortOrder: [true, false, false, false, false, false, false],
                sortOrderForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        return this.sortOrder[index];
                    }
                    return null;
                },
                negateSortForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        this.sortOrder[index] = !this.sortOrder[index];
                    }
                },
                add: function (athlete) {
                    if (athlete.pos() === 'TE') {
                        this.list[this.list.length] = athlete;
                    }
                },
                addTab: function (pTab) {
                    if (pTab !== undefined) {
                        if (pTab.getId().toUpperCase() === "TE") {
                            this.playerTab = pTab;
                        }
                    }
                },
                setContainer: function (setPage) {
                    if (this.container === undefined) {
                        this.container = new PlayerContainer('teContainer');
                    }
                    if (this.playerTab.isOpen()) {
                        if(setPage){
                            this.setSinglePage();
                        }
                        this.container.setPlayers(players.singlePage);
                    }
                },
                setSinglePage: function () {
                    var end = (this.page * players.pageSize) <= this.list.length ? ((this.page * players.pageSize)) : this.list.length;
                    var start = (end - (players.pageSize)) >= 0 ? (end - (players.pageSize)) : 0;
                    players.singlePage = this.list.slice(start, end);
                }
            },
            def: {
                page: 1,
                playerTab: undefined,
                list: [],
                container: undefined,
                sortOrder: [true, false, false, false, false, false, false],
                sortOrderForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        return this.sortOrder[index];
                    }
                    return null;
                },
                negateSortForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        this.sortOrder[index] = !this.sortOrder[index];
                    }
                },
                add: function (athlete) {
                    if (athlete.pos() === 'DEF') {
                        this.list[this.list.length] = athlete;
                    }
                },
                addTab: function (pTab) {
                    if (pTab !== undefined) {
                        if (pTab.getId().toUpperCase() === "DEF") {
                            this.playerTab = pTab;
                        }
                    }
                },
                setContainer: function (setPage) {
                    if (this.container === undefined) {
                        this.container = new PlayerContainer('teContainer');
                    }
                    if (this.playerTab.isOpen()) {
                        if(setPage){
                            this.setSinglePage();
                        }
                        this.container.setPlayers(players.singlePage);
                    }
                },
                setSinglePage: function () {
                    var end = (this.page * players.pageSize) <= this.list.length ? ((this.page * players.pageSize)) : this.list.length;
                    var start = (end - (players.pageSize)) >= 0 ? (end - (players.pageSize)) : 0;
                    players.singlePage = this.list.slice(start, end);
                }
            },
            k: {
                page: 1,
                playerTab: undefined,
                list: [],
                container: undefined,
                sortOrder: [true, false, false, false, false, false, false],
                sortOrderForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        return this.sortOrder[index];
                    }
                    return null;
                },
                negateSortForIndex: function(index){
                    if(index >= 0 && index < this.sortOrder.length){
                        this.sortOrder[index] = !this.sortOrder[index];
                    }
                },
                add: function (athlete) {
                    if (athlete.pos() === 'K') {
                        this.list[this.list.length] = athlete;
                    }
                },
                addTab: function (pTab) {
                    if (pTab !== undefined) {
                        if (pTab.getId().toUpperCase() === "K") {
                            this.playerTab = pTab;
                        }
                    }
                },
                setContainer: function (setPage) {
                    if (this.container === undefined) {
                        this.container = new PlayerContainer('kContainer');
                    }
                    if (this.playerTab.isOpen()) {
                        if(setPage){
                            this.setSinglePage();
                        }
                        this.container.setPlayers(players.singlePage);
                    }
                },
                setSinglePage: function () {
                    var end = (this.page * players.pageSize) <= this.list.length ? ((this.page * players.pageSize)) : this.list.length;
                    var start = (end - (players.pageSize)) >= 0 ? (end - (players.pageSize)) : 0;
                    players.singlePage = this.list.slice(start, end);
                }
            }
        };
        function setSingleSheet(tabId) {
            var pos = players.getPositionByTab(tabId);
            pos.setContainer(true);
        }
        
        function sortBy(id, heading, index){
            players.sort(id, heading, index);
        }

        return {
            set: function () {
                players.setPlayers();
            },
            addAthlete: function (athlete) {
                players.add(athlete);
            },
            addPlayerTab: function (playerTab) {
                players.addTab(playerTab);
            },
            tabOpened: function (tabId) {
                setSingleSheet(tabId);
            },
            tabClosed: function (tabId) {

            },
            headingClicked: function (parentId, htmlElement, index) {
                sortBy(parentId, $(htmlElement).attr('data-position'), index);
            }
        };
    }
    return Sheet;
});

