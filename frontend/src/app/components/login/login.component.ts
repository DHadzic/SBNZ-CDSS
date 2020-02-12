import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from 'src/app/services/security/authentication-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public user;

  @Output()
  changeDisplay:EventEmitter<any> = new EventEmitter();
  
  public wrongUsernameOrPass:boolean;

  constructor(private authenticationService:AuthenticationServiceService,
              private router: Router) {
    this.user = {};
    this.wrongUsernameOrPass = false;
   }

  ngOnInit() {
  }

  login():void{
    this.authenticationService.login(this.user.name, this.user.password,this);
  }

  handleLogin(loggedIn){
    if(loggedIn){
      console.log("SUCCESSFUL COMPONENT");
      this.router.navigate(['/main']);          
    }else{
      this.wrongUsernameOrPass = true;
      console.log("ERROR COMPONENT");
    }
  }

  public openRegistration(){
    this.changeDisplay.emit();
  }
}
