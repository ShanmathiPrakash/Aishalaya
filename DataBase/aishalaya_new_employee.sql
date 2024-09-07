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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` bigint NOT NULL,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `alter_mobile` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL,
  `employee_email` varchar(255) DEFAULT NULL,
  `employee_mobile` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `is_active` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pin_code` varchar(255) DEFAULT NULL,
  `pref_location` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `company_company_id` bigint DEFAULT NULL,
  `role_role_id` bigint DEFAULT NULL,
  `team_team_id` bigint DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKsyaal0r0wikvpl8k2e2e92ba8` (`company_company_id`),
  KEY `FKqrd6a14b3gto2w4myw77ywe3e` (`role_role_id`),
  KEY `FKboxry3ncgids7hrijep7aea9v` (`team_team_id`),
  KEY `FK8d7lrsr6kwirr93rx0tafnoqa` (`team_id`),
  CONSTRAINT `FK8d7lrsr6kwirr93rx0tafnoqa` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `FKboxry3ncgids7hrijep7aea9v` FOREIGN KEY (`team_team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `FKqrd6a14b3gto2w4myw77ywe3e` FOREIGN KEY (`role_role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FKsyaal0r0wikvpl8k2e2e92ba8` FOREIGN KEY (`company_company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (3,'Saravanampatti','Saravanampatti','9123456788','Anna nagar','/pages/setup/employeeImages/b5e2e012-a421-414e-8215-63e9ad954b69_WhatsApp Image 2024-06-11 at 12.45.42 PM.jpeg','Coimbatore','Admin','2024-05-12 05:30:00.000000','Coimbatore','2023-11-01 05:30:00.000000',NULL,'dharshini123@gmail.com','9123456787','Dharshiniii','','1','$2a$10$wJIr.84XF.XJSbp7I0kjCeFS0ObSeYoxqs1FGpntunC8sw9br2GL6','624235','Coimbatoree','Tamilnad','Dharshini',1,8,NULL,NULL,3),(4,'Saravanampatti','Saravanampatti','9123456789','Anna nagar','avatarEmployee/7156bfab-61cf-4c5c-8fe7-cb9f50091b94_download.jpeg','Coimbatore','Admin','2024-05-13 00:00:00.000000','Coimbatore','2024-05-01 00:00:00.000000',NULL,'yamini123@gmail.com','9123456788','yamini','','1','$2a$12$thuIe7.IvDMvec4ibwqY8uFMml/Ycd/BLWw0z2haY9KF6jzeK2Kg.','624236','Coimbatore','Tamilnaduu','yamini',2,2,NULL,NULL,4),(5,'Saravanampatti','Saravanampatti','9123456782','Anna nagar','avatarEmployee/e66d6460-c58c-4a07-a18e-f9cb4cc1992c_download.jpeg','Coimbatore','Admin','2024-05-13 09:48:36.871000','Coimbatore','2023-12-20 00:00:00.000000','AISE00005','devi123@gmail.com','9123456783','Devi','female','1','$2a$12$8Yki1LI./K0y9S9njjdUKuJOewrpfUcaqQVJfxYJYo3OirO0O/EC6','624237','Coimbatore','Tamilnadu','Devi',2,3,NULL,NULL,5),(152,'Gobi','PPM Nagar','6787678787','Saravanampatti','avatarEmployee/ad28d1cd-6ffe-45f3-8689-34535f5b6ecf_contactus - Copy.jpg','Salem','sri','2024-05-18 00:00:00.000000','Salem','2024-05-22 00:00:00.000000','AISE00053','suve22@gmail.com','9994871374','suve','female','1','$2a$12$hxuv58/.hGoLFaVi9Ego3ulo6pe11C9ACHZoKv/eaTgOKfzG.wxCa','789235','coimbatore','kerala','shan',2,4,NULL,NULL,152),(402,'Tiruchirappalli','TN Palayam','9629288888','Adhanur','avatarEmployee/eddfbf4e-a440-47d9-8158-afa1d2a218bb_logo.png','Tiruchi','Admin','2024-05-20 00:00:00.000000','Alaganallur','2000-01-01 00:00:00.000000',NULL,'varun123@gmail.com','9629288888','Varund','','1','$2a$12$jemu0mHu1Cg6Lrdad.GK.ON2JQxiXpMBQvUat6Qy/EfjyDICMO1Ga','621210','Tiruchirappalli','TamilNadu','varun123@gmail.com',2,3,NULL,NULL,402),(403,'Tiruchirappalli','Tiruchi','9994871377','Alanganallur','avatarEmployee/97d55eca-afcf-4171-8093-99c137a517f6_logo.png','Alanganallur','Admin','2024-05-20 00:00:00.000000','Tiruchi','2001-01-01 00:00:00.000000','AISE00403','joyel123@gmail.com','9994871377','Joel Meshach','male','1','$2a$12$fh.NSR3/EcNAypLRgvclD..LcuPqChxfIkQjkwjzD/djZDiDjyd/W','638476','Tiruchirappalli','Tamil Nadu','joyel123@gmail.com',2,5,NULL,NULL,403),(452,'Saravanampatti','PPM Nagar','6787678787','Saravanampatti','avatarEmployee/79659422-c3bd-4899-83c3-864b407c7345_contactus - Copy.jpg','Coimbatore','srivani','2024-06-05 00:00:00.000000','Coimbatore','2000-01-18 00:00:00.000000',NULL,'vanisri29@gmail.com','9035414828','shanmathivani','','1','$2a$12$rS9w.hnn4a8utyfCs4Kfi.xnChB3ovSkMJ/K5b08uzGyOs0PRh0ea','624235','coimbatore','kerala','shan29',2,1,NULL,NULL,452),(702,'Saravanampatti','Saravanampatti','9123456781','JJ Nagar','avatarEmployee/null','Coimbatore','Shanmathi','2024-06-20 00:00:00.000000','Coimbatore','2022-03-24 00:00:00.000000','AISE00653','lakshmi123@gmail.com','9123456783','Lakshmi','female','1','$2a$10$9tn4nLds7oAc0xeryM6CDum89TLYJHUjO1uG9f6.kpvur4E4zA7YW','624216','Coimbatore','Tamilnadu','Lakshmi',2,3,NULL,NULL,702),(1002,' Saravanampatty','PPM Nagar','9025414828','salem','/pages/setup/employeeImages/c551ad23-2c5f-42df-8fbe-096c90bbc413_blockList (2).odt','salem','Admin','2024-08-05 05:30:00.000000','salem','1994-08-29 05:30:00.000000',NULL,'aruldas123@gmail.com','9025414828','Arul Das','Male','1','$2a$10$nv2Q8wTGCdPIx/jMkc4xCOEOBkgZYQ77Fq9sHfH7Jo91HkHfJDfN2','636201',NULL,'TamilNadu','arul',2,2,NULL,NULL,1002);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 12:58:18
