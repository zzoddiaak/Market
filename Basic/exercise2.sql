DROP TABLE faсilities;

CREATE TABLE faсilities(
    facid integer PRIMARY KEY,
    name varchar(100),
    membercost numeric
);

insert into faсilities(facid, name, membercost) values(0, 'Tennis Court 1', 5);
insert into faсilities(facid, name, membercost) values(1, 'Tennis Court 2', 5);
insert into faсilities(facid, name, membercost) values(2, 'Badminton Court', 0);
insert into faсilities(facid, name, membercost) values(3, 'Table Tennis', 0);
insert into faсilities(facid, name, membercost ) values(4, 'Massage Room 1', 35);
insert into faсilities(facid, name,  membercost) values(5, 'Massage Room 2', 35);
insert into faсilities(facid, name, membercost) values(6, 'Squash Court', 3.5);
insert into faсilities(facid, name, membercost) values(7, 'Snooker Table', 0);
insert into faсilities(facid, name, membercost) values(8, 'Pool Table', 0);


SELECT name, membercost FROM faсilities;