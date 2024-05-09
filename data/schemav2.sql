-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: customers
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `account_profile_t`
--

DROP TABLE IF EXISTS `account_profile_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_profile_t` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account` bigint NOT NULL,
  `profile` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_UNIQUE` (`account`),
  UNIQUE KEY `profile_UNIQUE` (`profile`),
  KEY `IX_PROFILE` (`profile`),
  KEY `IX_ACCOUNT` (`account`),
  CONSTRAINT `fk_account` FOREIGN KEY (`account`) REFERENCES `account_t` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_profile` FOREIGN KEY (`profile`) REFERENCES `profile_t` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_profile_t`
--

LOCK TABLES `account_profile_t` WRITE;
/*!40000 ALTER TABLE `account_profile_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_profile_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_t`
--

DROP TABLE IF EXISTS `account_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_t` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_t`
--

LOCK TABLES `account_t` WRITE;
/*!40000 ALTER TABLE `account_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_t`
--

DROP TABLE IF EXISTS `address_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_t` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `address_line_1` varchar(200) DEFAULT NULL,
  `address_line_2` varchar(200) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `region` varchar(100) DEFAULT NULL,
  `postal_code` varchar(50) DEFAULT NULL,
  `account` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_account_idx` (`account`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_address_account` FOREIGN KEY (`account`) REFERENCES `account_t` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='customer address';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_t`
--

LOCK TABLES `address_t` WRITE;
/*!40000 ALTER TABLE `address_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_t`
--

DROP TABLE IF EXISTS `order_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_t` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `account` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_t`
--

LOCK TABLES `order_t` WRITE;
/*!40000 ALTER TABLE `order_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preference_t`
--

DROP TABLE IF EXISTS `preference_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preference_t` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account` bigint DEFAULT NULL,
  `key` varchar(50) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_idx` (`key`),
  KEY `fk_account_preferences_idx` (`account`),
  CONSTRAINT `fk_account_preferences` FOREIGN KEY (`account`) REFERENCES `account_t` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='user preferences & custom data';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preference_t`
--

LOCK TABLES `preference_t` WRITE;
/*!40000 ALTER TABLE `preference_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `preference_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile_t`
--

DROP TABLE IF EXISTS `profile_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile_t` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `primary_contact` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_verified` tinyint DEFAULT NULL,
  `email_verified` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='customer profile table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile_t`
--

LOCK TABLES `profile_t` WRITE;
/*!40000 ALTER TABLE `profile_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `profile_t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-08 23:16:40
