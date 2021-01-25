create table transaksi.produk_tabungan
(
    id               character varying(64) not null primary key default uuid_generate_v4(),
    nama             character varying(50) not null,
    min_setoran_awal numeric               not null             default 0,
    suku_bunga       float4                not null             default 0,
    biaya_admin      numeric               not null             default 0
);

create table transaksi.rekening_tabungan
(
    id                character varying(64)  not null primary key default uuid_generate_v4(),
    produk_id         character varying(64)  not null,
    nasabah_id        character varying(64)  not null,
    suku_bunga        float4                 not null             default 0,
    biaya_admin       numeric                not null             default 0,
    saldo_current     numeric                not null             default 0,
    created_by        character varying(100) not null,
    created_date      timestamp              not null             default now(),
    last_updated_by   character varying(100),
    last_updated_date timestamp
);

alter table transaksi.rekening_tabungan
    add constraint fk_rekening_produk_id foreign key (produk_id)
        references transaksi.produk_tabungan (id) on update cascade on delete cascade;

alter table transaksi.rekening_tabungan
    add constraint fk_rekening_nasabah_id foreign key (nasabah_id)
        references nasabah.nasabah (id) on update cascade on delete cascade;


create table transaksi.transaksi_tabungan
(
    id      character varying(64) not null primary key default uuid_generate_v4(),
    tanggal timestamp             not null             default now(),
    debit   numeric               not null             default 0,
    kredit  numeric               not null             default 0,
    saldo   numeric               not null             default 0
);
