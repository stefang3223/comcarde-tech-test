INSERT INTO PRODUCT (ID, NAME, QUANTITY) VALUES
    (1, 'a', 5),
    (2, 'b', 8),
    (3, 'c', 2),
    (4, 'd', 0),
    (5, 'e', 1);


INSERT INTO RULE (ID, RULE_STATUS, MIN_QUANTITY) VALUES
    (1, 'ACTIVE', 4),
    (2, 'ACTIVE', 4),
    (3, 'BLOCKED', 4),
    (4, 'ACTIVE', 8),
    (5, 'ACTIVE', 4);

INSERT INTO ADHOC_ORDER (id, PRODUCT_ID, is_active, quantity) VALUES
    (1, 4, 1, 15);
