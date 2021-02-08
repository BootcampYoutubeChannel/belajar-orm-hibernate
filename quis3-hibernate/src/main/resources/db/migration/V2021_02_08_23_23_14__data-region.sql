insert into regions.provinces(id, code, name)
values ('aceh', 1, 'Aceh'),
       ('jawa-barat', 13, 'Jawa Barat'),
       ('jawa-tengah', 14, 'Jawa Tengah'),
       ('dki-jakarta', 11, 'DKI Jakarta'),
       ('bali', 17, 'Bali');

insert into regions.cities(id, code, name, province_id)
values ('bandung', 1301, 'Bandung', 'jawa-barat'),
       ('kab-bandung', 1302, 'Kab. Bandung', 'jawa-barat'),
       ('kab-cimahi', 1303, 'Kab. Cimahi', 'jawa-barat'),
       ('bekasi', 1304, 'Bekasi', 'jawa-barat'),
       ('jakpus', 1101, 'Jakarta Pusat', 'dki-jakarta'),
       ('jaksel', 1102, 'Jakarta Selatan', 'dki-jakarta'),
       ('jakut', 1103, 'Jakarta Utara', 'dki-jakarta'),
       ('badung', 1701, 'Badung', 'bali'),
       ('buleleng', 1702, 'Buleleng', 'bali'),
       ('bangli', 1703, 'Bangli', 'bali');

insert into regions.districts(id, code, name, city_id)
values ('cileunyi', 130201, 'Cileunyi', 'kab-bandung'),
       ('cibiru', 130202, 'Cibiru', 'kab-bandung'),
       ('ujung-berung', 130101, 'Ujung Berung', 'bandung'),
       ('jatiasih', 130401, 'Jatiasih', 'bekasi'),
       ('antapani', 130102, 'Antapani', 'bandung'),
       ('gede-bage', 130103, 'Gede Bage', 'bandung'),
       ('melawai', 110201, 'Melawai', 'jaksel'),
       ('balai-kota', 110301, 'Balai Kota', 'jakpus'),
       ('gambir', 110302, 'Gambir', 'jakpus'),
       ('kuta', 170101, 'Kuta', 'badung'),
       ('kintamani', 170301, 'Kintamani', 'bangli');
