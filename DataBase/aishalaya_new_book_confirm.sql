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
-- Table structure for table `book_confirm`
--

DROP TABLE IF EXISTS `book_confirm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_confirm` (
  `book_confirm_id` bigint NOT NULL,
  `agreement_document` varchar(255) DEFAULT NULL,
  `agreement_document_serial_number` varchar(255) DEFAULT NULL,
  `booking_id` bigint DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_proof_document` varchar(255) DEFAULT NULL,
  `id_proof_document_serial_number` varchar(255) DEFAULT NULL,
  `legal_document` varchar(255) DEFAULT NULL,
  `legal_document_serial_number` varchar(255) DEFAULT NULL,
  `mobile_number` bigint DEFAULT NULL,
  `plot_confirmed_employee_email` varchar(255) DEFAULT NULL,
  `plot_number` bigint DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `rate_per_sqft` double DEFAULT NULL,
  `total_sqft` double DEFAULT NULL,
  `total_values` double DEFAULT NULL,
  `company_id` bigint DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  PRIMARY KEY (`book_confirm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_confirm`
--

LOCK TABLES `book_confirm` WRITE;
/*!40000 ALTER TABLE `book_confirm` DISABLE KEYS */;
INSERT INTO `book_confirm` VALUES (152,'agreementDocument/ad86e60b-6a52-4e2f-abff-8cb5bfc34e8d_blockList (1).odt','123',452,NULL,'2024-08-23 16:42:55.025000',NULL,'shree123@gmail.com','idProofDocument/005d5cb7-df56-41b5-b394-46abc0b45e9e_blockList (1).odt','456','legalDocument/ca6bc3fe-d757-4267-92f5-ed4176c502b1_blockList (1).odt','789',9812345678,'dharshini123@gmail.com',3,'CMS',2918,29,84622,2,153);
/*!40000 ALTER TABLE `book_confirm` ENABLE KEYS */;
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
