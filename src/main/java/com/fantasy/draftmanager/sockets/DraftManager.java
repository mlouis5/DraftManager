/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.sockets;

import com.fantasy.draftmanager.ServiceRequestor;
import com.fantasy.draftmanager.entities.League;
import com.fantasy.draftmanager.entities.PlayerAthlete;
import com.fantasy.draftmanager.pojo.Message;
import com.fantasy.draftmanager.pojo.impl.Board;
import com.fantasy.draftmanager.pojo.impl.Header;
import com.fantasy.draftmanager.pojo.impl.MessageImpl;
import com.fantasy.draftmanager.sockets.messagechain.MessageHandler;
import com.fantasy.draftmanager.sockets.messagechain.SetLeagueLink;
import com.fantasy.draftmanager.sockets.sessionchain.BoardSessionHandler;
import com.fantasy.draftmanager.sockets.sessionchain.OwnerSessionHandler;
import com.fantasy.draftmanager.sockets.sessionchain.SessionHandler;
import com.fantasy.draftmanager.sockets.utilities.JsonEncoderDecoder;
import com.fantasy.draftmanager.sockets.utilities.SessionManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.faces.bean.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author MacDerson
 */
//@ManagedBean(eager=true)
@ApplicationScoped
@Singleton
@ServerEndpoint("/draftmanager/{email}")
public class DraftManager{

    @EJB
    private JsonEncoderDecoder jed;
    @EJB
    private Header header;
    @EJB
    private Board board;
    @EJB
    private SessionManager sessions;
    @EJB(name = "ServiceRequestorImpl")
    private ServiceRequestor requestor;

    public static final String BOARD_PWD = "board";
    public static final String BASE_LEAGUE_RS_PATH = "http://localhost:8080/FantasyWSRS/league";
    private static final String BASE_OWNER_RS_PATH = "http://localhost:8080/FantasyWSRS/owner";
    public static final String BASE_ATHLETE_RS_PATH = "http://localhost:8080/FantasyWSRS/playerathlete";
    
    private League activeLeague;
    private List<League> availableLeagues;
    private List<PlayerAthlete> allAthletes;
    private MessageHandler messageHandlerChain;
    private SessionHandler sessionHandlerChain;
    
    @PostConstruct
    private void initBeans(){
        messageHandlerChain = new SetLeagueLink(this);
        sessionHandlerChain = new BoardSessionHandler(this, requestor);
        OwnerSessionHandler ownerHandler = new OwnerSessionHandler(this, requestor);
        sessionHandlerChain.setNext(ownerHandler);
    }

    @OnOpen
    public void connect(Session session, @PathParam("email") String email) {
        sessionHandlerChain.handle(session, email);
    }

    @OnMessage
    public String onMessage(String message) {
        ObjectMapper om = new ObjectMapper();
        Message<League> msg = null;
        try {
            msg = om.readValue(message, MessageImpl.class);
        } catch (IOException ex) {
            Logger.getLogger(DraftManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Message<League> msg = (MessageImpl<League>) jed.jsonDecode(MessageImpl.class, message);
        System.out.println(message);
        System.out.println(msg);
        
        messageHandlerChain.handle(msg);
        return null;
    }

//    @OnError
//    public void onError(Throwable t) {
//        return;
//    }
    @OnClose
    public void onClose(Session session) {

    }

    private boolean isBoard(String email) {
        return Objects.nonNull(email)
                && Objects.equals(email, BOARD_PWD);
    }

    public void setActiveLeague(League activeLeague){
        this.activeLeague = activeLeague;
        availableLeagues = null;
    }
    
    public SessionManager getSessionManager(){
        return sessions;
    }
    
    public void setAvailableLeagues(List<League> avail){
        availableLeagues = avail;
    }
    
    public void setPlayerAthletes(List<PlayerAthlete> athletes){
        allAthletes = athletes;
    }
    
    public JsonEncoderDecoder getEncoderDecodor(){
        return jed;
    }
    
    public ServiceRequestor getRequestor(){
        return requestor;
    }
    
    public League getActiveLeague(){
        return activeLeague;
    }
}
