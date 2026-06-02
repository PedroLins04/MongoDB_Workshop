package com.PedroLins.WorkshopMongo.Services;

import com.PedroLins.WorkshopMongo.Domain.post;
import com.PedroLins.WorkshopMongo.Repositories.PostRepository;
import com.PedroLins.WorkshopMongo.Services.Exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServices {

    @Autowired
    private PostRepository repository;

    public post findById(String id) {
        Optional<post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Object not found"));
    }

    public List<post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }

    public List<post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
