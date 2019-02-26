import { Player } from "../player";
import { Color, Spin } from "../spin-number";

/**
 * Fibonacci
 * 
 * If you win reduces 2 positions in the Fibonacci scale
 * If you lose you increase 1 on the Fibonacci scale
 */
export class Fibonacci extends Player {

  pos: number = 0;
  pay: number;
  bet: Spin;

  constructor(bet: Spin = Color.Black) {
    super(undefined, "Fibonacci");
    this.bet = bet;
  }

  play(money?: any, bet?: any) {
    this.pay = this.fibonacci(this.pos);
    super.play(this.pay, this.bet);
  }

  charge(money: number) {
    super.charge(money);
    if (money == 0) this.pos++;
    else if (this.pos > 1) this.pos -= 2;
  }

  private fibonacci(pos: number) {
    if ((pos == 0) || (pos == 1)) return 1;
    else return this.fibonacci(pos - 1) + this.fibonacci(pos - 2);
  }

}

export class FibonacciInverse extends Player {

  pos: number = 0;
  pay: number;
  bet: Spin;

  constructor(bet: Spin = Color.Black) {
    super(undefined, "Fibonacci Inverse");
    this.bet = bet;
  }

  play(money?: any, bet?: any) {
    this.pay = this.fibonacci(this.pos);
    super.play(this.pay, this.bet);
  }

  charge(money: number) {
    super.charge(money);
    if (money == 0) this.pos -= 2;
    else if (this.pos > 1) this.pos++;
  }

  private fibonacci(pos: number) {
    if ((pos == 0) || (pos == 1)) return 1;
    else return this.fibonacci(pos - 1) + this.fibonacci(pos - 2);
  }

}
