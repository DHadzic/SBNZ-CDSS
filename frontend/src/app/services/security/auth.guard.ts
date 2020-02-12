import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationServiceService } from './authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authenticationService: AuthenticationServiceService, private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    if (this.authenticationService.isLoggedIn()) {
      var allowed_roles = next.data["role"] as string;
      var my_roles = this.authenticationService.getRoles();
    
      console.log(allowed_roles);
      console.log(my_roles);
      
      if(allowed_roles == my_roles){
        return true;
      }else if( my_roles == "ROLE_ADMIN"){
        this.router.navigate(['/admin']);
        return false;
      }else{
        this.router.navigate(['/diagnose']);
        return false;
      }

    }
    else {
      this.router.navigate(['/login']);
      return false;
    }
  }}
