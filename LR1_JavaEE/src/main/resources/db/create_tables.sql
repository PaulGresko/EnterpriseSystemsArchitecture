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