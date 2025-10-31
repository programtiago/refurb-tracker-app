import { AfterViewInit, Component, OnInit, QueryList, ViewChildren } from '@angular/core';
import { RhService } from '../../../../rh/services/rh.service';
import { MenuItem } from '../../../../rh/model/menuItem';
import { MatMenu } from '@angular/material/menu';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit, AfterViewInit{

  menuItems: MenuItem[] = [];
  subMenus = new Map<MenuItem, MatMenu>();

  @ViewChildren(MatMenu) menus!: QueryList<MatMenu>;
  
  constructor(private rhService: RhService){}

  ngOnInit(): void {
    this.rhService.getMenuItemsList().subscribe({
      next: (res) => {
        this.menuItems = res,
        this.mapSubMenus();
      },
      error: (err) => console.error('Error loading menu:', err)
    })
  }

  ngAfterViewInit(): void {
    this.menus.changes.subscribe(() => this.mapSubMenus());
    this.mapSubMenus();
  }

  private mapSubMenus(){
    const menusArray = this.menus?.toArray() ?? [];
    this.menuItems.forEach((item, index) => {
      if (item.subMenuItems?.length && menusArray[index]){
        setTimeout(() => this.subMenus.set(item, menusArray[index]));
      }
    });
  }

  getSubMenu(item: MenuItem): MatMenu | null {
    return this.subMenus.get(item) ?? null;
  }

}
