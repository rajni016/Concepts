import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  productArray=[
    {name:'product1.jpg', "product_name":"Vegetable"},
    {name:'product2.jpg',"product_name":"Wheat"},
    {name:'product3.jpg',"product_name":"Fruits"},
    {name:'product4.jpg',"product_name":"Flowers"},
    {name:'product5.jpg',"product_name":"Sheep"},
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
