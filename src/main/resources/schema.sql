drop table if exists customer;
create table customer (
    id bigint auto_increment primary key,
    name varchar(256) not null
);