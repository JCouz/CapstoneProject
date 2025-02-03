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

  getMenuItemsByRestaurant(restaurant_id: number): Observable<any> {
    const url = `${this.apiUrl}/restaurant/${restaurant_id}`;
    return this.http.get<MenuItem>(url);
  }

  createMenuItem(menuItem: MenuItem): Observable<MenuItem> {
    return this.http.post<MenuItem>(this.apiUrl, menuItem);
  }
}
