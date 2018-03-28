/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.service.impl;

import com.samwan.sfa.entity.Opportunity;
import com.samwan.sfa.service.OpportunityService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service(value = "opportunityService")
public class OpportunityServiceImpl implements OpportunityService {

    @Override
    public Opportunity findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Opportunity> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Opportunity findOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
