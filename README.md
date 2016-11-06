Digitized schools
=================

Prerequisites

    * Java Runtime Environment (version 1.8.0  or greater)
    * Maven 3.0
    * MySQLServer 5.7
    * Git 2.10.2

In order to run this project, you need
--------------------------------------

1. Open Terminal on Linux or Git Bash on Windows on directory for Project purpose

2. Input following commands

.. code-block:: shell

    git clone https://github.com/RuslanPopenko/digitized-school.git

3. Create new empty schema called 'db_digitilized_school' on MySQLServer

.. code-block:: sql

    CREATE SCHEMA `db_digitilized_school`;

4. Open digitized-school directory and execute following code in a shell

.. code-block:: shell

    mvn clean package

5. Move to target directory and run jar file

.. code-block:: shell

    cd target
    java -jar digitized-school-1.0.jar
