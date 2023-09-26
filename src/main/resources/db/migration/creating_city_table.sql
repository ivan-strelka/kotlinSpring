create table city
(
    id         serial constraint city_pk primary key,
    country_id integer not null
    constraint city_country_fk references country,
    name       varchar not null
);