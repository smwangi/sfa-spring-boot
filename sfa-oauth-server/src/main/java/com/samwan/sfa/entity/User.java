/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.entity;

import static com.samwan.sfa.entity.BaseEntity.NOT_DELETED;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author smwangi
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User extends BaseId implements UserDetails {
    @Size(min = 4, max = 50)
    @Column(name = "username",unique = true, length = 50, nullable = false)
    private String username;
    
    @Column(name = "password",length = 150, nullable = false)
    private String password;
    
    @Email
    @Column(name = "email",length = 200,nullable = false)
    private String email;
    
    @Column(name = "account_expired")
    private boolean accountNonExpired;

    @Column(name = "credentials_expired")
    private boolean credentialsNonExpired;

    @Column(name = "account_locked")
    private boolean accountNonLocked;
    
    @Column(name = "enabled")
    private boolean enabled;

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
       return !accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
       return !credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return !enabled;
    }
    
    /*
    * Get all roles associated with the User that are not deleted
    */
   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinTable(name = "role_user", joinColumns = {
                   @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
                                   @JoinColumn(name = "role_id", referencedColumnName = "id") })
   @WhereJoinTable(clause = NOT_DELETED)
   @Where(clause = NOT_DELETED)
   private List<Role> roles;
    
    /*
    * Get roles and permissions and add them as a Set of GrantedAuthority
    */
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
           Set<GrantedAuthority> authorities = new HashSet<>();
           roles.stream().map((role) -> {
               authorities.add(new SimpleGrantedAuthority(role.getName()));
            return role;
        }).forEachOrdered((role) -> {
            role.getPermissions().forEach((permission) -> {
                authorities.add(new SimpleGrantedAuthority(permission.getName()));
            });
        });
           return authorities;
   }
}
