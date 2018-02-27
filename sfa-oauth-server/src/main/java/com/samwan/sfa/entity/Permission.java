/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author smwangi
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "permission")
public class Permission extends BaseId {
    @NotNull
    @Size(min = 1, max = 60)
    private String name;
}
