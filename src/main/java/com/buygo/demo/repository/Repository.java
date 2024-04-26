package com.buygo.demo.repository;

import com.buygo.demo.entity.TrainingCenter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository<TrainingCenter, String>
{
    List<TrainingCenter> findByAddressCity(String city);

    List<TrainingCenter> findByStudentCapacity(Integer studentCapacity);

    List<TrainingCenter> findByAddressCityAndStudentCapacity(String city, Integer studentCapacity);
}
