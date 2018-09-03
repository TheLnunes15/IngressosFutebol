-- MySQL dump 10.15 
--
-- Host: localhost    Database: futebol
-- ------------------------------------------------------

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
-- Table structure for table `jogos`
--

DROP TABLE IF EXISTS `jogos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogos` (
  `numJogo` int(11) NOT NULL AUTO_INCREMENT,
  `time1` varchar(45) DEFAULT NULL,
  `time2` varchar(45) DEFAULT NULL,
  `local` varchar(45) DEFAULT NULL,
  `horario` varchar(45) DEFAULT NULL,
  `data` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`numJogo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogos`
--

LOCK TABLES `jogos` WRITE;
/*!40000 ALTER TABLE `Jogos` DISABLE KEYS */;
INSERT INTO `jogos` VALUES (1,'Flamengo','Vasco','Maracana','19:30','23/12/2015'),(2,'Corinthians','Palmeiras','Arena Corinthians','20:30','23/12/2015'),(3,'Chapecoense','Fluminense','Arena Condá','21:00','23/12/2015'),(4,'Sport','Ponte Preta','Ilha do Retiro','22:00','23/12/2015'),(5,'Gremio','Internacional','Arena do Gremio','22:00','23/12/2015'),(6,'Figueirense','Avaí','Orlando Scarpelli','22:00','23/12/2015'),(7,'Cruzeiro','Atletico-MG','Mineirao','19:30','24/12/2015'), (8,'Coritiba','Atletico-PR','Couto Pereira','20:30','24/12/2015'), (9,'Goias','Joinville','Serra Dourada','21:00','24/12/2015'), (10,'Sao Paulo','Santos','Morumbi','21:00','24/12/2015');
/*!40000 ALTER TABLE `Jogos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bilhete`
--

DROP TABLE IF EXISTS `bilhete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bilhete` (
  `idbilhete` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `camarote` varchar(45) DEFAULT NULL,
  `setora` varchar(45) DEFAULT NULL,
  `setorb` varchar(45) DEFAULT NULL,
  `setorc` varchar(45) DEFAULT NULL,
  `jogo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbilhete`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilhete`
--

LOCK TABLES `bilhete` WRITE;
/*!40000 ALTER TABLE `bilhete` DISABLE KEYS */;
INSERT INTO `bilhete` VALUES (30,'Lucas','123344','20','758','0','0',2),(31,'Nunes','123344','20','23','3123','0',1),(32,'Santos','123344','6','0','0','0',7);
/*!40000 ALTER TABLE `bilhete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingressos`
--

DROP TABLE IF EXISTS `ingressos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingressos` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `codjogo` int(11) DEFAULT NULL,
  `camarote` int(11) DEFAULT NULL,
  `setor a` int(11) DEFAULT NULL,
  `setor b` int(11) DEFAULT NULL,
  `setor c` int(11) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingressos`
--

LOCK TABLES `ingressos` WRITE;
/*!40000 ALTER TABLE `ingressos` DISABLE KEYS */;
INSERT INTO `ingressos` VALUES (1,1,12,18,143,0),(2,2,20,758,0,0),(3,3,0,0,0,0),(4,4,0,0,0,0),(5,5,0,0,0,0),(6,6,0,0,0,0),(7,7,6,0,0,0),(8,8,0,0,0,0), (9,8,7,0,0,0), (10,8,5,0,0,0);
/*!40000 ALTER TABLE `ingressos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `times`
--

DROP TABLE IF EXISTS `times`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `times` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `times`
--

LOCK TABLES `times` WRITE;
/*!40000 ALTER TABLE `times` DISABLE KEYS */;
INSERT INTO `times` VALUES (1,'Flamengo'),(2,'Vasco'),(3,'Corinthians'),(4,'Palmeiras'),(5,'Chapecoense'),(6,'Fluminense'),(7,'Sport'),(8,'Ponte Preta'),(9,'Gremio'), (10,'Internacional'), (11,'Figueirense'), (12,'Avai'), (13,'Cruzeiro'), (14,'Atletico-MG'), (15,'Coritiba'), (16,'Atletico-PR'), (17,'Goias'), (18,'Joinville'), (19,'Sao Paulo'), (20,'Santos');
/*!40000 ALTER TABLE `times` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-11  12:45:22
