Team Members

1. Sai Lahari Seethamraju (SJSU ID - 016037112)
2. Pavan Karthik (SJSU ID - 015945670)
3. Saikrishna Dosapati(SJSU ID - 015950493)
4. Teja Ganapati Jaddipal(SJSU ID - 015957526)


## Sprint Tracker link
#### https://docs.google.com/spreadsheets/d/1mBVjg-GSgh19Kn4imrCRXldSPs7UuZe1aXoF6Y88ehw/edit#gid=164118333



## Github Project Board
## https://github.com/gopinathsjsu/team-project-ackermen/projects

## Image sources

https://mobirise.com/extensions/hotelm4/sliders-and-galleries.html
https://unsplash.com/t/food-drink
https://www.pexels.com/search/breakfast/


Steps to run the project.

1. Download and Install maven.
2. Download and Install postman to test APIs
3. Go to "your-project-location/HotelBooking"
4. Open terminal and execute command "mvn clean install" and wait for the compilation to complete.
5. Execute the command "mvn spring-boot:run", the embedded tomacat server will start at port 8090.
6. Using postman test the APIs - 
      1. GET API - http://localhost:8090/getAllUsers -  Displays the user data that is currently available
      2. POST API - http://localhost:8090/createUser - Creates a new user in th database using the data sent with API
      
      
      Data Format should be - 
      {
        "id": 116,
        "firstName": "3xk",
        "lastName": "tyson",
        "email": "tyson@mail.com",
        "password": "tyson@nypd",
        "country": "USA",
        "city": "Manhattan",
        "address": "1 washington sq. san jose",
        "zipcode": "95133"
      }
7. If you cant connect to the database that is provided, change it to your local database in application.properties file. Location of the file will be "your-project-location/HotelBooking/src/main/resources"
