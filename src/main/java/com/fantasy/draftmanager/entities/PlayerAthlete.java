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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MacDerson
 */
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@cycleId")
@Entity
@Table(name = "player_athlete", catalog = "fantasy", schema = "drafttool")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlayerAthlete.findAll", query = "SELECT p FROM PlayerAthlete p"),
    @NamedQuery(name = "PlayerAthlete.findByName", query = "SELECT p FROM PlayerAthlete p WHERE p.name = :name"),
    @NamedQuery(name = "PlayerAthlete.findById", query = "SELECT p FROM PlayerAthlete p WHERE p.id = :id"),
    @NamedQuery(name = "PlayerAthlete.findByHome", query = "SELECT p FROM PlayerAthlete p WHERE p.home = :home"),
    @NamedQuery(name = "PlayerAthlete.findByTeam", query = "SELECT p FROM PlayerAthlete p WHERE p.team = :team"),
    @NamedQuery(name = "PlayerAthlete.findByPos", query = "SELECT p FROM PlayerAthlete p WHERE p.pos = :pos"),
    @NamedQuery(name = "PlayerAthlete.findByDefenseAst", query = "SELECT p FROM PlayerAthlete p WHERE p.defenseAst = :defenseAst"),
    @NamedQuery(name = "PlayerAthlete.findByDefenseFfum", query = "SELECT p FROM PlayerAthlete p WHERE p.defenseFfum = :defenseFfum"),
    @NamedQuery(name = "PlayerAthlete.findByDefenseInt", query = "SELECT p FROM PlayerAthlete p WHERE p.defenseInt = :defenseInt"),
    @NamedQuery(name = "PlayerAthlete.findByDefenseSk", query = "SELECT p FROM PlayerAthlete p WHERE p.defenseSk = :defenseSk"),
    @NamedQuery(name = "PlayerAthlete.findByDefenseTkl", query = "SELECT p FROM PlayerAthlete p WHERE p.defenseTkl = :defenseTkl"),
    @NamedQuery(name = "PlayerAthlete.findByFumblesLost", query = "SELECT p FROM PlayerAthlete p WHERE p.fumblesLost = :fumblesLost"),
    @NamedQuery(name = "PlayerAthlete.findByFumblesRcv", query = "SELECT p FROM PlayerAthlete p WHERE p.fumblesRcv = :fumblesRcv"),
    @NamedQuery(name = "PlayerAthlete.findByFumblesTot", query = "SELECT p FROM PlayerAthlete p WHERE p.fumblesTot = :fumblesTot"),
    @NamedQuery(name = "PlayerAthlete.findByFumblesTrcv", query = "SELECT p FROM PlayerAthlete p WHERE p.fumblesTrcv = :fumblesTrcv"),
    @NamedQuery(name = "PlayerAthlete.findByFumblesYds", query = "SELECT p FROM PlayerAthlete p WHERE p.fumblesYds = :fumblesYds"),
    @NamedQuery(name = "PlayerAthlete.findByKickingFga", query = "SELECT p FROM PlayerAthlete p WHERE p.kickingFga = :kickingFga"),
    @NamedQuery(name = "PlayerAthlete.findByKickingFgm", query = "SELECT p FROM PlayerAthlete p WHERE p.kickingFgm = :kickingFgm"),
    @NamedQuery(name = "PlayerAthlete.findByKickingFgyds", query = "SELECT p FROM PlayerAthlete p WHERE p.kickingFgyds = :kickingFgyds"),
    @NamedQuery(name = "PlayerAthlete.findByKickingTotpfg", query = "SELECT p FROM PlayerAthlete p WHERE p.kickingTotpfg = :kickingTotpfg"),
    @NamedQuery(name = "PlayerAthlete.findByKickingXpa", query = "SELECT p FROM PlayerAthlete p WHERE p.kickingXpa = :kickingXpa"),
    @NamedQuery(name = "PlayerAthlete.findByKickingXpb", query = "SELECT p FROM PlayerAthlete p WHERE p.kickingXpb = :kickingXpb"),
    @NamedQuery(name = "PlayerAthlete.findByKickingXpmade", query = "SELECT p FROM PlayerAthlete p WHERE p.kickingXpmade = :kickingXpmade"),
    @NamedQuery(name = "PlayerAthlete.findByKickingXpmissed", query = "SELECT p FROM PlayerAthlete p WHERE p.kickingXpmissed = :kickingXpmissed"),
    @NamedQuery(name = "PlayerAthlete.findByKickingXptot", query = "SELECT p FROM PlayerAthlete p WHERE p.kickingXptot = :kickingXptot"),
    @NamedQuery(name = "PlayerAthlete.findByKickretAvg", query = "SELECT p FROM PlayerAthlete p WHERE p.kickretAvg = :kickretAvg"),
    @NamedQuery(name = "PlayerAthlete.findByKickretLng", query = "SELECT p FROM PlayerAthlete p WHERE p.kickretLng = :kickretLng"),
    @NamedQuery(name = "PlayerAthlete.findByKickretLngtd", query = "SELECT p FROM PlayerAthlete p WHERE p.kickretLngtd = :kickretLngtd"),
    @NamedQuery(name = "PlayerAthlete.findByKickretRet", query = "SELECT p FROM PlayerAthlete p WHERE p.kickretRet = :kickretRet"),
    @NamedQuery(name = "PlayerAthlete.findByKickretTds", query = "SELECT p FROM PlayerAthlete p WHERE p.kickretTds = :kickretTds"),
    @NamedQuery(name = "PlayerAthlete.findByPassingAtt", query = "SELECT p FROM PlayerAthlete p WHERE p.passingAtt = :passingAtt"),
    @NamedQuery(name = "PlayerAthlete.findByPassingCmp", query = "SELECT p FROM PlayerAthlete p WHERE p.passingCmp = :passingCmp"),
    @NamedQuery(name = "PlayerAthlete.findByPassingInts", query = "SELECT p FROM PlayerAthlete p WHERE p.passingInts = :passingInts"),
    @NamedQuery(name = "PlayerAthlete.findByPassingTds", query = "SELECT p FROM PlayerAthlete p WHERE p.passingTds = :passingTds"),
    @NamedQuery(name = "PlayerAthlete.findByPassingTwopta", query = "SELECT p FROM PlayerAthlete p WHERE p.passingTwopta = :passingTwopta"),
    @NamedQuery(name = "PlayerAthlete.findByPassingTwoptm", query = "SELECT p FROM PlayerAthlete p WHERE p.passingTwoptm = :passingTwoptm"),
    @NamedQuery(name = "PlayerAthlete.findByPassingYds", query = "SELECT p FROM PlayerAthlete p WHERE p.passingYds = :passingYds"),
    @NamedQuery(name = "PlayerAthlete.findByPuntingAvg", query = "SELECT p FROM PlayerAthlete p WHERE p.puntingAvg = :puntingAvg"),
    @NamedQuery(name = "PlayerAthlete.findByPuntingI20", query = "SELECT p FROM PlayerAthlete p WHERE p.puntingI20 = :puntingI20"),
    @NamedQuery(name = "PlayerAthlete.findByPuntingLng", query = "SELECT p FROM PlayerAthlete p WHERE p.puntingLng = :puntingLng"),
    @NamedQuery(name = "PlayerAthlete.findByPuntingPts", query = "SELECT p FROM PlayerAthlete p WHERE p.puntingPts = :puntingPts"),
    @NamedQuery(name = "PlayerAthlete.findByPuntingYds", query = "SELECT p FROM PlayerAthlete p WHERE p.puntingYds = :puntingYds"),
    @NamedQuery(name = "PlayerAthlete.findByPuntretAvg", query = "SELECT p FROM PlayerAthlete p WHERE p.puntretAvg = :puntretAvg"),
    @NamedQuery(name = "PlayerAthlete.findByPuntretLng", query = "SELECT p FROM PlayerAthlete p WHERE p.puntretLng = :puntretLng"),
    @NamedQuery(name = "PlayerAthlete.findByPuntretLngtd", query = "SELECT p FROM PlayerAthlete p WHERE p.puntretLngtd = :puntretLngtd"),
    @NamedQuery(name = "PlayerAthlete.findByPuntretRet", query = "SELECT p FROM PlayerAthlete p WHERE p.puntretRet = :puntretRet"),
    @NamedQuery(name = "PlayerAthlete.findByPuntretTds", query = "SELECT p FROM PlayerAthlete p WHERE p.puntretTds = :puntretTds"),
    @NamedQuery(name = "PlayerAthlete.findByReceivingLng", query = "SELECT p FROM PlayerAthlete p WHERE p.receivingLng = :receivingLng"),
    @NamedQuery(name = "PlayerAthlete.findByReceivingLngtd", query = "SELECT p FROM PlayerAthlete p WHERE p.receivingLngtd = :receivingLngtd"),
    @NamedQuery(name = "PlayerAthlete.findByReceivingRec", query = "SELECT p FROM PlayerAthlete p WHERE p.receivingRec = :receivingRec"),
    @NamedQuery(name = "PlayerAthlete.findByReceivingTds", query = "SELECT p FROM PlayerAthlete p WHERE p.receivingTds = :receivingTds"),
    @NamedQuery(name = "PlayerAthlete.findByReceivingTwopta", query = "SELECT p FROM PlayerAthlete p WHERE p.receivingTwopta = :receivingTwopta"),
    @NamedQuery(name = "PlayerAthlete.findByReceivingTwoptm", query = "SELECT p FROM PlayerAthlete p WHERE p.receivingTwoptm = :receivingTwoptm"),
    @NamedQuery(name = "PlayerAthlete.findByReceivingYds", query = "SELECT p FROM PlayerAthlete p WHERE p.receivingYds = :receivingYds"),
    @NamedQuery(name = "PlayerAthlete.findByRushingAtt", query = "SELECT p FROM PlayerAthlete p WHERE p.rushingAtt = :rushingAtt"),
    @NamedQuery(name = "PlayerAthlete.findByRushingLng", query = "SELECT p FROM PlayerAthlete p WHERE p.rushingLng = :rushingLng"),
    @NamedQuery(name = "PlayerAthlete.findByRushingLngtd", query = "SELECT p FROM PlayerAthlete p WHERE p.rushingLngtd = :rushingLngtd"),
    @NamedQuery(name = "PlayerAthlete.findByRushingTds", query = "SELECT p FROM PlayerAthlete p WHERE p.rushingTds = :rushingTds"),
    @NamedQuery(name = "PlayerAthlete.findByRushingTwopta", query = "SELECT p FROM PlayerAthlete p WHERE p.rushingTwopta = :rushingTwopta"),
    @NamedQuery(name = "PlayerAthlete.findByRushingTwoptm", query = "SELECT p FROM PlayerAthlete p WHERE p.rushingTwoptm = :rushingTwoptm"),
    @NamedQuery(name = "PlayerAthlete.findByRushingYds", query = "SELECT p FROM PlayerAthlete p WHERE p.rushingYds = :rushingYds"),
    @NamedQuery(name = "PlayerAthlete.findByStatisticYear", query = "SELECT p FROM PlayerAthlete p WHERE p.statisticYear = :statisticYear"),
    @NamedQuery(name = "PlayerAthlete.findByDrafted", query = "SELECT p FROM PlayerAthlete p WHERE p.drafted = :drafted")})
public class PlayerAthlete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 3)
    @Column(name = "home")
    private String home;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "team")
    private String team;
    @Size(max = 3)
    @Column(name = "pos")
    private String pos;
    @Column(name = "defense_ast")
    private Integer defenseAst;
    @Column(name = "defense_ffum")
    private Integer defenseFfum;
    @Column(name = "defense_int")
    private Integer defenseInt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "defense_sk")
    private Double defenseSk;
    @Column(name = "defense_tkl")
    private Integer defenseTkl;
    @Column(name = "fumbles_lost")
    private Integer fumblesLost;
    @Column(name = "fumbles_rcv")
    private Integer fumblesRcv;
    @Column(name = "fumbles_tot")
    private Integer fumblesTot;
    @Column(name = "fumbles_trcv")
    private Integer fumblesTrcv;
    @Column(name = "fumbles_yds")
    private Integer fumblesYds;
    @Column(name = "kicking_fga")
    private Integer kickingFga;
    @Column(name = "kicking_fgm")
    private Integer kickingFgm;
    @Column(name = "kicking_fgyds")
    private Integer kickingFgyds;
    @Column(name = "kicking_totpfg")
    private Integer kickingTotpfg;
    @Column(name = "kicking_xpa")
    private Integer kickingXpa;
    @Column(name = "kicking_xpb")
    private Integer kickingXpb;
    @Column(name = "kicking_xpmade")
    private Integer kickingXpmade;
    @Column(name = "kicking_xpmissed")
    private Integer kickingXpmissed;
    @Column(name = "kicking_xptot")
    private Integer kickingXptot;
    @Column(name = "kickret_avg")
    private Double kickretAvg;
    @Column(name = "kickret_lng")
    private Integer kickretLng;
    @Column(name = "kickret_lngtd")
    private Integer kickretLngtd;
    @Column(name = "kickret_ret")
    private Integer kickretRet;
    @Column(name = "kickret_tds")
    private Integer kickretTds;
    @Column(name = "passing_att")
    private Integer passingAtt;
    @Column(name = "passing_cmp")
    private Integer passingCmp;
    @Column(name = "passing_ints")
    private Integer passingInts;
    @Column(name = "passing_tds")
    private Integer passingTds;
    @Column(name = "passing_twopta")
    private Integer passingTwopta;
    @Column(name = "passing_twoptm")
    private Integer passingTwoptm;
    @Column(name = "passing_yds")
    private Integer passingYds;
    @Column(name = "punting_avg")
    private Double puntingAvg;
    @Column(name = "punting_i20")
    private Integer puntingI20;
    @Column(name = "punting_lng")
    private Integer puntingLng;
    @Column(name = "punting_pts")
    private Integer puntingPts;
    @Column(name = "punting_yds")
    private Integer puntingYds;
    @Column(name = "puntret_avg")
    private Double puntretAvg;
    @Column(name = "puntret_lng")
    private Integer puntretLng;
    @Column(name = "puntret_lngtd")
    private Integer puntretLngtd;
    @Column(name = "puntret_ret")
    private Integer puntretRet;
    @Column(name = "puntret_tds")
    private Integer puntretTds;
    @Column(name = "receiving_lng")
    private Integer receivingLng;
    @Column(name = "receiving_lngtd")
    private Integer receivingLngtd;
    @Column(name = "receiving_rec")
    private Integer receivingRec;
    @Column(name = "receiving_tds")
    private Integer receivingTds;
    @Column(name = "receiving_twopta")
    private Integer receivingTwopta;
    @Column(name = "receiving_twoptm")
    private Integer receivingTwoptm;
    @Column(name = "receiving_yds")
    private Integer receivingYds;
    @Column(name = "rushing_att")
    private Integer rushingAtt;
    @Column(name = "rushing_lng")
    private Integer rushingLng;
    @Column(name = "rushing_lngtd")
    private Integer rushingLngtd;
    @Column(name = "rushing_tds")
    private Integer rushingTds;
    @Column(name = "rushing_twopta")
    private Integer rushingTwopta;
    @Column(name = "rushing_twoptm")
    private Integer rushingTwoptm;
    @Column(name = "rushing_yds")
    private Integer rushingYds;
    @Column(name = "statistic_year")
    private Integer statisticYear;
    @Column(name = "drafted")
    private Boolean drafted;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "draftedAthlete")
//    private Pick pick;

    public PlayerAthlete() {
    }

    public PlayerAthlete(Integer id) {
        this.id = id;
        System.out.println("constructor PlayerAthlete Id: " + this.id);
    }

    public PlayerAthlete(Integer id, String name, String team) {
        this.id = id;
        this.name = name;
        this.team = team;
        System.out.println("constructor[multi] PlayerAthlete Id: " + this.id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        System.out.println("getId: " + this.id);
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        System.out.println("setId: " + this.id);
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getDefenseAst() {
        return defenseAst;
    }

    public void setDefenseAst(Integer defenseAst) {
        this.defenseAst = defenseAst;
    }

    public Integer getDefenseFfum() {
        return defenseFfum;
    }

    public void setDefenseFfum(Integer defenseFfum) {
        this.defenseFfum = defenseFfum;
    }

    public Integer getDefenseInt() {
        return defenseInt;
    }

    public void setDefenseInt(Integer defenseInt) {
        this.defenseInt = defenseInt;
    }

    public Double getDefenseSk() {
        return defenseSk;
    }

    public void setDefenseSk(Double defenseSk) {
        this.defenseSk = defenseSk;
    }

    public Integer getDefenseTkl() {
        return defenseTkl;
    }

    public void setDefenseTkl(Integer defenseTkl) {
        this.defenseTkl = defenseTkl;
    }

    public Integer getFumblesLost() {
        return fumblesLost;
    }

    public void setFumblesLost(Integer fumblesLost) {
        this.fumblesLost = fumblesLost;
    }

    public Integer getFumblesRcv() {
        return fumblesRcv;
    }

    public void setFumblesRcv(Integer fumblesRcv) {
        this.fumblesRcv = fumblesRcv;
    }

    public Integer getFumblesTot() {
        return fumblesTot;
    }

    public void setFumblesTot(Integer fumblesTot) {
        this.fumblesTot = fumblesTot;
    }

    public Integer getFumblesTrcv() {
        return fumblesTrcv;
    }

    public void setFumblesTrcv(Integer fumblesTrcv) {
        this.fumblesTrcv = fumblesTrcv;
    }

    public Integer getFumblesYds() {
        return fumblesYds;
    }

    public void setFumblesYds(Integer fumblesYds) {
        this.fumblesYds = fumblesYds;
    }

    public Integer getKickingFga() {
        return kickingFga;
    }

    public void setKickingFga(Integer kickingFga) {
        this.kickingFga = kickingFga;
    }

    public Integer getKickingFgm() {
        return kickingFgm;
    }

    public void setKickingFgm(Integer kickingFgm) {
        this.kickingFgm = kickingFgm;
    }

    public Integer getKickingFgyds() {
        return kickingFgyds;
    }

    public void setKickingFgyds(Integer kickingFgyds) {
        this.kickingFgyds = kickingFgyds;
    }

    public Integer getKickingTotpfg() {
        return kickingTotpfg;
    }

    public void setKickingTotpfg(Integer kickingTotpfg) {
        this.kickingTotpfg = kickingTotpfg;
    }

    public Integer getKickingXpa() {
        return kickingXpa;
    }

    public void setKickingXpa(Integer kickingXpa) {
        this.kickingXpa = kickingXpa;
    }

    public Integer getKickingXpb() {
        return kickingXpb;
    }

    public void setKickingXpb(Integer kickingXpb) {
        this.kickingXpb = kickingXpb;
    }

    public Integer getKickingXpmade() {
        return kickingXpmade;
    }

    public void setKickingXpmade(Integer kickingXpmade) {
        this.kickingXpmade = kickingXpmade;
    }

    public Integer getKickingXpmissed() {
        return kickingXpmissed;
    }

    public void setKickingXpmissed(Integer kickingXpmissed) {
        this.kickingXpmissed = kickingXpmissed;
    }

    public Integer getKickingXptot() {
        return kickingXptot;
    }

    public void setKickingXptot(Integer kickingXptot) {
        this.kickingXptot = kickingXptot;
    }

    public Double getKickretAvg() {
        return kickretAvg;
    }

    public void setKickretAvg(Double kickretAvg) {
        this.kickretAvg = kickretAvg;
    }

    public Integer getKickretLng() {
        return kickretLng;
    }

    public void setKickretLng(Integer kickretLng) {
        this.kickretLng = kickretLng;
    }

    public Integer getKickretLngtd() {
        return kickretLngtd;
    }

    public void setKickretLngtd(Integer kickretLngtd) {
        this.kickretLngtd = kickretLngtd;
    }

    public Integer getKickretRet() {
        return kickretRet;
    }

    public void setKickretRet(Integer kickretRet) {
        this.kickretRet = kickretRet;
    }

    public Integer getKickretTds() {
        return kickretTds;
    }

    public void setKickretTds(Integer kickretTds) {
        this.kickretTds = kickretTds;
    }

    public Integer getPassingAtt() {
        return passingAtt;
    }

    public void setPassingAtt(Integer passingAtt) {
        this.passingAtt = passingAtt;
    }

    public Integer getPassingCmp() {
        return passingCmp;
    }

    public void setPassingCmp(Integer passingCmp) {
        this.passingCmp = passingCmp;
    }

    public Integer getPassingInts() {
        return passingInts;
    }

    public void setPassingInts(Integer passingInts) {
        this.passingInts = passingInts;
    }

    public Integer getPassingTds() {
        return passingTds;
    }

    public void setPassingTds(Integer passingTds) {
        this.passingTds = passingTds;
    }

    public Integer getPassingTwopta() {
        return passingTwopta;
    }

    public void setPassingTwopta(Integer passingTwopta) {
        this.passingTwopta = passingTwopta;
    }

    public Integer getPassingTwoptm() {
        return passingTwoptm;
    }

    public void setPassingTwoptm(Integer passingTwoptm) {
        this.passingTwoptm = passingTwoptm;
    }

    public Integer getPassingYds() {
        return passingYds;
    }

    public void setPassingYds(Integer passingYds) {
        this.passingYds = passingYds;
    }

    public Double getPuntingAvg() {
        return puntingAvg;
    }

    public void setPuntingAvg(Double puntingAvg) {
        this.puntingAvg = puntingAvg;
    }

    public Integer getPuntingI20() {
        return puntingI20;
    }

    public void setPuntingI20(Integer puntingI20) {
        this.puntingI20 = puntingI20;
    }

    public Integer getPuntingLng() {
        return puntingLng;
    }

    public void setPuntingLng(Integer puntingLng) {
        this.puntingLng = puntingLng;
    }

    public Integer getPuntingPts() {
        return puntingPts;
    }

    public void setPuntingPts(Integer puntingPts) {
        this.puntingPts = puntingPts;
    }

    public Integer getPuntingYds() {
        return puntingYds;
    }

    public void setPuntingYds(Integer puntingYds) {
        this.puntingYds = puntingYds;
    }

    public Double getPuntretAvg() {
        return puntretAvg;
    }

    public void setPuntretAvg(Double puntretAvg) {
        this.puntretAvg = puntretAvg;
    }

    public Integer getPuntretLng() {
        return puntretLng;
    }

    public void setPuntretLng(Integer puntretLng) {
        this.puntretLng = puntretLng;
    }

    public Integer getPuntretLngtd() {
        return puntretLngtd;
    }

    public void setPuntretLngtd(Integer puntretLngtd) {
        this.puntretLngtd = puntretLngtd;
    }

    public Integer getPuntretRet() {
        return puntretRet;
    }

    public void setPuntretRet(Integer puntretRet) {
        this.puntretRet = puntretRet;
    }

    public Integer getPuntretTds() {
        return puntretTds;
    }

    public void setPuntretTds(Integer puntretTds) {
        this.puntretTds = puntretTds;
    }

    public Integer getReceivingLng() {
        return receivingLng;
    }

    public void setReceivingLng(Integer receivingLng) {
        this.receivingLng = receivingLng;
    }

    public Integer getReceivingLngtd() {
        return receivingLngtd;
    }

    public void setReceivingLngtd(Integer receivingLngtd) {
        this.receivingLngtd = receivingLngtd;
    }

    public Integer getReceivingRec() {
        return receivingRec;
    }

    public void setReceivingRec(Integer receivingRec) {
        this.receivingRec = receivingRec;
    }

    public Integer getReceivingTds() {
        return receivingTds;
    }

    public void setReceivingTds(Integer receivingTds) {
        this.receivingTds = receivingTds;
    }

    public Integer getReceivingTwopta() {
        return receivingTwopta;
    }

    public void setReceivingTwopta(Integer receivingTwopta) {
        this.receivingTwopta = receivingTwopta;
    }

    public Integer getReceivingTwoptm() {
        return receivingTwoptm;
    }

    public void setReceivingTwoptm(Integer receivingTwoptm) {
        this.receivingTwoptm = receivingTwoptm;
    }

    public Integer getReceivingYds() {
        return receivingYds;
    }

    public void setReceivingYds(Integer receivingYds) {
        this.receivingYds = receivingYds;
    }

    public Integer getRushingAtt() {
        return rushingAtt;
    }

    public void setRushingAtt(Integer rushingAtt) {
        this.rushingAtt = rushingAtt;
    }

    public Integer getRushingLng() {
        return rushingLng;
    }

    public void setRushingLng(Integer rushingLng) {
        this.rushingLng = rushingLng;
    }

    public Integer getRushingLngtd() {
        return rushingLngtd;
    }

    public void setRushingLngtd(Integer rushingLngtd) {
        this.rushingLngtd = rushingLngtd;
    }

    public Integer getRushingTds() {
        return rushingTds;
    }

    public void setRushingTds(Integer rushingTds) {
        this.rushingTds = rushingTds;
    }

    public Integer getRushingTwopta() {
        return rushingTwopta;
    }

    public void setRushingTwopta(Integer rushingTwopta) {
        this.rushingTwopta = rushingTwopta;
    }

    public Integer getRushingTwoptm() {
        return rushingTwoptm;
    }

    public void setRushingTwoptm(Integer rushingTwoptm) {
        this.rushingTwoptm = rushingTwoptm;
    }

    public Integer getRushingYds() {
        return rushingYds;
    }

    public void setRushingYds(Integer rushingYds) {
        this.rushingYds = rushingYds;
    }

    public Integer getStatisticYear() {
        return statisticYear;
    }

    public void setStatisticYear(Integer statisticYear) {
        this.statisticYear = statisticYear;
    }

    public Boolean getDrafted() {
        return drafted;
    }

    public void setDrafted(Boolean drafted) {
        this.drafted = drafted;
    }

    public Pick getPick() {
        return null;
        //return pick;
    }

    public void setPick(Pick pick) {
        //this.pick = pick;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlayerAthlete)) {
            return false;
        }
        PlayerAthlete other = (PlayerAthlete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fantasy.draftmanager.entities.PlayerAthlete[ id=" + id + " ]";
    }
    
}
