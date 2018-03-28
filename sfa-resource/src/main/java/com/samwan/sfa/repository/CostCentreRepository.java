/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.repository;

import com.samwan.sfa.entity.CostCentre;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author smwangi
 */
@Repository(value = "costCentreRepository")
public interface CostCentreRepository extends JpaRepository<CostCentre, Long>{
    CostCentre findByName(@Param("name")String name);
}
