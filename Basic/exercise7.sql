DROP TABLE faсilities;
CREATE TABLE faсilities(
    facid integer PRIMARY KEY,
    name varchar(100),
    membercost numeric,
    guestcost numeric,
    initialoutlay numeric,
    monthlymaintenance numeric
);

insert into faсilities(facid, name, monthlymaintenance) values(0, 'Tennis Court 1',200);
insert into faсilities(facid, name, monthlymaintenance) values(1, 'Tennis Court 2',200);
insert into faсilities(facid, name, monthlymaintenance) values(2, 'Badminton Court', 50);
insert into faсilities(facid, name, monthlymaintenance) values(3, 'Table Tennis',    10);
insert into faсilities(facid, name, monthlymaintenance) values(4, 'Massage Room 1',  3000);
insert into faсilities(facid, name, monthlymaintenance) values(5, 'Massage Room 2',  3000);
insert into faсilities(facid, name, monthlymaintenance) values(6, 'Squash Court',  80);
insert into faсilities(facid, name, monthlymaintenance) values(7, 'Snooker Table',     15);
insert into faсilities(facid, name, monthlymaintenance) values(8, 'Pool Table',       15);





SELECT name, 
CASE WHEN monthlymaintenance > 100 
THEN 'expensive' 
ELSE 'cheap' 
END AS cost FROM faсilities;