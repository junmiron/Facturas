CREATE DATABASE supermercado;
 
USE supermercado;
 
/*Table structure for table DetallesDeFactura */
 
DROP TABLE IF EXISTS DetallesDeFactura;
 
CREATE TABLE 
	DetallesDeFactura 
	(
		id BIGINT NOT NULL AUTO_INCREMENT,
		descripcion_del_articulo VARCHAR(30),
		marca_del_articulo VARCHAR(30),
		cantidad BIGINT,
		precio_de_compra NUMERIC,
		precio_de_venta NUMERIC,
		PRIMARY KEY  (id)
	); 
 
/*Data for the table DetallesDeFactura */

INSERT INTO DetallesDeFactura (id, descripcion_del_articulo, marca_del_articulo, cantidad, precio_de_compra, precio_de_venta)
  VALUES (1, "pan", "Fargo", 2, 10, 45);
INSERT INTO DetallesDeFactura (id, descripcion_del_articulo, marca_del_articulo, cantidad, precio_de_compra, precio_de_venta)
  VALUES (2, "leche", "Sancor", 3, 15, 55);  
  