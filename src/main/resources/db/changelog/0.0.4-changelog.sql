--liquibase formatted sql

--changeset punko_vitaliy:8

DROP SEQUENCE IF EXISTS BANK.BANK_TRANSACTIONS_HISTORY_SEQ;

drop table if exists BANK.TRANSACTIONS_HISTORY;

create table IF NOT EXISTS BANK.TRANSACTIONS_HISTORY
(
    ID
                             INTEGER
        PRIMARY
            KEY,
    TRANSACTION_TIME
                             TIMESTAMP,
    SUM
                             NUMERIC(19,
                                 4),
    BANK_ACCOUNT_SENDER_ID   INTEGER REFERENCES BANK.BANK_ACCOUNTS
        (
         ID
            ),
    BANK_ACCOUNT_RECEIVER_ID INTEGER REFERENCES BANK.BANK_ACCOUNTS
        (
         ID
            )
);

CREATE SEQUENCE IF NOT EXISTS BANK.BANK_TRANSACTIONS_HISTORY_SEQ