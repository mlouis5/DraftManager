/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MacDerson
 */
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@cycleId")
@Entity
@Table(name = "pick", catalog = "fantasy", schema = "drafttool")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pick.findAll", query = "SELECT p FROM Pick p"),
    @NamedQuery(name = "Pick.findByPickId", query = "SELECT p FROM Pick p WHERE p.pickId = :pickId")})
public class Pick implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pick_id")
    private Integer pickId;
    @JoinColumn(name = "drafting_owner", referencedColumnName = "owner_email")
    @ManyToOne(optional = false)
    private Owner draftingOwner;
    @JoinColumn(name = "drafted_athlete", referencedColumnName = "id")
    @OneToOne(optional = false)
    private PlayerAthlete draftedAthlete;

    public Pick() {
    }

    public Pick(Integer pickId) {
        this.pickId = pickId;
        System.out.println("PickId constructor: " + pickId);
    }

    public Integer getPickId() {
        System.out.println("getPickId: " + pickId);
        return pickId;
    }

    public void setPickId(Integer pickId) {
        this.pickId = pickId;
        System.out.println("setPickId: " + pickId);
    }
    
    public Owner getDraftingOwner() {
        return draftingOwner;
    }
    
    public void setDraftingOwner(Owner draftingOwner) {
        this.draftingOwner = draftingOwner;
    }

    public PlayerAthlete getDraftedAthlete() {
        return draftedAthlete;
    }

    public void setDraftedAthlete(PlayerAthlete draftedAthlete) {
        this.draftedAthlete = draftedAthlete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pickId != null ? pickId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pick)) {
            return false;
        }
        Pick other = (Pick) object;
        if ((this.pickId == null && other.pickId != null) || (this.pickId != null && !this.pickId.equals(other.pickId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fantasy.draftmanager.entities.Pick[ pickId=" + pickId + " ]";
    }
    
}
