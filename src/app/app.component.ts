import { Component, OnInit } from '@angular/core';
import { RouletteService } from './services/roulette.service';
import { Martingala, MartingalaInverse } from './models/strategies/martingala';
import { Fibonacci } from './models/strategies/fibonacci';
import { Alembert } from './models/strategies/alembert';
import { Player } from './models/player';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  players: Player[];

  intervalStatus = false;
  intervalValue = 100;
  interval: any;

  constructor(public roulette: RouletteService) { }

  ngOnInit() {
    this.initPlayers();
  }

  initPlayers() {
    this.players = [new Martingala(), new MartingalaInverse(), new Fibonacci(), new Alembert()];
  }

  wheel() {
    this.players.forEach(p => p.play());
    this.roulette.spin();
    this.roulette.payAll(this.players);
  }

  toggleInterval() {
    this.intervalStatus = !this.intervalStatus;
    if (this.intervalStatus) this.run();
    else this.stop();
  }

  run() {
    this.interval = setInterval(() => this.wheel(), this.intervalValue);
  }

  stop() {
    clearInterval(this.interval);
  }

  reset() {
    this.initPlayers();
    this.roulette.reset();
  }

}
