
alter table part
add image varchar(255) not null after price,
add part_description varchar(255) after price,
add labor_price decimal(19,2) after price,
add stock integer not null after price;


create table authorities (id bigint not null auto_increment, authority varchar(255), username varchar(255), primary key (id)) engine=InnoDB
create table car (id bigint not null auto_increment, make varchar(255), model varchar(255), price decimal(19,2), year varchar(255), primary key (id)) engine=InnoDB;
create table customer (id bigint not null auto_increment, city varchar(255), state varchar(255), street_address varchar(255), zip varchar(255), first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table department (department_id bigint not null auto_increment, amount integer not null, head varchar(255), name varchar(255), primary key (department_id)) engine=InnoDB;
create table employee (id bigint not null auto_increment, city varchar(255), state varchar(255), street_address varchar(255), zip varchar(255), email varchar(255), first_name varchar(255), last_name varchar(255), department bigint not null, primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
create table invoice (id bigint not null, total decimal(19,2), customer_id bigint, primary key (id)) engine=InnoDB;
create table invoice_parts (invoice_id bigint not null, parts_id bigint not null) engine=InnoDB;
create table part (id bigint not null, category integer, description varchar(255), image varchar(255), labor decimal(19,2), name varchar(255), price decimal(19,2), stock integer not null, supplier varchar(255), primary key (id)) engine=InnoDB;
create table project (id bigint not null, progress integer, car_id bigint not null, customer_id bigint not null, primary key (id)) engine=InnoDB;
create table users (username varchar(64) not null, enabled bit not null, password varchar(255), primary key (username)) engine=InnoDB;
alter table invoice_parts add constraint UK_bxt4sdg0x09wjj6bramuvklob unique (parts_id);
alter table employee add constraint FKkxx4wtsgsdt16iix2pso0k126 foreign key (department) references department (department_id);
alter table invoice add constraint FK5e32ukwo9uknwhylogvta4po6 foreign key (customer_id) references customer (id);
alter table invoice_parts add constraint FKoayb1ea0769yf015q4dqmkfot foreign key (parts_id) references part (id);
alter table invoice_parts add constraint FK6uackgcq3tsolou0tshtpnqq0 foreign key (invoice_id) references invoice (id);
alter table project add constraint FKnxbihe491j153gxaf3r9434lk foreign key (car_id) references car (id) on delete cascade;
alter table project add constraint FKj948tru2ilgqxfxsppp9mom5j foreign key (customer_id) references customer (id);
