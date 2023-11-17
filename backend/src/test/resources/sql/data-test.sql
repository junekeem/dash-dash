use dashdashdb;

insert into user (id, username, firstname, lastname, role, address, email, created_at, updated_at)
values (1, 'gmattersey0', 'Gerik', 'Mattersey', null, '593 Sunnyside Center', 'gmattersey0@vimeo.com',
        '2023-10-13 01:31:13', '2023-11-04 11:16:38');
insert into user (id, username, firstname, lastname, role, address, email, created_at, updated_at)
values (2, 'asindell1', 'Afton', 'Sindell', null, '6710 Lerdahl Alley', 'asindell1@linkedin.com', '2023-10-02 01:11:28',
        '2023-11-08 23:00:28');
insert into user (id, username, firstname, lastname, role, address, email, created_at, updated_at)
values (3, 'foscroft2', 'Fianna', 'Oscroft', null, '4 Florence Street', 'foscroft2@nationalgeographic.com',
        '2023-10-04 23:58:20', '2023-11-16 04:13:19');
insert into user (id, username, firstname, lastname, role, address, email, created_at, updated_at)
values (4, 'sscotsbrook3', 'Stephie', 'Scotsbrook', null, '69561 Dayton Center', 'sscotsbrook3@trellian.com',
        '2023-10-21 15:39:28', '2023-11-03 20:18:21');
insert into user (id, username, firstname, lastname, role, address, email, created_at, updated_at)
values (5, 'cfiennes4', 'Cosimo', 'Fiennes', null, '3 Porter Center', 'cfiennes4@weebly.com', '2023-10-14 06:37:58',
        '2023-11-06 00:13:27');
insert into user (id, username, firstname, lastname, role, address, email, created_at, updated_at)
values (6, 'dkincla5', 'Stévina', 'Kincla', null, '017 Beilfuss Crossing', 'akincla5@stumbleupon.com',
        '2023-10-08 13:58:30', '2023-11-11 18:21:41');
insert into user (id, username, firstname, lastname, role, address, email, created_at, updated_at)
values (7, 'wbartalucci6', 'Kuí', 'Bartalucci', null, '21 Toban Street', 'bbartalucci6@washingtonpost.com',
        '2023-10-12 04:52:28', '2023-11-09 11:11:04');
insert into user (id, username, firstname, lastname, role, address, email, created_at, updated_at)
values (8, 'wwhitehorn7', 'Fèi', 'Whitehorn', null, '4800 Columbus Plaza', 'ywhitehorn7@clickbank.net',
        '2023-10-12 05:08:37', '2023-11-13 06:32:38');
insert into user (id, username, firstname, lastname, role, address, email, created_at, updated_at)
values (9, 'rrenneke8', 'Lauréna', 'Renneke', null, '4 Glendale Court', 'mrenneke8@mayoclinic.com',
        '2023-10-16 13:07:10', '2023-11-12 04:45:59');
insert into user (id, username, firstname, lastname, role, address, email, created_at, updated_at)
values (10, 'sparkins9', 'Anaël', 'Parkins', null, '69381 Meadow Vale Terrace', 'dparkins9@cdc.gov',
        '2023-10-17 04:10:09', '2023-11-03 06:49:05');

insert into restaurant (id, name, phone, address, owner_id, created_at, updated_at)
values (1, 'Bankwell Financial Group, Inc.', '+62 (525) 217-0773', '14127 Gale Plaza', 6, '2023-10-22 14:34:19',
        '2023-11-16 09:22:01');
insert into restaurant (id, name, phone, address, owner_id, created_at, updated_at)
values (2, 'Tejon Ranch Co', '+351 (530) 727-4332', '5989 Northridge Lane', 6, '2023-10-24 12:27:02',
        '2023-11-03 20:01:03');
insert into restaurant (id, name, phone, address, owner_id, created_at, updated_at)
values (3, 'Vocera Communications, Inc.', '+7 (413) 389-0275', '2865 Esch Hill', 5, '2023-10-21 07:26:57',
        '2023-11-16 17:06:44');
insert into restaurant (id, name, phone, address, owner_id, created_at, updated_at)
values (4, 'Salem Media Group, Inc.', '+86 (834) 126-9211', '2 Susan Park', 8, '2023-10-24 12:56:26',
        '2023-11-09 05:53:36');
insert into restaurant (id, name, phone, address, owner_id, created_at, updated_at)
values (5, 'Capital One Financial Corporation', '+55 (448) 750-7374', '9 Lukken Point', 8, '2023-10-13 17:13:45',
        '2023-11-04 03:55:29');
insert into restaurant (id, name, phone, address, owner_id, created_at, updated_at)
values (6, 'ECA Marcellus Trust I', '+7 (752) 794-3769', '1 Bayside Parkway', 8, '2023-10-12 19:14:54',
        '2023-11-01 19:07:23');
insert into restaurant (id, name, phone, address, owner_id, created_at, updated_at)
values (7, 'Total System Services, Inc.', '+57 (787) 889-7440', '619 Schmedeman Parkway', 8, '2023-10-10 14:39:36',
        '2023-11-01 12:27:31');
insert into restaurant (id, name, phone, address, owner_id, created_at, updated_at)
values (8, 'Matson, Inc.', '+7 (902) 177-6821', '749 Forest Dale Parkway', 8, '2023-10-28 07:35:43',
        '2023-11-15 05:25:32');
insert into restaurant (id, name, phone, address, owner_id, created_at, updated_at)
values (9, 'Art''s-Way Manufacturing Co., Inc.', '+62 (900) 483-2945', '20 6th Point', 8, '2023-10-24 10:01:29',
        '2023-11-11 12:06:56');
insert into restaurant (id, name, phone, address, owner_id, created_at, updated_at)
values (10, 'DelMar Pharmaceuticals, Inc.', '+62 (824) 950-1016', '0725 Monica Trail', 7, '2023-10-17 04:36:08',
        '2023-11-12 13:59:19');

insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (1, 'Doilies - 7, Paper', 23.97, null, null, 1, '2023-10-05 04:50:49', '2023-11-08 04:14:51');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (2, 'Pork - Kidney', 11.34, null, null, 5, '2023-10-26 18:08:39', '2023-11-03 10:41:44');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (3, 'Container - Clear 32 Oz', 29.34, null, null, 5, '2023-10-28 03:23:14', '2023-11-15 03:59:12');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (4, 'Yucca', 15.11, null, null, 5, '2023-10-10 10:38:02', '2023-11-08 05:29:55');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (5, 'Asparagus - White, Fresh', 19.52, null, null, 1, '2023-10-20 19:38:50', '2023-11-16 05:13:42');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (6, 'Okra', 14.58, null, null, 3, '2023-10-10 16:14:19', '2023-11-10 03:03:41');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (7, 'Chocolate - White', 23.87, null, null, 5, '2023-10-17 22:25:45', '2023-11-15 16:41:26');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (8, 'Coffee - Almond Amaretto', 12.65, null, null, 3, '2023-10-06 10:27:52', '2023-11-13 12:29:20');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (9, 'Nantuket Peach Orange', 17.83, null, null, 5, '2023-10-30 17:50:28', '2023-11-15 19:34:49');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (10, 'Chilli Paste, Ginger Garlic', 8.49, null, null, 2, '2023-10-03 16:44:22', '2023-11-10 23:51:04');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (11, 'Olives - Kalamata', 7.47, null, null, 5, '2023-10-06 19:28:58', '2023-11-13 14:15:20');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (12, 'Muffin Hinge Container 6', 26.66, null, null, 1, '2023-10-30 17:11:15', '2023-11-03 14:57:09');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (13, 'Spice - Pepper Portions', 24.81, null, null, 1, '2023-10-26 21:00:46', '2023-11-10 23:50:46');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (14, 'Petite Baguette', 29.98, null, null, 3, '2023-10-09 20:11:12', '2023-11-16 10:48:57');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (15, 'Crab - Dungeness, Whole, live', 24.65, null, null, 1, '2023-10-15 05:51:27', '2023-11-03 06:24:05');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (16, 'Bread - Dark Rye', 27.61, null, null, 4, '2023-10-07 00:50:47', '2023-11-04 12:59:14');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (17, 'Compound - Orange', 19.16, null, null, 3, '2023-10-01 01:42:00', '2023-11-13 21:25:37');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (18, 'Macaroons - Homestyle Two Bit', 12.6, null, null, 4, '2023-10-29 22:31:32', '2023-11-02 09:35:51');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (19, 'Curry Powder', 15.99, null, null, 3, '2023-10-25 17:30:54', '2023-11-08 22:07:22');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (20, 'Oil - Shortening,liqud, Fry', 27.34, null, null, 3, '2023-10-30 06:56:35', '2023-11-08 09:37:32');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (21, 'Bread - Bagels, Mini', 28.92, null, null, 1, '2023-10-26 07:43:45', '2023-11-02 15:17:09');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (22, 'Plate Pie Foil', 25.23, null, null, 1, '2023-10-09 19:24:56', '2023-11-04 01:38:08');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (23, 'Wine - Ej Gallo Sonoma', 10.12, null, null, 3, '2023-10-06 20:51:06', '2023-11-13 22:30:41');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (24, 'Veal - Brisket, Provimi, Bone - In', 17.76, null, null, 2, '2023-10-17 22:23:56', '2023-11-08 12:27:39');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (25, 'Tamarind Paste', 28.09, null, null, 5, '2023-10-13 01:00:42', '2023-11-02 09:04:26');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (26, 'Country Roll', 18.39, null, null, 4, '2023-10-12 07:09:44', '2023-11-02 13:23:38');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (27, 'Beef - Ground Lean Fresh', 15.69, null, null, 3, '2023-10-02 16:55:39', '2023-11-01 17:04:18');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (28, 'Chocolate - Compound Coating', 25.26, null, null, 3, '2023-10-10 00:18:20', '2023-11-15 12:22:15');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (29, 'Container - Foam Dixie 12 Oz', 5.75, null, null, 5, '2023-10-18 17:24:01', '2023-11-12 14:04:11');
insert into menu (id, name, price, options, image, restaurant_id, created_at, updated_at)
values (30, 'Beef Ground Medium', 25.65, null, null, 4, '2023-10-18 19:59:40', '2023-11-03 06:25:09');

INSERT INTO `order` (id, user_id, restaurant_id, status, created_at, updated_at)
VALUES (1, 1, 1, 'PROCESSING', '2023-10-28 13:49:26', '2023-11-07 22:17:51');

INSERT INTO `order` (id, user_id, restaurant_id, status, created_at, updated_at)
VALUES (2, 1, 2, 'COMPLETED', '2023-10-07 04:59:56', '2023-11-04 00:54:20');

INSERT INTO `order` (id, user_id, restaurant_id, status, created_at, updated_at)
VALUES (3, 1, 3, 'PROCESSING', '2023-10-17 11:43:12', '2023-11-06 05:07:36');

INSERT INTO `order` (id, user_id, restaurant_id, status, created_at, updated_at)
VALUES (4, 1, 4, 'CREATED', '2023-10-07 15:45:05', '2023-11-12 14:49:14');

INSERT INTO `order` (id, user_id, restaurant_id, status, created_at, updated_at)
VALUES (5, 1, 5, 'CANCELED', '2023-10-04 07:38:03', '2023-11-03 05:54:01');

INSERT INTO `order` (id, user_id, restaurant_id, status, created_at, updated_at)
VALUES (6, 2, 1, 'PROCESSING', '2023-10-13 00:11:08', '2023-11-14 04:38:54');

INSERT INTO `order` (id, user_id, restaurant_id, status, created_at, updated_at)
VALUES (7, 2, 1, 'PROCESSING', '2023-10-08 14:35:46', '2023-11-13 04:10:39');

INSERT INTO `order` (id, user_id, restaurant_id, status, created_at, updated_at)
VALUES (8, 2, 2, 'CANCELED', '2023-10-14 06:40:05', '2023-11-01 18:38:55');

INSERT INTO `order` (id, user_id, restaurant_id, status, created_at, updated_at)
VALUES (9, 3, 3, 'PENDING', '2023-10-06 18:38:16', '2023-11-01 03:23:57');

INSERT INTO `order` (id, user_id, restaurant_id, status, created_at, updated_at)
VALUES (10, 4, 4, 'PENDING', '2023-10-23 18:48:48', '2023-11-09 02:38:51');

INSERT INTO order_detail (id, order_id, menu_id, quantity, created_at, updated_at)
VALUES (1, 1, 1, 2, '2023-10-05 14:00:00', '2023-11-01 14:00:00'),
       (2, 1, 5, 1, '2023-10-05 14:01:00', '2023-11-01 14:01:00');

INSERT INTO order_detail (id, order_id, menu_id, quantity, created_at, updated_at)
VALUES (3, 2, 2, 3, '2023-10-06 14:02:00', '2023-11-02 14:02:00');

INSERT INTO order_detail (id, order_id, menu_id, quantity, created_at, updated_at)
VALUES (4, 3, 6, 2, '2023-10-07 14:03:00', '2023-11-03 14:03:00');

INSERT INTO order_detail (id, order_id, menu_id, quantity, created_at, updated_at)
VALUES (5, 4, 11, 1, '2023-10-08 14:04:00', '2023-11-04 14:04:00'),
       (6, 4, 12, 1, '2023-10-08 14:05:00', '2023-11-04 14:05:00');

INSERT INTO order_detail (id, order_id, menu_id, quantity, created_at, updated_at)
VALUES (7, 6, 1, 1, '2023-10-09 14:06:00', '2023-11-05 14:06:00'),
       (8, 6, 5, 2, '2023-10-09 14:07:00', '2023-11-05 14:07:00');

INSERT INTO order_detail (id, order_id, menu_id, quantity, created_at, updated_at)
VALUES (9, 7, 7, 1, '2023-10-10 14:08:00', '2023-11-06 14:08:00'),
       (10, 7, 8, 1, '2023-10-10 14:09:00', '2023-11-06 14:09:00');

INSERT INTO order_detail (id, order_id, menu_id, quantity, created_at, updated_at)
VALUES (11, 9, 15, 1, '2023-10-11 14:10:00', '2023-11-07 14:10:00'),
       (12, 9, 17, 2, '2023-10-11 14:11:00', '2023-11-07 14:11:00');

INSERT INTO order_detail (id, order_id, menu_id, quantity, created_at, updated_at)
VALUES (13, 10, 24, 1, '2023-10-12 14:12:00', '2023-11-08 14:12:00'),
       (14, 10, 25, 2, '2023-10-12 14:13:00', '2023-11-08 14:13:00');

UPDATE order_detail
SET total_amount = quantity * (SELECT price FROM menu WHERE menu.id = order_detail.menu_id);