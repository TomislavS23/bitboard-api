-- CREATE DATABASE bitboard

CREATE TABLE role
(
    id_role   SERIAL PRIMARY KEY,
    role_type VARCHAR(50)
);

CREATE TABLE users
(
    id_user         SERIAL PRIMARY KEY,
    username        VARCHAR(50) UNIQUE     NOT NULL,
    email           VARCHAR(100) UNIQUE    NOT NULL,
    hashed_password VARCHAR(500)           NOT NULL,
    salt            CHAR(32)               NOT NULL,
    iterations      INTEGER DEFAULT 600001 NOT NULL,
    created_at      DATE    DEFAULT CURRENT_DATE,
    id_role         INTEGER DEFAULT 1 REFERENCES role (id_role)
);

CREATE TABLE thread
(
    id_thread       SERIAL PRIMARY KEY,
    title           VARCHAR(100),
    description     VARCHAR(500),
    total_upvotes   INTEGER, -- TODO: represents a sum of all upvotes/downvotes
    total_downvotes INTEGER,
    number_of_posts INTEGER,
    locked          BOOLEAN DEFAULT FALSE
);

CREATE TABLE subthread
(
    id_subthread    SERIAL PRIMARY KEY,
    title           VARCHAR(100),
    content         VARCHAR,
    total_upvotes   INTEGER,
    total_downvotes INTEGER,
    locked          BOOLEAN DEFAULT FALSE,
    id_user         INTEGER REFERENCES users (id_user),
    id_thread       INTEGER REFERENCES thread (id_thread)
);

CREATE TABLE user_thread
(
    id_user_thread SERIAL PRIMARY KEY,
    id_user        INTEGER REFERENCES users (id_user),
    id_thread      INTEGER REFERENCES thread (id_thread)
);

CREATE TABLE statistics
(
    id_statistics    SERIAL PRIMARY KEY,
    id_user          INTEGER REFERENCES users (id_user),
    number_of_topics INTEGER,
    total_upvotes    INTEGER,
    total_downvotes  INTEGER
);

CREATE TABLE support_ticket_type
(
    id_support_ticket_type SERIAL PRIMARY KEY,
    ticket_type            VARCHAR(50)
);

CREATE TABLE support_ticket
(
    id_support_ticket      SERIAL PRIMARY KEY,
    unique_id              VARCHAR(50), -- TODO: must be randomly generated string of characters.
    title                  VARCHAR(100),
    content                VARCHAR,
    id_support_ticket_type INTEGER REFERENCES support_ticket_type (id_support_ticket_type),
    id_user                INTEGER REFERENCES users (id_user)
);