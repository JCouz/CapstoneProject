import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Restaurant } from '../model/restaurant';
import { RestaurantService } from '../service/restaurant.service';

@Component({
  selector: 'app-restaurant-details',
  standalone: false,
  templateUrl: './restaurant-details.component.html',
  styleUrl: './restaurant-details.component.css',
})
export class RestaurantDetailsComponent implements OnInit {
  restaurant: Restaurant = {
    id: 0,
    name: '',
    location: '',
    rating: 0,
    menu: [],
  } as Restaurant;
  restaurantId: number | undefined;

  constructor(
    private route: ActivatedRoute,
    private restaurantService: RestaurantService
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.restaurantId = params['id'];
    });

    this.restaurantService
      .getRestaurantById(Number(this.restaurantId))
      .subscribe((Response) => {
        this.restaurant = Response;
      });
  }
}
