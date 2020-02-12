import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { LoginGuard } from './services/security/login.guard';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './services/security/auth.guard';
import { AdminCrudComponent } from './components/admin-crud/admin-crud.component';
import { DoctorDiagnoseComponent } from './components/doctor-diagnose/doctor-diagnose.component';
import { FormsModule } from '@angular/forms';
import { JwtUtilsService } from './services/security/jwt-utils.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { TokenInterceptorService } from './services/security/token-interceptor.service';
import { AuthenticationServiceService } from './services/security/authentication-service.service';

const appRoutes: Routes = [
  { path: 'main', 
    component: MainPageComponent,
    data: { role : "ROLE_DOCTOR" },
    canActivate: [AuthGuard]
  },
  { path: 'login',
    component: LoginPageComponent, 
    canActivate: [LoginGuard] 
  },
  { path: '',
    redirectTo: 'main',
    pathMatch: 'full'
  },
  {
    path: 'admin',
    component: AdminCrudComponent,
    data: { role : "ROLE_ADMIN" },
    canActivate: [AuthGuard]
  },
  {
  path: 'diagnose',
  component: DoctorDiagnoseComponent,
  data: { role : "ROLE_DOCTOR" },
  canActivate: [AuthGuard] 
  }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    MainPageComponent,
    LoginPageComponent,
    AdminCrudComponent,
    DoctorDiagnoseComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
    ],
  providers: [AuthGuard,
    JwtUtilsService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
    AuthenticationServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
