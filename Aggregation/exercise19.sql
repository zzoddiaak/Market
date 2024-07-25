DROP TABLE members;
DROP TABLE bookings;

CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    facid integer,
    memid integer,
    starttime timestamp,
    slots integer
);

CREATE TABLE members(
    memid integer PRIMARY KEY,
    surname varchar(200),
    firstname varchar(200)
);

insert into bookings(bookid, memid,  slots) values(2936,		14,	2);
insert into bookings(bookid, memid,  slots) values(2937,		0,		2);
insert into bookings(bookid, memid,  slots) values(2945,		15,	2);
insert into bookings(bookid, memid,  slots) values(2948,		0,		4);
insert into bookings(bookid, memid,  slots) values(2938,		13,	2);
insert into bookings(bookid, memid,  slots) values(2946,		0,		4);
insert into bookings(bookid, memid,  slots) values(2939,		9,		2);
insert into bookings(bookid, memid,  slots) values(2949,		0,		2);
insert into bookings(bookid, memid,  slots) values(2940,		0,		2);
insert into bookings(bookid, memid,  slots) values(2925,		0,		3);
insert into bookings(bookid, memid,  slots) values(2941,		13,	4);
insert into bookings(bookid, memid,  slots) values(2951,		0,		2);
insert into bookings(bookid, memid,  slots) values(2920,		0,		3);
insert into bookings(bookid, memid,  slots) values(2942,		0,		2);
insert into bookings(bookid, memid,  slots) values(2926,		0,		6);
insert into bookings(bookid, memid,  slots) values(2943,		6,		2);
insert into bookings(bookid, memid,  slots) values(2922,		0,		3);
insert into bookings(bookid, memid,  slots) values(2944,		20,	2);
	
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

SELECT firstname, surname,
((sum(bk.slots)+10)/20)*10 as hours,
rank() over (order by ((sum(bk.slots)+10)/20)*10 desc) as rank
FROM bookings bk
INNER JOIN members mem
ON bk.memid = mem.memid
GROUP BY mem.memid
ORDER BY rank, surname, firstname; 