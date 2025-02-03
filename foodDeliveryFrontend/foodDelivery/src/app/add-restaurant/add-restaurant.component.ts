import { Component } from '@angular/core';
import { RestaurantService } from '../service/restaurant.service';
import { Restaurant } from '../model/restaurant';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-restaurant',
  standalone: false,
  templateUrl: './add-restaurant.component.html',
  styleUrl: './add-restaurant.component.css',
})
export class AddRestaurantComponent {
  restaurantData: Restaurant = { name: '', location: '', rating: 0 };

  constructor(
    public restaurantService: RestaurantService,
    private router: Router
  ) {}

  onSubmit() {
    this.restaurantService
      .createRestaurant(this.restaurantData)
      .subscribe((data) => {
        console.log('Data saved', data);
        this.restaurantData = { name: '', location: '', rating: 0 };
        this.router.navigate(['/']);
      });
  }
}
