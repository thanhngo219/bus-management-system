/*polpulate users*/
INSERT INTO users(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);

/*populate roles*/ 
INSERT INTO authorities (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');

/*populate Operator*/
INSERT INTO `Operator` (`id`,`operatorName`) VALUES (1,'Hoang Long');
INSERT INTO `Operator` (`id`,`operatorName`) VALUES (2,'Phuong Trang');
INSERT INTO `Operator` (`id`,`operatorName`) VALUES (3,'Sinh Cafe');

/*populate Bus*/
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (1,50,'Bus','12345')
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (2,12,'Toyota','54321');
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (3,16,'Van','23451');
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (4,7,'SUV','43215');
INSERT INTO `Bus` (`id`,`capacity`,`model`,`serialNumber`) VALUES (5,4,'Vios','34512');

/*populate Station*/
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (1,'SG','Sai Gon','Vietnam','Mien Dong');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (2,'VT','Vung Tau','Vietnam','Vung Tau');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (3,'PT','Phan Thiet','Vietnam','Binh Thuan');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (4,'NT','Nha Trang','Vietnam','Tran Phu');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (5,'DL','Da Lat','Vietnam','Lam Dong');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (6,'CT','Can Tho','Vietnam','Can Tho');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (7,'BT','Ben Tre','Vietnam','Thong Nhat');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (8,'CM','Ca Mau','Vietnam','Ly Thuong Kiet');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (9,'BL','Bac Lieu','Vietnam','Tran Phu');
INSERT INTO `Station` (`id`,`stationCode`,`city`,`country`,`stationName`) VALUES (10,'VL','Vinh Long','Vietnam','Vinh Long');

/*populate Trip*/
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (1,'2018-12-21','09:00:00','2018-12-21','19:10:00','B001',1,1,1,2);
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (2,'2018-12-21','13:45:00','2018-12-21','15:05:00','B002',1,2,2,3);
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (3,'2018-12-21','06:15:00','2018-12-21','22:30:00','B003',2,3,2,5);
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (4,'2018-11-21','06:55:00','2018-11-21','21:55:00','B004',2,4,3,4);
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (5,'2018-12-21','05:45:00','2018-12-21','14:30:00','B005',3,5,2,7);
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (6,'2018-12-21','07:30:00','2018-12-21','12:59:00','B006',3,6,1,5);
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (7,'2018-12-21','07:40:00','2018-12-21','17:15:00','B007',1,2,1,9);
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (8,'2018-12-21','12:21:00','2018-12-21','22:05:00','B008',1,2,2,3);
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (9,'2018-12-21','23:39:00','2018-12-22','15:00:00','B009',2,3,1,5);
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (10,'2018-12-21','17:15:00','2018-12-22','11:05:00','B010',2,4,1,10)
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (11,'2018-12-21','14:53:00','2018-12-22','12:45:00','B011',3,5,2,6);
INSERT INTO `Trip` (`id`,`departureDate`,`departureTime`,`arrivalDate`,`arrivalTime`,`tripnr`,`bus_id`,`destination_id`,`operator_id`,`origin_id`) VALUES (12,'2018-12-21','10:38:00','2018-12-22','08:10:00','B012',3,6,1,8);