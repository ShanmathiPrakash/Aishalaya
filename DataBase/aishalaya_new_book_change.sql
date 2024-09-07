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
-- Table structure for table `book_change`
--

DROP TABLE IF EXISTS `book_change`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_change` (
  `book_change_id` bigint NOT NULL,
  `block_id` bigint DEFAULT NULL,
  `booking_id` bigint DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `customer_id` varchar(255) DEFAULT NULL,
  `diff_rate` double DEFAULT NULL,
  `gm_approve` bit(1) DEFAULT NULL,
  `old_diff_rate` double DEFAULT NULL,
  `old_original_rate` double DEFAULT NULL,
  `old_plot_number` bigint DEFAULT NULL,
  `old_selling_rate` double DEFAULT NULL,
  `old_total_amount` double DEFAULT NULL,
  `old_total_sqft` double DEFAULT NULL,
  `original_rate` double DEFAULT NULL,
  `plot_number` bigint DEFAULT NULL,
  `project_id` bigint DEFAULT NULL,
  `selling_rate` double DEFAULT NULL,
  `site_visit_emp_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_sqft` double DEFAULT NULL,
  `company_id` bigint DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  PRIMARY KEY (`book_change_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_change`
--

LOCK TABLES `book_change` WRITE;
/*!40000 ALTER TABLE `book_change` DISABLE KEYS */;
INSERT INTO `book_change` VALUES (104,NULL,506,'2024-08-27 12:57:26.638000','1102',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL,2900,NULL,NULL,84100,22,2,352);
/*!40000 ALTER TABLE `book_change` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 12:58:21
