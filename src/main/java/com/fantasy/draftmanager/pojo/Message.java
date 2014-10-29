/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.pojo;

/**
 *
 * @author MacDerson
 * @param <T>
 */
public interface Message<T> {
    
    public String getName();

    public void setName(String name);

    public String[] getRoutedTo();

    public void setRoutedTo(String... routedTo);

    public String getRoutedFrom();

    public void setRoutedFrom(String routedFrom);

    public String getPurpose();

    public void setPurpose(String purpose);

    public String getResponseMsg();

    public void setResponseMsg(String responseMsg);

    public T getJsonObj();

    public void setJsonObj(T jsonObj);
}
