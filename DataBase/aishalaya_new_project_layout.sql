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
-- Table structure for table `project_layout`
--

DROP TABLE IF EXISTS `project_layout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_layout` (
  `project_layout_id` bigint NOT NULL,
  `descrip` varchar(255) DEFAULT NULL,
  `msp` double DEFAULT NULL,
  `plot_number` bigint DEFAULT NULL,
  `project_id` bigint DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `shape` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_sqft` double DEFAULT NULL,
  `total_value` double DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  PRIMARY KEY (`project_layout_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_layout`
--

LOCK TABLES `project_layout` WRITE;
/*!40000 ALTER TABLE `project_layout` DISABLE KEYS */;
INSERT INTO `project_layout` VALUES (1302,'no cost emi',22000,1,1,3000,'Poly','Booked',11,33000,'Green builders',153),(1303,'no cost emi',29000,2,2,2000,'Poly','Booked',22,44000,'companyone project',352),(1304,'no cost emi',50000,3,552,2918,'Poly','Completed',29,84622,'CMS',153),(1352,'no cost emi',50000,4,552,2918,'Rect','Available Plot',29,84622,'CMS',153);
/*!40000 ALTER TABLE `project_layout` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 12:58:25
