import { OrderedPair } from './orderedpair';




export class ChartIn {
    public data: OrderedPair[];
    public chart: Map<String, String>;

    constructor(data: OrderedPair[], chart: Map<String, String>) {
        this.data = data;
        this.chart = chart;
    }
}
