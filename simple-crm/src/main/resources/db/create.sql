SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS clients (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 phone VARCHAR,
 email VARCHAR
);

CREATE TABLE IF NOT EXISTS clienttypes (
 id int PRIMARY KEY auto_increment,
 name VARCHAR
);

CREATE TABLE IF NOT EXISTS addresses (
 id int PRIMARY KEY auto_increment,
 street VARCHAR,
 postalcode VARCHAR,
 country VARCHAR,
 city VARCHAR,
 state VARCHAR
);

CREATE TABLE IF NOT EXISTS contacts (
 id int PRIMARY KEY auto_increment,
 firstname VARCHAR,
 lastname VARCHAR,
 position VARCHAR,
 contactphone VARCHAR,
 contactemail VARCHAR
);

CREATE TABLE IF NOT EXISTS notes (
 id int PRIMARY KEY auto_increment,
 writtenby VARCHAR,
 content VARCHAR,
 createdat BIGINT
);

CREATE TABLE IF NOT EXISTS clients_clienttypes (
 id int PRIMARY KEY auto_increment,
 clientid INTEGER,
 clienttypeid INTEGER,
);