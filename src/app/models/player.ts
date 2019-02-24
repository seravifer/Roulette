import { Color, NumberType, Colum, Row } from "./spin-number";
import { PlayerStats } from "./player-stats";

export class Player extends PlayerStats {

  name: string;
  money: number;
  moneyHistory: number[] = [];

  betMoney: number;
  bet: number | Color | NumberType | Colum | Row;

  constructor(money: number = 1000, name?: string) {
    super();
    this.money = money;
    this.name = name;
    this.moneyHistory.push(this.money);
  }

  play(money?: number, bet?: number | Color | NumberType | Colum | Row) {
    if (this.money <= 0 || this.money - this.betMoney < 0) {
      this.betMoney = null;
      return;
    }
    console.log(`Player ${name}: ${money} to ${bet}`);
    this.money -= money;
    this.bet = bet;
    this.betMoney = money;
  }

  charge(money: number) {
    this.money += money;
    this.moneyHistory.push(this.money);
    this.stat(money);
  }

}