import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  username = '';
  password = '';

  adminUsername = 'admin';
  adminPassword = 'admin';

  constructor(private router: Router) {}

  onSubmit() {
    if (
      this.username === this.adminUsername &&
      this.password === this.adminPassword
    ) {
      localStorage.setItem('isAdminLoggedIn', 'true');
      this.router.navigate(['/admin']);
    } else {
      alert('Invalid username or password');
    }
  }
}
