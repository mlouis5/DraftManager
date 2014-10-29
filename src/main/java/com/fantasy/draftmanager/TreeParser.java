/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager;

import java.util.AbstractMap;

/**
 *
 * @author Mac
 */
public interface TreeParser {
    
    void parseTree(AbstractMap treeMap);
    
    boolean isTreeParsed();
}
