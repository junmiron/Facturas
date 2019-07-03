import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers : new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  constructor(private http: HttpClient) { }

  getFacturas() {
    return this.http.get('/server/api/v1/facturas');
  }

  getFactura(id: number) {
    return this.http.get('/server/api/v1/facturas/' + id);
  }

  addFactura(factura) {
    const body = JSON.stringify(factura);
    return this.http.post('/server/api/v1/facturas/agregar', body, httpOptions);
  }
}


