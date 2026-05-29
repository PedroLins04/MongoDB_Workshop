package com.PedroLins.WorkshopMongo.Config;

import com.PedroLins.WorkshopMongo.Domain.user;
import com.PedroLins.WorkshopMongo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        user maria = new user(null, "Maria Brown", "maria@gmail.com");
        user alex = new user(null, "Alex Green", "alex@gmail.com");
        user bob = new user(null, "Bob Grey", "bob@gmail.com");

        repository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
