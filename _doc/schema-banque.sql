--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `adresse` varchar(200) DEFAULT NULL,
  `codepostal` varchar(30) DEFAULT NULL,
  `ville` varchar(200) DEFAULT NULL,
  `motdepasse` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `adresse`, `codepostal`, `ville`, `motdepasse`) VALUES
(1, 'DUPONT', 'Robert', '40 rue de la Paix', '75000', 'Paris', 'password'),
(2, 'DRUAND', 'Bruno', 'Place de Bretagne', '35000', 'Rennes', 'password'),
(3, 'DUBOIS', 'Stéphane', 'Butte Sainte Anne', '44100', 'Nantes', 'bidon'),
(4, 'DUPORT', 'Sylvie', '138 rue des Rivières', '85000', 'La Roche sur Yon', '123456');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `numero` int(11) NOT NULL,
  `solde` decimal(15,2) DEFAULT NULL,
  `idclient` int(11) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `fk_client_idx` (`idclient`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`numero`, `solde`, `idclient`) VALUES
(245646786, '8400.00', 1),
(263434345, '20000.00', 1),
(85691253, '-899.00', 2);

-- --------------------------------------------------------

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `fk_client` FOREIGN KEY (`idclient`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
