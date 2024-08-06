import { Routes } from '@angular/router';
import { LoginBoxComponent } from './components/login/login-box.component';
import { HomeComponent } from './components/home/home.component';
import { GroupsComponent } from './components/home/list/groups/groups.component';
import { CredentialsComponent } from './components/home/list/credentials/credentials.component';
import { OverviewComponent } from './components/home/overview/overview.component';

export const routes: Routes = [
    {
        path: '',
        component: LoginBoxComponent
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
];
