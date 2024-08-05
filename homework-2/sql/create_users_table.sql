CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  credential_id INT UNIQUE,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  bio TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (credential_id) REFERENCES user_credentials(id)
);