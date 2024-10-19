import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CoreService } from 'src/app/services/Core.service';
import { EmployeService } from 'src/app/services/employe.service';

@Component({
  selector: 'app-emp-add-edit',
  templateUrl: './emp-add-edit.component.html',
  styleUrls: ['./emp-add-edit.component.scss']
})
export class EmpAddEditComponent implements OnInit {
  empForm:FormGroup;
  constructor(
    private _fb: FormBuilder , private _empService: EmployeService,    private _dialogRef: MatDialogRef<EmpAddEditComponent>,
    @Inject(MAT_DIALOG_DATA)
     public data: any,
    private _coreService: CoreService
    ){
      this.empForm = this._fb.group({
        firstName: '',
        lastName: '',
        email: '',
        Password: '',
        Adresse: '',
        Phone: '',
        Grade : '',
       
      });
    }
    ngOnInit(): void {
      this.empForm.patchValue(this.data);
    }
  
    onFormSubmit() {
      if (this.empForm.valid) {
        if (this.data) {
          this._empService
            .updateEmployee(this.data.id, this.empForm.value)
            .subscribe({
              next: (val: any) => {
                this._coreService.openSnackBar('Mise à jour validé');
                this._dialogRef.close(true);
              },
              error: (err: any) => {
                console.error(err);
              },
            });
        } else {
          this._empService.addEmployee(this.empForm.value).subscribe({
            next: (val: any) => {
              this._coreService.openSnackBar('Employé ajouté');
              this._dialogRef.close(true);
            },
            error: (err: any) => {
              console.error(err);
            },
          });
        }
      }
    }
  }