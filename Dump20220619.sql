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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `created_day` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (8,'Customer-MjAyMjA2MTdfMjMwMzE0','Khoa','admin1','$2a$10$SD8B.75eJZPoG73Bb.3rcOjnRUQKfPCbAjTyE4msboUWMqEfmfg1q','Ha Noi','CUSTOMER','khoadamtam1@gmail.com','0981882816','17-06-2022',1),(9,'Customer-MjAyMjA2MThfMTQzMjA0','Khoa Dam Tam ','admin','$2a$10$Z.rXRXsxc7CYlCTsveHKiOYOQVN3PZcMwhW7.d5yvXmFCcQMtbpv6','Ha Noi','ADMIN','khoadamtam@gmail.com','0981882815','18-06-2022',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laptop`
--

DROP TABLE IF EXISTS `laptop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laptop` (
  `id` bigint(20) NOT NULL,
  `card` varchar(255) DEFAULT NULL,
  `cpu` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `display` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `memory` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `ram` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `weight` float NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK8pi53vvmhc93gx48fuwwd720v` FOREIGN KEY (`id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laptop`
--

LOCK TABLES `laptop` WRITE;
/*!40000 ALTER TABLE `laptop` DISABLE KEYS */;
INSERT INTO `laptop` VALUES (1,'Card tích hợp, Intel Iris Xe','i7, 1165G7, 2.8GHz','13.3\", Full HD','SSD 512 GB NVMe PCIe','16 GB, LP DDR4X, 4266 MHz','Dài 305 mm - Rộng 211 mm - Dày 11.9 mm',1.3),(2,'Intel Iris Xe Graphics','Intel Core i7-1165G7','14.0\", 1920 x 1080 Pixel, IPS, 60 Hz, 400 nits, Anti-glare LED-backlit','SSD 512 GB','16 GB, LPDDR4X, 4266 MHz','319 x 208 x 13.9',1.17),(3,'Intel Iris Xe Graphics','Intel Core i5-1135G7','13.4\", 1920 x 1080 Pixel, WVA, 60 Hz, 400 nits, LED-backlit','SSD 256 GB','8 GB, LPDDR4, 4266 MHz','296.9 x 208 x 14.7',1.32),(4,'Intel UHD','i7, 10710U, 1.1GHz','14\", Full HD (1920 x 1080)','256GB','16 GB, LPDDR4, 2933 MHz','Dai 319.3 mm - Rong 202.6 mm - Day 16.6 mm ',1.32),(5,'Intel Iris Xe Graphics','Intel Core i7-1165G7','13.3\", 3840 x 2160 Pixel, OLED, 60 Hz, 400 nits, OLED','SSD 1 TB','16 GB, LPDDR4, 3200 MHz','306.7 x 194.5 x 16.9',1.27),(6,'Intel Iris Xe Graphics','Intel Core i5-1135G7','14.0\", 1920 x 1080 Pixel, IPS, 60 Hz, 250 nits, Anti-glare LED UWVA','SSD 512 GB','16 GB, DDR4, 3200 MHz','323 x 214.6 x 17.9',1.35),(43,'Intel Iris Plus Graphics','Intel Core i5-10th-gen','13.3\", 2560 x 1600 Pixel, IPS, IPS LCD LED Backlit, True Tone','SSD 1 TB','16 GB, LPDDR4X, 3733 MHz','304.1 x 212.4 x 15.6',1.4),(44,'AMD Radeon Pro 5500M 4 GB & Intel UHD Graphics 630','Intel Core i9-9th-gen','16.0\", 3072 x 1920 Pixel, IPS, IPS LCD LED Backlit, True Tone','','16 GB, DDR4, 2666 MHz','357.9 x 24.59 x 16.2',2.1),(45,'Card tích hợp, 8 nhân GPU','Apple M1','13.3\", Retina (2560 x 1600)','SSD 1 TB','16GB','Dài 304.1 mm - Rộng 212.4 mm - Dày 15.6 mm',1.4),(46,'Card tích hợp, 7 nhân GPU','Apple M1','13.3\", Retina (2560 x 1600)','SSD 512 GB','16GB','Dài 304.1 mm - Rộng 212.4 mm - Dày 4.1 đến 16.1 mm',1.29),(47,'AMD Radeon RX 5500M 4GB','AMD Ryzen 7-5800H','15.6\", 1920 x 1080 Pixel, IPS, 144 Hz','SSD 512 GB','8 GB, DDR4, 3200 MHz','359 x 258 x 25',2.35),(48,'Card rời, RTX 3080 16GB','i7, 11800H, 2.30 GHz','15.6\", QHD (2560 x 1440), 240Hz','SSD 2 TB NVMe PCIe','32 GBDDR4 2 khe, 3200 MHz','Dài 358 mm - Rộng 267 mm - Dày 23.4 mm ',2.38),(49,'GeForce GTX 1650 4GB','Intel Core i5-10500H','15.6\", 1920 x 1080 Pixel, IPS, 144 Hz, 300 nits, IPS LCD LED Backlit, True Tone','512GB SSD','8 GB, DDR4, 3200 MHz','359 x 254 x 21.7',1.86),(50,'RTX 3070 8GB','i7, 11800H, 2.30 GHz',' 17.3\", Full HD (1920 x 1080), 240Hz','SSD 1 TB','16 GB, DDR4 2 khe, 3200 MHz','Dài 397 mm - Rộng 284 mm - Dày 25.9 mm',2.9),(51,'GTX 1660Ti 6GB','i7, 10750H, 2.6GHz','15.6\", Full HD (1920 x 1080), 144Hz','SSD 512 GB','16 GB, DDR4 (2 khe), 2666 MHz','Dài 359 mm - Rộng 254 mm - Dày 21.7 mm',2.3),(52,'AMD Radeon Graphics','AMD Ryzen 7-5700U','15.6\", 1920 x 1080 Pixel, IPS, 60 Hz, 250 nits, LED Backlit','SSD 512 GB','8 GB, DDR4, 3200 MHz','356.8 x 233.7 x 18.9',1.6),(53,'Card tích hợp, Intel Iris Xe','i7, 1185G7, 3GHz','13.4\", Full HD+ (1920 x 1200)','SSD 1 TB NVMe PCIe Gen4x4','16 GB, LPDDR4 (On board), 2133 MHz','Dài 300.2 mm - Rộng 222.25 mm - Dày 14.9 mm',1.35),(110,NULL,NULL,'ewqeq',NULL,NULL,NULL,1.5),(115,'dsadsa','dsadsa','ewqewq',NULL,NULL,NULL,1.5);
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
  `oid` bigint(20) NOT NULL,
  `cid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpjbqawi313hhm4itn7vjtt7g2` (`cid`),
  KEY `FK2wp59wbvbi2oel2obn6roleqw` (`oid`),
  CONSTRAINT `FK2wp59wbvbi2oel2obn6roleqw` FOREIGN KEY (`oid`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKpjbqawi313hhm4itn7vjtt7g2` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderproduct`
--

LOCK TABLES `orderproduct` WRITE;
/*!40000 ALTER TABLE `orderproduct` DISABLE KEYS */;
INSERT INTO `orderproduct` VALUES (1,'MSI_GE66R11UH269VN',2,7090,1,13),(6,'ASUS_KI439T',2,2698,4,11),(7,'MB_P162019TB',1,3181,4,10),(8,'IP_1264',2,1862,4,1),(9,'IP_12PM256',1,1590,4,1),(10,'MB_P162019TB',2,6362,5,10),(11,'IP_12PM256',2,3180,5,1),(17,'ASUS_HP163T',2,1122,9,11),(18,'IP_1264',1,931,9,1),(19,'SS-t_TS6L',2,908,9,8),(20,'ASUS_HP163T',1,561,10,11),(21,'IP_1264',2,1862,10,1),(22,'IP_12P512',3,4227,10,1),(23,'N_3.4',8,1008,12,5),(24,'SS-t_TS6L',10,4540,13,8),(25,'HW-t_MP11',2,1226,14,9),(26,'XM_R9C',4,488,15,3),(27,'HP_230P8PA',2,4408,16,14),(29,'MB_P162019TB',1,3181,18,10),(30,'SS-t_S7FE',4,2104,18,8),(31,'HP_ZBF14G8',1,1540,19,14),(32,'SS_N20',3,2043,19,2),(33,'iP_8128',1,717,19,7),(34,'VV_Y20SE',2,590,19,6),(36,'iP_A4256',3,3405,21,7),(37,'ASUS_HP163T',2,1122,22,11),(38,'IP_832',3,1089,22,1),(39,'iP_8128',3,2151,23,7),(40,'IP_13P128',1,1363,23,1),(41,'iP_36216132',3,3000,24,7),(43,'IP_13P128',2,2726,26,1),(48,'IP_11PM256',3,4227,58,1),(49,'MB_Z11C000CJ',2,4818,59,10),(50,'HW-t_MP11',1,613,59,9),(53,'IP_12PM512',2,3636,64,1),(54,'IP_11PM64',3,3681,65,1),(55,'IP_12PM256',3,4773,65,1);
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
  `name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `created` varchar(255) DEFAULT NULL,
  `total` int(11) NOT NULL,
  `status` bit(1) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'DAM KHOA','khoadamtam@gmail.com','0981882815','Cầu giấy',2,'26-03-2022',6950,_binary '',NULL),(4,'Khoa Dam','khoadamtam@gmail.com','0981882816','Cầu giấy',6,'26-03-2022',8777,_binary '',NULL),(5,'Khoa Tam','khoadamtam@gmail.com','0981882816','Cầu giấy',4,'26-03-2022',9164,_binary '',NULL),(9,'Khoa Dam','khoadam@gmail.com','0981882811','Vinh Thuong Phu Xuyen Ha Noi',5,'27-03-2022',2818,_binary '',NULL),(10,'Khoa Dam','khoadam@gmail.com','0981882881','Tran Quoc Hoan Cau Giay Ha Noi',6,'28-03-2022',6257,_binary '',NULL),(12,'Khoa T','khoaT@gmail.com','098188287','TQH Cau Giay Ha Noi',8,'28-03-2022',1016,_binary '',NULL),(13,'Dam Khoa','damkhoa@gmail.com','098188286','TQH Cau Giay Ha Noi',10,'28-03-2022',4550,_binary '',NULL),(14,'Dam K','dam@gmail.com','0981882816','TQH Cau Giay Ha Noi',2,'28-03-2022',1203,_binary '',NULL),(15,'DAM KHOA','khoadamtam@gmail.com','0981882817','TQH Cau Giay Ha Noi',4,'28-03-2022',492,_binary '',NULL),(16,'DAM KHOA','khoadamtam@gmail.com','0981882815','TQH CG HN',2,'28-03-2022',4410,_binary '',NULL),(18,'DAM KHOA','khoadamtam@gmail.com','0981882813','TQH CG HN',5,'29-03-2022',5026,_binary '',NULL),(19,'DAM KHOA','khoadamtam@gmail.com','0981882817','TQH CG HN',7,'29-03-2022',4555,_binary '',NULL),(21,'DAM KHOA TAM','khoadamtam@gmail.com','0981882815','TQH CG HN',3,'05-04-2022',3408,_binary '',NULL),(22,'DAM KHOI','khoadamtam@gmail.com','0981822813','TQH CG HN',5,'05-04-2022',2105,_binary '',NULL),(23,'Dam  Khoa','khoa@gmail.com','0981882815','TQH CG HN',4,'23-04-2022',3377,_binary '',NULL),(24,'Khoa Dam','','0981882815','  ',3,'23-04-2022',3003,_binary '',NULL),(26,'Khoa Dam Van','khoadamtam123@gmail.com','0981882815','TQH CG HN',2,'25-04-2022',2728,_binary '',NULL),(57,'Khoa Dam','khoadamtam@gmail.com','0981882815','  Hà Nội',3,'19-06-2022',4230,_binary '','Order-MjAyMjA2MTlfMDIwNDM0'),(58,'Khoa Dam','khoadamtam@gmail.com','0981882815','  Hà Nội',3,'19-06-2022',4230,_binary '','Order-MjAyMjA2MTlfMDIwNzE3'),(59,'Khoa Dam','khoadamtam@gmail.com','0981882815','  Hà Nội',3,'19-06-2022',5271,_binary '','Order-MjAyMjA2MTlfMDI0MDE3'),(64,'Khoa ',NULL,NULL,NULL,2,'19-06-2022',3638,_binary '','Order-MjAyMjA2MTlfMTkzODM1'),(65,'Khoa Dam','khoadamtam@gmail.com','0981882815','TQH CG HN',6,'19-06-2022',7953,_binary '','Order-MjAyMjA2MTlfMTk0MzMz');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonetab`
--

DROP TABLE IF EXISTS `phonetab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phonetab` (
  `id` bigint(20) NOT NULL,
  `display` varchar(255) DEFAULT NULL,
  `front_camera` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `back_camera` varchar(255) DEFAULT NULL,
  `chip` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `memory` varchar(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKkofrw0p4tk44x6de1h8cnihd4` FOREIGN KEY (`id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonetab`
--

LOCK TABLES `phonetab` WRITE;
/*!40000 ALTER TABLE `phonetab` DISABLE KEYS */;
INSERT INTO `phonetab` VALUES (7,'10.9\", IPS LCD','8 MP','13 MP','Snapdragon 865 8 nhân',' 128 GB','6 GB'),(8,'IPS LCD, 6.1\", Liquid Retina','12 MP','12 MP + 12 MP','Apple A13 Bionic','128 GB','4GB'),(9,'IPS LCD, 6.1\", Liquid Retina','12 MP','12 MP + 12 MP','Apple A13 Bionic','64GB','4GB'),(10,'6.5\", Super Retina XDR, Super AMOLED, 1242 x 2688 Pixel','12.0 MP','12.0 MP + 12.0 MP + 12.0 MP','A13 Bionic','128GB','4GB'),(11,'6.5\", Super Retina XDR, Super AMOLED, 1242 x 2688 Pixel','12.0 MP','12.0 MP + 12.0 MP + 12.0 MP','A13 Bionic','256GB','4GB'),(12,'6.5\", Super Retina XDR, Super AMOLED, 1242 x 2688 Pixel','12.0 MP','12.0 MP + 12.0 MP + 12.0 MP','A13 Bionic','64GB','4GB'),(13,'6.1\", Super Retina XDR, OLED, 2532 x 1170 Pixel','12.0 MP','12.0 MP + 12.0 MP','A14 Bionic','128GB','4GB'),(14,'6.1\", Super Retina XDR, OLED, 2532 x 1170 Pixel','12.0 MP','12.0 MP + 12.0 MP','A14 Bionic','256GB','4GB'),(15,'6.1\", Super Retina XDR, OLED, 2532 x 1170 Pixel','12.0 MP','12.0 MP + 12.0 MP','A14 Bionic','64GB','4GB'),(16,'6.1\", Super Retina XDR, OLED, 2532 x 1170 Pixel','12.0 MP','12.0 MP + 12.0 MP + 12.0 MP','A14 Bionic','128GB','6GB'),(17,'6.1\", Super Retina XDR, OLED, 2532 x 1170 Pixel','12.0 MP','12.0 MP + 12.0 MP + 12.0 MP','A14 Bionic','256GB','6GB'),(18,'6.1\", Super Retina XDR, OLED, 2532 x 1170 Pixel','12.0 MP','12.0 MP + 12.0 MP + 12.0 MP','A14 Bionic','512GB','6GB'),(19,'6.7\", Super Retina XDR, OLED, 2778 x 1284 Pixel','12.0 MP','12.0 MP + 12.0 MP + 12.0 MP','A14 Bionic','128GB','6GB'),(20,'6.7\", Super Retina XDR, OLED, 2778 x 1284 Pixel','12.0 MP','12.0 MP + 12.0 MP + 12.0 MP','A14 Bionic','256GB','6GB'),(21,'6.7\", Super Retina XDR, OLED, 2778 x 1284 Pixel','12.0 MP','12.0 MP + 12.0 MP + 12.0 MP','A14 Bionic','512GB','6GB'),(22,'OLED 6.1\", Super Retina XDR','12 MP','3 camera 12 MP','Apple A15 Bionic',' 128 GB','6 GB'),(23,'OLED 6.1\", Super Retina XDR','12 MP','3 camera 12 MP','Apple A15 Bionic','256 GB','6 GB'),(24,'LED-backlit IPS LCD, 4.7\", Retina HD','1.2 MP','8.0 MP','Apple A8','16GB','1GB'),(25,'LED-backlit IPS LCD, 5.5\", Retina HD','1.2 MP','8.0 MP','Apple A9','16GB','1GB'),(26,'LED-backlit IPS LCD, 4.7\", Retina HD','5.0 MP','8.0 MP','Apple A9','16GB','2GB'),(27,'LED-backlit IPS LCD, 5.5\", Retina HD','5 MP','12.0 MP','Apple A9','32GB','2GB'),(28,'LED-backlit IPS LCD, 4.7\", Retina HD','7.0 MP','12.0 MP','A10 Bionic','32GB','2GB'),(29,'LED-backlit IPS LCD, 5.5\", Retina HD','7.0 MP','12.0 MP + 12.0 MP','A10 Bionic','128GB','3GB'),(30,'LED-backlit IPS LCD, 5.5\", Retina HD','7.0 MP','12.0 MP + 12.0 MP','A10 Bionic','32GB','3GB'),(31,'LED-backlit IPS LCD, 4.7\", Retina HD','7.0 MP','12.0 MP','A11 Bionic','32GB','2GB'),(32,'LED-backlit IPS LCD, 5.5\", Retina HD','7.0 MP','12.0 MP','A11 Bionic','256GB','3GB'),(33,'LED-backlit IPS LCD, 5.5\", Retina HD','7.0 MP','12.0 MP + 12.0 MP','A11 Bionic','64GB','2GB'),(34,'IPS LCD, 4.7\", Retina HD','7 MP','12 MP','Apple A13 Bionic','64GB','3 GB'),(35,'OLED 5.8\",Super Retina','7.0 MP','12.0 MP + 12.0 MP','A11 Bionic','64GB','3GB'),(36,'OLED 5.8\",Super Retina','7.0 MP','12.0 MP + 12.0 MP','A11 Bionic','64GB','3GB'),(37,'6.1\", Liquid Retina HD, IPS LCD, 828 x 1792 Pixel','7.0 MP','12.0 MP','A12 Bionic','128GB','4GB'),(38,'6.1\", Liquid Retina HD, IPS LCD, 828 x 1792 Pixel','7.0 MP','12.0 MP','A12 Bionic','64GB','4GB'),(39,'OLED 5.8\",Super Retina','7.0 MP','12.0 MP + 12.0 MP','A12 Bionic','128GB','4GB'),(40,'OLED 5.8\",Super Retina','7.0 MP','12.0 MP + 12.0 MP','A12 Bionic','64GB','4GB'),(41,'OLED 6.5\",Super Retina','7.0 MP','12.0 MP + 12.0 MP','A12 Bionic','128GB','4GB'),(42,'OLED 6.5\",Super Retina','7.0 MP','12.0 MP + 12.0 MP','A12 Bionic','64GB','4GB'),(55,'TFT LCD, 6.5\", HD+','5 MP','2.0 MP + 13.0 MP ','Helio P22','32GB','2GB'),(56,'TFT LCD, 2.8\", 65.536 màu','2 MP','2 MP',NULL,NULL,NULL),(57,'IPS LCD, 6.39\", HD+','8 MP','2.0 MP + 5.0 MP + 8.0 MP','Snapdragon 460','64GB','4GB'),(58,'IPS LCD, 6.5\", HD+','5 MP','5 MP','Spreadtrum SC9863A','32GB','2GB'),(59,'AMOLED, 6.7\", Quad HD+ (2K+)','32 MP','3.0 MP + 13.0 MP + 50.0 MP + 50.0 MP','Snapdragon 888','256GB','12GB'),(60,'AMOLED, 6.43\", Full HD+','32 MP','2.0 MP + 2.0 MP + 8.0 MP + 64.0 MP','Snapdragon 765G','128 GB','8GB'),(61,'6.43\", FHD+, AMOLED, 1080 x 2400 Pixel','32 MP','64.0 MP + 8.0 MP + 2.0 MP','MediaTek Dimensity 800U','128 GB','8GB'),(62,'12.4\", TFT LCD','5 MP','8 MP','Snapdragon 750G','64GB','3 GB'),(63,'10.4\", PLS LCD','5 MP','8 MP','Exynos 9611','64GB','4GB'),(64,'11\", LTPS IPS LCD','8 MP ','Chính 13 MP & Phụ 5 MP','Snapdragon 865+','128GB','6GB'),(65,'Super AMOLED, 6.7\", Full HD+','32 MP','5.0 MP + 8.0 MP + 12.0 MP + 64.0 MP','Snapdragon 720G','256GB','8 GB'),(66,'6.7\", FHD+, Super AMOLED Plus, 1080 x 2400 Pixel','10.0 MP','12.0 MP + 12.0 MP + 64.0 MP','Exynos 990','256GB','8GB'),(67,'6.9\", 2K+, Dynamic AMOLED 2X, 1440 x 3088 Pixel','10.0 MP','108.0 MP + 12.0 MP + 12.0 MP','Exynos 990','256GB','8GB'),(68,'Dynamic AMOLED 2X6.7\"Quad HD+ (2K+)','10.0 MP','12.0 MP + 12.0 MP + 64.0 MP + 0.5 MP','Exynos 990','128 GB','8 GB'),(69,'Dynamic AMOLED 2X6.9\"Quad HD+ (2K+)','40 MP','12.0 MP + 48.0 MP + 108.0 MP, TOF 3D','Exynos 990','128 GB','12GB'),(70,'Dynamic AMOLED 2X6.7\"Full HD+','10.0 MP','12.0 MP + 12.0 MP + 64.0 MP','Exynos 2100','256GB','8 GB'),(71,'Dynamic AMOLED 2X6.8\"Quad HD+ (2K+)','40 MP','10.0 MP + 12.0 MP + 12.0 MP + 108.0 MP','Exynos 2100','128 GB','12GB'),(72,'Màn hình trước: 6.2\", Màn hình chính: 7.6\", HD+, Chính: Dynamic AMOLED 2X, phụ: Super AMOLED','10.0 MP','12.0 MP + 12.0 MP + 12.0 MP','Snapdragon 865+','256GB','12GB'),(73,'AMOLED, 6.44\", Full HD+','44 MP','2 MP + 8 MP + 64 MP','MediaTek Dimensity 800U 5G','128 GB','8 GB'),(74,'AMOLED, 6.44\", Full HD+','32 MP','2 MP + 8 MP + 48 MP','Snapdragon 665','128 GB','8 GB'),(75,'IPS LCD, 6.58\", Full HD+','40 MP','2 MP + 8 MP + 64 MP','MediaTek Dimensity 700','128 GB','8 GB'),(76,'IPS LCD, 6.67\", Full HD+','20 MP','5 MP + 13 MP + 108 MP','Snapdragon 865','256 GB','8GB'),(77,'AMOLED, 6.81\", Quad HD+ (2K+)','20 MP','5 MP + 13 MP + 108 MP','Snapdragon 888','256 GB','8GB'),(78,'AMOLED, 6.67\", Full HD+','16 MP','2 MP + 5 MP + 8 MP + 108MP','Snapdragon 732G','128GB','8GB'),(79,'IPS LCD, 6.53\", Full HD+','13 MP','2 MP + 2 MP + 8 MP + 48MP','MediaTek Helio G85','128GB','4GB'),(80,'6.67\", FHD+, IPS LCD, 1080 x 2400 Pixel','20 MP','48.0 MP + 8.0 MP + 2.0 MP + 2.0 MP','Snapdragon 860','256 GB','8GB'),(81,'IPS LCD, 6.53\", HD+','5 MP','13 MP','MediaTek Helio G25','32GB','2GB'),(82,'IPS LCD, 6.53\", HD+','5 MP','2 MP + 2 MP + 13MP','MediaTek Helio G35','64GB','3GB'),(83,'IPS LCD, 6.53\", HD+','8MP','2 MP + 2 MP + 8 MP + 48MP','Snapdragon 662','64GB','4GB'),(84,'AMOLED, 6.43\", Full HD+','13 MP','2 MP + 2 MP + 8 MP + 48MP','Snapdragon 678','128GB','6GB'),(85,'IPS LCD, 6.5\", Full HD+','8MP','2 MP + 2 MP + 48MP','MediaTek Dimensity 700','128GB','4GB'),(86,'10.2\", Retina IPS LCD','1.2 MP','8 MP','Apple A12 Bionic','128GB','3GB'),(87,'10.9\", Liquid Retina','7 MP','12 MP','Apple A14 Bionic','256 GB','4GB'),(88,'10.9\", Liquid Retina','7 MP','12 MP','Apple A14 Bionic','256GB','4GB'),(89,'11\", Liquid Retina','7 MP','Chính 12 MP & Phụ 10 MP, TOF 3D LiDAR','Apple A12Z Bionic','128GB','6GB'),(90,'12.9\", Liquid Retina','7 MP','Chính 12 MP & Phụ 10 MP, TOF 3D LiDAR','Apple A12Z Bionic','128GB','6GB'),(91,'11\", Liquid Retina','12 MP','ChÃ­nh 12 MP & Phá»¥ 10 MP, TOF 3D LiDAR','Apple M1 8 nhÃ¢n','256 GB','8GB'),(92,'12.9\", Liquid Retina XDR mini-LED LCD','12 MP','chinh 12 MP & phu 10 MP, TOF 3D LiDAR','Apple M1 8 nhÃ?Â¢n','128GB','6GB'),(117,NULL,'ewq',NULL,NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,11,'ASUS_HP163T','Laptop Asus ZenBook Flip UX363EA',561,'https://cdn.tgdd.vn/Products/Images/44/249286/asus-zenbook-flip-ux363ea-i7-hp163t-1-org.jpg',0),(2,11,'ASUS_KI439T','Laptop Asus Zenbook UX425EA KI439T',1349,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/19/637413930235653362_HASP-Asus-Vivobook-UX425(19).jpg',0),(3,12,'DELL_XPS139310','Laptop Dell XPS 13 9310',1909,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/3/23/637521096034930087_dell-xps-13-9310-2in1-bac-2-evo-i5.jpg',0),(4,14,'HP_230P8PA','Laptop HP EliteBook X360 1040 G7',2204,'https://cdn.tgdd.vn/Products/Images/44/232152/hp-elitebook-x360-1040-g7-i7-230p8pa-1-org.jpg',0),(5,14,'HP_S132101TU','Laptop HP Spectre x360 13-aw2101TU',2272,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/4/22/637547115695019344_hp-spectre-x360-xanh-3.jpg',0),(6,14,'HP_ZBF14G8','Laptop HP ZBook Firefly 14 G8',1540,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/9/4/637663502047201460_hp-zbook-firefly-14-g8-xam-2.jpg',0),(7,9,'HW-t_MP11','Huawei MatePad 11 da chinh sua',613,'https://www.electrorates.com/blogimg/Huawei_Matepad_11_2021.png',0),(8,1,'IP_11128','iPhone 11 128GB',908,'https://cdn.tgdd.vn/Products/Images/42/210644/iphone-11-xanh-la-1-org.jpg',0),(9,1,'IP_1164','iPhone 11 64GB',795,'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-11-do-1-1-1-org.jpg',0),(10,1,'IP_11PM128','Iphone 11 Pro Max 128GB',1318,'https://cdn.tgdd.vn/Products/Images/42/230521/iphone-13-pro-silver-2.jpg',0),(11,1,'IP_11PM256','Iphone 11 Pro Max 256GB',1409,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/9/637273078874356795_iphone%2011%20pro%20max%20(1).jpg',0),(12,1,'IP_11PM64','Iphone 11 Pro Max 64GB',1227,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/9/637273078874356795_iphone%2011%20pro%20max%20(1).jpg',0),(13,1,'IP_12128','Iphone 12 128GB',1022,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740261112650_iphone-12-12-mini-1.jpg',0),(14,1,'IP_12256','Iphone 12 256GB',1113,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740261112650_iphone-12-12-mini-1.jpg',0),(15,1,'IP_1264','Iphone 12 64GB',931,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740261112650_iphone-12-12-mini-1.jpg',0),(16,1,'IP_12P128','Iphone 12 Pro 128GB',1272,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740532520004_iphone-12-pro-12-pro-max-2.jpg',0),(17,1,'IP_12P256','Iphone 12 Pro 256GB',1318,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740532520004_iphone-12-pro-12-pro-max-2.jpg',0),(18,1,'IP_12P512','Iphone 12 Pro 512GB',1409,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740532520004_iphone-12-pro-12-pro-max-2.jpg',0),(19,1,'IP_12PM128','Iphone 12 Pro Max 128GB',1409,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740535019513_iphone-12-pro-12-pro-max-4.jpg',0),(20,1,'IP_12PM256','Iphone 12 Pro Max 256GB',1590,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740535019513_iphone-12-pro-12-pro-max-4.jpg',0),(21,1,'IP_12PM512','Iphone 12 Pro Max 512GB',1818,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/11/27/637420740535019513_iphone-12-pro-12-pro-max-4.jpg',0),(22,1,'IP_13P128','iPhone 13 Pro 128GB',1363,'https://cdn.tgdd.vn/Products/Images/42/230521/iphone-13-pro-1-1.jpg',0),(23,1,'IP_13P256','iPhone 13 Pro 256GB',1545,'https://cdn.tgdd.vn/Products/Images/42/230521/iphone-13-pro-silver-2.jpg',0),(24,1,'IP_632','Iphone 6 32GB',136,'https://cdn.tgdd.vn/Products/Images/42/92962/iphone-6-32gb-gold-up-1-org.jpg',0),(25,1,'IP_6P16','Iphone 6 Plus 16GB',181,'https://cdn.tgdd.vn/Products/Images/42/69783/iphone-6-plus-16gb-xam1-1-3-org.jpg',0),(26,1,'IP_6S16','Iphone 6s 16GB',181,'https://cdn.tgdd.vn/Products/Images/42/60831/iphone-6-xam-org-1.png',0),(27,1,'IP_6SP32','Iphone 6S Plus 32GB',227,'https://cdn.tgdd.vn/Products/Images/42/87846/iphone-6s-plus-32gb-vangdong1-1-3-org.jpg',0),(28,1,'IP_732','Iphone 7 32GB',272,'https://cdn.tgdd.vn/Products/Images/42/74110/iphone-7-den-1-12-org.jpg',0),(29,1,'IP_7P128','Iphone 7 Plus 128GB',363,'https://cdn.tgdd.vn/Products/Images/42/78124/iphone-7-plus-den-1-5-org.jpg',0),(30,1,'IP_7P32','Iphone 7 Plus 32GB',318,'https://cdn.tgdd.vn/Products/Images/42/78124/iphone-7-plus-den-1-5-org.jpg',0),(31,1,'IP_832','Iphone 8 32GB',363,'https://cdn.tgdd.vn/Products/Images/42/114113/iphone-8-64gb-den-1-org.jpg',0),(32,1,'IP_8P256','Iphone 8 Plus 256GB',454,'https://cdn.tgdd.vn/Products/Images/42/114110/iphone-8-plus-do-1-org.jpg',0),(33,1,'IP_8P64','Iphone 8 Plus 64GB',409,'https://cdn.tgdd.vn/Products/Images/42/114110/iphone-8-plus-64gb-vangdong-1-3-org.jpg',0),(34,1,'IP_SE64','iPhone SE 64GB',545,'https://cdn1.hoanghamobile.com/tin-tuc/wp-content/uploads/2020/04/Untitled-1.png',0),(35,1,'IP_X128','Iphone X 128GB',0,'https://cdn.tgdd.vn/Products/Images/42/114115/iphone-x-64gb-bac-1-1-org.jpg',0),(36,1,'IP_X64','Iphone X 64GB',477,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/11/637274707339798536_2%20iPhoneXr-Red-PB-PF-US-EN-SCREEN.jpg',0),(37,1,'IP_XR128','Iphone XR 128GB',659,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/11/637274707339798536_2%20iPhoneXr-Red-PB-PF-US-EN-SCREEN.jpg',0),(38,1,'IP_XR64','Iphone XR 64GB',568,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/11/637274707339798536_2%20iPhoneXr-Red-PB-PF-US-EN-SCREEN.jpg',0),(39,1,'IP_XS128','Iphone XS 128GB',0,'https://cdn.tgdd.vn/Products/Images/42/190323/iphone-xs-vang-1-1-org.jpg',0),(40,1,'IP_XS64','Iphone XS 64GB',568,'https://cdn.tgdd.vn/Products/Images/42/190323/iphone-xs-vang-1-1-org.jpg',0),(41,1,'IP_XSM128','Iphone XS Max 128GB',0,'https://cdn.tgdd.vn/Products/Images/42/190321/iphone-xs-max-1-org.jpg',0),(42,1,'IP_XSM64','Iphone XS Max 64GB',727,'https://cdn.tgdd.vn/Products/Images/42/190321/iphone-xs-max-1-org.jpg',0),(43,10,'MB_P152020TB','MacBook Pro 13\" 2020 Touch Bar',2499,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/23/637285184781674411_mbp13touch-space-gallery2-202005_GEO_US.jpg',0),(44,10,'MB_P162019TB','MacBook Pro 16\" 2019 Touch Bar',3181,'https://images.fpt.shop/unsafe/fit-in/960x640/filters:quality(90):fill(white):upscale()/fptshop.com.vn/Uploads/Originals/2020/6/10/637273992022046588_MacBook_Pro_16-in_Touch_Bar_Pure_Top_Open_Silver_SCREEN.jpg',0),(45,10,'MB_Z11C000CJ','Laptop Apple MacBook Pro M1',2408,'https://cdn.tgdd.vn/Products/Images/44/236131/laptopapplemacbookprom1-1-org.jpg',0),(46,10,'MB_Z12A00050','Laptop Apple MacBook Air M1',1795,'https://cdn.tgdd.vn/Products/Images/44/243952/apple-macbook-air-m1-2020-z12a00050-1-org.jpg',0),(47,13,'MSI_B15028VN','Laptop MSI Bravo 15 B5DD 028VN',1136,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/6/22/637599748140056944_msi-bravo-15-b5dx-den-1.jpg',0),(48,13,'MSI_GE66R11UH269VN','Laptop MSI Gaming GE66 Raider 11UH',3545,'https://cdn.tgdd.vn/Products/Images/44/249151/msi-gaming-ge66-raider-11uh-i7-259vn-1-org.jpg',0),(49,13,'MSI_GF631218VN','Laptop MSI Gaming GF63 10SCXR-1218VN',940,'https://cdn.tgdd.vn/Products/Images/44/242200/msi-gf65-10ue-i7-228vn-2-org.jpg',0),(50,13,'MSI_GP76435VN','Laptop MSI Gaming GP76 11UG',2408,'https://cdn.tgdd.vn/Products/Images/44/242204/msi-gp76-11ug-i7-435vn-1-org.jpg',0),(51,13,'MSI_L10SDKGL65242VN','Laptop MSI Gaming Leopard 10SDK GL65',1476,'https://cdn.tgdd.vn/Products/Images/44/225857/msi-gaming-leopard-10sdr-gl65-i7-242vn-1-org.jpg',0),(52,13,'MSI_M15A5M','Laptop MSI Modern 15 A5M',909,'https://fptshop.com.vn/Uploads/images/2015/Tin-Tuc/QuanLNH2/msi-modern-15-xam-carbon-1.jpg',0),(53,13,'MSI_SE13F211VN','Laptop MSI Summit E13 Flip',1817,'https://cdn.tgdd.vn/Products/Images/44/246951/msi-summit-e13-flip-i7-211vn-1-org.jpg',0),(55,5,'N_2.4','Nokia 2.4',104,'https://cdn.tgdd.vn/Products/Images/42/226218/nokia-24-xam-1-2-org.jpg',0),(56,5,'N_230','Nokia 230',56,'https://cdn.tgdd.vn/Products/Images/42/101850/nokia-230-khong-the-xam-dam-1-org.jpg',0),(57,5,'N_3.4','Nokia 3.4',126,'https://cdn.tgdd.vn/Products/Images/42/227626/nokia-34-1-1-org.jpg',0),(58,5,'N_C20','Nokia C20',90,'https://cdn.tgdd.vn/Products/Images/42/236437/nokia-c20-vang-1-1-org.jpg',0),(59,4,'OPPO_FX3P5G','OPPO Find X3 Pro 5G',1226,'https://cdn.tgdd.vn/Products/Images/42/232190/oppo-find-x3-pro-den-1-org.jpg',0),(60,4,'OPPO_R5G','OPPO Reno6 5G',517,'https://cdn.tgdd.vn/Products/Images/42/233460/oppo-reno5-5g-den--org.jpg',0),(61,4,'OPPO_RZ5G','OPPO Reno6 Z 5G',431,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/7/8/637613323642518520_oppo-reno6z-xanh-1.jpg',0),(62,8,'SS-t_S7FE','Samsung Galaxy Tab S7 FE ',526,'https://cdn.tgdd.vn/Products/Images/522/240254/samsung-galaxy-tab-s7-fe-green-1-org.jpg',0),(63,8,'SS-t_TS6L','Samsung Galaxy Tab S6 Lite ',454,'https://cdn.tgdd.vn/Products/Images/522/219912/samsung-galaxy-tab-s6-lite-xanh-1-org.jpg',0),(64,8,'SS-t_TS7','Samsung Galaxy Tab S7 ',908,'https://cdn.tgdd.vn/Products/Images/522/225031/samsung-galaxy-tab-s7-vang-dong-1-org.jpg',0),(65,2,'SS_A72','Samsung Galaxy A72 ',476,'https://cdn.tgdd.vn/Products/Images/42/226101/samsung-galaxy-a72-black-1020x680-org.jpg',0),(66,2,'SS_N20','Samsung Galaxy Note 20',681,'https://cdn.tgdd.vn/Products/Images/42/218355/samsung-galaxy-note-20-xanh-la-1-org.jpg',0),(67,2,'SS_N20U','Samsung Galaxy Note 20 Ultra',908,'https://cdn.tgdd.vn/Products/Images/42/220522/samsung-galaxy-note-20-ultra-vang-dong-1-org.jpg',0),(68,2,'SS_S20P','Samsung Galaxy S20+',772,'https://cdn.tgdd.vn/Products/Images/42/217936/samsung-galaxy-s20-plus-xanh-duong-1-org.jpg',0),(69,2,'SS_S20U','Samsung Galaxy S20 Ultra',1363,'https://cdn.tgdd.vn/Products/Images/42/217937/samsung-galaxy-s20-ultra-xam-1-org.jpg',0),(70,2,'SS_S21P','Samsung Galaxy S21+',1090,'https://cdn.tgdd.vn/Products/Images/42/236128/samsung-galaxy-s21-plus-256gb-bac-1-org.jpg',0),(71,2,'SS_S21U','Samsung Galaxy S21 Ultra',1181,'https://cdn.tgdd.vn/Products/Images/42/226316/samsung-galaxy-s21-ultra-bac-1-org.jpg',0),(72,2,'SS_ZF25G','Samsung Galaxy Z Fold2 5G   ',2000,'https://cdn.tgdd.vn/Products/Images/42/226099/samsung-galaxy-z-fold-2-den-1-org.jpg',0),(73,6,'VV_V215G','Vivo V21 5G',431,'https://cdn.tgdd.vn/Products/Images/42/238047/vivo-v21-5g-xanh-den-1-org.jpg',0),(74,6,'VV_Y20SE','Vivo Y20 SE',295,'https://cdn.tgdd.vn/Products/Images/42/228141/vivo-v20-se-den-1-org.jpg',0),(75,6,'VV_Y725G','Vivo Y72 5G',345,'https://cdn.tgdd.vn/Products/Images/42/236431/vivo-y72-5g-xanh-hong-1-1-org.jpg',0),(76,3,'XM_10TP5G','Xiaomi Mi 10T Pro 5G',567,'https://cdn.tgdd.vn/Products/Images/42/228136/xiaomi-mi-10t-pro-1-org.jpg',0),(77,3,'XM_115G','Xiaomi Mi 11 5G',772,'https://cdn.tgdd.vn/Products/Images/42/226264/xiaomi-mi-11-xanhduong-1-org.jpg',0),(78,3,'XM_N10P','Xiaomi Redmi Note 10 Pro',340,'https://cdn.tgdd.vn/Products/Images/42/229228/xiaomi-redmi-note-10-pro-xam-1-org.jpg',0),(79,3,'XM_N9','Xiaomi Redmi Note 9',190,'https://cdn.tgdd.vn/Products/Images/42/214925/xiaomi-redmi-note-9-den-1-org.jpg',0),(80,3,'XM_PX3PNFC','Xiaomi POCO X3 Pro NFC',331,'https://images.fpt.shop/unsafe/fit-in/585x390/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/5/15/637567026121171526_poco-x3-pro-den-1.jpg',0),(81,3,'XM_R9A','Xiaomi Redmi 9A',90,'https://cdn.tgdd.vn/Products/Images/42/218734/xiaomi-redmi-9a-xam-1-org.jpg',0),(82,3,'XM_R9C','Xiaomi Redmi 9C',122,'https://cdn.tgdd.vn/Products/Images/42/226321/xiaomi-redmi-9c-3gb-xanh-duong-1-org.jpg',0),(83,3,'XM_R9T','Xiaomi Redmi 9T',158,'https://cdn.tgdd.vn/Products/Images/42/231667/xiaomi-redmi-9t-xam-1-org.jpg',0),(84,3,'XM_RN10','Xiaomi Redmi Note 10',249,'https://cdn.tgdd.vn/Products/Images/42/222758/xiaomi-redmi-note-10-xanh-duong-1-org.jpg',0),(85,3,'XM_RN105G','Xiaomi Redmi Note 10 5G',240,'https://cdn.tgdd.vn/Products/Images/42/238306/xiaomi-redmi-note-10-5g-4gb-xanh-duong-1-org.jpg',0),(86,7,'iP_8128','iPad 8',717,'https://cdn.tgdd.vn/Products/Images/522/228903/ipad-8-wifi-cellular-128gb-2020-xam-1020-org.jpg',0),(87,7,'iP_A4256','iPad Air 4 ',1135,'https://cdn.tgdd.vn/Products/Images/522/228899/ipad-air-4-rose-gold-1020x680-org.jpg',0),(88,7,'iP_A4WC256','iPad Air 4 Wifi Cellular 256GB',1135,'https://cdn.tgdd.vn/Products/Images/522/228899/ipad-air-4-sky-blue-1020x680-org.jpg',0),(89,7,'iP_P11128','iPad Pro 11',1195,'https://cdn.tgdd.vn/Products/Images/522/221774/ipad-pro-11-inch-wifi-cellular-128gb-2020-bac-1020x680-org.jpg',0),(90,7,'iP_P12.9128','iPad Pro 12.9',1217,'https://cdn.tgdd.vn/Products/Images/522/221775/ipad-pro-12-9-inch-wifi-128gb-2020-bac-1020x680-org.jpg',0),(91,7,'iP_PM111256','iPad Pro M1 11',1363,'https://cdn.tgdd.vn/Products/Images/522/238626/ipad-pro-2021-11-inch-silver-600x600.jpg',0),(92,7,'iP_PM112.9128','iPad Pro M1 12.9 inch',1399,'https://cdn.tgdd.vn/Products/Images/522/237699/ipad-pro-m1-129-inch-wifi-128gb-2021-xam-1-org.jpg',0),(110,10,'MB_321321ewq','iPad Pro M1 12.9 inch',45,'http://localhost:8080/resources/uploads/mbm12020.jpg',100),(115,10,'MB_3271732','Laptop thu nghiem321',454,'http://localhost:8080/resources/uploads/Alcatel-3T8-1-600x600.jpg',100),(117,7,'iP_dsajdjsa','Tablet thu nghiemdsad',1000,'http://localhost:8080/resources/uploads/ipse.jpg',100);
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

-- Dump completed on 2022-06-19 20:03:35
