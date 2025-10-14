import { Employee } from "./employee";

export interface TemporaryEmployee extends Employee {
    eloCode: string;
    contractStartDate: Date;
    contractEndDate: Date;
    hiringEmploymentCompany: string;
    employeeType: 'TEMPORARY';
}