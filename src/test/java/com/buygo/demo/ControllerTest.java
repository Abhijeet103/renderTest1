package com.buygo.demo;

import com.buygo.demo.entity.Address;
import com.buygo.demo.entity.TrainingCenter;
import com.buygo.demo.services.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Service service;

    @Test
    public void validRequestTest() throws Exception {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName("Test Center");
        trainingCenter.setCenterCode("abc123456789");
        trainingCenter.setAddress(new Address("flat no 304  , sec 12 Noida" , "noida" , "Up" , "23444"));
        trainingCenter.setPhoneNumber("9204928948");


        when(service.createTrainingCenter(any(TrainingCenter.class))).thenReturn(trainingCenter);

        mockMvc.perform(MockMvcRequestBuilders.post("/trainingCenter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trainingCenter)))
                .andExpect(status().isOk());
    }

    @Test
    public void invalidRequestCenterNameNotFoundTest() throws Exception {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterCode("abc123456789");
        trainingCenter.setAddress(new Address("flat no 304  , sec 12 Noida" , "noida" , "Up" , "23444"));
        trainingCenter.setPhoneNumber("9204928948");


        when(service.createTrainingCenter(any(TrainingCenter.class))).thenReturn(trainingCenter);

        mockMvc.perform(MockMvcRequestBuilders.post("/trainingCenter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trainingCenter)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void invalidRequestCenterCodeNotFoundTest() throws Exception {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName("Test Center");
        trainingCenter.setAddress(new Address("flat no 304  , sec 12 Noida" , "noida" , "Up" , "23444"));
        trainingCenter.setPhoneNumber("9204928948");

        when(service.createTrainingCenter(any(TrainingCenter.class))).thenReturn(trainingCenter);

        mockMvc.perform(MockMvcRequestBuilders.post("/trainingCenter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trainingCenter)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void invalidRequestCenterAddressFoundTest() throws Exception {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName("Test Center");
        trainingCenter.setCenterCode("abc123456789");
        trainingCenter.setPhoneNumber("9204928948");


        when(service.createTrainingCenter(any(TrainingCenter.class))).thenReturn(trainingCenter);

        mockMvc.perform(MockMvcRequestBuilders.post("/trainingCenter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trainingCenter)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void invalidRequestCenterPhoneNumberFoundTest() throws Exception {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName("Test Center");
        trainingCenter.setCenterCode("abc123456789");
        trainingCenter.setAddress(new Address("flat no 304  , sec 12 Noida" , "noida" , "Up" , "23444"));



        when(service.createTrainingCenter(any(TrainingCenter.class))).thenReturn(trainingCenter);

        mockMvc.perform(MockMvcRequestBuilders.post("/trainingCenter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trainingCenter)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void validRequestWithAllAttributesTest() throws Exception {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName("Test Center");
        trainingCenter.setCenterCode("abc123456789");
        trainingCenter.setPhoneNumber("9204928948");
        trainingCenter.setAddress(new Address("flat no 304  , sec 12 Noida" , "noida" , "Up" , "23444"));
        trainingCenter.setContactEmail("test@gmail.com");
        trainingCenter.setStudentCapacity(100);
        List<String> courses = new ArrayList<>();
        courses.add("c1");
        courses.add("c2");
        trainingCenter.setCoursesOffered(courses);

        when(service.createTrainingCenter(any(TrainingCenter.class))).thenReturn(trainingCenter);

        mockMvc.perform(MockMvcRequestBuilders.post("/trainingCenter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trainingCenter)))
                .andExpect(status().isOk());
    }

    @Test
    public void inValidRequestWithInvalidEmailTest() throws Exception {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName("Test Center");
        trainingCenter.setCenterCode("abc123456789");
        trainingCenter.setPhoneNumber("9204928948");
        trainingCenter.setAddress(new Address("flat no 304  , sec 12 Noida" , "noida" , "Up" , "23444"));
        trainingCenter.setContactEmail("test");
        trainingCenter.setStudentCapacity(100);
        List<String> courses = new ArrayList<>();
        courses.add("c1");
        courses.add("c2");
        trainingCenter.setCoursesOffered(courses);

        when(service.createTrainingCenter(any(TrainingCenter.class))).thenReturn(trainingCenter);

        mockMvc.perform(MockMvcRequestBuilders.post("/trainingCenter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trainingCenter)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void inValidRequestWithInvalidPhoneNumberTest() throws Exception {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName("Test Center");
        trainingCenter.setCenterCode("abc123456789");
        trainingCenter.setPhoneNumber("9204928948q");
        trainingCenter.setAddress(new Address("flat no 304  , sec 12 Noida" , "noida" , "Up" , "23444"));
        trainingCenter.setContactEmail("test@gmail.com");
        trainingCenter.setStudentCapacity(100);
        List<String> courses = new ArrayList<>();
        courses.add("c1");
        courses.add("c2");
        trainingCenter.setCoursesOffered(courses);

        when(service.createTrainingCenter(any(TrainingCenter.class))).thenReturn(trainingCenter);

        mockMvc.perform(MockMvcRequestBuilders.post("/trainingCenter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trainingCenter)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void inValidRequestWithInvalidCenterCodeTest() throws Exception {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName("Test Center");
        trainingCenter.setCenterCode("abc1234567892233");
        trainingCenter.setPhoneNumber("9204928948");
        trainingCenter.setAddress(new Address("flat no 304  , sec 12 Noida" , "noida" , "Up" , "23444"));
        trainingCenter.setContactEmail("test@gmail.com");
        trainingCenter.setStudentCapacity(100);
        List<String> courses = new ArrayList<>();
        courses.add("c1");
        courses.add("c2");
        trainingCenter.setCoursesOffered(courses);

        when(service.createTrainingCenter(any(TrainingCenter.class))).thenReturn(trainingCenter);

        mockMvc.perform(MockMvcRequestBuilders.post("/trainingCenter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trainingCenter)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void inValidRequestWithInvalidCenterNameTest() throws Exception {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName("Test Center lorem epsum loren epsum loren epsum lorem epsum Test test 111");
        trainingCenter.setCenterCode("abc123456789");
        trainingCenter.setPhoneNumber("9204928948");
        trainingCenter.setAddress(new Address("flat no 304  , sec 12 Noida" , "noida" , "Up" , "23444"));
        trainingCenter.setContactEmail("test@gmail.com");
        trainingCenter.setStudentCapacity(100);
        List<String> courses = new ArrayList<>();
        courses.add("c1");
        courses.add("c2");
        trainingCenter.setCoursesOffered(courses);

        when(service.createTrainingCenter(any(TrainingCenter.class))).thenReturn(trainingCenter);

        mockMvc.perform(MockMvcRequestBuilders.post("/trainingCenter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trainingCenter)))
                .andExpect(status().isBadRequest());
    }



    // Utility method to convert object to JSON string
    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
