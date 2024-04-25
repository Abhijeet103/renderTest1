package com.buygo.demo.services;


import com.buygo.demo.entity.TrainingCenter;
import com.buygo.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {


    @Autowired
    Repository repo ;



    public TrainingCenter createTrainingCenter(TrainingCenter entity)
    {
        repo.save(entity);
        return entity;
    }

    public List<TrainingCenter> getAllTrainingCenter()
    {
        return  repo.findAll();
    }
}
