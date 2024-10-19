import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CoreService } from 'src/app/services/Core.service';
import { ProjetService } from 'src/app/services/projet.service';
import { ProjAddEditComponent } from '../proj-add-edit/proj-add-edit.component';

@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.scss']
})
export class ProjetComponent implements OnInit {
  displayedColumns: string[] = [
    'id',
    'Titre',
    'DateDePublication',
    'DateDeModification',
    'ChefDEquipe',
    'action'
  ];
  dataSource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private _dialog: MatDialog ,private _projService: ProjetService, private _coreService: CoreService
    ) {}
  ngOnInit(): void {
    this.getProjetList(); // Add parentheses to invoke the method
  }
  openAddEditprojForm() {
    const dialogRef = this._dialog.open(ProjAddEditComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getProjetList();
        }
      },
    });
  }
    getProjetList() {
      this._projService.getProjetList().subscribe({
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
    deleteProjet(id: number) {
      this._projService.deleteProjet(id).subscribe({
        next: (res) => {
          this._coreService.openSnackBar('projet suprimé', 'Terminé');
          this.getProjetList();
        },
        error: console.log,
      });
    }
  
    openEditForm(data: any) {
      const dialogRef = this._dialog.open(ProjAddEditComponent, {
        data,
      });
  
      dialogRef.afterClosed().subscribe({
        next: (val) => {
          if (val) {
            this.getProjetList();
          }
        },
      });
    }
  }