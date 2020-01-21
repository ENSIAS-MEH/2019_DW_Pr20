-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 21 jan. 2020 à 13:04
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `sang`
--
CREATE DATABASE IF NOT EXISTS `sang` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sang`;

-- --------------------------------------------------------

--
-- Structure de la table `alertebesoin`
--

DROP TABLE IF EXISTS `alertebesoin`;
CREATE TABLE IF NOT EXISTS `alertebesoin` (
  `idAlert` int(11) NOT NULL AUTO_INCREMENT,
  `idBS` int(11) NOT NULL,
  `idGS` int(11) NOT NULL,
  `dateAlerte` int(11) NOT NULL,
  `descriptionAlerte` text NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`idAlert`,`idBS`,`idGS`),
  KEY `idBS` (`idBS`),
  KEY `idGS` (`idGS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `banquesange`
--

DROP TABLE IF EXISTS `banquesange`;
CREATE TABLE IF NOT EXISTS `banquesange` (
  `idBS` int(11) NOT NULL AUTO_INCREMENT,
  `nomBS` varchar(50) NOT NULL,
  `emailBS` varchar(50) NOT NULL,
  `telBS` varchar(20) NOT NULL,
  `passwordBS` varchar(20) NOT NULL,
  `adressBS` varchar(80) NOT NULL,
  `idVille` int(11) NOT NULL,
  PRIMARY KEY (`idBS`),
  KEY `idVille` (`idVille`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `convoi`
--

DROP TABLE IF EXISTS `convoi`;
CREATE TABLE IF NOT EXISTS `convoi` (
  `idConvoi` int(11) NOT NULL AUTO_INCREMENT,
  `titreConvoi` varchar(50) NOT NULL,
  `desciption` text NOT NULL,
  `idBS` int(11) NOT NULL,
  PRIMARY KEY (`idConvoi`),
  KEY `idBS` (`idBS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `donnateur`
--

DROP TABLE IF EXISTS `donnateur`;
CREATE TABLE IF NOT EXISTS `donnateur` (
  `idDonnateur` int(11) NOT NULL AUTO_INCREMENT,
  `cin` varchar(20) NOT NULL,
  `nomD` varchar(50) NOT NULL,
  `prenomD` varchar(50) NOT NULL,
  `teleD` varchar(20) NOT NULL,
  `emailD` varchar(80) NOT NULL,
  `passwordD` varchar(20) NOT NULL,
  `idVille` int(11) NOT NULL,
  `idGS` int(11) NOT NULL,
  PRIMARY KEY (`idDonnateur`),
  KEY `idGS` (`idGS`),
  KEY `idVille` (`idVille`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `donnation`
--

DROP TABLE IF EXISTS `donnation`;
CREATE TABLE IF NOT EXISTS `donnation` (
  `idDonnateur` int(11) NOT NULL,
  `idBS` int(11) NOT NULL,
  `dateDonnation` date NOT NULL,
  PRIMARY KEY (`idDonnateur`,`idBS`),
  KEY `idBS` (`idBS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `groupesangin`
--

DROP TABLE IF EXISTS `groupesangin`;
CREATE TABLE IF NOT EXISTS `groupesangin` (
  `idGS` int(11) NOT NULL AUTO_INCREMENT,
  `nomGS` varchar(4) NOT NULL,
  PRIMARY KEY (`idGS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

DROP TABLE IF EXISTS `planning`;
CREATE TABLE IF NOT EXISTS `planning` (
  `idConvoi` int(11) NOT NULL,
  `idVille` int(11) NOT NULL,
  `dateConvoi` date NOT NULL,
  PRIMARY KEY (`idConvoi`,`idVille`),
  KEY `idVille` (`idVille`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `stocksang`
--

DROP TABLE IF EXISTS `stocksang`;
CREATE TABLE IF NOT EXISTS `stocksang` (
  `idBS` int(11) NOT NULL,
  `idGS` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`idBS`,`idGS`),
  KEY `idGS` (`idGS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE IF NOT EXISTS `ville` (
  `idVille` int(11) NOT NULL AUTO_INCREMENT,
  `nomVille` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idVille`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `alertebesoin`
--
ALTER TABLE `alertebesoin`
  ADD CONSTRAINT `alertebesoin_ibfk_1` FOREIGN KEY (`idBS`) REFERENCES `banquesange` (`idBS`),
  ADD CONSTRAINT `alertebesoin_ibfk_2` FOREIGN KEY (`idGS`) REFERENCES `groupesangin` (`idGS`);

--
-- Contraintes pour la table `banquesange`
--
ALTER TABLE `banquesange`
  ADD CONSTRAINT `banquesange_ibfk_1` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Contraintes pour la table `convoi`
--
ALTER TABLE `convoi`
  ADD CONSTRAINT `convoi_ibfk_1` FOREIGN KEY (`idBS`) REFERENCES `banquesange` (`idBS`);

--
-- Contraintes pour la table `donnateur`
--
ALTER TABLE `donnateur`
  ADD CONSTRAINT `donnateur_ibfk_1` FOREIGN KEY (`idGS`) REFERENCES `groupesangin` (`idGS`),
  ADD CONSTRAINT `donnateur_ibfk_2` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Contraintes pour la table `donnation`
--
ALTER TABLE `donnation`
  ADD CONSTRAINT `donnation_ibfk_1` FOREIGN KEY (`idDonnateur`) REFERENCES `donnateur` (`idDonnateur`),
  ADD CONSTRAINT `donnation_ibfk_2` FOREIGN KEY (`idBS`) REFERENCES `banquesange` (`idBS`);

--
-- Contraintes pour la table `planning`
--
ALTER TABLE `planning`
  ADD CONSTRAINT `planning_ibfk_1` FOREIGN KEY (`idConvoi`) REFERENCES `convoi` (`idConvoi`),
  ADD CONSTRAINT `planning_ibfk_2` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Contraintes pour la table `stocksang`
--
ALTER TABLE `stocksang`
  ADD CONSTRAINT `stocksang_ibfk_1` FOREIGN KEY (`idBS`) REFERENCES `banquesange` (`idBS`),
  ADD CONSTRAINT `stocksang_ibfk_2` FOREIGN KEY (`idGS`) REFERENCES `groupesangin` (`idGS`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
