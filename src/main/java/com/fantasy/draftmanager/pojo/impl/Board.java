/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.pojo.impl;

import com.fantasy.draftmanager.entities.Owner;
import com.fantasy.draftmanager.entities.Pick;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import javax.ejb.Singleton;

/**
 *
 * @author MacDerson
 */
@Singleton
public class Board {

    private final Map<Owner, List<Pick>> picks;

    public Board() {
        picks = new LinkedHashMap();
    }

    public void setPick(Owner owner, Pick pick) {
        if (Objects.nonNull(owner) && Objects.nonNull(pick)) {
            List<Pick> ownerPicks = getPicks(owner);
            if (Objects.nonNull(ownerPicks)) {
                if (!ownerPicks.contains(pick)) {
                    ownerPicks.add(pick);
                }
            }
        }
    }

    public List<Pick> getPicksFor(Owner owner) {
        return Optional.ofNullable(getPicks(owner)).orElse(new ArrayList(0));
    }

    public Pick getPickFor(Owner owner, int roundDrafted) {
        try {
            return Optional.ofNullable(getPicks(owner)).filter((l) -> {
                return Objects.nonNull(l) && roundDrafted < l.size() && roundDrafted >= 0;
            }).get().get(roundDrafted);
        } catch (NoSuchElementException nsee) {
        }
        return null;
    }

    private List<Pick> getPicks(Owner owner) {
        if (Objects.nonNull(owner)) {
            return picks.get(owner);
        }
        return null;
    }
}
