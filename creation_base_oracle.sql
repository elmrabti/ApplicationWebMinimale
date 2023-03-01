CREATE SEQUENCE personne_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE personne (
  id NUMBER(11) DEFAULT personne_seq.NEXTVAL NOT NULL,
  prenom VARCHAR2(20) NOT NULL,
  nom VARCHAR2(20) NOT NULL,
  CONSTRAINT pk_personne PRIMARY KEY (id)
);

CREATE SEQUENCE adresse_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE adresse (
  id NUMBER(11) DEFAULT adresse_seq.NEXTVAL NOT NULL,
  rue NUMBER(11) NOT NULL,
  ville VARCHAR2(20) NOT NULL,
  CONSTRAINT adresse_pk PRIMARY KEY (id)
);


CREATE TABLE adresse_personne (
  id_adresse NUMBER(11) NOT NULL,
  id_personne NUMBER(11) NOT NULL,
  PRIMARY KEY (id_personne, id_adresse),
  CONSTRAINT FK_adresse_personne_adresse FOREIGN KEY (id_adresse) REFERENCES adresse (id),
  CONSTRAINT FK_adresse_personne_personne FOREIGN KEY (id_personne) REFERENCES personne (id)
);