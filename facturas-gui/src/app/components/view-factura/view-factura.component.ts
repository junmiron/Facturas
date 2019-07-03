import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { FacturaService } from '../../services/factura.service';

@Component({
  selector: 'app-view-factura',
  templateUrl: './view-factura.component.html',
  styleUrls: ['./view-factura.component.css']
})
export class ViewFacturaComponent implements OnInit {

  public facturaView;

  constructor(private facturaService: FacturaService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getFacturaView(this.route.snapshot.params.id);
  }

  getFacturaView(id: number) {
    this.facturaService.getFactura(id).subscribe(
      data => {
        this.facturaView = data;
      }
    );
  }

}
