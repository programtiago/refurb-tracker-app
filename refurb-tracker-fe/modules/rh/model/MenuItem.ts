import { ChildrenMenuItem } from "./ChildrenMenuItem";

export interface MenuItem {
    title: string;
    path: string;
    description: string;
    subMenuItems: ChildrenMenuItem[]
}