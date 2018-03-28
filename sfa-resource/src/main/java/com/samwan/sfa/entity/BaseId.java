/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.entity;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author smwangi
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseId extends BaseEntity  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    
    @Expose
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID uuid;
}
