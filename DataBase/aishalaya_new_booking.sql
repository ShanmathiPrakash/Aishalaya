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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` bigint NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `block_emp_id` varchar(255) DEFAULT NULL,
  `block_emp_name` varchar(255) DEFAULT NULL,
  `booking_emp_id` varchar(255) DEFAULT NULL,
  `booking_empname` varchar(255) DEFAULT NULL,
  `cdt_date` datetime(6) DEFAULT NULL,
  `cdt_no` varchar(255) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
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
  `discount` double DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `net_amount` double DEFAULT NULL,
  `original_rate` double DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `paid_by` varchar(255) DEFAULT NULL,
  `paid_date` datetime(6) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `plot_number` bigint DEFAULT NULL,
  `plot_total_amount` double DEFAULT NULL,
  `project_id` bigint DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `received_by` varchar(255) DEFAULT NULL,
  `selling_rate` double DEFAULT NULL,
  `site_visit_emp_id` varchar(255) DEFAULT NULL,
  `site_visit_emp_name` varchar(255) DEFAULT NULL,
  `total_sqft` double DEFAULT NULL,
  `visit_id` bigint DEFAULT NULL,
  `company_id` bigint DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `paid_amount_in_block` double DEFAULT NULL,
  `total_paid_amount` double DEFAULT NULL,
  `block_id` varchar(255) DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (506,'Union Bank','dharshini123@gmail.com','Dharshiniii','dharshini123@gmail.com','Dharshiniii','2024-08-26 05:30:00.000000','123','2024-08-26 12:09:00.540000','AISC00953',1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,'9812345678',22000,22000,10000,'Shree','2024-08-26 12:09:00.540000','Part Payment','Credit Card',2,44000,2,'companyone project','dharshini',2000,'dharshini123@gmail.com','Dharshiniii',22,9,2,2000,10000,20000,'1103',352);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 12:58:24
