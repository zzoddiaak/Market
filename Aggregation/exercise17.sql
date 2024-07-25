
DROP TABLE members;

CREATE TABLE members(
    memid integer PRIMARY KEY,
    surname varchar(200),
    firstname varchar(200),
    address varchar(200),
    zipcode integer,
    telephone varchar(20),
    recommendedby integer REFERENCES members(memid),
    joindate timestamp
);

insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(0, 'GUEST', 'GUEST', 'GUEST', 0, '(000) 000-0000', NULL , '2012-07-01 00:00:00');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(1, 'Smith', 'Darren', '8 Bloomsbury Close, Boston', 4321, '555-555-5555', NULL, '2012-07-02 12:02:05');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(2, 'Smith', 'Tracy', '8 Bloomsbury Close, New York', 4321, '555-555-5555', NULL, '2012-07-02 12:08:23');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(3, 'Rownam', 'Tim', '23 Highway Way, Boston', 23423, '(844) 693-0723', NULL, '2012-07-03 09:32:15');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(4, 'Joplette', 'Janice', '20 Crossing Road, New York', 234, '(833) 942-4710', 1, '2012-07-03 10:25:05');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(5, 'Butters', 'Gerald', '1065 Huntingdon Avenue, Boston', 56754, '(844) 078-4130', 1, '2012-07-09 10:44:09');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(6, 'Tracy', 'Burton', '3 Tunisia Drive, Boston', 45678, '(822) 354-9973', NULL, '2012-07-15 08:52:55');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(7, 'Dare', 'Nancy', '6 Hunting Lodge Way, Boston', 10383, '(833) 776-4001', 4, '2012-07-25 08:59:12');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(8, 'Boothe', 'Tim', '3 Bloomsbury Close, Reading, 00234', 234, '(811) 433-2547', 3, '2012-07-25 16:02:35');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(9, 'Stibbons', 'Ponder', '5 Dragons Way, Winchester', 87630, '(833) 160-3900', 6, '2012-07-25 17:09:05');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(10, 'Owen', 'Charles', '52 Cheshire Grove, Winchester, 28563', 28563, '(855) 542-5251', 1, '2012-08-03 19:42:37');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(11, 'Jones', 'David', '976 Gnats Close, Reading', 33862, '(844) 536-8036', 4, '2012-08-06 16:32:55');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(12, 'Baker', 'Anne', '55 Powdery Street, Boston', 80743, '844-076-5141', 9, '2012-08-10 14:23:22');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(13, 'Farrell', 'Jemima', '103 Firth Avenue, North Reading', 57392, '(855) 016-0163', NULL, '2012-08-10 14:28:01');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(14, 'Smith', 'Jack', '252 Binkington Way, Boston', 69302, '(822) 163-3254', 1, '2012-08-10 16:22:05');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(15, 'Bader', 'Florence', '264 Ursula Drive, Westford', 84923, '(833) 499-3527', 9, '2012-08-10 17:52:03');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(16, 'Baker', 'Timothy', '329 James Street, Reading', 58393, '833-941-0824', 13, '2012-08-15 10:34:25');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(17, 'Pinker', 'David', '5 Impreza Road, Boston', 65332, '811 409-6734', 13, '2012-08-16 11:32:47');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(20, 'Genting', 'Matthew', '4 Nunnington Place, Wingfield, Boston', 52365, '(811) 972-1377', 5, '2012-08-19 14:55:55');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(21, 'Mackenzie', 'Anna', '64 Perkington Lane, Reading', 64577, '(822) 661-2898', 1, '2012-08-26 09:32:05');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(22, 'Coplin', 'Joan', '85 Bard Street, Bloomington, Boston', 43533, '(822) 499-2232', 16, '2012-08-29 08:32:41');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(24, 'Sarwin', 'Ramnaresh', '12 Bullington Lane, Boston', 65464, '(822) 413-1470', 15, '2012-09-01 08:44:42');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(26, 'Jones', 'Douglas', '976 Gnats Close, Reading', 11986, '844 536-8036', 11, '2012-09-02 18:43:05');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(27, 'Rumney', 'Henrietta', '3 Burkington Plaza, Boston', 78533, '(822) 989-8876', 20, '2012-09-05 08:42:35');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(28, 'Farrell', 'David', '437 Granite Farm Road, Westford', 43532, '(855) 755-9876', NULL, '2012-09-15 08:22:05');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(29, 'Worthington-Smyth', 'Henry', '55 Jagbi Way, North Reading', 97676, '(855) 894-3758', 2, '2012-09-17 12:27:15');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(30, 'Purview', 'Millicent', '641 Drudgery Close, Burnington, Boston', 34232, '(855) 941-9786', 2, '2012-09-18 19:04:01');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(33, 'Tupperware', 'Hyacinth', '33 Cheerful Plaza, Drake Road, Westford', 68666, '(822) 665-5327', NULL , '2012-09-18 19:32:05');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(35, 'Hunt', 'John', '5 Bullington Lane, Boston', 54333, '(899) 720-6978', 30, '2012-09-19 11:32:45');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(36, 'Crumpet', 'Erica', 'Crimson Road, North Reading', 75655, '(811) 732-4816', 2, '2012-09-22 08:36:38');
insert into members(memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate) values(37, 'Smith', 'Darren', '3 Funktown, Denzington, Boston', 66796, '(822) 577-3541', NULL, '2012-09-26 18:08:45');


SELECT row_number() over(ORDER BY joindate), firstname, surname
FROM members
ORDER BY joindate;