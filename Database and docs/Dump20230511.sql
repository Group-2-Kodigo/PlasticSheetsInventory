CREATE DATABASE  IF NOT EXISTS `sheetsinventory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sheetsinventory`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sheetsinventory
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `id_client` bigint NOT NULL AUTO_INCREMENT,
  `client_Name` varchar(75) DEFAULT NULL,
  `phone_Number` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `id_status` int DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`id_status`) REFERENCES `statusu` (`id_status`),
  CONSTRAINT `FKnc76wsd6ojf31poqmgthkio1e` FOREIGN KEY (`id_status`) REFERENCES `statusu` (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colors`
--

DROP TABLE IF EXISTS `colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colors` (
  `id_color` int NOT NULL AUTO_INCREMENT,
  `color` varchar(50) NOT NULL,
  PRIMARY KEY (`id_color`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
INSERT INTO `colors` VALUES (1,'negro');
/*!40000 ALTER TABLE `colors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colors_seq`
--

DROP TABLE IF EXISTS `colors_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colors_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors_seq`
--

LOCK TABLES `colors_seq` WRITE;
/*!40000 ALTER TABLE `colors_seq` DISABLE KEYS */;
INSERT INTO `colors_seq` VALUES (51);
/*!40000 ALTER TABLE `colors_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `id_inventory` bigint NOT NULL AUTO_INCREMENT,
  `id_movement` int NOT NULL,
  `id_user` int NOT NULL,
  `id_product` bigint NOT NULL,
  `id_invoice` bigint DEFAULT NULL,
  `quantity` int NOT NULL,
  `movementDate` date NOT NULL,
  `movementHour` time DEFAULT NULL,
  PRIMARY KEY (`id_inventory`),
  KEY `id_movement` (`id_movement`),
  KEY `id_user` (`id_user`),
  KEY `id_product` (`id_product`),
  KEY `id_invoice` (`id_invoice`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`id_movement`) REFERENCES `movements` (`id_movement`),
  CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `inventory_ibfk_3` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`),
  CONSTRAINT `inventory_ibfk_4` FOREIGN KEY (`id_invoice`) REFERENCES `invoiceheader` (`id_invoice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoicedetail`
--

DROP TABLE IF EXISTS `invoicedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoicedetail` (
  `id_invoiceDetail` bigint NOT NULL AUTO_INCREMENT,
  `invoiceDetailNumber` varchar(50) NOT NULL,
  `id_product` bigint NOT NULL,
  `id_invoice` bigint DEFAULT NULL,
  `invoiceQuantity` int NOT NULL,
  `subTotal` decimal(15,2) NOT NULL,
  `id_invoice_detail` bigint NOT NULL,
  `invoice_detail_number` varchar(255) DEFAULT NULL,
  `invoice_quantity` int DEFAULT NULL,
  `sub_total` double DEFAULT NULL,
  PRIMARY KEY (`id_invoiceDetail`),
  KEY `id_product` (`id_product`),
  KEY `id_invoice` (`id_invoice`),
  CONSTRAINT `invoicedetail_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`),
  CONSTRAINT `invoicedetail_ibfk_2` FOREIGN KEY (`id_invoice`) REFERENCES `invoiceheader` (`id_invoice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoicedetail`
--

LOCK TABLES `invoicedetail` WRITE;
/*!40000 ALTER TABLE `invoicedetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoicedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoiceheader`
--

DROP TABLE IF EXISTS `invoiceheader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoiceheader` (
  `id_invoice` bigint NOT NULL AUTO_INCREMENT,
  `invoiceNumber` varchar(50) NOT NULL,
  `id_movement` int NOT NULL,
  `id_supplier` bigint DEFAULT NULL,
  `id_client` bigint DEFAULT NULL,
  `id_user` int NOT NULL,
  `dateInvoice` date NOT NULL,
  `date_invoice` datetime(6) DEFAULT NULL,
  `invoice_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_invoice`),
  KEY `id_movement` (`id_movement`),
  KEY `id_supplier` (`id_supplier`),
  KEY `id_client` (`id_client`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `invoiceheader_ibfk_1` FOREIGN KEY (`id_movement`) REFERENCES `movements` (`id_movement`),
  CONSTRAINT `invoiceheader_ibfk_2` FOREIGN KEY (`id_supplier`) REFERENCES `suppliers` (`id_supplier`),
  CONSTRAINT `invoiceheader_ibfk_3` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`),
  CONSTRAINT `invoiceheader_ibfk_4` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoiceheader`
--

LOCK TABLES `invoiceheader` WRITE;
/*!40000 ALTER TABLE `invoiceheader` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoiceheader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id_material` int NOT NULL,
  `material` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_material`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_seq`
--

DROP TABLE IF EXISTS `material_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_seq`
--

LOCK TABLES `material_seq` WRITE;
/*!40000 ALTER TABLE `material_seq` DISABLE KEYS */;
INSERT INTO `material_seq` VALUES (1);
/*!40000 ALTER TABLE `material_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materials` (
  `id_material` int NOT NULL AUTO_INCREMENT,
  `material` varchar(75) NOT NULL,
  PRIMARY KEY (`id_material`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movements`
--

DROP TABLE IF EXISTS `movements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movements` (
  `id_movement` int NOT NULL AUTO_INCREMENT,
  `movement` varchar(50) NOT NULL,
  PRIMARY KEY (`id_movement`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movements`
--

LOCK TABLES `movements` WRITE;
/*!40000 ALTER TABLE `movements` DISABLE KEYS */;
INSERT INTO `movements` VALUES (1,'Move1');
/*!40000 ALTER TABLE `movements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id_product` bigint NOT NULL AUTO_INCREMENT,
  `product` varchar(100) NOT NULL,
  `thickness` varchar(5) NOT NULL,
  `stock` int NOT NULL,
  `id_size` int NOT NULL,
  `id_color` int NOT NULL,
  `id_material` int NOT NULL,
  `id_supplier` bigint NOT NULL,
  `selling_price` decimal(38,2) DEFAULT NULL,
  `unit_price` decimal(38,2) DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  KEY `id_size` (`id_size`),
  KEY `id_color` (`id_color`),
  KEY `id_supplier` (`id_supplier`),
  KEY `FK4u9q9siaysavdytmnvgrv0bu4` (`id_material`),
  CONSTRAINT `FK4u9q9siaysavdytmnvgrv0bu4` FOREIGN KEY (`id_material`) REFERENCES `material` (`id_material`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`id_size`) REFERENCES `sizes` (`id_size`),
  CONSTRAINT `products_ibfk_2` FOREIGN KEY (`id_color`) REFERENCES `colors` (`id_color`),
  CONSTRAINT `products_ibfk_3` FOREIGN KEY (`id_material`) REFERENCES `materials` (`id_material`),
  CONSTRAINT `products_ibfk_4` FOREIGN KEY (`id_supplier`) REFERENCES `suppliers` (`id_supplier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_seq`
--

DROP TABLE IF EXISTS `products_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_seq`
--

LOCK TABLES `products_seq` WRITE;
/*!40000 ALTER TABLE `products_seq` DISABLE KEYS */;
INSERT INTO `products_seq` VALUES (1);
/*!40000 ALTER TABLE `products_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `rol` varchar(50) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'root');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sizes` (
  `id_size` int NOT NULL AUTO_INCREMENT,
  `size` varchar(10) NOT NULL,
  PRIMARY KEY (`id_size`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes_seq`
--

DROP TABLE IF EXISTS `sizes_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sizes_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes_seq`
--

LOCK TABLES `sizes_seq` WRITE;
/*!40000 ALTER TABLE `sizes_seq` DISABLE KEYS */;
INSERT INTO `sizes_seq` VALUES (1);
/*!40000 ALTER TABLE `sizes_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusu`
--

DROP TABLE IF EXISTS `statusu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statusu` (
  `id_status` int NOT NULL AUTO_INCREMENT,
  `status_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusu`
--

LOCK TABLES `statusu` WRITE;
/*!40000 ALTER TABLE `statusu` DISABLE KEYS */;
INSERT INTO `statusu` VALUES (1,'Disponible');
/*!40000 ALTER TABLE `statusu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `id_supplier` bigint NOT NULL AUTO_INCREMENT,
  `supplier` varchar(75) NOT NULL,
  `NIT` varchar(25) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(15) DEFAULT NULL,
  `agent` varchar(100) DEFAULT NULL,
  `supplierAddress` varchar(100) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `supplier_address` varchar(255) DEFAULT NULL,
  `id_status` int DEFAULT NULL,
  PRIMARY KEY (`id_supplier`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `FK1vwk7e3jo3oxtrp41dhki21ap` FOREIGN KEY (`id_status`) REFERENCES `statusu` (`id_status`),
  CONSTRAINT `suppliers_ibfk_1` FOREIGN KEY (`id_status`) REFERENCES `statusu` (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers_seq`
--

DROP TABLE IF EXISTS `suppliers_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers_seq`
--

LOCK TABLES `suppliers_seq` WRITE;
/*!40000 ALTER TABLE `suppliers_seq` DISABLE KEYS */;
INSERT INTO `suppliers_seq` VALUES (1);
/*!40000 ALTER TABLE `suppliers_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(75) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `id_rol` int NOT NULL,
  `id_status` int DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `id_rol` (`id_rol`),
  KEY `id_status` (`id_status`),
  CONSTRAINT `FKq22aiafybiq03xswg0gui7ibe` FOREIGN KEY (`id_status`) REFERENCES `statusu` (`id_status`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`),
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`id_status`) REFERENCES `statusu` (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'waf503','12345',1,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sheetsinventory'
--

--
-- Dumping routines for database 'sheetsinventory'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-11 14:07:33
