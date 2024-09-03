explain SELECT * FROM users u
INNER JOIN user_roles ur ON u.id = ur.user_id
INNER JOIN roles r ON ur.role_id = r.id;

explain SELECT * FROM users u
INNER JOIN listings l ON u.id = l.user_id;

explain SELECT * FROM listings l
INNER JOIN listing_categories lc ON l.id = lc.listing_id
INNER JOIN categories c ON lc.category_id = c.id;

explain SELECT * FROM listings l
INNER JOIN listing_requests lr ON l.id = lr.listing_id;

explain SELECT * FROM users u
INNER JOIN listing_requests lr ON u.id = lr.requester_id;

explain SELECT * FROM listing_requests lr
INNER JOIN transactions t ON lr.id = t.request_id;

explain SELECT * FROM listings l
INNER JOIN bookings b ON l.id = b.listing_id;

explain SELECT * FROM users u
INNER JOIN bookings b ON u.id = b.user_id;

explain SELECT * FROM users u
INNER JOIN user_ratings ur ON u.id = ur.rater_id;

explain SELECT * FROM users u
INNER JOIN favorite_items fi ON u.id = fi.user_id
INNER JOIN listings l ON fi.listing_id = l.id;
