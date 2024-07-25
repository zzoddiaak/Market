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

insert into bookings(bookid,  memid, starttime) values(3167,	28,	'2012-09-18 09:00:00');
insert into bookings(bookid,  memid, starttime) values(3172,	28,	'2012-09-18 17:30:00');
insert into bookings(bookid,  memid, starttime) values(3219,	28,	'2012-09-18 13:30:00');
insert into bookings(bookid,  memid, starttime) values(3229,	28,	'2012-09-18 20:00:00');
insert into bookings(bookid,  memid, starttime) values(3231,	28,	'2012-09-19 09:30:00');
insert into bookings(bookid,  memid, starttime) values(3233,	28,	'2012-09-19 15:00:00');
insert into bookings(bookid,  memid, starttime) values(3288,	28,	'2012-09-19 12:00:00');
insert into bookings(bookid,  memid, starttime) values(3335,	28,	'2012-09-20 15:30:00');
insert into bookings(bookid,  memid, starttime) values(3351,	28,	'2012-09-20 11:30:00');
insert into bookings(bookid,  memid, starttime) values(3356,	28,	'2012-09-20 14:00:00');
insert into bookings(bookid,  memid, starttime) values(3415,	28,	'2012-09-21 10:30:00');
insert into bookings(bookid,  memid, starttime) values(3419,	28,	'2012-09-21 14:00:00');
insert into bookings(bookid,  memid, starttime) values(3479,	28,	'2012-09-22 08:30:00');
insert into bookings(bookid,  memid, starttime) values(3487,	28,	'2012-09-22 17:00:00');
insert into bookings(bookid,  memid, starttime) values(3546,	28,	'2012-09-23 08:30:00');
insert into bookings(bookid,  memid, starttime) values(3559,	28,	'2012-09-23 17:30:00');
insert into bookings(bookid,  memid, starttime) values(3561,	28,	'2012-09-23 19:00:00');
insert into bookings(bookid,  memid, starttime) values(3568,	28,	'2012-09-24 08:00:00');
insert into bookings(bookid,  memid, starttime) values(3616,	28,	'2012-09-24 16:30:00');
insert into bookings(bookid,  memid, starttime) values(3625,	28,	'2012-09-24 12:30:00');
insert into bookings(bookid,  memid, starttime) values(3691,	28,	'2012-09-25 15:30:00');
insert into bookings(bookid,  memid, starttime) values(3692,	28,	'2012-09-25 17:00:00');
insert into bookings(bookid,  memid, starttime) values(3755,	28,	'2012-09-26 13:00:00');
insert into bookings(bookid,  memid, starttime) values(3759,	28,	'2012-09-26 17:00:00');
insert into bookings(bookid,  memid, starttime) values(3814,	28,	'2012-09-27 08:00:00');
insert into bookings(bookid,  memid, starttime) values(3831,	28,	'2012-09-28 11:30:00');
insert into bookings(bookid,  memid, starttime) values(3885,	28,	'2012-09-28 09:30:00');
insert into bookings(bookid,  memid, starttime) values(3889,	28,	'2012-09-28 13:00:00');
insert into bookings(bookid,  memid, starttime) values(3902,	28,	'2012-09-29 16:00:00');
insert into bookings(bookid,  memid, starttime) values(3959,	28,	'2012-09-29 10:30:00');
insert into bookings(bookid,  memid, starttime) values(3963,	28,	'2012-09-29 13:30:00');
insert into bookings(bookid,  memid, starttime) values(3965,	28,	'2012-09-29 14:30:00');
insert into bookings(bookid,  memid, starttime) values(3969,	28,	'2012-09-29 17:30:00');
insert into bookings(bookid,  memid, starttime) values(4036,	28,	'2012-09-30 14:30:00');

insert into members(memid, surname, firstname) values(0, 'GUEST', 'GUEST');
insert into members(memid, surname, firstname) values(1, 'Smith', 'Darren');
insert into members(memid, surname, firstname) values(2, 'Smith', 'Tracy');
insert into members(memid, surname, firstname) values(3, 'Rownam', 'Tim');
insert into members(memid, surname, firstname) values(4, 'Joplette', 'Janice');
insert into members(memid, surname, firstname) values(5, 'Butters', 'Gerald');
insert into members(memid, surname, firstname) values(6, 'Tracy', 'Burton');
insert into members(memid, surname, firstname) values(7, 'Dare', 'Nancy');
insert into members(memid, surname, firstname) values(8, 'Boothe', 'Tim');
insert into members(memid, surname, firstname) values(9, 'Stibbons', 'Ponder');
insert into members(memid, surname, firstname) values(10, 'Owen', 'Charles');
insert into members(memid, surname, firstname) values(11, 'Jones', 'David');
insert into members(memid, surname, firstname) values(12, 'Baker', 'Anne');
insert into members(memid, surname, firstname) values(13, 'Farrell', 'Jemima');
insert into members(memid, surname, firstname) values(14, 'Smith', 'Jack');
insert into members(memid, surname, firstname) values(15, 'Bader', 'Florence');
insert into members(memid, surname, firstname) values(16, 'Baker', 'Timothy');
insert into members(memid, surname, firstname) values(17, 'Pinker', 'David');
insert into members(memid, surname, firstname) values(20, 'Genting', 'Matthew');
insert into members(memid, surname, firstname) values(21, 'Mackenzie', 'Anna');
insert into members(memid, surname, firstname) values(22, 'Coplin', 'Joan');
insert into members(memid, surname, firstname) values(24, 'Sarwin', 'Ramnaresh');
insert into members(memid, surname, firstname) values(26, 'Jones', 'Douglas');
insert into members(memid, surname, firstname) values(27, 'Rumney', 'Henrietta');
insert into members(memid, surname, firstname) values(28, 'Farrell', 'David');
insert into members(memid, surname, firstname) values(29, 'Worthington-Smyth', 'Henry');
insert into members(memid, surname, firstname) values(30, 'Purview', 'Millicent');
insert into members(memid, surname, firstname) values(33, 'Tupperware', 'Hyacinth');
insert into members(memid, surname, firstname) values(35, 'Hunt', 'John');
insert into members(memid, surname, firstname) values(36, 'Crumpet', 'Erica');
insert into members(memid, surname, firstname) values(37, 'Smith', 'Darren');


SELECT starttime
FROM bookings
JOIN members ON bookings.memid = members.memid
WHERE members.firstname = 'David' AND members.surname = 'Farrell';
