INSERT INTO roles ("id", "name") VALUES (1, 'ADMIN');
INSERT INTO roles ("id", "name") VALUES (2, 'USER');

INSERT INTO permissions ("role_id", "permission_id") VALUES (1, 0);
INSERT INTO permissions ("role_id", "permission_id") VALUES (1, 1);
INSERT INTO permissions ("role_id", "permission_id") VALUES (1, 2);
INSERT INTO permissions ("role_id", "permission_id") VALUES (2, 0);