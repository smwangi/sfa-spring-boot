/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.repository;

import com.samwan.sfa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author smwangi
 */
@Repository(value = "userRepository")
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
    User findActiveByUsername(@Param("username") String username);
    
    User findActiveByEmail(@Param("email") String email);
}
