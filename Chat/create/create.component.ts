import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Topic } from '../classes/topic';
import { TopicService } from 'src/app/Chat/services/topic.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  topic: Topic = new Topic(); // Initialisez topic avec une nouvelle instance de Topic

  constructor(private topicService: TopicService, private router: Router) { }

  ngOnInit() {
    // Vous pouvez initialiser d'autres propriétés de topic si nécessaire
    // Exemple : this.topic.titre = ''; this.topic.description = ''; this.topic.cle = '';
  }

  CreateRecord() {
    const record = {
      titre: this.topic.titre, // Utilisez directement les propriétés de l'objet topic
      description: this.topic.description,
      cle: this.topic.cle
    };
  
    this.topicService.createNewTopic(record).then(resp => {
      console.log(resp);
      alert('ajouté avec succès!');
      
      // Utilisez le router pour naviguer vers une autre page
      this.router.navigate(['topic']);
    })
    .catch(error => {
      console.log(error);
    });
  }
}
