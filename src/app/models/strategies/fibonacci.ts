import { Player } from "../player";
import { Color } from "../spin-number";

/**
 * Fibonacci
 * If you win reduces 2 positions in the Fibonacci scale
 * If you lose you increase 1 on the Fibonacci scale
 */
export class Fibonacci extends Player {

  pos: number = 0;
  pay: number;

  constructor() {
    super(undefined, "Fibonacci");
  }

  play(money?: any, bet?: any) {
    this.pay = this.fibonacci(this.pos);
    super.play(this.pay, Color.Red);
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
