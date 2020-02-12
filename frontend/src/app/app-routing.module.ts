import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { AdminCrudComponent } from './components/admin-crud/admin-crud.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { AuthGuard } from './services/security/auth.guard';
import { DoctorDiagnoseComponent } from './components/doctor-diagnose/doctor-diagnose.component';

@NgModule({
})
export class AppRoutingModule { }
