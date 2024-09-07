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
-- Table structure for table `book_pay`
--

DROP TABLE IF EXISTS `book_pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_pay` (
  `book_pay_id` bigint NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `booking_id` bigint DEFAULT NULL,
  `cdt_date` datetime(6) DEFAULT NULL,
  `cdt_no` varchar(255) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `deno10` bigint DEFAULT NULL,
  `deno100` bigint DEFAULT NULL,
  `deno20` bigint DEFAULT NULL,
  `deno200` bigint DEFAULT NULL,
  `deno50` bigint DEFAULT NULL,
  `deno500` bigint DEFAULT NULL,
  `deno_total_amount` double DEFAULT NULL,
  `deno_total_notes` double DEFAULT NULL,
  `denoa10` bigint DEFAULT NULL,
  `denoa100` bigint DEFAULT NULL,
  `denoa20` bigint DEFAULT NULL,
  `denoa200` bigint DEFAULT NULL,
  `denoa50` bigint DEFAULT NULL,
  `denoa500` bigint DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `net_amount` double DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `paid_by` varchar(255) DEFAULT NULL,
  `paid_date` datetime(6) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `plot_number` bigint DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `received_by` varchar(255) DEFAULT NULL,
  `site_visit_emp_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_pay`
--

LOCK TABLES `book_pay` WRITE;
/*!40000 ALTER TABLE `book_pay` DISABLE KEYS */;
INSERT INTO `book_pay` VALUES (1152,'',NULL,NULL,'',NULL,NULL,'undefined',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,10000,'suvetha','2024-08-22 12:57:48.185000','Part Payment','Credit Card',NULL,'','sri','dharshini123@gmail.com'),(1153,'',NULL,NULL,'',NULL,NULL,'undefined',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,10000,'','2024-08-22 15:35:25.316000','','',NULL,'','','devi123@gmail.com'),(1202,'',NULL,NULL,'',NULL,NULL,'undefined',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,10000,'','2024-08-22 17:12:58.495000','','',NULL,'','','dharshini123@gmail.com'),(1252,'',NULL,NULL,'',NULL,NULL,'undefined',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1320000,10000,'','2024-08-22 18:50:40.686000','','',1,'CMS','','yamini123@gmail.com'),(1253,'',NULL,NULL,'',NULL,NULL,'undefined',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1320000,11,'','2024-08-22 18:51:22.056000','','',1,'CMS','','yamini123@gmail.com'),(1302,'',NULL,NULL,'',NULL,1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'9812345678',42311,10000,'Shree','2024-08-23 15:06:26.634000','Part Payment','Credit Card',3,'CMS','dharshini','dharshini123@gmail.com'),(1352,'Indian Bank',452,'2024-08-23 05:30:00.000000','123456789','2024-08-23 15:06:26.634000',1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'9812345678',42311,10000,'Shree','2024-08-23 05:30:00.000000','Part Payment','Credit Card',3,'CMS','Dharshiniii','dharshini123@gmail.com'),(1353,'Indian Bank',452,'2024-08-23 05:30:00.000000','123456789','2024-08-23 15:06:26.634000',1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'9812345678',42311,10000,'Shree','2024-08-23 05:30:00.000000','Part Payment','Credit Card',3,'CMS','Dharshiniii','dharshini123@gmail.com'),(1354,'Indian Bank',452,'2024-08-23 05:30:00.000000','123456789','2024-08-23 15:06:26.634000',1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'9812345678',42311,2000,'Shree',NULL,'Part Payment','Credit Card',3,'CMS','Dharshiniii','dharshini123@gmail.com'),(1355,'Indian Bank',452,'2024-08-23 05:30:00.000000','123456789','2024-08-23 15:06:26.634000',1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'9812345678',42311,200,'Shree','2024-08-23 05:30:00.000000','Part Payment','Credit Card',3,'CMS','Dharshiniii','dharshini123@gmail.com'),(1356,'Indian Bank',452,'2024-08-23 05:30:00.000000','123456789','2024-08-23 15:06:26.634000',1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'9812345678',42311,111,'Shree','2024-08-23 05:30:00.000000','Part Payment','Credit Card',3,'CMS','Dharshiniii','dharshini123@gmail.com'),(1406,'Union Bank',NULL,'2024-08-26 05:30:00.000000','123',NULL,1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'9812345678',22000,10000,'Shree','2024-08-26 12:09:00.540000','Part Payment','Credit Card',2,'companyone project','dharshini','dharshini123@gmail.com');
/*!40000 ALTER TABLE `book_pay` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 12:58:26
