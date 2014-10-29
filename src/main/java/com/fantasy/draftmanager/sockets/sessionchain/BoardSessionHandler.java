/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.sockets.sessionchain;

import com.fantasy.draftmanager.ServiceRequestor;
import com.fantasy.draftmanager.entities.League;
import com.fantasy.draftmanager.pojo.Message;
import com.fantasy.draftmanager.pojo.impl.MessageImpl;
import com.fantasy.draftmanager.sockets.DraftManager;
import com.fantasy.draftmanager.sockets.utilities.JsonEncoderDecoder;
import com.fantasy.draftmanager.sockets.utilities.SessionManager;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.websocket.Session;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author Mac
 */
public class BoardSessionHandler extends SessionHandler {

    private final ServiceRequestor requestor;

    public BoardSessionHandler(DraftManager manager, ServiceRequestor requestor) {
        super(manager, Pattern.compile(DraftManager.BOARD_PWD));
        this.requestor = requestor;
    }

    @Override
    public void handleSession(Session sn, String email) {

        System.out.println("REQUESTOR: " + requestor);
        System.out.println(manager);
        if (Objects.nonNull(manager) && Objects.nonNull(requestor)) {
            SessionManager sessions = manager.getSessionManager();
            if (Objects.nonNull(sn) && sessions.isEmpty() && isBoard(email)) {
                ClientConfig cfg = new ClientConfig();
                cfg.register(JacksonJsonProvider.class);

                List<League> leagues = (List<League>) requestor.makeGetRequest(DraftManager.BASE_LEAGUE_RS_PATH, null, new GenericType<List<League>>() {
                }, MediaType.APPLICATION_JSON_TYPE, cfg);

//                System.out.println(response);
//                System.out.println(response.getStatus());
//                if (response.getStatus() == Response.Status.OK.getStatusCode()) {
//                    List<League> leagues = response.readEntity(new GenericType<List<League>>() {
//                    });
//                System.out.println(leagues);

                if (Objects.nonNull(leagues)) {
                    Message<List<League>> impl = new MessageImpl();

                    manager.setAvailableLeagues(leagues);
                    try {
                        impl.setName("leagues");
                        impl.setRoutedTo("drafttool");
                        impl.setRoutedFrom("draftmanager");
                        impl.setPurpose("init");
                        impl.setJsonObj(leagues);
                        sessions.addSession(sn);
                        JsonEncoderDecoder jed = manager.getEncoderDecodor();
                        String strMsg = jed.jsonEncode(impl);
                        sn.getBasicRemote().sendText(strMsg);
                    } catch (IOException ex) {
                        Logger.getLogger(DraftManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
//                }
            }
        }
    }

    private boolean isBoard(String email) {
        return Objects.nonNull(email)
                && Objects.equals(email, DraftManager.BOARD_PWD);
    }

}
