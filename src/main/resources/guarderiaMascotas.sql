CREATE DATABASE guarderiaMascotas;

USE guarderiaMascotas;

CREATE TABLE propietario(
	id_propietario INT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	apellido VARCHAR(100) NOT NULL,
	correo VARCHAR(100) NOT NULL,
	telefono VARCHAR(100) NOT NULL
);

CREATE TABLE mascota(
	id_mascota INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	edad_meses INT NOT NULL,
	raza VARCHAR(50) NOT NULL,
	genero ENUM('Macho','Hembra') NOT NULL,
	id_propietario INT NOT NULL,
	FOREIGN KEY (id_propietario) REFERENCES propietario(id_propietario)
);

CREATE TABLE jaula(
	id_jaula INT PRIMARY KEY,
	estado VARCHAR(100) NOT NULL,
	id_mascota INT,
	FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
);

CREATE TABLE admin_guarderia(
	id_admin INT PRIMARY KEY,
	nombre VARCHAR(100) NOT NULL,
	apellido VARCHAR(100) NOT NULL,
	usuario VARCHAR(100) NOT NULL,
	contrasenia VARCHAR(100) NOT NULL
);


CREATE TABLE info_jaula(
	id_info_jaula INT AUTO_INCREMENT PRIMARY KEY,
	id_mascota INT NOT NULL,
	hora_ingreso TIME NOT NULL,
	hora_salida TIME NOT NULL,
	precio_hora DECIMAL DEFAULT (10000),
	valor_servicio DECIMAL NOT NULL,
	FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
);
