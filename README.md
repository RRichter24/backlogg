# backlogg

## Project Description

Website designed for programmers and coders to anonymously gossip about their software engineering jobs and coworkers.

## Technologies Used

* Maven
* PostgreSQL
* Java
* Jackson
* Tomcat
* Eclipse
* VSCode
* SpringMVC
* Typescript
* Angular
* Hibernate
* Jasmine
* Protractor
* JUnit4
* Mockito

## Features

List of features ready:
* sign up
* log in/log out
* make posts
* make comments on posts
* add photos when creating posts
* can request other users to be friends
* can accept friend requests
* can look up other users on a search bar
* rate posts by their “spiciness” level using a jalapeno or milk rating system.
* every user has a default profile picture

TODO list:
* every profile should have a picture/avatar uploaded. (default profile pic if a custom one is not uploaded)
* dynamic loading of new posts being made
* dynamic loading of friends accepting posts
* direct message chains where all posts are being shown rather between two friend than a general board where only the last message between a user and the user's friend is shown
* actually ensuring that the password and the password check only admit a registration if the strings on both are equal
* posting directly to the feed

## Getting Ready

Open git bash in any suitable directory and type `git clone https://github.com/RRichter24/backlogg.git`
Open the directory `backend` on something like Eclipse
Open the director `client` on something like Visual Studio Code
On Eclipse, 
  open the Server view under Window > Perspective > Server. 
  Right click on Tomcat 9.0 server and click on Run Server
On Visual Studio Code, open the built in terminal by pressing Ctrl + backtick.
  Navigate to the app directory by `cd client/src/app`.
  Run `npm install` to install all the necessary dependencies.
  Run `ng serve --open` to compile the program, run the program on localhost:4200, and automatically open up the program
  
## Usage

On the landing page, you can either sign up or log in.
Signing up involves a username, password and its verification, company you work for, and a bio.
You can also log in if you have already registered.

When logged in, you can post to your profile, view your timefeed, befriend others, navigate and directly message your friends.
You are only allowed to post to your profile but you can view your friends' posts. When making a post, you can add a photo by clicking "Add Photo" when you make a post.
While you can directly message your friends you can only view the last post they made with you.
You can befriend a user by typing in their username next to "Enter username", and then hitting yes if the person exists. The screen will change to reflect that you have made a request and it won't go away until the person you want to befriend accepts or rejects the request.
If a person is a friend, you can directly message a friend by typing in their name, then the message you want to send. Then click send.
You can also search for a user in a search bar in the upper-right corner of the screen
