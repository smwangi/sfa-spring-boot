/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.controller;

import com.google.gson.GsonBuilder;
import com.samwan.sfa.entity.VisitMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.samwan.sfa.service.VisitModeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author smwangi
 */
@RestController
@RequestMapping(value = "/api/visit-mode")
public class VisitModeController {
    
    @Autowired
    private VisitModeService visitModeService;
    
    /**
     *
     * @return
     */
    @PreAuthorize("#oauth2.hasScope('visitmode') and #oauth2.hasScope('read')")// 
    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAll(){
        List<VisitMode> visitModes = visitModeService.findAll();
        if(visitModes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        String visitModeResponse = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create().toJson(visitModes);
        return new ResponseEntity<>(visitModeResponse,HttpStatus.OK);
    }
}
