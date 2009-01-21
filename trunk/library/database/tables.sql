SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `krishna` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `krishna`;

-- -----------------------------------------------------
-- Table `krishna`.`user_role`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `krishna`.`user_role` (
  `user_role_id` INT NOT NULL ,
  `user_role` VARCHAR(30) NOT NULL ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`user_role_id`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `user_role_uk` ON `krishna`.`user_role` (`user_role` ASC) ;


-- -----------------------------------------------------
-- Table `krishna`.`contact`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `krishna`.`contact` (
  `contact_id` INT NOT NULL ,
  `first_name` VARCHAR(30) NOT NULL ,
  `last_name` VARCHAR(30) NULL ,
  `alias` VARCHAR(45) NULL ,
  `street_address` VARCHAR(45) NULL ,
  `city` VARCHAR(30) NULL ,
  `state` VARCHAR(30) NULL ,
  `country` VARCHAR(30) NULL ,
  `contact_home` BIGINT NOT NULL ,
  `contact_cell` BIGINT NULL ,
  `updated_by` VARCHAR(30) NULL ,
  `updated_datetime` DATETIME NULL ,
  PRIMARY KEY (`contact_id`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `contact_uk` ON `krishna`.`contact` (`first_name` ASC, `last_name` ASC, `alias` ASC) ;


-- -----------------------------------------------------
-- Table `krishna`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `krishna`.`user` (
  `user_id` INT NOT NULL ,
  `user_name` VARCHAR(30) NOT NULL ,
  `contact_id` INT NOT NULL ,
  `password` VARCHAR(30) NOT NULL ,
  `user_role_id` INT NOT NULL ,
  `active_flag` CHAR(1) NOT NULL DEFAULT 'y' ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`user_id`) ,
  CONSTRAINT `user_fk`
    FOREIGN KEY (`user_role_id` )
    REFERENCES `krishna`.`user_role` (`user_role_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_fk1`
    FOREIGN KEY (`contact_id` )
    REFERENCES `krishna`.`contact` (`contact_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'users of the system';

CREATE UNIQUE INDEX `user_uk` ON `krishna`.`user` (`contact_id` ASC) ;

CREATE INDEX `user_fk` ON `krishna`.`user` (`user_role_id` ASC) ;

CREATE INDEX `user_fk1` ON `krishna`.`user` (`contact_id` ASC) ;


-- -----------------------------------------------------
-- Table `krishna`.`account_type`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `krishna`.`account_type` (
  `account_type_id` INT NOT NULL ,
  `account_type` VARCHAR(30) NOT NULL ,
  `max_borrow_limit_nb` INT NULL ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`account_type_id`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `account_type_uk` ON `krishna`.`account_type` (`account_type` ASC) ;


-- -----------------------------------------------------
-- Table `krishna`.`account`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `krishna`.`account` (
  `account_id` INT NOT NULL ,
  `account_nb` INT NOT NULL ,
  `contact_id` INT NOT NULL ,
  `start_datetime` DATETIME NOT NULL ,
  `end_datetime` DATETIME NULL ,
  `account_type_id` INT NOT NULL ,
  `active_flag` CHAR(1) NOT NULL DEFAULT 'y' ,
  `updated_by` VARCHAR(30) NULL ,
  `updated_datetime` DATETIME NULL ,
  PRIMARY KEY (`account_id`) ,
  CONSTRAINT `account_fk`
    FOREIGN KEY (`contact_id` )
    REFERENCES `krishna`.`contact` (`contact_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `account_fk1`
    FOREIGN KEY (`account_type_id` )
    REFERENCES `krishna`.`account_type` (`account_type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `account_uk` ON `krishna`.`account` (`account_nb` ASC, `start_datetime` ASC) ;

CREATE INDEX `account_fk` ON `krishna`.`account` (`contact_id` ASC) ;

CREATE INDEX `account_fk1` ON `krishna`.`account` (`account_type_id` ASC) ;


-- -----------------------------------------------------
-- Table `krishna`.`media_type`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `krishna`.`media_type` (
  `media_type_id` INT NOT NULL ,
  `media_type` VARCHAR(30) NOT NULL ,
  `description` VARCHAR(60) NULL ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`media_type_id`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `media_type_uk` ON `krishna`.`media_type` (`media_type` ASC) ;


-- -----------------------------------------------------
-- Table `krishna`.`media_category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `krishna`.`media_category` (
  `media_category_id` INT NOT NULL ,
  `category` VARCHAR(30) NOT NULL ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`media_category_id`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `media_category_uk` ON `krishna`.`media_category` (`category` ASC) ;


-- -----------------------------------------------------
-- Table `krishna`.`media`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `krishna`.`media` (
  `media_id` INT NOT NULL ,
  `title` VARCHAR(45) NOT NULL ,
  `media_type_id` INT NOT NULL ,
  `media_category_id` INT NOT NULL ,
  `volume_nb` INT NULL ,
  `total_volumes_nb` INT NULL ,
  `copies_nb` INT NULL ,
  `description` VARCHAR(60) NULL ,
  `location` VARCHAR(30) NULL ,
  `author` VARCHAR(45) NOT NULL ,
  `company` VARCHAR(45) NULL ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`media_id`) ,
  CONSTRAINT `media_fk`
    FOREIGN KEY (`media_type_id` )
    REFERENCES `krishna`.`media_type` (`media_type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `media_fk1`
    FOREIGN KEY (`media_category_id` )
    REFERENCES `krishna`.`media_category` (`media_category_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `media_fk` ON `krishna`.`media` (`media_type_id` ASC) ;

CREATE UNIQUE INDEX `media_uk` ON `krishna`.`media` (`title` ASC, `media_category_id` ASC) ;

CREATE INDEX `media_fk1` ON `krishna`.`media` (`media_category_id` ASC) ;


-- -----------------------------------------------------
-- Table `krishna`.`media_lending`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `krishna`.`media_lending` (
  `media_lending_id` INT NOT NULL ,
  `media_id` INT NOT NULL ,
  `account_id` INT NOT NULL ,
  `lending_datetime` DATETIME NOT NULL ,
  `return_datetime` DATETIME NULL ,
  `actual_return_datetime` DATETIME NOT NULL ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`media_lending_id`) ,
  CONSTRAINT `media_lending_fk`
    FOREIGN KEY (`account_id` )
    REFERENCES `krishna`.`account` (`account_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `media_lending_fk1`
    FOREIGN KEY (`media_id` )
    REFERENCES `krishna`.`media` (`media_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `media_lending_fk` ON `krishna`.`media_lending` (`account_id` ASC) ;

CREATE INDEX `media_lending_fk1` ON `krishna`.`media_lending` (`media_id` ASC) ;

CREATE UNIQUE INDEX `media_lending_uk` ON `krishna`.`media_lending` (`media_id` ASC, `account_id` ASC, `lending_datetime` ASC) ;
	


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
