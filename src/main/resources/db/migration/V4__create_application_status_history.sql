
CREATE TABLE application_status_history (
                                            id BIGSERIAL PRIMARY KEY,
                                            application_id BIGINT NOT NULL,
                                            old_status VARCHAR(30),
                                            new_status VARCHAR(30) NOT NULL,
                                            changed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                                            CONSTRAINT fk_status_history_application
                                                FOREIGN KEY (application_id)
                                                    REFERENCES applications(id)
                                                    ON DELETE CASCADE
);

CREATE INDEX idx_status_history_application_id
    ON application_status_history(application_id);
