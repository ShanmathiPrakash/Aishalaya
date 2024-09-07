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
-- Table structure for table `blocks`
--

DROP TABLE IF EXISTS `blocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blocks` (
  `blocks_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `block_emp_id` varchar(255) DEFAULT NULL,
  `block_emp_name` varchar(255) DEFAULT NULL,
  `cdt_date` datetime(6) DEFAULT NULL,
  `cdt_no` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
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
  `deno_total_notes` bigint DEFAULT NULL,
  `denoa10` bigint DEFAULT NULL,
  `denoa100` bigint DEFAULT NULL,
  `denoa20` bigint DEFAULT NULL,
  `denoa200` bigint DEFAULT NULL,
  `denoa50` bigint DEFAULT NULL,
  `denoa500` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL,
  `employee_type` varchar(255) DEFAULT NULL,
  `house_name` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `net_amount` double DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `paid_by` varchar(255) DEFAULT NULL,
  `paid_date` datetime(6) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `plot_id` bigint DEFAULT NULL,
  `plot_number` bigint DEFAULT NULL,
  `plot_total_amount` double DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `prefer_location` varchar(255) DEFAULT NULL,
  `project_id` bigint DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `rate_per_sqft` double DEFAULT NULL,
  `received_by` varchar(255) DEFAULT NULL,
  `selling_rate` double DEFAULT NULL,
  `site_visit_emp_id` varchar(255) DEFAULT NULL,
  `site_visit_emp_name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  `total_sqft` double DEFAULT NULL,
  `total_values` double DEFAULT NULL,
  `visit_id` bigint DEFAULT NULL,
  `work_place` varchar(255) DEFAULT NULL,
  `company_id` bigint DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  PRIMARY KEY (`blocks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blocks`
--

LOCK TABLES `blocks` WRITE;
/*!40000 ALTER TABLE `blocks` DISABLE KEYS */;
INSERT INTO `blocks` VALUES (1052,'Gobi','Saravanampatti','','dharshini123@gmail.com','Dharshiniii',NULL,'','Salem','AISC00953',1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'no cost emi',2,'Salem','shree123@gmail.com','dharshini123@gmail.com','Manager','Gobi','9812345678',42311,10000,'Shree','2024-08-23 05:30:00.000000','Cheque','Advance',3,3,84622,'789234','Gobi',NULL,'CMS',2918,'dharshini',2918,'dharshini123@gmail.com','Dharshiniii','TamilNadu',NULL,'PPM Nagar',29,84622,7,'KCT',2,153),(1103,'Gobi','Saravanampatti','Union Bank','dharshini123@gmail.com','Dharshiniii','2024-08-26 05:30:00.000000','123','Salem','AISC00953',1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'no cost emi',2,'Salem','shree123@gmail.com','dharshini123@gmail.com','Manager','Gobi','9812345678',22000,10000,'Shree','2024-08-26 05:30:00.000000','Cheque','Advance',2,2,44000,'789234','Gobi',2,'companyone project',2000,'dharshini',2000,'dharshini123@gmail.com','Dharshiniii','TamilNadu',NULL,'PPM Nagar',22,44000,9,'KCT',2,352),(1152,'Gobi','Saravanampatti','Union Bank','dharshini123@gmail.com','Dharshiniii','2024-08-26 05:30:00.000000','1234','Salem','AISC00953',1102,'Shree',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'no cost emi',2,'Salem','shree123@gmail.com','dharshini123@gmail.com','Manager','Gobi','9812345678',15950,10000,'Shree','2024-08-26 05:30:00.000000','Cheque','Advance',1,1,31900,'789234','Gobi',1,'Green builders',3000,'dharshini',2900,'dharshini123@gmail.com','Dharshiniii','TamilNadu',NULL,'PPM Nagar',11,33000,8,'KCT',2,153);
/*!40000 ALTER TABLE `blocks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 12:58:22
