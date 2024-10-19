import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EmpAddEditComponent } from '../emp-add-edit/emp-add-edit.component';
import { FormGroup } from '@angular/forms';
import { EmployeService } from 'src/app/services/employe.service';
import { CoreService } from 'src/app/services/Core.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-employe',
  templateUrl: './employe.component.html',
  styleUrls: ['./employe.component.scss']
})
export class EmployeComponent implements OnInit {
  displayedColumns: string[] = [
    'id',
    'firstName',
    'lastName',
    'email',
    'Password',
   'Adresse',
    'Phone',
    'Grade',
    'action'
  ];
  dataSource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private _dialog: MatDialog ,private _empService: EmployeService, private _coreService: CoreService
    ) {}
  ngOnInit(): void {
    this.getEmployeeList(); // Add parentheses to invoke the method
  }
  openAddEditEmpForm() {
    const dialogRef = this._dialog.open(EmpAddEditComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getEmployeeList();
        }
      },
    });
  }
    getEmployeeList() {
      this._empService.getEmployeeList().subscribe({
        next: (res) => {
          this.dataSource = new MatTableDataSource(res);
          this.dataSource.sort = this.sort;
          this.dataSource.paginator = this.paginator;
        },
        error: console.log,
      });
    }
    applyFilter(event: Event) {
      const filterValue = (event.target as HTMLInputElement).value;
      this.dataSource.filter = filterValue.trim().toLowerCase();
  
      if (this.dataSource.paginator) {
        this.dataSource.paginator.firstPage();
      }
    }
    deleteEmployee(id: number) {
      this._empService.deleteEmployee(id).subscribe({
        next: (res) => {
          this._coreService.openSnackBar('Employé suprimé', 'Terminé');
          this.getEmployeeList();
        },
        error: console.log,
      });
    }
  
    openEditForm(data: any) {
      const dialogRef = this._dialog.open(EmpAddEditComponent, {
        data,
      });
  
      dialogRef.afterClosed().subscribe({
        next: (val) => {
          if (val) {
            this.getEmployeeList();
          }
        },
      });
    }
  }