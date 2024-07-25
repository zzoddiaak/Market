DROP TABLE bookings;


CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    facid integer,
    starttime timestamp,
    slots integer
);



insert into bookings(bookid, facid, starttime, slots) values(2132, 0, '2012-09-01 12:30:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2133, 0, '2012-09-01 15:00:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2134, 0, '2012-09-01 17:00:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2135, 1, '2012-09-01 08:00:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2136, 1,  '2012-09-01 09:30:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2137, 1,  '2012-09-01 11:00:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2138, 1,  '2012-09-01 14:30:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2139, 1, '2012-09-01 16:30:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2140, 1,  '2012-09-01 19:00:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2141, 2, '2012-09-01 09:00:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2142, 2,  '2012-09-01 13:30:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2143, 2, '2012-09-01 16:30:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2144, 2,  '2012-09-01 18:00:00', 3);
insert into bookings(bookid, facid, starttime, slots) values(2145, 3,  '2012-09-01 08:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2146, 3,  '2012-09-01 09:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2147, 3,  '2012-09-01 10:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2148, 3,  '2012-09-01 12:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2149, 3,  '2012-09-01 14:00:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2150, 3,  '2012-09-01 15:00:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2151, 3, '2012-09-01 16:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2152, 3,  '2012-09-01 18:00:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2153, 3,  '2012-09-01 19:00:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2154, 4, '2012-09-01 08:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2155, 4, '2012-09-01 11:00:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2156, 4,  '2012-09-01 12:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2157, 4, '2012-09-01 13:30:00', 6);
insert into bookings(bookid, facid, starttime, slots) values(2158, 4, '2012-09-01 17:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2159, 4,  '2012-09-01 19:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2160, 5, '2012-09-01 09:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2161, 5, '2012-09-01 15:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2162, 6, '2012-09-01 09:30:00', 8);
insert into bookings(bookid, facid, starttime, slots) values(2163, 6, '2012-09-01 15:00:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2164, 6, '2012-09-01 16:00:00', 4);
insert into bookings(bookid, facid, starttime, slots) values(2165, 6, '2012-09-01 18:00:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2166, 7,  '2012-09-01 08:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2167, 7, '2012-09-01 11:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2168, 7, '2012-09-01 14:00:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2169, 7,  '2012-09-01 15:00:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2170, 7,  '2012-09-01 17:30:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2171, 7, '2012-09-01 19:00:00', 2);
insert into bookings(bookid, facid, starttime, slots) values(2172, 8,  '2012-09-01 10:00:00', 1);
insert into bookings(bookid, facid, starttime, slots) values(2173, 8, '2012-09-01 10:30:00', 1);
insert into bookings(bookid, facid, starttime, slots) values(2174, 8,  '2012-09-01 11:00:00', 1);
insert into bookings(bookid, facid, starttime, slots) values(2175, 8,  '2012-09-01 11:30:00', 1);
insert into bookings(bookid, facid, starttime, slots) values(2176, 8,  '2012-09-01 15:00:00', 1);
insert into bookings(bookid, facid, starttime, slots) values(2177, 8, '2012-09-01 16:00:00', 1);
insert into bookings(bookid, facid, starttime, slots) values(2178, 8,  '2012-09-01 18:00:00', 1);
insert into bookings(bookid, facid, starttime, slots) values(2179, 8, '2012-09-01 18:30:00', 1);
insert into bookings(bookid, facid, starttime, slots) values(2180, 8, '2012-09-01 19:30:00', 1);



SELECT facid, EXTRACT(MONTH FROM starttime) AS month ,sum(slots) AS "Total Slots"
FROM bookings 
WHERE EXTRACT(YEAR FROM starttime) = 2012
GROUP BY facid, month
ORDER BY facid, month;
