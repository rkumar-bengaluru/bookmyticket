INSERT INTO partners (name) VALUES ('INOX');
INSERT INTO partners (name) VALUES ('Rupak Kumar');

INSERT INTO theatre (name,city,address,partner_id) VALUES ('INOX R-City Ghatkopar','Bangalore','BEL ROAD',1);
INSERT INTO theatre (name,city,address,partner_id) VALUES ('INOX Megaplex, Inorbit Mall','Bangalore', 'DeviNagr',1);
INSERT INTO theatre (name,city,address,partner_id) VALUES ('Vaibhav Theatre','Delhi','MG ROAD',2);

INSERT INTO screen (name,theatre_id) VALUES ('VINTAGE',1);
INSERT INTO screen (name,theatre_id) VALUES ('SOPHIA',1);

INSERT INTO movie (name,language,status,screen_id) VALUES ('Venom: Let There Be Carnage','ENGLISH','RUNNING',1);
INSERT INTO movie (name,language,status,screen_id) VALUES ('Kotigobba 3','TAMIL','RUNNING',1);
INSERT INTO movie (name,language,status,screen_id) VALUES ('Dune','ENGLISH','STOPPED',2);
INSERT INTO movie (name,language,status,screen_id) VALUES ('No Time To Die','ENGLISH','RUNNING',2);

INSERT INTO slot (start,end,movie_id) VALUES ('10:00 AM','12:30 PM',1);
INSERT INTO slot (start,end,movie_id) VALUES ('12:30 AM','2:30 PM',1);
INSERT INTO slot (start,end,movie_id) VALUES ('10 AM','12:30 PM',2);
INSERT INTO slot (start,end,movie_id) VALUES ('10 AM','12:30 PM',3);
INSERT INTO slot (start,end,movie_id) VALUES ('10 AM','12:30 PM',4);

INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1A','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1B','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1C','EMPTY',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1D','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1E','EMPTY',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1F','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1G','EMPTY',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1H','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1I','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1A','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1B','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1C','EMPTY',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1D','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1E','EMPTY',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1F','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1G','EMPTY',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1H','RESERVED',1);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1I','RESERVED',1);

INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1A','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1B','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1C','EMPTY',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1D','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1E','EMPTY',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1F','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1G','EMPTY',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1H','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (1,'1I','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1A','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1B','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1C','EMPTY',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1D','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1E','EMPTY',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1F','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1G','EMPTY',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1H','RESERVED',2);
INSERT INTO seats (rowno,no,state,screen_id) VALUES (2,'1I','RESERVED',2);

