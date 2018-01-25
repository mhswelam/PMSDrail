import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
<<<<<<< HEAD
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from './navbar/navbar.component';
=======
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
>>>>>>> 71ac772829013a83d4f0085aced35580a869794b


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
