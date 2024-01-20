insert into "USERS" (discord_id, worlds_id, star, date, email, username, password, nickname, activated) values ("dic_admin","wor_admin",3,CURRENT_TIMESTAMP,'adm@nn.c','admin','$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 1);
insert into "USERS" (discord_id, worlds_id, star, date, email, username, password, nickname, activated) values ("dic_user","wor_user",5,CURRENT_TIMESTAMP,'use@nn.c','user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 1);

insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_ADMIN');

insert into user_authority (user_id, authority_name) values (1, 'ROLE_USER');
insert into user_authority (user_id, authority_name) values (1, 'ROLE_ADMIN');
insert into user_authority (user_id, authority_name) values (2, 'ROLE_USER');