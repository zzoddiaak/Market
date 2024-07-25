DROP TABLE faсilities;
CREATE TABLE faсilities(
    facid integer PRIMARY KEY,
    name varchar(100),
    membercost numeric,
    guestcost numeric,
    initialoutlay numeric,
    monthlymaintenance numeric
);

insert into faсilities(facid, name, membercost, monthlymaintenance) values(0, 'Tennis Court 1', 5, 200);
insert into faсilities(facid, name, membercost, monthlymaintenance) values(1, 'Tennis Court 2', 5, 200);
insert into faсilities(facid, name, membercost, monthlymaintenance) values(2, 'Badminton Court', 0, 50);
insert into faсilities(facid, name, membercost, monthlymaintenance) values(3, 'Table Tennis', 0, 10);
insert into faсilities(facid, name, membercost, monthlymaintenance) values(4, 'Massage Room 1', 35, 3000);
insert into faсilities(facid, name, membercost, monthlymaintenance) values(5, 'Massage Room 2', 35, 3000);
insert into faсilities(facid, name, membercost, monthlymaintenance) values(6, 'Squash Court', 3.5, 80);
insert into faсilities(facid, name, membercost, monthlymaintenance) values(7, 'Snooker Table', 0, 15);
insert into faсilities(facid, name, membercost, monthlymaintenance) values(8, 'Pool Table', 0, 15);



SELECT facid, name, membercost,monthlymaintenance 
FROM faсilities 
WHERE membercost < (monthlymaintenance)/50 and membercost != 0;