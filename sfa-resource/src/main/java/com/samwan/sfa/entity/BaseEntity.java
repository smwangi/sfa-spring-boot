/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.entity;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Data;

/**
 *
 * @author smwangi
 */
@Data
@MappedSuperclass
public class BaseEntity {
    private static final long serialVersionUID = 1L;
    
    protected static final String NOT_DELETED = "deletedOn > CURRENT_TIMESTAMP OR deletedOn IS NULL";

    @Version
    protected Long version;

    protected LocalDateTime createdOn;

    protected LocalDateTime updatedOn;

    protected LocalDateTime deletedOn;

    protected Long createdBy;

    protected Long updatedBy;
}
