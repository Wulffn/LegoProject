-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema recipe
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema lego
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lego
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lego` DEFAULT CHARACTER SET utf8 ;
USE `lego` ;

-- -----------------------------------------------------
-- Table `lego`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lego`.`users` (
  `idUser` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `customerEmail_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lego`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lego`.`orders` (
  `orderId` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  PRIMARY KEY (`orderId`, `userId`),
  CONSTRAINT `fk_orders_customers`
    FOREIGN KEY (`userId`)
    REFERENCES `lego`.`users` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lego`.`orderDetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lego`.`orderDetails` (
  `orderId` INT(11) NOT NULL,
  `houseLength` INT(11) NULL DEFAULT NULL,
  `houseWidth` INT(11) NULL DEFAULT NULL,
  `houseHeight` INT(11) NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT 'Waiting',
  PRIMARY KEY (`orderId`),
  CONSTRAINT `fk_orderDetails_orders1`
    FOREIGN KEY (`orderId`)
    REFERENCES `lego`.`orders` (`orderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
