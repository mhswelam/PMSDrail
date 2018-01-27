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
import { InfoDisplayComponent } from './components/profile/info-display/info-display.component';
import { InfoEditComponent } from './components/profile/info-edit/info-edit.component';
import { UserService } from './services/user.service';
import { ProfileService } from './services/profile.service';
import { StationComponent } from './components/station/station.component';
import { RailComponent } from './components/rail/rail.component';
import { TileDetailsComponent } from './components/tile-details/tile-details.component';
import { HttpClientModule } from '@angular/common/http';
import { LogoutService } from './services/logout.service';
import { StationService } from './services/station.service';
import { RailService } from './services/rail.service';
import { RegisterService } from './services/register.service';
import { AddStationComponent } from './components/add-station/add-station.component';
import { DragulaModule } from 'ng2-dragula';
import { UtilsService } from './services/utils.service';


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    NavbarComponent,
    ProfileComponent,
    MainViewComponent,
    InfoDisplayComponent,
    InfoEditComponent,
    StationComponent,
    RailComponent,
    TileDetailsComponent,
    AddStationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    DragulaModule
  ],
  providers: [
    LoginService,
    UserService,
    ProfileService,
    LogoutService,
    StationService,
    RailService,
    UtilsService,
    RegisterService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
