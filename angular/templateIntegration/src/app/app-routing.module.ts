import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductsComponent } from './products/products.component';
import{HttpClientModule} from '@angular/common/http'
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
const routes: Routes = [
  {path:'home', component:HomeComponent},
  {path:'about', component:AboutComponent},
  {path:'contact', component:ContactComponent},
  {path:'products', component:ProductsComponent},
  {path:'header', component:HeaderComponent},
  {path:'footer', component:FooterComponent},
  {path:'product-details/:products_id', component:ProductDetailsComponent}, // adding dynamic value to the url(product-details/id)
  {path:'login', component:LoginComponent},
  {path:'registration', component:RegistrationComponent},

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  HttpClientModule],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }
