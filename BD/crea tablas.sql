-- Crear tabla habitacion
CREATE TABLE habitacion (
    idhabitacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200),
    precio DECIMAL(10,2),
    estado BIT,
    usrcreacion VARCHAR(100),
    fechcreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usredicion VARCHAR(100),
    fechedicion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Crear tabla serviciosHabitacion
CREATE TABLE servicioshabitacion (
    idservhabitacion INT AUTO_INCREMENT PRIMARY KEY,
    idhabitacion INT,
    nombreservicio VARCHAR(200),
    urlimagen VARCHAR(255),
    estado BIT,
    usrcreacion VARCHAR(100),
    fechcreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usredicion VARCHAR(100),
    fechedicion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (idhabitacion) REFERENCES habitacion(idhabitacion)
);

-- Crear tabla imagenesHabitacion
CREATE TABLE imageneshabitacion (
    idimghabitacion INT AUTO_INCREMENT PRIMARY KEY,
    idhabitacion INT,
    urlimagen VARCHAR(255),
    estado BIT,
    usrcreacion VARCHAR(100),
    fechcreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usredicion VARCHAR(100),
    fechedicion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (idhabitacion) REFERENCES habitacion(idhabitacion)
);


CREATE TABLE clientes (
    idcliente INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(100),
    apellidos VARCHAR(100),
    nrodocumento VARCHAR(20),
    email VARCHAR(100),
    telefono VARCHAR(20),
    ciudad VARCHAR(100),
    direccion VARCHAR(255),
    urlfoto VARCHAR(255),
    estado BIT,
    usrcreacion VARCHAR(100),
    fechcreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usredicion VARCHAR(100),
    fechedicion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE reserva (
    idreserva INT AUTO_INCREMENT PRIMARY KEY,
    idcliente INT,
    idhabitacion INT,
    fechaingreso DATE,
    fechasalida DATE,
    totaldias INT,
    subtotal DECIMAL(10,2),
    igv DECIMAL(10,2),
    total DECIMAL(10,2),
    estado BIT,
    usrcreacion VARCHAR(100),
    fechcreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usredicion VARCHAR(100),
    fechedicion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (idcliente) REFERENCES clientes(idcliente),
    FOREIGN KEY (idhabitacion) REFERENCES habitacion(idhabitacion)
);

CREATE TABLE usuarios (
    idusuario INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(10),
	idcliente INT,
    estado BIT,
    usrcreacion VARCHAR(100),
    fechcreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usredicion VARCHAR(100),
    fechedicion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (idcliente) REFERENCES clientes(idcliente)
);


-- Insertar cliente 1
INSERT INTO clientes (nombres, apellidos, nroDocumento, email, telefono, ciudad, direccion, urlFoto, estado, usrCreacion, usrEdicion) 
VALUES ('Juan', 'Perez', '12345678', 'juan@example.com', '123456789', 'Lima', 'Av. Principal 123', 'https://w7.pngwing.com/pngs/857/213/png-transparent-man-avatar-user-business-avatar-icon.png', '1', 'admin', 'admin');

-- Insertar cliente 2
INSERT INTO clientes (nombres, apellidos, nroDocumento, email, telefono, ciudad, direccion, urlFoto, estado, usrCreacion, usrEdicion) 
VALUES ('Maria', 'Gomez', '87654321', 'maria@example.com', '987654321', 'Lima', 'Av. Central 456', 'https://w7.pngwing.com/pngs/857/213/png-transparent-man-avatar-user-business-avatar-icon.png', '1', 'admin', 'admin');

-- Insertar cliente 3
INSERT INTO clientes (nombres, apellidos, nroDocumento, email, telefono, ciudad, direccion, urlFoto, estado, usrCreacion, usrEdicion) 
VALUES ('Pedro', 'Martinez', '56789012', 'pedro@example.com', '456789012', 'Arequipa', 'Jr. Independencia 789', 'https://w7.pngwing.com/pngs/857/213/png-transparent-man-avatar-user-business-avatar-icon.png', '1', 'admin', 'admin');

-- Insertar cliente 4
INSERT INTO clientes (nombres, apellidos, nroDocumento, email, telefono, ciudad, direccion, urlFoto, estado, usrCreacion, usrEdicion) 
VALUES ('Ana', 'Lopez', '09876543', 'ana@example.com', '345678901', 'Cusco', 'Calle Principal 321', 'https://w7.pngwing.com/pngs/857/213/png-transparent-man-avatar-user-business-avatar-icon.png', '1', 'admin', 'admin');

-- Insertar cliente 5
INSERT INTO clientes (nombres, apellidos, nroDocumento, email, telefono, ciudad, direccion, urlFoto, estado, usrCreacion, usrEdicion) 
VALUES ('Carlos', 'Santos', '34567890', 'carlos@example.com', '234567890', 'Trujillo', 'Av. Libertad 987', 'https://w7.pngwing.com/pngs/857/213/png-transparent-man-avatar-user-business-avatar-icon.png', '1', 'admin', 'admin');

-- Insertar cliente 6
INSERT INTO clientes (nombres, apellidos, nroDocumento, email, telefono, ciudad, direccion, urlFoto, estado, usrCreacion, usrEdicion) 
VALUES ('Laura', 'Fernandez', '23456789', 'laura@example.com', '123456789', 'Piura', 'Jr. Comercio 654', 'https://w7.pngwing.com/pngs/857/213/png-transparent-man-avatar-user-business-avatar-icon.png', '1', 'admin', 'admin');



INSERT INTO habitacion (nombre, precio, estado, usrCreacion, usrEdicion) VALUES ('Habitación Estándar', 100.00, '1', 'admin', 'admin');
INSERT INTO habitacion (nombre, precio, estado, usrCreacion, usrEdicion) VALUES ('Suite Ejecutiva', 200.00, '1', 'admin', 'admin');
INSERT INTO habitacion (nombre, precio, estado, usrCreacion, usrEdicion) VALUES ('Habitación Superior', 150.00, '1', 'admin', 'admin');
INSERT INTO habitacion (nombre, precio, estado, usrCreacion, usrEdicion) VALUES ('Suite de Lujo', 300.00, '1', 'admin', 'admin');
INSERT INTO habitacion (nombre, precio, estado, usrCreacion, usrEdicion) VALUES ('Habitación Familiar', 180.00, '1', 'admin', 'admin');
INSERT INTO habitacion (nombre, precio, estado, usrCreacion, usrEdicion) VALUES ('Habitación Doble', 120.00, '1', 'admin', 'admin');


INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'https://www.hotelsantamariacusco.com/wp-content/uploads/2022/01/habitacion-simple-hotel-Santa-Maria-Cusco-peru01.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'https://www.hotelsantamariacusco.com/wp-content/uploads/2022/01/habitacion-doble-hotel-Santa-Maria-Cusco-peru01.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'https://www.hotelsantamariacusco.com/wp-content/uploads/2022/01/habitacion-simple-hotel-Santa-Maria-Cusco-peru.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'https://www.hotelsantamariacusco.com/wp-content/uploads/2022/01/habitacion-triple-hotel-Santa-Maria-Cusco-peru01.jpg', '1', 'admin', 'admin');


INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'https://www.hotellaslomas.com.pe/images/habitaciones/double-premium-room/double-premium-room-hotel-las-lomas1.png', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'https://www.hotellaslomas.com.pe/images/habitaciones/double-premium-room/double-premium-room-hotel-las-lomas2.png', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'https://www.hotellaslomas.com.pe/images/habitaciones/double-premium-room/double-premium-room-hotel-las-lomas3.png', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'https://www.hotellaslomas.com.pe/images/habitaciones/double-premium-room/double-premium-room-hotel-las-lomas4.png', '1', 'admin', 'admin');

INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'https://mariel-hotel.com/wp-content/uploads/2022/05/Habitacion-Individual-Estandar.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'https://mariel-hotel.com/wp-content/uploads/2022/05/Habitacion-Doble-Estandar-2-ingles.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'https://mariel-hotel.com/wp-content/uploads/2022/05/habitacion-doble-twin-2.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'https://mariel-hotel.com/wp-content/uploads/2022/05/abitacion-triple-2.jpg', '1', 'admin', 'admin');

INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'https://www.hotelsantamariacusco.com/wp-content/uploads/2022/01/habitacion-simple-hotel-Santa-Maria-Cusco-peru01.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'https://www.hotelsantamariacusco.com/wp-content/uploads/2022/01/habitacion-doble-hotel-Santa-Maria-Cusco-peru01.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'https://www.hotelsantamariacusco.com/wp-content/uploads/2022/01/habitacion-simple-hotel-Santa-Maria-Cusco-peru.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'https://www.hotelsantamariacusco.com/wp-content/uploads/2022/01/habitacion-triple-hotel-Santa-Maria-Cusco-peru01.jpg', '1', 'admin', 'admin');

INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'https://www.hotellaslomas.com.pe/images/habitaciones/double-premium-room/double-premium-room-hotel-las-lomas1.png', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'https://www.hotellaslomas.com.pe/images/habitaciones/double-premium-room/double-premium-room-hotel-las-lomas2.png', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'https://www.hotellaslomas.com.pe/images/habitaciones/double-premium-room/double-premium-room-hotel-las-lomas3.png', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'https://www.hotellaslomas.com.pe/images/habitaciones/double-premium-room/double-premium-room-hotel-las-lomas4.png', '1', 'admin', 'admin');


INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'https://mariel-hotel.com/wp-content/uploads/2022/05/Habitacion-Individual-Estandar.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'https://mariel-hotel.com/wp-content/uploads/2022/05/Habitacion-Doble-Estandar-2-ingles.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'https://mariel-hotel.com/wp-content/uploads/2022/05/habitacion-doble-twin-2.jpg', '1', 'admin', 'admin');
INSERT INTO imagenesHabitacion (idHabitacion, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'https://mariel-hotel.com/wp-content/uploads/2022/05/abitacion-triple-2.jpg', '1', 'admin', 'admin');





INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'No se aceptan mascotas', 'img/nomascota.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'Estacionamiento gratis', 'img/estacionamiento.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'Wifi gratis', 'img/wifi.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'Vista a la ciudad', 'img/vistaciudad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'Sencilla', 'img/sencilla.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'Capacidad', 'img/capacidad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (1, 'No reembolsable', 'img/noreembolsable.jpg', '1', 'admin', 'admin');


INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'No se aceptan mascotas', 'img/nomascota.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'Estacionamiento gratis', 'img/estacionamiento.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'Wifi gratis', 'img/wifi.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'Vista a la ciudad', 'img/vistaciudad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'Sencilla', 'img/sencilla.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'Capacidad', 'img/capacidad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (2, 'No reembolsable', 'img/noreembolsable.jpg', '1', 'admin', 'admin');

INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'No se aceptan mascotas', 'img/nomascota.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'Estacionamiento gratis', 'img/estacionamiento.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'Wifi gratis', 'img/wifi.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'Vista a la ciudad', 'img/vistaciudad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'Sencilla', 'img/sencilla.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'Capacidad', 'img/capacidad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (3, 'No reembolsable', 'img/noreembolsable.jpg', '1', 'admin', 'admin');


INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'No se aceptan mascotas', 'img/nomascota.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'Estacionamiento gratis', 'img/estacionamiento.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'Wifi gratis', 'img/wifi.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'Vista a la ciudad', 'img/vistaciudad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'Sencilla', 'img/sencilla.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'Capacidad', 'img/capacidad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (4, 'No reembolsable', 'img/noreembolsable.jpg', '1', 'admin', 'admin');

INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'No se aceptan mascotas', 'img/nomascota.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'Estacionamiento gratis', 'img/estacionamiento.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'Wifi gratis', 'img/wifi.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'Vista a la ciudad', 'img/vistaciudad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'Sencilla', 'img/sencilla.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'Capacidad', 'img/capacidad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (5, 'No reembolsable', 'img/noreembolsable.jpg', '1', 'admin', 'admin');


INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'No se aceptan mascotas', 'img/nomascota.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'Estacionamiento gratis', 'img/estacionamiento.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'Wifi gratis', 'img/wifi.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'Vista a la ciudad', 'img/vistaciudad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'Sencilla', 'img/sencilla.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'Capacidad', 'img/capacidad.jpg', '1', 'admin', 'admin');
INSERT INTO serviciosHabitacion (idHabitacion, nombreServicio, urlImagen, estado, usrCreacion, usrEdicion) VALUES (6, 'No reembolsable', 'img/noreembolsable.jpg', '1', 'admin', 'admin');




-- Registro 1
INSERT INTO reserva (idcliente, idhabitacion, fechaingreso, fechasalida, totaldias, subtotal, igv, total, estado, usrcreacion, usredicion) 
VALUES (1, 1, '2024-05-01', '2024-05-05', 4, 400.00, 76.00, 476.00, 1, 'admin', 'admin');

-- Registro 2
INSERT INTO reserva (idcliente, idhabitacion, fechaingreso, fechasalida, totaldias, subtotal, igv, total, estado, usrcreacion, usredicion) 
VALUES (2, 2, '2024-05-03', '2024-05-08', 5, 600.00, 114.00, 714.00, 1, 'admin', 'admin');

-- Registro 3
INSERT INTO reserva (idcliente, idhabitacion, fechaingreso, fechasalida, totaldias, subtotal, igv, total, estado, usrcreacion, usredicion) 
VALUES (3, 3, '2024-05-06', '2024-05-10', 4, 500.00, 95.00, 595.00, 1, 'admin', 'admin');

-- Registro 4
INSERT INTO reserva (idcliente, idhabitacion, fechaingreso, fechasalida, totaldias, subtotal, igv, total, estado, usrcreacion, usredicion) 
VALUES (4, 4, '2024-05-08', '2024-05-12', 4, 450.00, 85.50, 535.50, 1, 'admin', 'admin');

-- Registro 5
INSERT INTO reserva (idcliente, idhabitacion, fechaingreso, fechasalida, totaldias, subtotal, igv, total, estado, usrcreacion, usredicion) 
VALUES (5, 5, '2024-05-10', '2024-05-15', 5, 700.00, 133.00, 833.00, 1, 'admin', 'admin');


INSERT INTO usuarios (email, password,idcliente, estado, usrcreacion, usredicion)
VALUES ('usuario5@example.com', 'password5',1, 1, 'admin', 'admin');
INSERT INTO usuarios (email, password,idcliente, estado, usrcreacion, usredicion)
VALUES ('usuario3@example.com', 'password3',2, 1, 'admin', 'admin');
INSERT INTO usuarios (email, password,idcliente, estado, usrcreacion, usredicion)
VALUES ('usuario2@example.com', 'password2',3, 1, 'admin', 'admin');

