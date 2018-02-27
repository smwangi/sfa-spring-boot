/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

/**
 *
 * @author smwangi
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "oauth_client_details")
public class Client extends BaseId /*implements ClientDetails*/ {
    
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
    
    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;
    
    @Column(name = "authorities")
    private String authority;
    
    @Column(name = "additional_information")
    private String additionalInformation;

    /*@Override
    public Set<String> getResourceIds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public boolean isScoped() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return new HashSet<>(Arrays.asList("password","authorization_code","refresh_token","implicit"));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidity;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidity;
    }

    @Override
    public boolean isAutoApprove(String string) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Set<String> getScope(){
       return new HashSet<>
               (Arrays.asList("foo","visitmode","read"));
    }*/
}
