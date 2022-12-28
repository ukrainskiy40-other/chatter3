
CREATE TABLE IF NOT EXISTS user_role (
    id bigserial NOT NULL PRIMARY KEY,
    role_name varchar(255) NOT NULL UNIQUE
);

INSERT INTO user_role(id, role_name) VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');


ALTER TABLE user_chatter ADD COLUMN password_bcrypt varchar(2048) NOT NULL;
ALTER TABLE user_chatter ADD COLUMN user_role_id bigint NOT NULL;

alter table user_chatter add CONSTRAINT fk_user_chatter_user_role_id FOREIGN KEY (user_role_id) REFERENCES user_role(id);


-- пользователь admin, пароль - password
INSERT INTO user_chatter(login, full_name, password_bcrypt, user_role_id) VALUES ('admin', 'ADMINISTRATOR', '$2a$12$ISkGJEEPR7I24altoMQNFu42sSpzoIE59Y2tmacCdBjTe47FQL85W', 2);
