/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.repository;

import com.samwan.sfa.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author smwangi
 */
@Repository(value = "stageRepository")
public interface StageRepository extends JpaRepository<Stage, Long>{
    
}
