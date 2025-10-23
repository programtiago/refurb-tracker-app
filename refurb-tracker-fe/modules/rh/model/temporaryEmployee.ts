import { BaseEmployee } from "./employee";

export interface TemporaryEmployee extends BaseEmployee {
    eloCode: string;
    contractStartDate: Date;
    contractEndDate: Date;
    hiringEmploymentCompany: string;
}