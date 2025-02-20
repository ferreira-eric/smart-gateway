CREATE TABLE actuator (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          value_field FLOAT,
                          active BOOLEAN
);

CREATE TABLE sensor (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255),
                        value_field FLOAT,
                        unit VARCHAR(50),
                        active BOOLEAN NOT NULL,
                        updated_at TIMESTAMP NOT NULL
);

