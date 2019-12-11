use server_db;

INSERT INTO Users (UserId, Name, Surname, Email, Password, Phone, Role)
VALUES
  (1, "Sebastian", "Druciak", "faczor@gmail.com", "frytka123!", "513842168", "ADMIN"),
  (2, "Maciej", "Kozak", "mkozak@gimi.cop", "frytka123!", NULL, "USER");
  
  
  
INSERT INTO Playgrounds (PlaygroundId, Name, InDoor)
VALUES
  (1, "Szkola podstawowa nr 1 Wroclaw", false),
  (2, "LO nr 21 Warszawa", true),
  (3, "Hala sportowa ul Chorzowska 3/5 Katowice", true);
  
  
  
INSERT INTO Addresses (AddressId, PlaygroundId, Country, City, ZipCode, Street, Latitude, Longitude)
VALUES
  (1, 1, "Poland", "Wroclaw", 51350, "Dominikanska 1", 51.1089776, 17.0326689),
  (2, 2, "Poland", "Warsaw", 10345, "Wroclawska 15/3", 52.2319237, 21.0067265),
  (3, 3, "Poland", "Katowice", 35412, "Chorzowska 3/5", 50.2598987, 19.0215852);
  
  
  

INSERT INTO Games (GameId, PlaygroundId, UserId, Name, Price, Slots, Start, Length)
VALUES
  (1, 1, 2, "Gierka 4fun", 15, 10, '2019-09-23 15:34:21', 90),
  (2, 2, 2, "Kozaczki", 12, 15, '2019-09-23 15:34:21', 60);