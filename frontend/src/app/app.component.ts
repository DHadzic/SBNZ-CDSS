import { Component } from '@angular/core';
import { AuthenticationServiceService } from './services/security/authentication-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'sbnz-cdss';
  private verifyBtn = false;
  
  constructor(private authService: AuthenticationServiceService,
    public router: Router){}

    ngOnInit() {
    }
    
    loggedIn():boolean{
      return this.authService.isLoggedIn();
    }

    login():void{
      this.router.navigate(['/login']);
    }

    logout(){
      this.authService.logout();
      this.router.navigate(['/login']);
    }

    navigateTo(url){
      this.router.navigate['/' + url];
    }

    isAdmin(){
      var roles = this.authService.getRoles();
      return roles == "ROLE_ADMIN";
    }

    
  }