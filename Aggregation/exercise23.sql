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
    starttime timestamp,
    slots integer
);


insert into bookings(bookid, facid, memid, starttime, slots) values(2013, 8, 15, '2012-08-29 08:00:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2014, 8, 0, '2012-08-29 11:30:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2015, 8, 3, '2012-08-29 13:30:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2016, 8, 16, '2012-08-29 14:00:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2017, 8, 3, '2012-08-29 15:00:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2018, 8, 0, '2012-08-29 17:30:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2019, 8, 16, '2012-08-29 18:30:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2020, 8, 1, '2012-08-29 19:30:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2021, 0, 0, '2012-08-30 08:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2022, 0, 17, '2012-08-30 09:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2023, 0, 5, '2012-08-30 12:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2024, 0, 0, '2012-08-30 14:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2025, 0, 5, '2012-08-30 16:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2026, 1, 8, '2012-08-30 08:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2027, 1, 10, '2012-08-30 12:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2028, 1, 11, '2012-08-30 14:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2029, 1, 0, '2012-08-30 16:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2030, 1, 0, '2012-08-30 19:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2031, 2, 1, '2012-08-30 11:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2032, 2, 15, '2012-08-30 12:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2033, 2, 1, '2012-08-30 14:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2034, 2, 7, '2012-08-30 17:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2035, 2, 21, '2012-08-30 19:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2036, 3, 10, '2012-08-30 08:00:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2037, 3, 6, '2012-08-30 09:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2038, 3, 14, '2012-08-30 12:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2039, 3, 20, '2012-08-30 15:00:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2040, 3, 20, '2012-08-30 16:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2041, 3, 16, '2012-08-30 17:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2042, 3, 6, '2012-08-30 19:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2043, 4, 0, '2012-08-30 08:00:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2044, 4, 13, '2012-08-30 09:00:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2045, 4, 0, '2012-08-30 10:00:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2046, 4, 10, '2012-08-30 14:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2047, 4, 11, '2012-08-30 15:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2048, 4, 1, '2012-08-30 16:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2049, 4, 0, '2012-08-30 18:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2050, 6, 12, '2012-08-30 08:00:00', 6);
insert into bookings(bookid, facid, memid, starttime, slots) values(2051, 6, 12, '2012-08-30 11:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2052, 6, 0, '2012-08-30 13:00:00', 4);
insert into bookings(bookid, facid, memid, starttime, slots) values(2053, 6, 0, '2012-08-30 15:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2054, 6, 12, '2012-08-30 16:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2055, 6, 0, '2012-08-30 17:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2056, 7, 0, '2012-08-30 11:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2057, 7, 4, '2012-08-30 14:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2058, 7, 15, '2012-08-30 17:30:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2059, 7, 8, '2012-08-30 19:00:00', 2);
insert into bookings(bookid, facid, memid, starttime, slots) values(2060, 8, 1, '2012-08-30 08:00:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2061, 8, 21, '2012-08-30 10:00:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2062, 8, 3, '2012-08-30 10:30:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2063, 8, 20, '2012-08-30 11:00:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2064, 8, 17, '2012-08-30 12:30:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2065, 8, 3, '2012-08-30 13:00:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2066, 8, 2, '2012-08-30 14:00:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2067, 8, 21, '2012-08-30 15:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2068, 8, 3, '2012-08-30 18:00:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2069, 8, 6, '2012-08-30 19:00:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2070, 8, 16, '2012-08-30 19:30:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2071, 8, 9, '2012-08-30 20:00:00', 1);
insert into bookings(bookid, facid, memid, starttime, slots) values(2072, 0, 5, '2012-08-31 09:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2073, 0, 0, '2012-08-31 10:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2074, 0, 11, '2012-08-31 12:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2075, 0, 6, '2012-08-31 14:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2076, 0, 2, '2012-08-31 16:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2077, 0, 5, '2012-08-31 19:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2078, 1, 0, '2012-08-31 08:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2079, 1, 0, '2012-08-31 10:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2080, 1, 12, '2012-08-31 12:00:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2081, 1, 8, '2012-08-31 13:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2082, 1, 10, '2012-08-31 15:00:00', 6);
insert into bookings(bookid, facid, memid, starttime, slots) values(2083, 1, 8, '2012-08-31 18:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2084, 2, 2, '2012-08-31 08:30:00', 3);
insert into bookings(bookid, facid, memid, starttime, slots) values(2085, 2, 0, '2012-08-31 11:00:00', 3);

insert into faсilities(facid, name, membercost, guestcost) values(0, 'Tennis Court 1', 5, 25);
insert into faсilities(facid, name, membercost, guestcost) values(1, 'Tennis Court 2', 5, 25);
insert into faсilities(facid, name, membercost, guestcost) values(2, 'Badminton Court', 0, 15.5);
insert into faсilities(facid, name, membercost, guestcost) values(3, 'Table Tennis', 0, 5);
insert into faсilities(facid, name, membercost, guestcost) values(4, 'Massage Room 1', 35, 80);
insert into faсilities(facid, name, membercost, guestcost) values(5, 'Massage Room 2', 35, 80);
insert into faсilities(facid, name, membercost, guestcost) values(6, 'Squash Court', 3.5, 17.5);
insert into faсilities(facid, name, membercost, guestcost) values(7, 'Snooker Table', 0, 5);
insert into faсilities(facid, name, membercost, guestcost) values(8, 'Pool Table', 0, 5);

SELECT 	dategen.date,
(
SELECT sum(case
WHEN memid = 0
THEN slots * facs.guestcost
ELSE slots * membercost
END) as rev
FROM bookings bks
INNER JOIN faсilities facs
ON bks.facid = facs.facid
WHERE bks.starttime > dategen.date - interval '14 days'
AND bks.starttime < dategen.date + interval '1 day')/15 as revenue
FROM(
SELECT 	cast(generate_series(timestamp '2012-08-01', '2012-08-31','1 day') as date) as date)  as dategen
ORDER BY dategen.date; 