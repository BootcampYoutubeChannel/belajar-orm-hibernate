create table nasabah.nasabah
(
    id                character varying(64) primary key default uuid_generate_v4(),
    nama_kepemilikan  character varying(50)  not null,
    cif               character varying(20)  not null unique,
    no_identitas      character varying(32)  not null,
    kelurahan_id      character varying(64)  not null,
    created_by        character varying(100) not null,
    created_date      timestamp              not null   default now(),
    last_updated_by   character varying(100),
    last_updated_date timestamp
);

alter table nasabah.nasabah
    add constraint fk_nasabah_kelurahan_id foreign key (kelurahan_id)
        references wilayah.kelurahan (id) on update cascade on delete cascade;

create table nasabah.nasabah_perorangan
(
    nama_ibu_kandung character varying(50) not null,
    tanggal_lahir    date                  not null,
    no_telp          character varying(15) not null,
    nasabah_id       character varying(64) not null
);

alter table nasabah.nasabah_perorangan
    add constraint fk_perorangan_nasabah_id foreign key (nasabah_id)
        references nasabah.nasabah (id) on update cascade on delete cascade;

create table nasabah.nasabah_badan_usaha
(
    no_siup          character varying(50)  not null,
    no_akta_terakhir character varying(100) not null,
    no_telp          character varying(15),
    nasabah_id       character varying(64)  not null
);

alter table nasabah.nasabah_badan_usaha
    add constraint fk_badan_usaha_nasabah_id foreign key (nasabah_id)
        references nasabah.nasabah (id) on update cascade on delete cascade;

