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
-- Table structure for table `book_cancel`
--

DROP TABLE IF EXISTS `book_cancel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_cancel` (
  `book_cancel_id` bigint NOT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `book_cancel_emp_id` varchar(255) DEFAULT NULL,
  `book_cancel_emp_name` varchar(255) DEFAULT NULL,
  `booking_emp_id` varchar(255) DEFAULT NULL,
  `booking_empname` varchar(255) DEFAULT NULL,
  `cdt_date` datetime(6) DEFAULT NULL,
  `cdt_no` varchar(255) DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `customer_id` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `deduction_amount` double DEFAULT NULL,
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
  `description` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `paid_by` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `plot_number` bigint DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `purchased_discount` varchar(255) DEFAULT NULL,
  `purchased_plot_no` varchar(255) DEFAULT NULL,
  `purchased_rate_per_sqft` double DEFAULT NULL,
  `purchased_total_sqft` double DEFAULT NULL,
  `purchased_total_values` double DEFAULT NULL,
  `rate_per_sqft` double DEFAULT NULL,
  `rate_project` varchar(255) DEFAULT NULL,
  `received_by` varchar(255) DEFAULT NULL,
  `refund_amount` double DEFAULT NULL,
  `refund_date` datetime(6) DEFAULT NULL,
  `total_sqft` double DEFAULT NULL,
  `total_values` double DEFAULT NULL,
  `company_id` bigint DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  PRIMARY KEY (`book_cancel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_cancel`
--

LOCK TABLES `book_cancel` WRITE;
/*!40000 ALTER TABLE `book_cancel` DISABLE KEYS */;
INSERT INTO `book_cancel` VALUES (102,'Union Bank','dharshini123@gmail.com','Dharshiniii','dharshini123@gmail.com','Dharshiniii','2024-08-26 05:30:00.000000','1234','AISC00953','AISC00953','Shree',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'no cost emi','9812345678',20000,'dharshini','Full Payment','Credit Card',1,'Green builders','2','1',2900,11,17000,2900,'2900','Shree',20001,'2024-08-26 05:30:00.000000',11,15950,2,153);
/*!40000 ALTER TABLE `book_cancel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 12:58:23
