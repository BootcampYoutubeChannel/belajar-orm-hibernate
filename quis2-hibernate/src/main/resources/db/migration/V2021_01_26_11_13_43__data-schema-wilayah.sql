insert into wilayah.provinsi(id, kode, nama)
values ('jawa-barat', 32, 'Jawa Barat');

insert into wilayah.kota(id, kode, nama, provinsi_id)
values ('bandung', 3201, 'Kota Bandung', 'jawa-barat'),
       ('kab.bandung', 3202, 'Kab. Bandung', 'jawa-barat');

insert into wilayah.kecamatan(id, kode, nama, kota_id)
VALUES ('cileunyi', 320201, 'Cileunyi', 'kab.bandung'),
       ('cibiru-hilir', 320202, 'Cibiru Hilir', 'kab.bandung');

insert into wilayah.kelurahan(id, kode, nama, kecamatan_id)
values ('cinunuk', 32020101, 'Cinunuk', 'cileunyi'),
       ('permata-biru', 32020102, 'Permata Biru', 'cileunyi');
