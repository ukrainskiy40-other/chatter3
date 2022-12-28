
-- Таблица с пользователями
create table if not exists user_chatter
(
    id              bigserial     not null primary key,
    login           varchar(255)  not null,
    full_name       varchar(2048) not null,
    bcrypt_password varchar(4096),
    active          boolean       not null default false,
    deleted         boolean       not null default false
);
create unique index if not exists uix_user_chatter_login on user_chatter (lower(login));
-- Таблица с адресами email пользователя
create table if not exists user_email
(
    id              bigserial     not null primary key,
    user_chatter_id bigint        not null,
    user_email      varchar(512) not null,
    deleted         boolean       not null default false
);
create unique index if not exists uix_user_email_user_chatter_id_user_email on user_email (user_chatter_id, user_email);
alter table user_email
    add constraint fk_user_email_user_chatter_id foreign key (user_chatter_id) references user_chatter (id);

-- Таблица с сообщениями пользователя
create table if not exists message_chatter
(
    id                        bigserial    not null primary key,
    message                   varchar(512) not null,
    user_chatter_id           bigint       not null,
    return_message_chatter_id bigint,
    deleted                   boolean      not null default false
);
alter table message_chatter
    add constraint fk_message_chatter_user_chatter_id foreign key (user_chatter_id) references user_chatter (id);
alter table message_chatter
    add constraint fk_message_chatter_return_message_chatter_id foreign key (return_message_chatter_id) references message_chatter (id);


