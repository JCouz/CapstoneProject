import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MenuItem } from '../model/menuItem';

@Injectable({
  providedIn: 'root',
})
export class MenuItemService {
  private apiUrl = 'http://localhost:8080/menu-items';

  constructor(private http: HttpClient) {}

  getMenuItemsByRestaurant(restaurantId: number): Observable<any> {
    const url = `${this.apiUrl}/restaurant/${restaurantId}`;
    return this.http.get<MenuItem>(url);
  }
}
