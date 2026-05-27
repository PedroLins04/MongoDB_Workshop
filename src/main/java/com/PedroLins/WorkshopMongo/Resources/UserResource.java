package com.PedroLins.WorkshopMongo.Resources;

import com.PedroLins.WorkshopMongo.Domain.user;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity <List <user>> findAll() {
        user Maria = new user("1", "Maria Brown", "maria@gmail.com");
        user Alex = new user("2", "Alex Green", "alex@gmail.com");
        List <user> list = new ArrayList<>();
        list.addAll(Arrays.asList(Maria, Alex));
        return ResponseEntity.ok().body(list);
    }
}
