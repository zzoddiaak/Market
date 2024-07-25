DROP TABLE bookings;
DROP TABLE members;
DROP TABLE faсilities;

CREATE TABLE faсilities(
    facid integer PRIMARY KEY,
    name varchar(100)
);
CREATE TABLE members(
    memid integer PRIMARY KEY,
    surname varchar(200),
    firstname varchar(200)
);

CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    facid integer,
    memid integer
);



insert into bookings(bookid,  facid, memid)   values (968	,1,10);
insert into bookings(bookid,  facid, memid)   values (1289,	0 ,	5);
insert into bookings(bookid,  facid, memid)   values (1234,	0 ,	5);
insert into bookings(bookid,  facid, memid)   values (1006,	1 ,10);
insert into bookings(bookid,  facid, memid)   values (1491,	1 ,	9);
insert into bookings(bookid,  facid, memid)   values (240	,0 ,5 );
insert into bookings(bookid,  facid, memid)   values (194	,0 ,5 );
insert into bookings(bookid,  facid, memid)   values (2134,	0 ,	4);
insert into bookings(bookid,  facid, memid)   values (1445,	1 ,10);
insert into bookings(bookid,  facid, memid)   values (1197,	1 ,	0);
insert into bookings(bookid,  facid, memid)   values (3646,	1 ,	0);
insert into bookings(bookid,  facid, memid)   values (3638,	0 ,	0);
insert into bookings(bookid,  facid, memid)   values (771	,1 ,0);
insert into bookings(bookid,  facid, memid)   values (2662,	1 ,24);
insert into bookings(bookid,  facid, memid)   values (242	,1 ,0);
insert into bookings(bookid,  facid, memid)   values (3904,	1 ,	0);
insert into bookings(bookid,  facid, memid)   values (3368,	1 ,	1);
insert into bookings(bookid,  facid, memid)   values (3504,	1 ,	0);
insert into bookings(bookid,  facid, memid)   values (1589,	0 ,16);
insert into bookings(bookid,  facid, memid)   values (1193,	0 ,10);
insert into bookings(bookid,  facid, memid)   values (732	,0 ,6);
insert into bookings(bookid,  facid, memid)   values (3697,	0 ,	5);
insert into bookings(bookid,  facid, memid)   values (3173,	0 ,14);
insert into bookings(bookid,  facid, memid)   values (350	,1 ,5);
insert into bookings(bookid,  facid, memid)   values (108	,0 ,2);
insert into bookings(bookid,  facid, memid)   values (433	,1 ,1);
insert into bookings(bookid,  facid, memid)   values (2358,	0 ,17);
insert into bookings(bookid,  facid, memid)   values (3233,	0 ,28);
insert into bookings(bookid,  facid, memid)   values (2243,	1 ,	0);
insert into bookings(bookid,  facid, memid)   values (1003,	0 ,	5);
insert into bookings(bookid,  facid, memid)   values (1755,	1 ,	9);
insert into bookings(bookid,  facid, memid)   values (586	,0 ,6);
insert into bookings(bookid,  facid, memid)   values (1806,	0 ,	6);
insert into bookings(bookid,  facid, memid)   values (1243,	1 ,	8);
insert into bookings(bookid,  facid, memid)   values (3370,	1 ,10);
insert into bookings(bookid,  facid, memid)   values (2477,	0 ,14);
insert into bookings(bookid,  facid, memid)   values (3770,	1 ,	0);
insert into bookings(bookid,  facid, memid)   values (3642,	1 ,	0);
insert into bookings(bookid,  facid, memid)   values (2187,	1 ,11);
insert into bookings(bookid,  facid, memid)   values (1054,	0 ,	0);
insert into bookings(bookid,  facid, memid)   values (2853,	1 ,	0);
insert into bookings(bookid,  facid, memid)   values (3110,	1 ,	0);
insert into bookings(bookid,  facid, memid)   values (2590,	0 ,	5);
insert into bookings(bookid,  facid, memid)   values (1107,	1 ,	8);
insert into bookings(bookid,  facid, memid)   values (432	,0 ,0);
insert into bookings(bookid,  facid, memid)   values (2847,	0 ,	0);
insert into bookings(bookid,  facid, memid)   values (563	,0 ,0);
insert into bookings(bookid,  facid, memid)   values (325	,0 ,5);
insert into bookings(bookid,  facid, memid)   values (181	,1 ,3);
insert into bookings(bookid,  facid, memid)   values (849	,1 ,9);



insert into faсilities(facid, name) values(0, 'Tennis Court 1');
insert into faсilities(facid, name) values(1, 'Tennis Court 2');
insert into faсilities(facid, name) values(2, 'Badminton Court');
insert into faсilities(facid, name) values(3, 'Table Tennis');
insert into faсilities(facid, name) values(4, 'Massage Room 1');
insert into faсilities(facid, name) values(5, 'Massage Room 2');
insert into faсilities(facid, name) values(6, 'Squash Court');
insert into faсilities(facid, name) values(7, 'Snooker Table');
insert into faсilities(facid, name) values(8, 'Pool Table');

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

SELECT DISTINCT mem.firstname || ' ' || mem.surname as member, fac.name as facility
FROM members mem, faсilities fac, bookings bk
WHERE fac.name in ('Tennis Court 1', 'Tennis Court 2')
AND mem.memid = bk.memid
AND bk.facid = fac.facid
ORDER BY member, facility;