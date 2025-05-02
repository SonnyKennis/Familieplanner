CREATE TABLE grocery_list
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    quantity  VARCHAR(255) NOT NULL,
    brand     VARCHAR(255) NOT NULL,
    completed BOOLEAN DEFAULT FALSE
);