--liquibase formatted sql

--changeset punko_vitaliy:2

DROP SEQUENCE IF EXISTS BANK_CLIENTS_SEQ;

drop table if exists CLIENTS;

create table IF NOT EXISTS CLIENTS
(
    ID
                  INTEGER
        PRIMARY
            KEY,
    LAST_NAME
                  VARCHAR(30),
    FIRST_NAME    VARCHAR(30),
    YEAR_OF_BIRTH DATE,
    CITIZENSHIP   VARCHAR(30),
    REGISTRATION  VARCHAR(50)
);

CREATE SEQUENCE IF NOT EXISTS BANK_CLIENTS_SEQ;