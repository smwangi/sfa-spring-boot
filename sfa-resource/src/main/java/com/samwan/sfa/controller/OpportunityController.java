/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.controller;

import com.google.gson.GsonBuilder;
import com.samwan.sfa.entity.Opportunity;
import com.samwan.sfa.service.OpportunityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author smwangi
 */
@RestController
@RequestMapping(value = "/api/opportunity")
public class OpportunityController {
    
    @Autowired
    private OpportunityService opportunityService;
    
    @PreAuthorize("#oauth2.hasScope('opportunity') and oauth2.hasScope('read')")
    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findAll(){
        List<Opportunity> opportunities = opportunityService.findAll();
        if(opportunities.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        String opportunityJson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create().toJson(opportunities);
        return new ResponseEntity<>(opportunityJson,HttpStatus.OK);
    }
}
