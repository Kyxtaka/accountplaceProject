import { Routes } from '@angular/router';
import { LoginBoxComponent } from './components/login/login-box.component';
import { IndexComponent } from './components/index/index.component';
import { HomeComponent } from './components/home/home.component';
import { GroupsComponent } from './components/home/list/groups/groups.component';
import { CredentialsComponent } from './components/home/list/credentials/credentials.component';

export const routes: Routes = [
    {
        path: '',
        component: IndexComponent
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
                path: 'list/group',
                component: GroupsComponent

            },
            {
                path: 'list/credentials',
                component: CredentialsComponent
            },
        ]
    },
];
