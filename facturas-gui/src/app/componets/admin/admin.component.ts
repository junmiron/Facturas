import { Component, OnInit } from '@angular/core';

import { FacturaService } from '../../services/factura.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public facturas;

  constructor(private facturaService: FacturaService) { }

  ngOnInit() {
    this.getFacturas();
  }

  getFacturas() {
    this.facturaService.getFacturas().subscribe(
      data => { this.facturas = data; },
      err => { console.error(err); },
      () => console.log('Facturas cargadas')
    );
  }
}
