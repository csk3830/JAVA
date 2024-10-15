-- 기록용. 나중에 유저와 비번, DB를 확인할 목적.
create user 'javaUser'@'localhost' identified by 'mysql';

create database javadb;

grant all privileges on javadb.* to 'javaUser'@'localhost' with grant option;
flush privileges;

use javadb;

create table product(
pno int auto_increment,
pname varchar(50) not null,
price int default 0,
regdate datetime default now(),
madeby text,
primary key(pno));

-- DB는 수정되거나 추가되면 변경구문을 써놔야 함.
