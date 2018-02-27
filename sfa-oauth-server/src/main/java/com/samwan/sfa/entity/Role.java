/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.entity;

import static com.samwan.sfa.entity.BaseEntity.NOT_DELETED;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

/**
 *
 * @author smwangi
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "role")
public class Role extends BaseId {
    
    @NotNull
    @Size(min = 6, max = 60)
    private String name;

    /*
     * Get all permissions associated with the Role that are not deleted
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "permission_role", joinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = {
                                    @JoinColumn(name = "permission_id", referencedColumnName = "id") })
    @WhereJoinTable(clause = NOT_DELETED)
    @Where(clause = NOT_DELETED)
    private List<Permission> permissions;
}
