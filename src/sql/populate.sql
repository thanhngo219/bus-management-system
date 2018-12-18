/*polpulate users*/
INSERT INTO users(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);

/*populate roles*/ 
INSERT INTO authorities (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');

/*populate Operator*/
INSERT INTO `Operator` (`id`,`operatorName`) VALUES (1,'SkyTeam');
INSERT INTO `Operator` (`id`,`operatorName`) VALUES (2,'oneworld');
INSERT INTO `Operator` (`id`,`operatorName`) VALUES (3,'Star Alliance');

/*populate Bus*/
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (1,519,'A380','12345')
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (2,416,'747','54321');
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (3,519,'A380','23451');
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (4,416,'747','43215');
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (5,519,'A380','34512');
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (6,416,'747','32154');

/*populate Station*/
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (1,'AMS','Amsterdam','The Netherlands','Schiphol');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (2,'DTW','Detroid','USA','Detroid City');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (3,'NRT','Tokyo','Japan','Narita International Station');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (4,'SYD','Sydney','Australia','Kingsford Smith');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (5,'LAX','Los Angeles','USA','Los Angeles International');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (6,'FRA','Frankfurt','Germany','Frankfurt International Station');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (7,'ORD','Chicago','USA','Chicago Ohare International');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (8,'LHR','London','UK','London Heathrow');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (9,'JFK','New York','USA','John F. Kennedy International');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (10,'SIN','Singapore','Singapore','Changi Station');

/*populate Trip*/
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (1,'2018-11-07','09:00:00','2018-11-06','19:10:00','NW 36',1,1,1,2);
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (2,'2018-11-07','13:45:00','2018-11-06','15:05:00','NW 96',1,2,2,3);
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (3,'2018-11-07','06:15:00','2018-11-05','22:30:00','QF 12',2,3,4,5);
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (4,'2018-11-07','06:55:00','2018-11-06','21:55:00','QF 21',2,4,3,4);
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (5,'2018-11-07','05:45:00','2018-11-06','14:30:00','UA 944',3,5,6,7);
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (6,'2018-11-07','07:30:00','2018-11-06','12:59:00','UA 934',3,6,8,5);
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (7,'2018-11-07','07:40:00','2018-11-07','07:15:00','NW 8445',1,1,8,1);
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (8,'2018-11-07','12:21:00','2018-11-07','12:05:00','NW 1689',1,2,7,2);
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (9,'2018-11-07','23:39:00','2018-11-07','15:00:00','QF 3101',2,3,9,5);
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (10,'2018-11-07','17:15:00','2018-11-07','11:05:00','QF 4022',2,4,10,3)
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (11,'2018-11-07','14:53:00','2018-11-07','12:45:00','UA 941',3,5,7,6);
INSERT INTO `Trip` (`id`,`arrivalDate`,`arrivalTime`,`departureDate`,`departureTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (12,'2018-11-07','10:38:00','2018-11-07','08:10:00','UA 4842',3,6,1,8);