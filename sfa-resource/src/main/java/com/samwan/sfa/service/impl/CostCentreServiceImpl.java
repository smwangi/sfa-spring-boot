/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.service.impl;

import com.samwan.sfa.entity.CostCentre;
import com.samwan.sfa.repository.CostCentreRepository;
import com.samwan.sfa.service.CostCentreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service(value = "costCentreService")
public class CostCentreServiceImpl implements CostCentreService {

    @Autowired
    private CostCentreRepository costCentreRepository;
    
    @Override
    public CostCentre findByName(String name) {
        return costCentreRepository.findByName(name);
    }

    @Override
    public List<CostCentre> findAll() {
        return costCentreRepository.findAll();
    }

    @Override
    public CostCentre findOne(Long id) {
        return costCentreRepository.findOne(id);
    }
    
}
