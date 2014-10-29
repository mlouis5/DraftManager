/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.pojo.impl;

import com.fantasy.draftmanager.pojo.Message;

/**
 *
 * @author Mac
 * @param <T>
 */
public class MessageImpl<T> implements Message<T> {

    private String name;
    private String[] routedTo;
    private String routedFrom;
    private String purpose;
    private String responseMsg;
    private T jsonObj;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getRoutedTo() {
        return routedTo;
    }

    public void setRoutedTo(String... routedTo) {
        this.routedTo = routedTo;
    }

    public String getRoutedFrom() {
        return routedFrom;
    }

    public void setRoutedFrom(String routedFrom) {
        this.routedFrom = routedFrom;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public T getJsonObj() {
        return jsonObj;
    }

    public void setJsonObj(T jsonObj) {
        this.jsonObj = jsonObj;
    }
    
}
