import { Routes } from '@angular/router';
import { LoginBoxComponent } from './components/login/login-box.component';
import { HomeComponent } from './components/home/home.component';
import { GroupsComponent } from './components/home/list/groups/groups.component';
import { CredentialsComponent } from './components/home/list/credentials/credentials.component';
import { OverviewComponent } from './components/home/overview/overview.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { PresentationComponent } from './components/welcome/presentation/presentation.component';
import { AboutmeComponent } from './components/welcome/aboutme/aboutme.component';
import { GoalsComponent } from './components/welcome/goals/goals.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: '/index',  // Redirection de la route vide vers /index
        pathMatch: 'full'  // Assure que la redirection se fait pour la route complète
    },
    {
        path: 'index',
        component: WelcomeComponent,
        children: [
            {
                path: 'presentation',
                component: PresentationComponent
            },
            {
                path: 'aboutme',
                component: AboutmeComponent
            },
            {
                path: 'goals',
                component: GoalsComponent
            },
            {
                path: '',
                redirectTo: 'presentation',
                pathMatch: 'full',
            },
            {
                path: '**',  // Capture toutes les sous-routes non définies
                redirectTo: 'presentation',  // Redirige vers /index
            },
        ]
    },
    {
        path: 'login',
        component: LoginBoxComponent
    },
    {
        path: 'home',
        component: HomeComponent,
        children: [
            {
                path: 'groups',
                component: GroupsComponent

            },
            {
                path: 'credentials',
                component: CredentialsComponent
            },
            {
                path: 'overview',
                component: OverviewComponent
            },
        ]
    },
    {
        path: '**',  // Capture toutes les routes non définies
        redirectTo: '/index'  // Redirige vers /index
    }
];
