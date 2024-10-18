-- 기록용. 나중에 유저와 비번, DB를 확인할 목적.
create user 'javaUser'@'localhost' identified by 'mysql';

create database javadb;

grant all privileges on javadb.* to 'javaUser'@'localhost' with grant option;
flush privileges;

use javadb;

create table student(
sno int auto_increment;
sname varchar(50) not null,
birth varchar(50),
phone varchar(50),
address varchar(50),
regdate datetime default now(),
primary key(sno));

-- DB는 수정되거나 추가되면 변경구문을 써놔야 함.
