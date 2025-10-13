CREATE TABLE TB_TEMPORARY_EMPLOYEE (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    elo_code VARCHAR(255),
    contract_start_date DATE,
    contract_end_date DATE,
    hiring_employment_company VARCHAR(255),
    employee_type VARCHAR(50) NOT NULL,

    FOREIGN KEY (id) REFERENCES TB_EMPLOYEE(id)
);
