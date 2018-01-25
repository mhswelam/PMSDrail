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


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    NavbarComponent,
    ProfileComponent,
    MainViewComponent,
    InfoDisplayComponent,
    InfoEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpModule
  ],
  providers: [LoginService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
