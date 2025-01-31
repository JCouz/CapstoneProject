import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Error404Component } from './error404/error404.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { LoginComponent } from './login/login.component';
import { authGuard } from './service/auth.guard';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
import { AddMenuItemComponent } from './add-menu-item/add-menu-item.component';

const routes: Routes = [
  { path: '', redirectTo: 'restaurants', pathMatch: 'full' },
  { path: 'restaurants', component: RestaurantListComponent },
  { path: 'restaurants/:id', component: RestaurantDetailsComponent },
  { path: 'login', component: LoginComponent },
  {
    path: 'admin/add-restaurant',
    component: AddRestaurantComponent,
    canActivate: [authGuard],
  },
  {
    path: 'admin/add-menu-item',
    component: AddMenuItemComponent,
    canActivate: [authGuard],
  },
  { path: '**', component: Error404Component },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
