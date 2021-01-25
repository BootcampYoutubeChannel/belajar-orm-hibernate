alter table transaksi.transaksi_tabungan
    add column rekening_id character varying(64) not null;

alter table transaksi.transaksi_tabungan
    add constraint fk_transaksi_rekening_id foreign key (rekening_id) references transaksi.transaksi_tabungan (id) on update cascade on delete cascade;
