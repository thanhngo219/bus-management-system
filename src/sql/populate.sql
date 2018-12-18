/*polpulate users*/
INSERT INTO users(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);

/*populate roles*/ 
INSERT INTO authorities (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO `Operator` VALUES (1,'SkyTeam'),(2,'oneworld'),(3,'Star Alliance');

INSERT INTO `Bus` VALUES (1,519,'A380','12345'),(2,416,'747','54321'),(3,519,'A380','23451'),(4,416,'747','43215'),(5,519,'A380','34512'),(6,416,'747','32154');

INSERT INTO `Station` VALUES (1,'AMS','Amsterdam','The Netherlands','Schiphol'),(2,'DTW','Detroid','USA','Detroid City'),(3,'NRT','Tokyo','Japan','Narita International Airport'),(4,'SYD','Sydney','Australia','Kingsford Smith'),(5,'LAX','Los Angeles','USA','Los Angeles International'),(6,'FRA','Frankfurt','Germany','Frankfurt International Airport'),(7,'ORD','Chicago','USA','Chicago Ohare International'),(8,'LHR','London','UK','London Heathrow'),(9,'JFK','New York','USA','John F. Kennedy International'),(10,'SIN','Singapore','Singapore','Changi Airport');

INSERT INTO `Trip` VALUES (1,'2018-11-07','09:00:00','2018-11-06','19:10:00','NW 36',1,1,1,2),(2,'2018-11-07','13:45:00','2018-11-06','15:05:00','NW 96',1,2,2,3),(3,'2018-11-07','06:15:00','2018-11-05','22:30:00','QF 12',2,3,4,5),(4,'2018-11-07','06:55:00','2018-11-06','21:55:00','QF 21',2,4,3,4),(5,'2018-11-07','05:45:00','2018-11-06','14:30:00','UA 944',3,5,6,7),(6,'2018-11-07','07:30:00','2018-11-06','12:59:00','UA 934',3,6,8,5),(7,'2018-11-07','07:40:00','2018-11-07','07:15:00','NW 8445',1,1,8,1),(8,'2018-11-07','12:21:00','2018-11-07','12:05:00','NW 1689',1,2,7,2),(9,'2018-11-07','23:39:00','2018-11-07','15:00:00','QF 3101',2,3,9,5),(10,'2018-11-07','17:15:00','2018-11-07','11:05:00','QF 4022',2,4,10,3),(11,'2018-11-07','14:53:00','2018-11-07','12:45:00','UA 941',3,5,7,6),(12,'2018-11-07','10:38:00','2018-11-07','08:10:00','UA 4842',3,6,1,8);