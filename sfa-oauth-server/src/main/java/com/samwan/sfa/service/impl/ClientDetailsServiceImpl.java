/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.service.impl;

import com.samwan.sfa.entity.Client;
import com.samwan.sfa.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service(value = "clientAppDetailsService")
public class ClientDetailsServiceImpl implements ClientDetailsService,ClientRegistrationService {

    @Autowired
    private ClientRepository clientRepository;
    
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return clientRepository.findByClientId(clientId)
               .map(client -> {
                        BaseClientDetails details = new BaseClientDetails(client.getClientId(), null,client.getScope(),
                                client.getAuthorizedGrant(), client.getAuthority());
                        details.setClientSecret(client.getClientSecret());
                        details.setAccessTokenValiditySeconds(client.getAccessTokenValidity());
                        details.setRefreshTokenValiditySeconds(client.getRefreshTokenValidity());
                        return details;
                    })
            .orElseThrow(() -> new ClientRegistrationException(String.format("no client %s registered", clientId)));
    }

    @Override
    public void addClientDetails(ClientDetails cd) throws ClientAlreadyExistsException {
        Client client = new Client();
        client.setClientId(cd.getClientId());
        clientRepository.save(client);
    }

    @Override
    public void updateClientDetails(ClientDetails cd) throws NoSuchClientException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateClientSecret(String string, String string1) throws NoSuchClientException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeClientDetails(String string) throws NoSuchClientException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClientDetails> listClientDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
