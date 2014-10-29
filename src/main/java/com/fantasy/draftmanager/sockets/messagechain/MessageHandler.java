/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.sockets.messagechain;

import com.fantasy.draftmanager.pojo.Message;
import com.fantasy.draftmanager.sockets.DraftManager;

/**
 *
 * @author Mac
 */
public abstract class MessageHandler {
    
    protected DraftManager manager;
    private final String msgToHandle;
    private MessageHandler handler;
    
    protected MessageHandler(DraftManager manager, String msgToHandle){
        this.manager = manager;
        this.msgToHandle = msgToHandle;
    }
    
    public void setNext(MessageHandler handler){
        this.handler = handler;
    }
    
    public void handle(Message msg){
        if(msg.getResponseMsg().equalsIgnoreCase(msgToHandle)){
            handleMessage(msg);
        }else if(handler != null){
            handler.handle(msg);
        }
    }
    
    public abstract void handleMessage(Message msg);
}
