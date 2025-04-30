INSERT INTO activity (titel, beschrijving, starttijd, eindtijd)
VALUES ('🎮 Speeltijd', 'Vrije tijd om spelletjes te spelen', '2025-04-14T09:30:00', '2025-04-28T10:30:00'),
       ('⚽ Voetbaltraining', 'Teamtraining op het veld', '2025-01-28T16:00:00', '2025-04-28T17:30:00'),
       ('📚 bib', 'boeken halen', '2025-04-28T18:00:00', '2025-04-28T19:00:00'),
       ('🎨 Tekenen & Schilderen', 'Creatief tekenen en schilderen', '2025-04-16T11:00:00', '2025-04-29T12:00:00'),
       ('🏞️ Familiepicknick', 'Picknick in de buitenlucht met het hele gezin', '2025-05-30T12:00:00', '2025-04-30T15:00:00');

INSERT INTO tasks (titel, beschrijving, starttijd, eindtijd)
VALUES
    ('🧹 Kamer opruimen', 'Kleding en spullen opruimen in de slaapkamer', '2025-04-28T14:00:00', '2025-04-28T14:30:00'),
    ('🧼 Badkamer schoonmaken', 'Wastafel, douche en toilet poetsen', '2025-04-29T10:00:00', '2025-04-29T10:45:00'),
    ('🧺 Was opvouwen', 'Schone was sorteren en opvouwen', '2025-04-29T15:00:00', '2025-04-29T15:30:00'),
    ('🧽 Keuken schoonmaken', 'Aanrecht en eettafel poetsen', '2025-04-30T09:00:00', '2025-04-30T09:30:00'),
    ('🗑️ Vuilnis buitenzetten', 'Afval sorteren en containers aan de straat zetten', '2025-04-30T19:00:00', '2025-04-30T19:15:00');





-- Inserting User's and Admins --

-- Developers --
-- Inserting admin:thibeau :
-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('thibeau', '$2a$10$ofVE1aOcWwxldFtwjliCOujCjOIIXP5PjQyw0Jvp1P3lE0dFJVNx.', true);
-- INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
-- VALUES ('thibeau', 'ADMIN');
--
-- -- Inserting admin:jasper :
-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('jasper', '$2a$10$tDKuQ8HnXkzBw7gztwuAR.UsGNs09.fKiKVojkdpnY/dSf35BOdw2', true);
-- INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
-- VALUES ('jasper', 'ADMIN');
--
-- -- Inserting admin:Sonny :
-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('sonny', '$2a$10$tDKuQ8HnXkzBw7gztwuAR.UsGNs09.fKiKVojkdpnY/dSf35BOdw2', true);
-- INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
-- VALUES ('sonny', 'ADMIN');
--
-- -- Inserting admin:Enes :
-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('enes', '$2a$10$tDKuQ8HnXkzBw7gztwuAR.UsGNs09.fKiKVojkdpnY/dSf35BOdw2', true);
-- INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
-- VALUES ('enes', 'ADMIN');
-- -- Developers --
--
-- -- Inserting Ouders --
-- -- Inserting user:Papa :
-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('papa', '$2a$10$tDKuQ8HnXkzBw7gztwuAR.UsGNs09.fKiKVojkdpnY/dSf35BOdw2', true);
-- INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
-- VALUES ('papa', 'ADMIN');
--
-- -- Inserting admin:Mama :
-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('mama', '$2a$10$tDKuQ8HnXkzBw7gztwuAR.UsGNs09.fKiKVojkdpnY/dSf35BOdw2', true);
-- INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
-- VALUES ('mama', 'ADMIN');
--
-- -- Inserting Tieners --
-- -- Inserting admin:Tiener1 :
-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('tiener1', '$2a$10$tDKuQ8HnXkzBw7gztwuAR.UsGNs09.fKiKVojkdpnY/dSf35BOdw2', true);
-- INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
-- VALUES ('tiener1', 'user');
--
-- -- Inserting admin:Tiener2 :
-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('tiener2', '$2a$10$tDKuQ8HnXkzBw7gztwuAR.UsGNs09.fKiKVojkdpnY/dSf35BOdw2', true);
-- INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
-- VALUES ('tiener2', 'user');
--
-- -- Inserting Kinderen --
-- -- Inserting admin:Kind1 :
-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('kind1', '$2a$10$tDKuQ8HnXkzBw7gztwuAR.UsGNs09.fKiKVojkdpnY/dSf35BOdw2', true);
-- INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
-- VALUES ('kind1', 'user');
--
-- -- Inserting admin:Kind2 :
-- INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
-- VALUES ('kind2', '$2a$10$tDKuQ8HnXkzBw7gztwuAR.UsGNs09.fKiKVojkdpnY/dSf35BOdw2', true);
-- INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
-- VALUES ('kind2', 'user');


