import { Employee } from "./employee";

export interface InternalEmployee extends Employee {
    workerNo: string;
    employeeType: 'INTERNAL';
}