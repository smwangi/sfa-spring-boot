/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.entity;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sam wan
 */
@Entity
@Getter
@Setter
@Table(name = "opportunities")
public class Opportunity extends BaseId implements Serializable {
    
    @Expose
    @Column(name = "name",unique = true)
    private String name;
    @Expose
    @Column(name = "description")
    private String description;
    @Expose
    @Column(name="is_converted")
    private boolean isConverted;
    @Expose
    @Column(name = "win_probability")
    private int winProbability;
    @Expose
    @Column(name = "opportunity_type")
    private int opportunityType;
    @Expose
    @Column(name = "close_date")
    private LocalDate closeDate;
    @Expose
    @Column(name = "expected_amount")
    private double expectedAmount;
    @Expose
    @Column(name = "stageId")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Stage stage;    
    @Expose
    @Column(name = "ownerId",updatable = true)
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private CostCentre owner;
}
