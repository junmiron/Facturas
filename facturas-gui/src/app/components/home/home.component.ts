import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { FacturaService } from '../../services/factura.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private facturaService: FacturaService) { }

  facturaForm: FormGroup;
  validMessage = '';

  ngOnInit() {

    this.facturaForm = new FormGroup({
      descripcionDelArticulo: new FormControl('', Validators.required),
      marcaDelArticulo: new FormControl('', Validators.required),
      cantidad: new FormControl('', Validators.required),
      precioDeCompra: new FormControl('', Validators.required),
      precioDeVenta: new FormControl('', Validators.required)
    });
  }
  submitFactura() {
    if (this.facturaForm.valid) {
      this.validMessage = 'Su factura esta cargada';
      this.facturaService.addFactura(this.facturaForm.value).subscribe(
        data => {
          this.facturaForm.reset();
          return true;
        },
      );
    } else {
      this.validMessage = 'Hubo un error, por favor intentelo nuevamente';
    }
  }

}
