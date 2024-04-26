package com.buygo.demo.controller;

import com.buygo.demo.entity.TrainingCenter;
import com.buygo.demo.exceptions.InvalidRequestBodyException;
import com.buygo.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@EnableMongoAuditing
public class Controller {



    @Autowired
    Service service ;


    @PostMapping("/trainingCenter")
    TrainingCenter createTrainingCenter(@RequestBody @Validated TrainingCenter trainingCenter, BindingResult bindingResult) throws InvalidRequestBodyException {
        if (bindingResult.hasErrors()) {

            StringBuilder errorMessage = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> {
                if (!errorMessage.isEmpty()) {
                    errorMessage.append(", ");
                }
                errorMessage.append(error.getDefaultMessage());
            });

            throw new InvalidRequestBodyException(errorMessage.toString());
        }
        return service.createTrainingCenter(trainingCenter);
    }

    @GetMapping("/trainingCenter")
    List<TrainingCenter> getAllTrainingCenter(@RequestParam(required = false) Map<String  , String> filter) throws InvalidRequestBodyException {
        if(!validatedFilter(filter))
        {
            throw new InvalidRequestBodyException("Invalid filer parameter , allowed filter parameters are : centerCode, phoneNumber, state, pinCode, centerName, studentCapacity, contactEmail, city");
        }
        return service.getAllTrainingCenters(filter);
    }



    boolean validatedFilter(Map<String  , String> filter)
    {
        Set<String> cases = new HashSet<>();
        cases.add("city");
        cases.add("state");
        cases.add("pinCode");
        cases.add("centerName");
        cases.add("centerCode");
        cases.add("studentCapacity");
        cases.add("phoneNumber");
        cases.add("contactEmail");

        Set<String> params =  filter.keySet();

        if(cases.containsAll(params))
        {
            return true ;
        }
        return false ;
    }




}
