/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.repository;

import com.samwan.sfa.entity.VisitMode;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author smwangi
 */
@Repository(value = "visitModeRepository")
public interface VisitModeRepository extends JpaRepository<VisitMode,Long> {
    Optional<VisitMode> findByName(@Param("name")String name);
}
