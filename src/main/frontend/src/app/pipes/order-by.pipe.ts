import { Pipe, PipeTransform } from '@angular/core';
import * as _ from 'lodash'

@Pipe({
  name: 'orderBy'
})
export class OrderByPipe implements PipeTransform {
  transform(array: any, param: string): any {
    if(param.startsWith("-")){
      param = param.slice(1)
      return _.orderBy(array, [param], 'desc');
    }
    return _.orderBy(array, [param], 'asc');
  }
}

