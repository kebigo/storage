package TodoElProyecto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.*;
/**
 * Esta es la clase principal del programa
 * Realiza las operaciones principales del programa.
 * 
 * @author KevinYBittor
 */

public class agenciamain {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<empleado> empleadosArray = new ArrayList<empleado>();
        ArrayList<transporte> transportesArray = new ArrayList<transporte>();
        ArrayList<viajero> viajerosArray = new ArrayList<viajero>();
        ArrayList<alojamiento> alojamientosArray = new ArrayList<alojamiento>();
        ArrayList<paquete> paquetesArray = new ArrayList<paquete>();
        ArrayList<reservaAlojamiento> reservaAlojamientos = new ArrayList<reservaAlojamiento>();
        ArrayList<reservaTransporte> reservaTransportes = new ArrayList<reservaTransporte>();
        ArrayList<reservaPaquete> reservaPaquetes = new ArrayList<reservaPaquete>();
        empleado Empleado;
        transporte Transporte;
        alojamiento Alojamiento;
        paquete Paquete;
        boolean admin = false;
        String fecha;
        boolean ModificadoFactura = false;
        boolean Modificado = false;
        factura ac = new factura();
        ArrayList<factura> facturaArrayList = new ArrayList<factura>();
        final Logger LOGGER = CustomLogger.getLogger();
        BaseDeDatosFactura(facturaArrayList);
        BaseDeDatosEmpleado(empleadosArray);
        BaseDeDatosTransporte(transportesArray);
        BaseDeDatosViajeros(viajerosArray);
        BaseDeDatosAlojamientos(alojamientosArray);
        BaseDeDatosPaquetes(paquetesArray);
        BaseDeDatosReservaAlojamiento(reservaAlojamientos);
        BaseDeDatosReservaTrasporte(reservaTransportes);
        BaseDeDatosReservaPaquetes(reservaPaquetes);

        
        
        int intentos = 3;
        boolean login = false;
        boolean empleado = false;
        String email = "";
        String contrasena = "";
        String nombre = "";
        int opcion = 10;
        boolean ModificadoAlojamiento = false;
        boolean ModificadoEmpleado = false;
        boolean ModificadoPaquete = false;
        boolean ModificadoReAl = false;
        boolean ModificadoRePa = false;
        boolean ModificadoReTra = false;
        boolean ModificadoTransporte = false;
        boolean ModificadoViajero = false;
        String dni = "";
        // AGREGAR FECHA ELIMINACIÓN
        // INSERT INTO TABLE1 (fecha_eliminación) VALUES(sysdate());
        while (intentos > 0 && !login) {
            if (intentos < 3) {
                System.out.println("Contraseña o email incorrectos. Te quedan: " + intentos);
            }
            if (intentos == 1) {
                System.out.println("Te queda 1 intento. Quieres registrarte? si/no");
                String CrearUsuario;
                CrearUsuario = teclado.next().toLowerCase();
                if (CrearUsuario.equals("si")) {
                    viajero a = new viajero();
                    a.leer(teclado);
                    viajerosArray.add(a);
                    intentos = 3;
                    ModificadoViajero = true;
                }
            }
            if (!login) {
                System.out.println("LOGIN");
                System.out.println("Email");
                email = teclado.next();
                System.out.println("Contraseña");
                contrasena = teclado.next();
                for (empleado e : empleadosArray) {
                    if (email.equals(e.getEmail())) {
                        if (contrasena.equals(e.getContrasena())) {
                            login = true;
                            nombre = e.getNombre();
                            empleado = true;
                            if (e.esAdministrador(e)) {
                                admin = true;
                            }
                        }
                    }
                }
            }
            for (viajero e : viajerosArray) {
                if (email.equals(e.getEmail())) {
                    if (contrasena.equals(e.getContrasena())) {
                        login = true;
                        dni = e.getDNI();
                    }
                }
            }
            intentos -= 1;
        }
        if (intentos == 0) {
            System.out.println("Ha llegado al limite de intentos." + "\n" + " Intentelo de nuevo más tarde");
            System.exit(0);
        }
        if (login) {
            // Registro completo de lo que se haga, login, eliminar, cambiar contraseña.
            do {
                if (login && empleado) {// Vista empleado(Superior o Dueño)
                    while (opcion < 0 || opcion > 8) {
                        System.out.println("Bienvenido " + nombre + " Que desea hacer?");

                        System.out.println(" 0- Salir del Programa");
                        if (admin) {
                            System.out.println(" 1- Añadir un nuevo empleado");
                        }
                        System.out.println(" 2- Añadir nuevo Trans/Aloj/Paquete");
                        System.out.println(" 3- Ver empelados");
                        System.out.println(" 4- Ver reservas");
                        System.out.println(" 5- Ver Trans/Aloj/Paquete");
                        System.out.println(" 6- eliminar Trans/ALoj/Paquete");
                        System.out.println("Opciones: ");
                        /**
                         * Try And Catch que para evitar colapso de la aplicacion por poner numero
                         */
                        try {
                            opcion = teclado.nextInt();
                        } catch (InputMismatchException e) {
                        	LOGGER.log(Level.SEVERE, "Se ha producido un error inesperado.", e);
                            System.out.println("Ingrese un numero de 0 a 6 por favor");
                            teclado.nextLine();
                            opcion = -1;
                        }
                        LOGGER.info("El usuario ha seleccionado la opcion: "+opcion);
                        if (opcion < 0 || opcion > 8) {
                            System.out.println("Por favor, elija una opcion valida por favor");
                        }
                    }
                    switch (opcion) {
                        case 1:
                            if (!admin) {
                                System.out.println("No tienes permisos para usar esta opcion");
                                opcion = -1;
                            } else {
                                Empleado = new empleado();
                                teclado.nextLine();
                                System.out.println("Añada al nuevo empleado");
                                Empleado.leer(teclado);

                                if (empleadosArray.contains(Empleado))
                                    System.out.println("El Empelado ya existe");
                                else {
                                    empleadosArray.add(new empleado(Empleado));
                                    System.out.println("El empleado a sido añadido correctamente");
                                    ModificadoEmpleado = true;
                                }
                            }
                            opcion = -1;
                            break;
                        case 2:
                            opcion = -1;
                            int opcion2 = 0;
                            do {
                                System.out.println("Que desea añadir");
                                System.out.println("0- Salir");
                                System.out.println("1- Transporte");
                                System.out.println("2- Alojamiento");
                                System.out.println("3- Paquete");
                                System.out.println("opcion:");
                                try {
                                    opcion2 = teclado.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Ingrese un numero de 0 a 3 por favor");
                                    teclado.nextLine();
                                    opcion2 = -1;
                                }
                                if (opcion2 < 0 || opcion2 > 3) {
                                    System.out.println("Por favor, elija una opcion valida por favor");
                                }

                                switch (opcion2) {
                                    case 1:
                                        Transporte = new transporte();
                                        Transporte.leer(teclado);
                                        if (transportesArray.contains(Transporte)) {
                                            System.out.println("El transporte ya existe");
                                        } else {
                                            transportesArray.add(new transporte(Transporte));
                                            System.out.println("El transporte a sido añadido correctamente");
                                            ModificadoTransporte = true;
                                        }
                                        break;
                                    case 2:
                                        Alojamiento = new alojamiento();
                                        Alojamiento.leer(teclado);
                                        if (alojamientosArray.contains(Alojamiento)) {
                                            System.out.println("El alojamiento ya existe");
                                        } else {
                                            alojamientosArray.add(new alojamiento(Alojamiento));
                                            System.out.println("El alojamiento a sido añadido correctamente");
                                            ModificadoAlojamiento = true;
                                        }
                                        break;
                                    case 3:
                                        Paquete = new paquete();
                                        System.out.println("************Alojamientos************");
                                        for (alojamiento ra : alojamientosArray) {
                                            ra.print();
                                        }
                                        System.out.println("************Transportes************");
                                        for (transporte rt : transportesArray) {
                                            rt.print();
                                        }
                                        Paquete.leer(teclado);
                                        if (paquetesArray.contains(Paquete)) {
                                            System.out.println("El paquete ya existe");
                                        } else {
                                            paquetesArray.add(new paquete(Paquete));
                                            System.out.println("El paquete a sido añadido correctamente");
                                            ModificadoPaquete = true;
                                        }
                                        break;
                                }
                            } while (opcion2 != 0);

                            break;

                        case 3:
                            opcion = -1;
                            for (empleado e : empleadosArray) {
                                e.print();
                            }
                            break;
                        case 4:
                            opcion = -1;
                            System.out.println("************Alojamientos************");
                            for (reservaAlojamiento ra : reservaAlojamientos) {
                                ra.print();
                            }
                            System.out.println("************Transportes************");
                            for (reservaTransporte rt : reservaTransportes) {
                                rt.print();
                            }
                            System.out.println("************Paquetes************");
                            for (reservaPaquete rp : reservaPaquetes) {
                                rp.print();
                            }
                            break;

                        case 5:
                            opcion2 = 0;
                            do {
                                System.out.println("Que desea ver");
                                System.out.println("0- Salir");
                                System.out.println("1- Transporte");
                                System.out.println("2- Alojamiento");
                                System.out.println("3- Paquete");
                                System.out.println("opcion:");
                                try {
                                    opcion2 = teclado.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Ingrese un numero de 0 a 3 por favor");
                                    teclado.nextLine();
                                    opcion2 = -1;
                                }
                                if (opcion2 < 0 || opcion2 > 3) {
                                    System.out.println("Por favor, elija una opcion valida por favor");
                                }

                                switch (opcion2) {
                                    case 1:
                                        for (transporte t : transportesArray) {
                                            t.print();
                                        }
                                        break;
                                    case 2:
                                        for (alojamiento a : alojamientosArray) {
                                            a.print();
                                        }
                                        break;
                                    case 3:
                                        for (paquete p : paquetesArray) {
                                            p.print();
                                        }
                                        break;
                                }
                            } while (opcion2 != 0);
                            opcion = -1;
                            break;
                        case 6:
                            opcion = -1;
                            opcion2 = -1;
                            do {
                                System.out.println("Que desea Eliminar");
                                System.out.println("0- Salir");
                                System.out.println("1- Transporte");
                                System.out.println("2- Alojamiento");
                                System.out.println("3- Paquete");
                                System.out.println("opcion:");
                                try {
                                    opcion2 = teclado.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Ingrese un numero de 0 a 3 por favor");
                                    teclado.nextLine();
                                    opcion2 = -1;
                                }
                                if (opcion2 < 0 || opcion2 > 3) {
                                    System.out.println("Por favor, elija una opcion valida por favor");
                                }

                                switch (opcion2) {
                                    case 1:
                                        int Identificador = 0;
                                        Transporte = new transporte();
                                        for (transporte t : transportesArray) {
                                            t.print();
                                        }
                                        System.out.println("Transporte: INGRESE EL IDENTIFICADOR PARA BORRARLO ");
                                        Identificador = teclado.nextInt();
                                        for (transporte t : transportesArray) {
                                            if (Identificador == t.getIdTransporte()) {
                                                Transporte = t;
                                                System.out.println("Se ha encontrado la ID");
                                            }
                                        }

                                        if (transportesArray.remove(Transporte)) {
                                            System.out.println("El elemento ha sido borrado");
                                            ModificadoTransporte = true;
                                        } else {
                                            System.out.println("El Transporte NO se ha encontrado");
                                        }

                                        break;
                                    case 2:
                                        Alojamiento = new alojamiento();
                                        System.out.println("Transporte: ");
                                        Alojamiento.leer(teclado);

                                        if (alojamientosArray.remove(Alojamiento)) {
                                            System.out.println("El elemento ha sido borrado");
                                        } else {
                                            System.out.println("El Transporte NO se ha encontrado");
                                        }
                                        ModificadoAlojamiento = true;
                                        break;
                                    case 3:
                                        Paquete = new paquete();
                                        System.out.println("Transporte: ");
                                        Paquete.leer(teclado);

                                        if (paquetesArray.remove(Paquete)) {
                                            System.out.println("El elemento ha sido borrado");
                                        } else {
                                            System.out.println("El Transporte NO se ha encontrado");
                                        }
                                        ModificadoPaquete = true;
                                        break;
                                }
                            } while (opcion2 != 0);
                            break;
                    }
                } else if (login && !empleado) {
                    int opcion2 = 0;
                    do {
                        System.out.println(" 0- Salir del Programa");
                        System.out.println(" 1- Ver Trans/Aloj/Paquete");
                        System.out.println(" 2- hacer una reserva");
                        System.out.println(" 3- Ver reservas");
                        System.out.println(" 4- Cancelar una reserva");
                        System.out.println(" 5- Crear Factura");
                        System.out.println(" 6- Ver Factura");
                        System.out.println("Opciones: ");
                        try {
                            opcion = teclado.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Ingrese un numero de 0 a 5 por favor");
                            teclado.nextLine();
                            opcion = -1;
                        }
                        if (opcion < 0 || opcion > 8) {
                            System.out.println("Por favor, elija una opcion valida valido");
                        }

                        switch (opcion) {
                            case 1:
                                opcion2 = 0;

                                System.out.println("Que desea ver");
                                System.out.println("1- Transporte");
                                System.out.println("2- Alojamiento");
                                System.out.println("3- Paquete");
                                System.out.println("opcion:");
                                opcion2 = teclado.nextInt();
                                if (opcion2 < 0 || opcion2 > 3) {
                                    System.out.println("Por favor, elija una opcion valida por favor");
                                }

                                switch (opcion2) {
                                    case 1:
                                        for (transporte t : transportesArray) {
                                            t.print();
                                        }
                                        break;
                                    case 2:
                                        for (alojamiento a : alojamientosArray) {
                                            a.print();
                                        }
                                        break;
                                    case 3:
                                        for (paquete p : paquetesArray) {
                                            p.print();
                                        }
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Que quieres reservar?");

                                opcion2 = 0;
                                System.out.println("0- Salir");
                                System.out.println("1- Transporte");
                                System.out.println("2- Alojamiento");
                                System.out.println("3- Paquete");
                                System.out.println("opcion:");
                                opcion2 = teclado.nextInt();
                                if (opcion2 < 0 || opcion2 > 3) {
                                    System.out.println("Por favor, elija una opcion valida por favor");
                                }

                                switch (opcion2) {
                                    case 1:

                                        int idtransporte = 0;
                                        boolean encontrado = false;
                                        dni = "";
                                        double precio = 0;
                                        fecha = "";

                                        for (transporte a : transportesArray) {
                                            a.print();
                                        }

                                        System.out.println("Escribe el id del transporte que desea reservar");
                                        idtransporte = teclado.nextInt();
                                        for (transporte t : transportesArray) {
                                            if (t.idTransporte == idtransporte) {
                                                precio = t.getPrecio();
                                                encontrado = true;
                                            }
                                        }
                                        if (encontrado) {
                                            LocalDate currentDate = LocalDate.now();
                                            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                            for (viajero v : viajerosArray) {
                                                if (email.equals(v.getEmail())) {
                                                    dni = v.getDNI();
                                                    fecha = formattedDate;
                                                }
                                            }
                                            reservaTransportes.add(new reservaTransporte(idtransporte, dni, fecha, precio));
                                            System.out.println("Su transporte a sido reservado");
                                            ModificadoReTra = true;
                                        }
                                        if (!encontrado) {
                                            System.err.println("No se a encontrado ningun transporte ");
                                        }
                                        break;
                                    case 2:
                                        int idAlojamiento = 0;
                                        encontrado = false;
                                        dni = "";
                                        precio = 0;
                                        fecha = "";

                                        for (alojamiento a : alojamientosArray) {
                                            a.print();
                                        }

                                        System.out.println("Escribe el id del alojamiento que desea reservar");
                                        idAlojamiento = teclado.nextInt();
                                        for (alojamiento t : alojamientosArray) {
                                            if (t.idAlojamiento == idAlojamiento) {
                                                precio = t.getPrecio();
                                                encontrado = true;
                                            }
                                        }
                                        if (encontrado) {
                                            LocalDate currentDate = LocalDate.now();
                                            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                            for (viajero v : viajerosArray) {
                                                if (email.equals(v.getEmail())) {
                                                    dni = v.getDNI();
                                                    fecha = formattedDate;
                                                }
                                            }
                                            reservaAlojamientos
                                                    .add(new reservaAlojamiento(idAlojamiento, dni, fecha, precio));
                                            System.out.println("Su alojamiento a sido reservado");
                                            ModificadoReAl = true;
                                        }
                                        if (!encontrado) {
                                            System.err.println("No se a encontrado ningun alojamiento ");
                                        }

                                        break;
                                    case 3:
                                        int idpaquete = 0;
                                        encontrado = false;
                                        dni = "";
                                        precio = 0;
                                        fecha = "";
                                        for (paquete p : paquetesArray) {
                                            p.print();
                                        }
                                        System.out.println("Escribe el id del transporte que desea reservar");
                                        idAlojamiento = teclado.nextInt();
                                        for (paquete t : paquetesArray) {
                                            if (t.idPaquete == idpaquete) {
                                                precio = t.getPrecio();
                                                encontrado = true;
                                            }
                                        }
                                        if (encontrado) {
                                            LocalDate currentDate = LocalDate.now();
                                            String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                            for (viajero v : viajerosArray) {
                                                System.out.println(email);
                                                if (email.equals(v.getEmail())) {
                                                    dni = v.getDNI();
                                                    fecha = formattedDate;
                                                }
                                            }
                                            reservaPaquetes.add(new reservaPaquete(idpaquete, dni, fecha, precio));
                                            System.out.println("Su paquete a sido reservado");
                                            ModificadoRePa = true;
                                        }
                                        if (!encontrado) {
                                            System.err.println("No se a encontrado ningun paquete ");
                                        }
                                        break;
                                }
                                break;
                            case 3:
                                for (viajero v : viajerosArray) {
                                    if (email.equals(v.getEmail())) {
                                        dni = v.getDNI();
                                    }
                                }
                                for (reservaAlojamiento p : reservaAlojamientos) {
                                    if (dni.equals(p.getDNI())) {
                                        p.print();
                                    }

                                }
                                for (reservaTransporte p : reservaTransportes) {
                                    if (dni.equals(p.getDNI())) {
                                        p.print();
                                    }
                                }
                                for (reservaPaquete p : reservaPaquetes) {
                                    if (dni.equals(p.getDNI())) {
                                        p.print();
                                    }
                                }
                                break;
                            case 4:
                            
                                for (viajero v : viajerosArray) {
                                    if (email.equals(v.getEmail())) {
                                        dni = v.getDNI();
                                    }
                                }
                                opcion2 = 0;
                                System.out.println("Elimina las reservas de:");
                                System.out.println("0- Salir");
                                System.out.println("1- Transporte");
                                System.out.println("2- Alojamiento");
                                System.out.println("3- Paquete");
                                System.out.println("opcion:");
                                opcion2 = teclado.nextInt();
                                if (opcion2 < 0 || opcion2 > 3) {
                                    System.out.println("Por favor, elija una opcion valida por favor");
                                }

                                switch (opcion2) {
                                    case 1:
                                    for (reservaTransporte p : reservaTransportes) {
                                        if (dni.equals(p.getDNI())) {
                                            reservaTransportes.remove(p);
                                        }
                                        ModificadoReTra = true;
                                    }
                                        break;
                                    case 2:
                                    for (reservaAlojamiento p : reservaAlojamientos) {
                                        if (dni.equals(p.getDNI())) {
                                            reservaAlojamientos.remove(p);
                                        }
                                        ModificadoReAl = true;
                                    }
                                        break;
                                    case 3:
                                    for (reservaPaquete p : reservaPaquetes) {
                                        if (dni.equals(p.getDNI())) {
                                            reservaPaquetes.remove(p);
                                        }
                                        ModificadoRePa = true;
                                    }
                                        break;
                                }
                                break;
                                case 5:
                                int cantidad=0;
                                cantidad = facturaArrayList.size();
                                LocalDate currentDate = LocalDate.now();
                                String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                
                                ac = new factura(cantidad, dni, formattedDate, new  ArrayList<LineaFactura>());
                                for (reservaPaquete p : reservaPaquetes) {
                                    if (dni.equals(p.getDNI())) {
                                        ac.anadirLinea(p.getIDPaquete(), p.getPrecio());
                                    }
                                }
                                for (reservaPaquete p : reservaPaquetes) {
                                    if (dni.equals(p.getDNI())) {
                                        ac.anadirLinea(p.getIDPaquete(), p.getPrecio());
                                    }
                                }
                                for (reservaPaquete p : reservaPaquetes) {
                                    if (dni.equals(p.getDNI())) {
                                        ac.anadirLinea(p.getIDPaquete(), p.getPrecio());
                                    }
                                }
                                facturaArrayList.add(ac);
                                ModificadoFactura = true;
                                Modificado = true;
                                break;
                                case 6:
                                    for (factura fa : facturaArrayList) {
                                        if (fa.getDNI().equals(dni)) {
                                            fa.print();
                                        }
                                    }
                                break;
                        }
                    } while (opcion != 0);
                }
            } while (opcion != 0);
            teclado.close();
        }
        if (Modificado) {
            try {
                FileOutputStream fos = new FileOutputStream("factura.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                for (factura cc : facturaArrayList) {
                    oos.writeObject(cc);
                }
                oos.close();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (ModificadoEmpleado) {
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                st.executeUpdate("DELETE FROM empleado;");
                st.executeUpdate("DELETE FROM persona;");
                String DNI = "";
                String Nombre = "";
                String apellido = "";
                String Email = "";
                String telefono = "";
                String contrasenaa = "";
                String departamento = "";
                String rol = "";

                for (empleado e : empleadosArray) {
                    DNI = e.getDNI();
                    Nombre = e.getNombre();
                    apellido = e.getApellido();
                    Email = e.getEmail();
                    telefono = e.getTelefono();
                    contrasenaa = e.getContrasena();
                    departamento = e.getDepartamento();
                    rol = e.getRol();
                    st.executeUpdate("CALL insertar_persona('" + DNI + "')");
                    st.executeUpdate("INSERT INTO empleado VALUES ('" + DNI + "','" + Nombre + "','" +
                            apellido + "','" + Email + "','" + telefono + "','" + contrasenaa + "','" + departamento
                            + "','" + rol + "')");
                }

                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
        }
        if (ModificadoTransporte) {
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                st.executeUpdate("DELETE FROM transporte;");
                int idTransporte = 0;
                double precio = 0;
                String tipo = "";
                String destino = "";
                String origen = "";
                int puntuacion = 0;
                String extras = "";

                for (transporte t : transportesArray) {
                    idTransporte = t.getIdTransporte();
                    precio = t.getPrecio();
                    tipo = t.getTipo();
                    destino = t.getDestino();
                    origen = t.getOrigen();
                    puntuacion = t.getPuntuacion();
                    extras = t.getExtras();

                    st.executeUpdate("INSERT INTO transporte VALUES ('" + idTransporte + "','" + precio + "','" +
                            tipo + "','" + destino + "','" + origen + "','" + puntuacion + "','" + extras + "')");
                }
                // cierro la conexion
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
        }
        if (ModificadoViajero) {
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                st.executeUpdate("DELETE FROM viajero;");
                String DNI = "";
                String Nombre = "";
                String apellido = "";
                String Email = "";
                String telefono = "";
                contrasena = "";
                int vacunasCOVID = 0;

                for (viajero v : viajerosArray) {
                    DNI = v.getDNI();
                    Nombre = v.getNombre();
                    apellido = v.getApellido();
                    Email = v.getEmail();
                    telefono = v.getTelefono();
                    contrasena = v.getContrasena();
                    vacunasCOVID = v.getVacunasCOVID();
                    st.executeUpdate("CALL insertar_persona('" + DNI + "')");
                    st.executeUpdate("INSERT INTO viajero VALUES ('" + DNI + "','" + Nombre + "','" +
                            apellido + "','" + Email + "','" + telefono + "','" + contrasena + "','" + vacunasCOVID
                            + "')");
                }
                // cierro la conexion

                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
        }
        if (ModificadoAlojamiento) {

            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                st.executeUpdate("DELETE FROM alojamiento;");
                int idAlojamiento = 0;
                double precio = 0;
                String tipo = "";
                String destino = "";
                int puntuacion = 0;
                String extra = "";
                String instalaciones = "";
                for (alojamiento a : alojamientosArray) {
                    idAlojamiento = a.getIdAlojamiento();
                    precio = a.getPrecio();
                    tipo = a.getTipo();
                    destino = a.getDestino();
                    puntuacion = a.getPuntuacion();
                    extra = a.getExtra();
                    instalaciones = a.getInstalaciones();
                    st.executeUpdate("INSERT INTO alojamiento VALUES ('" + idAlojamiento + "','" + precio + "','" +
                            tipo + "','" + destino + "','" + puntuacion + "','" + extra + "','" + instalaciones + "')");
                }
                // cierro la conexion
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
        }
        if (ModificadoPaquete) {

            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                st.executeUpdate("DELETE FROM paquete;");
                int idPaquete = 0;
                int idTransporte = 0;
                int idAlojamiento = 0;
                double precio = 0;
                for (paquete p : paquetesArray) {
                    idPaquete = p.getIdPaquete();
                    idTransporte = p.getIdTransporte();
                    idAlojamiento = p.getIdAlojamiento();
                    precio = p.getPrecio();
                    st.executeUpdate("INSERT INTO paquete VALUES ('" + idPaquete + "','" + idTransporte + "','" +
                            idAlojamiento + "','" + precio + "')");
                }
                // cierro la conexion

                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
        }
        if (ModificadoReAl) {

            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                st.executeUpdate("DELETE FROM reservaalojamiento;");
                int IDAlojamiento = 0;
                String DNI = "";
                String Fecha = "";
                double precio = 0;
                for (reservaAlojamiento ra : reservaAlojamientos) {
                    IDAlojamiento = ra.getIDAlojamiento();
                    DNI = ra.getDNI();
                    Fecha = ra.getFecha();
                    precio = ra.getPrecio();
                    st.executeUpdate("INSERT INTO reservaalojamiento VALUES ('" + IDAlojamiento + "','" + DNI + "','" +
                            Fecha + "','" + precio + "')");
                }
                // cierro la conexion

                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
        }
        if (ModificadoReTra) {

            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                st.executeUpdate("DELETE FROM reservatransporte;");
                int IDTransporte = 0;
                String DNI = "";
                String Fecha = "";
                double precio = 0;
                for (reservaTransporte rt : reservaTransportes) {
                    IDTransporte = rt.getIDTransporte();
                    DNI = rt.getDNI();
                    Fecha = rt.getFecha();
                    precio = rt.getPrecio();
                    st.executeUpdate("INSERT INTO reservatransporte VALUES ('" + IDTransporte + "','" + DNI + "','" +
                            Fecha + "','" + precio + "')");
                }
                // cierro la conexion
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
        }
        if (ModificadoRePa) {

            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                st.executeUpdate("DELETE FROM reservapaquete;");
                int IDPaquete = 0;
                String DNI = "";
                String Fecha = "";
                double precio = 0;
                for (reservaTransporte rt : reservaTransportes) {
                    IDPaquete = rt.getIDTransporte();
                    DNI = rt.getDNI();
                    Fecha = rt.getFecha();
                    precio = rt.getPrecio();
                    st.executeUpdate("INSERT INTO reservapaquete VALUES ('" + IDPaquete + "','" + DNI + "','" +
                            Fecha + "','" + precio + "')");
                }
                // cierro la conexion
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
        }
        if (ModificadoFactura) {

            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                st.executeUpdate("DELETE FROM factura;");
                int IDFactura = 0;
                String DNI = "";
                String Fecha = "";
                double total = 0;
                for (factura rt : facturaArrayList) {
                    IDFactura = rt.getIDFactura();
                    IDFactura += 1;
                    DNI = rt.getDNI();
                    Fecha = rt.getFecha();
                    total = rt.getTotal();
                    st.executeUpdate("INSERT INTO factura VALUES ('" + IDFactura + "','" + DNI + "','" +
                            Fecha + "','" + total + "')");
                }
                // cierro la conexion
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
        }
    }

    private static void BaseDeDatosReservaPaquetes(ArrayList<reservaPaquete> reservaPaquetes) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM reservapaquete;");
            int IDPaquete = 0;
            String DNI = "";
            String Fecha = "";
            double precio = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    IDPaquete = (int) rs.getObject("IDPaquete");
                    DNI = (String) rs.getObject("DNI");
                    Fecha = (String) rs.getObject("fecha");
                    precio = (double) rs.getObject("precio");
                    reservaPaquetes.add(new reservaPaquete(IDPaquete, DNI, Fecha, precio));
                }
            } else {
                // si no hay registros
                System.out.println("La tabla no tiene Registros");
            }
            // cierro la conexion
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            // si NO se ha conectado correctamente
            e.printStackTrace();
            System.out.println("Error de Conexión");
        }
    }

    private static void BaseDeDatosReservaTrasporte(ArrayList<reservaTransporte> reservaTransportes) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM reservatransporte;");
            int IDTransporte = 0;
            String DNI = "";
            String Fecha = "";
            double precio = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    IDTransporte = (int) rs.getObject("IDTransporte");
                    DNI = (String) rs.getObject("DNI");
                    Fecha = (String) rs.getObject("fecha");
                    precio = (double) rs.getObject("precio");
                    reservaTransportes.add(new reservaTransporte(IDTransporte, DNI, Fecha, precio));
                }
            } else {
                // si no hay registros
                System.out.println("La tabla no tiene Registros");
            }
            // cierro la conexion
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            // si NO se ha conectado correctamente
            e.printStackTrace();
            System.out.println("Error de Conexión");
        }
    }

    private static void BaseDeDatosReservaAlojamiento(ArrayList<reservaAlojamiento> reservaAlojamientos) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM reservaalojamiento;");
            int IDAlojamiento = 0;
            String DNI = "";
            String Fecha = "";
            double precio = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    IDAlojamiento = (int) rs.getObject("IDAlojamiento");
                    DNI = (String) rs.getObject("DNI");
                    Fecha = (String) rs.getObject("fecha");
                    precio = (double) rs.getObject("precio");
                    reservaAlojamientos.add(new reservaAlojamiento(IDAlojamiento, DNI, Fecha, precio));
                }
            } else {
                // si no hay registros
                System.out.println("La tabla no tiene Registros");
            }
            // cierro la conexion
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            // si NO se ha conectado correctamente
            e.printStackTrace();
            System.out.println("Error de Conexión");
        }
    }

    private static void BaseDeDatosPaquetes(ArrayList<paquete> paquetesArray) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM paquete;");
            int idPaquete = 0;
            int idTransporte = 0;
            int idAlojamiento = 0;
            double precio = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    idPaquete = (int) rs.getObject("IDPaquete");
                    idTransporte = (int) rs.getObject("IDTransporte");
                    idAlojamiento = (int) rs.getObject("IDAlojamiento");
                    precio = (double) rs.getObject("precio");
                    paquetesArray.add(new paquete(idPaquete, idTransporte, idAlojamiento, precio));
                }
            } else {
                // si no hay registros
                System.out.println("La tabla no tiene Registros");
            }
            // cierro la conexion
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            // si NO se ha conectado correctamente
            e.printStackTrace();
            System.out.println("Error de Conexión");
        }
    }

    private static void BaseDeDatosAlojamientos(ArrayList<alojamiento> alojamientosArray) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM alojamiento;");
            int idAlojamiento = 0;
            double precio = 0;
            String tipo = "";
            String destino = "";
            int puntuacion = 0;
            String extra = "";
            String instalaciones = "";
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    idAlojamiento = (int) rs.getObject("IDAlojamiento");
                    precio = (double) rs.getObject("precio");
                    tipo = (String) rs.getObject("tipo");
                    destino = (String) rs.getObject("destino");
                    puntuacion = (int) rs.getObject("puntuacion");
                    extra = (String) rs.getObject("extras");
                    instalaciones = (String) rs.getObject("instalaciones");
                    alojamientosArray.add(
                            new alojamiento(idAlojamiento, precio, tipo, destino, puntuacion, extra, instalaciones));
                }
            } else {
                // si no hay registros
                System.out.println("La tabla no tiene Registros");
            }
            // cierro la conexion
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            // si NO se ha conectado correctamente
            e.printStackTrace();
            System.out.println("Error de Conexión");
        }
    }

    private static void BaseDeDatosViajeros(ArrayList<viajero> viajerosArray) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM viajero;");
            String DNI = "";
            String nombre = "";
            String apellido = "";
            String email = "";
            String telefono = "";
            String contrasena = "";
            int vacunasCOVID = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    DNI = (String) rs.getObject("DNI");
                    nombre = (String) rs.getObject("nombre");
                    apellido = (String) rs.getObject("apellido");
                    email = (String) rs.getObject("email");
                    telefono = (String) rs.getObject("telefono");
                    contrasena = (String) rs.getObject("contrasena");
                    vacunasCOVID = (int) rs.getObject("vacunasCOVID");
                    viajerosArray.add(new viajero(DNI, nombre, apellido, email, telefono, contrasena, vacunasCOVID));
                }

            } else {
                // si no hay registros
                System.out.println("La tabla no tiene Registros");
            }
            // recorro registro a registro el ResultSet

            rs.close();
            conexion.close();
        } catch (SQLException e) {
            // si NO se ha conectado correctamente
            e.printStackTrace();
            System.out.println("Error de Conexión");
        }
    }

    private static void BaseDeDatosTransporte(ArrayList<transporte> transportesArray) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM transporte;");
            int idTransporte = 0;
            double precio = 0;
            String tipo = "";
            String destino = "";
            String origen = "";
            int puntuacion = 0;
            String extras = "";
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    idTransporte = (int) rs.getObject("IDTransporte");
                    precio = (double) rs.getObject("precio");
                    tipo = (String) rs.getObject("tipo");
                    destino = (String) rs.getObject("destino");
                    origen = (String) rs.getObject("origen");
                    puntuacion = (int) rs.getObject("puntuacion");
                    extras = (String) rs.getObject("extras");
                    transportesArray
                            .add(new transporte(idTransporte, precio, tipo, destino, origen, puntuacion, extras));
                }

            } else {
                // si no hay registros
                System.out.println("La tabla no tiene Registros");
            }

            // cierro la conexion
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            // si NO se ha conectado correctamente
            e.printStackTrace();
            System.out.println("Error de Conexión");
        }
    }

    private static void BaseDeDatosEmpleado(ArrayList<empleado> empleadosArray) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM empleado;");
            String DNI = "";
            String nombre = "";
            String apellido = "";
            String email = "";
            String telefono = "";
            String contrasena = "";
            String departamento = "";
            String rol = "";
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    DNI = (String) rs.getObject("DNI");
                    nombre = (String) rs.getObject("nombre");
                    apellido = (String) rs.getObject("apellido");
                    email = (String) rs.getObject("email");
                    telefono = (String) rs.getObject("telefono");
                    contrasena = (String) rs.getObject("contrasena");
                    departamento = (String) rs.getObject("departamento");
                    rol = (String) rs.getObject("rol");
                    empleadosArray.add(new empleado(DNI, nombre, apellido, email, telefono, contrasena, departamento, rol));
                }
            } else {
                // si no hay registros
                System.out.println("La tabla no tiene Registros");
            }

            // cierro la conexion
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            // si NO se ha conectado correctamente
            e.printStackTrace();
            System.out.println("Error de Conexión");
        }
    }

    private static void BaseDeDatosFactura(ArrayList<factura> facturaArrayList) {
        factura ac;
        try {
            FileInputStream fis = new FileInputStream("factura.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                ac = (factura) ois.readObject();
                facturaArrayList.add(ac);
            }
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
