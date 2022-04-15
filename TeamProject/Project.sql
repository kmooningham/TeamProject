DROP TABLE IF EXISTS players

CREATE TABLE IF NOT EXISTS players(
    id	        INT		AUTO_INCREMENT,
    username    VARCHAR(20)     NOT NULL,
    password    VARBINARY(20)   NOT NULL,
    wins        INT     DEFAULT 0   NOT NULL,
    CONSTRAINT players_id_uindex
	UNIQUE (id)
);

ALTER TABLE players
    ADD CONSTRAINT players_id_pk PRIMARY KEY(id);

