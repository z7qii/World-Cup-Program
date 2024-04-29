-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: assignment_1
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
-- Table structure for table `match_2`
--

DROP TABLE IF EXISTS `match_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `match_2` (
  `seatID` varchar(10) NOT NULL,
  `cusName` varchar(45) DEFAULT 'Empty',
  `cusEmail` varchar(45) DEFAULT 'Empty',
  `seatPrice` int DEFAULT '300',
  `TicketId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`seatID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match_2`
--

LOCK TABLES `match_2` WRITE;
/*!40000 ALTER TABLE `match_2` DISABLE KEYS */;
INSERT INTO `match_2` VALUES ('A1','Empty','Empty',300,'A1'),('A2','Empty','Empty',300,'A2'),('A3','Empty','Empty',300,'A3'),('A4','Empty','Empty',300,'A4'),('A5','Empty','Empty',300,'A5'),('A6','Empty','Empty',300,'A6'),('A7','Empty','Empty',300,'B1'),('A8','Empty','Empty',300,'B2'),('B1','Empty','Empty',300,'B3'),('B2','Empty','Empty',300,'B4'),('B3','zayed','zayed@gmail.com',300,'B5'),('B4','Empty','Empty',300,'B6'),('C1','Empty','Empty',300,'C1'),('C2','Empty','Empty',300,'C2'),('C3','Empty','Empty',300,'C3'),('C4','Empty','Empty',300,'C4'),('C5','Empty','Empty',300,'C5'),('C6','Empty','Empty',300,'C6'),('C7','Empty','Empty',300,'D1'),('C8','Empty','Empty',300,'D2'),('D1','Empty','Empty',300,'D3'),('D2','Empty','Empty',300,'D4'),('D3','Empty','Empty',300,'D5'),('D4','Empty','Empty',300,'D6');
/*!40000 ALTER TABLE `match_2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-12 21:47:42
