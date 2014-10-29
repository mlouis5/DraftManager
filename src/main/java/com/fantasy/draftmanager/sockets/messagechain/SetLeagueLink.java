/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.sockets.messagechain;

import com.fantasy.draftmanager.entities.League;
import com.fantasy.draftmanager.pojo.Message;
import com.fantasy.draftmanager.sockets.DraftManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mac
 */
public class SetLeagueLink extends MessageHandler{

    private static final String toHandle = "setLeagueName";
    public SetLeagueLink(DraftManager manager) {
        super(manager, toHandle);
    }

    @Override
    public void handleMessage(Message msg) {        
        try {
            ObjectMapper om = new ObjectMapper();            
            String content = om.writeValueAsString(msg.getJsonObj());
            League league = om.readValue(content, League.class);            
            manager.setActiveLeague(league);
        } catch (IOException ex) {
            Logger.getLogger(SetLeagueLink.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
