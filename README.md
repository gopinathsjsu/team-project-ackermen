Team Members

1. Sai Lahari Seethamraju (SJSU ID - 016037112)
2. Pavan Karthik (SJSU ID - 015945670)
3. Saikrishna Dosapati(SJSU ID - 015950493)
4. Teja Ganapati Jaddipal(SJSU ID - 015957526)


## Jira Link for tracking user stories.
https://team202-ackerman.atlassian.net/jira/software/projects/AC2/boards/2


## Github Project Board
## https://github.com/gopinathsjsu/team-project-ackermen/projects

## Image sources

https://mobirise.com/extensions/hotelm4/sliders-and-galleries.html
https://unsplash.com/t/food-drink
https://www.pexels.com/search/breakfast/


Note - Always fetch latest updates from repository before you start working on.




Steps to run the project.

1. Download and Install maven.
2. Download and Install postman to test APIs
3. Go to "your-project-location/HotelBooking"
4. Open terminal and execute command "mvn clean install" and wait for the compilation to complete.
5. Execute the command "mvn spring-boot:run", the embedded tomacat server will start at port 8090.
6. Using postman test the APIs - 
      1. API to get all users  - GET http://localhost:8090/getAllUsers -  Displays the user data that is currently available
      2. API to create a new user for hotel management system - POST http://localhost:8090/createUser - Creates a new user in th database using the data sent with API. CustomerType will be 'c' for external users, 'a' for admin and 'e' for hotel staff.
      
      
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
              "zipcode": "95133",
              "userType": "c"
            }
      
      3. API to serach for hotels - GET http://localhost:8090/searchHotels?searchkey=sPaRtan - value of searchkey parameter can be replaced with any string. Currently the search API works with country name and hotel name as search key.
      4. API to create new booking - POST http://localhost:8090/createBooking - creates a new booking row in db with the data sent with API

             No need to send booking id since it will be auto incremented in db and will be returned
             Data format should be - 
             {
                "userId": 2, 
                "hotelId": 1,
                "adultCount":4,
                "childrenCount":2,
                "checkinDate":"06/05/2022",
                "checkoutDate":"06/08/2022",
                "singleroomsBooked":2,
                "doubleroomsBooked":0,
                "suitesBooked":1,
                "bookingEmail":"iloveburgers@bur.com"
             }
      
7. Everyone can connect to the db now with the details provided in properties file.
