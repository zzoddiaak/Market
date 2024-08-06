CREATE TABLE comments (
  id BIGSERIAL PRIMARY KEY,
  user_id INT,
  commenter_id INT,
  comment_text TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (commenter_id) REFERENCES users(id)
);
