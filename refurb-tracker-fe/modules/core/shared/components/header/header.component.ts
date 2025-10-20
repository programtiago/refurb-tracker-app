import { Component } from '@angular/core';
import { RhService } from '../../../../rh/services/rh.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

  constructor(private rhService: RhService){
    this.rhService.getMenuItemsList().subscribe((res) => {
      console.log(res)
    })
  }
}
