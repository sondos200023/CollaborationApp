import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private firestore: AngularFirestore
  ) { }

  createNewUser(record: any): Promise<any> {
    return this.firestore.collection('Users').add(record);
  }

  readUsers(): Observable<any[]> {
    return this.firestore.collection('Users').snapshotChanges();
  }

  updateUser(recordID: string, record: any): void {
    this.firestore.doc(`Users/${recordID}`).update(record);
    console.log('updated');
  }

  deleteUser(record_id: string): void {
    this.firestore.doc(`Users/${record_id}`).delete();
  }
}
