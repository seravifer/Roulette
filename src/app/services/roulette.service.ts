import { Injectable } from '@angular/core';
import { SpinNumber, Color, NumberType, Colum, Dozen } from '../models/spin-number';
import { Player } from '../models/player';

@Injectable({
  providedIn: 'root'
})
export class RouletteService {

  history: SpinNumber[] = [];
  turn: number = 0;

  numbersStats: Map<number, number> = new Map();
  colorStats: Map<Color, number> = new Map();
  typeStats: Map<NumberType, number> = new Map();
  columStats: Map<Colum, number> = new Map();
  rowStats: Map<Dozen, number> = new Map();

  constructor() {
    this.initStats();
  }

  spin() {
    const result = new SpinNumber();
    this.history.push(result);
    this.turn++;
    this.saveStats();
    console.log(`Wheel: ${result.number} ${result.color}`);
  }

  getSpin() {
    return this.history[this.history.length - 1];
  }

  reset() {
    this.history = [];
    this.turn = 0;
    this.initStats();
  }

  pay(player: Player) {
    if (!player || player.betMoney == null) return;

    const bet = player.bet;
    let pay = player.betMoney;

    if (bet == this.getSpin().color) pay *= 2;
    else if (bet == this.getSpin().type)  pay *= 2;
    else if (bet == this.getSpin().colum)  pay *= 3;
    else if (bet == this.getSpin().dozen)  pay *= 3;
    else if (bet == this.getSpin().number)  pay *= 36;
    else pay *= 0;

    player.charge(pay);
  }

  payAll(players: Player[]) {
    players.forEach(p => this.pay(p));
  }

  private initStats() {
    for (let i = 0; i < 36; i++) this.numbersStats.set(i, 0);
    this.colorStats.set(Color.Red, 0);
    this.colorStats.set(Color.Black, 0);
    this.colorStats.set(Color.Green, 0);
    this.typeStats.set(NumberType.Even, 0);
    this.typeStats.set(NumberType.Odd, 0);
    this.columStats.set(Colum.First, 0);
    this.columStats.set(Colum.Second, 0);
    this.columStats.set(Colum.Third, 0);
    this.rowStats.set(Dozen.First, 0);
    this.rowStats.set(Dozen.Second, 0);
    this.rowStats.set(Dozen.Third, 0);
  }

  private saveStats() {
    this.numbersStats.set(this.getSpin().number, this.numbersStats.get(this.getSpin().number) + 1);
    this.colorStats.set(this.getSpin().color, this.colorStats.get(this.getSpin().color) + 1);
    this.typeStats.set(this.getSpin().type, this.typeStats.get(this.getSpin().type) + 1);
    this.columStats.set(this.getSpin().colum, this.columStats.get(this.getSpin().colum) + 1);
    this.rowStats.set(this.getSpin().dozen, this.rowStats.get(this.getSpin().dozen) + 1);
  }

}
