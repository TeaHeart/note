drop table if exists tb_datepart;

create table tb_datepart
(
    id          bigint not null comment 'ID' primary key,
    name        varchar(100) null comment '姓名',
    create_time date null
);

insert into tb_datepart(id, name, create_time)
values (1, 'Tom', '2022-01-01');
insert into tb_datepart(id, name, create_time)
values (2, 'Cat', '2022-01-10');
insert into tb_datepart(id, name, create_time)
values (3, 'Rose', '2022-01-11');
insert into tb_datepart(id, name, create_time)
values (4, 'Coco', '2022-01-20');
insert into tb_datepart(id, name, create_time)
values (5, 'Rose2', '2022-01-21');
insert into tb_datepart(id, name, create_time)
values (6, 'Coco2', '2022-01-30');
insert into tb_datepart(id, name, create_time)
values (7, 'Coco3', '2022-01-31');