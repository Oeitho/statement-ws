CREATE SEQUENCE HIBERNATE_SEQUENCE INCREMENT BY 1;

CREATE TABLE statement (
    id            IDENTITY PRIMARY KEY,
    claim         VARCHAR(100) NOT NULL,
    validity      BOOLEAN NOT NULL,
    explanation   VARCHAR(1000) NOT NULL,
    active        BOOLEAN NOT NULL,
    creation_date DATE,
    author        VARCHAR(60) NOT NULL
);

INSERT INTO statement(id, claim, validity, explanation, active, creation_date, author)
VALUES (HIBERNATE_SEQUENCE.NEXTVAL, 'This is a true claim', true, 'This is simply true', true, '2020-10-10', 'Øivind Thorrud'),
    (HIBERNATE_SEQUENCE.NEXTVAL, 'This is a false claim', false, 'This is simply not true', true, '2020-10-10', 'Øivind Thorrud'),
    (HIBERNATE_SEQUENCE.NEXTVAL,'This is a true inactive claim', true, 'This is simply true, but inactive', false, '2020-10-10', 'Øivind Thorrud'),
    (HIBERNATE_SEQUENCE.NEXTVAL, 'This is a false inactive claim', false, 'This is simply false, but inactive', false, '2020-10-10', 'Øivind Thorrud'),
    (HIBERNATE_SEQUENCE.NEXTVAL, 'One more test claim', true, 'A test claim', true, '2020-10-10', 'Øivind Thorrud'),
    (HIBERNATE_SEQUENCE.NEXTVAL, 'This has an old claim', true, 'Old claim', true, '2000-10-10', 'Øivind Thorrud');