export interface Employee {
    id: number;
    firstName: string;
    lastName: string;
    birthdayDate?: string;
    department: string;
    position: string;
    admissionDate?: string;
    createdAt: Date;
    status: string;
    active: boolean;
    displayName: string;
    employeeType: 'INTERNAL' | 'TEMPORARY';
    phoneNumber: string;
}