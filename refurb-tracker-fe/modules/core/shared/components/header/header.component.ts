import { Component } from '@angular/core';
import { RhService } from '../../../../rh/services/rh.service';
import { MenuItem } from '../../../../rh/model/MenuItem';
import { ChildrenMenuItem } from '../../../../rh/model/ChildrenMenuItem';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

  menuItems: MenuItem[] = [];
  subMenuItems: ChildrenMenuItem[] = []

  constructor(private rhService: RhService){
    this.rhService.getMenuItemsList().subscribe((res) => {
      this.menuItems = res;
      
      this.subMenuItems = res.flatMap(menu => menu.subMenuItems);

      console.log("Menu Items: ", this.menuItems);
      console.log("Sub Menu Items: ", this.subMenuItems);
    })
  }
}
