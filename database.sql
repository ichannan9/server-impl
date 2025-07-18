create database boardservice;

use boardservice;

create table if not exists member (
	id int auto_increment primary key,
    username varchar(50) not null unique,
    password varchar(100) not null,
    email varchar(100),
    created_at datetime default current_timestamp,
    update_at datetime on update current_timestamp
);


create table if not exists post(
	id int auto_increment primary key,
    member_id int not null,
    title varchar(200) not null,
    content text not null, 
    created_at datetime default current_timestamp,
    updated_at datetime on update current_timestamp,
    foreign key (member_id) references member(id) on delete cascade
);

select * from member;

select * from post;