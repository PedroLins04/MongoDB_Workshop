package com.PedroLins.WorkshopMongo.Resources;

import com.PedroLins.WorkshopMongo.Domain.user;
import com.PedroLins.WorkshopMongo.Services.UserServices;
import com.PedroLins.WorkshopMongo.dto.userDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
    @RequestMapping(value="/users")
    public class UserResource {

        @Autowired
        private UserServices service;

        @RequestMapping(method=RequestMethod.GET)
        public ResponseEntity<List<userDTO>> findAll() {
            List<user> list = service.findAll();
            List<userDTO> listDTO = list.stream().map(x -> new userDTO(x)).collect(Collectors.toList());
            return ResponseEntity.ok().body(listDTO);
        }

    }
