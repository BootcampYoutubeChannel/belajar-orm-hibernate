insert into hr.jobs(id, title, min_salary, max_salary)
values ('IT_PROG', 'Programmer', 3000, 6000),
       ('BA', 'Business Analyst', 3000, 5000),
       ('CTO', 'Chief Technology Officer', 6000, 10000),
       ('PM', 'Project Manager', 5000, 8000),
       ('CEO', 'Chief Executive Officer', 8000, 12000),
       ('IT_UIUX', 'UI/UX', 4000, 12000);

insert into hr.departments(id, name)
values ('project', 'Project Development'),
       ('rnd', 'Research and Development'),
       ('product', 'Product Development'),
       ('market', 'Marketing & Distributing');

insert into hr.employees(id, first_name, last_name, email, phone_number, job_id, commission_pct, manager_id,
                         department_id, join_date, status, salary)
values ('harsap', 'Hari', 'Sapto Adi', 'harsap@xxxxxxxxx.com', '08xxxxxxxx', 'CTO', 0.20, null, null, '2015-08-01',
        'ACTIVE', 8500),
       ('denisutisna', 'Deni', 'Sutisna', 'deni@xxxxxxxxx.com', '08xxxxxxxx', 'CEO', 0.20, null, null, '2015-08-01',
        'ACTIVE', 9000),
       ('putri', 'Putri', 'Harahap', 'putri@xxxxxxxxx.com', '08xxxxxxxx', 'BA', 0.09, 'denisutisna', 'project',
        '2016-11-01', 'RESIGN', 5500),
       ('dea', 'Dea', 'Ayunda', 'dea@xxxxxxxxx.com', '08xxxxxxxx', 'BA', 0.05, 'denisutisna', 'project', '2016-11-01',
        'RESIGN', 5000),
       ('dimas', 'Dimas', 'Maryanto', 'dimas@xxxxxxxxx.com', '08xxxxxxxx', 'IT_PROG', 0.15, 'harsap', 'rnd',
        '2016-05-01', 'LEAVE', 6000),
       ('dewa', 'Dewa', 'Adi', 'dewa@xxxxxxxxx.com', '08xxxxxxxx', 'IT_PROG', 0.16, 'harsap', 'rnd', '2017-01-01',
        'RESIGN', 6500),
       ('yusuf', 'Muhammad', 'Yusuf', 'yusuf@xxxxxxxxx.com', '08xxxxxxxx', 'IT_PROG', 0.13, 'harsap', 'product',
        '2018-01-01', 'ACTIVE', 5900),
       ('abdul', 'Abdul', 'Arraisi', 'abdul@xxxxxxxxx.com', '08xxxxxxxx', 'IT_PROG', 0.13, 'harsap', 'project',
        '2019-01-01', 'ACTIVE', 5000),
       ('junaedi', 'Junaedi', '', 'jenaedi@xxxxxxxxx.com', '08xxxxxxxx', 'PM', 0.10, 'harsap', 'project', '2018-01-01',
        'ACTIVE', 4000),
       ('purwadi', 'Muhammad', 'Purwadi', 'purwadi@xxxxxxxxx.com', '08xxxxxxxx', 'PM', 0.12, 'harsap', 'project',
        '2018-01-01', 'ACTIVE', 6700),
       ('prima', 'Prima', 'Jakaria', 'prima@xxxxxxxxx.com', '08xxxxxxxx', 'IT_PROG', 0.13, 'harsap', 'project',
        '2019-01-01', 'ACTIVE', 5800),
       ('dewi', 'Dewi', 'Sofiati', 'dewi@xxxxxxxxx.com', '08xxxxxxxx', 'BA', 0.13, 'denisutisna', 'project',
        '2019-01-01', 'ACTIVE', 5300),
       ('muni', 'Muni', '', 'muni@xxxxxxxxx.com', '08xxxxxxxx', 'BA', null, 'denisutisna', 'project', '2020-01-01',
        'ACTIVE', 5200),
       ('cathrin', 'Catherine', '', 'cathrine@xxxxxxxxx.com', '08xxxxxxxx', 'BA', null, 'denisutisna', 'project',
        '2020-08-01', 'ACTIVE', 5200),
       ('raka', 'Raka', 'Maulana', 'raka@xxxxxxxxx.com', '08xxxxxxxx', 'IT_PROG', null, 'harsap', 'project',
        '2020-07-01', 'ACTIVE', 4800),
       ('apri', 'Apri', 'Primanda', 'apri@xxxxxxxxx.com', '08xxxxxxxx', 'IT_PROG', null, 'harsap', 'project',
        '2019-12-01', 'ACTIVE', 4800),
       ('insan', 'Insanul', 'Yakin', 'insan@xxxxxxxxx.com', '08xxxxxxxx', 'IT_PROG', 0.13, 'harsap', 'project',
        '2017-12-01', 'ACTIVE', 5500);

update hr.departments
set manager_id = 'harsap'
where id in ('project', 'product');
update hr.departments
set manager_id = 'dimas'
where id in ('rnd');
update hr.departments
set manager_id = 'denisutisna'
where id in ('market');

insert into hr.employee_addresses(district_id, employee_id, street_address, type)
values ('jatiasih', 'denisutisna', 'jl...', 'RUMAH'),
       ('antapani', 'harsap', 'jl...', 'RUMAH'),
       ('ujung-berung', 'yusuf', 'jl...', 'RUMAH'),
       ('cileunyi', 'purwadi', 'jl...', 'RUMAH'),
       ('cileunyi', 'dimas', 'jl...', 'RUMAH'),
       ('melawai', 'dimas', 'jl...', 'DOMISILI');


