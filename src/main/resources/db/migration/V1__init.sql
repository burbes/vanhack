
CREATE TABLE cousine (
                id INTEGER(11) NOT NULL,
                name VARCHAR(30) NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE store (
                id INTEGER(11) NOT NULL,
                name VARCHAR(30) NOT NULL,
                address VARCHAR(30) NOT NULL,
                cousine_id INTEGER(11) NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE product (
                id INTEGER(11) NOT NULL,
                store_id INTEGER(11) NOT NULL,
                name VARCHAR(30) NOT NULL,
                description VARCHAR(30) NOT NULL,
                price DOUBLE  NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE customer (
                id INTEGER(11) AUTO_INCREMENT NOT NULL,
                email VARCHAR(30) NOT NULL,
                name VARCHAR(30) NOT NULL,
                address VARCHAR(30) NOT NULL,
                date_creation DATE NOT NULL,
                password VARCHAR(30) NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE pedido (
                id INTEGER(11) NOT NULL,
                date DATE NOT NULL,
                customer_id INTEGER(11) NOT NULL,
                delivery_address VARCHAR(30) NOT NULL,
                contact VARCHAR(30) NOT NULL,
                store_id INTEGER(11) NOT NULL,
                total DOUBLE  NOT NULL,
                status VARCHAR(30) NOT NULL,
                last_update DATE NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE order_item (
                id INTEGER(11) NOT NULL,
                order_id INTEGER(11) NOT NULL,
                product_id INTEGER(11) NOT NULL,
                price DOUBLE  NOT NULL,
                quantity INTEGER(11) NOT NULL,
                total DOUBLE  NOT NULL,
                PRIMARY KEY (id)
);


ALTER TABLE store ADD CONSTRAINT cousine_store_fk
FOREIGN KEY (cousine_id)
REFERENCES cousine (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE product ADD CONSTRAINT store_product_fk
FOREIGN KEY (store_id)
REFERENCES store (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE order_item ADD CONSTRAINT product_order_item_fk
FOREIGN KEY (product_id)
REFERENCES product (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE order_item ADD CONSTRAINT product_order_item_fk1
FOREIGN KEY (product_id)
REFERENCES product (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE order_item ADD CONSTRAINT product_order_item_fk2
FOREIGN KEY (product_id)
REFERENCES product (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE pedido ADD CONSTRAINT customer_order_fk
FOREIGN KEY (customer_id)
REFERENCES customer (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE order_item ADD CONSTRAINT order_order_item_fk
FOREIGN KEY (order_id)
REFERENCES pedido (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;