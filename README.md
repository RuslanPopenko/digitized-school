Digitized schools
=================

Prerequisites
-------------

    * Java Runtime Environment (version 1.8.0  or greater)
    * Maven 3.0
    * MySQLServer 5.7
    * Git 2.10.2
    * Docker 1.12.3

#. `Run project usual way`_
#. `Run project with Docker`_

Run project usual way
---------------------

1. Clone project from Github

    git clone https://github.com/RuslanPopenko/digitized-school.git

2. Create new empty schema called 'db_digitilized_school' on MySQLServer

    CREATE SCHEMA `db_digitilized_school`;

3. In application.properties (src/resources) change database username and password

4. Open digitized-school directory and execute following code in a shell

    mvn clean package

5. Move to target directory and run jar file

    cd /project-location/target

    java -jar digitized-school-1.0.jar

Run project with Docker
-----------------------

1. Clone project from Github

    git clone https://github.com/RuslanPopenko/digitized-school.git

2. Move to project directory

    cd /../project directory

3. Build Docker image of project

    sudo docker -t build "digitized-school" .

4. Run MySQL image from Docker hub

    sudo docker run --name demo-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=demo -e MYSQL_USER=demo_user -e MYSQL_PASSWORD=demo_pass -d mysql:5.6

5. Run project image and link with running MySQL image

    sudo docker run -p 8080:8080 --name demo-app --link demo-mysql:mysql -d digitized-school



