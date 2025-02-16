INSERT INTO organizers (id, name, description) VALUES (101, 'Nishu GalleryNishu Gallery', 'Nishu Gallery Technology Corporation');
INSERT INTO organizers (id, name, description) VALUES (102, 'DEV Rock', 'DEV Rock Sports Equipment');

INSERT INTO venues (id, name, street, city, country) VALUES (201, 'Nishu Gallery Main Office', 'Test Street 325', 'Delhi', 'India');
INSERT INTO venues (id, name, street, city, country) VALUES (202, 'Sea View Hotel', 'Beach Boulevard 863', 'Noida', 'India');

INSERT INTO events (id, name, organizer_id, venue_id, start_date, end_date) VALUES (501, 'Nishu Gallery Tech Conference', 101, 201, '2023-10-02', '2023-10-04');
INSERT INTO events (id, name, organizer_id, venue_id, start_date, end_date) VALUES (502, 'Nishu Gallery Developer Day', 101, 201, '2024-01-10', '2024-01-10');
INSERT INTO events (id, name, organizer_id, venue_id, start_date, end_date) VALUES (503, 'DEV Rock New Products Day', 102, 202, '2024-02-29', '2024-02-29');

INSERT INTO products (id, event_id, name, description, price) VALUES (801, 501, 'Standard', 'Standard Conference Ticket', 499.00);
INSERT INTO products (id, event_id, name, description, price) VALUES (802, 501, 'Premium', 'Premium Conference Ticket', 649.00);
INSERT INTO products (id, event_id, name, description, price) VALUES (803, 502, 'Standard', 'Developer Day Ticket', 195.50);
INSERT INTO products (id, event_id, name, description, price) VALUES (804, 503, 'Regular', 'Regular Entrance', 35.00);
INSERT INTO products (id, event_id, name, description, price) VALUES (805, 503, 'VIP', 'VIP Bonus Entrance', 65.00);
