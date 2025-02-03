import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MenuItemService } from '../service/menu-item.service';
import { MenuItem } from '../model/menuItem';

@Component({
  selector: 'app-menu-item-list',
  standalone: false,
  templateUrl: './menu-item-list.component.html',
  styleUrls: ['./menu-item-list.component.css'],
})
export class MenuItemListComponent implements OnInit {
  menuItems: MenuItem[] = [];

  constructor(
    private route: ActivatedRoute,
    private menuItemService: MenuItemService
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      const restaurant_id = params['id'];

      this.menuItemService
        .getMenuItemsByRestaurant(restaurant_id)
        .subscribe((response) => {
          console.log(response);
          this.menuItems = response;
        });
    });
  }
}
