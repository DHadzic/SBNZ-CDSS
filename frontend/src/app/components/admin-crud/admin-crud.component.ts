import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Component({
  selector: 'app-admin-crud',
  templateUrl: './admin-crud.component.html',
  styleUrls: ['./admin-crud.component.scss']
})
export class AdminCrudComponent implements OnInit {
  public supstance;

  constructor(private adminService:AdminService) {
      this.supstance = {};
  }

  ngOnInit() {
  }

  addSupstance(){
    var _this = this;
    var observer = {
      next(value) {
        alert(value);
      },
      error(msg) {
        alert(msg.error);
      }
    }
    this.adminService.addSupstance(this.supstance.supstanceId)
        .pipe(catchError(err => {
          return throwError(err);
        })).subscribe(observer);
  }

  editSupstance(){
    var _this = this;
    var observer = {
      next(value) {
        alert(value);
      },
      error(msg) {
        alert(msg.error);
      }
    }
    var help_supstance = {
      oldId : this.supstance.supstanceId,
      newId : this.supstance.newId
    }

    this.adminService.addSupstance(help_supstance)
        .pipe(catchError(err => {
          return throwError(err);
        })).subscribe(observer);
  }

  deleteSupstance(){
    var _this = this;
    var observer = {
      next(value) {
        alert(value);
      },
      error(msg) {
        alert(msg.error);
      }
    }
    this.adminService.addSupstance(this.supstance.supstanceId)
        .pipe(catchError(err => {
          return throwError(err);
        })).subscribe(observer);
  }

}
