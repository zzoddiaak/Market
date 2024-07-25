DROP TABLE bookings;
DROP TABLE members;

CREATE TABLE members(
    memid integer PRIMARY KEY,
    surname varchar(200),
    firstname varchar(200)
);
CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    memid integer,
    starttime timestamp
);
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

insert into bookings(bookid,  memid, starttime) values(2130, 0, '2012-09-01 08:00:00');
insert into bookings(bookid,  memid, starttime) values(2131, 17, '2012-09-01 11:00:00');
insert into bookings(bookid,  memid, starttime) values(2132, 7, '2012-09-01 12:30:00');
insert into bookings(bookid,  memid, starttime) values(2133, 6, '2012-09-01 15:00:00');
insert into bookings(bookid,  memid, starttime) values(2134, 4, '2012-09-01 17:00:00');
insert into bookings(bookid,  memid, starttime) values(2135, 0, '2012-09-01 08:00:00');
insert into bookings(bookid,  memid, starttime) values(2136, 11, '2012-09-01 09:30:00');
insert into bookings(bookid,  memid, starttime) values(2137, 10, '2012-09-01 11:00:00');
insert into bookings(bookid,  memid, starttime) values(2138, 12, '2012-09-01 14:30:00');
insert into bookings(bookid,  memid, starttime) values(2139, 0, '2012-09-01 16:30:00');
insert into bookings(bookid,  memid, starttime) values(2140, 12, '2012-09-01 19:00:00');
insert into bookings(bookid,  memid, starttime) values(2141, 1, '2012-09-01 09:00:00');
insert into bookings(bookid,  memid, starttime) values(2142, 21, '2012-09-01 13:30:00');
insert into bookings(bookid,  memid, starttime) values(2143, 1, '2012-09-01 16:30:00');
insert into bookings(bookid,  memid, starttime) values(2144, 15, '2012-09-01 18:00:00');
insert into bookings(bookid,  memid, starttime) values(2145, 17, '2012-09-01 08:30:00');
insert into bookings(bookid,  memid, starttime) values(2146, 13, '2012-09-01 09:30:00');
insert into bookings(bookid,  memid, starttime) values(2147, 15, '2012-09-01 10:30:00');
insert into bookings(bookid,  memid, starttime) values(2148, 17, '2012-09-01 12:30:00');
insert into bookings(bookid,  memid, starttime) values(2149, 17, '2012-09-01 14:00:00');
insert into bookings(bookid,  memid, starttime) values(2150, 16, '2012-09-01 15:00:00');
insert into bookings(bookid,  memid, starttime) values(2151, 0, '2012-09-01 16:30:00');
insert into bookings(bookid,  memid, starttime) values(2152, 16, '2012-09-01 18:00:00');
insert into bookings(bookid,  memid, starttime) values(2153, 17, '2012-09-01 19:00:00');
insert into bookings(bookid,  memid, starttime) values(2154, 8, '2012-09-01 08:30:00');
insert into bookings(bookid,  memid, starttime) values(2155, 9, '2012-09-01 11:00:00');
insert into bookings(bookid,  memid, starttime) values(2156, 11, '2012-09-01 12:30:00');
insert into bookings(bookid,  memid, starttime) values(2157, 0, '2012-09-01 13:30:00');
insert into bookings(bookid,  memid, starttime) values(2158, 0, '2012-09-01 17:30:00');
insert into bookings(bookid,  memid, starttime) values(2159, 16, '2012-09-01 19:30:00');
insert into bookings(bookid,  memid, starttime) values(2160, 0, '2012-09-01 09:30:00');
insert into bookings(bookid,  memid, starttime) values(2161, 7, '2012-09-01 15:30:00');
insert into bookings(bookid,  memid, starttime) values(2162, 0, '2012-09-01 09:30:00');
insert into bookings(bookid,  memid, starttime) values(2163, 4, '2012-09-01 15:00:00');
insert into bookings(bookid,  memid, starttime) values(2164, 0, '2012-09-01 16:00:00');
insert into bookings(bookid,  memid, starttime) values(2165, 2, '2012-09-01 18:00:00');
insert into bookings(bookid,  memid, starttime) values(2166, 21, '2012-09-01 08:30:00');
insert into bookings(bookid,  memid, starttime) values(2167, 2, '2012-09-01 11:30:00');
insert into bookings(bookid,  memid, starttime) values(2168, 1, '2012-09-01 14:00:00');
insert into bookings(bookid,  memid, starttime) values(2169, 15, '2012-09-01 15:00:00');
insert into bookings(bookid,  memid, starttime) values(2170, 13, '2012-09-01 17:30:00');
insert into bookings(bookid,  memid, starttime) values(2171, 9, '2012-09-01 19:00:00');
insert into bookings(bookid,  memid, starttime) values(2172, 17, '2012-09-01 10:00:00');
insert into bookings(bookid,  memid, starttime) values(2173, 1, '2012-09-01 10:30:00');
insert into bookings(bookid,  memid, starttime) values(2174, 14, '2012-09-01 11:00:00');
insert into bookings(bookid,  memid, starttime) values(2175, 21, '2012-09-01 11:30:00');
insert into bookings(bookid,  memid, starttime) values(2176, 21, '2012-09-01 15:00:00');
insert into bookings(bookid,  memid, starttime) values(2177, 3, '2012-09-01 16:00:00');
insert into bookings(bookid,  memid, starttime) values(2178, 20, '2012-09-01 18:00:00');
insert into bookings(bookid,  memid, starttime) values(2179, 3, '2012-09-01 18:30:00');
insert into bookings(bookid,  memid, starttime) values(2180, 7, '2012-09-01 19:30:00');


SELECT mem.surname, mem.firstname, mem.memid, min(bk.starttime) as starttime
FROM bookings bk
INNER JOIN members mem on
mem.memid = bk.memid
WHERE starttime >= '2012-09-01'
GROUP BY mem.surname, mem.firstname, mem.memid
ORDER BY mem.memid;   