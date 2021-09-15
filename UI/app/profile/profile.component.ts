import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GlobalConstants } from '../common/global-constants';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  

  userObj : any;
  
  // Code For Side Bar
  mobileQuery: MediaQueryList;
  private _mobileQueryListener: () => void;

  // Constructor
  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher, private _service: RegistrationService, private _route: Router,private globalconstants : GlobalConstants) {
    this.userObj = globalconstants.getUser();
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }

  ngOnInit(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }

  

}
