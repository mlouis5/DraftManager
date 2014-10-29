/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.sockets.sessionchain;

import com.fantasy.draftmanager.sockets.DraftManager;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.websocket.Session;

/**
 *
 * @author Mac
 */
public abstract class SessionHandler {

    protected DraftManager manager;
    private Pattern p;
    private SessionHandler nextHandler;

    protected SessionHandler(DraftManager manager, Pattern emailToHandle) {
        this.manager = manager;
        this.p = emailToHandle;
    }

    public void setNext(SessionHandler handler) {
        this.nextHandler = handler;
    }

    public void handle(Session sn, String email) {
        if (Objects.nonNull(email) && Objects.nonNull(sn)) {
            Matcher match = p.matcher(email);
            if (match.matches()) {
                handleSession(sn, email);
            } else if (nextHandler != null) {
                nextHandler.handle(sn, email);
            }
        }
    }

    public abstract void handleSession(Session sn, String email);
}
