CREATE TABLE listing_categories (
  listing_id BIGINT,
  category_id BIGINT,
  PRIMARY KEY (listing_id, category_id),
  FOREIGN KEY (listing_id) REFERENCES listings(id),
  FOREIGN KEY (category_id) REFERENCES categories(id)
);
--rollback DROP TABLE listing_categories;
