CREATE TABLE listings (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT,
  title VARCHAR(100) NOT NULL,
  description TEXT,
  price DECIMAL(10, 2),
  negotiable BOOLEAN DEFAULT FALSE,
  listing_type VARCHAR(20), -- 'purchase', 'rental', 'exchange'
  item_type VARCHAR(50) NOT NULL,
  address VARCHAR(255), -- Только для аренды
  rental_price DECIMAL(10, 2), -- Только для аренды
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);
--rollback DROP TABLE listings;
