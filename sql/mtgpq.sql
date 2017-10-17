drop database if exists mtgpq;
create database if not exists mtgpq;

use mtgpq;

drop table if exists carddata;

create table carddata(
cardname varchar(255) not null primary key,
color enum('Withe','Blue','Black','Red','Green','Multi','Non Color'),
mana int(10),
cardtype enum('Creature','Spell','Support'),
imgurl varchar(255),
price int,
card_stock int
);

drop table if exists buycard;

create table buycard(
id int not null primary key auto_increment,
cardname varchar(255),
total_price int,
total_count int,
insert_date datetime
);

drop table if exists adminuser;

create table adminuser(
user_id varchar(255),
password varchar(255)
);

drop table if exists user_data;

create table user_data(
user_id varchar(255) not null primary key,
password varchar(255)
);

drop table if exists buy_card_data;

create table buy_card_data(
user_id varchar(255) not null primary key,
cardname varchar(255),
total_price int,
total_count int,
insert_date datetime
);

insert into carddata value
('Stalwart Aven','Withe',10,'Creature','cardimg/Stalwart Aven.png',50,20),
('Day_s Undoing','Blue',10,'Spell','cardimg/Day_s Undoing.png',1500,4),
('Infernal Scarring','Black',6,'Support','cardimg/Infernal Scarring.png',200,10),
('Avaricious Dragon','Red',15,'Creature','cardimg/Avaricious Dragon.png',400,8),
('Gaea_s Revenge','Green',16,'Creature','cardimg/Gaea_s Revenge.png',2000,2),
('Thunderclap Wyvern','Multi',12,'Creature','cardimg/Thunderclap Wyvern.png',100,15),
('護法の宝珠','Non Color',8,'Support','',150,35);


insert into adminuser value(
"taro","123"
);

insert into user_data value
("taro","123"),
("jiro","456"),
("hanako","789")
;
