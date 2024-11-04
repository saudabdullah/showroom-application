CREATE TABLE tbl_showroom (
                              id UUID PRIMARY KEY,
                              name VARCHAR(255),
                              commercial_registration_number BIGINT,
                              manger_name VARCHAR(255),
                              contact_number BIGINT,
                              address VARCHAR(255),
                              deleted BOOLEAN DEFAULT FALSE
);


CREATE TABLE tbl_cars (
                          id UUID PRIMARY KEY,
                          vin VARCHAR(255),
                          maker VARCHAR(255),
                          model VARCHAR(255),
                          model_year INT,
                          price DOUBLE PRECISION,
                          deleted BOOLEAN DEFAULT FALSE,
                          showroom_id UUID,
                          CONSTRAINT fk_showroom FOREIGN KEY (showroom_id) REFERENCES tbl_showroom (id)
);