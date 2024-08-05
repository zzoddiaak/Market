CREATE TABLE listing_categories (
  listing_id INT,
  category_id INT,
  PRIMARY KEY (listing_id, category_id),
  FOREIGN KEY (listing_id) REFERENCES listings(id),
  FOREIGN KEY (category_id) REFERENCES categories(id)
);