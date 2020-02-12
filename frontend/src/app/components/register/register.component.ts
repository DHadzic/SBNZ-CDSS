import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { AuthenticationServiceService } from 'src/app/services/security/authentication-service.service';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  public myBool : boolean;
  public user;
  public user_types;

  @Output()
  changeDisplay:EventEmitter<any> = new EventEmitter();

  constructor(private userService:AuthenticationServiceService,private router: Router) { 
    this.user = {};
    this.user_types = ["Admin","Doctor"];
    this.user.type = this.user_types[0];
  }

  
  ngOnInit() {
  }

  openLogin(){
    this.changeDisplay.emit();
  }

  register(){

    if(this.user.username == undefined)
      return;
    if(this.user.password == undefined)
      return;

    this.user.role = "ROLE_" + this.user.type.toUpperCase();
    console.log(this.user);

    var _this = this;

    var observer = {
      next(value) {
        _this.user.type = _this.user_types[0];
        _this.router.navigate(['/main']);
      },
      error(msg) {
        console.log(msg.error);
        _this.user.type = _this.user_types[0];
        alert("msg.error");
      }
    }

    this.userService.register(this.user)
        .pipe(catchError(err => {
          return throwError(err);
        })).subscribe(observer);
  }
}
