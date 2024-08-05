CREATE TABLE favorite_items (
  user_id INT,
  listing_id INT,
  PRIMARY KEY (user_id, listing_id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (listing_id) REFERENCES listings(id)
);
