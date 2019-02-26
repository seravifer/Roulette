import { Player } from "../player";
import { Color } from "../spin-number";

/**
 * Sistema de Paroli
 * 
 * Apuesta base
 * Si ganas duplicas
 * Si pierdes vuelves a la apuesta base
 * Máximo 3 tiras ganas consecutivas duplicando
 */
export class Paroli extends Player {

  initPay: number;
  streak: number;
  pay: number;

  constructor() {
    super(undefined, "Paroli");
    this.streak = 0;
    this.initPay = 10;
    this.pay = this.initPay;
  }

  play(money?: any, bet?: any) {
    super.play(this.pay, Color.Black);
  }

  charge(money: number) {
    super.charge(money);
    if (money == 0) {
      this.streak = 0;
      this.pay = this.initPay;
    } else {
      if (this.streak == 3) {
        this.streak = 0;
        this.pay = this.initPay;
      } else {
        this.streak++;
        this.pay *= 2;
      }
    }
  }

}
