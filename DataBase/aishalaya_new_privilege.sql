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
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `privilege` (
  `privilege_id` bigint NOT NULL,
  `blocked_list_release` varchar(255) DEFAULT NULL,
  `blocked_lists` varchar(255) DEFAULT NULL,
  `booking_cancelled_list` varchar(255) DEFAULT NULL,
  `booking_list_book_edit` varchar(255) DEFAULT NULL,
  `booking_list_change_cancel` varchar(255) DEFAULT NULL,
  `booking_lists` varchar(255) DEFAULT NULL,
  `companies` varchar(255) DEFAULT NULL,
  `company_form` varchar(255) DEFAULT NULL,
  `company_list_edit` varchar(255) DEFAULT NULL,
  `company_list_view` varchar(255) DEFAULT NULL,
  `company_lists` varchar(255) DEFAULT NULL,
  `customer` varchar(255) DEFAULT NULL,
  `customer_form` varchar(255) DEFAULT NULL,
  `customer_list_edit` varchar(255) DEFAULT NULL,
  `customer_list_view` varchar(255) DEFAULT NULL,
  `customer_lists` varchar(255) DEFAULT NULL,
  `dashboard` varchar(255) DEFAULT NULL,
  `employee` varchar(255) DEFAULT NULL,
  `employee_form` varchar(255) DEFAULT NULL,
  `employee_list_edit` varchar(255) DEFAULT NULL,
  `employee_list_view` varchar(255) DEFAULT NULL,
  `employee_lists` varchar(255) DEFAULT NULL,
  `employee_privileges` varchar(255) DEFAULT NULL,
  `employee_team` varchar(255) DEFAULT NULL,
  `employee_team_list_team_edit` varchar(255) DEFAULT NULL,
  `employee_team_lists` varchar(255) DEFAULT NULL,
  `employee_team_privileges` varchar(255) DEFAULT NULL,
  `payment_history` varchar(255) DEFAULT NULL,
  `plot_blocked` varchar(255) DEFAULT NULL,
  `plot_booking` varchar(255) DEFAULT NULL,
  `plot_completed` varchar(255) DEFAULT NULL,
  `plot_confirmed` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `project_form` varchar(255) DEFAULT NULL,
  `project_layout_list_edit` varchar(255) DEFAULT NULL,
  `project_layout_lists` varchar(255) DEFAULT NULL,
  `project_list_edit` varchar(255) DEFAULT NULL,
  `project_list_view` varchar(255) DEFAULT NULL,
  `project_lists` varchar(255) DEFAULT NULL,
  `reports` varchar(255) DEFAULT NULL,
  `site_visit` varchar(255) DEFAULT NULL,
  `site_visit_form` varchar(255) DEFAULT NULL,
  `site_visit_block_book` varchar(255) DEFAULT NULL,
  `site_visit_list_edit` varchar(255) DEFAULT NULL,
  `site_visit_list_view` varchar(255) DEFAULT NULL,
  `site_visit_lists` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `company_company_id` bigint DEFAULT NULL,
  `role_role_id` bigint DEFAULT NULL,
  `team_team_id` bigint DEFAULT NULL,
  `block_module_for_master` varchar(255) DEFAULT NULL,
  `company_module_for_master` varchar(255) DEFAULT NULL,
  `customer_module_for_master` varchar(255) DEFAULT NULL,
  `employee_module_for_master` varchar(255) DEFAULT NULL,
  `project_module_for_master` varchar(255) DEFAULT NULL,
  `site_visit_module_for_master` varchar(255) DEFAULT NULL,
  `team_wise_employee_module_for_master` varchar(255) DEFAULT NULL,
  `book_module_for_master` varchar(255) DEFAULT NULL,
  `confirmed_plots_for_master` varchar(255) DEFAULT NULL,
  `plots_completed_for_master` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`privilege_id`),
  KEY `FKto14jg9w3xg8nu9m76fcd3yj1` (`company_company_id`),
  KEY `FK1x3q7lx9hdsqyaiax7ph0x8d5` (`role_role_id`),
  KEY `FK2wm643s9dfs7t2braletya8dt` (`team_team_id`),
  CONSTRAINT `FK1x3q7lx9hdsqyaiax7ph0x8d5` FOREIGN KEY (`role_role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FK2wm643s9dfs7t2braletya8dt` FOREIGN KEY (`team_team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `FKto14jg9w3xg8nu9m76fcd3yj1` FOREIGN KEY (`company_company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (1102,'1','1','1','1','1','1','0','1','1','1','1','0','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','0','0','0','0','0','1','1','1','1','1','1','1','0','1','1','1','1','1',3,1,8,202,'1','1','1','1','1','1','1','1','1','1'),(1103,'1','1','1','1','1','1','1',NULL,NULL,'0','1','1','1','1','1','1','1','1','0','0','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',4,2,2,153,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1104,'0','1','1','1','1','1','1','1','0','0','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',152,2,4,153,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1106,'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',403,2,5,153,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1154,'1','1','1','1','1','1','1',NULL,NULL,'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',402,2,3,152,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1202,'1','1','1','1','1','1','1',NULL,NULL,'1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',5,2,3,352,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1252,'0','0','0','0','0','0','0',NULL,NULL,'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',452,2,1,352,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1253,'1','1','1','1','1','1','1',NULL,NULL,'1','1','1','1','1','1','1','1','1','0','0','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1',702,2,3,352,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
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
