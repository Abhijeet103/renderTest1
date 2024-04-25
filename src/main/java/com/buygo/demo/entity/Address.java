package com.buygo.demo.entity;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @NotBlank(message = "detail address is missing ")
    private String detailedAddress ;
    @NotBlank(message = "city  is missing")
    private String city;

    @NotBlank(message = "state is missing")
    private String state ;

    @NotBlank(message = "pin code is missing")
    private String pinCode  ;

}
