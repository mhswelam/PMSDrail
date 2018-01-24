import { OrderedPair } from './orderedpair';

export class Chart {
    private _data: OrderedPair[];
    private _totalPoints: number;

    constructor(data: OrderedPair[], totalPoints: number) {
        this._data = data;
        this._totalPoints = totalPoints;
    }

    get data(): OrderedPair[] {
        return this._data;
    }
    set data(data: OrderedPair[]) {
        if (data != null) {
            this._data = data;
        }
    }

    get totalPoints(): number {
        return this._totalPoints;
    }
    set totalPoints(totalPoints: number) {
        if (totalPoints != null) {
            this._totalPoints = totalPoints;
        }
    }
}
