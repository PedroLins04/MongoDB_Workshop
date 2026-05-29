package com.PedroLins.WorkshopMongo.Repositories;

import com.PedroLins.WorkshopMongo.Domain.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <user, String> {
}
