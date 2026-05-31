package com.PedroLins.WorkshopMongo.Resources;

import com.PedroLins.WorkshopMongo.Domain.user;
import com.PedroLins.WorkshopMongo.Services.UserServices;
import com.PedroLins.WorkshopMongo.dto.userDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<userDTO>> findAll() {
        List<user> list = service.findAll();
        List<userDTO> listDTO = list.stream().map(x -> new userDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<userDTO> findById(@PathVariable String id) {
        user obj = service.findById(id);
        return ResponseEntity.ok().body(new userDTO(obj));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody userDTO objDto) {
        user obj = service.fromDTO(objDto);
        obj = service.Insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
