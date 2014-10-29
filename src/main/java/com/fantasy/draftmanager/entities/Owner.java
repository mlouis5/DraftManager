/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.draftmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

/**
 *
 * @author MacDerson
 */
@Entity
@Table(name = "owner", catalog = "fantasy", schema = "drafttool")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Owner.findAll", query = "SELECT o FROM Owner o"),
    @NamedQuery(name = "Owner.findByOwnerName", query = "SELECT o FROM Owner o WHERE o.ownerName = :ownerName"),
    @NamedQuery(name = "Owner.findByOwnerEmail", query = "SELECT o FROM Owner o WHERE o.ownerEmail = :ownerEmail"),
    @NamedQuery(name = "Owner.findByTeamName", query = "SELECT o FROM Owner o WHERE o.teamName = :teamName")})
public class Owner implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "owner_name")
    private String ownerName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "owner_email")
    private String ownerEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "team_name")
    private String teamName;
    @JoinColumn(name = "owner_league_name", referencedColumnName = "league_name")
    @ManyToOne(optional = false)
    private League ownerLeagueName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "draftingOwner")
    private List<Pick> pickList;

    public Owner() {
    }

    public Owner(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Owner(String ownerEmail, String ownerName, String teamName) {
        this.ownerEmail = ownerEmail;
        this.ownerName = ownerName;
        this.teamName = teamName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @XmlElement
    @XmlInverseReference(mappedBy="owner")
    public League getOwnerLeagueName() {
        return ownerLeagueName;
    }

    public void setOwnerLeagueName(League ownerLeagueName) {
        this.ownerLeagueName = ownerLeagueName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ownerEmail != null ? ownerEmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Owner)) {
            return false;
        }
        Owner other = (Owner) object;
        if ((this.ownerEmail == null && other.ownerEmail != null) || (this.ownerEmail != null && !this.ownerEmail.equals(other.ownerEmail))) {
            return false;
        }
        return true;
    }
    
    public boolean sameEmail(String email){
         return Objects.equals(this.ownerEmail, email);
    }

    @Override
    public String toString() {
        return "com.fantasy.draftlogger.service.pojo.Owner[ ownerEmail=" + ownerEmail + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public List<Pick> getPickList() {
        return pickList;
    }

    public void setPickList(List<Pick> pickList) {
        this.pickList = pickList;
    }
    
}