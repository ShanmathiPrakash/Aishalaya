-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: aishalaya_new
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company_id` bigint DEFAULT NULL,
  `custom_code` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL,
  `employee_type` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  `work_place` varchar(255) DEFAULT NULL,
  `date_added` datetime(6) DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (302,'Gobi','Saravanampatti','Salem',2,'AISC00253','Vanisri4803@gmail.com','Shivaranjani','2024-05-17 00:00:00.000000','Salem','EMP0007','Manager','customerImages/613d7839-93d0-4998-a619-fabb3642554d_contactus - Copy.jpg','Gobi','99948713748',NULL,'789234','kerala','PPM Nagar','KCT',NULL,352),(653,'Gobi','Saravanampatti','Tirunelveli',2,'AISC00653','prakash12103@gmail.com','prakash','2024-06-26 05:30:00.000000','Coimbatore','prakash103@gmail.com','Manager','/pages/setup/customerImages/72eb39a8-b03e-48f3-8fdb-626bd5036cfa_fc123706-f14f-4244-8e58-d28c2291c13c_download.jpg','Coimbatore','09791789306','prakash1234','789234','kerala','PPM Nagar','KCT',NULL,153),(952,'','Saravanampatti','Salem',2,'AISC00903','','Shivaranjaniiiiiii','2024-08-01 05:30:00.000000','demo','yamini123@gmail.com','','/pages/setup/customerImages/06ccef95-bdd3-41b7-822d-a912010cf0cf_contactus - Copy.jpg','Gobi','98765432135','siva','789234','TamilNadu','','',NULL,153),(1102,'Gobi','Saravanampatti','Salem',2,'AISC00953','shree123@gmail.com','Shree','2024-08-23 05:30:00.000000','Salem','dharshini123@gmail.com','Manager','/pages/setup/customerImages/4dd8740c-6fd6-4a06-acf7-895b311e2feb_contactus - Copy.jpg','Gobi','9812345678','shree123','789234','TamilNadu','PPM Nagar','KCT',NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 12:58:28
