import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CoreService } from 'src/app/services/Core.service';
import { ProjetService } from 'src/app/services/projet.service';

@Component({
  selector: 'app-proj-add-edit',
  templateUrl: './proj-add-edit.component.html',
  styleUrls: ['./proj-add-edit.component.scss']
})
export class ProjAddEditComponent  implements OnInit {
  projForm!:FormGroup;
  constructor(
    private _fb: FormBuilder , private _projService: ProjetService,    private _dialogRef: MatDialogRef<ProjAddEditComponent>,
    @Inject(MAT_DIALOG_DATA)
     public data: any,
    private _coreService: CoreService
    ){
      this.projForm = this._fb.group({
        Titre: '',
        DateDePublication:'' ,
        DateDeModification: '',
        ChefDEquipe: '',
       
      });
    }
    ngOnInit(): void {
      this.projForm.patchValue(this.data);
    }
  
    onFormSubmit() {
      if (this.projForm.valid) {
        if (this.data) {
          this._projService
            .updateProjet(this.data.id, this.projForm.value)
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
          this._projService.addProjet(this.projForm.value).subscribe({
            next: (val: any) => {
              this._coreService.openSnackBar('projet ajouté');
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