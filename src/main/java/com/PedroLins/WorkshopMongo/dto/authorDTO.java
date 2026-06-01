package com.PedroLins.WorkshopMongo.dto;

import com.PedroLins.WorkshopMongo.Domain.user;

import java.io.Serializable;

public class authorDTO implements Serializable {
    private final static long serialVersionUID = 1L;

    private String id;
    private String name;

    //CONSTRUCTORS

    public authorDTO(){}

    public authorDTO (user obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    //GETTERS AND SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
