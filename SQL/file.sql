INSERT INTO POSTS (USER_ID, BODY)
VALUES (5, 'To delete');

DELETE FROM POSTS
WHERE BODY = 'To delete';

COMMIT;