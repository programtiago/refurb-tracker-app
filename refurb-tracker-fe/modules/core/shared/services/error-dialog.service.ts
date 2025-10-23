import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from '../components/error-dialog/error-dialog.component';

@Injectable({
  providedIn: 'root'
})
export class ErrorDialogService {

  constructor(private dialog: MatDialog) { }

  openDialog(title: string, message: string){
    this.dialog.open(ErrorDialogComponent, {
      width: '400px',
      data: { title, message },
      panelClass: 'error-dialog-container'
    })
  }
}
