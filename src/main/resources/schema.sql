drop table if exists `customer` cascade ;
drop table if exists `account_book` cascade ;

create table `customer` (
    `id` bigint NOT NULL auto_increment,
    `email` varchar(50) not null,
    `password` varchar(50) not null,
    primary key (id)
);

create table `account_book`(
    `id` bigint NOT NULL auto_increment,
    `user_id` bigint not null,
    `pay_money` bigint not null,
    `memo` varchar(1000) not null,
    `created_at` timestamp not null,
    `modified_at` timestamp not null,
    primary key (id)
);