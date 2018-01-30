import { OrderedPair } from './orderedpair';




export class ChartIn {
    public data: number[];
    public labels: number[];
    public points: number;

    constructor(data: number[], labels: number[]) {
        this.data = data;
        this.labels = labels;
    }
}
