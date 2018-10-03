-- Passwords are same as corresponding usernames
INSERT INTO users ("id", "name", "password_hash") VALUES (1, 'admin', '$2a$10$vqjSFNSRKdTczpm.xTKZJuoiJ4VXPhmKII2rJ9FOGgNlGa1yBZ2C6');
INSERT INTO users ("id", "name", "password_hash") VALUES (2, 'user', '$2a$10$2LDzugB6LyO9dHT9po8Y2Otq2bBbeiCuBdGO.rakto62r1xVgZ2/a');

INSERT INTO roles ("id", "name") VALUES (1, 'ADMIN');
INSERT INTO roles ("id", "name") VALUES (2, 'USER');

INSERT INTO jt_roles ("user_id", "role_id") VALUES (1, 1);
INSERT INTO jt_roles ("user_id", "role_id") VALUES (2, 2);

INSERT INTO permissions ("role_id", "permission_id") VALUES (1, 0);
INSERT INTO permissions ("role_id", "permission_id") VALUES (1, 1);
INSERT INTO permissions ("role_id", "permission_id") VALUES (2, 1);