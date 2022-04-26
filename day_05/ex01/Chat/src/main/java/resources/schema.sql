drop table if exists messages, chat_rooms, users;

create table if not exists users
(   id bigserial primary key,
    login varchar(20) not null,
    password varchar(20) not null,
    created_rooms bigint[],
    active_rooms bigint[]
);

create table if not exists chat_rooms
(   id bigserial primary key,
    name varchar not null,
    creator bigint not null,
    messages int[],
    constraint fk_user foreign key (creator) references users(id)
);

create table if not exists messages
(   id bigserial primary key,
    author bigint not null,
    chat_room bigint not null,
    text text not null,
    date timestamp not null default current_timestamp,
    constraint fk_user foreign key (author) references users(id),
    constraint fk_chat_room foreign key (chat_room) references chat_rooms(id)
);