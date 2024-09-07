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
-- Table structure for table `crm_user`
--

DROP TABLE IF EXISTS `crm_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crm_user` (
  `id` bigint NOT NULL,
  `company_id` bigint DEFAULT NULL,
  `employee_code` varchar(255) DEFAULT NULL,
  `employee_email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_user`
--

LOCK TABLES `crm_user` WRITE;
/*!40000 ALTER TABLE `crm_user` DISABLE KEYS */;
INSERT INTO `crm_user` VALUES (1,1,'AISE00002','dharshini456@gmail.com','Dharshini','Dharshini'),(2,1,'AISE00002','companytwo@gmail.com','vani','vani123@gmail.com'),(3,1,'AISE00002','dharshini123@gmail.com','Dharshini','Dharshini'),(4,1,'AISE00004','yamini123@gmail.com','yamini','yamini'),(5,1,'AISE00005','devi123@gmail.com','Devi','Devi'),(6,1,'AISE00006','bala123@gmail.com','bala','Bala'),(52,1,'AISE00007','ss@gmail.com','ssssss','shan'),(102,2,'AISE00053','dharshini123@gmail.com','dharshini','Dharshini'),(103,3,'AISE00103','devi123@gmail.com','devi','Devi'),(152,102,'AISE00053','surya22@gmail.com','$2a$10$euPkABz6QOlpaAG7TTJSJ.dOa8w7ef8RwIP10kUEJaZTOCQSZCek.','shan'),(202,3,'AISE00153','suvetha123@gmail.com','$2a$10$Cfm.DzR2zSLTzufuXq.QA.mz6.AEl3fnusJTcdhQXy/Woa.EvC5ru','suve'),(252,2,'AISE00203','siva123@gmail.com','$2a$10$n6afGG7F0RixPykc4PLbyeiEkcaBDdUeuE7n4I0Ju1bj0jbWv8GFO','shan'),(302,3,'AISE00253','sandy123@gmail.com','$2a$10$NXmUXNMXWvNoA246sehX3ur.oG5LxxjxrFtgMU8z/7eZPHBtPmieS','sandy'),(352,2,'AISE00203','shanmathiprakash88@gmail.com','$2a$10$5352xtDKKlCmYwLN0BJHwuLjxkMHonaSACdVrjAu869UevnnAQxwu','shan'),(402,202,'AISE00203','9629288888','$2a$10$N0fOCnPcOM9tLv7whfArP.zZJN.IEqE3hEt/RDm6gmMTPng0BZLZ.','varun123@gmail.com'),(403,202,'AISE00403','joyel123@gmail.com','$2a$10$THg3x76qYF.G/kwbokVLLuP87ensrlibH9iHM3g0ZlppIhlsTYdte','joyel123@gmail.com'),(452,302,'AISE00404','vanisri29@gmail.com','$2a$10$qJvhipW4ybIaJvUVtf9aWOU8fNDsu7srUTh63DbIcvVODvU.8evla','shan29'),(502,202,'AISE00453','Vanisri1103@gmail.com','$2a$10$ra7ER8K1W/F055PJ5gEDF.qE04YN4m5fuI2hJCzZ8WhRYm7bP5u.2','prakash'),(503,302,'AISE00503','suresh@gmail.com','$2a$10$TO6jnEKrdoZeMVLaMJAJzupfdnd2ANURr2e2IadnoZLkuD3QjuIRW','suresh'),(552,252,'AISE00504','Vanisri1103@gmail.com','$2a$10$W6tZUiFaGLHncJezXm.F4OBwRev/MB.DHMxpuICo/O3WuEtJShKI6','shan'),(602,452,'AISE00553','kannan123@gmail.com','$2a$10$M6y2YTbPy.1.OoXWfl1PMurOvL2M0OadQ7C.vmNMNIktPxHxVpXs.','kannan'),(652,502,'AISE00603','kaviya123@gmail.com','$2a$10$Qv5LVgxrxHqki.oxMiO2MOJvztpknUmhTUj/ApvQi8Vy1bA/Xerfm','Kaviya'),(702,502,'AISE00653','lakshmi123@gmail.com','$2a$10$9tn4nLds7oAc0xeryM6CDum89TLYJHUjO1uG9f6.kpvur4E4zA7YW','Lakshmi'),(752,552,'AISE00703','prakash1103@gmail.com','$2a$10$y8lbx0/0b5tH/e16E2HToO5xJbp01PC.07GOakkiTWroq1FngnIZ6','prakash1103@gmail.com'),(753,552,'AISE00753','prakash1103@gmail.com','$2a$10$ramPybsVL8L1sKs4in6Xy.H6.I7YCI7VAG.cYFybKvfR9vTDKOufu','prakash1103@gmail.com'),(754,552,'AISE00753','prakash1103@gmail.com','$2a$10$idopzHqybPQ7BX1DDjV7xO81OD98O3Oo0oLjhEyzcQ8QEoZPe1eti','prakash1103@gmail.com'),(802,2,'AISE00755','kaviya123@gmail.com','$2a$10$gIswffI7kDIG5AbSOvn4/Op5rMU9kbLyqTBcsMPs2zafcasKg.jO6','Kaviya'),(803,2,'AISE00803','kaviya123@gmail.com','$2a$10$/IuOfc2V1a1HFDLDBJ4XUOhcU3dXdWaJ1y.NOWdPbPmVUtYXOTSiu','Kaviya'),(852,2,'AISE00804','prakash11103@gmail.com','$2a$10$Bda70To2/igX5kpaw.G44OlCim8YQAgEC4yqd7b5Pzeus4C8IQRkG','prakash11103@gmail.com'),(902,202,'AISE00853','sdf@gmail.com','$2a$10$vCX9m2ez5gcBqnuIn.0C2uQJF/5.Djl24a0gqaj1hCYVdEfrjXqKa','shan'),(903,202,'AISE00903','sdf@gmail.com','$2a$10$KwavC6owSbS4SpRuD42TEOe1U8Pl75HjEca6zyywP8cCcEfN48CO.','shan'),(904,202,'AISE00904','ggggggg@gmail.com','$2a$10$4L0rLPRgYaT5C3FdQ2/Ts.mMMQXmzaQVNpKl76SB93nl1OLxhK9eC','shan'),(905,202,'AISE00905','fz@gmail.com','$2a$10$Ic3EgVBw8zAhm8nYIL.6SukP2wlrpAEPVSRgEISxTW6ELtmUNnTDC','DDD'),(906,202,'AISE00906','ss@gmail.com','$2a$10$GB4Sz1uF/TZ7EIvkcquf6u6Y.ynftA1XgfWCgFMG5g/ONnqM/yo8O','DSDSDDSDS'),(907,202,'AISE00907','ggggggg@gmail.com','$2a$10$kVT.40Xc1fYaUfGV2viwKeUcssw4a4/a5tcUFethSbE3dzPqk3QlK','HJHJHJHJ'),(908,202,'AISE00908','dd@gmail.com','$2a$10$GI235i9FxYyA9bEC6VqVOeWlf6zlPy74LW/c.PtPcluXqcS04mikm','ghghghgh891291821'),(952,202,'AISE00909','elankumaranraj@gmail.com','$2a$10$Kaaj4sKuQ1fOoDkEDUOcruYMd8I16DI6XQcsJPta51mlSZOI5Fgva','kumaran '),(953,202,'AISE00909','elankumaranraj@gmail.com','$2a$10$r2iflK5Acus4vxgyAPWs7.WBbZ7tJ0ZIifFcIX2mrxmFdPwXPdwBe','kumaran '),(1002,2,'AISE00953','aruldas123@gmail.com','$2a$10$nv2Q8wTGCdPIx/jMkc4xCOEOBkgZYQ77Fq9sHfH7Jo91HkHfJDfN2','arul'),(1052,552,'AISE01003','q','$2a$10$LeKtV9whMVoSwQgNFxfduOMOjDo0O.42S25Yzpqejv1UeL5lp3bL2','dfwe'),(1053,603,'AISE01053','shanm@123@gmail.com','$2a$10$N.BzaMAEz5WGaBEkV3dnYug96kmnhj5R5PUL8yXblhuGejiTlFZae','dfwe'),(1054,603,'AISE01054','f','$2a$10$6vzC7LChF9ifqUVGsoLobOqYozp/XbeUGq/sHcRaX9bwygi4Npv5u','dfwe'),(1055,603,'AISE01055','a','$2a$10$tPt9CdMHiap8mEaJBiN1Q.hYR6NAAvOrEzmx1WQif7PdQYfrsXQ9a','a'),(1056,602,'AISE01056','mari@gmail.com','$2a$10$hTjU6ckTbM1cUPjzNX.6TujXrI3pqhWga7FXMywIreMGxoqo96dua','dfwe'),(1102,603,'AISE01057','dharshini12','$2a$10$UoA2LjRgbUTgRK9gFLBnP.I.vkG/6ZSKrmeJp6dfTNAejWE/bgU1C','d'),(1103,603,'AISE01103','dharshini12','$2a$10$m9EzVW5Q6ciGszC8RW2QzuWsjSPBMFdb6ab4vPWXUQBSZcymIPXwK','d'),(1104,603,'AISE01104','dharshini12','$2a$10$8muKlBWPxT035s79eAXmLObSmmPtnqmcZoE4lNajkDM33kVIF34GS','d'),(1105,603,'AISE01105','dharshini12','$2a$10$TIMmrSnEVaJr/bn1Bo6jKujQYsJDzcM57FGgZA4TI7yVCI/GbiuPG','d'),(1106,602,'AISE01106','a','$2a$10$/9gK8PCORZ3CcQBcBtptvuzJkwWLG37Fy07gKnM5KTS/6x7KSQoum','d'),(1107,603,'AISE01107','','$2a$10$HNsEEFwqLtTIyRXD0ixKHODzv.wJiMijnyrDuAcpEoQFf3Z2WSBzC','a'),(1108,29,'AISE01108','a','$2a$10$089ILPROf7wGalawDS1f/uHVdMrHKQSa7gVGSoaxHulcNPGFmOWc6','a'),(1109,602,'AISE01109','a','$2a$10$rfiug8Y9ozlVpqeRKKTmIeUwBFrBHxX3beGZCxGt6BMEhMbQCmC/6','d'),(1110,3,'AISE01110','yamini123@gmail.com','$2a$10$ePx89IFzke2qzNeVBUxC0e/YpDkz1Wpz78Z0billd4EIQ2L1nH/eu','d'),(1111,602,'AISE01111','hamini123@gmail.com','$2a$10$e6ZS4HXrotD3tSiH4Oc8FuaMv3InWdfQFuwmrb8o1II.dq9aTOE12','a'),(1112,603,'AISE01112','a','$2a$10$OQDXinb0Jq7BgoaH09/g4OsI6K1p3WS.A.qzmpkkPCx.OP2UkWudC','a'),(1113,602,'AISE01113','a','$2a$10$9XzZwYMouMhm9i1./LQ4.u3P340TAaOpRDZ0hCx0kHzPP/OJDuU8y','a'),(1114,603,'AISE01114','dharshini12','$2a$10$.ztWtEZKZqXu6fG/zeaTeOSQLeD6ojENwsyd0j5Bwun8rY.Amu3cG','a'),(1115,603,'AISE01115','dharshini12','$2a$10$MeavzSKWTpR48wiitbW1buDzMxV.RKBabTSkfc4Y06SuS8fxFpQTC','d'),(1116,603,'AISE01116','dharshini12','$2a$10$WS12Qpcm4e69u9cfLVWQhOlkgwCU6SxpXDffFYaAcEvUkPjzlAb2K','a'),(1117,1,'AISE01003','a','$2a$10$nnf.hX2o2tgWSowVtVLxT./rQn35X7lqjHLqbya9GJhtToXl62num','d'),(1118,1,'AISE01118','a','$2a$10$xY5FTRdWjsZOyak9ZI/kZOsCvzLbciXoiZOoFfbqGt2urP1bAabKe','a'),(1119,1,'AISE01119','a','$2a$10$IXaCEo0/30KaBBIGoY33mu01A.MRItgnRHZwU3AY/9jODoyeWGDfq','a'),(1120,1,'AISE01120','a','$2a$10$/duDlkOMq3J9W3FTTe9ph.w008Jc4KFEyfdHp8wSHKFg.H2xP5N/G','a'),(1121,1,'AISE01121','dharshini12','$2a$10$vT30WZ54zg6L7mZssUYcS.Ng9eH2UjtZ.07ON.vebwQsZwHxqfKjO','a'),(1122,1,'AISE01122','dharshini12','$2a$10$VSBcvlY8nwkFfPeyPni4veSMesfL9D79566qb80Rn8nrFy2fxngNK','a'),(1123,1,'AISE01123','varun123@gmail.com','$2a$10$fyXAUd/MsRpF3CiEB5zc0eOWHTkf0zBjNykwlUGuuHyTVcaii7Yya','a'),(1124,1,'AISE01124','q','$2a$10$wB.J7mbVmwPbFv1iFrkCh.Y7znmghsKXbV0Ub7yfCAhHifEGsikru','d'),(1125,1,'AISE01125','varun123@gmail.com','$2a$10$Y982H1MyT1wSQi3r7igmuuQt4FUDV51bKpyaDtyngPdfc0JB40/5K','a'),(1126,1,'AISE01126','d','$2a$10$SNcLaPcmoK5VAX98CKjloOLUaoS0/VAmj67vb8mDtczz7rzavOBFa','d');
/*!40000 ALTER TABLE `crm_user` ENABLE KEYS */;
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
