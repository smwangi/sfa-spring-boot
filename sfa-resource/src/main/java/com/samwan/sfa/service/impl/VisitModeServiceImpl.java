/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.service.impl;

import com.samwan.sfa.entity.VisitMode;
import com.samwan.sfa.repository.VisitModeRepository;
import com.samwan.sfa.service.VisitModeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service(value = "visitModeService")
public class VisitModeServiceImpl implements VisitModeService {

    @Autowired
    private VisitModeRepository visitModeRepository;
    
    @Override
    public VisitMode findByName(String name) {
        return visitModeRepository.findByName(name).orElseGet(() -> {
            return new VisitMode();
        });
       
    }

    @Override
    public List<VisitMode> findAll() {
        return visitModeRepository.findAll();
    }

    @Override
    public VisitMode findOne(Long id) {
        return visitModeRepository.findOne(id);
    }
    
}
