ALTER TABLE books ADD COLUMN BESTSELLER BOOLEAN DEFAULT FALSE;

DROP FUNCTION IF EXISTS SetBestseller;

DELIMITER $$

CREATE FUNCTION SetBestseller(booksrented INT) RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE result BOOLEAN DEFAULT FALSE;
    IF booksrented >= 2 THEN
        SET result = TRUE;
    ELSE
        SET result = FALSE;
    end if;
    return result;
end $$

DELIMITER ;

DROP PROCEDURE IF EXISTS UpdateBestsellers;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
BEGIN
    DECLARE BOOKSRENTED, CURRENT_BOOK_ID, DAYS INT;
    DECLARE BOOKSPERMONTH DECIMAL(5,2);
    DECLARE FINISHED INT DEFAULT 0;
    DECLARE ALL_BOOKS CURSOR FOR SELECT BOOK_ID FROM books;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;
    OPEN ALL_BOOKS;
    WHILE (FINISHED = 0) DO
        FETCH ALL_BOOKS INTO CURRENT_BOOK_ID;
        IF (FINISHED = 0) THEN
            SELECT COUNT(*) FROM rents
                WHERE BOOK_ID = CURRENT_BOOK_ID
                INTO BOOKSRENTED;

            SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM rents
                WHERE BOOK_ID = CURRENT_BOOK_ID
                INTO DAYS;

            SET BOOKSPERMONTH = BOOKSRENTED / DAYS * 30;

            UPDATE books SET books.BESTSELLER = SetBestseller(BOOKSPERMONTH)
                WHERE BOOK_ID = CURRENT_BOOK_ID;
            COMMIT;
        end if;
        end while;

    CLOSE ALL_BOOKS;
end $$

DELIMITER ;

CALL UpdateBestsellers();