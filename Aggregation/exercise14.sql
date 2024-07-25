DROP TABLE bookings;
DROP TABLE faсilities;

CREATE TABLE bookings(
    bookid integer PRIMARY KEY,
    facid integer,
    slots integer
);
CREATE TABLE faсilities(
    facid integer PRIMARY KEY,
    name varchar(100)
);

insert into faсilities(facid, name) values(0, 'Tennis Court 1' );
insert into faсilities(facid, name) values(1, 'Tennis Court 2' );
insert into faсilities(facid, name) values(2, 'Badminton Court');
insert into faсilities(facid, name) values(3, 'Table Tennis'   );
insert into faсilities(facid, name ) values(4, 'Massage Room 1');
insert into faсilities(facid, name) values(5, 'Massage Room 2' );
insert into faсilities(facid, name) values(6, 'Squash Court'   );
insert into faсilities(facid, name) values(7, 'Snooker Table'  );
insert into faсilities(facid, name) values(8, 'Pool Table'		);

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


select facs.facid, facs.name, trim(to_char(sum(bks.slots)/2.0, '9999999999999999D99')) as "Total Hours"
from bookings bks
inner join faсilities facs
on facs.facid = bks.facid
group by facs.facid, facs.name
order by facs.facid;     