import { Component, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  user: User = new User(); // Initialisez user directement
  constructor(private userService: UserService) {}

  ngOnInit() {
    if (localStorage.length > 0) {
      // Supprimez l'utilisateur précédent s'il existe
      const previousUserId = localStorage.getItem('id');
      if (previousUserId) {
        this.userService.deleteUser(previousUserId);
      }
      localStorage.clear();
    }
  }

  CreateRecord() {
    const record: any = {};
    record['pseudo'] = this.user.pseudo;

    this.userService.createNewUser(record).then((resp: any) => {
      localStorage.setItem('pseudo', this.user.pseudo);
      localStorage.setItem('id', resp.id);
      localStorage.setItem('room', 'chat');

      window.location.replace('accueil');
      console.log(resp);
    }).catch((error: any) => {
      console.log(error);
    });
  }
}
