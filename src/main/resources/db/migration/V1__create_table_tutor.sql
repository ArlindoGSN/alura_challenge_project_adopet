CREATE TABLE tutor
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    name         VARCHAR(255)          NOT NULL,
    phone_number VARCHAR(255)          NOT NULL,
    city         VARCHAR(255)          NOT NULL,
    about        VARCHAR(255),
    CONSTRAINT pk_tutor PRIMARY KEY (id)
);