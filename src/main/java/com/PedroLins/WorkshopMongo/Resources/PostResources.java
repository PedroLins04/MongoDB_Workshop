package com.PedroLins.WorkshopMongo.Resources;

import com.PedroLins.WorkshopMongo.Domain.post;
import com.PedroLins.WorkshopMongo.Resources.util.url;
import com.PedroLins.WorkshopMongo.Services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String txt) {
        txt = url.DecodeParam(txt);
        List<post> list = services.findByTitle(txt);
        return ResponseEntity.ok().body(list);
    }
}
