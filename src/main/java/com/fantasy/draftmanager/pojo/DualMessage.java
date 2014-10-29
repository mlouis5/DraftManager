/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.pojo;

/**
 *
 * @author Mac
 * @param <F>
 * @param <S>
 */
public interface DualMessage<F, S> extends Message<F> {

    public S getSecondMsg();

    public void setSecondMsg(S secondMsg);
}
