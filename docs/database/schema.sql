DROP DATABASE IF EXISTS server_db;
CREATE DATABASE server_db;
CREATE USER IF NOT EXISTS 'playwithus'@'localhost' IDENTIFIED BY 'playwithus';
GRANT ALL PRIVILEGES ON server_db.* TO 'playwithus'@'localhost';

USE server_db;

CREATE TABLE IF NOT EXISTS `Users` (
  `UserId` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(32),
  `Surname` VARCHAR(32),
  `Email` VARCHAR(64) NOT NULL UNIQUE,
  `Password` VARCHAR(64) NOT NULL,
  `Phone` VARCHAR(20) UNIQUE,
  `Role` VARCHAR(20) NOT NULL,
  PRIMARY KEY(`UserId`)
);

CREATE TABLE IF NOT EXISTS `Playgrounds` (
  `PlaygroundId` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL UNIQUE,
  `InDoor` BOOLEAN NOT NULL,
  PRIMARY KEY(`PlaygroundId`)
);    

CREATE TABLE IF NOT EXISTS `Addresses` (
  `AddressId` BIGINT NOT NULL AUTO_INCREMENT,
  `PlaygroundId` BIGINT NOT NULL,
  `Country` VARCHAR(63),
  `City` VARCHAR(63),
  `ZipCode` MEDIUMINT,
  `Street` VARCHAR(255),
  `Latitude` DOUBLE,
  `Longitude` DOUBLE,
  PRIMARY KEY (`AddressId`),
  FOREIGN KEY (`PlaygroundId`)
    REFERENCES Playgrounds(PlaygroundId)
);

CREATE TABLE IF NOT EXISTS `Games` (
  `GameId` BIGINT NOT NULL AUTO_INCREMENT,
  `PlaygroundId` BIGINT NOT NULL,
  `UserId` BIGINT NOT NULL,
  `Name` VARCHAR(255),
  `Price` INTEGER,
  `Slots` INTEGER NOT NULL,
  `Start` DateTime,
  `Length` INTEGER NOT NULL,
  PRIMARY KEY(`GameId`),
  FOREIGN KEY(`PlaygroundId`)
    REFERENCES Playgrounds(`PlaygroundId`),
  FOREIGN KEY(`UserId`)
    REFERENCES Users(`UserId`)
);