package com.PedroLins.WorkshopMongo.Services;

import com.PedroLins.WorkshopMongo.Domain.user;
import com.PedroLins.WorkshopMongo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public List <user> findAll() {
       return repository.findAll();
    }
}
