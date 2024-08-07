CREATE TABLE listing_requests (
  id BIGSERIAL PRIMARY KEY,
  listing_id INT,
  requester_id INT,
  offered_price DECIMAL(10, 2), -- Для покупки и обмена
  status VARCHAR(20) DEFAULT 'pending', -- 'pending', 'accepted', 'rejected'
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (listing_id) REFERENCES listings(id),
  FOREIGN KEY (requester_id) REFERENCES users(id)
);
--rollback DROP TABLE listing_requests;
