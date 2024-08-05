INSERT INTO user_credentials (username, password)
VALUES
    ('user1', 'password1'),
    ('user2', 'password2'),
    ('user3', 'password3'),
    ('user4', 'password4'),
    ('user5', 'password5');

INSERT INTO users (credential_id, first_name, last_name, bio)
VALUES
    (1, 'First1', 'Last1', 'Bio for user 1'),
    (2, 'First2', 'Last2', 'Bio for user 2'),
    (3, 'First3', 'Last3', 'Bio for user 3'),
    (4, 'First4', 'Last4', 'Bio for user 4'),
    (5, 'First5', 'Last5', 'Bio for user 5');

INSERT INTO roles (name) VALUES ('user'), ('admin');

INSERT INTO user_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 1),
    (1, 2);

INSERT INTO categories (name)
VALUES
    ('Category 1'),
    ('Category 2'),
    ('Category 3'),
    ('Category 4'),
    ('Category 5');

INSERT INTO listings (user_id, title, description, price, negotiable, listing_type, item_type, address, rental_price)
VALUES
    (1, 'Title 1', 'Description for listing 1', 10.00, false, 'purchase', 'Item Type 1', 'Address 1', 5.00),
    (2, 'Title 2', 'Description for listing 2', 20.00, true, 'rental', 'Item Type 2', 'Address 2', 10.00),
    (3, 'Title 3', 'Description for listing 3', 30.00, false, 'exchange', 'Item Type 3', 'Address 3', 15.00),
    (4, 'Title 4', 'Description for listing 4', 40.00, true, 'purchase', 'Item Type 4', 'Address 4', 20.00),
    (5, 'Title 5', 'Description for listing 5', 50.00, false, 'rental', 'Item Type 5', 'Address 5', 25.00);

INSERT INTO listing_categories (listing_id, category_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

INSERT INTO comments (user_id, commenter_id, comment_text)
VALUES
    (1, 2, 'Comment text for user 1'),
    (2, 3, 'Comment text for user 2'),
    (3, 4, 'Comment text for user 3'),
    (4, 5, 'Comment text for user 4'),
    (5, 1, 'Comment text for user 5');

INSERT INTO listing_requests (listing_id, requester_id, offered_price)
VALUES
    (1, 2, 15.00),
    (2, 3, 25.00),
    (3, 4, 35.00),
    (4, 5, 45.00),
    (5, 1, 55.00);

INSERT INTO transactions (request_id)
VALUES
    (1),
    (2),
    (3),
    (4),
    (5);

INSERT INTO bookings (listing_id, user_id, start_date, end_date)
VALUES
    (1, 2, CURRENT_DATE + 1, CURRENT_DATE + 7),
    (2, 3, CURRENT_DATE + 2, CURRENT_DATE + 8),
    (3, 4, CURRENT_DATE + 3, CURRENT_DATE + 9),
    (4, 5, CURRENT_DATE + 4, CURRENT_DATE + 10),
    (5, 1, CURRENT_DATE + 5, CURRENT_DATE + 11);

INSERT INTO user_ratings (rater_id, rated_user_id, rating)
VALUES
    (1, 2, 5),
    (2, 3, 4),
    (3, 4, 3),
    (4, 5, 4),
    (5, 1, 5);

INSERT INTO favorite_items (user_id, listing_id)
VALUES
    (1, 2),
    (2, 3),
    (3, 4),
    (4, 5),
    (5, 1);
