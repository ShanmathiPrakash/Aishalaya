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
-- Table structure for table `book_list`
--

DROP TABLE IF EXISTS `book_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_list` (
  `book_list_id` bigint NOT NULL,
  `booking_id` bigint DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `differ_rate` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `original_rate` double DEFAULT NULL,
  `plot_number` bigint DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `selling_rate` double DEFAULT NULL,
  `site_visit_emp_id` varchar(255) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_sqft` double DEFAULT NULL,
  PRIMARY KEY (`book_list_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_list`
--

LOCK TABLES `book_list` WRITE;
/*!40000 ALTER TABLE `book_list` DISABLE KEYS */;
INSERT INTO `book_list` VALUES (402,NULL,NULL,NULL,-1140000,3,1320000,1,'CMS',180000,'yamini123@gmail.com',33000,11),(403,NULL,NULL,NULL,-1140000,3,1320000,1,'CMS',180000,'yamini123@gmail.com',33000,11),(452,NULL,NULL,1102,-39393,2,42311,3,'CMS',2918,'dharshini123@gmail.com',84622,29),(506,NULL,NULL,1102,-20000,2,22000,2,'companyone project',2000,'dharshini123@gmail.com',44000,22);
/*!40000 ALTER TABLE `book_list` ENABLE KEYS */;
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
