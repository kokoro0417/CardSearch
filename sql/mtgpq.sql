drop database if exists mtgpq;
create database mtgpq;

use mtgpq;
create table carddata(
cardname varchar(255),
color enum('Withe','Blue','Black','Red','Green','Multi','Non Color'),
mana int(10),
cardtype enum('Creature','Spell','Support'),
ability enum('','Flying','Berserker','Haste','Defender','Draw'),
imgurl varchar(255)
);

insert into carddata value
('Stalwart Aven','Withe',10,'Creature','Flying','cardimg/Stalwart Aven.png'),
('Day_s Undoing','Blue',10,'Spell','','cardimg/Day_s Undoing.png'),
('Infernal Scarring','Black',6,'Support','Draw','cardimg/Infernal Scarring.png'),
('Avaricious Dragon','Red',15,'Creature','Flying','cardimg/Avaricious Dragon.png'),
('Gaea_s Revenge','Green',16,'Creature','Haste','cardimg/Gaea_s Revenge.png'),
('Thunderclap Wyvern','Multi',12,'Creature','Flying','cardimg/Thunderclap Wyvern.png'),
('護法の宝珠','Non Color',8,'Support','','')
;