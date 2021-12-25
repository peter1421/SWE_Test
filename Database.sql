CREATE DATABASE  IF NOT EXISTS `fcu_shop` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `fcu_shop`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fcu_shop
-- ------------------------------------------------------
-- Server version	5.7.36-log

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
-- Table structure for table `商品資料`
--

DROP TABLE IF EXISTS `商品資料`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `商品資料` (
  `商品ID` int(11) NOT NULL AUTO_INCREMENT,
  `商品名稱` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `商品圖片` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `商品價格` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `商品敘述` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`商品ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `商品資料`
--

LOCK TABLES `商品資料` WRITE;
/*!40000 ALTER TABLE `商品資料` DISABLE KEYS */;
INSERT INTO `商品資料` VALUES (1,'漢堡','https://i.imgur.com/AklmEBl.png','1111','漢堡漢堡漢堡漢堡'),(2,'泡麵','https://i.imgur.com/dGWDm1c.png','4','泡麵泡麵泡麵泡麵'),(3,'薯條','https://i.imgur.com/ImarohO.png','555','薯條薯條薯條薯條'),(4,'可樂','https://i.imgur.com/Ha3Rdcs.png','100','可樂可樂可樂可樂');
/*!40000 ALTER TABLE `商品資料` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `帳密資料`
--

DROP TABLE IF EXISTS `帳密資料`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `帳密資料` (
  `電子郵件` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `密碼` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`電子郵件`),
  UNIQUE KEY `EMAIL_UNIQUE` (`電子郵件`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `帳密資料`
--

LOCK TABLES `帳密資料` WRITE;
/*!40000 ALTER TABLE `帳密資料` DISABLE KEYS */;
INSERT INTO `帳密資料` VALUES ('1@gmail.com','1'),('11@gmail.com','11'),('111@gmail.com','111'),('12@gmail.com','12'),('22@gmail.com','22'),('87@gmail.com','87'),('a1@gmai.com','00000000'),('a2@gmail.com','00000000'),('abcde@gmail.com','0000'),('b1@gmail.com','00000000'),('c1@gmail.com','00000000'),('pp@gmail.com','pp'),('try11@gmail.com','try11');
/*!40000 ALTER TABLE `帳密資料` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `訂單資料`
--

DROP TABLE IF EXISTS `訂單資料`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `訂單資料` (
  `訂單ID` int(11) NOT NULL AUTO_INCREMENT,
  `商品ID` int(11) NOT NULL,
  `買家Email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `商品數量` int(11) NOT NULL,
  PRIMARY KEY (`訂單ID`),
  UNIQUE KEY `orderId_UNIQUE` (`訂單ID`),
  KEY `商品ID` (`商品ID`),
  KEY `買家Email` (`買家Email`),
  CONSTRAINT `訂單資料_ibfk_1` FOREIGN KEY (`商品ID`) REFERENCES `商品資料` (`商品ID`),
  CONSTRAINT `訂單資料_ibfk_2` FOREIGN KEY (`買家Email`) REFERENCES `帳密資料` (`電子郵件`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `訂單資料`
--

LOCK TABLES `訂單資料` WRITE;
/*!40000 ALTER TABLE `訂單資料` DISABLE KEYS */;
INSERT INTO `訂單資料` VALUES (9,1,'111@gmail.com',111),(12,3,'111@gmail.com',121),(13,2,'111@gmail.com',10),(14,1,'pp@gmail.com',12),(15,2,'abcde@gmail.com',888),(16,1,'abcde@gmail.com',888),(17,2,'1@gmail.com',33),(18,1,'11@gmail.com',1);
/*!40000 ALTER TABLE `訂單資料` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-25 14:36:50
