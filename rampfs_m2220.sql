CREATE DATABASE  IF NOT EXISTS `rampfs_m2220` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rampfs_m2220`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: rampfs_m2220
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `accountId` bigint NOT NULL AUTO_INCREMENT,
  `accountNumber` varchar(255) DEFAULT NULL,
  `accountType` int DEFAULT NULL,
  `accountCustomerId` bigint DEFAULT '0',
  `accountBalance` decimal(10,0) DEFAULT '0',
  `accountCreatedOn` datetime DEFAULT NULL,
  `accountUpdatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`accountId`),
  UNIQUE KEY `accountNumber_UNIQUE` (`accountNumber`),
  KEY `account_customer_fk_idx` (`accountCustomerId`),
  CONSTRAINT `account_customer_fk` FOREIGN KEY (`accountCustomerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=100010 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (100001,'565546443633',1001,10001,250000,'2021-12-11 21:12:28',NULL),(100002,'565546443644',1001,10002,45700,'2021-12-11 21:13:27',NULL),(100004,'565546443655',1001,10004,150800,'2021-12-11 21:14:07',NULL),(100006,'565546443699',1001,10006,4500,'2021-12-13 16:59:59',NULL),(100008,'365546443699',NULL,10007,100000,'2021-12-17 11:14:43',NULL),(100009,'365546449876',NULL,10008,25000000,'2021-12-17 11:47:47',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_type`
--

DROP TABLE IF EXISTS `account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_type` (
  `accountCode` bigint NOT NULL AUTO_INCREMENT,
  `accountName` varchar(45) NOT NULL,
  `accountDescription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`accountCode`),
  UNIQUE KEY `accountName_UNIQUE` (`accountName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_type`
--

LOCK TABLES `account_type` WRITE;
/*!40000 ALTER TABLE `account_type` DISABLE KEYS */;
INSERT INTO `account_type` VALUES (1001,'SAVINGS','General Saving Account'),(1002,'CURRENT','General Current Account'),(1003,'LOAN','General Loal Account'),(1004,'WEALTH','General Wealth Account');
/*!40000 ALTER TABLE `account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customerId` bigint NOT NULL AUTO_INCREMENT,
  `customerName` varchar(255) NOT NULL,
  `customerMobile` varchar(255) NOT NULL,
  `customerEmail` varchar(255) NOT NULL,
  `customerUsername` varchar(255) NOT NULL,
  `customerPassword` varchar(255) NOT NULL,
  `customerAddress` varchar(255) NOT NULL,
  `customerType` bigint NOT NULL DEFAULT '0',
  `customerStatus` int NOT NULL,
  `customerCreatedOn` datetime DEFAULT NULL,
  `customerUpdatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `customerId_UNIQUE` (`customerId`),
  UNIQUE KEY `customerMobile_UNIQUE` (`customerMobile`),
  UNIQUE KEY `customerEmail_UNIQUE` (`customerEmail`),
  UNIQUE KEY `customerUsername_UNIQUE` (`customerUsername`)
) ENGINE=InnoDB AUTO_INCREMENT=10011 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='customerType;// General(0), Wealth(1)\ncustomerStatus;// Active(0) , Inactive(1), Closed(2), Hold(3)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (10001,'VENKATESWARA RAO','9876543210','venkatesh@gmail.com','venkateshusername','venkateshpassword','Road No.36, Jubilee Hills, near Bank of Baroda, Hyderabad',101,0,'2021-12-10 23:39:36',NULL),(10002,'PUSHPA RAJ','6543219870','pushparaj@gmail.com','pushparajusername','pushparajpassword','Road No.01, Jubilee Hills, near PVR mall, Hyderabad',101,0,'2021-12-11 19:57:12',NULL),(10004,'M AKHANDA','9516238470','akhanda@gmail.com','akhandausername','akhandapassword','Road No.02, Jubilee Hills, near Metro Station, Hyderabad',101,0,'2021-12-11 20:00:20',NULL),(10006,'RAVI TEJA','9516238444','raviteja@gmail.com','ravitejausername','ravitejapassword','Road No.899, Jubilee Hills, near Metro Station, Hyderabad',101,0,'2021-12-13 16:59:08',NULL),(10007,'Bhagvan Singh','95162381111','bhagavansingh@gmail.com','bhagavansinghusername','bhagavansinghpassword','Metro House, Bunglow No. 28/2, Anand Nagar, C. K. Naidu Road, MH',101,0,'2021-12-17 11:13:11',NULL),(10008,'Santosh Kushwah','95162382222','santoshkushwah@gmail.com','santoshkushwah','santoshkushwahpassword','Sector 21, Mansarovar, Jaipur, Rajasthan',101,0,NULL,'2021-12-17 12:29:20'),(10009,'Vishitha Manu','6666655555','vishithamanu@gmail.com','vishithamanu','vishithamanups','kailash nagar, Road no.6 , chandanagar, hyderabad, telangana',101,0,NULL,'2021-12-17 12:29:34'),(10010,'Vishnu Priya','6666622222','vishnupriya@gmail.com','vishnupriya','vishnupriya','Anandh nagar, Street no.8 , chandanagar, hyderabad, telangana',101,0,'2021-12-17 12:38:50','2021-12-17 12:39:34');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginuser`
--

DROP TABLE IF EXISTS `loginuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loginuser` (
  `loginuserId` bigint NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` varchar(45) NOT NULL,
  `roles` varchar(255) NOT NULL,
  `customerId` bigint NOT NULL,
  PRIMARY KEY (`loginuserId`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `customerId_UNIQUE` (`customerId`),
  CONSTRAINT `fk_loginuser_customer` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginuser`
--

LOCK TABLES `loginuser` WRITE;
/*!40000 ALTER TABLE `loginuser` DISABLE KEYS */;
INSERT INTO `loginuser` VALUES (100001,'venkateswararao.c','venkat123','true','CUSTOMER',10001);
/*!40000 ALTER TABLE `loginuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transactionId` bigint NOT NULL AUTO_INCREMENT,
  `transactionAmount` double NOT NULL,
  `transactionNumber` varchar(255) NOT NULL,
  `transactionUpdatedOn` datetime DEFAULT NULL,
  `transactionType` int NOT NULL,
  `transactionAccountId` bigint NOT NULL DEFAULT '0',
  `transactionAccountNumber` varchar(255) DEFAULT NULL,
  `transactionstate` varchar(45) DEFAULT NULL,
  `transactionOn` datetime DEFAULT NULL,
  PRIMARY KEY (`transactionId`),
  KEY `transaction_account_fk_idx` (`transactionAccountId`),
  CONSTRAINT `transaction_account_fk` FOREIGN KEY (`transactionAccountId`) REFERENCES `account` (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=1000025 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1000001,1000,'e6b16263-f982-45b9-b82d-3a9098a3ec94',NULL,1,100002,'565546443644','COMPLETE','2021-12-11 22:50:26'),(1000002,1000,'e6b16263-f982-45b9-b82d-3a9098a3ec94',NULL,0,100001,'565546443633','COMPLETE','2021-12-11 22:50:27'),(1000003,1000,'9d91aa69-8441-411a-8d85-649b3b99e433',NULL,1,100002,'565546443644','COMPLETE','2021-12-11 23:07:37'),(1000004,1000,'9d91aa69-8441-411a-8d85-649b3b99e433',NULL,0,100001,'565546443633','COMPLETE','2021-12-11 23:07:37'),(1000005,1000,'68cdd378-1195-42be-aa25-177c723af9b6',NULL,1,100002,'565546443644','COMPLETE','2021-12-11 23:12:09'),(1000006,1000,'68cdd378-1195-42be-aa25-177c723af9b6',NULL,0,100001,'565546443633','COMPLETE','2021-12-11 23:12:09'),(1000007,500,'74cf164a-4106-418b-93a1-9ecaa36bd3df',NULL,1,100002,'565546443644','COMPLETE','2021-12-11 23:21:28'),(1000008,500,'74cf164a-4106-418b-93a1-9ecaa36bd3df',NULL,0,100001,'565546443633','COMPLETE','2021-12-11 23:21:29'),(1000009,500,'ebfd5b81-56a3-46e9-864a-5dc1cf8dd4bc',NULL,1,100002,'565546443644','COMPLETE','2021-12-11 23:23:01'),(1000010,500,'ebfd5b81-56a3-46e9-864a-5dc1cf8dd4bc',NULL,0,100001,'565546443633','COMPLETE','2021-12-11 23:23:01'),(1000011,500,'b898de02-7c6b-401c-b53e-370e9e02a39c',NULL,1,100002,'565546443644','COMPLETE','2021-12-11 23:32:31'),(1000012,500,'b898de02-7c6b-401c-b53e-370e9e02a39c',NULL,0,100001,'565546443633','COMPLETE','2021-12-11 23:32:31'),(1000013,600,'c2e1bf41-1469-4ceb-8026-3a177729bba0',NULL,1,100002,'565546443644','COMPLETE','2021-12-12 11:36:52'),(1000014,600,'c2e1bf41-1469-4ceb-8026-3a177729bba0',NULL,0,100001,'565546443633','COMPLETE','2021-12-12 11:36:52'),(1000015,100,'4a059371-d18e-405d-a1b8-0a77dc68bf28',NULL,1,100002,'565546443644','COMPLETE','2021-12-12 11:39:42'),(1000016,100,'4a059371-d18e-405d-a1b8-0a77dc68bf28',NULL,0,100001,'565546443633','COMPLETE','2021-12-12 11:39:42'),(1000017,100,'aa340929-135f-4996-b51f-6ab901e6eeb8',NULL,1,100002,'565546443644','COMPLETE','2021-12-12 11:50:14'),(1000018,100,'aa340929-135f-4996-b51f-6ab901e6eeb8',NULL,0,100001,'565546443633','COMPLETE','2021-12-12 11:50:15'),(1000019,1000,'2cf74100-057b-4bd2-9dae-8e02d3aba363',NULL,1,100001,'565546443633','COMPLETE','2021-12-12 23:36:05'),(1000020,1000,'2cf74100-057b-4bd2-9dae-8e02d3aba363',NULL,0,100002,'565546443644','COMPLETE','2021-12-12 23:36:05'),(1000021,800,'b3056c87-fab0-4e6b-a94f-fe492eff6f34',NULL,1,100001,'565546443633','COMPLETE','2021-12-13 16:27:51'),(1000022,800,'b3056c87-fab0-4e6b-a94f-fe492eff6f34',NULL,0,100004,'565546443655','COMPLETE','2021-12-13 16:27:51'),(1000023,3500,'e7eb0ba9-16c0-4bc8-bb05-53410b2483d2',NULL,1,100001,'565546443633','COMPLETE','2021-12-13 17:01:45'),(1000024,3500,'e7eb0ba9-16c0-4bc8-bb05-53410b2483d2',NULL,0,100006,'565546443699','COMPLETE','2021-12-13 17:01:45');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-21 19:02:48
