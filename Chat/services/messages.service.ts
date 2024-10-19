import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(
    private firestore: AngularFirestore
  ) { }

  createNewMessage(record: any, room: string): Promise<any> {
    return this.firestore.collection(`Topics/${room}/Messages`).add(record);
  }

  readMessages(room: string): Observable<any[]> {
    return this.firestore.collection(`Topics/${room}/Messages`, ref => ref.orderBy('date')).snapshotChanges();
  }

  updateMessage(recordID: string, record: any, room: string): void {
    this.firestore.doc(`Topics/${room}/Messages/${recordID}`).update(record);
    console.log('updated');
  }

  deleteMessage(record_id: string, room: string): void {
    this.firestore.doc(`Topics/${room}/Messages/${record_id}`).delete();
  }
}
