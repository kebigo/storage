DROP DATABASE IF EXISTS AGENCIADEVIAJES;
CREATE DATABASE AGENCIADEVIAJES CHARACTER SET utf8 COLLATE utf8_bin;
USE AGENCIADEVIAJES;
CREATE TABLE PERSONA(
    DNI VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(30),
    apellido VARCHAR(20),
    email VARCHAR(50),
    telefono VARCHAR(12)
);
CREATE TABLE EMPLEADO(
    DNI VARCHAR(9) PRIMARY KEY,
    departamento VARCHAR(20),
    CONSTRAINT FK1 FOREIGN KEY (DNI) REFERENCES PERSONA (DNI)
);
CREATE TABLE VIAJERO(
    DNI VARCHAR(9) PRIMARY KEY,
    vacunasCOVID INT,
    CONSTRAINT FK2 FOREIGN KEY (DNI) REFERENCES PERSONA (DNI)
);
CREATE TABLE ALOJAMIENTO(
    IDAlojamiento INT PRIMARY KEY,
    Precio INT,
    tipo VARCHAR(20),
    destino VARCHAR(20),
    puntuacion INT,
    extras VARCHAR(30),
    instalaciones VARCHAR(20)
);
CREATE TABLE TRANSPORTE(
    IDTransporte INT PRIMARY KEY,
    Precio INT,
    tipo VARCHAR(20),
    destino VARCHAR(20),
    origen VARCHAR(20),
    puntuacion INT,
    extras VARCHAR(30)
);
CREATE TABLE PAQUETE(
    IDPaquete INT PRIMARY KEY,
    IDTransporte INT,
    IDAlojamiento INT,
    precio INT,
    CONSTRAINT FK3 FOREIGN KEY (IDTransporte) REFERENCES TRANSPORTE (IDTransporte),
    CONSTRAINT FK4 FOREIGN KEY (IDAlojamiento) REFERENCES ALOJAMIENTO (IDAlojamiento)
);
CREATE TABLE reservaPaquete(
    DNI VARCHAR(9),
    IDPaquete INT,
    fecha DATE,
    precio INT,
    PRIMARY KEY(DNI, IDPaquete),
    CONSTRAINT FK5 FOREIGN KEY (DNI) REFERENCES VIAJERO (DNI),
    CONSTRAINT FK6 FOREIGN KEY (IDPaquete) REFERENCES PAQUETE (IDPaquete)
);
CREATE TABLE reservaAlojamiento(
    DNI VARCHAR(9),
    IDAlojamiento INT,
    fecha DATE,
    precio INT,
    PRIMARY KEY(DNI, IDAlojamiento),
    CONSTRAINT FK7 FOREIGN KEY (DNI) REFERENCES VIAJERO (DNI),
    CONSTRAINT FK8 FOREIGN KEY (IDAlojamiento) REFERENCES ALOJAMIENTO (IDAlojamiento)
);
CREATE TABLE reservaTransporte(
    DNI VARCHAR(9),
    IDTransporte INT,
    fecha DATE,
    precio INT,
    PRIMARY KEY(DNI, IDTransporte),
    CONSTRAINT FK9 FOREIGN KEY (DNI) REFERENCES VIAJERO (DNI),
    CONSTRAINT FK10 FOREIGN KEY (IDTransporte) REFERENCES TRANSPORTE (IDTransporte)
);
CREATE TABLE FACTURA(
    IDFactura INT AUTO_INCREMENT PRIMARY KEY,
    DNI VARCHAR(9),
    fecha DATE,
    total INT,
    CONSTRAINT FK11 FOREIGN KEY (DNI) REFERENCES VIAJERO (DNI)
);