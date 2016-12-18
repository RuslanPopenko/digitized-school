-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: db_digitilized_school
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,10,'Max','Morozov',''),(2,13,'Yevhenii','Zmeul',''),(3,12,'Iryna','Rustova','\0'),(4,13,'Nadia','Danylenko','\0'),(5,12,'John','Daw',''),(6,13,'Marta','Kent','\0'),(7,40,'Jon','Snow',''),(8,36,'May','Slansa','\0'),(9,13,'Slava','Golovko',''),(10,12,'Ksenia','Petrenko','\0'),(11,12,'Valesa','Nagieva','\0'),(12,11,'Oksana','Sanava','\0');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pupil`
--

LOCK TABLES `pupil` WRITE;
/*!40000 ALTER TABLE `pupil` DISABLE KEYS */;
INSERT INTO `pupil` VALUES (1,2,7,9),(2,4,7,10),(3,3,8,11),(4,1,8,12),(5,9,7,9),(6,10,7,10),(7,11,8,11),(8,12,8,12);
/*!40000 ALTER TABLE `pupil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pupil_subject_cross`
--

LOCK TABLES `pupil_subject_cross` WRITE;
/*!40000 ALTER TABLE `pupil_subject_cross` DISABLE KEYS */;
INSERT INTO `pupil_subject_cross` VALUES (1,11),(5,11),(2,12),(6,12),(3,13),(7,13),(4,14),(8,14);
/*!40000 ALTER TABLE `pupil_subject_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (7,'185','Spec'),(8,'162','Usual');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `school_class`
--

LOCK TABLES `school_class` WRITE;
/*!40000 ALTER TABLE `school_class` DISABLE KEYS */;
INSERT INTO `school_class` VALUES (9,'5-A',7),(10,'5-B',7),(11,'5-A',8),(12,'5-B',8);
/*!40000 ALTER TABLE `school_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `school_class_subject_cross`
--

LOCK TABLES `school_class_subject_cross` WRITE;
/*!40000 ALTER TABLE `school_class_subject_cross` DISABLE KEYS */;
INSERT INTO `school_class_subject_cross` VALUES (9,11),(10,12),(11,13),(12,14);
/*!40000 ALTER TABLE `school_class_subject_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (11,'Math'),(12,'Physics'),(13,'Literature'),(14,'Biology');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (13,5),(14,6),(15,7),(16,8);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher_school_class_cross`
--

LOCK TABLES `teacher_school_class_cross` WRITE;
/*!40000 ALTER TABLE `teacher_school_class_cross` DISABLE KEYS */;
INSERT INTO `teacher_school_class_cross` VALUES (13,9),(14,10),(15,11),(16,12);
/*!40000 ALTER TABLE `teacher_school_class_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher_school_cross`
--

LOCK TABLES `teacher_school_cross` WRITE;
/*!40000 ALTER TABLE `teacher_school_cross` DISABLE KEYS */;
INSERT INTO `teacher_school_cross` VALUES (13,7),(14,7),(15,8),(16,8);
/*!40000 ALTER TABLE `teacher_school_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher_subject_cross`
--

LOCK TABLES `teacher_subject_cross` WRITE;
/*!40000 ALTER TABLE `teacher_subject_cross` DISABLE KEYS */;
INSERT INTO `teacher_subject_cross` VALUES (14,11),(13,12),(15,13),(16,14);
/*!40000 ALTER TABLE `teacher_subject_cross` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-17 20:10:26
