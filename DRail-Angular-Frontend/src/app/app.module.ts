import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';
import { AppRoutingModule } from './app-routing.module';
import { ProfileComponent } from './components/profile/profile.component';
import { MainViewComponent } from './components/main-view/main-view.component';
import { LoginService } from './services/login.service';
import { HttpModule } from '@angular/http';
import { UserService } from './services/user.service';
import { HttpClientModule } from '@angular/common/http';
import { LogoutService } from './services/logout.service';
import { StationComponent } from './components/station/station.component';
import { RailComponent } from './components/rail/rail.component';
import { TileDetailsComponent } from './components/tile-details/tile-details.component';
import { StationService } from './services/station.service';
import { RailService } from './services/rail.service';
import { GetStationsService } from './services/get-stations.service';
import { StationViewComponent } from './components/station-view/station-view.component';
import { StationsComponent } from './components/stations/stations.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    NavbarComponent,
    ProfileComponent,
    MainViewComponent,
    StationComponent,
    RailComponent,
    TileDetailsComponent,
    StationViewComponent,
    StationsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule
  ],
  providers: [LoginService, UserService, LogoutService, StationService, RailService, GetStationsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
