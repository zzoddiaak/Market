DROP TABLE members;

CREATE TABLE members(
    memid integer PRIMARY KEY,
    surname varchar(200),
    firstname varchar(200),
    recommendedby integer REFERENCES members(memid) 
);

insert into members(memid, surname, firstname, recommendedby) values(0, 'GUEST', 'GUEST', NULL);
insert into members(memid, surname, firstname, recommendedby) values(1, 'Smith', 'Darren',NULL);
insert into members(memid, surname, firstname, recommendedby) values(2, 'Smith', 'Tracy',  NULL);
insert into members(memid, surname, firstname, recommendedby) values(3, 'Rownam', 'Tim', NULL);
insert into members(memid, surname, firstname, recommendedby) values(4, 'Joplette', 'Janice',1);
insert into members(memid, surname, firstname, recommendedby) values(5, 'Butters', 'Gerald',  1);
insert into members(memid, surname, firstname, recommendedby) values(6, 'Tracy', 'Burton', NULL);
insert into members(memid, surname, firstname, recommendedby) values(7, 'Dare', 'Nancy', 4	);
insert into members(memid, surname, firstname, recommendedby) values(8, 'Boothe', 'Tim', 3 );
insert into members(memid, surname, firstname, recommendedby) values(9, 'Stibbons', 'Ponder', 6	);
insert into members(memid, surname, firstname, recommendedby) values(10, 'Owen', 'Charles',1);
insert into members(memid, surname, firstname, recommendedby) values(11, 'Jones', 'David', 4);
insert into members(memid, surname, firstname, recommendedby) values(12, 'Baker', 'Anne', 9	);
insert into members(memid, surname, firstname, recommendedby) values(13, 'Farrell', 'Jemima', NULL);
insert into members(memid, surname, firstname, recommendedby) values(14, 'Smith', 'Jack', 1	);
insert into members(memid, surname, firstname, recommendedby) values(15, 'Bader', 'Florence', 9);
insert into members(memid, surname, firstname, recommendedby) values(16, 'Baker', 'Timothy', 13);
insert into members(memid, surname, firstname, recommendedby) values(17, 'Pinker', 'David', 13);
insert into members(memid, surname, firstname, recommendedby) values(20, 'Genting', 'Matthew', 5);
insert into members(memid, surname, firstname, recommendedby) values(21, 'Mackenzie', 'Anna', 1);
insert into members(memid, surname, firstname, recommendedby) values(22, 'Coplin', 'Joan', 16);
insert into members(memid, surname, firstname, recommendedby) values(24, 'Sarwin', 'Ramnaresh', 15);
insert into members(memid, surname, firstname, recommendedby) values(26, 'Jones', 'Douglas', 11);
insert into members(memid, surname, firstname, recommendedby) values(27, 'Rumney', 'Henrietta', 20);
insert into members(memid, surname, firstname, recommendedby) values(28, 'Farrell', 'David', NULL);
insert into members(memid, surname, firstname, recommendedby) values(29, 'Worthington-Smyth', 'Henry', 2);
insert into members(memid, surname, firstname, recommendedby) values(30, 'Purview', 'Millicent', 2);
insert into members(memid, surname, firstname, recommendedby) values(33, 'Tupperware', 'Hyacinth', NULL);
insert into members(memid, surname, firstname, recommendedby) values(35, 'Hunt', 'John', 30);
insert into members(memid, surname, firstname, recommendedby) values(36, 'Crumpet', 'Erica', 2);
insert into members(memid, surname, firstname, recommendedby) values(37, 'Smith', 'Darren', NULL);

WITH RECURSIVE recommenders AS (
    SELECT recommendedby AS recommender 
    FROM cd.members 
    WHERE memid = 27
    UNION ALL
    SELECT m.recommendedby
    FROM cd.members m
    INNER JOIN recommenders r ON m.memid = r.recommender
)
SELECT r.recommender, m.firstname, m.surname
FROM recommenders r
INNER JOIN cd.members m ON r.recommender = m.memid
ORDER BY m.memid DESC;
       
