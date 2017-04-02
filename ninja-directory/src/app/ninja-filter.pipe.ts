import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ninjaFilter'
})
export class NinjaFilterPipe implements PipeTransform {

  transform(ninjaList: any, text: any): any {
    //check if search term is undefined
    if (text === undefined) return ninjaList;
    //return updated ninjaList
    return ninjaList.filter(function(ninja) {
      return ninja.name.toLowerCase().includes(text.toLowerCase());
    })
  }

}
