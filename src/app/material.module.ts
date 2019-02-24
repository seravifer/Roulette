import { MatCardModule, MatButtonModule, MatSliderModule, MatIconModule } from '@angular/material';
import { NgModule } from '@angular/core';

@NgModule({
  imports: [MatCardModule, MatButtonModule, MatSliderModule, MatIconModule],
  exports: [MatCardModule, MatButtonModule, MatSliderModule, MatIconModule]
})
export class MaterialModule { }