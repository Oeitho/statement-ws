CREATE SEQUENCE HIBERNATE_SEQUENCE INCREMENT BY 1;

CREATE TABLE statement (
    id            SERIAL PRIMARY KEY,
    claim         VARCHAR(100) NOT NULL,
    validity      BOOLEAN NOT NULL,
    explanation   VARCHAR(1000) NOT NULL,
    active        BOOLEAN NOT NULL,
    creation_date DATE,
    author        VARCHAR(60) NOT NULL
);