CREATE TABLE hotels
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  TEXT,
    brand        VARCHAR(255) NOT NULL,
    house_number INT          NOT NULL,
    street       VARCHAR(255) NOT NULL,
    city         VARCHAR(255) NOT NULL,
    country      VARCHAR(255) NOT NULL,
    post_code    VARCHAR(24)  NOT NULL,
    phone        VARCHAR(24)  NOT NULL,
    email        VARCHAR(255) NOT NULL,
    check_in     TIME         NOT NULL,
    check_out    TIME
);

CREATE TABLE amenities
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    hotel_id BIGINT       NOT NULL,
    name     VARCHAR(255) NOT NULL,
    CONSTRAINT fk_hotel_amenities FOREIGN KEY (hotel_id) REFERENCES hotels (id)
);