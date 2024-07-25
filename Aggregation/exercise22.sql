DROP TABLE bookings;
DROP TABLE faсilities;

CREATE TABLE faсilities(
    facid integer PRIMARY KEY,
    name varchar(100),
    membercost numeric,
    guestcost numeric,
    initialoutlay numeric,
    monthlymaintenance numeric
);


CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    facid integer,
	memid integer,
    slots integer
);

insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(0, 'Tennis Court 1', 5, 25, 10000, 200);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(1, 'Tennis Court 2', 5, 25, 8000, 200);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(2, 'Badminton Court', 0, 15.5, 4000, 50);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(3, 'Table Tennis', 0, 5, 320, 10);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(4, 'Massage Room 1', 35, 80, 4000, 3000);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(5, 'Massage Room 2', 35, 80, 4000, 3000);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(6, 'Squash Court', 3.5, 17.5, 5000, 80);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(7, 'Snooker Table', 0, 5, 450, 15);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(8, 'Pool Table', 0, 5, 400, 15);

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


SELECT 	facs.name as name, facs.initialoutlay/((sum(case
WHEN memid = 0 
THEN slots * facs.guestcost
ELSE slots * membercost
END)/3) - facs.monthlymaintenance) as months
FROM bookings bks
INNER JOIN faсilities facs
ON bks.facid = facs.facid
GROUP BY facs.facid
ORDER BY name;   
