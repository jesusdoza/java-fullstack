package com.fullstack.moviesdemo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> { //extend the mongo repo interface, will store movie objects, with keys of type ObjectId

}
