import { Component, OnInit } from '@angular/core';
import { MenuItemService } from '../service/menu-item.service';
import { MenuItem } from '../model/menuItem';
import { RestaurantService } from '../service/restaurant.service';
import { Restaurant } from '../model/restaurant';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-menu-item',
  standalone: false,

  templateUrl: './add-menu-item.component.html',
  styleUrl: './add-menu-item.component.css',
})
export class AddMenuItemComponent implements OnInit {
  MenuItemData: MenuItem = { name: '', price: 0, restaurant: 0 };
  restaurants: Restaurant[] = [];
  selectedRestaurant: number = 0;

  constructor(
    public menuItemService: MenuItemService,
    public restaurantService: RestaurantService,
    private router: Router
  ) {}

  ngOnInit() {
    this.restaurantService.getRestaurants().subscribe(
      (data: any) => {
        this.restaurants = data;
      },
      (error) => {
        console.error('Error fetching restaurants:', error);
      }
    );
  }

  onSubmit() {
    this.MenuItemData.restaurant = { id: this.selectedRestaurant };

    console.log('Data =', this.MenuItemData);
    this.menuItemService.createMenuItem(this.MenuItemData).subscribe((data) => {
      console.log('Data saved', data);
      this.MenuItemData = { name: '', price: 0, restaurant: 0 };
      this.router.navigate(['restaurants/' + this.selectedRestaurant]);
    });
  }
}
