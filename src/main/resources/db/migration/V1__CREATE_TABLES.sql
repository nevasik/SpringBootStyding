create table hibernate_sequence(
    next_val bigint
);

insert into hibernate_sequence values (1);
insert into hibernate_sequence values (1);

CREATE TABLE users (
    id BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username varchar(64) unique not null ,
    password varchar(64) not null

);

CREATE TABLE todo (
    id BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title varchar(64) unique not null ,
    completed bool not null
);
