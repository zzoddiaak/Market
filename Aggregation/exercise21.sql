DROP TABLE bookings;
DROP TABLE faсilities;

CREATE TABLE faсilities(
    facid integer PRIMARY KEY,
    name varchar(100),
    membercost numeric,
    guestcost numeric
    
);


CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    facid integer,
	memid integer,
    slots integer
);
insert into faсilities(facid, name, membercost, guestcost) values(0, 'Tennis Court 1', 5, 25);
insert into faсilities(facid, name, membercost, guestcost) values(1, 'Tennis Court 2', 5, 25);
insert into faсilities(facid, name, membercost, guestcost) values(2, 'Badminton Court', 0, 15.5);
insert into faсilities(facid, name, membercost, guestcost) values(3, 'Table Tennis', 0, 5);
insert into faсilities(facid, name, membercost, guestcost) values(4, 'Massage Room 1', 35, 80);
insert into faсilities(facid, name, membercost, guestcost) values(5, 'Massage Room 2', 35, 80);
insert into faсilities(facid, name, membercost, guestcost) values(6, 'Squash Court', 3.5, 17.5);
insert into faсilities(facid, name, membercost, guestcost) values(7, 'Snooker Table', 0, 5);
insert into faсilities(facid, name, membercost, guestcost) values(8, 'Pool Table', 0, 5);

insert into bookings(bookid, facid, memid,  slots) values(2936,	4,	14,	2);
insert into bookings(bookid, facid, memid,  slots) values(2937,	4,	0,		2);
insert into bookings(bookid, facid, memid,  slots) values(2945,	5,	15,	2);
insert into bookings(bookid, facid, memid,  slots) values(2948,	6,	0,		4);
insert into bookings(bookid, facid, memid,  slots) values(2938,	4,	13,	2);
insert into bookings(bookid, facid, memid,  slots) values(2946,	5,	0,		4);
insert into bookings(bookid, facid, memid,  slots) values(2939,	4,	9,		2);
insert into bookings(bookid, facid, memid,  slots) values(2949,	6,	0,		2);
insert into bookings(bookid, facid, memid,  slots) values(2940,	4,	0,		2);
insert into bookings(bookid, facid, memid,  slots) values(2925,	1,	0,		3);
insert into bookings(bookid, facid, memid,  slots) values(2941,	4,	13,	4);
insert into bookings(bookid, facid, memid,  slots) values(2951,	6,	0,		2);
insert into bookings(bookid, facid, memid,  slots) values(2920,	0,	0,		3);
insert into bookings(bookid, facid, memid,  slots) values(2942,	4,	0,		2);
insert into bookings(bookid, facid, memid,  slots) values(2926,	1,	0,		6);
insert into bookings(bookid, facid, memid,  slots) values(2943,	4,	6,		2);
insert into bookings(bookid, facid, memid,  slots) values(2922,	0,	0,		3);
insert into bookings(bookid, facid, memid,  slots) values(2944,	4,	20,	2);


SELECT name, case when class=1 then 'high'
WHEN class=2 
THEN 'average'
ELSE 'low'
END revenue
FROM (
SELECT facs.name as name, ntile(3) over (order by sum(case
WHEN memid = 0 then slots * facs.guestcost
ELSE slots * membercost
END) desc) as class
FROM bookings bks
INNER JOIN faсilities facs
ON bks.facid = facs.facid
GROUP BY facs.name) as subq
ORDER BY class, name;    