package com.PedroLins.WorkshopMongo.Resources;

import com.PedroLins.WorkshopMongo.Domain.post;
import com.PedroLins.WorkshopMongo.Services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostServices services;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<post> findById(@PathVariable String id) {
        post obj = services.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
