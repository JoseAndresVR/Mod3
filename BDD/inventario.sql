/*Drops*/
drop table if exists detalle_pedidos;
drop table if exists detalle_venta;
drop table if exists cabecera_pedido;
drop table if exists cabecera_ventas;
drop table if exists historial_stock;
drop table if exists proveedores;
drop table if exists productos;
drop table if exists unidades_medida;
drop table if exists categorias;
drop table if exists categorias_unidad_medida;
drop table if exists tipo_documento;
drop table if exists estado_pedido;


/*creaciones*/
create table categorias(
	codigoCa serial not null primary key,
	nombre_categoria varchar(100) not null,
	categoria_padre int not null
);
create table categorias_unidad_medida(
	codigoCu char(1) not null primary key,
	nombre varchar(100) not null
);
create table unidades_medida(
	nombre_unidad_medida char(1) not null primary key,
	descripcion varchar(100) not null,
	categoria_udm char(1) not null,
	constraint catud_fk foreign key(categoria_udm) 
	references categorias_unidad_medida(codigoCu)
);
create table productos(
	codigoP serial not null primary key,
	nombre_producto varchar(50) not null,
	codigo_udm char(1) not null,
	precio money not null,
	tiene_iva boolean not null,
	coste money not null,
	codigo_cat serial not null,
	stock int not null,
	foreign key(codigo_udm) references unidades_medida(nombre_unidad_medida),
	foreign key(codigo_cat) references categorias(codigoCa)
);
create table tipo_documento(
	codigoTp char(1) not null primary key,
	descripcion varchar(100) not null
);
create table proveedores(
	identificador int not null primary key,
	tipo_doc char(1) not null,
	nombre varchar(100) not null,
	telefono int not null,
	correo varchar(100) not null,
	direccion varchar(100) not null,
	foreign key(tipo_doc) references tipo_documento(codigoTp)
);
create table estado_pedido(
	codigoEp char(1) not null primary key,
	descripcion varchar(100) not null
);
create table cabecera_pedido(
	numeroCp int not null primary key,
	proveedor int not null,
	fecha date not null,
	estado char(1) not null,
	foreign key(proveedor) references proveedores(identificador),
	foreign key(estado) references estado_pedido(codigoEp)
);
create table detalle_pedidos(
	codigoDp serial not null primary key,
	cabecera_pd serial not null,
	producto serial not null,
	cantidad int not null,
	subtotal money not null,
	cantidad_recibida int not null,
	foreign key(cabecera_pd) references cabecera_pedido(numeroCp),
	foreign key(producto) references productos(codigoP)
);
create table historial_stock(
	codigoHs serial not null primary key,
	fecha timestamp without time zone not null,
	referencia varchar(30) not null,
	producto serial not null,
	cantidad int not null,
	foreign key(producto) references productos(codigoP)
);
create table cabecera_ventas(
	codigoCv serial not null primary key,
	fecha timestamp without time zone not null,
	total_sin_iva money not null,
	iva money not null,
	total money not null
);
create table detalle_venta(
	codigoDv serial not null primary key,
	cabecera_vt serial not null,
	producto serial not null,
	cantidad int not null,
	precio_venta money not null,
	subtotal money not null,
	subtotal_con_iva money not null,
	foreign key(producto) references productos(codigoP),
	foreign key(cabecera_vt) references cabecera_ventas(codigoCv)
);
/*INSERTS*/

-- Insertar en tipo_documento
INSERT INTO tipo_documento (codigoTp, descripcion) VALUES
('C', 'Cédula de Identidad'),
('R', 'RUC'),
('P', 'Pasaporte');

-- Insertar en categorias_unidad_medida
INSERT INTO categorias_unidad_medida (codigoCu, nombre) VALUES
('U', 'Unidad'),
('D', 'Docena'),
('K', 'Kilogramo'),
('L', 'Litro');

-- Insertar en categorias
INSERT INTO categorias (codigoCa, nombre_categoria, categoria_padre) VALUES
(1, 'Electrodomésticos', 0),
(2, 'Electrónicos', 0),
(3, 'Alimentos', 0),
(4, 'Bebidas', 0);

-- Insertar en unidades_medida
INSERT INTO unidades_medida (nombre_unidad_medida, descripcion, categoria_udm) VALUES
('U', 'Unidad', 'U'),
('D', 'Docena', 'D'),
('K', 'Kilogramo', 'K'),
('L', 'Litro', 'L');

-- Insertar en productos
INSERT INTO productos (codigoP, nombre_producto, codigo_udm, precio, tiene_iva, coste, codigo_cat, stock) VALUES
(1001, 'Licuadora', 'U', 0.80, true, 0.60, 1, 15),
(1002, 'Televisor LED 50 pulgadas', 'U', 0.60, true, 0.40, 2, 10),
(1003, 'Arroz', 'K', 0.20, true, 0.18, 3, 200),
(1004, 'Agua mineral', 'L', 0.10, true, 0.50, 4, 300);

-- Insertar en proveedores
INSERT INTO proveedores (identificador, tipo_doc, nombre, telefono, correo, direccion) VALUES
(1, 'R', 'Electrohogar SA', 987654321, 'ventas@electrohogar.com', 'Av. Principal 123'),
(2, 'C', 'Supermercado El Buen Sabor', 123456789, 'info@elbuensabor.com', 'Calle Secundaria 456');

-- Insertar en estado_pedido
INSERT INTO estado_pedido (codigoEp, descripcion) VALUES
('P', 'Pendiente'),
('E', 'Entregado');

-- Insertar en cabecera_pedido
INSERT INTO cabecera_pedido (numeroCp, proveedor, fecha, estado) VALUES
(10001, 1, '2024-05-06', 'P'),
(10002, 2, '2024-05-07', 'P');

-- Insertar en detalle_pedidos
INSERT INTO detalle_pedidos (codigoDp, cabecera_pd, producto, cantidad, subtotal, cantidad_recibida) VALUES
(5001, 10001, 1001, 2, 160, 0),
(5002, 10001, 1002, 1, 600, 0),
(5003, 10002, 1003, 50, 125, 0),
(5004, 10002, 1004, 100, 100, 0);

-- Insertar en historial_stock
INSERT INTO historial_stock (codigoHs, fecha, referencia, producto, cantidad) VALUES
(20001, '2024-05-06 08:00:00', 'Compra proveedor 1', 1001, 2),
(20002, '2024-05-06 08:00:00', 'Compra proveedor 1', 1002, 1),
(20003, '2024-05-07 10:00:00', 'Compra proveedor 2', 1003, 50),
(20004, '2024-05-07 10:00:00', 'Compra proveedor 2', 1004, 100);

-- Insertar en cabecera_ventas
INSERT INTO cabecera_ventas (codigoCv, fecha, total_sin_iva, iva, total) VALUES
(30001, '2024-05-08 14:00:00', 2200, 352, 2552),
(30002, '2024-05-09 15:00:00', 250, 40, 290);

-- Insertar en detalle_venta
INSERT INTO detalle_venta (codigoDv, cabecera_vt, producto, cantidad, precio_venta, subtotal, subtotal_con_iva) VALUES
(7001, 30001, 1001, 2, 800, 1600, 1856),
(7002, 30001, 1002, 1, 600, 600, 696),
(7003, 30002, 1003, 5, 2.5, 12.5, 14.5),
(7004, 30002, 1004, 10, 1, 10, 11.6);
