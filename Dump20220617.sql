-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: shop_online_db
-- ------------------------------------------------------
-- Server version	5.7.33-log

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `line` varchar(255) DEFAULT NULL,
  `cmid` bigint(20) NOT NULL,
  `manuid` bigint(20) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `category_code` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKokbi8lshw8e2mji2whbabh2o8` (`manuid`),
  KEY `FKqlccyejh8tp4nx5a1aqg621kd` (`cmid`),
  CONSTRAINT `FKokbi8lshw8e2mji2whbabh2o8` FOREIGN KEY (`manuid`) REFERENCES `manu` (`id`),
  CONSTRAINT `FKqlccyejh8tp4nx5a1aqg621kd` FOREIGN KEY (`cmid`) REFERENCES `productline` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Iphone',1,1,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340490193124614_iPhone-Apple@2x.jpg','IP','AItem-MjAyMjA2MTZfMjIzMTI5'),(2,'Samsung',1,2,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340490904217021_Samsung@2x.jpg','SS','AItem-MjAyMjA2MTZfMjdsada'),(3,'Xiaomi',1,4,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/6/2/637582325361253577_Xiaomi@2x.jpg','XM','AItem-MjAyMjA2MTZfMjIzMTI5as'),(4,'Oppo',1,3,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340491304997311_Oppo@2x.jpg','OPPO','AItem-MjAyMjA2MTZfMjIzMTI52'),(5,'Nokia',1,9,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340493755614653_Nokia@2x.jpg','N','AItem-MjAyMjA2MTZfMjIzMTI53'),(6,'Vivo',1,3,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340491898745716_Vivo@2x.jpg','VV','AItem-MjAyMjA2MTZfMjIzMTI54'),(7,'Ipad',2,1,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340494667486283_iPad-Apple@2x.jpg','iP','AItem-MjAyMjA2MTZfMjIzMTI55'),(8,'Samsung-tab',2,2,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340490904217021_Samsung@2x.jpg','SS-t','AItem-MjAyMjA2MTZfMjIzMTI56'),(9,'Huawei-tab',2,3,'https://cdn.tgdd.vn/Brand/1/Huawei522-b_4.jpg','HW-t','AItem-MjAyMjA2MTZfMjIzMTI57'),(10,'Macbook',3,1,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340494668267616_Macbook-Apple@2x.jpg','MB','AItem-MjAyMjA2MTZfMjIzMTI58'),(11,'Asus',3,5,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340494666861275_Asus.jpg','ASUS','AItem-MjAyMjA2MTZfMjIzMTI59'),(12,'Dell',3,6,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340494666861275_Dell@2x.jpg','DELL','AItem-MjAyMjA2MTZfMjIzMTI510'),(13,'MSI',3,8,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/26/637340493755614653_MSI@2x.jpg','MSI','AItem-MjAyMjA2MTZfMjIzMTI11'),(14,'HP',3,7,'https://images.fpt.shop/unsafe/fit-in/108x40/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/7/15/637619564183327279_HP@2x.png','HP','AItem-MjAyMjA2MTZfMjIzMTI5213'),(19,'Apple Watch',5,1,NULL,NULL,NULL),(20,'Samsung',5,2,NULL,NULL,NULL),(21,'Xiaomi',5,4,NULL,NULL,NULL),(22,'Oppo',5,3,NULL,NULL,NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laptop`
--

DROP TABLE IF EXISTS `laptop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laptop` (
  `card` varchar(255) DEFAULT NULL,
  `cpu` varchar(255) DEFAULT NULL,
  `display` varchar(255) DEFAULT NULL,
  `memory` varchar(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `weight` float NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK8pi53vvmhc93gx48fuwwd720v` FOREIGN KEY (`id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laptop`
--

LOCK TABLES `laptop` WRITE;
/*!40000 ALTER TABLE `laptop` DISABLE KEYS */;
/*!40000 ALTER TABLE `laptop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manu`
--

DROP TABLE IF EXISTS `manu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6mcb7jjtw3dbm95xijs55b2tn` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manu`
--

LOCK TABLES `manu` WRITE;
/*!40000 ALTER TABLE `manu` DISABLE KEYS */;
INSERT INTO `manu` VALUES (1,'AItem-MjAyMjA2MTZfMjIwODA0','Apple'),(2,'AItem-MjAyMjA2MTZfMjIwODEx','Samsung'),(3,'AItem-MjAyMjA2MTZfMjIwODE2','Oppo'),(4,'AItem-MjAyMjA2MTZfMjIwODI4','Xiaomi'),(5,'AItem-MjAyMjA2MTZfMjIwODMy','Asus'),(6,'AItem-MjAyMjA2MTZfMjIwOTE3','DELL'),(7,'AItem-MjAyMjA2MTZfMjIwOTIx','HP'),(8,'AItem-MjAyMjA2MTZfMjIwOTI0','MSI'),(9,'AItem-MjAyMjA2MTZfMjIwOTMw','Nokia');
/*!40000 ALTER TABLE `manu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderproduct`
--

DROP TABLE IF EXISTS `orderproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderproduct` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `cid` bigint(20) NOT NULL,
  `oid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpjbqawi313hhm4itn7vjtt7g2` (`cid`),
  KEY `FK2wp59wbvbi2oel2obn6roleqw` (`oid`),
  CONSTRAINT `FK2wp59wbvbi2oel2obn6roleqw` FOREIGN KEY (`oid`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKpjbqawi313hhm4itn7vjtt7g2` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderproduct`
--

LOCK TABLES `orderproduct` WRITE;
/*!40000 ALTER TABLE `orderproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `status` bit(1) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonetab`
--

DROP TABLE IF EXISTS `phonetab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phonetab` (
  `back_camera` varchar(255) DEFAULT NULL,
  `chip` varchar(255) DEFAULT NULL,
  `display` varchar(255) DEFAULT NULL,
  `front_camera` varchar(255) DEFAULT NULL,
  `memory` varchar(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKkofrw0p4tk44x6de1h8cnihd4` FOREIGN KEY (`id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonetab`
--

LOCK TABLES `phonetab` WRITE;
/*!40000 ALTER TABLE `phonetab` DISABLE KEYS */;
/*!40000 ALTER TABLE `phonetab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `quantity_stock` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcxmxpfdetdqdqm69d4cgbhotv` (`cid`),
  CONSTRAINT `FKcxmxpfdetdqdqm69d4cgbhotv` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,11,'ASUS_HP163T','Laptop Asus ZenBook Flip UX363EA',12345,'https://cdn.tgdd.vn/Products/Images/44/249286/asus-zenbook-flip-ux363ea-i7-hp163t-1-org.jpg',0),(2,11,'ASUS_KI439T','Laptop Asus Zenbook UX425EA KI439T',29699,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/19/637413930235653362_HASP-Asus-Vivobook-UX425(19).jpg',0),(3,12,'DELL_XPS139310','Laptop Dell XPS 13 9310',41999,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/3/23/637521096034930087_dell-xps-13-9310-2in1-bac-2-evo-i5.jpg',0),(4,14,'HP_230P8PA','Laptop HP EliteBook X360 1040 G7',48490,'https://cdn.tgdd.vn/Products/Images/44/232152/hp-elitebook-x360-1040-g7-i7-230p8pa-1-org.jpg',0),(5,14,'HP_S132101TU','Laptop HP Spectre x360 13-aw2101TU',49999,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/4/22/637547115695019344_hp-spectre-x360-xanh-3.jpg',0),(6,14,'HP_ZBF14G8','Laptop HP ZBook Firefly 14 G8',33899,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/9/4/637663502047201460_hp-zbook-firefly-14-g8-xam-2.jpg',0),(7,9,'HW-t_MP11','Huawei MatePad 11 da chinh sua',13490,'https://www.electrorates.com/blogimg/Huawei_Matepad_11_2021.png',0),(8,1,'IP_11128','iPhone 11 128GB',19990,'https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-xanh-la-1-org.jpg',0),(9,1,'IP_1164','iPhone 11 64GB',17490,'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-11-do-1-1-1-org.jpg',0),(10,1,'IP_11PM128','Iphone 11 Pro Max 128GB',28999,'https://cdn.tgdd.vn/Products/Images/42/230521/iphone-13-pro-silver-2.jpg',0),(11,1,'IP_11PM256','Iphone 11 Pro Max 256GB',30999,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/9/637273078874356795_iphone%2011%20pro%20max%20(1).jpg',0),(12,1,'IP_11PM64','Iphone 11 Pro Max 64GB',26999,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/9/637273078874356795_iphone%2011%20pro%20max%20(1).jpg',0),(13,1,'IP_12128','Iphone 12 128GB',22499,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740261112650_iphone-12-12-mini-1.jpg',0),(14,1,'IP_12256','Iphone 12 256GB',24499,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740261112650_iphone-12-12-mini-1.jpg',0),(15,1,'IP_1264','Iphone 12 64GB',20499,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740261112650_iphone-12-12-mini-1.jpg',0),(16,1,'IP_12P128','Iphone 12 Pro 128GB',27999,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740532520004_iphone-12-pro-12-pro-max-2.jpg',0),(17,1,'IP_12P256','Iphone 12 Pro 256GB',28999,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740532520004_iphone-12-pro-12-pro-max-2.jpg',0),(18,1,'IP_12P512','Iphone 12 Pro 512GB',30999,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740532520004_iphone-12-pro-12-pro-max-2.jpg',0),(19,1,'IP_12PM128','Iphone 12 Pro Max 128GB',30999,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740535019513_iphone-12-pro-12-pro-max-4.jpg',0),(20,1,'IP_12PM256','Iphone 12 Pro Max 256GB',34999,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740535019513_iphone-12-pro-12-pro-max-4.jpg',0),(21,1,'IP_12PM512','Iphone 12 Pro Max 512GB',39999,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740535019513_iphone-12-pro-12-pro-max-4.jpg',0),(22,1,'IP_13P128','iPhone 13 Pro 128GB',29990,'https://cdn.tgdd.vn/Products/Images/42/230521/iphone-13-pro-1-1.jpg',0),(23,1,'IP_13P256','iPhone 13 Pro 256GB',33990,'https://cdn.tgdd.vn/Products/Images/42/230521/iphone-13-pro-silver-2.jpg',0),(24,1,'IP_632','Iphone 6 32GB',2999,'https://cdn.tgdd.vn/Products/Images/42/92962/iphone-6-32gb-gold-up-1-org.jpg',0),(25,1,'IP_6P16','Iphone 6 Plus 16GB',3999,'https://cdn.tgdd.vn/Products/Images/42/69783/iphone-6-plus-16gb-xam1-1-3-org.jpg',0),(26,1,'IP_6S16','Iphone 6s 16GB',4000,'https://cdn.tgdd.vn/Products/Images/42/60831/iphone-6-xam-org-1.png',0),(27,1,'IP_6SP32','Iphone 6S Plus 32GB',4999,'https://cdn.tgdd.vn/Products/Images/42/87846/iphone-6s-plus-32gb-vangdong1-1-3-org.jpg',0),(28,1,'IP_732','Iphone 7 32GB',5999,'https://cdn.tgdd.vn/Products/Images/42/74110/iphone-7-den-1-12-org.jpg',0),(29,1,'IP_7P128','Iphone 7 Plus 128GB',7999,'https://cdn.tgdd.vn/Products/Images/42/78124/iphone-7-plus-den-1-5-org.jpg',0),(30,1,'IP_7P32','Iphone 7 Plus 32GB',6999,'https://cdn.tgdd.vn/Products/Images/42/78124/iphone-7-plus-den-1-5-org.jpg',0),(31,1,'IP_832','Iphone 8 32GB',7999,'https://cdn.tgdd.vn/Products/Images/42/114113/iphone-8-64gb-den-1-org.jpg',0),(32,1,'IP_8P256','Iphone 8 Plus 256GB',9999,'https://cdn.tgdd.vn/Products/Images/42/114110/iphone-8-plus-do-1-org.jpg',0),(33,1,'IP_8P64','Iphone 8 Plus 64GB',8999,'https://cdn.tgdd.vn/Products/Images/42/114110/iphone-8-plus-64gb-vangdong-1-3-org.jpg',0),(34,1,'IP_SE64','iPhone SE 64GB',11990,'https://cdn1.hoanghamobile.com/tin-tuc/wp-content/uploads/2020/04/Untitled-1.png',0),(35,1,'IP_X128','Iphone X 128GB',0,'https://cdn.tgdd.vn/Products/Images/42/114115/iphone-x-64gb-bac-1-1-org.jpg',0),(36,1,'IP_X64','Iphone X 64GB',10499,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/11/637274707339798536_2%20iPhoneXr-Red-PB-PF-US-EN-SCREEN.jpg',0),(37,1,'IP_XR128','Iphone XR 128GB',14499,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/11/637274707339798536_2%20iPhoneXr-Red-PB-PF-US-EN-SCREEN.jpg',0),(38,1,'IP_XR64','Iphone XR 64GB',12499,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/11/637274707339798536_2%20iPhoneXr-Red-PB-PF-US-EN-SCREEN.jpg',0),(39,1,'IP_XS128','Iphone XS 128GB',0,'https://cdn.tgdd.vn/Products/Images/42/190323/iphone-xs-vang-1-1-org.jpg',0),(40,1,'IP_XS64','Iphone XS 64GB',12499,'https://cdn.tgdd.vn/Products/Images/42/190323/iphone-xs-vang-1-1-org.jpg',0),(41,1,'IP_XSM128','Iphone XS Max 128GB',0,'https://cdn.tgdd.vn/Products/Images/42/190321/iphone-xs-max-1-org.jpg',0),(42,1,'IP_XSM64','Iphone XS Max 64GB',15999,'https://cdn.tgdd.vn/Products/Images/42/190321/iphone-xs-max-1-org.jpg',0),(43,10,'MB_P152020TB','MacBook Pro 13\" 2020 Touch Bar',54999,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/23/637285184781674411_mbp13touch-space-gallery2-202005_GEO_US.jpg',0),(44,10,'MB_P162019TB','MacBook Pro 16\" 2019 Touch Bar',69990,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/10/637273992022046588_MacBook_Pro_16-in_Touch_Bar_Pure_Top_Open_Silver_SCREEN.jpg',0),(45,10,'MB_Z11C000CJ','Laptop Apple MacBook Pro M1',52990,'https://cdn.tgdd.vn/Products/Images/44/236131/laptopapplemacbookprom1-1-org.jpg',0),(46,10,'MB_Z12A00050','Laptop Apple MacBook Air M1',39490,'https://cdn.tgdd.vn/Products/Images/44/243952/apple-macbook-air-m1-2020-z12a00050-1-org.jpg',0),(47,13,'MSI_B15028VN','Laptop MSI Bravo 15 B5DD 028VN',24999,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/6/22/637599748140056944_msi-bravo-15-b5dx-den-1.jpg',0),(48,13,'MSI_GE66R11UH269VN','Laptop MSI Gaming GE66 Raider 11UH',77990,'https://cdn.tgdd.vn/Products/Images/44/249151/msi-gaming-ge66-raider-11uh-i7-259vn-1-org.jpg',0),(49,13,'MSI_GF631218VN','Laptop MSI Gaming GF63 10SCXR-1218VN',20699,'https://cdn.tgdd.vn/Products/Images/44/242200/msi-gf65-10ue-i7-228vn-2-org.jpg',0),(50,13,'MSI_GP76435VN','Laptop MSI Gaming GP76 11UG',52990,'https://cdn.tgdd.vn/Products/Images/44/242204/msi-gp76-11ug-i7-435vn-1-org.jpg',0),(51,13,'MSI_L10SDKGL65242VN','Laptop MSI Gaming Leopard 10SDK GL65',32490,'https://cdn.tgdd.vn/Products/Images/44/225857/msi-gaming-leopard-10sdr-gl65-i7-242vn-1-org.jpg',0),(52,13,'MSI_M15A5M','Laptop MSI Modern 15 A5M',19999,'https://fptshop.com.vn/Uploads/images/2015/Tin-Tuc/QuanLNH2/msi-modern-15-xam-carbon-1.jpg',0),(53,13,'MSI_SE13F211VN','Laptop MSI Summit E13 Flip',39990,'https://cdn.tgdd.vn/Products/Images/44/246951/msi-summit-e13-flip-i7-211vn-1-org.jpg',0),(54,13,'MSI_TN','laptop thu nghiem',111089,'https://nguyencongpc.vn/photos/17/Laptop-MSI-GE76-Raider-10UH-5-900x.jpg',0),(55,5,'N_2.4','Nokia 2.4',2290,'https://cdn.tgdd.vn/Products/Images/42/226218/nokia-24-xam-1-2-org.jpg',0),(56,5,'N_230','Nokia 230',1250,'https://cdn.tgdd.vn/Products/Images/42/101850/nokia-230-khong-the-xam-dam-1-org.jpg',0),(57,5,'N_3.4','Nokia 3.4',2790,'https://cdn.tgdd.vn/Products/Images/42/227626/nokia-34-1-1-org.jpg',0),(58,5,'N_C20','Nokia C20',1990,'https://cdn.tgdd.vn/Products/Images/42/236437/nokia-c20-vang-1-1-org.jpg',0),(59,4,'OPPO_FX3P5G','OPPO Find X3 Pro 5G',26990,'https://cdn.tgdd.vn/Products/Images/42/232190/oppo-find-x3-pro-den-1-org.jpg',0),(60,4,'OPPO_R5G','OPPO Reno6 5G',11390,'https://cdn.tgdd.vn/Products/Images/42/233460/oppo-reno5-5g-den--org.jpg',0),(61,4,'OPPO_RZ5G','OPPO Reno6 Z 5G',9490,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/7/8/637613323642518520_oppo-reno6z-xanh-1.jpg',0),(62,8,'SS-t_S7FE','Samsung Galaxy Tab S7 FE ',11590,'https://cdn.tgdd.vn/Products/Images/522/240254/samsung-galaxy-tab-s7-fe-green-1-org.jpg',0),(63,8,'SS-t_TS6L','Samsung Galaxy Tab S6 Lite ',9990,'https://cdn.tgdd.vn/Products/Images/522/219912/samsung-galaxy-tab-s6-lite-xanh-1-org.jpg',0),(64,8,'SS-t_TS7','Samsung Galaxy Tab S7 ',19990,'https://cdn.tgdd.vn/Products/Images/522/225031/samsung-galaxy-tab-s7-vang-dong-1-org.jpg',0),(65,2,'SS_A72','Samsung Galaxy A72 ',10490,'https://cdn.tgdd.vn/Products/Images/42/226101/samsung-galaxy-a72-black-1020x680-org.jpg',0),(66,2,'SS_N20','Samsung Galaxy Note 20',14990,'https://cdn.tgdd.vn/Products/Images/42/218355/samsung-galaxy-note-20-xanh-la-1-org.jpg',0),(67,2,'SS_N20U','Samsung Galaxy Note 20 Ultra',19990,'https://cdn.tgdd.vn/Products/Images/42/220522/samsung-galaxy-note-20-ultra-vang-dong-1-org.jpg',0),(68,2,'SS_S20P','Samsung Galaxy S20+',16990,'https://cdn.tgdd.vn/Products/Images/42/217936/samsung-galaxy-s20-plus-xanh-duong-1-org.jpg',0),(69,2,'SS_S20U','Samsung Galaxy S20 Ultra',29990,'https://cdn.tgdd.vn/Products/Images/42/217937/samsung-galaxy-s20-ultra-xam-1-org.jpg',0),(70,2,'SS_S21P','Samsung Galaxy S21+',23990,'https://cdn.tgdd.vn/Products/Images/42/236128/samsung-galaxy-s21-plus-256gb-bac-1-org.jpg',0),(71,2,'SS_S21U','Samsung Galaxy S21 Ultra',25990,'https://cdn.tgdd.vn/Products/Images/42/226316/samsung-galaxy-s21-ultra-bac-1-org.jpg',0),(72,2,'SS_ZF25G','Samsung Galaxy Z Fold2 5G   ',44000,'https://cdn.tgdd.vn/Products/Images/42/226099/samsung-galaxy-z-fold-2-den-1-org.jpg',0),(73,6,'VV_V215G','Vivo V21 5G',9490,'https://cdn.tgdd.vn/Products/Images/42/238047/vivo-v21-5g-xanh-den-1-org.jpg',0),(74,6,'VV_Y20SE','Vivo Y20 SE',6490,'https://cdn.tgdd.vn/Products/Images/42/228141/vivo-v20-se-den-1-org.jpg',0),(75,6,'VV_Y725G','Vivo Y72 5G',7590,'https://cdn.tgdd.vn/Products/Images/42/236431/vivo-y72-5g-xanh-hong-1-1-org.jpg',0),(76,3,'XM_10TP5G','Xiaomi Mi 10T Pro 5G',12490,'https://cdn.tgdd.vn/Products/Images/42/228136/xiaomi-mi-10t-pro-1-org.jpg',0),(77,3,'XM_115G','Xiaomi Mi 11 5G',16990,'https://cdn.tgdd.vn/Products/Images/42/226264/xiaomi-mi-11-xanhduong-1-org.jpg',0),(78,3,'XM_N10P','Xiaomi Redmi Note 10 Pro',7490,'https://cdn.tgdd.vn/Products/Images/42/229228/xiaomi-redmi-note-10-pro-xam-1-org.jpg',0),(79,3,'XM_N9','Xiaomi Redmi Note 9',4190,'https://cdn.tgdd.vn/Products/Images/42/214925/xiaomi-redmi-note-9-den-1-org.jpg',0),(80,3,'XM_PX3PNFC','Xiaomi POCO X3 Pro NFC',7290,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/5/15/637567026121171526_poco-x3-pro-den-1.jpg',0),(81,3,'XM_R9A','Xiaomi Redmi 9A',1990,'https://cdn.tgdd.vn/Products/Images/42/218734/xiaomi-redmi-9a-xam-1-org.jpg',0),(82,3,'XM_R9C','Xiaomi Redmi 9C',2690,'https://cdn.tgdd.vn/Products/Images/42/226321/xiaomi-redmi-9c-3gb-xanh-duong-1-org.jpg',0),(83,3,'XM_R9T','Xiaomi Redmi 9T',3490,'https://cdn.tgdd.vn/Products/Images/42/231667/xiaomi-redmi-9t-xam-1-org.jpg',0),(84,3,'XM_RN10','Xiaomi Redmi Note 10',5490,'https://cdn.tgdd.vn/Products/Images/42/222758/xiaomi-redmi-note-10-xanh-duong-1-org.jpg',0),(85,3,'XM_RN105G','Xiaomi Redmi Note 10 5G',5290,'https://cdn.tgdd.vn/Products/Images/42/238306/xiaomi-redmi-note-10-5g-4gb-xanh-duong-1-org.jpg',0),(86,7,'iP_8128','iPad 8',15790,'https://cdn.tgdd.vn/Products/Images/522/228903/ipad-8-wifi-cellular-128gb-2020-xam-1020-org.jpg',0),(87,7,'iP_A4256','iPad Air 4 ',24990,'https://cdn.tgdd.vn/Products/Images/522/228899/ipad-air-4-rose-gold-1020x680-org.jpg',0),(88,7,'iP_A4WC256','iPad Air 4 Wifi Cellular 256GB',24990,'https://cdn.tgdd.vn/Products/Images/522/228899/ipad-air-4-sky-blue-1020x680-org.jpg',0),(89,7,'iP_P11128','iPad Pro 11',26290,'https://cdn.tgdd.vn/Products/Images/522/221774/ipad-pro-11-inch-wifi-cellular-128gb-2020-bac-1020x680-org.jpg',0),(90,7,'iP_P12.9128','iPad Pro 12.9',26790,'https://cdn.tgdd.vn/Products/Images/522/221775/ipad-pro-12-9-inch-wifi-128gb-2020-bac-1020x680-org.jpg',0),(91,7,'iP_PM111256','iPad Pro M1 11',29990,'https://cdn.tgdd.vn/Products/Images/522/238626/ipad-pro-2021-11-inch-silver-600x600.jpg',0),(92,7,'iP_PM112.9128','iPad Pro M1 12.9 inch',30790,'https://cdn.tgdd.vn/Products/Images/522/237699/ipad-pro-m1-129-inch-wifi-128gb-2021-xam-1-org.jpg',0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productline`
--

DROP TABLE IF EXISTS `productline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `line` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productline`
--

LOCK TABLES `productline` WRITE;
/*!40000 ALTER TABLE `productline` DISABLE KEYS */;
INSERT INTO `productline` VALUES (1,'Smart Phone','fas fa-mobile-alt','http://localhost:8080/shopfptvs2_war_exploded/resources/images/banner_01.png','The phone you always desired','AItem-MjAyMjA2MTZfMjIwhsh0'),(2,'Tablet','fas fa-tablet-alt','https://hoanghamobile.com/i/preview/Uploads/2020/11/06/ipad-10-2-2019-gen-7.png','Making communication easier','AItem-MjAyMjA2MTZfMjIwhsh01'),(3,'Laptop','fas fa-laptop','https://file.hstatic.net/1000238589/file/apple_macbook_pro_13-inch__core_i5__2.0_2020_a2251_-_3348_03d930d68a984f95a305867404a2fcd0.png','Packed with features','AItem-MjAyMjA2MTZfMjIwhsh02'),(4,'Accessory','fas fa-headphones-alt','http://localhost:8080/shopfptvs2_war_exploded/resources/images/headphone.png','Communicate effortlessly','AItem-MjAyMjA2MTZfMjIwhsh03'),(5,'Watch','far fa-clock','https://images.fpt.shop/unsafe/fit-in/60x60/filters:quality(90):fill(transparent)/https://fptshop.com.vn/Uploads/images/v5d/smart-watch.png',NULL,'AItem-MjAyMjA2MTZfMjIwhsh04'),(6,'Apple','fab fa-apple','https://images.fpt.shop/unsafe/fit-in/60x60/filters:quality(90):fill(transparent)/https://fptshop.com.vn/Uploads/images/v5d/apple.png',NULL,'AItem-MjAyMjA2MTZfMjIwhsh05'),(7,'Samsung',NULL,'https://images.fpt.shop/unsafe/fit-in/60x60/filters:quality(90):fill(transparent)/https://fptshop.com.vn/Uploads/images/2015/Other/chuyentrangsamsung8_7.png',NULL,'AItem-MjAyMjA2MTZfMjIwhsh06'),(8,'Display',NULL,'https://images.fpt.shop/unsafe/fit-in/60x60/filters:quality(90):fill(transparent)/https://fptshop.com.vn/Uploads/images/v5d/monitor2x.png',NULL,'AItem-MjAyMjA2MTZfMjIwhsh08'),(9,'Xiaomi',NULL,'https://images.fpt.shop/unsafe/fit-in/60x60/filters:quality(90):fill(transparent)/https://fptshop.com.vn/Uploads/images/v5d/xiaomi2.png',NULL,'AItem-MjAyMjA2MTZfMjIwhsh09');
/*!40000 ALTER TABLE `productline` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-17  0:52:01
