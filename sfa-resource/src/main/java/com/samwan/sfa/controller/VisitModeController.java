/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.controller;

import com.samwan.sfa.entity.VisitMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.samwan.sfa.service.VisitModeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 *
 * @author smwangi
 */
@RestController
@RequestMapping(value = "/api/visit-mode")
public class VisitModeController {
    
    @Autowired
    private VisitModeService visitModeService;
    
    @PreAuthorize("#oauth2.hasScope('visitmode')")// and #oauth2.hasScope('read')
    @GetMapping(value = "/")
    @ResponseBody
    public List<VisitMode> findAll(){
        return visitModeService.findAll();
    }
}
