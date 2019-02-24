export class PlayerStats {

  win: number;
  lose: number;

  constructor() {
    this.win = 0;
    this.lose = 0;
  }

  stat(money) {
    if (money > 0) this.win++;
    else this.lose++;
  }
}