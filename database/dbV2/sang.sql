-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2020 at 01:05 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sang`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(2) NOT NULL,
  `emailAdmin` varchar(256) DEFAULT NULL,
  `passwordAdmin` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `alertebesoin`
--

CREATE TABLE `alertebesoin` (
  `idAlerte` int(11) NOT NULL,
  `idBS` int(11) NOT NULL,
  `idGS` int(11) NOT NULL,
  `dateAlerte` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `descriptionAlerte` text NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `alertebesoin`
--

INSERT INTO `alertebesoin` (`idAlerte`, `idBS`, `idGS`, `dateAlerte`, `descriptionAlerte`, `enable`) VALUES
(1, 1, 7, '2020-01-08 09:02:07', 'description alerte 1', 1),
(3, 2, 8, '2020-01-15 11:02:08', 'description alerte 3', 0),
(4, 1, 8, '2020-01-15 10:02:08', 'dessssssssssssssssssc 4', 1),
(5, 2, 4, '2020-01-22 16:02:08', 'description alerte 5', 1);

-- --------------------------------------------------------

--
-- Table structure for table `banquesang`
--

CREATE TABLE `banquesang` (
  `idBS` int(11) NOT NULL,
  `nomBS` varchar(50) NOT NULL,
  `emailBS` varchar(50) NOT NULL,
  `teleBS` varchar(20) NOT NULL,
  `passwordBS` varchar(20) NOT NULL,
  `adresseBS` varchar(80) NOT NULL,
  `idVille` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `banquesang`
--

INSERT INTO `banquesang` (`idBS`, `nomBS`, `emailBS`, `teleBS`, `passwordBS`, `adresseBS`, `idVille`) VALUES
(1, 'banque103', 'email@gmail.com', '0616161616', '123', 'hay salam', 1),
(2, 'banque2', 'banq1@gmail.com', '0321121212', '78954', 'hay nour', 2),
(3, 'Ta7alil', 'email@gmail.com', '021544521', '12311', 'rabat agdal ', 2),
(4, 'Mokhtabar', 'email@email.com', '021202120', '12512', 'Ibn btouta', 1);

-- --------------------------------------------------------

--
-- Table structure for table `convoi`
--

CREATE TABLE `convoi` (
  `idConvoi` int(11) NOT NULL,
  `titreConvoi` varchar(50) NOT NULL,
  `desciption` text NOT NULL,
  `idBS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `donnateur`
--

CREATE TABLE `donnateur` (
  `idDonnateur` int(11) NOT NULL,
  `cin` varchar(20) NOT NULL,
  `nomD` varchar(50) NOT NULL,
  `prenomD` varchar(50) NOT NULL,
  `teleD` varchar(20) NOT NULL,
  `emailD` varchar(80) NOT NULL,
  `passwordD` varchar(20) NOT NULL,
  `idVille` int(11) NOT NULL,
  `idGS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `donnateur`
--

INSERT INTO `donnateur` (`idDonnateur`, `cin`, `nomD`, `prenomD`, `teleD`, `emailD`, `passwordD`, `idVille`, `idGS`) VALUES
(1, 'LB202020', 'Mejdaoui', 'Soufiane', '0612451245', 'soufiane@email.com', 'azerty', 4, 7),
(2, 'A121212', 'El Yossr', 'Mohamed Amine', '061213212', 'amin@emial.com', 'azerty', 5, 8),
(3, 'K121212', 'Oussama', 'Mossati', '0631121212', 'oussama@email.com', 'azerty', 6, 3),
(4, 'T321212', 'EL MEhdi', 'Zouhair', '0621353636', 'zouhair@email.com', 'azerty', 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `donnation`
--

CREATE TABLE `donnation` (
  `idDonnateur` int(11) NOT NULL,
  `idBS` int(11) NOT NULL,
  `dateDonnation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `groupesangin`
--

CREATE TABLE `groupesangin` (
  `idGS` int(11) NOT NULL,
  `nomGS` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groupesangin`
--

INSERT INTO `groupesangin` (`idGS`, `nomGS`) VALUES
(1, 'A-'),
(2, 'A+'),
(3, 'B+'),
(4, 'B-'),
(5, 'AB+'),
(6, 'AB-'),
(7, 'O+'),
(8, 'O-');

-- --------------------------------------------------------

--
-- Table structure for table `planning`
--

CREATE TABLE `planning` (
  `idConvoi` int(11) NOT NULL,
  `idVille` int(11) NOT NULL,
  `dateConvoi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `stocksang`
--

CREATE TABLE `stocksang` (
  `idBS` int(11) NOT NULL,
  `idGS` int(11) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stocksang`
--

INSERT INTO `stocksang` (`idBS`, `idGS`, `quantite`) VALUES
(2, 1, 2),
(2, 7, 11),
(4, 1, 10);

-- --------------------------------------------------------

--
-- Table structure for table `ville`
--

CREATE TABLE `ville` (
  `idVille` int(11) NOT NULL,
  `nomVille` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ville`
--

INSERT INTO `ville` (`idVille`, `nomVille`) VALUES
(1, 'tanger'),
(2, 'rabat'),
(3, 'Taza'),
(4, 'Ksar el kebir'),
(5, 'Casablanca'),
(6, 'Mohmmadia'),
(7, 'Fes'),
(8, 'El Jadida');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indexes for table `alertebesoin`
--
ALTER TABLE `alertebesoin`
  ADD PRIMARY KEY (`idAlerte`,`idBS`,`idGS`),
  ADD KEY `idBS` (`idBS`),
  ADD KEY `idGS` (`idGS`);

--
-- Indexes for table `banquesang`
--
ALTER TABLE `banquesang`
  ADD PRIMARY KEY (`idBS`),
  ADD KEY `idVille` (`idVille`);

--
-- Indexes for table `convoi`
--
ALTER TABLE `convoi`
  ADD PRIMARY KEY (`idConvoi`),
  ADD KEY `idBS` (`idBS`);

--
-- Indexes for table `donnateur`
--
ALTER TABLE `donnateur`
  ADD PRIMARY KEY (`idDonnateur`),
  ADD KEY `idGS` (`idGS`),
  ADD KEY `idVille` (`idVille`);

--
-- Indexes for table `donnation`
--
ALTER TABLE `donnation`
  ADD PRIMARY KEY (`idDonnateur`,`idBS`),
  ADD KEY `idBS` (`idBS`);

--
-- Indexes for table `groupesangin`
--
ALTER TABLE `groupesangin`
  ADD PRIMARY KEY (`idGS`);

--
-- Indexes for table `planning`
--
ALTER TABLE `planning`
  ADD PRIMARY KEY (`idConvoi`,`idVille`),
  ADD KEY `idVille` (`idVille`);

--
-- Indexes for table `stocksang`
--
ALTER TABLE `stocksang`
  ADD PRIMARY KEY (`idBS`,`idGS`),
  ADD KEY `idGS` (`idGS`);

--
-- Indexes for table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`idVille`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alertebesoin`
--
ALTER TABLE `alertebesoin`
  MODIFY `idAlerte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `banquesang`
--
ALTER TABLE `banquesang`
  MODIFY `idBS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `convoi`
--
ALTER TABLE `convoi`
  MODIFY `idConvoi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `donnateur`
--
ALTER TABLE `donnateur`
  MODIFY `idDonnateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `groupesangin`
--
ALTER TABLE `groupesangin`
  MODIFY `idGS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `ville`
--
ALTER TABLE `ville`
  MODIFY `idVille` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `banquesang`
--
ALTER TABLE `banquesang`
  ADD CONSTRAINT `banquesang_ibfk_1` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Constraints for table `convoi`
--
ALTER TABLE `convoi`
  ADD CONSTRAINT `convoi_ibfk_1` FOREIGN KEY (`idBS`) REFERENCES `banquesang` (`idBS`);

--
-- Constraints for table `donnateur`
--
ALTER TABLE `donnateur`
  ADD CONSTRAINT `donnateur_ibfk_1` FOREIGN KEY (`idGS`) REFERENCES `groupesangin` (`idGS`),
  ADD CONSTRAINT `donnateur_ibfk_2` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Constraints for table `donnation`
--
ALTER TABLE `donnation`
  ADD CONSTRAINT `donnation_ibfk_1` FOREIGN KEY (`idDonnateur`) REFERENCES `donnateur` (`idDonnateur`),
  ADD CONSTRAINT `donnation_ibfk_2` FOREIGN KEY (`idBS`) REFERENCES `banquesang` (`idBS`);

--
-- Constraints for table `planning`
--
ALTER TABLE `planning`
  ADD CONSTRAINT `planning_ibfk_1` FOREIGN KEY (`idConvoi`) REFERENCES `convoi` (`idConvoi`),
  ADD CONSTRAINT `planning_ibfk_2` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Constraints for table `stocksang`
--
ALTER TABLE `stocksang`
  ADD CONSTRAINT `stocksang_ibfk_1` FOREIGN KEY (`idBS`) REFERENCES `banquesang` (`idBS`),
  ADD CONSTRAINT `stocksang_ibfk_2` FOREIGN KEY (`idGS`) REFERENCES `groupesangin` (`idGS`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
