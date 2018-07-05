# JavaAppHibernate

This netbean project is an example for connect a java app to mysql database using hibernate framework

## Prerequisites

Database schema required

```
create schema javaapphibernate;

use javaapphibernate;

create table javaapphibernate.contact (
    `pk_id_contact` bigint auto_increment,
    `name` varchar (50),
    `lastname` varchar (50),
    `address` varchar(100),
    primary key (`pk_id_contact`)
);

create table javaapphibernate.phone (
    `pk_id_phone` bigint auto_increment,
    `number` bigint,
    `fk_id_contact` bigint,
    primary key (`pk_id_phone`),
    foreign key (fk_id_contact) references javaapphibernate.contact(pk_id_contact) on update cascade
);

create table javaapphibernate.team (
    `pk_id_team` bigint auto_increment,
    `name` varchar(50),
    primary key (`pk_id_team`)
);

create table javaapphibernate.contact_team (
    `fk_id_contact` bigint,
    `fk_id_team` bigint,
    primary key (`fk_id_contact`,`fk_id_team`),
    foreign key (fk_id_contact) references javaapphibernate.contact(pk_id_contact) on update cascade,
    foreign key (fk_id_team) references javaapphibernate.team(pk_id_team) on update cascade
);
```

## Built With

* [NetBeans 8.2](https://netbeans.org) - Development environment used