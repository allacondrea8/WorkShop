create database workshop_db;
use workshop_db;


CREATE TABLE artisans (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    spécialité VARCHAR(100) NOT NULL
);

CREATE TABLE ateliers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    description VARCHAR(1000),
    artisan_id BIGINT,
    FOREIGN KEY (artisan_id) REFERENCES artisans(id)
);

CREATE TABLE participants (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE réservations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dateHeure DATETIME NOT NULL,
    statut ENUM('CONFIRMÉE', 'ANNULÉE') NOT NULL,
    participant_id BIGINT,
    atelier_id BIGINT,
    FOREIGN KEY (participant_id) REFERENCES participants(id),
    FOREIGN KEY (atelier_id) REFERENCES ateliers(id)
);


-- Insérer des artisans
INSERT INTO artisans (nom, email, spécialité) VALUES ('Artisan 1', 'artisan1@example.com', 'Céramique');
INSERT INTO artisans (nom, email, spécialité) VALUES ('Artisan 2', 'artisan2@example.com', 'Vitrail');

-- Insérer des ateliers
INSERT INTO ateliers (nom, description, artisan_id) VALUES ('Atelier de Céramique', 'Apprenez à fabriquer de la céramique.', (SELECT id FROM artisans WHERE email='artisan1@example.com'));
INSERT INTO ateliers (nom, description, artisan_id) VALUES ('Atelier de Vitrail', 'Créez votre propre vitrail.', (SELECT id FROM artisans WHERE email='artisan2@example.com'));

-- Insérer des participants
INSERT INTO participants (nom, email) VALUES ('Participant 1', 'participant1@example.com');
INSERT INTO participants (nom, email) VALUES ('Participant 2', 'participant2@example.com');

-- Insérer des réservations
INSERT INTO réservations (dateHeure, statut, participant_id, atelier_id) VALUES 
('2023-01-01 10:00:00', 'CONFIRMÉE', (SELECT id FROM participants WHERE email='participant1@example.com'), (SELECT id FROM ateliers WHERE nom='Atelier de Céramique')),
('2023-01-02 10:00:00', 'CONFIRMÉE', (SELECT id FROM participants WHERE email='participant2@example.com'), (SELECT id FROM ateliers WHERE nom='Atelier de Vitrail'));

ALTER TABLE `réservations` RENAME TO `reservations`;