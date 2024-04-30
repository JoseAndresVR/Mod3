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
	codigo serial not null primary key,
	nombre varchar(100) not null,
	categoria_padre int not null
);
create table categorias_unidad_medida(
	codigo char(1) not null primary key,
	nombre varchar(100) not null
);
create table unidades_medida(
	codigo char(1) not null primary key,
	descripcion varchar(100) not null,
	categoria_udm char(1) not null,
	constraint catud_fk foreign key(categoria_udm) 
	references categorias_unidad_medida(codigo)
);
create table productos(
	codigo serial not null primary key,
	codigo_udm char(1) not null,
	precio money not null,
	tiene_iva boolean not null,
	coste money not null,
	codigo_cat serial not null,
	stock int not null,
	foreign key(codigo_udm) references unidades_medida(codigo),
	foreign key(codigo_cat) references categorias(codigo)
);
create table tipo_documento(
	codigo char(1) not null primary key,
	descripcion varchar(100) not null
);
create table proveedores(
	identificador int not null primary key,
	tipo_doc char(1) not null,
	nombre varchar(100) not null,
	telefono int not null,
	correo varchar(100) not null,
	direccion varchar(100) not null,
	foreign key(tipo_doc) references tipo_documento(codigo)
);
create table estado_pedido(
	codigo char(1) not null primary key,
	descripcion varchar(100) not null
);
create table cabecera_pedido(
	numero serial not null primary key,
	proveedor int not null,
	fecha date not null,
	estado char(1) not null,
	foreign key(proveedor) references proveedores(identificador),
	foreign key(estado) references estado_pedido(codigo)
);
create table detalle_pedidos(
	codigo serial not null primary key,
	cabecera_pd serial not null,
	producto serial not null,
	cantidad int not null,
	subtotal money not null,
	cantidad_recibida int not null,
	foreign key(cabecera_pd) references cabecera_pedido(numero),
	foreign key(producto) references productos(codigo)
);
create table historial_stock(
	codigo serial not null primary key,
	fecha timestamp without time zone not null,
	referencia varchar(30) not null,
	producto serial not null,
	cantidad int not null,
	foreign key(producto) references productos(codigo)
);
create table cabecera_ventas(
	codigo serial not null primary key,
	fecha timestamp without time zone not null,
	total_sin_iva money not null,
	iva money not null,
	total money not null
);
create table detalle_venta(
	codigo serial not null primary key,
	cabecera_vt serial not null,
	producto serial not null,
	cantidad int not null,
	precio_venta money not null,
	subtotal money not null,
	subtotal_con_iva money not null,
	foreign key(producto) references productos(codigo),
	foreign key(cabecera_vt) references cabecera_ventas(codigo)
);
/*INSERTS*/

-- Inserts para la tabla categorias
INSERT INTO categorias (nombre, categoria_padre) VALUES 
    ('Electrónicos', 0),
    ('Ropa', 0),
    ('Computadoras', 1),
    ('Televisores', 1),
    ('Pantalones', 2),
    ('Camisetas', 2);

-- Inserts para la tabla categorias_unidad_medida
INSERT INTO categorias_unidad_medida (codigo, nombre) VALUES 
    ('P', 'Peso'),
    ('V', 'Volumen'),
    ('U', 'Unidad');

-- Inserts para la tabla unidades_medida
INSERT INTO unidades_medida (codigo, descripcion, categoria_udm) VALUES 
    ('P', 'Kilogramo', 'P'),
    ('V', 'Litro', 'V'),
    ('U', 'Unidad', 'U');

-- Inserts para la tabla productos
INSERT INTO productos (codigo_udm, precio, tiene_iva, coste, codigo_cat, stock) VALUES 
    ('P', 299.99, true, 150.00, 3, 100),
    ('U', 799.99, true, 500.00, 4, 50),
    ('P', 49.99, false, 25.00, 5, 200),
    ('U', 29.99, false, 15.00, 6, 150);

-- Inserts para la tabla tipo_documento
INSERT INTO tipo_documento (codigo, descripcion) VALUES 
    ('D', 'DNI'),
    ('C', 'Cédula de Identidad'),
    ('R', 'RIF');

-- Inserts para la tabla proveedores
INSERT INTO proveedores (identificador, tipo_doc, nombre, telefono, correo, direccion) VALUES 
    (1, 'D', 'Proveedor 1', 123456789, 'proveedor1@example.com', 'Dirección 1'),
    (2, 'C', 'Proveedor 2', 987654321, 'proveedor2@example.com', 'Dirección 2'),
    (3, 'R', 'Proveedor 3', 567891234, 'proveedor3@example.com', 'Dirección 3');

-- Inserts para la tabla estado_pedido
INSERT INTO estado_pedido (codigo, descripcion) VALUES 
    ('P', 'Pendiente'),
    ('E', 'Enviado'),
    ('R', 'Recibido');

-- Inserts para la tabla cabecera_pedido
INSERT INTO cabecera_pedido (proveedor, fecha, estado) VALUES 
    (1, '2024-04-29', 'P'),
    (2, '2024-04-30', 'E'),
    (3, '2024-05-01', 'R');

-- Inserts para la tabla detalle_pedidos
INSERT INTO detalle_pedidos (cabecera_pd, producto, cantidad, subtotal, cantidad_recibida) VALUES 
    (1, 1, 50, 14999.50, 50),
    (2, 2, 20, 15998.80, 20),
    (3, 3, 100, 4999.00, 100),
    (3, 4, 80, 2399.20, 80);

-- Inserts para la tabla historial_stock
INSERT INTO historial_stock (fecha, referencia, producto, cantidad) VALUES 
    ('2024-04-29 08:00:00', 'Compra inicial', 1, 100),
    ('2024-04-30 10:00:00', 'Venta', 1, -50),
    ('2024-04-30 12:00:00', 'Venta', 2, -20),
    ('2024-05-01 09:00:00', 'Venta', 3, -100),
    ('2024-05-01 09:00:00', 'Venta', 4, -80);

-- Inserts para la tabla cabecera_ventas
INSERT INTO cabecera_ventas (fecha, total_sin_iva, iva, total) VALUES 
    ('2024-04-29 15:30:00', 14999.50, 2850.90, 17850.40),
    ('2024-04-30 16:45:00', 15998.80, 3039.79, 19038.59),
    ('2024-05-01 17:00:00', 4999.00, 949.81, 5948.81);

-- Inserts para la tabla detalle_venta
INSERT INTO detalle_venta (cabecera_vt, producto, cantidad, precio_venta, subtotal, subtotal_con_iva) VALUES 
    (1, 1, 50, 299.99, 14999.50, 17850.40),
    (2, 2, 20, 799.99, 15998.80, 19038.59),
    (3, 3, 100, 49.99, 4999.00, 5948.81),
    (3, 4, 80, 29.99, 2399.20, 2876.01);



