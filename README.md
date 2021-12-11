# Authentication App
Welcome to my authentication app.  Here, I built this project using Java with Spring Boot and H2 database to design the backend while I used React to design the frontend.

# Getting started
In order to run this app, make sure you have Maven and NPM downloaded on your machine and clone this repository.  In your terminal, you can start the backend by running `mvn spring-boot:run` in the base repository and the frontend by running `npm start` from the `~/src/main/webapp/reactjs` path.  The backend will run on `localhost:8080` while the frontend will run on `localhost:3000`.

# How to use this app
If you pull up `localhost:3000`, you will be prompted to choose whether you want to sign in or sign up.  If you have just started up your backend, there will be no users in the database.  In order to add users, click on the sign up text.  

![CBB5DF57-D04F-444B-BCBE-5BB80042EE9A_1_201_a](https://user-images.githubusercontent.com/78940830/145566071-7aaa8b40-f3cf-4264-9ac5-52561259ef24.jpeg)

This will then open up the next page that will ask you to type out your username, password, and a checkbox to say whether you want to have guest or admin priviledges.  Once you fill out all your fields, click the continue button which will generate a user in your database.  In order to check that the user has been added, got to `localhost:8080/users` to see a list of users  You will see that the password you have entered into the database has been encrypted with BCrypt so that people who have access to the database are not allowed to know what your password is.  

![085E7381-E451-4545-B875-3C707D9C365C_1_201_a](https://user-images.githubusercontent.com/78940830/145566112-285d87ec-5de0-4492-a84f-b1fd911ad308.jpeg)

Next, you can click `Already have a sign in?` button in order to sign in to your recently made account.  Next, input your credentials and press continue.  Depending on whether or not your login was authenticated, you will receive an alert.  The alert will either tell you `Incorrect login` or `Correct login` and will tell you whether you have guest or admin authorization.

![9487DDD5-22C1-4BED-8590-E506EE2ACECA_1_201_a](https://user-images.githubusercontent.com/78940830/145566172-74b5b3cc-0608-4953-9433-f14fe2e1c09c.jpeg)

# Options with the backend
The backend is built at the path `~/src/main/java/com/hellowalnut/login`.  

It has a GET and POST mapping for `/users` and a POST mapping for `/validate` which lies in the controller repository.  

The user entity that we are creating for the database is stored in the model repository which stores an auto generated ID, username, password, and authorization.

Lastly in the service repository, this contains all the logic for accessing data from the database to respond to all the GET and POST request recieved from the server.

# What I would improve with more time

If I had more time to work on this app, I would add a check to make sure that you are entering a secure password by checking for uppercase and lowercase letters, numbers, and special characters.  In addition, I would set up this app on an HTTPS server in order to encrypt messages going from the user to the server.  Another thing I could improve on is implementing a JWT in order to give users secure authorization.  Lastly, I could have set up an OAuth if the user ever wanted to give access to resources on a server.
