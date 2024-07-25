DROP TABLE bookings;
DROP TABLE faсilities;
CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    facid integer,
    starttime timestamp
);
CREATE TABLE faсilities(
    facid integer PRIMARY KEY,
    name varchar(100)
);

insert into bookings(bookid,  facid, starttime) values(3360,	0,	'2012-09-21 08:00:00');
insert into bookings(bookid,  facid, starttime) values(3366,	1,	'2012-09-21 08:00:00');
insert into bookings(bookid,  facid, starttime) values(3361,	0,	'2012-09-21 09:30:00');
insert into bookings(bookid,  facid, starttime) values(3367,	1,	'2012-09-21 10:00:00');
insert into bookings(bookid,  facid, starttime) values(3368,	1,	'2012-09-21 11:30:00');
insert into bookings(bookid,  facid, starttime) values(3362,	0,	'2012-09-21 12:00:00');
insert into bookings(bookid,  facid, starttime) values(3363,	0,	'2012-09-21 13:30:00');
insert into bookings(bookid,  facid, starttime) values(3369,	1,	'2012-09-21 14:00:00');
insert into bookings(bookid,  facid, starttime) values(3364,	0,	'2012-09-21 15:30:00');
insert into bookings(bookid,  facid, starttime) values(3370,	1,	'2012-09-21 16:00:00');
insert into bookings(bookid,  facid, starttime) values(3365,	0,	'2012-09-21 17:00:00');
insert into bookings(bookid,  facid, starttime) values(3371,	1,	'2012-09-21 18:00:00');

insert into faсilities(facid, name) values(0, 'Tennis Court 1');
insert into faсilities(facid, name) values(1, 'Tennis Court 2');
insert into faсilities(facid, name) values(2, 'Badminton Court');
insert into faсilities(facid, name) values(3, 'Table Tennis');
insert into faсilities(facid, name) values(4, 'Massage Room 1');
insert into faсilities(facid, name) values(5, 'Massage Room 2');
insert into faсilities(facid, name) values(6, 'Squash Court');
insert into faсilities(facid, name) values(7, 'Snooker Table');
insert into faсilities(facid, name) values(8, 'Pool Table');



SELECT book.starttime as start, fc.name 
FROM bookings book,
      faсilities fc
WHERE fc.name in ('Tennis Court 1', 'Tennis Court 2') 
AND book.starttime >= '2012-09-21'
AND book.starttime < '2012-09-22'
AND book.facid = fc.facid
ORDER BY book.starttime;