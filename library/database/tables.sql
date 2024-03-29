CREATE SCHEMA IF NOT EXISTS `library` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `library`;

-- -----------------------------------------------------
-- Table `user_role`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `user_role` (
  `user_role_id` INT NOT NULL ,
  `user_role` VARCHAR(30) NOT NULL ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`user_role_id`) );

CREATE UNIQUE INDEX `user_role_uk` ON `user_role` (`user_role` ASC) ;


-- -----------------------------------------------------
-- Table `contact`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `contact` (
  `contact_id` INT NOT NULL ,
  `first_name` VARCHAR(30) NOT NULL ,
  `last_name` VARCHAR(30) NULL ,
  `alias` VARCHAR(45) NULL ,
  `street_address` VARCHAR(45) NOT NULL ,
  `city` VARCHAR(30) NOT NULL ,
  `state` VARCHAR(30) NOT NULL ,
  `country` VARCHAR(30) NULL ,
  `contact_home` BIGINT NOT NULL ,
  `contact_cell` BIGINT NULL ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`contact_id`) );

CREATE UNIQUE INDEX `contact_uk` ON `contact` (`first_name` ASC, `last_name` ASC, `alias` ASC) ;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `user` (
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
    REFERENCES `user_role` (`user_role_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_fk1`
    FOREIGN KEY (`contact_id` )
    REFERENCES `contact` (`contact_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE UNIQUE INDEX `user_uk` ON `user` (`contact_id` ASC) ;

CREATE INDEX `user_fk` ON `user` (`user_role_id` ASC) ;

CREATE INDEX `user_fk1` ON `user` (`contact_id` ASC) ;


-- -----------------------------------------------------
-- Table `account_type`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `account_type` (
  `account_type_id` INT NOT NULL ,
  `account_type` VARCHAR(30) NOT NULL ,
  `max_borrow_limit_nb` INT NULL ,
  `registration_fee` DECIMAL(5,2) NOT NULL,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`account_type_id`) );

CREATE UNIQUE INDEX `account_type_uk` ON `account_type` (`account_type` ASC) ;

-- ---------------------------------------------------------
-- Table `fee`
-- ---------------------------------------------------------
DROP TABLE IF EXISTS `fee`;
CREATE TABLE `fee` (
  `fee_id` int NOT NULL,
  `amount` decimal(5,2) NOT NULL,
  `fee_type` varchar(30),
  `paid` char(1) NOT NULL DEFAULT 'n',
  `payment_method` varchar(50) DEFAULT 'cash',
  `updated_by` varchar(30) DEFAULT NULL,
  `updated_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`fee_id`));

CREATE INDEX `fee_fk` ON `fee` (`fee_id` ASC) ;

-- -----------------------------------------------------
-- Table `account`
-- -----------------------------------------------------
CREATE TABLE  IF NOT EXISTS `account` (
  `account_id` int NOT NULL,
  `account_nb` bigint unsigned NOT NULL,
  `contact_id` int NOT NULL,
  `start_datetime` datetime NOT NULL,
  `end_datetime` datetime DEFAULT NULL,
  `account_type_id` int NOT NULL,
  `active_flag` char(1) NOT NULL DEFAULT 'y',
  `fee_id` int NOT NULL,
  `updated_by` varchar(30) NOT NULL,
  `updated_datetime` datetime NOT NULL,
  PRIMARY KEY (`account_id`),
  CONSTRAINT `account_fk` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `account_fk1` FOREIGN KEY (`account_type_id`) REFERENCES `account_type` (`account_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `account_fk2` FOREIGN KEY (`fee_id`) REFERENCES `fee` (`fee_id`) ON UPDATE NO ACTION
);

CREATE UNIQUE INDEX `account_uk` ON `account` (`account_nb` ASC, `start_datetime` ASC) ;

CREATE INDEX `account_fk` ON `account` (`contact_id` ASC) ;

CREATE INDEX `account_fk1` ON `account` (`account_type_id` ASC) ;


-- -----------------------------------------------------
-- Table `media_type`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `media_type` (
  `media_type_id` INT NOT NULL ,
  `media_type` VARCHAR(30) NOT NULL ,
  `description` VARCHAR(60) NULL ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`media_type_id`) );

CREATE UNIQUE INDEX `media_type_uk` ON `media_type` (`media_type` ASC) ;


-- -----------------------------------------------------
-- Table `media_category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `media_category` (
  `media_category_id` INT NOT NULL ,
  `category` VARCHAR(30) NOT NULL ,
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`media_category_id`) );

CREATE UNIQUE INDEX `media_category_uk` ON `media_category` (`category` ASC) ;


-- -----------------------------------------------------
-- Table `media`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `media` (
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
    REFERENCES `media_type` (`media_type_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `media_fk1`
    FOREIGN KEY (`media_category_id` )
    REFERENCES `media_category` (`media_category_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX `media_fk` ON `media` (`media_type_id` ASC) ;

CREATE UNIQUE INDEX `media_uk` ON `media` (`title` ASC, `media_category_id` ASC, `volume_nb` ASC) ;

CREATE INDEX `media_fk1` ON `media` (`media_category_id` ASC) ;


-- -----------------------------------------------------
-- Table `media_lending`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `media_lending` (
  `media_lending_id` INT NOT NULL ,
  `media_id` INT NOT NULL ,
  `account_id` INT NOT NULL ,
  `lending_datetime` DATETIME NOT NULL ,
  `return_datetime` DATETIME NULL ,
  `actual_return_datetime` DATETIME NULL ,
  `fee_id` int(11),
  `updated_by` VARCHAR(30) NOT NULL ,
  `updated_datetime` DATETIME NOT NULL ,
  PRIMARY KEY (`media_lending_id`) ,
  CONSTRAINT `media_lending_fk`
    FOREIGN KEY (`account_id` )
    REFERENCES `account` (`account_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `media_lending_fk1`
    FOREIGN KEY (`media_id` )
    REFERENCES `media` (`media_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `media_lending_fk2` 
  	FOREIGN KEY (`fee_id`) 
  	REFERENCES `fee` (`fee_id`) 
  	ON UPDATE NO ACTION   
);

CREATE INDEX `media_lending_fk` ON `media_lending` (`account_id` ASC) ;

CREATE INDEX `media_lending_fk1` ON `media_lending` (`media_id` ASC) ;

CREATE INDEX `media_lending_fk2` ON `media_lending` (`fee_id` ASC) ;

CREATE UNIQUE INDEX `media_lending_uk` ON `media_lending` (`media_id` ASC, `account_id` ASC, `lending_datetime` ASC) ;
