DROP TABLE members;
CREATE TABLE members
(
    memid integer PRIMARY KEY, 
    joindate timestamp
);

insert into members(memid, joindate) values(0, '2012-07-01 00:00:00');
insert into members(memid, joindate) values(1, '2012-07-02 12:02:05');
insert into members(memid, joindate) values(2, '2012-07-02 12:08:23');
insert into members(memid, joindate) values(3, '2012-07-03 09:32:15');
insert into members(memid, joindate) values(4, '2012-07-03 10:25:05');
insert into members(memid, joindate) values(5, '2012-07-09 10:44:09');
insert into members(memid, joindate) values(6, '2012-07-15 08:52:55');
insert into members(memid, joindate) values(7, '2012-07-25 08:59:12');
insert into members(memid, joindate) values(8, '2012-07-25 16:02:35');
insert into members(memid, joindate) values(9, '2012-07-25 17:09:05');
insert into members(memid, joindate) values(10,'2012-08-03 19:42:37');
insert into members(memid, joindate) values(11,'2012-08-06 16:32:55');
insert into members(memid, joindate) values(12,'2012-08-10 14:23:22');
insert into members(memid, joindate) values(13,'2012-08-10 14:28:01');
insert into members(memid, joindate) values(14,'2012-08-10 16:22:05');
insert into members(memid, joindate) values(15,'2012-08-10 17:52:03');
insert into members(memid, joindate) values(16,'2012-08-15 10:34:25');
insert into members(memid, joindate) values(17,'2012-08-16 11:32:47');
insert into members(memid, joindate) values(20,'2012-08-19 14:55:55');
insert into members(memid, joindate) values(21,'2012-08-26 09:32:05');
insert into members(memid, joindate) values(22,'2012-08-29 08:32:41');
insert into members(memid, joindate) values(24,'2012-09-01 08:44:42');
insert into members(memid, joindate) values(26,'2012-09-02 18:43:05');
insert into members(memid, joindate) values(27,'2012-09-05 08:42:35');
insert into members(memid, joindate) values(28,'2012-09-15 08:22:05');
insert into members(memid, joindate) values(29,  '2012-09-17 12:27:15');
insert into members(memid, joindate) values(30,  '2012-09-18 19:04:01');
insert into members(memid, joindate) values(33,   '2012-09-18 19:32:05');
insert into members(memid, joindate) values(35,  '2012-09-19 11:32:45');
insert into members(memid, joindate) values(36, '2012-09-22 08:36:38');
insert into members(memid, joindate) values(37,  '2012-09-26 18:08:45');



SELECT joindate FROM members ORDER BY joindate DESC LIMIT 1;
