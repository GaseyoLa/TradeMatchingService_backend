insert into "USERS" (discord_id, worlds_id, star, date, email, username, password, nickname, activated) values ('dic_admin','wor_admin',3,CURRENT_TIMESTAMP,'admin@email.com','admin','$2a$10$mhn/16Qw.hl8u3Jem8r.mO9XS45LR5d3eFLuJ1N1j9eYULZZltU6W', 'admin', 1);
insert into "USERS" (discord_id, worlds_id, star, date, email, username, password, nickname, activated) values ('dic_user','wor_user',5,CURRENT_TIMESTAMP,'user@email.com','user','$2a$10$CkDXqN2K77pN14WvwgIXTuNj3Q.8QXHr/NRRs4gmX2C/S6u8U08Qq', 'user', 1);

insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_ADMIN');

insert into user_authority (user_id, authority_name) values (1, 'ROLE_USER');
insert into user_authority (user_id, authority_name) values (1, 'ROLE_ADMIN');
insert into user_authority (user_id, authority_name) values (2, 'ROLE_USER');


insert into option_item (attack_speed, magic_attack, required_level, required_stat, sells_for, upgrade_slots, weapon_attack) values (5, 15, 0, '0', 1, 7, 15);
insert into option_item (attack_speed, required_level, required_stat, sells_for, upgrade_slots, weapon_attack) values (5, 35, 'STR 110', 40000, 7, 52);
insert into option_item (attack_speed, required_level, required_stat, sells_for, upgrade_slots, weapon_attack, effects) values (4, 35, '0', 1, 7, 48, '이동속도+15');
insert into option_item (attack_speed, magic_attack, required_level, required_stat, sells_for, upgrade_slots, weapon_attack) values (5, 52, 40, '0', 50000, 7, 52);
insert into option_item (attack_speed, required_level, required_stat, sells_for, upgrade_slots, weapon_attack) values (5, 40, 'STR 125', 90000, 7, 57);

insert into items (option_item_id, name) values (1,'하늘색 우산');
insert into items (option_item_id, name) values (2,'커틀러스');
insert into items (option_item_id, name) values (3,'붉은 채찍');
insert into items (option_item_id, name) values (4,'노란색 우산');
insert into items (option_item_id, name) values (5,'트라우스');
