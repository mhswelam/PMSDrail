import { Station } from './station';

export class Stations {
    private _stations: Station[];

    constructor(stations: Station[]) {
        this._stations = stations;
    }

    public get stations(): Station[] {
        return this._stations;
    }

    public set stations(value: Station[]) {
        if (value == null) { return; }
        this._stations = value;
    }
}

