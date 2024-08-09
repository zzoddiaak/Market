CREATE TABLE bookings (
  id BIGSERIAL PRIMARY KEY,
  listing_id BIGINT,
  user_id BIGINT,
  start_date DATE,
  end_date DATE,
  status VARCHAR(20) DEFAULT 'pending',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (listing_id) REFERENCES listings(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);
--rollback DROP TABLE bookings;
