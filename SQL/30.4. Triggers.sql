#CREATING AUDIENCE TABLES
CREATE TABLE BOOKS_AUD (
    EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
    EVENT_DATE DATETIME NOT NULL,
    EVENT_TYPE VARCHAR(10) DEFAULT NULL,
    BOOK_ID INT(11) NOT NULL,
    OLD_TITLE VARCHAR(225),
    NEW_TITLE VARCHAR(225),
    OLD_PUBYEAR INT(11),
    NEW_PUBYEAR INT(20),
    OLD_BESTSELLER BOOLEAN,
    NEW_BESTSELLER BOOLEAN,
    PRIMARY KEY (EVENT_ID)
);

CREATE TABLE READERS_AUD (
    EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
    EVENT_DATE DATETIME NOT NULL,
    EVENT_TYPE VARCHAR(10) DEFAULT NULL,
    READER_ID INT(11) NOT NULL,
    OLD_FIRSTNAME VARCHAR(255),
    NEW_FIRSTNAME VARCHAR(255),
    OLD_LASTNAME VARCHAR(255),
    NEW_LASTNAME VARCHAR(255),
    OLD_PESELID VARCHAR(11),
    NEW_PESELID VARCHAR(11),
    OLD_VIP_LEVEL VARCHAR(20),
    NEW_VIP_LEVEL VARCHAR(20),
    PRIMARY KEY (EVENT_ID)
);

#CHECKING THAT TABLES HAVE BEEN CREATED
SHOW TABLES FROM kodilla_course;

#CREATING INSERT TRIGGER FOR BOOKS
DELIMITER $$

CREATE TRIGGER BOOKS_INSERT AFTER INSERT ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID, NEW_TITLE, NEW_PUBYEAR, NEW_BESTSELLER)
        VALUE (CURTIME(), "INSERT", NEW.BOOK_ID, NEW.TITLE, NEW.PUBYEAR, NEW.BESTSELLER);
END $$

DELIMITER ;

#CHECKING THAT TRIGGER WORKS CORRECTLY
INSERT INTO BOOKS(TITLE, PUBYEAR, BESTSELLER)
VALUES ("The Lord of the Rings", 1954, 0);

COMMIT;

SELECT * FROM BOOKS_AUD;

#CREATING UPDATE TRIGGER FOR BOOKS
DELIMITER $$

CREATE TRIGGER BOOKS_UPDATE AFTER UPDATE ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID, OLD_TITLE, NEW_TITLE,
                           OLD_PUBYEAR, NEW_PUBYEAR, OLD_BESTSELLER, NEW_BESTSELLER)
        VALUE (CURTIME(), "UPDATE", OLD.BOOK_ID, OLD.TITLE, NEW.TITLE,
               OLD.PUBYEAR, NEW.PUBYEAR, OLD.BESTSELLER, NEW.BESTSELLER);
END $$

DELIMITER ;

#CHECKING THAT TRIGGER WORKS CORRECTLY
UPDATE BOOKS SET BESTSELLER = 1
WHERE BOOK_ID = 18;

COMMIT;

SELECT * FROM BOOKS_AUD;

#CREATING DELETE TRIGGER FOR BOOKS
DELIMITER $$

CREATE TRIGGER BOOKS_DELETE AFTER DELETE ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID)
        VALUE (CURTIME(), "DELETE", OLD.BOOK_ID);
END $$

DELIMITER ;

#CHECKING THAT TRIGGER WORKS CORRECTLY
DELETE FROM BOOKS WHERE BOOK_ID = 18;

COMMIT;

SELECT * FROM BOOKS_AUD;

#CREATING INSERT TRIGGER FOR READERS
DELIMITER $$

CREATE TRIGGER READERS_INSERT AFTER INSERT ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID,
                             NEW_FIRSTNAME, NEW_LASTNAME, NEW_PESELID, NEW_VIP_LEVEL)
        VALUE (CURTIME(), "INSERT", NEW.READER_ID,
               NEW.FIRSTNAME, NEW.LASTNAME, NEW.PESELID, NEW.VIP_LEVEL);
END $$

DELIMITER ;

#CHECKING THAT TRIGGER WORKS CORRECTLY
INSERT INTO READERS (FIRSTNAME, LASTNAME, PESELID, VIP_LEVEL)
VALUES ("Tom", "Evans", "98040537829", "Standard customer");

COMMIT;

SELECT * FROM READERS_AUD;

#CREATING UPDATE TRIGGER FOR READERS
DELIMITER $$

CREATE TRIGGER READERS_UPDATE AFTER UPDATE ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID,
                             OLD_FIRSTNAME, NEW_FIRSTNAME, OLD_LASTNAME, NEW_LASTNAME,
                             OLD_PESELID, NEW_PESELID, OLD_VIP_LEVEL, NEW_VIP_LEVEL)
        VALUE (CURTIME(), "UPDATE", NEW.READER_ID,
               OLD.FIRSTNAME, NEW.FIRSTNAME, OLD.LASTNAME, NEW.LASTNAME,
               OLD.PESELID, NEW.PESELID, OLD.VIP_LEVEL, NEW.VIP_LEVEL);
END $$

DELIMITER ;

#CHECKING THAT TRIGGER WORKS CORRECTLY
UPDATE READERS SET VIP_LEVEL = "Gold customer"
WHERE READER_ID = 6;

COMMIT;

SELECT * FROM READERS_AUD;

#CREATING DELETE TRIGGER FOR READERS
DELIMITER $$

CREATE TRIGGER READERS_DELETE AFTER DELETE ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID)
        VALUE (CURTIME(), "DELETE", OLD.READER_ID);
END $$

DELIMITER ;

#CHECKING THAT TRIGGER WORKS CORRECTLY
DELETE FROM READERS WHERE READER_ID = 6;

COMMIT;

SELECT * FROM READERS_AUD;

SHOW TRIGGERS;