import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TopicService {

  constructor(
    private firestore: AngularFirestore
  ) { }

  createNewTopic(record: any): Promise<any> {
    return this.firestore.collection('Topics').add(record);
  }

  readTopics(): Observable<any[]> {
    return this.firestore.collection('Topics').snapshotChanges();
  }

  updateTopic(recordID: string, record: any): void {
    this.firestore.doc('Topics/' + recordID).update(record);
    console.log('updated');
  }

  deleteTopic(record_id: string): void {
    this.firestore.doc('Topics/' + record_id).delete();
  }
}
