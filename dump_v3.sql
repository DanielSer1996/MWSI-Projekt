CREATE DATABASE  IF NOT EXISTS `cepik_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cepik_db`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cepik_db
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `ADDRESS`
--

DROP TABLE IF EXISTS `ADDRESS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ADDRESS` (
  `ADDRESS_ID` bigint(20) NOT NULL,
  `ADDRESS_LOCALITY` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ADDRESS_STREET` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ADDRESS_ZIPCODE` varchar(6) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ADDRESS_VOIVODESHIP` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ADDRESS_STREET_NUMBER` decimal(8,0) DEFAULT NULL,
  `ADDRESS_APARTMENT_NUMBER` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADDRESS`
--

LOCK TABLES `ADDRESS` WRITE;
/*!40000 ALTER TABLE `ADDRESS` DISABLE KEYS */;
INSERT INTO `ADDRESS` VALUES (1,'Sulejówek','ul. Bzowska','44-240','opolskie',20,7),(2,'Wygoda','ul. Strażacka','88-100','świętokrzyskie',2,7),(3,'Głogów','Os. 1 Maja','44-240','opolskie',23,1),(4,'Wityń','Os. Złote Łąki 3','98-360','śląskie',20,9),(5,'Grodzewo','ul. Dubois Stanisława','04-353','lubelskie',6,9),(6,'Warszawa','ul. Sadowa','02-747','lubuskie',30,7),(7,'Dąbrowa Górnicza','ul. Zielona Góra','18-507','warmińsko-mazurskie',25,1),(8,'Dąbrowa-Wilki','Pl. Konstytucji','97-525','łódzkie',2,10),(9,'Kraków','ul. Wesoła','60-454','dolnośląskie',9,1),(10,'Bytom','ul. Gminna','91-865','mazowieckie',21,4),(11,'Jemielno','Os. Jagiełły Władysława','78-520','mazowieckie',15,5),(12,'Sochaczew','ul. Wytrwałych','88-111','mazowieckie',29,10),(13,'Łapka','ul. Lubomira','44-122','mazowieckie',22,9),(14,'Bielsko-Biała','ul. Pstrowskiego Wincentego','28-363','mazowieckie',16,1),(15,'Szczecin','ul. Grunwaldzka','63-400','mazowieckie',7,10),(16,'Borówno','ul. Solec','05-800','pomorskie',18,7),(17,'Jagodne Małe','ul. Słoneczna','21-077','małopolskie',1,2),(18,'Wilkołaz Dolny','ul. Conrada Józefa','41-208','podlaskie',5,3),(19,'Warszawa','ul. Sierakowskiego Zygmunta','61-407','łódzkie',15,3),(20,'Gdynia','ul. Gojawiczyńskiej Poli','16-113','pomorskie',30,4),(21,'Gdańsk','ul. Mickiewicza Adama','91-231','świętokrzyskie',25,5),(22,'Wrocław','ul. Oświatowa','59-335','śląskie',1,4),(23,'Orzeszkowo','ul. Katowicka','44-300','wielkopolskie',29,10),(24,'Jasiona','ul. Rudzka','61-229','lubelskie',18,10),(25,'Witkowo','ul. Kujawska','81-234','wielkopolskie',12,2),(26,'Chruszczobród','ul. Harnasiów','07-106','wielkopolskie',29,7),(27,'Zaleszczyce','ul. Jarzębinowa','41-807','wielkopolskie',10,5),(28,'Andrzejów','ul. Kłodzka','66-530','warmińsko-mazurskie',9,3),(29,'Dywity','Os. Piłsudskiego Józefa','26-200','łódzkie',29,7),(30,'Słupia','Al. 700-Lecia','43-190','lubuskie',19,9);
/*!40000 ALTER TABLE `ADDRESS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAR`
--

DROP TABLE IF EXISTS `CAR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CAR` (
  `CAR_VIN` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `INSURANCE_ID` bigint(20) NOT NULL,
  `CAR_MAKE` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CAR_MODEL` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CAR_REGISTRATION_NUMBER` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CAR_VIN`),
  KEY `FK_Relationship_2` (`INSURANCE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAR`
--

LOCK TABLES `CAR` WRITE;
/*!40000 ALTER TABLE `CAR` DISABLE KEYS */;
INSERT INTO `CAR` VALUES ('81G58X832C7920DIL',1,'Mitsubishi','Raider','TU22575'),('11TP3GS38QYC54DOH',2,'Land Rover','Range Rover','RLE1655'),('71A4WAFN27SC0YB4S',3,'Mazda','B-Series','WQV0486'),('1J9EO9PDJEK4W1394',4,'MINI','Cooper','SRN1609'),('U92P3D4676216SXJ2',5,'GMC','Yukon','QH68690'),('W158N99R38S7FA361',6,'Pontiac','Sunfire','ZL88476'),('13IYC0W1PGJAES355',7,'Toyota','4Runner','RS33807'),('228757O2N6UA3CBP2',8,'GMC','Yukon','GW68707'),('ZO3021NHX7QQ03W77',9,'Toyota','Avalon','OYD3367'),('739QD1F14994I57KY',10,'Infiniti','QX','JC48732'),('BZ9QB038N5PDGF45F',11,'Volkswagen','Corrado','HK27076'),('7H8TAVLE22XVKO8X0',12,'Mitsubishi','Lancer Evolution','RD47772'),('1HED5FJO7K7F532XH',13,'Infiniti','G37','LNY2730'),('EOMULAST2X0UTS9D5',14,'Ford','Mustang','PC59555'),('24X066155NVXWX0H9',15,'Cadillac','Seville','YM49608'),('1ZYC1386S0V9ZDWAI',16,'Pontiac','Grand Prix','VU46692'),('663561EK03ZBT1Y0T',17,'Lotus','Esprit','PH32868'),('8Z01V44F7Z74U3221',18,'Kia','Sephia','IFL2526'),('OO9N06A00J5914W59',19,'Dodge','Grand Caravan','ADQ2671'),('38GQ269A42702VWHG',20,'Dodge','Stratus','HWK6356'),('1W40WB13880UE5W0E',21,'Hyundai','Sonata','NP53888'),('3O1TZG4W6MJS0P2SH',22,'Ford','Expedition','BR94454'),('ZB715Q233ZBX2946F',23,'Cadillac','Sixty Special','OU04547'),('RFBX0FJ14BZ7T26VJ',24,'Audi','Coupe GT','KDE2893'),('880CT0Z766K57I0OU',25,'Plymouth','Neon','YM81972'),('U3EAD6CSQR6AY82GZ',26,'Dodge','Ram Van 3500','FL84244'),('O0M446DI65389RU29',27,'Dodge','Ram','EC80369'),('44CYW25KM08G9L177',28,'BMW','7 Series','AW59733'),('T7W3U36UKGS0QL35F',29,'Volkswagen','Passat','PSE3069'),('21ZULB4XR6DJ5FL17',30,'Chevrolet','Impala','HBD3538');
/*!40000 ALTER TABLE `CAR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAR_REVIEW`
--

DROP TABLE IF EXISTS `CAR_REVIEW`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CAR_REVIEW` (
  `CAR_VIN` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `REVIEW_ID` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `REVIEW_DATE` date DEFAULT NULL,
  `REVIEW_EXPIRE_DATE` date DEFAULT NULL,
  `REVIEW_COMMENTS` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`REVIEW_ID`),
  KEY `FK_Relationship_1` (`CAR_VIN`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAR_REVIEW`
--

LOCK TABLES `CAR_REVIEW` WRITE;
/*!40000 ALTER TABLE `CAR_REVIEW` DISABLE KEYS */;
INSERT INTO `CAR_REVIEW` VALUES ('81G58X832C7920DIL','1','2017-02-26','2018-02-26','Przeglad przebiegl pomyslnie. Brak uwag'),('11TP3GS38QYC54DOH','2','2017-04-13','2018-04-13','Zle skorygowane swiatla. Przeglad uznany za pomyslny.'),('71A4WAFN27SC0YB4S','3','2017-03-21','2018-03-21','Amortyzatory w stanie bardzo slabym, przeglad krotkoterminowy'),('1J9EO9PDJEK4W1394','4','2017-02-20','2018-02-20','Przeglad przebiegl pomyslnie'),('U92P3D4676216SXJ2','5','2017-03-13','2018-03-13','Przeglad przebiegl pomyslnie. Brak uwag'),('W158N99R38S7FA361','6','2017-03-24','2018-03-24','Zle skorygowane swiatla. Przeglad uznany za pomyslny.'),('13IYC0W1PGJAES355','7','2017-03-17','2018-03-17','Amortyzatory w stanie bardzo slabym, przeglad krotkoterminowy'),('228757O2N6UA3CBP2','8','2017-03-19','2018-03-19','Przeglad przebiegl pomyslnie'),('ZO3021NHX7QQ03W77','9','2017-03-16','2018-03-16','Przeglad przebiegl pomyslnie. Brak uwag'),('739QD1F14994I57KY','10','2017-04-06','2018-04-06','Zle skorygowane swiatla. Przeglad uznany za pomyslny.'),('BZ9QB038N5PDGF45F','11','2017-04-08','2018-04-08','Amortyzatory w stanie bardzo slabym, przeglad krotkoterminowy'),('7H8TAVLE22XVKO8X0','12','2017-03-28','2018-03-28','Przeglad przebiegl pomyslnie'),('1HED5FJO7K7F532XH','13','2017-04-08','2018-04-08','Przeglad przebiegl pomyslnie. Brak uwag'),('EOMULAST2X0UTS9D5','14','2017-02-09','2018-02-09','Zle skorygowane swiatla. Przeglad uznany za pomyslny.'),('24X066155NVXWX0H9','15','2017-02-01','2018-02-01','Amortyzatory w stanie bardzo slabym, przeglad krotkoterminowy'),('1ZYC1386S0V9ZDWAI','16','2017-04-09','2018-04-09','Przeglad przebiegl pomyslnie'),('663561EK03ZBT1Y0T','17','2017-04-04','2018-04-04','Wymieniona zarowka kierunkowskazu.'),('8Z01V44F7Z74U3221','18','2017-02-11','2018-02-11','Amortyzatory w stanie bardzo slabym, przeglad krotkoterminowy'),('OO9N06A00J5914W59','19','2017-03-27','2018-03-27','Przeglad przebiegl pomyslnie'),('38GQ269A42702VWHG','20','2017-04-28','2018-04-28','Wymieniona zarowka kierunkowskazu.'),('1W40WB13880UE5W0E','21','2017-03-16','2018-03-16','Zle skorygowane swiatla. Przeglad uznany za pomyslny.'),('3O1TZG4W6MJS0P2SH','22','2017-02-08','2018-02-08','Amortyzatory w stanie bardzo slabym, przeglad krotkoterminowy'),('ZB715Q233ZBX2946F','23','2017-04-22','2018-04-22','Przeglad przebiegl pomyslnie'),('RFBX0FJ14BZ7T26VJ','24','2017-05-03','2018-05-03','Przeglad przebiegl pomyslnie. Brak uwag'),('880CT0Z766K57I0OU','25','2017-03-10','2018-03-10','Zle skorygowane swiatla. Przeglad uznany za pomyslny.'),('U3EAD6CSQR6AY82GZ','26','2017-04-17','2018-04-17','Amortyzatory w stanie bardzo slabym, przeglad krotkoterminowy'),('O0M446DI65389RU29','27','2017-04-01','2018-04-01','Przeglad przebiegl pomyslnie'),('44CYW25KM08G9L177','28','2017-03-18','2018-03-18','Przeglad przebiegl pomyslnie. Brak uwag'),('T7W3U36UKGS0QL35F','29','2017-03-06','2018-03-06','Wymieniona zarowka kierunkowskazu.'),('21ZULB4XR6DJ5FL17','30','2017-04-07','2018-04-07','Zle skorygowane swiatla. Przeglad uznany za pomyslny.');
/*!40000 ALTER TABLE `CAR_REVIEW` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CRIMINAL_RECORDS`
--

DROP TABLE IF EXISTS `CRIMINAL_RECORDS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CRIMINAL_RECORDS` (
  `DRIVER_ID` bigint(20) NOT NULL,
  `record_id` bigint(20) NOT NULL,
  `CR_DICTIONARY_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`record_id`),
  KEY `FK_Relationship_10` (`CR_DICTIONARY_ID`),
  KEY `FK_Relationship_3` (`DRIVER_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CRIMINAL_RECORDS`
--

LOCK TABLES `CRIMINAL_RECORDS` WRITE;
/*!40000 ALTER TABLE `CRIMINAL_RECORDS` DISABLE KEYS */;
INSERT INTO `CRIMINAL_RECORDS` VALUES (1,1,8),(2,2,7),(3,3,3),(4,4,8),(5,5,4),(6,6,5),(7,7,1),(8,8,2),(9,9,4),(10,10,2),(11,11,5),(12,12,2),(13,13,10),(14,14,6),(15,15,4),(16,16,9),(17,17,9),(18,18,4),(19,19,5),(20,20,2),(21,21,6),(22,22,8),(23,23,5),(24,24,9),(25,25,9),(26,26,10),(27,27,10),(28,28,2),(29,29,3),(30,30,4);
/*!40000 ALTER TABLE `CRIMINAL_RECORDS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CRIMINAL_RECORDS_DICTIONARY`
--

DROP TABLE IF EXISTS `CRIMINAL_RECORDS_DICTIONARY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CRIMINAL_RECORDS_DICTIONARY` (
  `CR_DICTIONARY_ID` bigint(20) NOT NULL,
  `CR_DICTIONARY_TYPE` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CR_DICTIONARY_POINTS` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`CR_DICTIONARY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CRIMINAL_RECORDS_DICTIONARY`
--

LOCK TABLES `CRIMINAL_RECORDS_DICTIONARY` WRITE;
/*!40000 ALTER TABLE `CRIMINAL_RECORDS_DICTIONARY` DISABLE KEYS */;
INSERT INTO `CRIMINAL_RECORDS_DICTIONARY` VALUES (1,'Spowodowanie zagrożenia bezpieczeństwa ruchu drogowego – kolizja drogowa',6),(2,'Kierowanie pojazdem mechanicznym w stanie po użyciu alkoholu lub środka podobnie działającego do alkoholu',10),(3,'Kierowanie pojazdem mechanicznym w stanie nietrzeźwości lub będąc pod wpływem środka odurzającego',10),(4,'Wyprzedzanie na przejściach dla pieszych i bezpośrednio przed nimi',10),(5,'Nieustąpienie pierwszeństwa pieszemu znajdującemu się na oznakowanym przejściu',10),(6,'Naruszenie zakazu rozdzielania kolumn pieszych',5),(7,'Niestosowanie się do sygnalow swietlnych',6),(8,'Nieustąpienie pierwszeństwa pieszemu podczas cofania',6),(9,'Nieudzielenie pomocy ofiarom wypadku',10),(10,'Niezastosowanie się, w celu uniknięcia kontroli, do sygnału osoby uprawnionej do kontroli ruchu drogowego, nakazującego zatrzymanie pojazdu',8);
/*!40000 ALTER TABLE `CRIMINAL_RECORDS_DICTIONARY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DRIVER`
--

DROP TABLE IF EXISTS `DRIVER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DRIVER` (
  `DRIVER_ID` bigint(20) NOT NULL,
  `ADDRESS_ID` bigint(20) DEFAULT NULL,
  `LICENSE_ID` bigint(20) DEFAULT NULL,
  `DRIVER_PESEL` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DRIVER_NAME` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DRIVER_SURNAME` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DRIVER_BIRTH_DATE` date DEFAULT NULL,
  PRIMARY KEY (`DRIVER_ID`),
  KEY `FK_Relationship_6` (`LICENSE_ID`),
  KEY `FK_Relationship_9` (`ADDRESS_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DRIVER`
--

LOCK TABLES `DRIVER` WRITE;
/*!40000 ALTER TABLE `DRIVER` DISABLE KEYS */;
INSERT INTO `DRIVER` VALUES (1,1,1,'85033016730','Gerhard','Gierłowski','1985-03-30'),(2,2,2,'85022807819','Sofroniusz','Podleśny','1985-02-28'),(3,3,3,'84052321759','Zbigniew','Bobala','1984-05-23'),(4,4,4,'90021025553','Przemił','Kuznar','1990-02-10'),(5,5,5,'77012014435','Probus','Kunierewicz','1977-01-20'),(6,6,6,'82080212751','Honorat','Macficz','1982-08-02'),(7,7,7,'80061502530','Artur','Wentlak','1980-06-15'),(8,8,8,'84062503699','Tolimir','Studziba','1984-06-25'),(9,9,9,'88082014070','Maurycy','Żmudz','1988-08-20'),(10,10,10,'80080113096','Witomysł','Domojewska','1980-08-01'),(11,11,11,'89052809775','Przybywoj','Kryżka','1989-05-28'),(12,12,12,'90041923037','Święcimir','Joriadu','1990-04-19'),(13,13,13,'79120919556','Herakles','Trizna','1979-12-09'),(14,14,14,'79112311997','Kwiryn','Pizuński','1979-11-23'),(15,15,15,'90102223258','Burchard','Szczerbyk','1990-10-22'),(16,16,16,'78021122234','Waleriusz','Wyranik','1978-02-11'),(17,17,17,'80030809093','Petroniusz','Grączeski','1980-03-08'),(18,18,18,'78011408739','Radogost','Norowiczuk','1978-01-14'),(19,19,19,'92123122293','Karp','Doniziak','1992-12-31'),(20,20,20,'85081403531','Herakliusz','Donagała','1985-08-14'),(21,21,21,'93100802997','Marcin','Wołysz vel Wołczyński','1993-10-08'),(22,22,22,'82111906176','Alan','Siemientko','1982-11-19'),(23,23,23,'87072221557','Otton','Chodasewicz','1987-07-22'),(24,24,24,'93012609439','Witołd','Samukonga','1993-01-26'),(25,25,25,'87111311771','Świętopełk','Hawdzel','1987-11-13'),(26,26,26,'91040413792','Krystian','Barlochowska','1991-04-04'),(27,27,27,'77110719595','Wiktor','Wielonda','1977-11-07'),(28,28,28,'83021111319','Świętobor','Tadeus','1983-02-11'),(29,29,29,'81050111210','Filemon','Sodkowiak','1981-05-01'),(30,30,30,'85112810015','Malkolm','Wrenczak','1985-11-28');
/*!40000 ALTER TABLE `DRIVER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DRIVER_CAR_REL`
--

DROP TABLE IF EXISTS `DRIVER_CAR_REL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DRIVER_CAR_REL` (
  `DRIVER_ID` bigint(20) NOT NULL,
  `CAR_VIN` varchar(17) NOT NULL,
  KEY `FK_Relationship_4` (`CAR_VIN`),
  KEY `FK_Relationship_5` (`DRIVER_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DRIVER_CAR_REL`
--

LOCK TABLES `DRIVER_CAR_REL` WRITE;
/*!40000 ALTER TABLE `DRIVER_CAR_REL` DISABLE KEYS */;
INSERT INTO `DRIVER_CAR_REL` VALUES (1,'81G58X832C7920DIL'),(2,'11TP3GS38QYC54DOH'),(3,'71A4WAFN27SC0YB4S'),(4,'1J9EO9PDJEK4W1394'),(5,'U92P3D4676216SXJ2'),(6,'W158N99R38S7FA361'),(7,'13IYC0W1PGJAES355'),(8,'228757O2N6UA3CBP2'),(9,'ZO3021NHX7QQ03W77'),(10,'739QD1F14994I57KY'),(11,'BZ9QB038N5PDGF45F'),(12,'7H8TAVLE22XVKO8X0'),(13,'1HED5FJO7K7F532XH'),(14,'EOMULAST2X0UTS9D5'),(15,'24X066155NVXWX0H9'),(16,'1ZYC1386S0V9ZDWAI'),(17,'663561EK03ZBT1Y0T'),(18,'8Z01V44F7Z74U3221'),(19,'OO9N06A00J5914W59'),(20,'38GQ269A42702VWHG'),(21,'1W40WB13880UE5W0E'),(22,'3O1TZG4W6MJS0P2SH'),(23,'ZB715Q233ZBX2946F'),(24,'RFBX0FJ14BZ7T26VJ'),(25,'880CT0Z766K57I0OU'),(26,'U3EAD6CSQR6AY82GZ'),(27,'O0M446DI65389RU29'),(28,'44CYW25KM08G9L177'),(29,'T7W3U36UKGS0QL35F'),(30,'21ZULB4XR6DJ5FL17');
/*!40000 ALTER TABLE `DRIVER_CAR_REL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DRIVING_LICENSE`
--

DROP TABLE IF EXISTS `DRIVING_LICENSE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DRIVING_LICENSE` (
  `LICENSE_ID` bigint(20) NOT NULL,
  `EXPIRE_DATE` date DEFAULT NULL,
  `ISSUE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`LICENSE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DRIVING_LICENSE`
--

LOCK TABLES `DRIVING_LICENSE` WRITE;
/*!40000 ALTER TABLE `DRIVING_LICENSE` DISABLE KEYS */;
INSERT INTO `DRIVING_LICENSE` VALUES (1,'2020-08-21','2005-08-21'),(2,'2019-04-06','2004-04-06'),(3,'2020-04-02','2005-04-02'),(4,'2020-08-05','2005-08-05'),(5,'2021-05-17','2006-05-17'),(6,'2019-07-06','2004-07-06'),(7,'2020-02-25','2005-02-25'),(8,'2021-12-22','2006-12-22'),(9,'2020-03-12','2005-03-12'),(10,'2021-02-28','2006-02-28'),(11,'2022-10-28','2007-10-28'),(12,'2020-12-15','2005-12-15'),(13,'2021-03-10','2006-03-10'),(14,'2020-12-03','2005-12-03'),(15,'2021-08-30','2006-08-30'),(16,'2021-05-05','2006-05-05'),(17,'2020-01-03','2005-01-03'),(18,'2023-03-05','2008-03-05'),(19,'2019-06-22','2004-06-22'),(20,'2020-04-16','2005-04-16'),(21,'2020-12-09','2005-12-09'),(22,'2021-08-06','2006-08-06'),(23,'2021-01-11','2006-01-11'),(24,'2020-10-29','2005-10-29'),(25,'2021-09-22','2006-09-22'),(26,'2021-01-14','2006-01-14'),(27,'2019-08-27','2004-08-27'),(28,'2022-02-14','2007-02-14'),(29,'2020-02-28','2005-02-28'),(30,'2021-03-12','2006-03-12');
/*!40000 ALTER TABLE `DRIVING_LICENSE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DRIVING_LICENSE_CATEGORY_REL`
--

DROP TABLE IF EXISTS `DRIVING_LICENSE_CATEGORY_REL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DRIVING_LICENSE_CATEGORY_REL` (
  `LICENSE_ID` bigint(20) NOT NULL,
  `CATEGORY_ID` bigint(20) NOT NULL,
  KEY `FK_Relationship_7` (`LICENSE_ID`),
  KEY `FK_Relationship_8` (`CATEGORY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DRIVING_LICENSE_CATEGORY_REL`
--

LOCK TABLES `DRIVING_LICENSE_CATEGORY_REL` WRITE;
/*!40000 ALTER TABLE `DRIVING_LICENSE_CATEGORY_REL` DISABLE KEYS */;
INSERT INTO `DRIVING_LICENSE_CATEGORY_REL` VALUES (1,5),(2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5),(9,5),(10,5),(11,5),(12,5),(13,5),(14,5),(15,5),(16,5),(17,5),(18,5),(19,5),(20,5),(21,5),(22,5),(23,5),(24,5),(25,5),(26,5),(27,5),(28,5),(29,5),(30,5),(1,1),(2,2),(3,3),(4,4),(5,6),(6,7),(7,8),(8,9),(9,10),(10,1),(11,2),(12,3),(13,4),(14,6),(15,7),(16,8),(17,9),(18,10),(19,1),(20,2),(21,3),(22,4),(23,6),(24,7),(25,8),(26,9),(27,10),(28,1),(29,2),(30,3);
/*!40000 ALTER TABLE `DRIVING_LICENSE_CATEGORY_REL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INSURANCE`
--

DROP TABLE IF EXISTS `INSURANCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INSURANCE` (
  `INSURANCE_ID` bigint(20) NOT NULL,
  `INSURANCE_BEGIN_DATE` date DEFAULT NULL,
  `INSURANCE_EXPIRE_DATE` date DEFAULT NULL,
  `INSURANCE_TYPE` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`INSURANCE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INSURANCE`
--

LOCK TABLES `INSURANCE` WRITE;
/*!40000 ALTER TABLE `INSURANCE` DISABLE KEYS */;
INSERT INTO `INSURANCE` VALUES (1,'2017-03-15','2018-03-15','Pełne ubezpieczenie'),(2,'2017-03-15','2018-03-15','Pełne ubezpieczenie'),(3,'2017-01-25','2018-01-25','Podstawowe ubezpieczenie + 26 lat wzwyż'),(4,'2017-01-11','2018-01-11','Podstawowe ubezpieczenie'),(5,'2017-01-05','2018-01-05','Pełne ubezpieczenie + AC'),(6,'2017-02-27','2018-02-27','Podstawowe ubezpieczenie + NWW'),(7,'2017-02-16','2018-02-16','Pełne ubezpieczenie'),(8,'2017-02-18','2018-02-18','Pełne ubezpieczenie'),(9,'2017-03-17','2018-03-17','Podstawowe ubezpieczenie + 26 lat wzwyż'),(10,'2017-01-05','2018-01-05','Podstawowe ubezpieczenie'),(11,'2017-03-11','2018-03-11','Pełne ubezpieczenie + AC'),(12,'2017-03-15','2018-03-15','Podstawowe ubezpieczenie + NWW'),(13,'2017-02-14','2018-02-14','Pełne ubezpieczenie'),(14,'2017-02-15','2018-02-15','Pełne ubezpieczenie'),(15,'2017-01-10','2018-01-10','Podstawowe ubezpieczenie + 26 lat wzwyż'),(16,'2017-01-31','2018-01-31','Podstawowe ubezpieczenie'),(17,'2017-02-13','2018-02-13','Pełne ubezpieczenie + AC'),(18,'2017-03-15','2018-03-15','Podstawowe ubezpieczenie + NWW'),(19,'2017-03-17','2018-03-17','Pełne ubezpieczenie'),(20,'2017-02-16','2018-02-16','Pełne ubezpieczenie'),(21,'2017-01-13','2018-01-13','Podstawowe ubezpieczenie + 26 lat wzwyż'),(22,'2017-02-17','2018-02-17','Podstawowe ubezpieczenie'),(23,'2017-02-16','2018-02-16','Pełne ubezpieczenie + AC'),(24,'2017-01-16','2018-01-16','Podstawowe ubezpieczenie + NWW'),(25,'2017-01-29','2018-01-29','Pełne ubezpieczenie'),(26,'2017-02-04','2018-02-04','Pełne ubezpieczenie'),(27,'2017-02-09','2018-02-09','Podstawowe ubezpieczenie + 26 lat wzwyż'),(28,'2017-02-07','2018-02-07','Podstawowe ubezpieczenie'),(29,'2017-01-22','2018-01-22','Pełne ubezpieczenie + AC'),(30,'2017-03-06','2018-03-06','Podstawowe ubezpieczenie + NWW');
/*!40000 ALTER TABLE `INSURANCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LICENSE_CATEGORY`
--

DROP TABLE IF EXISTS `LICENSE_CATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LICENSE_CATEGORY` (
  `CATEGORY_ID` bigint(20) NOT NULL,
  `CATEGORY_TYPE` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CATEGORY_DESCRIPTION` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LICENSE_CATEGORY`
--

LOCK TABLES `LICENSE_CATEGORY` WRITE;
/*!40000 ALTER TABLE `LICENSE_CATEGORY` DISABLE KEYS */;
INSERT INTO `LICENSE_CATEGORY` VALUES (1,'A1','UPRAWNIA DO KIEROWANIA:\nmotocyklem o pojemności skokowej silnika nieprzekraczającej 125 cm3, mocy nieprzekraczającej 11 kW i stosunku mocy do masy własnej nieprzekraczającym 0,1 kW/kg,\nmotocyklem trójkołowym o mocy nieprzekraczającej 15 kW'),(2,'A2','UPRAWNIA DO KIEROWANIA:\nmotocyklem o mocy nieprzekraczającej 35 kW i stosunku mocy do masy własnej nieprzekraczającym 0,2 kW/kg, przy czym nie może on powstać w wyniku wprowadzenia zmian w pojeździe o mocy przekraczającej dwukrotność mocy tego motocykla,\nmotocyklem trójkołowym o mocy nieprzekraczającej 15 kW,'),(3,'A','UPRAWNIA DO KIEROWANIA:\nmotocyklem (motocykl - pojazd samochodowy jednośladowy lub z bocznym wózkiem – wielośladowy) oraz motocyklem z przyczepą motocyklową o masie nieprzekraczającej masy własnej motocykla i 100 kg. Wymagany wiek do uzyskania kategorii A to 24 lata 24 lata albo 20 lat, jeżeli kandydat co najmniej od 2 lat posiada prawo jazdy kategorii A2, ale do prowadzenia motocykli trójkołowych o mocy przekraczającej 15 kW konieczne jest i tak ukończenie 21 roku życia;'),(4,'B','UPRAWNIA DO KIEROWANIA:\npojazdem samochodowym o dopuszczalnej masie całkowitej (dmc) nieprzekraczającej 3,5 tony (z wyjątkiem motocykla lub autobusu);\npojazdem samochodowym o dmc nieprzekraczającej 3,5 tony wraz z przyczepą lekką (do 750kg DMC);\npojazdem samochodowym o dmc nieprzekraczającej 3,5 tony wraz z przyczepą inną niż lekka pod warunkiem, że dopuszczalna masa całkowita zespołu pojazdów nie przekracza 4250 kg a kierowca zdał dodatkowy egzamin praktyczny potwierdzony wpisem do prawa jazdy'),(5,'B+E','UPRAWNIA DO KIEROWANIA:\n\nzespołem pojazdów składającym się z pojazdu określonego w kategorii B (dmc do 3,5 tony) oraz przyczepy, której rzeczywista masa całkowita nie przekracza rzeczywistej masy całkowitej pojazdu ciągnącego;\nzespołem pojazdów złożonym z ciągnika rolniczego z przyczepą (przyczepami) lub pojazdu wolnobieżnego z przyczepą (przyczepami) (tylko na terytorium RP);'),(6,'C',' UPRAWNIA DO KIEROWANIA:\n\npojazdem samochodowym o dopuszczalnej masie całkowitej przekraczającej 3,5 t, z wyjątkiem autobusu\npojazdami określonymi dla prawa jazdy kategorii AM;\nciągnikiem rolniczym, pojazdem wolnobieżnym oraz zespołem złożonym z tego pojazdu i przyczepy lekkiej (do 750kg dmc) (tylko na terytorium RP).'),(7,'C+E','UPRAWNIA DO KIEROWANIA:\n\npojazdem samochodowym o dopuszczalnej masie całkowitej przekraczającej 3,5t łącznie z przyczepą\nzespołem pojazdów złożonym z ciągnika rolniczego z przyczepą (przyczepami) lub pojazdu wolnobieżnego z przyczepą (przyczepami) (tylko na terytorium RP).'),(8,'C1',' UPRAWNIA DO KIEROWANIA:\n\npojazdem samochodowym o dopuszczalnej masie całkowitej przekraczającej 3,5 t i nieprzekraczającej 7,5 t, z wyjątkiem autobusu;\nzespołem pojazdów składającym się z pojazdu ciągnącego określonego w kategorii C1 i przyczepy której dopuszczalna masa całkowita nie przekracza 750 kg;\npojazdami określonymi dla prawa jazdy kategorii AM;\nciągnikiem rolniczym, pojazdem wolnobieżnym oraz zespołem złożonym z tego pojazdu i przyczepy lekkiej (do 750kg DMC) (tylko na terytorium RP).'),(9,'C1+E','UPRAWNIA DO KIEROWANIA:\n\nzespołem pojazdów o dopuszczalnej masie całkowitej nieprzekraczającej 12 t, składającym się z pojazdu ciągnącego określonego w kategorii C1 i przyczepy o dopuszczalnej masie całkowitej nieprzekraczającej masy własnej pojazdu ciągnącego;\nzespołem pojazdów złożonym z ciągnika rolniczego z przyczepą (przyczepami) lub pojazdu wolnobieżnego z przyczepą (przyczepami) (tylko na terytorium RP).'),(10,'D','UPRAWNIA DO KIEROWANIA:\n\nautobusem;\nzespołem pojazdów złożonym z autobusu oraz z przyczepy lekkiej (do 750kg DMC);\npojazdami określonymi dla prawa jazdy kategorii AM;\nciągnikiem rolniczym, pojazdem wolnobieżnym oraz zespołem złożonym z tego pojazdu i przyczepy lekkiej (do 750kg dmc) (tylko na terytorium RP).');
/*!40000 ALTER TABLE `LICENSE_CATEGORY` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-18 13:29:24
