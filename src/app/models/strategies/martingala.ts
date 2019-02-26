import { Player } from "../player";
import { Color, Spin } from "../spin-number";

/**
  * Martingala
  * 
  * Si ganas vuelves a la puesta inicial
  * Si pierdes dublicas lo apostado
  */
export class Martingala extends Player  {

  initPay: number;
  pay: number;
  bet: Spin;

  constructor(bet: Spin = Color.Black, initPay: number = 1) {
    super(undefined, "Martingala");
    this.bet = bet;
    this.initPay = initPay;
    this.pay = initPay;
  }

  play(money?: any, bet?: any) {
    super.play(this.pay, this.bet);
  }

  charge(money: number) {
    super.charge(money);
    if (money == 0) this.pay *= 2;
    else this.pay = this.initPay;
  }

}

/**
  * Martingala Inversa
  * 
  * Si ganas duplicas la apuesta
  * Si pierdo vuelvo a la apuesta inicial
  */
export class MartingalaInverse extends Player{

  initPay: number;
  pay: number;
  bet: Spin;

  constructor(bet: Spin = Color.Black, initPay: number = 1) {
    super(undefined, "MartingalaInverse");
    this.initPay = initPay;
    this.pay = initPay;
    this.bet = bet;
  }

  play(money?: any, bet?: any) {
    super.play(this.pay, this.bet);
  }

  charge(money: number) {
    super.charge(money);
    if (money == 0 && this.pay > 1) this.pay /= 2;
    else if (money > 0) this.pay *= 2;
  }

}