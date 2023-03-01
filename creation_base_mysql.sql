CREATE TABLE IF NOT EXISTS 'adresse' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'rue' int(11) NOT NULL,
  'ville' varchar(20) NOT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;


CREATE TABLE adresse (
  id int(11) NOT NULL,
  rue int(11) NOT NULL,
  ville varchar(20) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO 'adresse' ('id', 'rue', 'ville') VALUES
	(9, 18, 'rabat'),
	(10, 8, 'Fes'),
	(11, 11, 'Marakech'),
	(12, 8, 'Tanger');



CREATE TABLE IF NOT EXISTS 'adresse_personne' (
  'id_adresse' int(11) NOT NULL,
  'id_personne' int(11) NOT NULL,
  PRIMARY KEY ('id_personne','id_adresse'),
  KEY 'id_adresse_id_personne' ('id_adresse','id_personne'),
  CONSTRAINT 'FK_adresse_personne_adresse' FOREIGN KEY ('id_adresse') REFERENCES 'adresse' ('id'),
  CONSTRAINT 'FK_adresse_personne_personne' FOREIGN KEY ('id_personne') REFERENCES 'personne' ('id')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO 'adresse_personne' ('id_adresse', 'id_personne') VALUES
	(9, 8),
	(12, 8),
	(10, 9),
	(11, 9);



CREATE TABLE IF NOT EXISTS 'personne' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'prenom' varchar(20) NOT NULL DEFAULT '',
  'nom' varchar(20) NOT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;


INSERT INTO 'personne' ('id', 'prenom', 'nom') VALUES
	(8, 'Zinedine', 'Benali'),
	(9, 'hamza', 'elmrabti'),
	(10, 'Zineb', 'Tazi');