CREATE DATABASE  IF NOT EXISTS `medicine` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `medicine`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: medicine
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `additional_fields`
--

DROP TABLE IF EXISTS `additional_fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additional_fields` (
  `ID_FIELD` int NOT NULL AUTO_INCREMENT,
  `FIELD_NAME` varchar(256) DEFAULT NULL,
  `DATA_TYPE` enum('STRING','INTEGER','DOUBLE') DEFAULT NULL,
  PRIMARY KEY (`ID_FIELD`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional_fields`
--

LOCK TABLES `additional_fields` WRITE;
/*!40000 ALTER TABLE `additional_fields` DISABLE KEYS */;
INSERT INTO `additional_fields` VALUES (1,'Резус-фактор','STRING'),(2,'Зрение','STRING'),(3,'Кровь','STRING'),(4,'Кожа','STRING'),(5,'Вес','DOUBLE'),(6,'Рост','DOUBLE');
/*!40000 ALTER TABLE `additional_fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `additional_fields_values`
--

DROP TABLE IF EXISTS `additional_fields_values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additional_fields_values` (
  `ID_VALUE` int NOT NULL AUTO_INCREMENT,
  `ID_FORM` int DEFAULT NULL,
  `ID_FIELD` int DEFAULT NULL,
  `VALUE` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`ID_VALUE`),
  KEY `field_idx` (`ID_FIELD`),
  KEY `form_idx` (`ID_FORM`),
  CONSTRAINT `field_id` FOREIGN KEY (`ID_FIELD`) REFERENCES `additional_fields` (`ID_FIELD`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `form_id` FOREIGN KEY (`ID_FORM`) REFERENCES `form` (`ID_FORM`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional_fields_values`
--

LOCK TABLES `additional_fields_values` WRITE;
/*!40000 ALTER TABLE `additional_fields_values` DISABLE KEYS */;
INSERT INTO `additional_fields_values` VALUES (141,41,1,'Rh+'),(142,41,5,'70'),(143,41,6,'180'),(144,42,1,'Rh+'),(145,42,5,'75'),(146,42,6,'170');
/*!40000 ALTER TABLE `additional_fields_values` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `form` (
  `ID_FORM` int NOT NULL AUTO_INCREMENT,
  `DATE` date DEFAULT NULL,
  `ID_PEOPLE` int NOT NULL,
  `status` enum('EXIST','DELETED') DEFAULT NULL,
  PRIMARY KEY (`ID_FORM`),
  KEY `idPeople_idx` (`ID_PEOPLE`),
  CONSTRAINT `idPeople` FOREIGN KEY (`ID_PEOPLE`) REFERENCES `people` (`ID_PEOPLE`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form`
--

LOCK TABLES `form` WRITE;
/*!40000 ALTER TABLE `form` DISABLE KEYS */;
INSERT INTO `form` VALUES (41,'2023-05-14',5,'EXIST'),(42,'2023-05-14',6,'EXIST');
/*!40000 ALTER TABLE `form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people` (
  `ID_PEOPLE` int NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(45) DEFAULT NULL,
  `LASTNAME` varchar(45) DEFAULT NULL,
  `FATHER` varchar(45) DEFAULT NULL,
  `BIRTH_DATE` date DEFAULT NULL,
  `SEX` varchar(45) DEFAULT NULL,
  `MED_DOC` int DEFAULT NULL,
  `STATUS` enum('EXIST','DELETED') DEFAULT NULL,
  PRIMARY KEY (`ID_PEOPLE`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (4,'Олег','Олегов','Олегович','2004-09-18','муж',222020220,'DELETED'),(5,'Иван','Иванов','Иванович','2005-08-22','муж',1111111,'EXIST'),(6,'Максим','Максимов','Максимович','2002-01-19','муж',574534563,'EXIST');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-14 17:01:54
