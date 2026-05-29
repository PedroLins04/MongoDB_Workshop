package com.PedroLins.WorkshopMongo.dto;

import com.PedroLins.WorkshopMongo.Domain.user;

import java.io.Serializable;

public class userDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    //CONSTRUCTORS

    public userDTO (){};

    public userDTO (user obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
