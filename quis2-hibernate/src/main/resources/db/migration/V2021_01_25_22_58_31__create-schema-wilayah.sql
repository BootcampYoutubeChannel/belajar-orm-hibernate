create table wilayah.provinsi
(
    id   character varying(64) primary key default uuid_generate_v4(),
    kode bigint                 not null,
    nama character varying(100) not null
);

create table wilayah.kota
(
    id          character varying(64) primary key default uuid_generate_v4(),
    kode        bigint                 not null,
    nama        character varying(100) not null,
    provinsi_id character varying(64)  not null
);

alter table wilayah.kota
    add constraint fk_kota_provinsi_id foreign key (provinsi_id)
        references wilayah.provinsi (id) on update cascade on delete cascade;

create table wilayah.kecamatan
(
    id      character varying(64) primary key default uuid_generate_v4(),
    kode    bigint                 not null,
    nama    character varying(100) not null,
    kota_id character varying(64)  not null
);

alter table wilayah.kecamatan
    add constraint fk_kecamatan_kota_id foreign key (kota_id)
        references wilayah.kota (id) on update cascade on delete cascade;

create table wilayah.kelurahan
(
    id           character varying(64) primary key default uuid_generate_v4(),
    kode         bigint                 not null,
    nama         character varying(100) not null,
    kecamatan_id character varying(64)  not null
);

alter table wilayah.kelurahan
    add constraint fk_kelurahan_kecamatan_id foreign key (kecamatan_id)
        references wilayah.kecamatan (id) on update cascade on delete cascade;
