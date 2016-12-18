-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: localhost    Database: db_digitilized_school
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

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
INSERT INTO `person` VALUES (1,10,'max','morozov',''),(2,9,'zheka','zmeul',''),(3,50,'iryna','ivanivna','\0'),(4,60,'hadia','grygoriivna','\0'),(5,18,'John','Daw',''),(6,46,'Marta','Kent','\0');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pupil`
--

LOCK TABLES `pupil` WRITE;
/*!40000 ALTER TABLE `pupil` DISABLE KEYS */;
INSERT INTO `pupil` VALUES (5,1,7,9),(6,2,7,10);
/*!40000 ALTER TABLE `pupil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pupil_subject_cross`
--

LOCK TABLES `pupil_subject_cross` WRITE;
/*!40000 ALTER TABLE `pupil_subject_cross` DISABLE KEYS */;
INSERT INTO `pupil_subject_cross` VALUES (5,11),(6,11),(5,12),(6,12);
/*!40000 ALTER TABLE `pupil_subject_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (7,'185','spec'),(8,'162','usual');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `school_class`
--

LOCK TABLES `school_class` WRITE;
/*!40000 ALTER TABLE `school_class` DISABLE KEYS */;
INSERT INTO `school_class` VALUES (9,'10-A',7),(10,'10-B',7);
/*!40000 ALTER TABLE `school_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `school_class_subject_cross`
--

LOCK TABLES `school_class_subject_cross` WRITE;
/*!40000 ALTER TABLE `school_class_subject_cross` DISABLE KEYS */;
INSERT INTO `school_class_subject_cross` VALUES (9,11),(10,12);
/*!40000 ALTER TABLE `school_class_subject_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (11,'math'),(12,'phys');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (13,3),(14,4);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher_school_class_cross`
--

LOCK TABLES `teacher_school_class_cross` WRITE;
/*!40000 ALTER TABLE `teacher_school_class_cross` DISABLE KEYS */;
INSERT INTO `teacher_school_class_cross` VALUES (13,9),(14,9),(13,10),(14,10);
/*!40000 ALTER TABLE `teacher_school_class_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher_school_cross`
--

LOCK TABLES `teacher_school_cross` WRITE;
/*!40000 ALTER TABLE `teacher_school_cross` DISABLE KEYS */;
INSERT INTO `teacher_school_cross` VALUES (13,7),(14,7);
/*!40000 ALTER TABLE `teacher_school_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teacher_subject_cross`
--

LOCK TABLES `teacher_subject_cross` WRITE;
/*!40000 ALTER TABLE `teacher_subject_cross` DISABLE KEYS */;
INSERT INTO `teacher_subject_cross` VALUES (14,11),(13,12);
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

-- Dump completed on 2016-12-06 22:10:14