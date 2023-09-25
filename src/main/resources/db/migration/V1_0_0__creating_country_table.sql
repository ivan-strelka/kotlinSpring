create table country
(
    id         serial constraint country_pk primary key,
    name       varchar not null,
    population integer not null
);