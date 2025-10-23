import { BaseEmployee } from "./employee";

export interface InternalEmployee extends BaseEmployee {
    workerNo: string;
}