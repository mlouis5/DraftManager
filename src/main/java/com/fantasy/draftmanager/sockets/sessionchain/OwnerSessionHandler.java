/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.sockets.sessionchain;

import com.fantasy.draftmanager.ServiceRequestor;
import com.fantasy.draftmanager.entities.League;
import com.fantasy.draftmanager.entities.Owner;
import com.fantasy.draftmanager.entities.PlayerAthlete;
import com.fantasy.draftmanager.pojo.DualMessage;
import com.fantasy.draftmanager.pojo.impl.DualMessageImpl;
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
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author Mac
 */
public class OwnerSessionHandler extends SessionHandler {

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private final ServiceRequestor requestor;

    public OwnerSessionHandler(DraftManager manager, ServiceRequestor requestor) {
        super(manager, Pattern.compile(EMAIL_PATTERN));
        this.requestor = requestor;
    }

    @Override
    public void handleSession(Session sn, String email) {
        SessionManager sessions = manager.getSessionManager();
        if (Objects.nonNull(sn) && Objects.nonNull(email) && Objects.nonNull(sessions)) {
            int sessionSize = manager.getSessionManager().size();
            League activeLeague = manager.getActiveLeague();
            if (Objects.nonNull(activeLeague)) {
                int leagueSize = activeLeague.getNumTeams();

//                if (sessionSize > 0 && sessionSize < (leagueSize + 1)) {
                    Owner connectingOwner = null;

                    for (Owner owner : activeLeague.getOwnerList()) {
                        if (owner.sameEmail(email)) {
                            connectingOwner = owner;
                            break;
                        }
                    }

                    if (Objects.nonNull(connectingOwner)) {
                        sessions.addSession(sn);

                        ClientConfig cfg = new ClientConfig();
                        cfg.register(JacksonJsonProvider.class);
                        List<PlayerAthlete> pAthletes = (List<PlayerAthlete>) requestor.makeGetRequest(DraftManager.BASE_ATHLETE_RS_PATH, null, new GenericType<List<PlayerAthlete>>() {
                        }, MediaType.APPLICATION_JSON_TYPE, cfg);

                        if (Objects.nonNull(pAthletes)) {
                            manager.setPlayerAthletes(pAthletes);
                            DualMessage<Owner, List<PlayerAthlete>> impl = new DualMessageImpl();
                            try {
                                impl.setName("owner");
                                impl.setRoutedTo("draftsheet");
                                impl.setRoutedFrom("draftmanager");
                                impl.setPurpose("init");
                                impl.setJsonObj(connectingOwner);
                                impl.setSecondMsg(pAthletes);
                                JsonEncoderDecoder jed = manager.getEncoderDecodor();
                                String strMsg = jed.jsonEncode(impl);
                                sn.getBasicRemote().sendText(strMsg);
                            } catch (IOException ex) {
                                Logger.getLogger(DraftManager.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
//                }
            }
        }
    }

}
