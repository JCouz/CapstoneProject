import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-add-restaurant',
  standalone: false,
  templateUrl: './add-restaurant.component.html',
  styleUrl: './add-restaurant.component.css',
})
export class AddRestaurantComponent {
  restaurantData = { name: '', location: '', rating: 0 };

  constructor(private http: HttpClient) {}

  onSubmit() {
    this.http.post('/restaurants', this.restaurantData).subscribe(
      (response) => {
        console.log('Restaurant added:', response);
        this.restaurantData = { name: '', location: '', rating: 0 };
      },
      (error) => {
        console.error('Error adding restaurant:', error);
      }
    );
  }
}
