--liquibase formatted sql

--changeset punko_vitaliy:6

DROP SEQUENCE IF EXISTS BANK.BANK_CARDS_SEQ;

drop table if exists BANK.BANK_CARDS;

create table IF NOT EXISTS BANK.BANK_CARDS
(
    ID
                    INTEGER
        PRIMARY
            KEY,
    BANK_CARD_NUMBER
                    VARCHAR(12),
    OPEN_DATE       DATE,
    CLOSE_DATE      DATE,
    BANK_ACCOUNT_ID INTEGER REFERENCES BANK.BANK_ACCOUNTS
        (
         ID
            ),
    CLIENT_ID       INTEGER REFERENCES BANK.CLIENTS
        (
         ID
            )
);

ALTER TABLE BANK.BANK_CARDS
    ADD CONSTRAINT UNIQUE_BANK_CARD_NUMBER
        UNIQUE (BANK_CARD_NUMBER);

CREATE SEQUENCE IF NOT EXISTS BANK.BANK_CARDS_SEQ;