CREATE TABLE quantity_measurements (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    operand1 VARCHAR(50),
    operand2 VARCHAR(50),
    operationType VARCHAR(50),
    result VARCHAR(50),
    errorMessage VARCHAR(255),
    timestamp TIMESTAMP
);