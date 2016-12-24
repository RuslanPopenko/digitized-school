Digitized schools
=================

[![Build Status](https://travis-ci.org/RuslanPopenko/digitized-school.svg?branch=master)](https://travis-ci.org/RuslanPopenko/digitized-school)

Prerequisites
-------------

    * Java Runtime Environment (version 1.8.0  or greater)
    * Maven 3.0
    * MySQLServer 5.7
    * Git 2.10.2
    * Docker 1.12.3

Run project usual way
---------------------

- Clone project from Github

    - `git clone https://github.com/RuslanPopenko/digitized-school.git`

- Create new empty schema called 'db_digitilized_school' on MySQLServer

    - ``CREATE SCHEMA `db_digitilized_school`;``

- In application.properties (src/resources) change database username and password

- Open digitized-school directory and execute following code in a shell

    - `mvn clean package`

- Move to target directory and run jar file

    - `cd /project-location/target`

    - `java -jar digitized-school-1.0.jar`

Run project with Docker
-----------------------

- Clone project from Github

    - `git clone https://github.com/RuslanPopenko/digitized-school.git`

- Move to project directory

    - `cd /../project directory`

- Build Docker image of project

    - `sudo docker build -t "digitized-school" .`

- Run MySQL image from Docker hub

    - `sudo docker run --name demo-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=demo -e MYSQL_USER=demo_user -e MYSQL_PASSWORD=demo_pass -d mysql:5.6`

- Run project image and link with running MySQL image

    - `sudo docker run -p 8080:8080 --name demo-app --link demo-mysql:mysql -d digitized-school`



