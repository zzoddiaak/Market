DROP TABLE faсilities;
CREATE TABLE faсilities(
    facid integer PRIMARY KEY,
    name varchar(100),
    membercost numeric,
    guestcost numeric,
    initialoutlay numeric,
    monthlymaintenance numeric
);

insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(0, 'Tennis Court 1', 5, 25, 10000, 200);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(1, 'Tennis Court 2', 5, 25, 8000, 200);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(2, 'Badminton Court', 0, 15.5, 4000, 50);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(3, 'Table Tennis', 0, 5, 320, 10);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(4, 'Massage Room 1', 35, 80, 4000, 3000);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(5, 'Massage Room 2', 35, 80, 4000, 3000);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(6, 'Squash Court', 3.5, 17.5, 5000, 80);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(7, 'Snooker Table', 0, 5, 450, 15);
insert into faсilities(facid, name, membercost, guestcost, initialoutlay, monthlymaintenance) values(8, 'Pool Table', 0, 5, 400, 15);


SELECT * FROM faсilities;
