create table partners (
    id			INTEGER NOT NULL AUTO_INCREMENT,
    name        varchar(100)    not null,
    primary key (id)
);

create table theatre (
    id			INTEGER NOT NULL AUTO_INCREMENT,
    name        varchar(100)    not null,
    city        varchar(100)    not null,
    address        varchar(100)    not null,
    partner_id	INTEGER NOT NULL,
    primary key (id)
);

create table screen (
    id			INTEGER NOT NULL AUTO_INCREMENT,
    name        varchar(100)    not null,
    theatre_id	INTEGER NOT NULL,
    primary key (id)
);

create table movie (
    id			INTEGER NOT NULL AUTO_INCREMENT,
    name        varchar(100)    not null,
    language        varchar(100)    not null,
    status        varchar(100)    not null,
    screen_id	INTEGER NOT NULL,
    primary key (id)
);

create table slot (
    id			INTEGER NOT NULL AUTO_INCREMENT,
    start        varchar(100)    not null,
    end        varchar(100)    not null,
    movie_id	INTEGER NOT NULL,
    primary key (id)
);