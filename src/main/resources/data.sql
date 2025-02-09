

INSERT INTO users (username, password, role, email, biography)
VALUES ('haker', '$2a$10$hQ2NaTEuDGAIVlYPmmoBQOvzY6C2QOVhXW4tsWQnM9NXQjZB8p7Ue', 'HAKER', 'haker@email.com','bio van een beginnende haker'),
       ('patroonmaker', '$2a$10$269PRnQcWu8I6elFvtaoouGLJCUfMSKEKhIpeh99/igt7.44kLY6S', 'PATROONMAKER', 'patroonmaker@email.com', 'bio van een ervaren patroonmaker'),
    ('haakliefhebber', '$2a$10$9o9BU9tJ/YTGbidExhA62e841/Dp7bBTPpIBL8TAChZQ3iBcBySfu', 'HAKER', 'haakliefhebber@email.com', 'Enthousiaste haakliefhebber die graag nieuwe patronen uitprobeert.'),
    ('creatievehaakster', '$2a$10$SaDqnEdim3btVqzQ4d5jCOfG7dTVsDRF1hwWbS5C.fnrKteAlH4N.', 'PATROONMAKER', 'creatievehaakster@email.com', 'Creatieve haakster met een passie voor kleurrijke ontwerpen.'),
    ('amigurumi_fan', '$2a$10$NwGQXZwfB1tUej7cHaJ/Eu7rSAQ.ZF028GVyiAanQvHYML1XfNa06', 'HAKER', 'amigurumi_fan@email.com', 'Fan van het haken van schattige amigurumi figuren.'),
    ('haakexpert', '$2a$10$TVPViYY5afyKR9bxWrvDCeDaZCCwLRvD0.1kQQP2bbhkyNZ94etqS', 'PATROONMAKER', 'haakexpert@email.com', 'Ervaren haakexpert die graag tips en trucs deelt.');


-- Voeg afbeeldingen toe
INSERT INTO images (content_type, title, url)
VALUES ('image/png', 'Trui Afbeelding', 'https://i.pinimg.com/736x/b0/bf/cc/b0bfcc6b217246bdf1f997049ef824f8.jpg'),
       ('image/jpeg', 'Sjaal Afbeelding', 'https://i.pinimg.com/736x/38/25/ae/3825aedf193bbb6848f16cdc495d183e.jpg'),
       ('image/jpeg', 'Muts Afbeelding', 'https://i.pinimg.com/736x/5f/a0/cd/5fa0cd97eb2ffa10fca8203754867ee2.jpg'),
       ('image/png', 'Tas Afbeelding', 'https://i.pinimg.com/736x/47/74/4d/47744d89aff17323cf1c16ce74efd490.jpg'),
       ('image/png', 'Zomer shorts', 'https://i.pinimg.com/736x/04/e5/3a/04e53a6059176f54c1920b2abdc5cafa.jpg'),
       ('image/jpeg', 'Gekleurde trui', 'https://i.pinimg.com/736x/27/cf/00/27cf009a7f55d6f16f84f904fd3b5044.jpg'),
       ('image/jpeg', 'Muts Afbeelding', 'https://i.pinimg.com/736x/19/9f/9f/199f9f6c42f5a91bb8cc22a49dda56fd.jpg'),
       ('image/png', 'Banaan', 'https://i.pinimg.com/736x/45/10/c9/4510c9a6733f442410eb8163a2456310.jpg'),
       ('image/png', 'Pikachu met pokebal', 'https://i.pinimg.com/736x/30/2b/27/302b27a90cc990d0b2b3140e994fc768.jpg'),
       ('image/jpeg', 'Zwart witten trui', 'https://i.pinimg.com/736x/c5/96/1b/c5961ba3fa301dbed0c1936a11282bd3.jpg'),
       ('image/jpeg', 'Mesh sweater blauw', 'https://i.pinimg.com/736x/d1/e6/37/d1e6377bf1608ff240ede467d8ba4490.jpg'),
       ('image/jpeg', 'Mesh sweater oranje', 'https://i.pinimg.com/736x/4c/f7/7e/4cf77ea540d2dc83b3941c3d6148b0e3.jpg'),
       ('image/png', 'Multicolor sjaal', 'https://i.pinimg.com/736x/0a/e1/e2/0ae1e20589c431b1c39a2eedadb7b1d3.jpg'),
       ('image/jpeg', 'Rode sjaal', 'https://i.pinimg.com/736x/30/2f/a6/302fa6767c8c111449405edf48da43af.jpg'),
       ('image/png', 'Multicolor beanie', 'https://i.pinimg.com/736x/48/ce/7e/48ce7e904f1b3501c711234c20fa0098.jpg'),
       ('image/png', 'Gestreepte beanie', 'https://i.pinimg.com/736x/97/79/b1/9779b192f34fefb15d4809eddbe55e83.jpg'),
       ('image/jpeg', 'Groene tas', 'https://i.pinimg.com/736x/cd/6f/87/cd6f87ba4d4fcee14a65cf709ef19700.jpg'),
       ('image/jpeg', 'Roze handtas', 'https://i.pinimg.com/736x/3b/42/47/3b42476274b7bbf27d14250758da2cc3.jpg'),
       ('image/png', 'shorts', 'https://i.pinimg.com/736x/45/cd/3d/45cd3d000470ee9cd07ea0c342c8f5d7.jpg'),
       ('image/png', 'Rode shorts', 'https://i.pinimg.com/736x/f6/f0/a5/f6f0a581ea7fed8c510a1e5aeb4a09f1.jpg'),
       ('image/jpeg', 'Multicolor sweater', 'https://i.pinimg.com/736x/ed/71/66/ed71666db09e14f76f82e70e9dc3b75a.jpg'),
       ('image/jpeg', 'Kleine konijn', 'https://i.pinimg.com/736x/dd/17/8a/dd178aa1fae7c6ebe28735eebdf332a1.jpg'),
       ('image/png', 'Banaan', 'https://i.pinimg.com/736x/17/52/66/1752668dcf865ae84f23932c97ab7741.jpg'),
       ('image/png', 'Pikachu', 'https://i.pinimg.com/736x/4b/d1/4d/4bd14d161b379ba18b3ca12d2478ffe5.jpg');

-- Voeg posts toe
INSERT INTO posts (is_draft, likes, image_id, user_id, title, description, category)
VALUES (FALSE, 5, 1, 1, 'Mesh Trui', 'Ik wil graag deze zomerse mesh trui maken', 'Truien'),
       (FALSE, 0, 2, 3, 'Gekleurde Sjaal', 'Leuke gekleurde sjaal voor in de winter', 'Sjaals'),
       (FALSE, 10, 3, 3, 'Gestreepte Muts', 'Weet iemand hoe je deze gestreepte muts maakt?', 'Mutsen'),
       (FALSE, 3, 4, 5, 'Handtas', 'Dit is een post over een handtas', 'Tassen'),
       (FALSE, 15, 5, 3, 'Gestreepte shorts', 'Shorts voor de zomer.', 'Broeken'),
       (FALSE, 20, 6, 5, 'Multicolor sweater', 'Heeft iemand een patroon voor deze sweater', 'Truien'),
       (FALSE, 25, 7, 5, 'Konijn knuffel', 'Een zachte knuffeltje voor de kleintjes.', 'Knuffels'),
       (FALSE, 30, 8, 1, 'Gehaakte banaan', 'Ik wil graag deze banaan maken', 'Knuffels'),
       (FALSE, 35, 10, 1, 'Zwart witte trui', 'Iemand een patroon voor deze trui', 'Truien'),
       (FALSE, 35, 9, 1, 'Pokemon', 'Wie weet hoe je Pikachu maakt?', 'Knuffles');



-- Voeg patronen toe
INSERT INTO patterns (amount_of_yarn, darning_needle, hook_size, is_draft, length, likes, measuring_tape, scissor,
                      width, image_id, post_id, user_id, title, description, level, type_yarn)
VALUES (200, TRUE, 4.5, FALSE, 120.5, 7, TRUE, TRUE, 80.0, 11, 1, 2, 'Mesh Trui Patroon blauw', 'Patroon voor een mesh trui', 'Beginner', 'Merino'),
       (200, TRUE, 4.5, FALSE, 120.5, 40, TRUE, TRUE, 80.0, 12, 1, 2, 'Mesh Trui Patroon oranje', 'Patroon voor een mesh trui', 'Beginner', 'Katoen'),
       (150, FALSE, 5.0, TRUE, 100.0, 3, FALSE, FALSE, 70.0, 13, 2, 4, 'Gekleurde Sjaal Patroon','Patroon voor een gekleurde sjaal', 'Medium', 'Wol'),
       (150, FALSE, 5.0, TRUE, 100.0, 3, FALSE, FALSE, 70.0, 14, 2, 4, 'Leuk Sjaal Patroon','Patroon voor een gekleurde sjaal', 'Medium', 'Wol'),
       (250, TRUE, 6.0, FALSE, 150.0, 12, TRUE, TRUE, 90.0, 15, 3, 6, 'Scrap yarn beanie', 'Patroon voor een gestreepte muts', 'Expert', 'Alpaca'),
       (250, TRUE, 6.0, FALSE, 150.0, 17, TRUE, TRUE, 90.0, 16, 3, 6, 'Gestreepte Muts Rood', 'Patroon voor een gestreepte muts', 'Expert', 'Alpaca'),
       (300, FALSE, 7.0, FALSE, 180.0, 8, TRUE, FALSE, 100.0, 17, 4, 2, 'Handtas Groen', 'Patroon voor een handtas','Beginner', 'Katoen'),
       (300, FALSE, 7.0, FALSE, 180.0, 20, TRUE, FALSE, 100.0, 18, 4, 2, 'Handtas roze', 'Patroon voor een handtas','Gevorderd', 'Acryl'),
       (100, TRUE, 3.5, FALSE, 150.0, 5, TRUE, TRUE, 50.0, 19, 5, 6, 'Shorts Patroon', 'Eenvoudig patroon voor een korte broek.', 'Beginner', 'Katoen'),
       (120, TRUE, 4.0, FALSE, 160.0, 8, TRUE, TRUE, 55.0, 20, 5, 2, 'Gestreepte Shorts', 'Geavanceerd patroon.', 'Gevorderd', 'Linnen'),
       (50, TRUE, 2.5, FALSE, 30.0, 10, TRUE, TRUE, 30.0, 21, 6, 4, 'Gekleurde trui', 'Eenvoudig sweater patroon met basissteken.', 'Beginner', 'Katoen'),
       (300, TRUE, 5.0, FALSE, 100.0, 15, TRUE, TRUE, 80.0, 22, 7, 6, 'Klein konijntje', 'Eenvoudig patroon voor een knuffel.', 'Beginner', 'Acryl'),
       (300, TRUE, 5.0, FALSE, 100.0, 15, TRUE, TRUE, 80.0, 23, 8, 6, 'Banaan knuffel', 'Eenvoudig patroon voor een banaan.', 'Beginner', 'Acryl'),
       (200, TRUE, 4.0, FALSE, 40.0, 20, TRUE, TRUE, 35.0, 24, 10, 6, 'Pikachu patroon', 'Gevorderd patroon voor een pokemon knuffel', 'Gevorderd', 'Katoen');


-- Voeg comments toe
INSERT INTO comments (likes, parent_comment_id, pattern_id, post_id, time_stamp, user_id, message)
VALUES (2, NULL, 1, 1, CURRENT_TIMESTAMP, 1, 'Leuk die wil ik ook wel maken!'),
       (3, NULL, 2, 2, CURRENT_TIMESTAMP, 2, 'Prachtig ontwerp voor een sjaal, kan niet wachten om het te maken!'),
       (1, NULL, 3, 3, CURRENT_TIMESTAMP, 4, 'De muts is mooi, maar ik vond het iets moeilijker dan verwacht.'),
       (0, NULL, 4, 4, CURRENT_TIMESTAMP, 2, 'Vette tas!'),
       (0, NULL, 4, 8, CURRENT_TIMESTAMP, 5, 'Banana!'),
       (0, NULL, 4, 10, CURRENT_TIMESTAMP, 3, 'Pika pika!');

-- Voeg afkortingen toe
INSERT INTO abbreviations (pattern_id, abbreviated, full_form)
VALUES (1, 'cm', 'Centimeter'),
       (2, 'm', 'Meter'),
       (3, 'st', 'Steken'),
       (4, 'slst', 'Slip Stitch');

-- Voeg stappen toe
INSERT INTO steps (pattern_id, title, description)
VALUES (1, 'Stap 1', 'Begin met het maken van de eerste rij steken voor de mesh trui.'),
       (2, 'Stap 1', 'Start met het breien van de eerste rij voor de gekleurde sjaal.'),
       (3, 'Stap 1', 'Begin met het breien van de eerste steken voor de gestreepte muts.'),
       (4, 'Stap 1', 'Maak de basis voor de handtas met het linnen draad.');





