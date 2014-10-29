/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.pojo.impl;

import com.fantasy.draftmanager.entities.Owner;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.ejb.Singleton;

/**
 *
 * @author MacDerson
 */
@Singleton
public class Header {

    private static final int DEFAULT_NUM_OWNERS = 12;
    private final Set<Owner> owners;

    public Header() {
        owners = new LinkedHashSet(DEFAULT_NUM_OWNERS);
    }

    public Owner getOwner(int ownerIndex) {
        int index = 0;
        int size = owners.size();
        Iterator<Owner> it = owners.iterator();

        Owner owner = null;
        while (it.hasNext() && index < size) {
            if (index++ == ownerIndex) {
                owner = it.next();
                break;
            }
        }
        return owner;
    }

    public Owner getOwner(String email) {
        Owner owner = null;

        Iterator<Owner> it = owners.iterator();
        while (it.hasNext()) {
            Owner o = it.next();
            if (Objects.nonNull(o) && Objects.equals(o.getOwnerEmail(), email)) {
                owner = o;
                break;
            }
        }
        return owner;
    }

    public void setOwner(Owner owner) {
        if (Objects.nonNull(owner)) {
            if (!owners.contains(owner)) {
                owners.add(owner);
            }
        }
    }
    
    public void setOwners(List<Owner> owners){
        if(Objects.nonNull(owners)){
            this.owners.addAll(owners);
        }
    }

}
