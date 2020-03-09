# Movies Calendar

A Java Application which uses Spring Boot to build a movie calendar and Hibernate to connect to a local database.

![](Screenshot.gif)

# About this Project

This project's goal is to create a calendar which displays all the good movies which were releases and those which are yet to be released. This application connects to a local MySQL database through Hibernate and uses materialize css in the frontend.

# Getting Started

**Prerequisites**

To run this project, you'll need to have a basic environment to run a Java, MySQL App.

**Installing**

Cloning the Repository

    $ git clone https://github.com/awcasella/Movies-Calendar.git

    $ cd Movies-Calendar

**Installation of XAMPP and MySQL**

    $ sudo apt-get install mysql-server
    
    $ sudo apt-get install mysql-client

- XAMPP installation tutorial can be found in [here](https://www.edivaldobrito.com.br/como-instalar-o-xampp-no-linux/).

**Java Installation**

    $ sudo apt install default-jre
    
    $ sudo apt install default-jdk

After that, open the terminal and start MySQL

    $ mysql -u root -p

Configure local database to be connected by our app:

    > create database if not exists movies;
    
**Note:** It is imperative to create a database named 'movies'. Otherwise, either the program will throw an exception or you'll have to change the code lines to make it compatible with the database.

Open Eclipse (or other IDE) and run the project. 

# Built With
- [Eclipse](https://eclipse.org): The Platform for Open Innovation and Collaboration.

- [Spring Boot](https://spring.io/projects/spring-boot): A Java framework.

- [Hibernate](https://hibernate.org): Everything data.

- [MySQL](https://www.mysql.com): The world's most popular open source database.

- [Materialize](https://materializecss.com): A modern responsive front-end framework based on Material Design.

# References

- Michelli Brito: Curso de Spring Boot: criando uma aplicaço Java Wev. Available at: [https://www.youtube.com/playlist?list=PL8iIphQOyG-DHLpEx1TPItqJamy08fs1D](https://www.youtube.com/playlist?list=PL8iIphQOyG-DHLpEx1TPItqJamy08fs1D). Access at March, 2020.

- luv2code. Hibernate Tutorial. Available at: [https://www.youtube.com/playlist?list=PLEAQNNR8IlB7fNkRsUgzrR346i-UqE5CG](https://www.youtube.com/playlist?list=PLEAQNNR8IlB7fNkRsUgzrR346i-UqE5CG). Access at March, 2020.
