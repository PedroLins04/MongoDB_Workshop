package com.PedroLins.WorkshopMongo.Repositories;

import com.PedroLins.WorkshopMongo.Domain.post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository <post, String> {

    List<post> findByTitleContainingIgnoreCase(String text);
}
