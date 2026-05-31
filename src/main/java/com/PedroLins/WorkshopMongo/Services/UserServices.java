package com.PedroLins.WorkshopMongo.Services;

import com.PedroLins.WorkshopMongo.Domain.user;
import com.PedroLins.WorkshopMongo.Repositories.UserRepository;
import com.PedroLins.WorkshopMongo.Services.Exceptions.ObjectNotFound;
import com.PedroLins.WorkshopMongo.dto.userDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public List<user> findAll() {
        return repository.findAll();
    }

    public user findById(String id) {
        Optional<user> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Object not found"));
    }

    public user Insert(user obj) {
        return repository.insert(obj);
    }

    public user update(user obj) {
        user newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(user newObj, user obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public user fromDTO(userDTO dto) {
        return new user(dto.getId(), dto.getName(), dto.getEmail());
    }

    public void DeleteById(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
