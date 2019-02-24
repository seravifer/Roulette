import { Player } from "../player";
import { Color } from "../spin-number"

/**
  * Sistema D’Alembert
  * Si gano bajo la apuesta 1
  * Si pierdo subo la apuesta 1
  */
export class Alembert extends Player { 
  
  initPay: number;
  pay: number;

  constructor(initPay: number = 1) {
    super(undefined, "D’Alembert");
    this.initPay = initPay;
    this.pay = initPay;
  }

  play(money?: any, bet?: any) {
    super.play(this.pay, Color.Black);
  }

  charge(money: number) {
    super.charge(money);
    if (money == 0) this.pay++;
    else this.pay = this.pay--;
  }
}
