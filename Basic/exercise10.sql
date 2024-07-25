DROP TABLE faсilities;
DROP TABLE members;
CREATE TABLE members
(
    memid integer PRIMARY KEY, 
    surname character varying(200)
    
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

insert into members(memid, surname) values(0, 'GUEST'    );
insert into members(memid, surname) values(1, 'Smith'    );
insert into members(memid, surname) values(2, 'Smith'    );
insert into members(memid, surname) values(3, 'Rownam'   );
insert into members(memid, surname) values(4, 'Joplette' );
insert into members(memid, surname) values(5, 'Butters'  );
insert into members(memid, surname) values(6, 'Tracy'    );
insert into members(memid, surname) values(7, 'Dare'    );
insert into members(memid, surname) values(8, 'Boothe'   );
insert into members(memid, surname) values(9, 'Stibbons' );
insert into members(memid, surname) values(10, 'Owen'    );
insert into members(memid, surname) values(11, 'Jones'   );
insert into members(memid, surname) values(12, 'Baker'    );
insert into members(memid, surname) values(13, 'Farrell'  );
insert into members(memid, surname) values(14, 'Smith'    );
insert into members(memid, surname) values(15, 'Bader'    );
insert into members(memid, surname) values(16, 'Baker'	   );
insert into members(memid, surname) values(17, 'Pinker' 	 );
insert into members(memid, surname) values(20, 'Genting'    );
insert into members(memid, surname) values(21, 'Mackenzie' );
insert into members(memid, surname) values(22, 'Coplin' 	 );
insert into members(memid, surname) values(24, 'Sarwin' 	 );
insert into members(memid, surname) values(26, 'Jones'	   );
insert into members(memid, surname) values(27, 'Rumney' 	 );
insert into members(memid, surname) values(28, 'Farrell'	 );
insert into members(memid, surname) values(29, 'Worthington-Smyth'  );
insert into members(memid, surname) values(30, 'Purview'  );
insert into members(memid, surname) values(33, 'Tupperware'  );
insert into members(memid, surname) values(35, 'Hunt'     );
insert into members(memid, surname) values(36, 'Crumpet' );
insert into members(memid, surname) values(37, 'Smith'  );

SELECT surname  FROM members UNION SELECT name FROM faсilities;