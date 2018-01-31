import { Injectable } from '@angular/core';

@Injectable()
export class UtilsService {

  constructor() { }

  map(lst, fun) {
    let result = [];
    for (let elem of lst) {
      result.push(fun(elem));
    }
    return result;
  }

}
