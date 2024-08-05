CREATE TABLE transactions (
  id SERIAL PRIMARY KEY,
  request_id INT,
  completed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (request_id) REFERENCES listing_requests(id)
);
