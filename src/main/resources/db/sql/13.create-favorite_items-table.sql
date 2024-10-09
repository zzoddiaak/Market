CREATE TABLE favorite_items (
  user_id BIGINT,
  listing_id BIGINT,
  PRIMARY KEY (user_id, listing_id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (listing_id) REFERENCES listings(id)
);
--rollback DROP TABLE user_ratings;
