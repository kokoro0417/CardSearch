drop database if exists mtgpq;
create database if not exists mtgpq;

use mtgpq;

drop table if exists carddata;

create table carddata(
card_id int not null primary key auto_increment,
cardname varchar(255),
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
id int not null primary key ,
user_id varchar(255),
password varchar(255)
);


insert into carddata value
(1,'Stalwart Aven','Withe',10,'Creature','cardimg/Stalwart Aven.png',50,20),
(2,'Day_s Undoing','Blue',10,'Spell','cardimg/Day_s Undoing.png',1500,4),
(3,'Infernal Scarring','Black',6,'Support','cardimg/Infernal Scarring.png',200,10),
(4,'Avaricious Dragon','Red',15,'Creature','cardimg/Avaricious Dragon.png',400,8),
(5,'Gaea_s Revenge','Green',16,'Creature','cardimg/Gaea_s Revenge.png',2000,2),
(6,'Thunderclap Wyvern','Multi',12,'Creature','cardimg/Thunderclap Wyvern.png',100,15),
(7,'護法の宝珠','Non Color',8,'Support','',150,35);


insert into adminuser value(
1,"taro","123"
);
