-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mar. 22 fév. 2022 à 16:35
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tracker1`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(2, 'testadmin', '123456');

-- --------------------------------------------------------

--
-- Structure de la table `position`
--

CREATE TABLE `position` (
  `id` int(11) NOT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `idTracker` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `position`
--

INSERT INTO `position` (`id`, `latitude`, `longitude`, `date`, `idTracker`) VALUES
(5, 12.36, 36.25, '2021-05-10', 4),
(6, 96.25, 14.25, '2021-06-12', 5),
(8, 96.25222569, 14.252222563987, '2021-07-12', 6),
(10, 8883, 22223, '2021-08-08', 10),
(11, 12.36, 36.25, '2021-05-10', 12),
(12, 5555, 6666, '2021-12-05', 4);

-- --------------------------------------------------------

--
-- Structure de la table `tracker`
--

CREATE TABLE `tracker` (
  `id` int(11) NOT NULL,
  `simNumber` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tracker`
--

INSERT INTO `tracker` (`id`, `simNumber`) VALUES
(4, '133333333'),
(5, '06138874'),
(6, '9874563'),
(7, '8963'),
(10, 'Sh1325689'),
(11, '89637'),
(12, '07669165'),
(13, '123654789');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id` int(11) NOT NULL,
  `matricule` varchar(20) DEFAULT NULL,
  `marque` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`id`, `matricule`, `marque`, `type`) VALUES
(2, '698', 'nissan', 'moto'),
(5, '123', 'Mercedes', 'G63'),
(6, '3659', 'Toyota', 'V8'),
(8, '256987', 'Lamborgini', 'aventador'),
(9, '1452874', 'Skoda', 'oktavia'),
(11, '888', 'safari', 'moto'),
(12, 'kawazaki', 'z1000', 'moto');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule_tracker`
--

CREATE TABLE `vehicule_tracker` (
  `id` int(11) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `vehicule` int(11) DEFAULT NULL,
  `tracker` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vehicule_tracker`
--

INSERT INTO `vehicule_tracker` (`id`, `date_debut`, `date_fin`, `vehicule`, `tracker`) VALUES
(3, '2021-12-15', '2021-12-31', 2, 4),
(6, '2021-12-24', '2021-12-31', 2, 7),
(8, '1999-05-16', '2021-12-16', 11, 12),
(9, '2020-08-05', '2021-12-31', 6, 4),
(10, '2020-08-05', '2021-12-31', 6, 4),
(11, '2021-12-04', '2021-12-07', 12, 13);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk` (`idTracker`);

--
-- Index pour la table `tracker`
--
ALTER TABLE `tracker`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vehicule_tracker`
--
ALTER TABLE `vehicule_tracker`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_V` (`vehicule`),
  ADD KEY `fk_T` (`tracker`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `position`
--
ALTER TABLE `position`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `tracker`
--
ALTER TABLE `tracker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `vehicule_tracker`
--
ALTER TABLE `vehicule_tracker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `position`
--
ALTER TABLE `position`
  ADD CONSTRAINT `fk` FOREIGN KEY (`idTracker`) REFERENCES `tracker` (`id`);

--
-- Contraintes pour la table `vehicule_tracker`
--
ALTER TABLE `vehicule_tracker`
  ADD CONSTRAINT `fk_T` FOREIGN KEY (`tracker`) REFERENCES `tracker` (`id`),
  ADD CONSTRAINT `fk_V` FOREIGN KEY (`vehicule`) REFERENCES `vehicule` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
