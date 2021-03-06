import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent} from './components/profile/profile.component';
import { MainViewComponent } from './components/main-view/main-view.component';
import { StationComponent } from './components/station/station.component';
import { StationsComponent } from './components/stations/stations.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'main', component: MainViewComponent },
  { path: 'station', component: StationComponent},
  { path: 'stations', component: StationsComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})

export class AppRoutingModule { }
