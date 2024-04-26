## Features Implemented 

1) simple get API which get all the Training centers , if none present in the DataBase then return empty list 
2) Post API which post Training Center data 
3) All specified Validations like email , phone  , Not null constrinat for some   data members etc .  
4) Unit Test with Mock MVC 
5) dockerized 
6) swagger UI is attached
7) Filter  with any parameter is implemented , usage of invalid parameter for filtering will result in a bad request

## Tools Used

Java  , Springboot  , SpringBoot validation  , spring data Mongo ,  MongoDb  , Junit  

## Unit Test 
![image](https://github.com/Abhijeet103/Backend_Traini8_Abhijeet_Jha/assets/93581505/593ad915-a67e-4163-8b9a-8434450bb0ea)



## SetUp 

1) Have docker demon running 
2) run the command  docker-compose up --build     
3) server will  start at port 8080
4) use  http://localhost:8080/swagger-ui/index.html  for swagger UI
5) for get and post use localhost:8080/trainingCenter
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
