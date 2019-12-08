USE server_db;

INSERT INTO `Users`
  (`Name`, `Surname`, `Email`, `Password`, `Phone`, `Role`)
VALUES
  ("Sebastian", "Druciak", "faczor@gmail.com", "frytka123!", "513842168", "ADMIN"),
  ("Maciej", "Kozak", "mkozak@gimi.cop", "frytka123!", NULL, "USER");
  
  
  
INSERT INTO `Playgrounds`
  (`Name`, `InDoor`)
VALUES
  ("Szkola podstawowa nr 1 Wroclaw", false),
  ("LO nr 21 Warszawa", true),
  ("Hala sportowa ul Chorzowska 3/5 Katowice", true);
  
  
  
INSERT INTO `Addresses`
  (`PlaygroundId`, `Country`, `City`, `ZipCode`, `Street`, `Latitude`, `Longitude`)
VALUES
  (1, "Poland", "Wroclaw", 51350, "Dominikanska 1", 51.1089776, 17.0326689),
  (2, "Poland", "Warsaw", 10345, "Wroclawska 15/3", 52.2319237, 21.0067265),
  (3, "Poland", "Katowice", 35412, "Chorzowska 3/5", 50.2598987, 19.0215852);
  
  
  

INSERT INTO `Games`
  (`PlaygroundId`, `UserId`, `Name`, `Price`, `Slots`, `Start`, `Length`)
VALUES
  (1, 2, "Gierka 4fun", 15, 10, NOW(), 90),
  (2, 2, "Kozaczki", 12, 15, NOW(), 60);