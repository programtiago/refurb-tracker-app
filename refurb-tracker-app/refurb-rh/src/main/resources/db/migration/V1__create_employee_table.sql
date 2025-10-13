CREATE TABLE TB_EMPLOYEE (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(10) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    birthday_date DATE NOT NULL,
    department VARCHAR(15) NOT NULL,
    function VARCHAR(50) NOT NULL,
    admission_date DATE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    display_name VARCHAR(40) NOT NULL
);
