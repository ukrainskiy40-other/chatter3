create or replace view message_user_chatter_view AS
    SELECT
        m.id,
        m.message,
        u.id as user_chatter_id,
        u.login as user_chatter_login,
        u.full_name as user_chatter_full_name
    from message_chatter m
    join user_chatter u on u.id = m.user_chatter_id;
    