CREATE TABLE library (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);

CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    library_id INTEGER NOT NULL,
    FOREIGN KEY (library_id) REFERENCES library(id) ON DELETE CASCADE
);

CREATE TABLE audit_events (
    id SERIAL PRIMARY KEY,
    entity_name VARCHAR(255) NOT NULL,
    entity_id BIGINT NOT NULL,
    change_type VARCHAR(50) NOT NULL,
    change_details TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE notification_conditions (
    id SERIAL PRIMARY KEY,
    entity_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);