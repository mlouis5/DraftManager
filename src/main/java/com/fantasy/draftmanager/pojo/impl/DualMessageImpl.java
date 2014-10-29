/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.pojo.impl;

import com.fantasy.draftmanager.pojo.DualMessage;

/**
 *
 * @author Mac
 * @param <F>
 * @param <S>
 */
public class DualMessageImpl<F, S> implements DualMessage<F, S> {

    private String name;
    private String[] routedTo;
    private String routedFrom;
    private String purpose;
    private String responseMsg;
    private F jsonObj;
    private S secondMsg;

    @Override
    public S getSecondMsg() {
        return secondMsg;
    }

    @Override
    public void setSecondMsg(S secondMsg) {
        this.secondMsg = secondMsg;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String[] getRoutedTo() {
        return routedTo;
    }

    @Override
    public void setRoutedTo(String[] routedTo) {
        this.routedTo = routedTo;
    }

    @Override
    public String getRoutedFrom() {
        return routedFrom;
    }

    @Override
    public void setRoutedFrom(String routedFrom) {
        this.routedFrom = routedFrom;
    }

    @Override
    public String getPurpose() {
        return purpose;
    }

    @Override
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String getResponseMsg() {
        return responseMsg;
    }

    @Override
    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    @Override
    public F getJsonObj() {
        return jsonObj;
    }

    @Override
    public void setJsonObj(F jsonObj) {
        this.jsonObj = jsonObj;
    }
    
    
}
