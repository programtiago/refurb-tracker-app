INSERT INTO TB_EMPLOYEE
(first_name, last_name, birthday_date, department, function, admission_date, created_at, status, active, display_name, phone_number, worker_no, contract_start_date, contract_end_date)
VALUES
('Tiago', 'Silva', '1996-5-2', 'IT', 'IT Technician - Level 1', '2022-10-15', CURRENT_TIMESTAMP, 'AVAILABLE', TRUE, '[30015]-Tiago Silva', '+351965236812', '30015'),
('Maria', 'Oliveira', '1985-7-22', 'HR', 'HR Technician', '2022-10-15', CURRENT_TIMESTAMP, 'AVAILABLE', TRUE, '[30016]-Maria Oliveira', '+351935881236', '30016', ''),
('Marcelo', 'Pereira', '1994-5-23', 'PROD', 'Production Operator', '2023-1-10', CURRENT_TIMESTAMP, 'AVAILABLE', TRUE, '[80014]-Marcelo Pereira', '+351913975127', '80014', '2023-1-10', '2023-7-10'),
('Sabrina', 'Rocha', '1997-7-14', 'LOG', 'Warehouse Operator - Level 3', '2022-3-1', CURRENT_TIMESTAMP, 'AVAILABLE', TRUE, '[80015]-Sabrina Rocha', '+351965881218', '80015', '2022-3-1', '2022-9-1'),
('João', 'Ferreira', '1990-04-18', 'QA', 'Quality Technician', '2021-09-05', CURRENT_TIMESTAMP, 'AVAILABLE', TRUE, '[30017]-João Ferreira', '+351912345678', '30017'),
('Ana', 'Costa', '1988-11-02', 'PROD', 'Production Operator', '2020-06-12', CURRENT_TIMESTAMP, 'AVAILABLE', TRUE, '[80016]-Ana Costa', '+351934567890', '80016', '2025-8-16', '2026-2-16'),
('Ricardo', 'Santos', '1993-02-27', 'IT', 'IT Technician - Level 3', '2023-02-10', CURRENT_TIMESTAMP, 'AVAILABLE', TRUE, '[30018]-Ricardo Santos', '+351916789012', '30018'),
('Beatriz', 'Gomes', '1999-09-15', 'HR', 'Recruitment Assistant', '2023-03-20', CURRENT_TIMESTAMP, 'AVAILABLE', TRUE, '[30019]-Beatriz Gomes', '+351965432187', '30019',  ),
('Miguel', 'Almeida', '1987-03-30', 'PROD', 'Production Supervisor', '2019-05-25', CURRENT_TIMESTAMP, 'AVAILABLE', TRUE, '[80017]-Miguel Almeida', '+351927651234', '80017', '2025-8-16', '2026-2-16'),
('Patrícia', 'Lopes', '1992-06-09', 'LOG', 'Warehouse Operator - Level 1', '2021-07-19', CURRENT_TIMESTAMP, 'AVAILABLE', TRUE, '[30020]-Patrícia Lopes', '+351938765432', '30020', '2025-8-16', '2026-2-16');