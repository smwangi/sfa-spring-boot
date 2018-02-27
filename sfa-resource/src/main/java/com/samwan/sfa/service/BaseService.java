/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.service;

import java.util.Optional;
import java.util.List;
/**
 *
 * @author smwangi
 * @param <T>
 */
public interface BaseService<T> {
    T findByName(String name);
    List<T> findAll();
    T findOne(Long id);
    
}
