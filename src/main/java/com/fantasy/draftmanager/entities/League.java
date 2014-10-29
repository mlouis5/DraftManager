/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.entities;

import com.fantasy.draftmanager.annotations.SerializableProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MacDerson
 */
@Entity
@Table(name = "league", catalog = "fantasy", schema = "drafttool")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "League.findAll", query = "SELECT l FROM League l"),
    @NamedQuery(name = "League.findByLeagueName", query = "SELECT l FROM League l WHERE l.leagueName = :leagueName"),
    @NamedQuery(name = "League.findByNumTeams", query = "SELECT l FROM League l WHERE l.numTeams = :numTeams"),
    @NamedQuery(name = "League.findByNumRounds", query = "SELECT l FROM League l WHERE l.numRounds = :numRounds"),
    @NamedQuery(name = "League.findByDraftType", query = "SELECT l FROM League l WHERE l.draftType = :draftType"),
    @NamedQuery(name = "League.findBySecPerPick", query = "SELECT l FROM League l WHERE l.secPerPick = :secPerPick")})
public class League implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "league_name")
    @SerializableProperty//(getter = "getLeagueName")
    private String leagueName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_teams")
    @SerializableProperty//(getter = "getNumTeams")
    private int numTeams;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_rounds")
    @SerializableProperty//(getter = "getNumRounds")
    private int numRounds;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "draft_type")
    @SerializableProperty//(getter = "getDraftType")
    private String draftType;
    @Column(name = "sec_per_pick")
    @SerializableProperty
    private Integer secPerPick;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerLeagueName", fetch = FetchType.EAGER)
    @SerializableProperty
    private List<Owner> ownerList;

    public League() {
    }

    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    public League(String leagueName, int numTeams, int numRounds, String draftType) {
        this.leagueName = leagueName;
        this.numTeams = numTeams;
        this.numRounds = numRounds;
        this.draftType = draftType;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getNumTeams() {
        return numTeams;
    }

    public void setNumTeams(int numTeams) {
        this.numTeams = numTeams;
    }

    public int getNumRounds() {
        return numRounds;
    }

    public void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }

    public String getDraftType() {
        return draftType;
    }

    public void setDraftType(String draftType) {
        this.draftType = draftType;
    }

    public Integer getSecPerPick() {
        return secPerPick;
    }

    public void setSecPerPick(Integer secPerPick) {
        this.secPerPick = secPerPick;
    }

    //@XmlTransient
    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leagueName != null ? leagueName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof League)) {
            return false;
        }
        League other = (League) object;
        if ((this.leagueName == null && other.leagueName != null) || (this.leagueName != null && !this.leagueName.equals(other.leagueName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fantasy.draftmanager.entities.League[ leagueName=" + leagueName + " ]\n" + ownerList;
    }

}
