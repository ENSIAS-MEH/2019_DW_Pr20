-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 22 jan. 2020 à 17:25
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

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

-- --------------------------------------------------------

--
-- Structure de la table `alertebesoin`
--

DROP TABLE IF EXISTS `alertebesoin`;
CREATE TABLE IF NOT EXISTS `alertebesoin` (
  `idAlerte` int(11) NOT NULL AUTO_INCREMENT,
  `idBS` int(11) NOT NULL,
  `idGS` int(11) NOT NULL,
  `dateAlerte` timestamp NOT NULL,
  `descriptionAlerte` text NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idAlerte`,`idBS`,`idGS`),
  KEY `idBS` (`idBS`),
  KEY `idGS` (`idGS`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `alertebesoin`
--

INSERT INTO `alertebesoin` (`idAlerte`, `idBS`, `idGS`, `dateAlerte`, `descriptionAlerte`, `enable`) VALUES
(1, 1, 7, '2020-01-08 09:02:07', 'description alerte 1', 1),
(3, 2, 8, '2020-01-15 11:02:08', 'description alerte 3', 0),
(4, 1, 8, '2020-01-15 10:02:08', 'dessssssssssssssssssc 4', 1),
(5, 2, 4, '2020-01-22 16:02:08', 'description alerte 5', 1);

-- --------------------------------------------------------

--
-- Structure de la table `banquesang`
--

DROP TABLE IF EXISTS `banquesang`;
CREATE TABLE IF NOT EXISTS `banquesang` (
  `idBS` int(11) NOT NULL AUTO_INCREMENT,
  `nomBS` varchar(50) NOT NULL,
  `emailBS` varchar(50) NOT NULL,
  `telBS` varchar(20) NOT NULL,
  `passwordBS` varchar(20) NOT NULL,
  `adressBS` varchar(80) NOT NULL,
  `idVille` int(11) NOT NULL,
  PRIMARY KEY (`idBS`),
  KEY `idVille` (`idVille`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `banquesang`
--

INSERT INTO `banquesang` (`idBS`, `nomBS`, `emailBS`, `telBS`, `passwordBS`, `adressBS`, `idVille`) VALUES
(1, 'nom BS 1', 'bs1@gmail.com', '0610203040', 'bs1', 'adresse bs1', 1),
(2, 'nom bs 2', 'bs2@gmail.com', '0650607080', 'bs2', 'adresse bs2', 2);

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `groupesangin`
--

INSERT INTO `groupesangin` (`idGS`, `nomGS`) VALUES
(1, 'A+'),
(2, 'A-'),
(3, 'B+'),
(4, 'B-'),
(5, 'AB+'),
(6, 'AB-'),
(7, 'O+'),
(8, 'O-');

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

DROP TABLE IF EXISTS `planning`;
CREATE TABLE IF NOT EXISTS `planning` (
  `idConvoi` int(11) NOT NULL,
  `idVille` int(11) NOT NULL,
  `dateConvoi_debut` date NOT NULL,
  `dateConvoi_fin` date NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ville`
--

INSERT INTO `ville` (`idVille`, `nomVille`) VALUES
(1, 'Casablanca'),
(2, 'Rabat'),
(3, 'Tanger'),
(4, 'Fes');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `alertebesoin`
--
ALTER TABLE `alertebesoin`
  ADD CONSTRAINT `alertebesoin_ibfk_1` FOREIGN KEY (`idBS`) REFERENCES `banquesang` (`idBS`),
  ADD CONSTRAINT `alertebesoin_ibfk_2` FOREIGN KEY (`idGS`) REFERENCES `groupesangin` (`idGS`);

--
-- Contraintes pour la table `banquesang`
--
ALTER TABLE `banquesang`
  ADD CONSTRAINT `banquesang_ibfk_1` FOREIGN KEY (`idVille`) REFERENCES `ville` (`idVille`);

--
-- Contraintes pour la table `convoi`
--
ALTER TABLE `convoi`
  ADD CONSTRAINT `convoi_ibfk_1` FOREIGN KEY (`idBS`) REFERENCES `banquesang` (`idBS`);

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
  ADD CONSTRAINT `donnation_ibfk_2` FOREIGN KEY (`idBS`) REFERENCES `banquesang` (`idBS`);

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
  ADD CONSTRAINT `stocksang_ibfk_1` FOREIGN KEY (`idBS`) REFERENCES `banquesang` (`idBS`),
  ADD CONSTRAINT `stocksang_ibfk_2` FOREIGN KEY (`idGS`) REFERENCES `groupesangin` (`idGS`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
