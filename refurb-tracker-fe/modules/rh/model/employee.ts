import { InternalEmployee } from "./internalEmployee";
import { TemporaryEmployee } from "./temporaryEmployee";

export interface BaseEmployee {
    id: number;
    firstName: string;
    lastName: string;
    birthdayDate?: string;
    department: string;
    position: string;
    workerNo: string;
    admissionDate?: string;
    contractStartDate: string;
    contractEndDate: string;
    createdAt: Date;
    status: string;
    active: boolean;
    displayName: string;
    employeeType: 'INTERNAL' | 'TEMPORARY';
    phoneNumber: string;
}

export type Employee = InternalEmployee | TemporaryEmployee