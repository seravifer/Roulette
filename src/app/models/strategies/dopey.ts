import { Player } from "../player";
import { Number } from "../spin-number";

/**
 * Dopey
 * 
 * Apostar 37 tiradas al mismo número
 */
export class Dopey extends Player { 
  
  number: Number;
  streak: number;

  constructor(number: Number) {
    super(undefined, "Dopey");
    this.number = number;
    this.streak = 0;
  }

  play(money?: any, bet?: any) {
    super.play(10, this.number);
  }

  charge(money: number) {
    super.charge(money);
    this.streak++;
  }
}
