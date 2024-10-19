import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: 'Tableau de bord',
    url: '/dashboard',
    iconComponent: { name: 'cil-speedometer' },
    badge: {
      color: 'info',
      text: 'NOUVEAU'
    }
  },
  {
    title: true,
    name: 'Projets'
  },
  {
    name: 'Liste des Projets',
    url: '/projet',
    iconComponent: { name: 'cil-chart' }
  },
  {
    name: 'Liste des Tâches',
    url: '/taches',
    linkProps: { fragment: 'someAnchor' },
    iconComponent: { name: 'cil-pencil' }
  },
  {
    name: 'Discussion',
    title: true,
  
  },
  {
    name: 'chat',
    url: '/chat',
    iconComponent: { name: 'cil-speech' }
  },
  {
    name: 'Plus',
    url: '/login',
    iconComponent: { name: 'cil-star' },
    children: [
      {
        name: 'Déconnexion',
        url: '/login',
        iconComponent: { name: 'cil-lock-locked' },
      },
      {
        name: 'Inscription',
        url: '/register',
        iconComponent: { name: 'cil-user-follow' },
      },
      
    ]
  },
];
