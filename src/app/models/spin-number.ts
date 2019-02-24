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

export enum Row {
  First = "first",
  Second = "second",
  Third = "third"
}

export enum Place {
  // 1To18
  // 19To36
}

export class SpinNumber {

  number: number;
  color: Color;
  type: NumberType;
  colum: Colum;
  row: Row;

  constructor() {
    this.number = Math.floor(Math.random() * 36);
    this.color = this.getColor(this.number);
    this.type = this.getType(this.number);
    this.colum = this.getColum(this.number);
    this.row = this.getRow(this.number);
  }

  private getColor(number: number): Color {
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

  private getType(number: number): NumberType {
    if (number % 2 == 0) return NumberType.Even;
    else return NumberType.Odd;
  }

  private getColum(number: number): Colum {
    if (number >= 1 && number <= 12) return Colum.First;
    if (number >= 13 && number <= 24) return Colum.Second;
    if (number >= 25 && number <= 36) return Colum.Third;
    else return null;
  }

  private getRow(number: number): Row {
    if (number == 0) return null;
    if (number % 3 == 0) return Row.First;
    if ((number + 1) % 3 === 0) return Row.Second;
    else return Row.Third;
  }
}