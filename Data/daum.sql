-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: daum
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `daumlist`
--

DROP TABLE IF EXISTS `daumlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `daumlist` (
  `rank` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daumlist`
--

LOCK TABLES `daumlist` WRITE;
/*!40000 ALTER TABLE `daumlist` DISABLE KEYS */;
INSERT INTO `daumlist` VALUES (1,'블랙 위도우'),(2,'발신제한'),(3,'크루엘라'),(4,'콰이어트 플레이스 2'),(5,'랑종'),(6,'루카'),(7,'킬러의 보디가드 2'),(8,'미드나이트'),(9,'BIFAN2021 판타스틱 단편 걸작선 1'),(10,'괴기맨숀'),(11,'컨저링3: 악마가 시켰다'),(12,'인 더 하이츠'),(13,'빛나는 순간'),(14,'체르노빌 1986'),(15,'이번엔 잘 되겠지');
/*!40000 ALTER TABLE `daumlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie2019`
--

DROP TABLE IF EXISTS `movie2019`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie2019` (
  `rank` int(11) NOT NULL,
  `rating` text,
  `title` varchar(100) DEFAULT NULL,
  `reviews` int(11) DEFAULT NULL,
  PRIMARY KEY (`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie2019`
--

LOCK TABLES `movie2019` WRITE;
/*!40000 ALTER TABLE `movie2019` DISABLE KEYS */;
INSERT INTO `movie2019` VALUES (1,' 98%','Parasite (Gisaengchung) ',459),(2,' 94%','Avengers: Endgame ',542),(3,' 97%','Knives Out ',464),(4,' 93%','Us ',551),(5,' 97%','Toy Story 4 ',451),(6,' 95%','The Irishman ',452),(7,' 95%','Little Women ',421),(8,' 96%','Booksmart ',372),(9,' 97%','The Farewell ',342),(10,' 95%','A Beautiful Day in the Neighborhood ',370),(11,' 94%','Marriage Story ',388),(12,' 95%','If Beale Street Could Talk ',360),(13,' 85%','Once Upon a Time In Hollywood ',565),(14,' 90%','Spider-Man: Far From Home ',448),(15,' 96%','Pain and Glory (Dolor y gloria) ',296),(16,' 90%','Shazam! ',410),(17,' 92%','Ford v Ferrari ',349),(18,' 97%','Dolemite Is My Name ',232),(19,' 99%','Apollo 11 ',186),(20,' 90%','The Lighthouse ',381),(21,' 89%','Rocketman ',388),(22,' 91%','Uncut Gems ',340),(23,' 99%','Amazing Grace ',160),(24,' 99%','They Shall Not Grow Old ',154),(25,' 99%','Ash Is Purest White ',153),(26,' 100%','Honeyland ',124),(27,' 89%','John Wick: Chapter 3 - Parabellum ',349),(28,' 94%','Honey Boy ',231),(29,' 100%','One Cut of the Dead (Kamera o tomeru na!) ',90),(30,' 93%','Fighting with My Family ',241),(31,' 94%','The Peanut Butter Falcon ',218),(32,' 99%','Knock Down the House ',104),(33,' 79%','Captain Marvel ',538),(34,' 96%','Birds of Passage (Pájaros de verano) ',167),(35,' 98%','Maiden ',118),(36,' 87%','Hustlers ',351),(37,' 98%','One Child Nation ',100),(38,' 98%','For Sama ',98),(39,' 98%','3 Faces ',98),(40,' 100%','Chained for Life ',52),(41,' 97%','First Love (Hatsukoi) ',117),(42,' 97%','Woman at War (Kona fer í stríð) ',117),(43,' 90%','How to Train Your Dragon: The Hidden World ',269),(44,' 100%','White Riot ',49),(45,' 94%','Transit ',179),(46,' 99%','The Chambermaid (La camarista) ',70),(47,' 97%','Tigers Are Not Afraid (Vuelven) ',113),(48,' 100%','Midnight Traveler ',47),(49,' 92%','Stan & Ollie ',221),(50,' 88%','Ready or Not ',308),(51,' 95%','Atlantics ',154),(52,' 100%','Mickey and the Bear ',45),(53,' 98%','Deadwood: The Movie ',88),(54,' 98%','Varda by Agnès ',88),(55,' 100%','Scream, Queen! My Nightmare on Elm Street ',43),(56,' 96%','Hail Satan? ',130),(57,' 100%','Changing the Game ',40),(58,' 98%','The Heiresses (Las Herederas) ',80),(59,' 97%','Toni Morrison: The Pieces I Am ',100),(60,' 92%','The Last Black Man in San Francisco ',206),(61,' 83%','Midsommar ',395),(62,' 95%','The Mustang ',133),(63,' 92%','Wild Rose ',194),(64,' 89%','Blinded by the Light ',258),(65,' 94%','Bad Education ',148),(66,' 83%','Ad Astra ',387),(67,' 98%','63 Up ',56),(68,' 98%','Homecoming: A Film by Beyoncé ',55),(69,' 98%','Too Late to Die Young (Tarde para morir joven) ',55),(70,' 91%','Gloria Bell ',205),(71,' 96%','By the Grace of God (Grâce à Dieu) ',96),(72,' 97%','Midnight Family ',72),(73,' 98%','Buñuel in the Labyrinth of the Turtles (Buñuel en el laberinto de las tortugas) ',49),(74,' 98%','Fiddler: A Miracle of Miracles ',47),(75,' 96%','American Factory ',90),(76,' 98%','Dirty God ',45),(77,' 97%','Making Waves: The Art of Cinematic Sound ',66),(78,' 98%','I\'m No Longer Here (Ya no estoy aquí) ',43),(79,' 98%','Working Woman ',43),(80,' 97%','The Cave ',63),(81,' 97%','The Kingmaker ',62),(82,' 96%','I Lost My Body ',83),(83,' 97%','Harpoon ',61),(84,' 97%','Love, Antosha ',61),(85,' 95%','Little Woods ',96),(86,' 80%','Jojo Rabbit ',422),(87,' 89%','Dark Waters ',226),(88,' 96%','The Amusement Park ',71),(89,' 89%','The Two Popes ',223),(90,' 95%','Mike Wallace Is Here ',91),(91,' 96%','Ray & Liz ',69),(92,' 95%','Be Natural: The Untold Story of Alice Guy-Blaché ',86),(93,' 92%','Monos ',150),(94,' 94%','Shadow ',102),(95,' 96%','Rojo ',53),(96,' 91%','In Fabric ',160),(97,' 96%','An Elephant Sitting Still (Da xiang xi di er zuo) ',50),(98,' 96%','It Must Be Heaven ',49),(99,' 95%','The Mortuary Collection ',66),(100,' 91%','Clemency ',150);
/*!40000 ALTER TABLE `movie2019` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-13 17:54:40
