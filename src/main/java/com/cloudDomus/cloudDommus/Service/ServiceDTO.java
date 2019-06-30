/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudDomus.cloudDommus.Service;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ana
 */
public class ServiceDTO extends Service{
    @NotEmpty
    private Long id;
    
    private String type;
    
    private String description;

    public ServiceDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    
    
}
