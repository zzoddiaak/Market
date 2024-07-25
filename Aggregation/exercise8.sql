DROP TABLE bookings;


CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    memid integer
    
);
insert into bookings(bookid,  memid) values(2936,	14);
insert into bookings(bookid,  memid) values(2937,	0);
insert into bookings(bookid,  memid) values(2945,	15);
insert into bookings(bookid,  memid) values(2948,	0);
insert into bookings(bookid,  memid) values(2938,	13);
insert into bookings(bookid,  memid) values(2946,	0);
insert into bookings(bookid,  memid) values(2939,	9);
insert into bookings(bookid,  memid) values(2949,	0);
insert into bookings(bookid,  memid) values(2940,	0);
insert into bookings(bookid,  memid) values(2925,	0);
insert into bookings(bookid,  memid) values(2941,	13);
insert into bookings(bookid,  memid) values(2951,	0);
insert into bookings(bookid,  memid) values(2920,	0);
insert into bookings(bookid,  memid) values(2942,	0);
insert into bookings(bookid,  memid) values(2926,	0);
insert into bookings(bookid,  memid) values(2943,	6);
insert into bookings(bookid,  memid) values(2922,	0);
insert into bookings(bookid,  memid) values(2944,	20);

SELECT count(distinct memid) from bookings;
