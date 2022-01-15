drop table user if exists;
drop table account_book if exists;

create table `user` (
    `id` bigint NOT NULL auto_increament,
    `email` varchar(50) not null,
    `password` varchar(50) not null,
    primary key (id)
);

create table `account_book`(
    `id` bigint NOT NULL auto_increament,
    `user_id` bigint not null,
    `pay_money` bigint not null,
    `memo` varchar(1000) not null,
    `created_at` timestamp not null,
    `modified_at` timestamp not null,
)