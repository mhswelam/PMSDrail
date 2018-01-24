export class OrderedPair {
    private _x: number;
    private _y: number;

    constructor(x: number, y: number) {
        this._x = x;
        this._y = y;
    }

    get x(): number {
        return this._x;
    }
    set x(x: number) {
        if (x != null) {
            this._x = x;
        }
    }

    get y(): number {
        return this._y;
    }
    set y(y: number) {
        if (y != null) {
            this._y = y;
        }
    }
}
