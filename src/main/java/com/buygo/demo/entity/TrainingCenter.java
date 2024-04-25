package com.buygo.demo.entity;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class TrainingCenter {
    @Id
    private String id  ;

    @NotBlank(message = "center name is mandatory")
    @Size(max = 40 , message = "center Name must be less than 40 characters long")
    private String centerName ;

    @NotBlank(message = "center Code is mandatory")
    @Size(min = 12, max = 12, message = "center code must be exactly 12 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "center code must be alphanumeric ")
    private String centerCode ;

    @Valid
    @NotNull(message = "address must not be null")
    private Address address ;

    int studentCapacity ;
    private List<String> coursesOffered ;

    @CreatedDate
    private Date createdOn ;

    @Email(message = "must be in email format")
    private String contactEmail ;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be valid and contain exactly 10 digits")
    private String phoneNumber;


}
