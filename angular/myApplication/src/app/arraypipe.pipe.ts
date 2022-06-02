import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'arraypipe'
})
export class ArraypipePipe implements PipeTransform {
//value is array of objects
  transform(value:any, searchText:any): any{
    
    console.log(value, searchText);
    if(searchText==""){
      return value;
    }
    let filterAarray=value.filter((o:any)=>o['name'].startsWith(searchText));
    return filterAarray;
  }

}
