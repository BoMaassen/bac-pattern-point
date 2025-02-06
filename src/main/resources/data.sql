/*wachtwoord voor haker: haker1iscool*/
/*wachtwoord voor patroonmaker: patroonmaker1*/
/*wachtwoord voor hakerliefhebber: hakerliefhebber1*/
/*wachtwoord voor creatievehaakster: creatievehaakster1*/
/*wachtwoord voor amigurumi_fan: amigurumi_fan1*/
/*wachtwoord voor haakexpert: haakexpert1*/


INSERT INTO users (username, password, role, email, biography)
VALUES ('haker', '$2a$10$hQ2NaTEuDGAIVlYPmmoBQOvzY6C2QOVhXW4tsWQnM9NXQjZB8p7Ue', 'HAKER', 'haker@email.com','bio van een haker'),
       ('patroonmaker', '$2a$10$269PRnQcWu8I6elFvtaoouGLJCUfMSKEKhIpeh99/igt7.44kLY6S', 'PATROONMAKER', 'patroonmaker@email.com', 'bio van een patroonmaker'),
    ('haakliefhebber', '$2a$10$9o9BU9tJ/YTGbidExhA62e841/Dp7bBTPpIBL8TAChZQ3iBcBySfu', 'HAKER', 'haakliefhebber@email.com', 'Enthousiaste haakliefhebber die graag nieuwe patronen uitprobeert.'),
    ('creatievehaakster', '$2a$10$SaDqnEdim3btVqzQ4d5jCOfG7dTVsDRF1hwWbS5C.fnrKteAlH4N.', 'PATROONMAKER', 'creatievehaakster@email.com', 'Creatieve haakster met een passie voor kleurrijke ontwerpen.'),
    ('amigurumi_fan', '$2a$10$NwGQXZwfB1tUej7cHaJ/Eu7rSAQ.ZF028GVyiAanQvHYML1XfNa06', 'HAKER', 'amigurumi_fan@email.com', 'Fan van het haken van schattige amigurumi figuren.'),
    ('haakexpert', '$2a$10$TVPViYY5afyKR9bxWrvDCeDaZCCwLRvD0.1kQQP2bbhkyNZ94etqS', 'PATROONMAKER', 'haakexpert@email.com', 'Ervaren haakexpert die graag tips en trucs deelt.');


-- Voeg afbeeldingen toe
INSERT INTO images (content_type, title, url)
VALUES ('image/png', 'Trui Afbeelding', 'https://i.pinimg.com/736x/27/cf/00/27cf009a7f55d6f16f84f904fd3b5044.jpg'),
       ('image/jpeg', 'Sjaal Afbeelding', 'https://i.pinimg.com/736x/38/25/ae/3825aedf193bbb6848f16cdc495d183e.jpg'),
       ('image/jpeg', 'Muts Afbeelding', 'https://i.pinimg.com/736x/5f/a0/cd/5fa0cd97eb2ffa10fca8203754867ee2.jpg'),
       ('image/png', 'Tas Afbeelding', 'https://i.pinimg.com/736x/47/74/4d/47744d89aff17323cf1c16ce74efd490.jpg'),
       ('image/png', 'Trui Afbeelding', 'https://i.pinimg.com/736x/27/cf/00/27cf009a7f55d6f16f84f904fd3b5044.jpg'),
       ('image/jpeg', 'Sjaal Afbeelding', 'https://i.pinimg.com/736x/38/25/ae/3825aedf193bbb6848f16cdc495d183e.jpg'),
       ('image/jpeg', 'Muts Afbeelding', 'https://i.pinimg.com/736x/5f/a0/cd/5fa0cd97eb2ffa10fca8203754867ee2.jpg'),
       ('image/png', 'Tas Afbeelding', 'https://i.pinimg.com/736x/47/74/4d/47744d89aff17323cf1c16ce74efd490.jpg'),
       ('image/png', 'Trui Afbeelding', 'https://i.pinimg.com/736x/27/cf/00/27cf009a7f55d6f16f84f904fd3b5044.jpg'),
       ('image/jpeg', 'Sjaal Afbeelding', 'https://i.pinimg.com/736x/38/25/ae/3825aedf193bbb6848f16cdc495d183e.jpg'),
       ('image/jpeg', 'Muts Afbeelding', 'https://i.pinimg.com/736x/5f/a0/cd/5fa0cd97eb2ffa10fca8203754867ee2.jpg'),
       ('image/png', 'Tas Afbeelding', 'https://i.pinimg.com/736x/47/74/4d/47744d89aff17323cf1c16ce74efd490.jpg'),
       ('image/jpeg', 'Muts Afbeelding', 'https://i.pinimg.com/736x/5f/a0/cd/5fa0cd97eb2ffa10fca8203754867ee2.jpg'),
       ('image/png', 'Tas Afbeelding', 'https://i.pinimg.com/736x/47/74/4d/47744d89aff17323cf1c16ce74efd490.jpg'),
       ('image/png', 'Trui Afbeelding', 'https://i.pinimg.com/736x/27/cf/00/27cf009a7f55d6f16f84f904fd3b5044.jpg'),
       ('image/jpeg', 'Sjaal Afbeelding', 'https://i.pinimg.com/736x/38/25/ae/3825aedf193bbb6848f16cdc495d183e.jpg'),
       ('image/jpeg', 'Muts Afbeelding', 'https://i.pinimg.com/736x/5f/a0/cd/5fa0cd97eb2ffa10fca8203754867ee2.jpg'),
       ('image/png', 'Tas Afbeelding', 'https://i.pinimg.com/736x/47/74/4d/47744d89aff17323cf1c16ce74efd490.jpg'),
       ('image/png', 'Trui Afbeelding', 'https://i.pinimg.com/736x/27/cf/00/27cf009a7f55d6f16f84f904fd3b5044.jpg'),
       ('image/jpeg', 'Sjaal Afbeelding', 'https://i.pinimg.com/736x/38/25/ae/3825aedf193bbb6848f16cdc495d183e.jpg'),
       ('image/jpeg', 'Muts Afbeelding', 'https://i.pinimg.com/736x/5f/a0/cd/5fa0cd97eb2ffa10fca8203754867ee2.jpg'),
       ('image/png', 'Tas Afbeelding', 'https://i.pinimg.com/736x/47/74/4d/47744d89aff17323cf1c16ce74efd490.jpg');

-- Voeg posts toe
INSERT INTO posts (is_draft, likes, image_id, user_id, title, description, category)
VALUES (FALSE, 5, 1, 1, 'Mesh Trui', 'Dit is een post over een mesh trui', 'truien'),
       (FALSE, 0, 2, 3, 'Gekleurde Sjaal', 'Dit is een post over een gekleurde sjaal', 'sjaals'),
       (FALSE, 10, 3, 3, 'Gestreepte Muts', 'Dit is een post over een gestreepte muts', 'mutsen'),
       (FALSE, 3, 4, 5, 'Handtas', 'Dit is een post over een handtas', 'tassen'),
       (FALSE, 15, 5, 3, 'Gehaakte Zomersjaal', 'Een lichte en luchtige sjaal perfect voor de zomer.', 'sjaals'),
       (FALSE, 20, 6, 5, 'Gehaakte Mandala', 'Een kleurrijke mandala om je interieur op te fleuren.', 'decoratie'),
       (FALSE, 25, 7, 5, 'Gehaakte Babydeken', 'Een zachte en warme deken voor de kleintjes.', 'dekens'),
       (FALSE, 30, 8, 1, 'Gehaakte Markt Tas', 'Een stevige en herbruikbare tas voor je boodschappen.', 'tassen'),
       (FALSE, 35, 9, 1, 'Gehaakte Zomerhoed', 'Bescherm jezelf tegen de zon met deze stijlvolle hoed.', 'accessoires'),
       (FALSE, 35, 10, 1, 'Gehaakte Knuffel', 'Schatige knuffel', 'accessoires');


-- Voeg patronen toe
INSERT INTO patterns (amount_of_yarn, darning_needle, hook_size, is_draft, length, likes, measuring_tape, scissor,
                      width, image_id, post_id, user_id, title, description, level, type_yarn)
VALUES (200, TRUE, 4.5, FALSE, 120.5, 7, TRUE, TRUE, 80.0, 1, 1, 2, 'Mesh Trui Patroon', 'Patroon voor een mesh trui', 'Beginner', 'Katoen'),
       (150, FALSE, 5.0, TRUE, 100.0, 3, FALSE, FALSE, 70.0, 2, 2, 4, 'Gekleurde Sjaal Patroon','Patroon voor een gekleurde sjaal', 'Medium', 'Wol'),
       (250, TRUE, 6.0, FALSE, 150.0, 12, TRUE, TRUE, 90.0, 3, 3, 6, 'Gestreepte Muts Patroon', 'Patroon voor een gestreepte muts', 'Expert', 'Alpaca'),
       (300, FALSE, 7.0, FALSE, 180.0, 8, TRUE, FALSE, 100.0, 4, 4, 2, 'Handtas Patroon', 'Patroon voor een handtas','Beginner', 'Linnen'),
       (100, TRUE, 3.5, FALSE, 150.0, 5, TRUE, TRUE, 50.0, 5, 5, 6, 'Zomersjaal Patroon 1', 'Eenvoudig patroon voor een zomerse sjaal.', 'Beginner', 'Katoen'),
       (120, TRUE, 4.0, FALSE, 160.0, 8, TRUE, TRUE, 55.0, 6, 5, 2, 'Zomersjaal Patroon 2', 'Geavanceerd patroon met kantdetails.', 'Gevorderd', 'Linnen'),
       (50, TRUE, 2.5, FALSE, 30.0, 10, TRUE, TRUE, 30.0, 7, 6, 4, 'Mandala Patroon 1', 'Eenvoudig mandala patroon met basissteken.', 'Beginner', 'Katoen'),
       (60, TRUE, 3.0, FALSE, 35.0, 12, TRUE, TRUE, 35.0, 8, 6, 4, 'Mandala Patroon 2', 'Mandala met complexe patronen en kleuren.', 'Expert', 'Wol'),
       (300, TRUE, 5.0, FALSE, 100.0, 15, TRUE, TRUE, 80.0, 9, 7, 6, 'Babydeken Patroon 1', 'Eenvoudig patroon voor een zachte babydeken.', 'Beginner', 'Acryl'),
       (350, TRUE, 5.5, FALSE, 110.0, 18, TRUE, TRUE, 85.0, 10, 7, 2, 'Babydeken Patroon 2', 'Geavanceerd patroon met kabeldetails.', 'Gevorderd', 'Wol'),
       (200, TRUE, 4.0, FALSE, 40.0, 20, TRUE, TRUE, 35.0, 11, 8, 6, 'Markt Tas Patroon 1', 'Eenvoudig patroon voor een stevige tas.', 'Beginner', 'Katoen'),
       (220, TRUE, 4.5, FALSE, 45.0, 22, TRUE, TRUE, 40.0, 12, 8, 6, 'Markt Tas Patroon 2', 'Tas met gehaakte bloemen als decoratie.', 'Gevorderd', 'Linnen');


-- Voeg comments toe
INSERT INTO comments (likes, parent_comment_id, pattern_id, post_id, time_stamp, user_id, message)
VALUES (2, NULL, 1, 1, CURRENT_TIMESTAMP, 1, 'Leuk patroon voor een trui, makkelijk te volgen!'),
       (3, NULL, 2, 2, CURRENT_TIMESTAMP, 2, 'Prachtig ontwerp voor een sjaal, kan niet wachten om het te maken!'),
       (1, NULL, 3, 3, CURRENT_TIMESTAMP, 1, 'De muts is mooi, maar iets moeilijker dan verwacht.'),
       (0, NULL, 4, 4, CURRENT_TIMESTAMP, 2, 'Mooi patroon voor een handtas, maar mis wat details.');

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





