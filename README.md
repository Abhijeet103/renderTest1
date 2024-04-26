## Features Implemented 

1) simple get API ,  which get all the Training centers , if none present in the DataBase then return empty list
2) Filter  with any parameter is implemented , usage of invalid parameter for filtering will result in a bad request
3) Post API which post Training Center data 
4) All specified Validations like email , phone  , Not null constrinat for some   data members etc .  
5) Unit Test with Mock MVC 
6) dockerized 
7) swagger UI is attached

## Tools Used

Java  , Springboot  , SpringBoot validation  , spring data Mongo ,  MongoDb  , Junit  , Swagger 

## Unit Test 
![image](https://github.com/Abhijeet103/Backend_Traini8_Abhijeet_Jha/assets/93581505/593ad915-a67e-4163-8b9a-8434450bb0ea)



## SetUp 

1) Have docker demon running 
2) run the command  docker-compose up --build     
3) server will  start at port 8080
4) use  http://localhost:8080/swagger-ui/index.html  for swagger UI

## Usage
5) use localhost:8080/trainingCenter  endpoint for get and post request  
6) for filter in get use localhost:8080/trainingCenter?studentCapacity=50&city=delhi
7) Sample Post payload  :
   {
    "centerName" : "test1" ,
    "centerCode" : "123456789012" ,
    "address" : {
                    "detailedAddress" : "plot 5" ,
                    "city" :"gurgoan" ,
                    "state" :"haryana" ,
                    "pinCode" :"221145"
                } ,
    "contactEmail" : "test@gmail.com" ,
    "phoneNumber" : "1234567890" ,  
    "studentCapacity" :500    
}


# ScreenShots 

## Get Request without filter  
* Request
  
  ![s1](https://github.com/Abhijeet103/Backend_Traini8_Abhijeet_Jha/assets/93581505/8d401720-6245-4fef-a3fb-f950164f4e9b)

* Response

  ![s2](https://github.com/Abhijeet103/Backend_Traini8_Abhijeet_Jha/assets/93581505/22293648-793a-4c43-a042-3bbf49cef8ba)


## Get Request with filter example 1
* Request

  ![s3](https://github.com/Abhijeet103/Backend_Traini8_Abhijeet_Jha/assets/93581505/a1e2a6ce-70d0-4af3-9419-e0b5f9a92e59)

* Response

  ![s4](https://github.com/Abhijeet103/Backend_Traini8_Abhijeet_Jha/assets/93581505/7d4bbd3c-03da-4cf6-be31-d6d13daf192c)


  ## Get Request with filter example 2
  * Request

    ![s5](https://github.com/Abhijeet103/Backend_Traini8_Abhijeet_Jha/assets/93581505/bdc740de-3e5a-4033-a00f-a60b530b1ac5)

  * Response

    ![s6](https://github.com/Abhijeet103/Backend_Traini8_Abhijeet_Jha/assets/93581505/901d3ddc-39a9-43ec-b2c8-d8b30669ff46)


    







