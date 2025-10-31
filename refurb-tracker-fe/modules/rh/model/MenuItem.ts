import { ChildrenMenuItem } from "./childrenMenuItem";

export interface MenuItem {
    title: string;
    path: string;
    description: string;
    subMenuItems: ChildrenMenuItem[]
}