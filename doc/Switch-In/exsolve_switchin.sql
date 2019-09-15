-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: exsolve_switchin
-- ------------------------------------------------------
-- Server version	5.6.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` varchar(50) NOT NULL,
  `eventName` varchar(50) NOT NULL,
  `merchantId` varchar(50) NOT NULL,
  `createtime` datetime DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `Tagline` varchar(50) DEFAULT NULL,
  `price` decimal(20,2) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `csPhone` varchar(10) DEFAULT NULL,
  `location` varchar(500) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `twitter` varchar(50) DEFAULT NULL,
  `facebook` varchar(50) DEFAULT NULL,
  `map` varchar(500) DEFAULT NULL,
  `maxpax` int(7) DEFAULT NULL,
  `maxpaxPerRegister` int(7) DEFAULT NULL,
  `status` int(3) DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `reminder` varchar(250) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES ('EV1','erver100','SI_MC32','2019-09-16 01:37:32','2019-09-01 00:00:00','2019-09-08 00:00:00',NULL,100.00,NULL,'3432423',NULL,'klcc','123123@#@#$','123123@34234',NULL,100,100,0,NULL,'fsdf','123123','123123'),('EV2','erver103','SI_MC30','2019-09-16 01:38:21','2019-09-02 00:00:00','2019-09-17 00:00:00',NULL,100.00,'2019-09-16 01:56:00','3432423',NULL,'klccooo','123123@#@#$','agas@com',NULL,100,100,0,NULL,'司法所地方','水电费是否s','dfsdfs');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_picture`
--

DROP TABLE IF EXISTS `event_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_picture` (
  `id` varchar(32) NOT NULL,
  `event_id` int(11) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `indx` int(3) DEFAULT NULL,
  `name_old` varchar(100) DEFAULT NULL,
  `name_new` varchar(150) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_picture`
--

LOCK TABLES `event_picture` WRITE;
/*!40000 ALTER TABLE `event_picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exl_agent`
--

DROP TABLE IF EXISTS `exl_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exl_agent` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `qualification` varchar(50) DEFAULT NULL,
  `policyNo` varchar(50) DEFAULT NULL,
  `agentIdNo` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  `googlePlus` varchar(100) DEFAULT NULL,
  `profilePicture` varchar(500) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `lastUpdateTime` datetime DEFAULT NULL,
  `loginTimes` int(7) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exl_agent`
--

LOCK TABLES `exl_agent` WRITE;
/*!40000 ALTER TABLE `exl_agent` DISABLE KEYS */;
INSERT INTO `exl_agent` VALUES ('EXL_AG1','aaa','4297F44B13955235245B2497399D7A93','asdfasdfa','M','2019-07-30','ijdfsnn',NULL,NULL,'1231212','123123','123123@fsdf','123123123','123123',NULL,'2019-08-30 09:37:08',NULL,'2019-08-30 09:37:08',NULL,0,NULL),('EXL_AG2','a01','4297F44B13955235245B2497399D7A93','123123','F','2019-08-13','123123',NULL,NULL,'123123','12123','123123@123','123123','123123',NULL,'2019-08-30 11:43:06',NULL,'2019-08-30 11:43:06',NULL,0,NULL),('EXL_AG3','a02','4297F44B13955235245B2497399D7A93','123123','F','2019-08-04','123123',NULL,NULL,'123123','123123','123123@12313','123123@123','23123',NULL,'2019-08-30 11:49:32',NULL,'2019-08-30 11:49:32',NULL,0,NULL),('EXL_AG4','a03','4297F44B13955235245B2497399D7A93','12123','M','2019-07-29','123123',NULL,NULL,'12312','123123','123123@123','123123','123123',NULL,'2019-08-30 11:57:54',NULL,'2019-08-30 11:57:54',NULL,0,NULL),('EXL_AG5','a04','4297F44B13955235245B2497399D7A93','12123','M','2019-07-29','123123',NULL,NULL,'12312','123123','123123@123','123123','123123','/exl_agent/EXL_AG5/PROFILE/20190830121349_Screen Shot 2019-06-16 at 22.40.08.png','2019-08-30 12:02:12',NULL,'2019-08-30 12:13:50',NULL,0,NULL),('EXL_AG6','sdff','4C4711EA06C811B55AFE1017DC3F39DC','23123','F','2019-08-20','12123',NULL,NULL,'123123','123123','123123@123123','123123','123123','/exl_agent/EXL_AG6/PROFILE/20190830121817_Screen Shot 2019-06-18 at 10.39.06.png','2019-08-30 12:14:37',NULL,'2019-08-30 12:19:28',NULL,0,NULL);
/*!40000 ALTER TABLE `exl_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exl_agent_file`
--

DROP TABLE IF EXISTS `exl_agent_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exl_agent_file` (
  `id` varchar(32) NOT NULL,
  `agentId` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `indx` int(3) DEFAULT NULL,
  `name_old` varchar(100) DEFAULT NULL,
  `name_new` varchar(150) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exl_agent_file`
--

LOCK TABLES `exl_agent_file` WRITE;
/*!40000 ALTER TABLE `exl_agent_file` DISABLE KEYS */;
INSERT INTO `exl_agent_file` VALUES ('6cba605eba3941cd9d9cf3694751995c','EXL_AG6','PROFILE',-1,'Screen Shot 2019-06-18 at 10.39.06.png','20190830121817_Screen Shot 2019-06-18 at 10.39.06.png','/exl_agent/EXL_AG6/PROFILE/20190830121817_Screen Shot 2019-06-18 at 10.39.06.png'),('bb09a32e6ff345ffacd65d82f615cc98','EXL_AG5','PROFILE',-1,'Screen Shot 2019-06-16 at 22.40.08.png','20190830121349_Screen Shot 2019-06-16 at 22.40.08.png','/exl_agent/EXL_AG5/PROFILE/20190830121349_Screen Shot 2019-06-16 at 22.40.08.png');
/*!40000 ALTER TABLE `exl_agent_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exl_client`
--

DROP TABLE IF EXISTS `exl_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exl_client` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `policyNo` varchar(50) DEFAULT NULL,
  `agentId` varchar(50) DEFAULT NULL,
  `agentName` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  `googlePlus` varchar(100) DEFAULT NULL,
  `profilePicture` varchar(500) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `lastUpdateTime` datetime DEFAULT NULL,
  `loginTimes` int(7) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exl_client`
--

LOCK TABLES `exl_client` WRITE;
/*!40000 ALTER TABLE `exl_client` DISABLE KEYS */;
INSERT INTO `exl_client` VALUES ('EXL_CL1','c01','4297F44B13955235245B2497399D7A93','123123','M','2019-08-13','123123','123123',NULL,'123123','123123@123','123123','123123','/exl_client/EXL_CL1/PROFILE/20190830161112_Screen Shot 2019-06-18 at 10.39.06.png','2019-08-30 15:41:56',NULL,'2019-08-30 16:11:13',NULL,0,NULL),('EXL_CL2','c02','4297F44B13955235245B2497399D7A93','123123','M','2019-08-13','123123','123123',NULL,'123123','123123@123','123123','123123',NULL,'2019-08-30 15:44:27',NULL,'2019-08-30 15:44:27',NULL,0,NULL),('EXL_CL3','c03','4297F44B13955235245B2497399D7A93','123123','M','2019-08-13','123123','123123',NULL,'123123','123123@123','123123','123123',NULL,'2019-08-30 15:49:23',NULL,'2019-08-30 15:49:23',NULL,0,NULL),('EXL_CL4','c04','4297F44B13955235245B2497399D7A93','123123','M','2019-08-13','123123','123123',NULL,'123123','123123@123','123123','123123',NULL,'2019-08-30 15:51:18',NULL,'2019-08-30 15:51:18',NULL,0,NULL),('EXL_CL5','c05','4297F44B13955235245B2497399D7A93','123123','M','2019-08-13','123123','123123',NULL,'123123','123123@123','123123','123123','/exl_client/EXL_CL5/PROFILE/20190830155910_Screen Shot 2019-06-25 at 09.30.20.png','2019-08-30 15:59:10',NULL,'2019-08-30 15:59:10',NULL,0,NULL),('EXL_CL6','c06','4297F44B13955235245B2497399D7A93','123123','M','2019-08-20','123123','123123',NULL,'123123','123123@123','123123','123123','/exl_client/EXL_CL6/PROFILE/20190830160500_Screen Shot 2019-06-21 at 13.38.29.png','2019-08-30 16:00:36',NULL,'2019-08-30 16:05:13',NULL,0,NULL);
/*!40000 ALTER TABLE `exl_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exl_client_file`
--

DROP TABLE IF EXISTS `exl_client_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exl_client_file` (
  `id` varchar(32) NOT NULL,
  `clientId` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `indx` int(3) DEFAULT NULL,
  `name_old` varchar(100) DEFAULT NULL,
  `name_new` varchar(150) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exl_client_file`
--

LOCK TABLES `exl_client_file` WRITE;
/*!40000 ALTER TABLE `exl_client_file` DISABLE KEYS */;
INSERT INTO `exl_client_file` VALUES ('50ef96f66b7d4d728499eaa08c667277','EXL_CL5','PROFILE',-1,'Screen Shot 2019-06-25 at 09.30.20.png','20190830155910_Screen Shot 2019-06-25 at 09.30.20.png','/exl_client/EXL_CL5/PROFILE/20190830155910_Screen Shot 2019-06-25 at 09.30.20.png'),('5585c3e91c264a6cb15d5a34a9c14a03','EXL_CL6','PROFILE',-1,'Screen Shot 2019-06-21 at 13.38.29.png','20190830160500_Screen Shot 2019-06-21 at 13.38.29.png','/exl_client/EXL_CL6/PROFILE/20190830160500_Screen Shot 2019-06-21 at 13.38.29.png'),('b1d4baf074f94653a5316750be5e3273','EXL_CL4','PROFILE',-1,'Screen Shot 2019-06-16 at 22.40.08.png','20190830155118_Screen Shot 2019-06-16 at 22.40.08.png','/exl_client/EXL_CL4/PROFILE/20190830155118_Screen Shot 2019-06-16 at 22.40.08.png'),('f50e99de2e3240bab5877e1235818592','EXL_CL1','PROFILE',-1,'Screen Shot 2019-06-18 at 10.39.06.png','20190830161112_Screen Shot 2019-06-18 at 10.39.06.png','/exl_client/EXL_CL1/PROFILE/20190830161112_Screen Shot 2019-06-18 at 10.39.06.png');
/*!40000 ALTER TABLE `exl_client_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequenceNo`
--

DROP TABLE IF EXISTS `sequenceNo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequenceNo` (
  `siMerchantTotal` int(5) DEFAULT '0',
  `siMemberTotal` int(5) DEFAULT '0',
  `exlAgentTotal` int(5) DEFAULT '0',
  `exlClientTotal` int(5) DEFAULT '0',
  `eventTotal` int(5) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequenceNo`
--

LOCK TABLES `sequenceNo` WRITE;
/*!40000 ALTER TABLE `sequenceNo` DISABLE KEYS */;
INSERT INTO `sequenceNo` VALUES (32,21,6,6,2);
/*!40000 ALTER TABLE `sequenceNo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `si_member`
--

DROP TABLE IF EXISTS `si_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `si_member` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `occupation` varchar(50) DEFAULT NULL,
  `interesteCategory` varchar(250) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  `googlePlus` varchar(100) DEFAULT NULL,
  `userType` varchar(20) DEFAULT NULL,
  `agentId` varchar(50) DEFAULT NULL,
  `profilePicture` varchar(500) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `lastUpdateTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `loginTimes` int(7) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remark` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `si_member`
--

LOCK TABLES `si_member` WRITE;
/*!40000 ALTER TABLE `si_member` DISABLE KEYS */;
INSERT INTO `si_member` VALUES ('SI_MB1','memok','12313','mmok','M',NULL,'2019-08-09',NULL,NULL,'(60)123123','mm@com','mm@com','mm@com',NULL,NULL,NULL,'2019-08-10 01:32:09',NULL,'2019-08-30 00:26:34',NULL,NULL,0,NULL),('SI_MB10','mmm','123123','123123','M',NULL,'2019-08-22',NULL,NULL,'123123','123123@123','121231','23123',NULL,NULL,NULL,'2019-08-26 17:35:16',NULL,'2019-08-26 17:35:16',NULL,NULL,0,NULL),('SI_MB11','yyuu','123123','123123','M',NULL,'2019-08-21',NULL,NULL,'123123','123@123','123123','123123',NULL,NULL,NULL,'2019-08-26 17:36:44',NULL,'2019-08-26 17:36:44',NULL,NULL,0,NULL),('SI_MB12','wwqq','123123','123123','F',NULL,'2019-08-06',NULL,NULL,'12312','123123@123','123123','123123',NULL,NULL,NULL,'2019-08-26 17:38:28',NULL,'2019-08-30 00:26:58',NULL,NULL,0,NULL),('SI_MB13','hahah','123123','123123','M',NULL,'2019-09-04',NULL,NULL,'123123','sdfs@sdf','123123','123123',NULL,NULL,NULL,'2019-08-27 16:06:09',NULL,'2019-08-27 16:06:09',NULL,NULL,0,NULL),('SI_MB14','koko','123123','123123','M',NULL,'2019-08-28',NULL,NULL,'123123','123@123','12313','123132',NULL,NULL,NULL,'2019-08-27 16:08:11',NULL,'2019-08-27 16:08:11',NULL,NULL,0,NULL),('SI_MB15','rruru','123123','123123','M',NULL,'2019-08-01',NULL,NULL,'1231231','13123@sdfs','131313','1313',NULL,NULL,NULL,'2019-08-27 16:12:00',NULL,'2019-08-27 16:12:00',NULL,NULL,0,NULL),('SI_MB16','jjjj','12123','123123','M',NULL,'2019-08-14',NULL,NULL,'123123','sdad@sdf','123123','2131',NULL,NULL,NULL,'2019-08-27 16:34:52',NULL,'2019-08-27 16:34:52',NULL,NULL,0,NULL),('SI_MB17','havepic','123123','12123','M',NULL,'2019-08-28',NULL,NULL,'12123','123123@123','123123','123123',NULL,NULL,NULL,'2019-08-27 16:50:49',NULL,'2019-08-27 16:50:49',NULL,NULL,0,NULL),('SI_MB18','nopic','2312123','123123','M',NULL,'2019-07-30',NULL,NULL,'112313','qweqwe@ad','123123','123123',NULL,NULL,NULL,'2019-08-27 16:51:47',NULL,'2019-08-27 16:51:47',NULL,NULL,0,NULL),('SI_MB19','ttww','123123','12123','M',NULL,'2019-07-11',NULL,NULL,'123123','123123@123','123123','123123',NULL,NULL,NULL,'2019-08-27 18:04:28',NULL,'2019-08-27 18:04:28',NULL,NULL,0,NULL),('SI_MB2','memaa','123123','mmaa','M',NULL,'2019-08-09',NULL,NULL,'(60)123123','mm@com','mm@com','mm@com',NULL,NULL,NULL,'2019-08-11 02:12:38',NULL,'2019-08-11 02:12:38',NULL,NULL,0,NULL),('SI_MB20','sdfsdfsd','123123','123123','F',NULL,'2019-08-08',NULL,NULL,'123123','qqeqwe@sdf','12313','123123',NULL,NULL,NULL,'2019-08-29 11:27:30',NULL,'2019-08-29 11:27:30',NULL,NULL,0,NULL),('SI_MB21','223wfw','123123','4444','F',NULL,'2019-08-15',NULL,NULL,'1231231','123@123','23123','123123',NULL,NULL,NULL,'2019-08-29 15:28:33',NULL,'2019-08-30 00:25:18',NULL,NULL,0,NULL),('SI_MB3','membb','123123','mmbb','M',NULL,'2019-08-09',NULL,NULL,'(60)123123','mm@com','mm@com','mm@com',NULL,NULL,NULL,'2019-08-11 02:12:54',NULL,'2019-08-11 02:12:54',NULL,NULL,0,NULL),('SI_MB4','erwr','','wwerw','M',NULL,'2019-08-25',NULL,NULL,'123123','sdfsd@sdfs','123123','123123',NULL,NULL,NULL,'2019-08-25 23:36:04',NULL,'2019-08-30 00:32:51',NULL,NULL,0,NULL),('SI_MB5','yyyy','123123','yyy','M',NULL,'2019-08-21',NULL,NULL,'123123','sdfsdf@sdfsd.com','sdfsdf@sdfsd.com','sdfsdf@sdfsd.com',NULL,NULL,NULL,'2019-08-26 02:17:40',NULL,'2019-08-26 02:17:40',NULL,NULL,0,NULL),('SI_MB6','yyyx','123123','yyy','M',NULL,'2019-08-21',NULL,NULL,'123123','sdfsdf@sdfsd.com','sdfsdf@sdfsd.com','sdfsdf@sdfsd.com',NULL,NULL,NULL,'2019-08-26 02:56:32',NULL,'2019-08-26 02:56:32',NULL,NULL,0,NULL),('SI_MB7','xxxx','123123','12123v','M',NULL,'2019-07-31',NULL,NULL,'123123','sdfsf@fwef','sdfsf@fwef','sdfsf@fwef',NULL,NULL,NULL,'2019-08-26 15:24:16',NULL,'2019-08-26 15:24:16',NULL,NULL,0,NULL),('SI_MB8','qqqqq','123123','qqqq','M',NULL,'2019-08-21',NULL,NULL,'123123','123@123','12123','123123',NULL,NULL,NULL,'2019-08-26 15:35:35',NULL,'2019-08-26 15:35:35',NULL,NULL,0,NULL),('SI_MB9','bsbbs','123123','23123','M',NULL,'2019-08-14',NULL,NULL,'123123','sdf@swer','123123','123123',NULL,NULL,NULL,'2019-08-26 17:20:18',NULL,'2019-08-26 17:20:18',NULL,NULL,0,NULL);
/*!40000 ALTER TABLE `si_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `si_member_file`
--

DROP TABLE IF EXISTS `si_member_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `si_member_file` (
  `id` varchar(32) NOT NULL,
  `memberId` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `indx` int(3) DEFAULT NULL,
  `name_old` varchar(100) DEFAULT NULL,
  `name_new` varchar(150) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `si_member_file`
--

LOCK TABLES `si_member_file` WRITE;
/*!40000 ALTER TABLE `si_member_file` DISABLE KEYS */;
INSERT INTO `si_member_file` VALUES ('7c3ffb26bd9043db8a314483f35a8a77','SI_MB6','PROFILE',-1,'Screen Shot 2019-06-16 at 22.16.38.png','20190826025632_Screen Shot 2019-06-16 at 22.16.38.png','/si_member/SI_MB6/PROFILE/20190826025632_Screen Shot 2019-06-16 at 22.16.38.png'),('7c98693ffcc44dac941aeca762ca796d','SI_MB8','PROFILE',-1,'Screen Shot 2019-06-16 at 22.20.56.png','20190826153535_Screen Shot 2019-06-16 at 22.20.56.png','/si_member/SI_MB8/PROFILE/20190826153535_Screen Shot 2019-06-16 at 22.20.56.png'),('9bfdccbb73684364afc30d46129de20e','SI_MB12','PROFILE',-1,'Screen Shot 2019-06-24 at 16.25.23.png','20190830002657_Screen Shot 2019-06-24 at 16.25.23.png','/si_member/SI_MB12/PROFILE/20190830002657_Screen Shot 2019-06-24 at 16.25.23.png'),('9e8c817d7b674b48b4922c4aa2b4f70a','-1','profile',-1,'Screen Shot 2019-06-20 at 13.09.48.png','20190826013533_Screen Shot 2019-06-20 at 13.09.48.png','/si_member/SI_MB1/profile/20190826013533_Screen Shot 2019-06-20 at 13.09.48.png'),('c037606410e64acb8f600ee372798c7b','SI_MB5','profile',-1,'Screen Shot 2019-06-18 at 10.39.06.png','20190826021740_Screen Shot 2019-06-18 at 10.39.06.png','/si_member/SI_MB5/profile/20190826021740_Screen Shot 2019-06-18 at 10.39.06.png'),('d0b7384bfc684d1c9a696db7b39628ad','SI_MB7','PROFILE',-1,'Screen Shot 2019-06-16 at 22.16.38.png','20190826152415_Screen Shot 2019-06-16 at 22.16.38.png','/si_member/SI_MB7/PROFILE/20190826152415_Screen Shot 2019-06-16 at 22.16.38.png'),('dfba6f8cfc6c4bf2aca0889f9dd0671b','SI_MB20','PROFILE',-1,'Screen Shot 2019-06-16 at 22.16.38.png','20190829112730_Screen Shot 2019-06-16 at 22.16.38.png','/si_member/SI_MB20/PROFILE/20190829112730_Screen Shot 2019-06-16 at 22.16.38.png'),('e66aa67a941a4ba1b47bce0895c92a2a','SI_MB17','PROFILE',-1,'Screen Shot 2019-06-21 at 13.36.14.png','20190827165048_Screen Shot 2019-06-21 at 13.36.14.png','/si_member/SI_MB17/PROFILE/20190827165048_Screen Shot 2019-06-21 at 13.36.14.png'),('e74bec1f7ef746c58b55474d58b7371e','SI_MB4','PROFILE',-1,'Screen Shot 2019-06-25 at 09.30.42.png','20190830003250_Screen Shot 2019-06-25 at 09.30.42.png','/si_member/SI_MB4/PROFILE/20190830003250_Screen Shot 2019-06-25 at 09.30.42.png'),('f2ead01f1fe1433b839fac4e568b286e','SI_MB19','PROFILE',-1,'Screen Shot 2019-06-18 at 10.39.06.png','20190827180427_Screen Shot 2019-06-18 at 10.39.06.png','/si_member/SI_MB19/PROFILE/20190827180427_Screen Shot 2019-06-18 at 10.39.06.png'),('f652f1a6e8474d4a817893b9ec1ab34a','SI_MB21','PROFILE',-1,'Screen Shot 2019-06-18 at 17.40.07.png','20190830002517_Screen Shot 2019-06-18 at 17.40.07.png','/si_member/SI_MB21/PROFILE/20190830002517_Screen Shot 2019-06-18 at 17.40.07.png'),('fedf0b731c5c40f0a030caa92308a7aa','SI_MB1','profile',-1,'Screen Shot 2019-06-21 at 13.36.48.png','20190830002633_Screen Shot 2019-06-21 at 13.36.48.png','/si_member/SI_MB1/PROFILE/20190830002633_Screen Shot 2019-06-21 at 13.36.48.png');
/*!40000 ALTER TABLE `si_member_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `si_merchant`
--

DROP TABLE IF EXISTS `si_merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `si_merchant` (
  `id` varchar(50) NOT NULL,
  `companyName` varchar(100) DEFAULT NULL,
  `companyRegNo` varchar(50) DEFAULT NULL,
  `totalStaff` int(4) DEFAULT NULL,
  `companyType` varchar(50) DEFAULT NULL,
  `industryType` varchar(50) DEFAULT NULL,
  `companyAddress` varchar(500) DEFAULT NULL,
  `expiredDateSSM` datetime DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `userTitle` varchar(5) DEFAULT NULL,
  `realName` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `companyLogo` varchar(100) DEFAULT NULL,
  `credentialNo` varchar(100) DEFAULT NULL,
  `credentialType` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `officePhone` varchar(50) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  `googlePlus` varchar(100) DEFAULT NULL,
  `companyDiscription` varchar(500) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `lastUpdateTime` datetime DEFAULT NULL,
  `lastLoginPICType` varchar(50) DEFAULT NULL,
  `lastLoginPICId` varchar(50) DEFAULT NULL,
  `loginTimes` int(7) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `si_merchant`
--

LOCK TABLES `si_merchant` WRITE;
/*!40000 ALTER TABLE `si_merchant` DISABLE KEYS */;
INSERT INTO `si_merchant` VALUES ('SI_MC1','xxx','123456',NULL,NULL,'pic00','klcc','2019-07-21 00:00:00','mer1','123123','pic00','123456','0001-01-01','www.com','busi00','','xxx@com','0127123123','luffy','24234234',NULL,'remark','2019-07-21 14:21:52','2019-07-21 14:21:52','2019-07-21 14:21:52',NULL,NULL,1,1),('SI_MC10','xxx','123456',NULL,NULL,'pic00','klcc','2019-07-22 00:00:00','mer18','123123','pic00','123456','0001-01-01','www.com','busi00','','xxx@com','0127123123','luffy','24234234',NULL,'remark','2019-07-22 14:21:53','2019-07-21 14:21:53','2019-07-21 14:21:53',NULL,NULL,1,1),('SI_MC11','comp123','123123',123,'AL','AL',NULL,'2019-08-06 00:00:00','123123','123123','AL','123123',NULL,NULL,'123123',NULL,'123123@com','(60)123123','(60)123123','123123@com',NULL,NULL,'2019-08-10 01:10:48',NULL,'2019-08-10 01:10:48',NULL,NULL,NULL,0),('SI_MC12','comp123','123123',123,'AL','AL',NULL,'2019-08-06 00:00:00','abcabc','123123','AL','123123',NULL,NULL,'123123',NULL,'123123@com','(60)123123','(60)123123','123123@com',NULL,NULL,'2019-08-10 01:16:27',NULL,'2019-08-10 01:16:27',NULL,NULL,NULL,0),('SI_MC13','compxxx','123123',100,'AL','AL',NULL,'2019-08-06 00:00:00','xxxxxx','123123','AL','123123',NULL,NULL,'123123',NULL,'123123@com','(60)123123','(60)123123','123123@com',NULL,NULL,'2019-08-10 01:18:57',NULL,'2019-08-10 01:18:57',NULL,NULL,NULL,0),('SI_MC14','coc','132123',12312,'BHD','fb','12kkk','2019-09-17 00:00:00','mer990','4297F44B13955235245B2497399D7A93','Mr','123123',NULL,NULL,'123123',NULL,'23123@1231','23123','1231231','123123',NULL,'edeee','2019-09-05 11:55:46',NULL,'2019-09-05 11:55:46',NULL,NULL,NULL,0),('SI_MC15','coc','132123',12312,NULL,NULL,'12kkk','2019-09-17 00:00:00','mer991','4297F44B13955235245B2497399D7A93','Mr','123123',NULL,NULL,'123123',NULL,'23123@1231','23123','1231231','123123',NULL,'edeee','2019-09-05 12:00:04',NULL,'2019-09-05 12:00:04',NULL,NULL,NULL,0),('SI_MC16','coc','132123',12312,NULL,NULL,'12kkk','2019-09-17 00:00:00','mer992','4297F44B13955235245B2497399D7A93','Mr','123123',NULL,NULL,'123123',NULL,'23123@1231','23123','1231231','123123',NULL,'edeee','2019-09-05 17:46:25',NULL,'2019-09-05 17:46:25',NULL,NULL,NULL,0),('SI_MC17','coc','132123',12312,NULL,NULL,'12kkk','2019-09-17 00:00:00','mer993','4297F44B13955235245B2497399D7A93','Mr','123123',NULL,NULL,'123123',NULL,'23123@1231','23123','1231231','123123',NULL,'edeee','2019-09-05 17:50:03',NULL,'2019-09-05 17:50:03',NULL,NULL,NULL,0),('SI_MC18','coc','132123',12312,NULL,NULL,'12kkk','2019-09-17 00:00:00','mer994','4297F44B13955235245B2497399D7A93','Mdm','123123',NULL,NULL,'123123',NULL,'23123@1231','23123','1231231','123123',NULL,'edeee','2019-09-05 17:50:44',NULL,'2019-09-05 17:50:44',NULL,NULL,NULL,0),('SI_MC19','coc','132123',12312,NULL,NULL,'12kkk','2019-09-17 00:00:00','mer995','4297F44B13955235245B2497399D7A93','Ms','123123',NULL,NULL,'123123',NULL,'23123@1231','23123','1231231','123123',NULL,'edeee','2019-09-05 17:51:18',NULL,'2019-09-05 17:51:18',NULL,NULL,NULL,0),('SI_MC2','xxx','123456',NULL,NULL,'pic00','klcc','2019-07-23 00:00:00','mer10','123123','pic00','123456','0001-01-01','www.com','busi00','','xxx@com','0127123123','luffy','24234234',NULL,'remark','2019-07-23 14:21:52','2019-07-21 14:21:52','2019-07-21 14:21:52',NULL,NULL,1,1),('SI_MC20','coc','132123',12312,NULL,NULL,'12kkk','2019-09-17 00:00:00','mer996','4297F44B13955235245B2497399D7A93','Ms','123123',NULL,NULL,'123123',NULL,'23123@1231','23123','1231231','123123',NULL,'edeee','2019-09-05 17:55:45',NULL,'2019-09-05 17:55:45',NULL,NULL,NULL,0),('SI_MC21','csdf','123123',123,'BHD','retail','123123','2019-09-24 00:00:00','uu111','4297F44B13955235245B2497399D7A93','Mr','123123',NULL,NULL,'1231231',NULL,'123123@123','1231231','23123','23123',NULL,'123','2019-09-05 17:59:03',NULL,'2019-09-05 17:59:03',NULL,NULL,NULL,0),('SI_MC22','csdf','123123',123,NULL,NULL,'123123','2019-09-24 00:00:00','uu112','4297F44B13955235245B2497399D7A93','Mr','123123',NULL,NULL,'1231231',NULL,'123123@123','1231231','23123','23123',NULL,'123','2019-09-05 18:06:54',NULL,'2019-09-05 18:06:54',NULL,NULL,NULL,0),('SI_MC23','1312dsd','dad',123,'BHD','qwe','123123','2019-09-20 00:00:00','ii111','4297F44B13955235245B2497399D7A93','Mr','123123',NULL,NULL,'123123',NULL,'','','123123','',NULL,'','2019-09-05 18:08:02',NULL,'2019-09-05 18:08:02',NULL,NULL,NULL,0),('SI_MC24','1312dsd','dad',123,'uiui','publicSector','123123','2019-09-20 00:00:00','ii112','4297F44B13955235245B2497399D7A93','Mr','123123',NULL,NULL,'123123',NULL,'sdfs@213','123123','123123','123123',NULL,'123123','2019-09-05 18:13:42',NULL,'2019-09-05 18:14:10',NULL,NULL,NULL,0),('SI_MC25','1312dsd','dad',123,'SP','123123','123123','2019-09-20 00:00:00','ii113','4297F44B13955235245B2497399D7A93','Mr','123123',NULL,NULL,'123123',NULL,'sdfs@213','123123','123123','123123',NULL,'123123','2019-09-05 18:16:45',NULL,'2019-09-05 18:16:45',NULL,NULL,NULL,0),('SI_MC26','1312dsd','dad',123,'PNS','fb','123123','2019-09-20 00:00:00','ii114','4297F44B13955235245B2497399D7A93','Mr','123123',NULL,'/exl_agent/SI_MC26/PROFILE/20190906001726_Screen Shot 2019-06-21 at 13.38.29.png','123123',NULL,'sdfs@213','123123','123123','123123',NULL,'123123','2019-09-05 18:19:37',NULL,'2019-09-06 00:17:27',NULL,NULL,NULL,0),('SI_MC27','dskfs','12313',123,'123','fffbbb','123','2019-09-12 00:00:00','o100','B3DDBC502E307665F346CBD6E52CC10D','Mr','',NULL,'/exl_agent/SI_MC27/PROFILE/20190906002302_Screen Shot 2019-06-18 at 10.39.06.png','',NULL,'','','','',NULL,'','2019-09-05 18:22:47',NULL,'2019-09-06 00:25:42',NULL,NULL,NULL,0),('SI_MC28','hh001','123123',99,NULL,NULL,'123123kl','2019-09-26 00:00:00','hui001','4297F44B13955235245B2497399D7A93','Mdm','123123',NULL,'/exl_agent/SI_MC28/PROFILE/20190906003607_Screen Shot 2019-06-16 at 22.54.32.png','23123',NULL,'12312@123','12313','123123','123123',NULL,'12312','2019-09-06 00:36:07',NULL,'2019-09-06 00:36:07',NULL,NULL,NULL,0),('SI_MC29','132oo1','123123',111,'','','123123','2019-09-17 00:00:00','sdfsdf','4297F44B13955235245B2497399D7A93','Mrs','123123',NULL,'/exl_agent/SI_MC29/PROFILE/20190906004011_Screen Shot 2019-06-16 at 22.40.08.png','123123',NULL,'123123@1231231','231231','12312312','2311',NULL,'23123','2019-09-06 00:40:12',NULL,'2019-09-06 00:40:12',NULL,NULL,NULL,0),('SI_MC3','xxx','123456',NULL,NULL,'pic00','klcc','2019-07-24 00:00:00','mer11','123123','pic00','123456','0001-01-01','www.com','busi00','','xxx@com','0127123123','luffy','24234234',NULL,'remark','2019-07-24 14:21:52','2019-07-21 14:21:52','2019-07-21 14:21:52',NULL,NULL,1,1),('SI_MC30','jlk','123123',99,'SB','service','123123','2019-09-02 00:00:00','ijio99','4297F44B13955235245B2497399D7A93','Mrs','',NULL,'/exl_agent/SI_MC30/PROFILE/20190906004206_Screen Shot 2019-06-16 at 22.20.56.png','',NULL,'','','','',NULL,'','2019-09-06 00:42:06',NULL,'2019-09-06 00:42:06',NULL,NULL,NULL,0),('SI_MC31','sdfsdf','123123',78,'SB','service','12312jk','2019-09-10 00:00:00','kj88','B3DDBC502E307665F346CBD6E52CC10D','Mr','123123',NULL,'/exl_agent/SI_MC31/PROFILE/20190906011603_Screen Shot 2019-06-16 at 22.20.56.png','123123',NULL,'12312@12311','123123','123123','2312',NULL,'12312','2019-09-06 01:16:03',NULL,'2019-09-06 01:16:03',NULL,NULL,NULL,0),('SI_MC32','mmlm','123123',98,'SB','service','12323kjl','2019-09-17 00:00:00','qw990','4297F44B13955235245B2497399D7A93','Mdm','123123',NULL,'/si_merchant/SI_MC32/PROFILE/20190906022230_Screen Shot 2019-06-16 at 22.16.38.png','123123',NULL,'12313@123','123123','123123','123123',NULL,'123123','2019-09-06 02:02:51',NULL,'2019-09-06 02:22:30',NULL,'051e230609c44174aa70cccb4ba4cc96',NULL,0),('SI_MC4','xxx','123456',NULL,NULL,'pic00','klcc','2019-07-25 00:00:00','mer12','123123','pic00','123456','0001-01-01','www.com','busi00','','xxx@com','0127123123','luffy','24234234',NULL,'remark','2019-07-25 14:21:52','2019-07-21 14:21:52','2019-07-21 14:21:52',NULL,NULL,1,1),('SI_MC5','xxx','123456',NULL,NULL,'pic00','klcc','2019-07-26 00:00:00','mer13','123123','pic00','123456','0001-01-01','www.com','busi00','','xxx@com','0127123123','luffy','24234234',NULL,'remark','2019-07-26 14:21:52','2019-07-21 14:21:52','2019-07-21 14:21:52',NULL,NULL,1,1),('SI_MC6','xxx','123456',NULL,NULL,'pic00','klcc','2019-07-27 00:00:00','mer14','123123','pic00','123456','0001-01-01','www.com','busi00','','xxx@com','0127123123','luffy','24234234',NULL,'remark','2019-07-27 14:21:52','2019-07-21 14:21:52','2019-07-21 14:21:52',NULL,NULL,1,1),('SI_MC7','xxx','123456',NULL,NULL,'pic00','klcc','2019-07-28 00:00:00','mer15','123123','pic00','123456','0001-01-01','www.com','busi00','','xxx@com','0127123123','luffy','24234234',NULL,'remark','2019-07-28 14:21:53','2019-07-21 14:21:53','2019-07-21 14:21:53',NULL,NULL,1,1),('SI_MC8','xxx','123456',NULL,NULL,'pic00','klcc','2019-07-29 00:00:00','mer16','123123','pic00','123456','0001-01-01','www.com','busi00','','xxx@com','0127123123','luffy','24234234',NULL,'remark','2019-07-29 14:21:53','2019-07-21 14:21:53','2019-07-21 14:21:53',NULL,NULL,1,1),('SI_MC9','xxx','123456',NULL,NULL,'pic00','klcc','2019-07-30 00:00:00','mer17','123123','pic00','123456','0001-01-01','www.com','busi00','','xxx@com','0127123123','luffy','24234234',NULL,'remark','2019-07-30 14:21:53','2019-07-21 14:21:53','2019-07-21 14:21:53',NULL,NULL,1,1);
/*!40000 ALTER TABLE `si_merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `si_merchant_doc`
--

DROP TABLE IF EXISTS `si_merchant_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `si_merchant_doc` (
  `id` varchar(32) NOT NULL,
  `merchantId` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `indx` int(3) DEFAULT NULL,
  `name_old` varchar(100) DEFAULT NULL,
  `name_new` varchar(150) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `si_merchant_doc`
--

LOCK TABLES `si_merchant_doc` WRITE;
/*!40000 ALTER TABLE `si_merchant_doc` DISABLE KEYS */;
INSERT INTO `si_merchant_doc` VALUES ('1730597d01144bf0bf86dda6ec5f8af6','SI_MC26','PROFILE',-1,'Screen Shot 2019-06-21 at 13.38.29.png','20190906001726_Screen Shot 2019-06-21 at 13.38.29.png','/exl_agent/SI_MC26/PROFILE/20190906001726_Screen Shot 2019-06-21 at 13.38.29.png'),('76c8da713aea45e2ba693166e8da3023','SI_MC27','PROFILE',-1,'Screen Shot 2019-06-18 at 10.39.06.png','20190906002302_Screen Shot 2019-06-18 at 10.39.06.png','/exl_agent/SI_MC27/PROFILE/20190906002302_Screen Shot 2019-06-18 at 10.39.06.png'),('8e0aa9afa7db4698ba8328cd8fa16ba9','SI_MC31','PROFILE',-1,'Screen Shot 2019-06-16 at 22.20.56.png','20190906011603_Screen Shot 2019-06-16 at 22.20.56.png','/exl_agent/SI_MC31/PROFILE/20190906011603_Screen Shot 2019-06-16 at 22.20.56.png'),('8e2c684567084864b95eee579267f1c3','SI_MC28','PROFILE',-1,'Screen Shot 2019-06-16 at 22.54.32.png','20190906003607_Screen Shot 2019-06-16 at 22.54.32.png','/exl_agent/SI_MC28/PROFILE/20190906003607_Screen Shot 2019-06-16 at 22.54.32.png'),('91619c2d41a64787b5f5ef7f0123231f','SI_MC30','PROFILE',-1,'Screen Shot 2019-06-16 at 22.20.56.png','20190906004206_Screen Shot 2019-06-16 at 22.20.56.png','/exl_agent/SI_MC30/PROFILE/20190906004206_Screen Shot 2019-06-16 at 22.20.56.png'),('9fcfaad2bd014621add85ad19909f378','SI_MC32','PROFILE',-1,'Screen Shot 2019-06-16 at 22.16.38.png','20190906022230_Screen Shot 2019-06-16 at 22.16.38.png','/si_merchant/SI_MC32/PROFILE/20190906022230_Screen Shot 2019-06-16 at 22.16.38.png'),('c327f86ed79d496780da44cd589832d2','SI_MC29','PROFILE',-1,'Screen Shot 2019-06-16 at 22.40.08.png','20190906004011_Screen Shot 2019-06-16 at 22.40.08.png','/exl_agent/SI_MC29/PROFILE/20190906004011_Screen Shot 2019-06-16 at 22.40.08.png');
/*!40000 ALTER TABLE `si_merchant_doc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `si_merchant_pic`
--

DROP TABLE IF EXISTS `si_merchant_pic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `si_merchant_pic` (
  `id` varchar(32) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `merchantId` varchar(50) DEFAULT NULL,
  `title` varchar(5) DEFAULT NULL,
  `realName` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `officePhone` varchar(50) DEFAULT NULL,
  `discription` varchar(500) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `lastUpdateTime` datetime DEFAULT NULL,
  `loginTimes` int(7) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `si_merchant_pic`
--

LOCK TABLES `si_merchant_pic` WRITE;
/*!40000 ALTER TABLE `si_merchant_pic` DISABLE KEYS */;
INSERT INTO `si_merchant_pic` VALUES ('051e230609c44174aa70cccb4ba4cc96','qw990','123123','SI_MC32','Ms','1231231','12313@12323','123123123','881231299','init123','2019-09-06 02:02:51',NULL,NULL,NULL,0),('2c397a0627cd47348de3b19c4959e0d7','ijio99','4297F44B13955235245B2497399D7A93','SI_MC30','Mrs','','','','','init','2019-09-06 00:42:06',NULL,NULL,NULL,0),('8b5ef8b52096446c93870b22ce1cf68e','kj88','B3DDBC502E307665F346CBD6E52CC10D','SI_MC31','Mr','123123','12312@12311','123123','123123','init','2019-09-06 01:16:03',NULL,NULL,NULL,0),('8d11d60247c546609adefd0a00a9caa5','sdfsdf','4297F44B13955235245B2497399D7A93','SI_MC29','Mrs','123123','123123@1231231','231231','12312312','init','2019-09-06 00:40:12',NULL,NULL,NULL,0),('dd3f997b13d441fd8de83ba4b9db15af','hui001','4297F44B13955235245B2497399D7A93','SI_MC28','Mdm','123123','12312@123','12313','123123','init','2019-09-06 00:36:07',NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `si_merchant_pic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-16  2:03:09
