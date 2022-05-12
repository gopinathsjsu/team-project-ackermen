## Team Ackermen

### Team Members

1. Pavan Karthik Gollakaram (SJSU ID - 015945670)
2. Sai Lahari Seethamraju (SJSU ID - 016037112)
3. Saikrishna Dosapati(SJSU ID - 015950493)
4. Teja Ganapati Jaddipal(SJSU ID - 015957526)


## Areas of contribution

1. Pavan Karthik - Worked on Frontend, Creation of wireframes.
2. Sai Lahari Seethamraju  - Worked on Backend Development, Worked on cloud deployment.
3. Saikrishna Dosapati - Worked on Frontend, RDS Setup.
4. Teja Ganapati Jaddipal - Worked on Backend Development, API testing, RDS Setup.

## Github repo link
https://github.com/gopinathsjsu/team-project-ackermen

Commit history link(Incase github insights not showing correctly)

https://github.com/gopinathsjsu/team-project-ackermen/commits/main (for main branch)

Individual commit history

Pavan Karthik - https://github.com/gopinathsjsu/team-project-ackermen/commits?author=pavankarthikg 

Sai Lahari Seethamraju - https://github.com/gopinathsjsu/team-project-ackermen/commits?author=slahari5 

Saikrishna Dosapati - https://github.com/gopinathsjsu/team-project-ackermen/commits?author=saikrishnaDsk 

Teja Ganapati Jaddipal - https://github.com/gopinathsjsu/team-project-ackermen/commits?author=gthreehosmane 

## Github Project Board
https://github.com/gopinathsjsu/team-project-ackermen/projects/4


## Github Project journal (Includes weekly scrum reports, XP values, technology details)
https://github.com/gopinathsjsu/team-project-ackermen/wiki

## Sprint Task Sheet
https://github.com/gopinathsjsu/team-project-ackermen/blob/main/Sprints_TaskSheet.xlsx

## XP core values 

<strong>Feedback</strong> - We provide our feedback to each teammate and listen to them carefully. We meet every week to discuss the feedback, how to improve the weak spots.We adjust our project by gather feedback on design and implementations. After each team member’s assigned story is done, other team members do a review and give some feedback about the work.

<strong>Simplicity</strong> - We are very specific about what we are going to develop, not creating any features which are not mentioned in requirements. Throughout the project, we guaranteed complete transparency, integrity, and ultimate reliability.

<strong>Respect</strong> - We respect everyone's ideas/inputs regarding project in team and come to a consensus. From the beginning of the project each team member had valued others opinion and also considered others ideas and suggestions and respected each others.



## Design decisions

1. We created a loosely coupled MVC pattern where our application APIs are hosted in the cloud and the UI is hosted on our local machines.
2. We did not use Spring JPA repositories because before inserting the data into db, certain calculations had to be made. For example, in case of a new hotel booking, it is necessary to find out the final price and  reward points based on the final price.
3. We have used AWS RDS because of its high-availability, backup and recovery features.
4. We used JDBC driver to connect to AWS RDS, which provided us with the flexibility to use a variety of queries to fetch different data.
5. We used SpringBoot framework for following reasons

                    1. Easy dependency management - Our entire backend runs only using 7 dependencies.
                                Spring-boot-starter-web
                                Spring-boot-starter-test
                                Spring-boot-starter-jdbc
                                Spring-boot-starter-actuator
                                Mysql-connector-java
                                Spring-session-core
                                Spring-session-jdbc
                    2. SpringBoot applications includes a embedded web server
                    3. No need of deploying war files.
                    4. Application is easy to start.
                    
6. We did not concentrate too much on UX as our main goal is to show a working application with a high quality UI.
7. JQuery to be used to improve the performance and achieve the dynamic UserInterface, by generating the HTML and Styling dynamically on the BookingSummary and Hotel History Page.
8. Implemented Event Listeners to handle user actions from the user interface, Event Listeners are reliable to use as they invoke the required Javascript methods.
9. Toast messages are implemented to handle and display the error messages for multiple user input failure scenarios.
10. As the web UI will be used across different browsers and devices, we leveraged Bootstrap as it is flexible for responsive design, while maintaining wide browser compatibility and offers consistent design by using reusable components.
11. An AutoScaling group is configured to spin up EC2 instances in case of failures. This ASG consists of user data which is a bash script that installs aws-cli, java, downloads packages from S3 and runs jar file. User data script runs on every initialization of EC2 instances. An artifact(Jar file) is uploaded to AWS S3 and EC2 uses IAM to download the artifact from S3.
12. An Application load balancer is configured to forward http traffic to a target and target group forwards traffic from 80 to 8090 (the port where application is running), health checks are configured on target group and ASG will create new instances (with 300 sec grace period) on failure in health checks. 
13. As an additional security feature, a security group is configured so the requests are terminated at the load balancer and only the load balancer can talk to EC2 on 8090.

## Architecture diagram

![architecture-diagram](https://user-images.githubusercontent.com/13237444/168009462-899c643f-aa8c-44a3-a401-4e1b2ca2d993.png)

## Deployment Diagram
 ![DD (2)](https://user-images.githubusercontent.com/99698941/168180834-13c35c1e-a5cb-4592-b2a8-87c49e9df889.png)


## Feature set

1. New users of our application can register using user signup
2. Application supports 3 types of users
      a. End User - Has permissions to book rooms, delete booking, change booking, access reward points
      b. Hotel employees - Can perform extra functions such as View all users, view all bookings, booking checkout along with normal user functions.
      c. Hotel Admins - Has highest level of privilage, only admins can Add new hotel details to website. Apart from this Admins can do all end user and hotel employee functions.
3. Final price of the booking depends on number of guests, room types selected, amenities selected and check-in check-out dates.
4. When a new user signes up will get 100 reward points as welcome bonus.
5. Depending on the reward points accumulated, users will get a automatic discount on final booking price.
6. Users can search for hotels based on country or name of the hotel.
7. Using one email id only one user can signup.
8. Users can see their booking history, do new bookings, change/cancel their booking using our application
9. Users are not allowed to stay for more than 7 days in a single booking.
10. Seasonal pricing - prices are high for certain days in winter and summer season
11. Holiday pricing - prices are high around Chrismas, Thanksgiving, New year and July 4th weekend 


## DB schema

![hotel_schema3 0](https://user-images.githubusercontent.com/13237444/167969704-6c505a65-07da-4d3a-bdd4-d8ece0aba9fa.png)


## Use case diagram

<img width="1099" alt="use-case" src="https://user-images.githubusercontent.com/13237444/168154194-a8ecf36e-7698-4b87-a847-cd967af7a52c.png">

## Scrum Meetings
Friday and Monday

## Story board sample

<img width="1784" alt="story-screenshot" src="https://user-images.githubusercontent.com/13237444/168010545-6fbc2779-4c86-48ac-9c1b-b998226bc5d3.png">

## Weekly Scrum report sample
<img src="/webpages/Weekly_Scrum_Report.png" alt="Sprint 4 Burn down chart" title="Sprint 4 Burn down chart" style="display: inline-block; margin-right: 0 auto; width: 800px">

## Sprint-wise burn down charts samples for 2 sprints
<img src="/BurnDownCharts/Sprint_1.png" alt="Sprint 1 Burn down chart" title="Sprint 1 Burn down chart" style="display: inline-block; margin-left: 0 auto; width: 500px">
<img src="/BurnDownCharts/Sprint_4.png" alt="Sprint 4 Burn down chart" title="Sprint 4 Burn down chart" style="display: inline-block; margin-right: 0 auto; width: 500px">

## WireFrames

#### Login
<img src="/Wireframes/Login_Page.png" alt="Login_Page" title="Login_Page" style="display: inline-block; margin-right: 0 auto; width: 800px">

#### SignUp
<img src="/Wireframes/Frame 1.png" alt="SignUp" title="SignUp" style="display: inline-block; margin-right: 0 auto; width: 800px">

#### Booking Summary
<img src="/Wireframes/BookingSummary.png" alt="BookingSummary" title="BookingSummary" style="display: inline-block; margin-right: 0 auto; width: 800px">

Wireframes of SearchBar, Landing page, Search Results can be found at https://github.com/gopinathsjsu/team-project-ackermen/tree/main/Wireframes

## Image sources

https://mobirise.com/extensions/hotelm4/sliders-and-galleries.html
https://unsplash.com/t/food-drink
https://www.pexels.com/search/breakfast/


Note - Always fetch latest updates from repository before you start working on.






