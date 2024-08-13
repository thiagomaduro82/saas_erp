-- DESCRIBE THE PERMISSIONS TABLE
CREATE TABLE PERMISSIONS (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UUID CHAR(13) NOT NULL UNIQUE,
    NAME VARCHAR(127) NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- DESCRIBE THE ROLES TABLE
CREATE TABLE ROLES (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UUID CHAR(13) NOT NULL UNIQUE,
    NAME VARCHAR(127) NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- DESCRIBE THE ROLE_PERMISSIONS TABLE
CREATE TABLE ROLE_PERMISSIONS (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ROLE_ID BIGINT UNSIGNED NOT NULL,
    PERMISSION_ID BIGINT UNSIGNED NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT `ROLE_PERMISSIONS_ROLES_FK` FOREIGN KEY (`ROLE_ID`) REFERENCES `ROLES` (`ID`) ON DELETE CASCADE,
    CONSTRAINT `ROLE_PERMISSIONS_PERMISSIONS_FK` FOREIGN KEY (`PERMISSION_ID`) REFERENCES `PERMISSIONS` (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- DESCRIBE THE USERS TABLE
CREATE TABLE USERS (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UUID CHAR(13) NOT NULL UNIQUE,
    NAME VARCHAR(127) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL UNIQUE,
    PASSWORD VARCHAR(255) NOT NULL,
    ROLE_ID BIGINT UNSIGNED NOT NULL,
    ACTIVE BOOLEAN,
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT `USERS_ROLES_FK` FOREIGN KEY (`ROLE_ID`) REFERENCES `ROLES` (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- DESCRIBE THE CONTACT_TYPES TABLE
CREATE TABLE CONTACT_TYPES (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UUID CHAR(13) NOT NULL UNIQUE,
    NAME VARCHAR(127) NOT NULL,
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- DESCRIBE THE COUNTRY TABLE
CREATE TABLE COUNTRIES (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UUID CHAR(13) NOT NULL UNIQUE,
    NAME VARCHAR(127) NOT NULL,
    CODE CHAR(2) NOT NULL,
    CURRENCY CHAR(3) NOT NULL,
    LOCALE CHAR(5) NOT NULL,
    STATE_REQUIRED BOOLEAN DEFAULT TRUE, 
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- DESCRIBE THE TIMEZONE TABLE
CREATE TABLE TIMEZONES (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UUID CHAR(13) NOT NULL UNIQUE,
    COUNTRY_ID BIGINT UNSIGNED NOT NULL, 
    NAME VARCHAR(255) NOT NULL,
    UTC_OFFSET INTEGER, 
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
    CONSTRAINT `TIMEZONE_COUNTRIES_FK` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `COUNTRIES` (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- DESCRIBE THE MERCHANTS TABLE
CREATE TABLE MERCHANTS (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UUID CHAR(13) NOT NULL UNIQUE, 
    NAME VARCHAR(127) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL UNIQUE,
    COUNTRY_ID BIGINT UNSIGNED NOT NULL, 
    TIMEZONE_ID BIGINT UNSIGNED NOT NULL, 
    VERIFIED BOOLEAN DEFAULT FALSE, 
    BLOCKED BOOLEAN DEFAULT FALSE, 
    ACTIVED BOOLEAN DEFAULT FALSE, 
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
    CONSTRAINT `MERCHANTS_COUNTRIES_FK` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `COUNTRIES` (`ID`), 
    CONSTRAINT `MERCHANTS_TIMEZONES_FK` FOREIGN KEY (`TIMEZONE_ID`) REFERENCES `TIMEZONES` (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- DESCRIBE THE MERCHANT_ADDRESSES TABLE
CREATE TABLE MERCHANT_ADDRESSES (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UUID CHAR(13) NOT NULL UNIQUE,
    MERCHANT_ID BIGINT UNSIGNED NOT NULL,
    DESCRIPTION VARCHAR(127) NOT NULL, 
    ADDRESS_1 VARCHAR(127) NOT NULL, 
    ADDRESS_2 VARCHAR(127), 
    ADDRESS_3 VARCHAR(127),
    COUNTY VARCHAR(127) NOT NULL, 
    CITY VARCHAR(127) NOT NULL, 
    ZIP_CODE VARCHAR(15) NOT NULL, 
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
    CONSTRAINT `MERCHANT_ADDRESSES_MERCHANTS_FK` FOREIGN KEY (`MERCHANT_ID`) REFERENCES `MERCHANTS` (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- DESCRIBE THE MERCHANT_CONTACTS TABLE
CREATE TABLE MERCHANT_CONTACTS (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UUID CHAR(13) NOT NULL UNIQUE,
    MERCHANT_ID BIGINT UNSIGNED NOT NULL,
    CONTACT_TYPE_ID BIGINT UNSIGNED NOT NULL,
    VALUE VARCHAR(255) NOT NULL, 
    PERSON_NAME VARCHAR(127) NOT NULL, 
    DESCRIPTION VARCHAR(127) NOT NULL, 
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
    CONSTRAINT `MERCHANT_CONTACTS_MERCHANTS_FK` FOREIGN KEY (`MERCHANT_ID`) REFERENCES `MERCHANTS` (`ID`), 
    CONSTRAINT `MERCHANT_CONTACTS_CONTACT_TYPES_FK` FOREIGN KEY (`CONTACT_TYPE_ID`) REFERENCES `CONTACT_TYPES` (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

-- DESCRIBE THE MERCHANT_VERIFIED TABLE
CREATE TABLE MECHANT_VERIFIED (
    ID BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    UUID CHAR(13) NOT NULL UNIQUE,
    MERCHANT_ID BIGINT UNSIGNED NOT NULL,
    TOKEN_GENERATED CHAR(13) NOT NULL, 
    TOKEN_EXPIRED_AT TIMESTAMP NOT NULL, 
    CREATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
    CONSTRAINT `MERCHANT_VERIFIED_MERCHANTS_FK` FOREIGN KEY (`MERCHANT_ID`) REFERENCES `MERCHANTS` (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
