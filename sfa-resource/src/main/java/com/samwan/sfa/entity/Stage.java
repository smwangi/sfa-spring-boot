/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.entity;

import com.google.gson.annotations.Expose;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "stages")
public class Stage extends BaseId {
    
    @Expose
    @Column(name = "name",length = 150,unique = true)
    private int name;
}
