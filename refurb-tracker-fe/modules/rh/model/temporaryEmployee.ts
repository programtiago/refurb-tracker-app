import { BaseEmployee } from "./employee";

export interface TemporaryEmployee extends BaseEmployee {
    hiringEmploymentCompany: string;
}