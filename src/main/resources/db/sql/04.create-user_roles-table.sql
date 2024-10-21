CREATE TABLE user_roles (
  user_credential_id BIGINT,
  role_id BIGINT,
  PRIMARY KEY (user_credential_id, role_id),
  FOREIGN KEY (user_credential_id) REFERENCES user_credentials(id),
  FOREIGN KEY (role_id) REFERENCES roles(id)
);
-- rollback DROP TABLE user_roles;