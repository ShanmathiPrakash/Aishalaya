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
-- Table structure for table `visit_details`
--

DROP TABLE IF EXISTS `visit_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visit_details` (
  `visit_detail_id` bigint NOT NULL AUTO_INCREMENT,
  `buying_duration` varchar(255) DEFAULT NULL,
  `cab` varchar(255) DEFAULT NULL,
  `company_id` bigint DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `employee_notes` varchar(255) DEFAULT NULL,
  `end_kms` double DEFAULT NULL,
  `funding_source` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `starting_kms` double DEFAULT NULL,
  `starting_time` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  `vehicle_type` varchar(255) DEFAULT NULL,
  `ending_time` varchar(255) DEFAULT NULL,
  `is_block` bit(1) DEFAULT NULL,
  `is_book` bit(1) DEFAULT NULL,
  PRIMARY KEY (`visit_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit_details`
--

LOCK TABLES `visit_details` WRITE;
/*!40000 ALTER TABLE `visit_details` DISABLE KEYS */;
INSERT INTO `visit_details` VALUES (7,'Loan','car',2,'Shree','1970-01-01 05:30:00.000000','vani','dharshini123@gmail.com','Dharshiniii','Good',23,'Loan','9812345678','photoImages/block.odt',33,'2024-08-23 05:30:00.000000','Price Negotiation',153,'cab','2024-08-23',_binary '\0',_binary '\0'),(8,'Loan','car',2,'Shree','1970-01-01 05:30:00.000000','das','dharshini123@gmail.com','Dharshiniii','\nGood',29,'Loan','9812345678','photoImages/contactus - Copy.jpg',18,'2024-08-26 05:30:00.000000','Price Negotiation',153,'cab','2024-08-26',_binary '\0',_binary '\0'),(9,'Jewel','car',2,'Shree',NULL,'vani','dharshini123@gmail.com','Dharshiniii','Good',23,'Loan','9812345678','photoImages/blockList (1).odt',33,'2024-08-26 05:30:00.000000','Comparing with the competators',352,'cab','2024-08-26',_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `visit_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 12:58:27
