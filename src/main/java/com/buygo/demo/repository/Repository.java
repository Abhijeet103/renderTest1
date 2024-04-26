package com.buygo.demo.repository;

import com.buygo.demo.entity.TrainingCenter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository<TrainingCenter, String>
{
    List<TrainingCenter> findByAddressCity(String city);

    List<TrainingCenter> findByStudentCapacity(Integer studentCapacity);

    List<TrainingCenter> findByAddressState(String state) ;

    List<TrainingCenter>  findByCenterName(String centerName);

    List<TrainingCenter>  findByCenterCode(String centerCode);

    List<TrainingCenter>  findByAddressPinCode(String pinCode);

    List<TrainingCenter>  findByPhoneNumber(String phoneNumber);

    List<TrainingCenter> findByContactEmail(String contactEmail) ;


}
