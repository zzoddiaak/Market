CREATE TABLE user_ratings (
  id BIGSERIAL PRIMARY KEY,
  rater_id INT,
  rated_user_id INT,
  rating INT CHECK (rating BETWEEN 1 AND 5),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (rater_id) REFERENCES users(id),
  FOREIGN KEY (rated_user_id) REFERENCES users(id)
);
--rollback DROP TABLE user_ratings;
