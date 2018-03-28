/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.entity;

import com.samwan.sfa.util.CostCentreType;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sam wan
 */

@Entity
@Getter
@Setter
public  class CostCentre extends BaseId {
    
    private String name;
    private int costCentreType;
}
