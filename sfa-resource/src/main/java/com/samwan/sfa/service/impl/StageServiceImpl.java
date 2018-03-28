/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.service.impl;

import com.samwan.sfa.entity.Stage;
import com.samwan.sfa.service.StageService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service(value = "stageService")
public class StageServiceImpl implements StageService{

    @Override
    public Stage findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Stage> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stage findOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
