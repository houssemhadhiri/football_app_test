CREATE DATABASE equipe_db;

USE equipe_db;

CREATE TABLE equipe (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    acronym VARCHAR(10) NOT NULL,
    budget DOUBLE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE joueur (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    position VARCHAR(50) NOT NULL,
    equipe_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT FK_team FOREIGN KEY (equipe_id) REFERENCES equipe(id)
);
INSERT INTO equipe (name, acronym, budget) VALUES ('Nice', 'OGCN', 1000000.00);
INSERT INTO joueur (name, position, equipe_id) VALUES ('Player 1', 'Forward', 1);
INSERT INTO joueur (name, position, equipe_id) VALUES ('Player 2', 'Midfielder', 1);