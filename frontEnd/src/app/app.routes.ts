import { Routes } from '@angular/router';
import { LoginBoxComponent } from './login-box/login-box.component';
import { HomeGroupSelectorComponent } from './home-group-selector/home-group-selector.component';
import { AppComponent } from './app.component';

export const routes: Routes = [
    {
        path: 'index',
        component: AppComponent
    },
    {
        path: 'login',
        component: LoginBoxComponent
    },
    {
        path: 'home',
        component: HomeGroupSelectorComponent
    },
];
