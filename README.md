Work still in progress...
Progress board: https://trello.com/b/JGF8GZcL
Todo: Clean code, Token provider.

1) Eng:
PWU - Play with us, system for team games registration.
-

Technologies stack:
- Java 11,
- Spring boot (security, jpa)
- Hibernate
- GraphQl
- MySql

Run project by: mvn spring-boot:run

Main idea of pvu-server is to enable connection client-server by GraphQl, and by ServerResponse class that gives all possible responses like wrong input walidation, empty input, invalid entity fields, etc.

Version 0.01 Main functionalities:
-
- Account: Sign in, sign up, change password, change contact details, game history.

- Map: Searching for a game by map, searching for a game by search engine, add new playground to map,

- Games: Add new game, join game, cancel reservation,

2) Pl:
PWU - Play with us, jest to system do rejestrowania gier drużynowych.
-

Technologies stack:
- Java 11,
- Spring boot (security, jpa)
- Hibernate
- GraphQl
- MySql

Sposób uruchomienia:
- komenda mvn spring-boot:run

Wersja 0.01 podstawowe funkcjonalności:
-
- Konto: Rejestracja(bez aktywacji konta), logowanie, zmiana hasła, zmiana danych kontaktowych, historia gier.

- Mapa: Wyszukiwanie gry na mapie, wyszukiwanie gry przez wyszukiwarke, dodanie nowego miejsca gdzie odbywają się  gry,

- Gry: Dodanie gry do danego miejsca, dołączenie do gry, rezygnacja z gry,


