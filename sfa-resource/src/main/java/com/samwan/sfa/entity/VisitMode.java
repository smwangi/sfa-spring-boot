/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author smwangi
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "visit_modes")
public class VisitMode extends BaseId {
    
    @Column(name = "name",length = 150)
    private String name;
}
