
insert into users (login, password, created_rooms, active_rooms) values ('Anna', '123456789', array [1], array [1]);
insert into users (login, password, created_rooms, active_rooms) values ('Petya', '123456789', array [2], array [2]);
insert into users (login, password, created_rooms, active_rooms) values ('Vasya', '123456789', array [3], array [3]);
insert into users (login, password, created_rooms, active_rooms) values ('Nastya', '123456789', array [4], array [4]);
insert into users (login, password, created_rooms, active_rooms) values ('John', '123456789', array [5], array [5]);

insert into chat_rooms (name, creator)
select 'My first chat ' || login, id from users;

insert into messages (author, chat_room, text)
select users.id, chat_rooms.id, 'Hi, my name is ' || users.login
from users
left join chat_rooms on users.id = chat_rooms.creator;

update messages
set text = 'sfafd'
where id = 3;