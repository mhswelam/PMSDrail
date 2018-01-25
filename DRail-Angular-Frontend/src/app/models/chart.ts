import { OrderedPair } from './orderedpair';

export class Chart {
    public data: OrderedPair[];
    public totalPoints: number;

    constructor(data: OrderedPair[], totalPoints: number) {
        this.data = data;
        this.totalPoints = totalPoints;
    }
}
