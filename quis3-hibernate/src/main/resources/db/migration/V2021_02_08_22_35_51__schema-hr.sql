create table hr.jobs
(
    id         character varying(64) not null primary key default uuid_generate_v4(),
    title      character varying(35),
    min_salary numeric(8, 2)         not null             default 0,
    max_salary numeric(8, 2)         not null             default 0,
    constraint ck_salary_default check ( min_salary >= 1 and max_salary >= 0 )
);

create table hr.employees
(
    id             character varying(64) not null primary key default uuid_generate_v4(),
    first_name     character varying(20),
    last_name      character varying(25) not null,
    email          character varying(50),
    phone_number   character varying(15),
    job_id         character varying(64),
    salary         numeric(8, 2)         not null             default 0,
    commission_pct float4,
    manager_id     character varying(64),
    department_id  character varying(64),
    join_date      timestamp             not null,
    status         character varying(20) not null,
    constraint fk_employee_job_id foreign key (job_id)
        references hr.jobs (id) on update cascade on delete set null,
    constraint ch_salary_default check ( salary >= 0 ),
    constraint fk_employee_manager_id foreign key (manager_id)
        references hr.employees (id) on update cascade on delete set null,
    constraint ck_status_employee check ( status in ('RESIGN', 'LEAVE', 'ACTIVE') ),
    constraint ck_join_date_past check ( join_date <= now() )
);

create table hr.departments
(
    id         character varying(64) not null primary key default uuid_generate_v4(),
    name       character varying(50),
    manager_id character varying(64),
    constraint fk_department_manager_id foreign key (manager_id)
        references hr.employees (id) on update cascade
        on delete set null
);

alter table hr.employees
    add constraint fk_employee_department_id foreign key (department_id)
        references hr.departments (id) on update cascade on delete set null;

create table hr.employee_addresses
(
    id             character varying(64) not null primary key default uuid_generate_v4(),
    district_id    character varying(64) not null,
    employee_id    character varying(64) not null,
    street_address text,
    type           character varying(20) not null,
    constraint fk_employee_address_district_id foreign key (district_id)
        references regions.districts (id) on update cascade on delete cascade,
    constraint fk_employee_address_employee_id foreign key (employee_id)
        references hr.employees (id) on update cascade on delete cascade,
    constraint ck_type_address check ( type in ('RUMAH', 'DOMISILI')),
    constraint uq_location_by_employee unique (district_id, employee_id, type)
);
