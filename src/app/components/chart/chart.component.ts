import { Component, OnInit, Input, OnChanges, DoCheck, AfterViewInit, ViewChild, ElementRef } from '@angular/core';
import { Player } from 'src/app/models/player';
import { Chart } from 'chart.js';

@Component({
  selector: 'chart-component',
  template: '<div><canvas #myChart></canvas></div>',
  styleUrls: ['./chart.component.scss']
})
export class ChartComponent implements OnInit, DoCheck  {

  @ViewChild('myChart') myChart: ElementRef;
  @Input() player: Player;

  private chart: any;
  private turn: number[];

  constructor() { }

  ngOnInit() {
    this.initChart();
  }

  ngDoCheck() {
    if (this.turn.length < this.player.moneyHistory.length) this.turn.push(1);
    if (this.turn.length > this.player.moneyHistory.length) this.initChart();
    this.chart.update();
  }

  private initChart() {
    this.turn = [1];
    this.chart = new Chart(this.myChart.nativeElement, {
      type: 'line',
      data: {
        labels: this.turn,
        datasets: [{
          data: this.player.moneyHistory,
          fill: false
        }]
      },
      options: {
        responsive: true, 
        maintainAspectRatio: false,
        legend: {
          display: false
        },
        scales: {
          xAxes: [{
            ticks: {
              display: false
            },
            gridLines: {
              display: false,
            },
          }]
        }
      }
    });
  }

}
