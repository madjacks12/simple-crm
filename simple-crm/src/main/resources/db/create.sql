
CREATE TABLE IF NOT EXISTS clients (
 id SERIAL PRIMARY KEY,
 clientname VARCHAR,
 phone VARCHAR,
 email VARCHAR
);

CREATE TABLE IF NOT EXISTS clienttypes(
 id SERIAL PRIMARY KEY,
 typeName VARCHAR,
 clientId INTEGER
);

CREATE TABLE IF NOT EXISTS addresses(
 id SERIAL PRIMARY KEY,
 street VARCHAR,
 postalcode VARCHAR,
 country VARCHAR,
 city VARCHAR,
 state VARCHAR,
 clientID INTEGER
);

CREATE TABLE IF NOT EXISTS contacts (
 id SERIAL PRIMARY KEY,
 firstname VARCHAR,
 lastname VARCHAR,
 position VARCHAR,
 contactphone VARCHAR,
 contactemail VARCHAR,
 ClientId INTEGER
);

CREATE TABLE IF NOT EXISTS notes (
 id SERIAL PRIMARY KEY,
 writtenby VARCHAR,
 content VARCHAR,
 createdat BIGINT,
 clientID INTEGER
);

CREATE TABLE IF NOT EXISTS clients_clienttypes (
 id SERIAL PRIMARY KEY,
 clientid INTEGER,
 clienttypeid INTEGER
);