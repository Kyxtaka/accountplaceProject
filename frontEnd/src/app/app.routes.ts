import { Routes } from '@angular/router';
import { LoginBoxComponent } from './components/login/login-box.component';
import { HomeComponent } from './components/home/home.component';
import { GroupsComponent } from './components/home/list/groups/groups.component';
import { CredentialsComponent } from './components/home/list/credentials/credentials.component';
import { OverviewComponent } from './components/home/overview/overview.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { NotFoundComponent } from './components/not-found/not-found.component';

export const routes: Routes = [ 
    {
        path: '',
        component: WelcomeComponent,
    },
    // {
    //     path: '/',
    //     redirectTo: ''
    // },
    {
        path: 'login',
        component: LoginBoxComponent
    },
    {
        path: 'home',
        component: HomeComponent,
        children: [
            {
                path: '',
                redirectTo: 'overview',
                pathMatch: 'full',
            },
            {
                path: 'overview',
                component: OverviewComponent
            },
            {
                path: 'groups',
                component: GroupsComponent
            },
            {
                path: 'credentials',
                component: CredentialsComponent
            },
        ]
    },
    {
        path: '**',
        component: NotFoundComponent
    }
];