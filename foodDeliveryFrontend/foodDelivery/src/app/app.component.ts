import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'foodDelivery';
  isAdminLoggedIn = localStorage.getItem('isAdminLoggedIn') === 'true';

  constructor(private router: Router) {
    this.router.events.subscribe(() => {
      this.isAdminLoggedIn = localStorage.getItem('isAdminLoggedIn') === 'true';
    });
  }

  logout() {
    localStorage.removeItem('isAdminLoggedIn');
    this.isAdminLoggedIn = false;
    this.router.navigate(['/']);
  }
}
