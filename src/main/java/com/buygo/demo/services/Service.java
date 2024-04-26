package com.buygo.demo.services;


import com.buygo.demo.entity.TrainingCenter;
import com.buygo.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@org.springframework.stereotype.Service
public class Service {


    @Autowired
    public Repository repo ;



    public TrainingCenter createTrainingCenter(TrainingCenter entity)
    {
        repo.save(entity);
        return entity;
    }


    public List<TrainingCenter> getAllTrainingCenters(Map<String, String> filterParams) {

        Set<TrainingCenter> intersection = new HashSet<>(repo.findAll());

        for (String paramName : filterParams.keySet()) {
            switch (paramName) {
                case "city" -> intersection.retainAll(repo.findByAddressCity(filterParams.get(paramName)));
                case "state" -> intersection.retainAll(repo.findByAddressState(filterParams.get(paramName)));
                case "pinCode" -> intersection.retainAll(repo.findByAddressPinCode(filterParams.get(paramName)));
                case "centerName" -> intersection.retainAll(repo.findByCenterName(filterParams.get(paramName)));
                case "centerCode" -> intersection.retainAll(repo.findByCenterCode(filterParams.get(paramName)));
                case "studentCapacity" ->
                        intersection.retainAll(repo.findByStudentCapacity(Integer.valueOf(filterParams.get(paramName))));
                case "phoneNumber" -> intersection.retainAll(repo.findByPhoneNumber(filterParams.get(paramName)));
                case "contactEmail" -> intersection.retainAll(repo.findByContactEmail(filterParams.get(paramName)));
            }
        }

        return List.copyOf(intersection);
    }

    @FunctionalInterface
    private interface RepositoryMethodCaller {
        List<TrainingCenter> call(String param);
    }


}
