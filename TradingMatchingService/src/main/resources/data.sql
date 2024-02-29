insert into "user" (discord_id, worlds_id, star, date, email, username, password, nickname, activated) values ('dic_admin','wor_admin',3,CURRENT_TIMESTAMP,'admin@email.com','admin','$2a$10$mhn/16Qw.hl8u3Jem8r.mO9XS45LR5d3eFLuJ1N1j9eYULZZltU6W', 'admin', 1);
insert into "user" (discord_id, worlds_id, star, date, email, username, password, nickname, activated) values ('dic_user','wor_user',5,CURRENT_TIMESTAMP,'user@email.com','user','$2a$10$CkDXqN2K77pN14WvwgIXTuNj3Q.8QXHr/NRRs4gmX2C/S6u8U08Qq', 'user', 1);

insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_ADMIN');

insert into user_authority (user_id, authority_name) values (1, 'ROLE_USER');
insert into user_authority (user_id, authority_name) values (1, 'ROLE_ADMIN');
insert into user_authority (user_id, authority_name) values (2, 'ROLE_USER');