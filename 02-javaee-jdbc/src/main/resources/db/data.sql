drop database if exists isil_db;
create database isil_db;

\connect isil_db;

CREATE TABLE accounts (
  id SERIAL,
  name VARCHAR(100) NOT NULL,
  balance DOUBLE PRECISION NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO accounts(name,balance)
VALUES('Bob',10000);

INSERT INTO accounts(name,balance)
VALUES('Alice',10000);

SELECT * FROM accounts;

CREATE OR REPLACE FUNCTION transfer(INTEGER, INTEGER, double precision)
    RETURNS BOOLEAN AS $$
DECLARE passed BOOLEAN;
BEGIN
    -- subtracting the amount from the sender's account
    UPDATE accounts
    SET balance = balance - $3
    WHERE id = $1;

    -- adding the amount to the receiver's account
    UPDATE accounts
    SET balance = balance + $3
    WHERE id = $2;

    RETURN passed;
END;
$$ LANGUAGE plpgsql;

SELECT transfer(1,2,1000);