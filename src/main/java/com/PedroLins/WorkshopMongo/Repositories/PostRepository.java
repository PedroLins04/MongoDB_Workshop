package com.PedroLins.WorkshopMongo.Repositories;

import com.PedroLins.WorkshopMongo.Domain.post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository <post, String> {
}
