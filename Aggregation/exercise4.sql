DROP TABLE bookings;


CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    facid integer,
    slots integer
);
insert into bookings(bookid, facid, slots) values(2936,	4,	2);
insert into bookings(bookid, facid, slots) values(2937,	4,	2);
insert into bookings(bookid, facid, slots) values(2945,	5,	2);
insert into bookings(bookid, facid, slots) values(2948,	6,	4);
insert into bookings(bookid, facid, slots) values(2938,	4,	2);
insert into bookings(bookid, facid, slots) values(2946,	5,	4);
insert into bookings(bookid, facid, slots) values(2939,	4,	2);
insert into bookings(bookid, facid, slots) values(2949,	6,	2);
insert into bookings(bookid, facid, slots) values(2940,	4,	2);
insert into bookings(bookid, facid, slots) values(2925,	1,	3);
insert into bookings(bookid, facid, slots) values(2941,	4,	4);
insert into bookings(bookid, facid, slots) values(2951,	6,	2);
insert into bookings(bookid, facid, slots) values(2920,	0,	3);
insert into bookings(bookid, facid, slots) values(2942,	4,	2);
insert into bookings(bookid, facid, slots) values(2926,	1,	6);
insert into bookings(bookid, facid, slots) values(2943,	4,	2);
insert into bookings(bookid, facid, slots) values(2922,	0,	3);
insert into bookings(bookid, facid, slots) values(2944,	4,	2);

SELECT facid, sum(slots) AS "Total Slots"
FROM bookings
GROUP BY facid
ORDER BY facid;