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
import { DragulaModule } from 'ng2-dragula';
import { TileService } from './services/tile.service';
import { BootstrapModalModule } from 'ng2-bootstrap-modal';
import { TilepopComponent } from './components/tilepop/tilepop.component';
import { TaskService } from './services/task.service';
import { GetStationsService } from './services/get-stations.service';
import { StationViewComponent } from './components/station-view/station-view.component';
import { StationsComponent } from './components/stations/stations.component';
import { AddStationComponent } from './components/add-station/add-station.component';
import { UtilsService } from './services/utils.service';
import { CreateStationPopComponent } from './components/create-station-pop/create-station-pop.component';
import { CreateStationService } from './services/create-station.service';
import { AddRailComponent } from './components/add-rail/add-rail.component';
import { UpdateRailComponent } from './components/update-rail/update-rail.component';
import { EditStationPopComponent } from './components/edit-station-pop/edit-station-pop.component';
import { ChartComponent } from './components/chart/chart.component';
import { ChartService } from './services/chart.service';
import { ChartsModule } from 'ng2-charts';
import { AddtilepopComponent } from './components/addtilepop/addtilepop.component';
import { AddUserPopComponent } from './components/add-user-pop/add-user-pop.component';
import { InfoPasswordComponent } from './components/profile/info-password/info-password.component';

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
    TilepopComponent,
    StationViewComponent,
    StationsComponent,
    AddStationComponent,
    CreateStationPopComponent,
    AddStationComponent,
    AddRailComponent,
    UpdateRailComponent,
    EditStationPopComponent,
    AddtilepopComponent,
    AddUserPopComponent,
    ChartComponent,
    AddtilepopComponent,
    InfoPasswordComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    DragulaModule,
    ChartsModule,
    BootstrapModalModule.forRoot({container: document.body})
  ],

  providers: [ LoginService, UserService, ProfileService, LogoutService, StationService, RailService, RegisterService, GetStationsService,
    TileService, TaskService, CreateStationService, UtilsService, ChartService],
  entryComponents: [TilepopComponent, CreateStationPopComponent, AddRailComponent, UpdateRailComponent, EditStationPopComponent, 
    AddtilepopComponent, AddUserPopComponent, ChartComponent],


  bootstrap: [AppComponent]
})
export class AppModule { }
