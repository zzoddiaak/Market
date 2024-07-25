DROP TABLE bookings;
DROP TABLE members;
DROP TABLE faсilities;
CREATE TABLE faсilities(
    facid integer PRIMARY KEY,
    name varchar(100),
    membercost numeric,
    guestcost numeric,
    initialoutlay numeric,
    monthlymaintenance numeric
);

CREATE TABLE members(
    memid integer PRIMARY KEY,
    surname varchar(200),
    firstname varchar(200)
);

CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    facid integer,
    memid integer,
    starttime timestamp,
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

insert into bookings(bookid, facid, memid, starttime, slots) values(2936,	4,	14,	'2012-09-14 08:00:00',	2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2937,	4,	0,	'2012-09-14 09:00:00',	2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2945,	5,	15,	'2012-09-14 09:30:00',	2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2948,	6,	0,	'2012-09-14 09:30:00',	4);
insert into bookings(bookid, facid, memid, starttime, slots) values(2938,	4,	13,	'2012-09-14 11:00:00',	2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2946,	5,	0,	'2012-09-14 11:00:00',	4);
insert into bookings(bookid, facid, memid, starttime, slots) values(2939,	4,	9,	'2012-09-14 12:00:00',	2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2949,	6,	0,	'2012-09-14 12:30:00',	2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2940,	4,	0,	'2012-09-14 13:00:00',	2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2925,	1,	0,	'2012-09-14 14:00:00',	3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2941,	4,	13,	'2012-09-14 14:00:00',	4);
insert into bookings(bookid, facid, memid, starttime, slots) values(2951,	6,	0,	'2012-09-14 15:00:00',	2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2920,	0,	0,	'2012-09-14 16:00:00',	3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2942,	4,	0,	'2012-09-14 16:00:00',	2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2926,	1,	0,	'2012-09-14 17:00:00',	6);
insert into bookings(bookid, facid, memid, starttime, slots) values(2943,	4,	6,	'2012-09-14 18:00:00',	2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2922,	0,	0,	'2012-09-14 19:00:00',	3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2944,	4,	20,	'2012-09-14 19:00:00',	2);



insert into members(memid, surname, firstname) values(0, 'GUEST', 'GUEST'	);
insert into members(memid, surname, firstname) values(1, 'Smith', 'Darren'	);
insert into members(memid, surname, firstname) values(2, 'Smith', 'Tracy'	);
insert into members(memid, surname, firstname) values(3, 'Rownam', 'Tim'		);
insert into members(memid, surname, firstname) values(4, 'Joplette', 'Janice');
insert into members(memid, surname, firstname) values(5, 'Butters', 'Gerald'	);
insert into members(memid, surname, firstname) values(6, 'Tracy', 'Burton'	 );
insert into members(memid, surname, firstname) values(7, 'Dare', 'Nancy'		);
insert into members(memid, surname, firstname) values(8, 'Boothe', 'Tim'		);
insert into members(memid, surname, firstname) values(9, 'Stibbons', 'Ponder');
insert into members(memid, surname, firstname) values(10, 'Owen', 'Charles'	);
insert into members(memid, surname, firstname) values(11, 'Jones', 'David'	);
insert into members(memid, surname, firstname) values(12, 'Baker', 'Anne'	);
insert into members(memid, surname, firstname) values(13, 'Farrell', 'Jemima' );
insert into members(memid, surname, firstname) values(14, 'Smith', 'Jack'	);
insert into members(memid, surname, firstname) values(15, 'Bader', 'Florence');
insert into members(memid, surname, firstname) values(16, 'Baker', 'Timothy'	);
insert into members(memid, surname, firstname) values(17, 'Pinker', 'David'	);
insert into members(memid, surname, firstname) values(20, 'Genting', 'Matthew');
insert into members(memid, surname, firstname) values(21, 'Mackenzie', 'Anna');
insert into members(memid, surname, firstname) values(22, 'Coplin', 'Joan'	);
insert into members(memid, surname, firstname) values(24, 'Sarwin', 'Ramnaresh');
insert into members(memid, surname, firstname) values(26, 'Jones', 'Douglas'	);
insert into members(memid, surname, firstname) values(27, 'Rumney', 'Henrietta');
insert into members(memid, surname, firstname) values(28, 'Farrell', 'David'	);
insert into members(memid, surname, firstname) values(29, 'Worthington-Smyth', 'Henry');
insert into members(memid, surname, firstname) values(30, 'Purview', 'Millicent');
insert into members(memid, surname, firstname) values(33, 'Tupperware', 'Hyacinth');
insert into members(memid, surname, firstname) values(35, 'Hunt', 'John');
insert into members(memid, surname, firstname) values(36, 'Crumpet', 'Erica');
insert into members(memid, surname, firstname) values(37, 'Smith', 'Darren');



SELECT member, facility, cost 
FROM
(
 SELECT
  mem.firstname || ' ' || mem.surname AS member,
  fac.name AS facility,
  CASE
  WHEN mem.memid = 0 THEN
  bk.slots*fac.guestcost
  ELSE
  bk.slots*fac.membercost
  END AS cost
  FROM members mem
  INNER JOIN bookings bk
  ON mem.memid = bk.memid
  INNER JOIN faсilities fac
  ON bk.facid = fac.facid
  WHERE bk.starttime >= '2012-09-14' 
  AND bk.starttime < '2012-09-15'
 ) 
AS bookings
WHERE cost > 30
ORDER BY cost DESC;