INSERT INTO restaurant_schema.restaurant_type VALUES("Specific romanesc");
INSERT INTO restaurant_schema.restaurant_type VALUES("Specific italian");
INSERT INTO restaurant_schema.restaurant_type VALUES("Specific spaniol");
INSERT INTO restaurant_schema.restaurant_type VALUES("Specific englezesc");
INSERT INTO restaurant_schema.restaurant_type VALUES("Specific rusesc");
INSERT INTO restaurant_schema.restaurant_type VALUES("Specific unguresc");

-- add restaurants
INSERT INTO restaurant_schema.restaurant(ID, NAME, RESTAURANT_TYPE_ID) VALUES("Osteria Sempre Buono", "Osteria Sempre Buono", "Specific romanesc");
INSERT INTO restaurant_schema.restaurant(ID, NAME, RESTAURANT_TYPE_ID) VALUES("Beraria H", "Beraria H", "Specific rusesc");
INSERT INTO restaurant_schema.restaurant(ID, NAME, RESTAURANT_TYPE_ID) VALUES("Caru' cu bere", "Caru' cu bere", "Specific rusesc");
INSERT INTO restaurant_schema.restaurant(ID, NAME, RESTAURANT_TYPE_ID) VALUES("Hanul lui Manuc", "Hanul lui Manuc", "Specific rusesc");
INSERT INTO restaurant_schema.restaurant(ID, NAME, RESTAURANT_TYPE_ID) VALUES("Nomad", "Nomad", "Specific englezesc");
INSERT INTO restaurant_schema.restaurant(ID, NAME, RESTAURANT_TYPE_ID) VALUES("Linea / Closer To The Moon", "Linea / Closer To The Moon", "Specific englezesc");
INSERT INTO restaurant_schema.restaurant(ID, NAME, RESTAURANT_TYPE_ID) VALUES("Nor Sky", "Nor Sky", "Specific unguresc");
INSERT INTO restaurant_schema.restaurant(ID, NAME, RESTAURANT_TYPE_ID) VALUES("La Raci", "La Raci", "Specific unguresc");
INSERT INTO restaurant_schema.restaurant(ID, NAME, RESTAURANT_TYPE_ID) VALUES("Casa di David", "Casa di David", "Specific unguresc");
INSERT INTO restaurant_schema.restaurant(ID, NAME, RESTAURANT_TYPE_ID) VALUES("Casa Doina", "Casa Doina", "Specific unguresc");

update restaurant_schema.restaurant set DESCRIPTION = name;