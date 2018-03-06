USE manufacturing;

INSERT INTO manufacturer VALUES
    (unhex(replace('a729addb-0085-11e8-b790-74d02b0b2f61', '-', '')), 'Calvin Klein'),
    (unhex(replace('a72d2e71-0085-11e8-b790-74d02b0b2f61', '-', '')), 'Nivea'),
    (unhex(replace('a72d3129-0085-11e8-b790-74d02b0b2f61', '-', '')), 'Samsung');

INSERT INTO product VALUES
    (unhex(replace(uuid(), '-', '')), 'Jeans',100,unhex(replace('a729addb-0085-11e8-b790-74d02b0b2f61', '-', ''))),
    (unhex(replace(uuid(), '-', '')), 'Shirt',80,unhex(replace('a729addb-0085-11e8-b790-74d02b0b2f61', '-', ''))),
    (unhex(replace(uuid(), '-', '')), 'Shampoo',10.5,unhex(replace('a72d2e71-0085-11e8-b790-74d02b0b2f61', '-', ''))),
    (unhex(replace(uuid(), '-', '')), 'Cream',20.2,unhex(replace('a72d2e71-0085-11e8-b790-74d02b0b2f61', '-', ''))),
    (unhex(replace(uuid(), '-', '')), 'Lotion',25.5,unhex(replace('a72d2e71-0085-11e8-b790-74d02b0b2f61', '-', ''))),
    (unhex(replace(uuid(), '-', '')), 'Smartphone',150,unhex(replace('a72d3129-0085-11e8-b790-74d02b0b2f61', '-', ''))),
    (unhex(replace(uuid(), '-', '')), 'Tablet',180,unhex(replace('a72d3129-0085-11e8-b790-74d02b0b2f61', '-', ''))),
    (unhex(replace(uuid(), '-', '')), 'TV',300,unhex(replace('a72d3129-0085-11e8-b790-74d02b0b2f61', '-', '')));

INSERT INTO role VALUES
    (1, 'ROLE_USER'),
    (2, 'ROLE_ADMIN');

INSERT INTO user VALUES (1, 'test', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');

INSERT INTO user_role VALUES (1, 2);

