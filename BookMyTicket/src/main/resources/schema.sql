create table partners (
    id			INTEGER NOT NULL AUTO_INCREMENT,
    name        varchar(100)    not null,
    primary key (id)
);

create table theatre (
    id			INTEGER NOT NULL AUTO_INCREMENT,
    name        varchar(100)    not null,
    partner_id	INTEGER NOT NULL,
    primary key (id)
);