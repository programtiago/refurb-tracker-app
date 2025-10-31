import { Component, OnInit, QueryList, ViewChildren } from '@angular/core';
import { RhService } from '../../../../rh/services/rh.service';
import { MenuItem } from '../../../../rh/model/menuItem';
import { MatMenu } from '@angular/material/menu';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit{

  menuItems: MenuItem[] = [];

  @ViewChildren(MatMenu) menus!: QueryList<MatMenu>;

  ngOnInit(): void {
    this.rhService.getMenuItemsList().subscribe({
      next: (res) => (this.menuItems = res),
      error: (err) => console.error('Error loading menu:', err)
    })
  }

  constructor(private rhService: RhService){}

  getSubMenu(item: MenuItem): MatMenu | null {
    const index = this.menuItems.indexOf(item);
    return this.menus?.toArray()[index + 1] ?? null;
  }

}
