create table regions.provinces
(
    id   character varying(64) not null primary key default uuid_generate_v4(),
    code bigint                not null unique,
    name character varying(50)
);

create table regions.cities
(
    id          character varying(64) not null primary key default uuid_generate_v4(),
    code        bigint                not null unique,
    name        character varying(50),
    province_id character varying(64) not null,
    constraint fk_cities_province_id foreign key (province_id)
        references regions.provinces (id)
        on update cascade on delete cascade
);

create table regions.districts
(
    id      character varying(64) not null primary key default uuid_generate_v4(),
    code    bigint                not null unique,
    name    character varying(50),
    city_id character varying(64) not null,
    constraint fk_districts_city_id foreign key (city_id)
        references regions.cities (id)
        on update cascade on delete cascade
);
