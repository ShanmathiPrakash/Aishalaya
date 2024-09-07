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
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `agreement_details` varchar(255) DEFAULT NULL,
  `agreement_documents` varchar(255) DEFAULT NULL,
  `block` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `corporation_details` varchar(255) DEFAULT NULL,
  `corporation_documents` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `document_details` varchar(255) DEFAULT NULL,
  `document_documents` varchar(255) DEFAULT NULL,
  `draft_details` varchar(255) DEFAULT NULL,
  `draft_documents` varchar(255) DEFAULT NULL,
  `dtcp_details` varchar(255) DEFAULT NULL,
  `dtcp_documents` varchar(255) DEFAULT NULL,
  `east_details` varchar(255) DEFAULT NULL,
  `extent` double DEFAULT NULL,
  `geo_location` varchar(255) DEFAULT NULL,
  `land_type` varchar(255) DEFAULT NULL,
  `launch_date` date DEFAULT NULL,
  `layout` varchar(255) DEFAULT NULL,
  `legal_book_details` varchar(255) DEFAULT NULL,
  `legal_book_documents` varchar(255) DEFAULT NULL,
  `legal_details` varchar(255) DEFAULT NULL,
  `legal_documents` varchar(255) DEFAULT NULL,
  `new_survey_no` varchar(255) DEFAULT NULL,
  `north_details` varchar(255) DEFAULT NULL,
  `old_survey_no` varchar(255) DEFAULT NULL,
  `prev_owner_address` varchar(255) DEFAULT NULL,
  `prev_owner_contact` varchar(255) DEFAULT NULL,
  `prev_owner_name` varchar(255) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `registration_details` varchar(255) DEFAULT NULL,
  `road_cent` double DEFAULT NULL,
  `road_sqft` double DEFAULT NULL,
  `saleable_cent` double DEFAULT NULL,
  `saleable_sqft` double DEFAULT NULL,
  `soil_type` varchar(255) DEFAULT NULL,
  `south_details` varchar(255) DEFAULT NULL,
  `taluk` varchar(255) DEFAULT NULL,
  `total_plots` bigint DEFAULT NULL,
  `total_site_cent` double DEFAULT NULL,
  `total_site_sqft` double DEFAULT NULL,
  `ts_no` bigint DEFAULT NULL,
  `village` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `west_details` varchar(255) DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  `company_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Saravanampatti','Completed','/pages/setup/projectImages/agreementDocument/fb28543a-164f-43d4-88aa-45b111772c19_security.jpeg','A','Tata','Completed','/pages/setup/projectImages/corporationDocument/6d1bb435-f6db-4eaa-a906-688ccf4e4c22_security.jpeg','Dindugal','Completed','/pages/setup/projectImages/legalDocument/9a975538-854b-4e68-afed-e65869662cad_security.jpeg','Completed','/pages/setup/projectImages/draftDocument/f9fed9de-4a6d-4151-85d0-3e3e0e38ec9f_security.jpeg','Completed','/pages/setup/projectImages/dtcpDocument/ef8da9f8-2859-458a-bc8b-89a90e2ebc7f_security.jpeg','E',1234,'Coimbatore','Hill station','2024-05-08','/pages/setup/projectImages/projectImages/layout/9d08c6a7-9ba4-478f-8eb5-dd47ecb641a3_security.jpeg','Completed','/pages/setup/projectImages/legalBookDocument/3b457956-0013-4006-8d1f-980b49b6f602_security.jpeg','Completed','/pages/setup/projectImages/documentDocuments/null','34','N','12','Kalapatti','9123456798','Shanmathi','Green builders','Completed',78,36,15,45,'Red soil','S','Kodaikanal',1,24,35,5678,'Pannaikadu','12','W',153,2),(2,'','','agreementDocuments/e0095029-6e8d-473d-a737-7b81c59756f3_camera.jpg','','Tata','','corporationDocuments/d0f95a96-39c8-43bc-b372-744c4508146e_camera.jpg','coimbatore','','documentDocuments/3de61d9c-f2db-4ad7-a3b4-efd9e7bd990e_camera.jpg','','draftDocuments/98f080c4-7d59-42ab-bcad-46d3edd33319_camera.jpg','','dtcpDocuments/4c683afb-ac01-40a3-9f86-0e858d69871e_camera.jpg','',NULL,'','','2024-04-30','layout/db075877-2288-4104-9350-378ffe4a0097_camera.jpg','','legalBookDocuments/76d1167b-baf7-4947-b933-1da8b9565a8e_camera.jpg','','legalDocuments/9fd65ff0-b55c-4a6e-b2b7-277850e76cff_camera.jpg','','','','','','','companyone project','',NULL,NULL,NULL,NULL,'','','kodaikanal',1,NULL,NULL,NULL,'coimbatore','','',352,2),(552,'test','','/pages/setup/projectImages/agreementDocument/a48ca309-e469-4100-bd85-33a95c4e8a18_fc123706-f14f-4244-8e58-d28c2291c13c_download.jpg',NULL,'Tata','','/pages/setup/projectImages/corporationDocument/85759997-27ff-489d-819d-a1e12c307be8_fc123706-f14f-4244-8e58-d28c2291c13c_download.jpg','Coimbatore','','/pages/setup/projectImages/legalDocument/02a719a7-70b6-4681-bd6e-930ac93b458e_fc123706-f14f-4244-8e58-d28c2291c13c_download.jpg','','/pages/setup/projectImages/draftDocument/2496d74a-5ae6-47da-9c3c-f6e937382b0e_fc123706-f14f-4244-8e58-d28c2291c13c_download.jpg','','/pages/setup/projectImages/dtcpDocument/142000e9-68ad-4e1c-8198-2295efe6d4e0_fc123706-f14f-4244-8e58-d28c2291c13c_download.jpg','test',99,'test','test','2024-06-26','/pages/setup/projectImages/layout/dcbec936-adbf-4644-a97b-9e9cfa44cf53_fc123706-f14f-4244-8e58-d28c2291c13c_download.jpg','','/pages/setup/projectImages/legalBookDocument/10dbd58b-8ff2-43ba-8016-97fc637bf549_fc123706-f14f-4244-8e58-d28c2291c13c_download.jpg','','/pages/setup/projectImages/documentDocument/null',NULL,'test',NULL,'test','9791789306','test','CMS','',500,500,500,500,NULL,'test','Tiruchirappalli',2,500,500,NULL,'Gobi',NULL,'test',153,2);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 12:58:19
