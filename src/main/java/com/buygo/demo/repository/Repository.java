package com.buygo.demo.repository;

import com.buygo.demo.entity.TrainingCenter;
import org.springframework.data.mongodb.repository.MongoRepository;


@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository<TrainingCenter, String>
{

}
