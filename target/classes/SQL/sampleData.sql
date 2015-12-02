-- to test, execute these insertions

INSERT INTO testing.room(roomId,price,roomNumber,properties,type) VALUES(1,100,"101","NSMK","K");
INSERT INTO testing.room(roomId,price,roomNumber,properties,type) VALUES(2,120,"102","SMK","K");
INSERT INTO testing.room(roomId,price,roomNumber,properties,type) VALUES(3,100,"103","NSMK","Q");


INSERT INTO testing.Occupancy(OCCUPANCYID,checkinDate,checkOutDate,roomNumber) VALUES(4,"2015-11-24","2015-11-25",1);
INSERT INTO testing.Occupancy(OCCUPANCYID,checkinDate,checkOutDate,roomNumber) VALUES(5,"2015-11-26","2015-11-27",2);
INSERT INTO testing.Occupancy(OCCUPANCYID,checkinDate,checkOutDate,roomNumber) VALUES(6,"2015-11-26","2015-11-27",1);
