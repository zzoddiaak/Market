CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  credential_id BIGINT UNIQUE,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  bio TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (credential_id) REFERENCES user_credentials(id)
);
-- rollback DROP TABLE users;