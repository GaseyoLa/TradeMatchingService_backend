insert into "USERS" (discord_id, worlds_id, star, date, email, username, password, nickname, activated) values ('dic_admin','wor_admin',3,CURRENT_TIMESTAMP,'admin@email.com','admin','$2a$10$mhn/16Qw.hl8u3Jem8r.mO9XS45LR5d3eFLuJ1N1j9eYULZZltU6W', 'admin', 1);
insert into "USERS" (discord_id, worlds_id, star, date, email, username, password, nickname, activated) values ('dic_user','wor_user',5,CURRENT_TIMESTAMP,'user@email.com','user','$2a$10$CkDXqN2K77pN14WvwgIXTuNj3Q.8QXHr/NRRs4gmX2C/S6u8U08Qq', 'user', 1);

insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_ADMIN');

insert into user_authority (user_id, authority_name) values (1, 'ROLE_USER');
insert into user_authority (user_id, authority_name) values (1, 'ROLE_ADMIN');
insert into user_authority (user_id, authority_name) values (2, 'ROLE_USER');

insert into category (name, weapon_attack, magic_attack) values ('한손검', true, true);
insert into category (name, weapon_attack) values ('두손검', true);
insert into category (name, weapon_attack) values ('한손도끼', true);
/*
insert into category (name, info) values ('두손도끼');
insert into category (name, info) values ('한손둔기');
insert into category (name, info) values ('두손둔기');
insert into category (name, info) values ('창');
insert into category (name, info) values ('폴암');
insert into category (name, info) values ('활');
insert into category (name, info) values ('석궁');
insert into category (name, info) values ('완드');
insert into category (name, info) values ('스태프');
insert into category (name, info) values ('단검');
insert into category (name, info) values ('아대');
insert into category (name, info) values ('모자');
insert into category (name, info) values ('장갑');
insert into category (name, info) values ('신발');
insert into category (name, info) values ('전신');
insert into category (name, info) values ('상의');
insert into category (name, info) values ('하의');
insert into category (name, info) values ('방패');
insert into category (name, info) values ('귀고리');
insert into category (name, info) values ('망토');
insert into category (name, info) values ('반지');
insert into category (name, info) values ('주문서');
*/

insert into option_item (attack_speed, magic_attack, required_level, required_stat, sells_for, upgrade_slots, weapon_attack) values (5, 15, 0, '0', 1, 7, 15);
insert into option_item (attack_speed, required_level, required_stat, sells_for, upgrade_slots, weapon_attack) values (5, 35, 'STR 110', 40000, 7, 52);
insert into option_item (attack_speed, required_level, required_stat, sells_for, upgrade_slots, weapon_attack, effects) values (4, 35, '0', 1, 7, 48, '이동속도+15');
insert into option_item (attack_speed, magic_attack, required_level, required_stat, sells_for, upgrade_slots, weapon_attack) values (5, 52, 40, '0', 50000, 7, 52);
insert into option_item (attack_speed, required_level, required_stat, sells_for, upgrade_slots, weapon_attack) values (5, 40, 'STR 125', 90000, 7, 57);
insert into option_item(attack_speed, required_level, required_stat, sells_for, upgrade_slots, weapon_attack) values (4, 35, 'STR 115', 140000, 7, 55);
insert into option_item(attack_speed, required_level, required_stat, sells_for, upgrade_slots, weapon_attack) values (6,30, 'STR 95', 20000, 7, 47);

insert into items (category_id, option_item_id, name, image) values (1, 1,'하늘색 우산','https://maplestory.io/api/gms/62/item/1302016/icon');
insert into items (category_id, option_item_id, name) values (1, 2,'커틀러스');
insert into items (category_id, option_item_id, name) values (1, 3,'붉은 채찍');
insert into items (category_id, option_item_id, name, image) values (1, 4,'노란색 우산');
insert into items (category_id, option_item_id, name) values (1, 5,'트라우스');
insert into items (category_id, option_item_id, name) values (2, 6,'하이랜더');
insert into items (category_id, option_item_id, name) values (3, 7,'파이어 잭');
