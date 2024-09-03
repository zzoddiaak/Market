CREATE TABLE comments (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT,
  commenter_id BIGINT,
  comment_text TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (commenter_id) REFERENCES users(id)
);
--rollback DROP TABLE comments;
