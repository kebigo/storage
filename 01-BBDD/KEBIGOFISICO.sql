DROP DATABASE IF EXISTS AGENCIADEVIAJES;
CREATE DATABASE AGENCIADEVIAJES CHARACTER SET utf8 COLLATE utf8_bin;
USE AGENCIADEVIAJES;
CREATE TABLE PERSONA(
    DNI VARCHAR(9) PRIMARY KEY
);
CREATE TABLE EMPLEADO(
    DNI VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(30),
    apellido VARCHAR(20),
    email VARCHAR(50),
    telefono VARCHAR(12),
    contrasena VARCHAR(50),
    departamento VARCHAR(20),
    rol VARCHAR(20),
    CONSTRAINT FK1 FOREIGN KEY (DNI) REFERENCES PERSONA (DNI)
);
CREATE TABLE VIAJERO(
    DNI VARCHAR(9) PRIMARY KEY,
    vacunasCOVID INT,
    CONSTRAINT FK2 FOREIGN KEY (DNI) REFERENCES PERSONA (DNI)
);
CREATE TABLE ALOJAMIENTO(
    IDAlojamiento INT PRIMARY KEY,
    Precio DOUBLE,
    tipo VARCHAR(20),
    destino VARCHAR(20),
    puntuacion INT,
    extras VARCHAR(30),
    instalaciones VARCHAR(20)
);
CREATE TABLE TRANSPORTE(
    IDTransporte INT PRIMARY KEY,
    Precio DOUBLE,
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
    precio DOUBLE,
    CONSTRAINT FK3 FOREIGN KEY (IDTransporte) REFERENCES TRANSPORTE (IDTransporte),
    CONSTRAINT FK4 FOREIGN KEY (IDAlojamiento) REFERENCES ALOJAMIENTO (IDAlojamiento)
);
CREATE TABLE reservaPaquete(
    DNI VARCHAR(9),
    IDPaquete INT,
    fecha DATE,
    precio DOUBLE,
    PRIMARY KEY(DNI, IDPaquete),
    CONSTRAINT FK5 FOREIGN KEY (DNI) REFERENCES VIAJERO (DNI),
    CONSTRAINT FK6 FOREIGN KEY (IDPaquete) REFERENCES PAQUETE (IDPaquete)
);
CREATE TABLE reservaAlojamiento(
    DNI VARCHAR(9),
    IDAlojamiento INT,
    fecha DATE,
    precio DOUBLE,
    PRIMARY KEY(DNI, IDAlojamiento),
    CONSTRAINT FK7 FOREIGN KEY (DNI) REFERENCES VIAJERO (DNI),
    CONSTRAINT FK8 FOREIGN KEY (IDAlojamiento) REFERENCES ALOJAMIENTO (IDAlojamiento)
);
CREATE TABLE reservaTransporte(
    DNI VARCHAR(9),
    IDTransporte INT,
    fecha DATE,
    precio DOUBLE,
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
INSERT INTO persona VALUES("11111111A");
INSERT INTO persona VALUES("22222222A");
INSERT INTO EMPLEADO VALUES("11111111A", "Kevin", "Patiño", "saikonogameryt@gmail.com","+34666666666","patata", "informatica", "administrador");
INSERT INTO EMPLEADO VALUES("22222222A", "Kevin", "Patiño", "a","+34555555555","a", "informatica", "administrador");

DELIMITER $$
DROP PROCEDURE IF EXISTS insertar_persona$$
CREATE PROCEDURE insertar_persona(IN dni VARCHAR(9))
BEGIN
    INSERT INTO persona(dni) VALUES (dni);
END $$

DELIMITER $$

DROP TRIGGER IF EXISTS transportes_borrados$$
CREATE TRIGGER transportes_borrados
BEFORE DELETE ON transporte
FOR EACH ROW
BEGIN
    INSERT INTO transportes_borrados
    VALUES (now(),OLD.IDTransporte, OLD.tipo);
END$$
DELIMITER $$

DROP TRIGGER IF EXISTS transportes_VALORES_ANTIGUOS$$
CREATE TRIGGER transportes_VALORES_ANTIGUOS
BEFORE UPDATE ON transporte
FOR EACH ROW
BEGIN
    INSERT INTO transportes_borrados
    VALUES (now(),OLD.IDTransporte, OLD.tipo);
END$$

    CREATE TABLE IF NOT EXISTS transportes_borrados (
        fecha DATETIME,
        IDTransporte INT PRIMARY KEY,
        tipo VARCHAR(20)
    );
    CREATE TABLE IF NOT EXISTS transportes_VALORES_ANTIGUOS (
        fecha DATETIME,
        IDTransporte INT PRIMARY KEY,
        tipo VARCHAR(20)
    );

    DELIMITER $$
DROP PROCEDURE IF EXISTS get_tables$$
CREATE PROCEDURE get_tables()
BEGIN
SELECT p.* ,e.* FROM persona p, empleado e GROUP BY p.DNI;
END$$
CALL get_tables();