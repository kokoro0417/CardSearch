drop database if exists mtgpq;
create database mtgpq;

use mtgpq;
create table carddata(
cardname varchar(255),
color enum('Withe','Blue','Black','Red','Green','Multi','Non Color'),
mana int(10),
cardtype enum('Creature','Spell','Support'),
ability enum('','Flying','Berserker','Haste','Defender','Draw')
);

insert into carddata value
('Stalwart Aven','Withe',10,'Creature','Flying'),
('Day_s Undoing','Blue',10,'Spell',''),
('Infernal Scarring','Black',6,'Support','Draw'),
('Avaricious Dragon','Red',15,'Creature','Flying'),
('Gaea_s Revenge','Green',16,'Creature','Haste'),
('Thunderclap Wyvern','Multi',12,'Creature','Flying'),
('護法の宝珠','Non Color',8,'Support','')
;