drop table if exists `account` cascade ;
drop table if exists `delete_account` cascade ;
drop table if exists `customer` cascade ;

create table `customer` (
    `id` bigint NOT NULL auto_increment,
    `email` varchar(50) not null,
    `password` varchar(50) not null,
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `account`(
    `id` bigint NOT NULL auto_increment,
    `customer_id` bigint not null,
    `pay_money` bigint not null,
    `memo` varchar(1000),
    `created_at` timestamp not null,
    `modified_at` timestamp,
    primary key (id),
    foreign key (customer_id) references customer(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table `delete_account`(
      `id` bigint NOT NULL auto_increment,
      `customer_id` bigint not null,
      `pay_money` bigint not null,
      `memo` varchar(1000),
      `created_at` timestamp not null,
      `modified_at` timestamp null,
      primary key (id),
      foreign key (customer_id) references customer(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;