import { Routes } from '@angular/router';
import { LoginBoxComponent } from './components/login/login-box.component';
import { IndexComponent } from './components/index/index.component';
import { HomeComponent } from './components/home/home.component';
import { AppComponent } from './components/app-component/app.component';
import { Component } from '@angular/core';
import { GroupsapceComponent } from './components/groupsapce/groupsapce.component';

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
    },
    {
        path: 'group',
        component: GroupsapceComponent
    },
];
