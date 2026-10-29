CREATE TABLE applications (
                              id BIGSERIAL PRIMARY KEY,
                              title VARCHAR(255) NOT NULL,
                              description VARCHAR(255) NOT NULL,
                              category VARCHAR(255),
                              priority VARCHAR(255) NOT NULL DEFAULT 'MEDIUM',
                              created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              status VARCHAR(255) NOT NULL DEFAULT 'NEW'
);
