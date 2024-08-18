CREATE TABLE transactions (
  id BIGSERIAL PRIMARY KEY,
  request_id BIGINT,
  completed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (request_id) REFERENCES listing_requests(id)
);
--rollback DROP TABLE transactions;
