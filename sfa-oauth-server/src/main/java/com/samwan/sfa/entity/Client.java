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
@Table(name = "oauth_client_details")
public class Client extends BaseId {
    
    @Column(name = "client_id")
    private String clientId;
    
    @Column(name = "scope")
    private String scope;
    
    @Column(name ="client_secret")
    private String clientSecret;
    
    @Column(name = "authorized_grant_types")
    private String authorizedGrant;
    
    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;
    
    @Column(name = "refresh_toke_validity")
    private Integer refreshTokenValidity;
    
    @Column(name = "authorities")
    private String authority;
}
