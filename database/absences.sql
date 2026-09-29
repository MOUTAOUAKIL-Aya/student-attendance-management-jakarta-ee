DROP DATABASE IF EXISTS absences;
CREATE DATABASE absences DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE absences;

CREATE TABLE etudiants (
  id INT PRIMARY KEY,
  nom VARCHAR(50) NOT NULL,
  prenom VARCHAR(50) NOT NULL,
  tel VARCHAR(20),
  email VARCHAR(100),
  niveau VARCHAR(30),
  groupe VARCHAR(30)
);

CREATE TABLE matieres (
  id INT PRIMARY KEY,
  nom_matiere VARCHAR(80) NOT NULL,
  prof_matiere VARCHAR(80) NOT NULL
);

CREATE TABLE absences (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_etudiant INT NOT NULL,
  mois INT NOT NULL,
  jour INT NOT NULL,
  heure INT NOT NULL,
  duree INT NOT NULL,
  id_matiere INT NOT NULL,
  CONSTRAINT fk_abs_etudiant FOREIGN KEY(id_etudiant) REFERENCES etudiants(id),
  CONSTRAINT fk_abs_matiere FOREIGN KEY(id_matiere) REFERENCES matieres(id)
);

INSERT INTO etudiants VALUES
(1,'Alami','Youssef','0600000001','youssef.alami@mail.com','2IIR','G1'),
(2,'Benali','Sara','0600000002','sara.benali@mail.com','2IIR','G1'),
(3,'El Fassi','Omar','0600000003','omar.elfassi@mail.com','2IIR','G2'),
(4,'Naciri','Imane','0600000004','imane.naciri@mail.com','2IIR','G2'),
(5,'Alaoui','Hamza','0600000005','hamza.alaoui@mail.com','3IIR','G1'),
(6,'Berrada','Salma','0600000006','salma.berrada@mail.com','3IIR','G1'),
(7,'Tazi','Mehdi','0600000007','mehdi.tazi@mail.com','3IIR','G2'),
(8,'Idrissi','Aya','0600000008','aya.idrissi@mail.com','3IIR','G2'),
(9,'Kabbaj','Anas','0600000009','anas.kabbaj@mail.com','4IIR','G1'),
(10,'Zerouali','Lina','0600000010','lina.zerouali@mail.com','4IIR','G1');

INSERT INTO matieres VALUES
(1,'Jakarta EE','Pr. Amrani'),
(2,'Bases de donnees','Pr. Bennis'),
(3,'UML','Pr. Raji'),
(4,'Reseaux','Pr. Karim'),
(5,'Java avance','Pr. Saidi');

-- 2 absences par matière = 10 absences
INSERT INTO absences(id_etudiant, mois, jour, heure, duree, id_matiere) VALUES
(1,5,3,8,2,1),(2,5,10,10,2,1),
(3,5,4,8,2,2),(4,5,11,14,3,2),
(5,4,5,10,2,3),(6,4,12,8,2,3),
(7,5,6,14,2,4),(8,5,13,16,2,4),
(9,6,7,8,2,5),(10,6,14,10,2,5);
