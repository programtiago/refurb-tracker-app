INSERT INTO TB_ERP_RECEPTION (
       operation_date,
       operation_by,
       reception_identifier,
       purchase_order,
       pallet_id,
       sn,
       cpe_instance_id
)
VALUES
(CURRENT_TIMESTAMP, 'Employee A', 'RECEPTION', 'REC000008', 'PO0000018', 'P-25090000242', 1),
(CURRENT_TIMESTAMP, 'Employee B', 'RECEPTION', 'REC000008', 'PO0000018', 'P-25090000242', 2),
(CURRENT_TIMESTAMP, 'Employee C', 'RECEPTION', 'REC000008', 'PO0000018', 'P-25090000242', 3),
(CURRENT_TIMESTAMP, 'Employee D', 'RECEPTION', 'REC000009', 'PO0000018', 'P-25090000242', 4),
(CURRENT_TIMESTAMP, 'Employee E', 'RECEPTION', 'REC000010', 'PO0000018', 'P-25090000242', 5);

