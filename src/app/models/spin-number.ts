export type Number = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20 | 21 | 22 | 23 | 24 | 25 | 26 | 27 | 28 | 29 | 30 | 31 | 32 | 33 | 34 | 35 | 36;
export type Split = [number, number];
export type Street = [number, number, number]
export type Corner = [number, number, number, number];
export type Line = [Street, Street];

export enum Color {
  Green = "green",
  Red = "red",
  Black = "black"
}

export enum NumberType {
  Even = "even",
  Odd = "odd"
}

export enum Colum {
  First = "first",
  Second = "second",
  Third = "third"
}

export enum Dozen {
  First = "first",
  Second = "second",
  Third = "third"
}

export enum Position {
  Low = "low",
  High = "high"
}

export type Spin = Number | Color | NumberType | Colum | Dozen | Position | Split | Street | Corner | Line;

export class SpinNumber {

  number: Number;
  color: Color;
  type: NumberType;
  colum: Colum;
  dozen: Dozen;

  constructor() {
    this.number = <Number>Math.floor(Math.random() * 36);
    this.color = this.getColor(this.number);
    this.type = this.getType(this.number);
    this.colum = this.getColum(this.number);
    this.dozen = this.getDozen(this.number);
  }

  private getColor(number: Number): Color {
    const color = [
      Color.Green,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red,
      Color.Black,
      Color.Red
    ];
    return color[number];
  }

  private getType(number: Number): NumberType {
    if (number % 2 == 0) return NumberType.Even;
    else return NumberType.Odd;
  }

  private getColum(number: Number): Colum {
    if (number >= 1 && number <= 12) return Colum.First;
    if (number >= 13 && number <= 24) return Colum.Second;
    if (number >= 25 && number <= 36) return Colum.Third;
    else return null;
  }

  private getDozen(number: Number): Dozen {
    if (number == 0) return null;
    if (number % 3 == 0) return Dozen.First;
    if ((number + 1) % 3 === 0) return Dozen.Second;
    else return Dozen.Third;
  }
}