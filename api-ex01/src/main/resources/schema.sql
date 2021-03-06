DROP TABLE IF EXISTS ACCOUNT_DETAILS;
DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS MEMBER;

CREATE TABLE MEMBER (
    ID     BIGINT NOT NULL,
    NAME        VARCHAR(100),
    AGE         INT,		
    JOIN_DATE   VARCHAR(10),
    PRIMARY KEY (ID)
);

CREATE TABLE ACCOUNT (
    ID     BIGINT NOT NULL,
    ACCOUNT_NO      VARCHAR(100) NOT NULL
);

CREATE TABLE ACCOUNT_DETAILS (
    ACCOUNT_NO                  VARCHAR(100) NOT NULL    ,
    DEPOSIT_WITHDRAWAL_STATUS   VARCHAR(1) NOT NULL,   
    DEPOSIT_AMOUNT              INT NOT NULL    ,
    DEPOSIT_DATE                VARCHAR(10)  NOT NULL   
);