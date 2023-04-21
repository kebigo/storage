package TodoElProyecto;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.sql.Date;

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
        boolean Modificado = false;
        boolean admin = false;
        Date fecha;
        LocalDate fechaLocalDate;

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM empleado;");
            String DNI = "";
            String nombre = "";
            String apellido = "";
            String email = "";
            String telefono = "";
            String contrasena = "";
            String departamento = "";
            String rol = "";

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
            // cierro la conexion
            rs.close();
            conexion.close();
        } catch (SQLException e) {
            // si NO se ha conectado correctamente
            e.printStackTrace();
            System.out.println("Error de Conexión");
        }
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM agenciadeviajes.transporte;");
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
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM agenciadeviajes.viajero;");
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
                    vacunasCOVID = (int) rs.getObject("departamento");
                    viajerosArray.add(new viajero(DNI, nombre, apellido, email, telefono, contrasena, vacunasCOVID));
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
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM agenciadeviajes.alojamiento;");
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
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM agenciadeviajes.paquete;");
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
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM agenciadeviajes.reservaalojamiento;");
            int IDAlojamiento = 0;
            String DNI = "";
            Date Fecha = new Date(0000-00-00);
            double precio = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    IDAlojamiento = (int) rs.getObject("IDAlojamiento");
                    DNI = (String) rs.getObject("DNI");
                    Fecha = (Date) rs.getObject("fecha");
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
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM agenciadeviajes.reservatransporte;");
            int IDTransporte = 0;
            String DNI = "";
            Date Fecha = new Date(0000-00-00);
            double precio = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    IDTransporte = (int) rs.getObject("IDTransporte");
                    DNI = (String) rs.getObject("DNI");
                    Fecha = (Date) rs.getObject("fecha");
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
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
            // si se ha conectado correctamente
            System.out.println("Conexión Correcta.");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM agenciadeviajes.reservapaquete;");
            int IDPaquete = 0;
            String DNI = "";
            Date Fecha = new Date(0000-00-00);
            double precio = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    IDPaquete = (int) rs.getObject("IDPaquete");
                    DNI = (String) rs.getObject("DNI");
                    Fecha = (Date) rs.getObject("fecha");
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

        int intentos = 3;
        boolean login = false;
        boolean empleado = false;
        String email = "";
        String contraseña = "";
        String nombre = "";
        int opcion = 0;
        // AGREGAR FECHA ELIMINACIÓN
        // INSERT INTO TABLE1 (fecha_eliminación) VALUES(sysdate());
        while (intentos > 0 && !login) {
            if (intentos < 3) {
                System.out.println("Contraseña o email incorrectos. Te quedan: " + intentos);
            }
            System.out.println("LOGIN");
            System.out.println("Email");
            email = teclado.next();
            System.out.println("Contraseña");
            contraseña = teclado.next();
            for (empleado e : empleadosArray) {
                if (email.equals(e.getEmail())) {
                    if (contraseña.equals(e.getContraseña())) {
                        login = true;
                    }
                }
            }
            if (intentos == 1) {
                System.out.println("Te queda 1 intento. Quieres registrarte? si/no");
                String CrearUsuario;
                CrearUsuario = teclado.next().toLowerCase();
                if (CrearUsuario.equals("si")) {
                    // metodocrear usuario
                }
            }
            /*
             * Se compara con la base de datos y si se encuentra la info en la base de datos
             * pone el login en true,
             * de lo contrario, te da un apartado al ultimo intento para poder registrarse
             */
        }
        if (intentos == 0) {
            System.out.println("Ha llegado al limite de intentos." + "\n" + " Intentelo de nuevo más tarde");
            System.exit(0);
        }
        if (login) {
            System.out.println("Bienvenido " + nombre + " Que desea hacer?");
        }
        // Registro completo de lo que se haga, login, eliminar, cambiar contraseña.
        do {
            if (login && empleado) {// Vista empleado(Superior o Dueño)
                while (opcion < 0 || opcion > 8) {
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
                    opcion = teclado.nextInt();
                    if (opcion < 0 || opcion > 8) {
                        System.out.println("Por favor, elija una opcion valida por favor");
                    }
                }
                switch (opcion) {
                    case 1:
                        Empleado = new empleado();
                        teclado.nextLine();
                        System.out.println("Añada al nuevo empleado");
                        Empleado.leer(teclado);

                        if (empleadosArray.contains(Empleado))
                            System.out.println("El Empelado ya existe");
                        else {
                            empleadosArray.add(new empleado(Empleado));
                            System.out.println("El empleado a sido añadido correctamente");
                            Modificado = true;
                        }
                        break;
                    case 2:
                        int opcion2 = 0;
                        while (opcion2 < 0 || opcion2 > 3) {
                            System.out.println("Que desea añadir");
                            System.out.println("1- Transporte");
                            System.out.println("2- Alojamiento");
                            System.out.println("3- Paquete");
                            System.out.println("opcion:");
                            opcion2 = teclado.nextInt();
                            if (opcion2 < 0 || opcion2 > 3) {
                                System.out.println("Por favor, elija una opcion valida por favor");
                            }
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
                                    Modificado = true;
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
                                    Modificado = true;
                                }
                                break;
                            case 3:
                                Paquete = new paquete();
                                Paquete.leer(teclado);
                                if (paquetesArray.contains(Paquete)) {
                                    System.out.println("El paquete ya existe");
                                } else {
                                    paquetesArray.add(new paquete(Paquete));
                                    System.out.println("El paquete a sido añadido correctamente");
                                    Modificado = true;
                                }
                                break;
                        }

                        break;
                    case 3:
                        for (empleado e : empleadosArray) {
                            e.print();
                        }
                        break;
                    case 4:
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
                        while (opcion2 < 0 || opcion2 > 3) {
                            System.out.println("Que desea ver");
                            System.out.println("1- Transporte");
                            System.out.println("2- Alojamiento");
                            System.out.println("3- Paquete");
                            System.out.println("opcion:");
                            opcion2 = teclado.nextInt();
                            if (opcion2 < 0 || opcion2 > 3) {
                                System.out.println("Por favor, elija una opcion valida por favor");
                            }
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
                    case 6:
                        opcion2 = 0;
                        while (opcion2 < 0 || opcion2 > 3) {
                            System.out.println("Que desea Eliminar");
                            System.out.println("1- Transporte");
                            System.out.println("2- Alojamiento");
                            System.out.println("3- Paquete");
                            System.out.println("opcion:");
                            opcion2 = teclado.nextInt();
                            if (opcion2 < 0 || opcion2 > 3) {
                                System.out.println("Por favor, elija una opcion valida por favor");
                            }
                        }
                        switch (opcion2) {
                            case 1:
                                Transporte = new transporte();
                                System.out.println("Transporte: ");
                                Transporte.leer(teclado);

                                if (transportesArray.remove(Transporte)) {
                                    System.out.println("El elemento ha sido borrado");
                                } else {
                                    System.out.println("El Transporte NO se ha encontrado");
                                }
                                Modificado = true;
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
                                Modificado = true;
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
                                Modificado = true;
                                break;
                        }
                        break;
                }
            } else if (login && !empleado) {
                int opcion2 = 0;
                while (opcion < 0 || opcion > 8) {
                    System.out.println(" 0- Salir del Programa");
                    System.out.println(" 1- Ver Trans/Aloj/Paquete");
                    System.out.println(" 2- hacer una reserva");
                    System.out.println(" 3- Ver reservas");
                    System.out.println(" 4- Cancelar una reserva");
                    System.out.println("Opciones: ");
                    opcion = teclado.nextInt();
                    if (opcion < 0 || opcion > 8) {
                        System.out.println("Por favor, elija una opcion valida valido");
                    }
                }
                switch (opcion) {
                    case 1:
                        opcion2 = 0;
                        while (opcion2 < 0 || opcion2 > 3) {
                            System.out.println("Que desea ver");
                            System.out.println("1- Transporte");
                            System.out.println("2- Alojamiento");
                            System.out.println("3- Paquete");
                            System.out.println("opcion:");
                            opcion2 = teclado.nextInt();
                            if (opcion2 < 0 || opcion2 > 3) {
                                System.out.println("Por favor, elija una opcion valida por favor");
                            }
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
                    
                    opcion2 = 0;
                    while (opcion2 < 0 || opcion2 > 3) {
                            System.out.println("Que quieres reservar?");
                            System.out.println("1- Transporte");
                            System.out.println("2- Alojamiento");
                            System.out.println("3- Paquete");
                            System.out.println("opcion:");
                            opcion2 = teclado.nextInt();
                            if (opcion2 < 0 || opcion2 > 3) {
                                System.out.println("Por favor, elija una opcion valida por favor");
                            }
                        }
                        switch (opcion2) {
                            case 1:
                            Transporte = new transporte();
                            int idtransporte = 0;
                            boolean encontrado =false;
                            String dni = "";
                            double precio = 0;
                            fecha = new Date(0000-00-00);

                                System.out.println("Escribe el id del transporte que desea reservar");
                                idtransporte = teclado.nextInt();
                                for (transporte t : transportesArray) {
                                    if(t.idTransporte == idtransporte){
                                        precio = t.getPrecio();
                                        encontrado = true;
                                    }
                                }
                                if (!encontrado) {
                                    System.err.println("No se a encontrado ningun transporte ");
                                }
                                for (viajero v : viajerosArray) {
                                    if (email.equals(v.getEmail())) {
                                        dni = v.getDNI();
                                        fechaLocalDate = LocalDate.now();
                                        fecha = java.sql.Date.valueOf(fechaLocalDate);
                                    }
                                }
                                reservaTransportes.add(new reservaTransporte(idtransporte, dni, fecha,precio));
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
                }
            }
        } while (opcion > 0);
        teclado.close();
        if (Modificado) {
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                st.executeUpdate("DELETE FROM empleado;");
                String DNI = "";
                String Nombre = "";
                String apellido = "";
                String Email = "";
                String telefono = "";
                String contrasena = "";
                String departamento = "";
                String rol = "";

                for (empleado e : empleadosArray) {
                    DNI = e.getDNI();
                    Nombre = e.getNombre();
                    apellido = e.getApellido();
                    Email = e.getEmail();
                    telefono = e.getTelefono();
                    contrasena = e.getContraseña();
                    departamento = e.getDepartamento();
                    rol = e.getRol();
                    st.executeUpdate("INSERT INTO empleado VALUES ('" + DNI + "','" + Nombre + "','" +
                            apellido + "','" + Email + "','" + telefono + "','" + contrasena + "','" + departamento
                            + "','" + rol + "')");
                }

                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery("DELETE FROM transporte;");
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
                    st.executeUpdate("INSERT INTO empleado VALUES ('" + idTransporte + "','" + precio + "','" +
                            tipo + "','" + destino + "','" + origen + "','" + puntuacion + "','" + extras + "')");
                }
                // cierro la conexion
                rs.close();
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery("DELETE FROM viajero;");
                String DNI = "";
                String Nombre = "";
                String apellido = "";
                String Email = "";
                String telefono = "";
                String contrasena = "";
                int vacunasCOVID = 0;

                for (viajero v : viajerosArray) {
                    DNI = v.getDNI();
                    Nombre = v.getNombre();
                    apellido = v.getApellido();
                    Email = v.getEmail();
                    telefono = v.getTelefono();
                    contrasena = v.getContraseña();
                    vacunasCOVID = v.getVacunasCOVID();
                    st.executeUpdate("INSERT INTO empleado VALUES ('" + DNI + "','" + Nombre + "','" +
                            apellido + "','" + Email + "','" + telefono + "','" + contrasena + "','" + vacunasCOVID
                            + "')");
                }
                // cierro la conexion
                rs.close();
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery("DELETE FROM alojamiento;");
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
                    st.executeUpdate("INSERT INTO empleado VALUES ('" + idAlojamiento + "','" + precio + "','" +
                            tipo + "','" + destino + "','" + puntuacion + "','" + extra + "','" + instalaciones + "')");
                }
                // cierro la conexion
                rs.close();
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery("DELETE FROM paquete;");
                int idPaquete = 0;
                int idTransporte = 0;
                int idAlojamiento = 0;
                double precio = 0;
                for (paquete p : paquetesArray) {
                    idPaquete = p.getIdPaquete();
                    idTransporte = p.getIdTransporte();
                    idAlojamiento = p.getIdAlojamiento();
                    precio = p.getPrecio();
                    st.executeUpdate("INSERT INTO empleado VALUES ('" + idPaquete + "','" + idTransporte + "','" +
                            idAlojamiento + "','" + precio + "')");
                }
                // cierro la conexion
                rs.close();
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(" DELETE FROM reservaalojamiento;");
                int IDAlojamiento = 0;
                String DNI = "";
                Date Fecha = new Date(0000-00-00);
                double precio = 0;
                for (reservaAlojamiento ra : reservaAlojamientos) {
                    IDAlojamiento = ra.getIDAlojamiento();
                    DNI = ra.getDNI();
                    Fecha = ra.getFecha();
                    precio = ra.getPrecio();
                    st.executeUpdate("INSERT INTO empleado VALUES ('" + IDAlojamiento + "','" + DNI + "','" +
                            Fecha + "','" + precio + "')");
                }
                // cierro la conexion
                rs.close();
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery("DELETE FROM reservatransporte;");
                int IDTransporte = 0;
                String DNI = "";
                Date Fecha = new Date(0000-00-00);
                double precio = 0;
                for (reservaTransporte rt : reservaTransportes) {
                    IDTransporte = rt.getIDTransporte();
                    DNI = rt.getDNI();
                    Fecha = rt.getFecha();
                    precio = rt.getPrecio();
                    st.executeUpdate("INSERT INTO empleado VALUES ('" + IDTransporte + "','" + DNI + "','" +
                            Fecha + "','" + precio + "')");
                }
                // cierro la conexion
                rs.close();
                conexion.close();
            } catch (SQLException e) {
                // si NO se ha conectado correctamente
                e.printStackTrace();
                System.out.println("Error de Conexión");
            }
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agenciadeviajes", "root", "");
                // si se ha conectado correctamente
                System.out.println("Conexión Correcta.");
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery("DELETE FROM reservapaquete;");
                int IDPaquete = 0;
                String DNI = "";
                Date Fecha = new Date(0000-00-00);
                double precio = 0;
                for (reservaTransporte rt : reservaTransportes) {
                    IDPaquete = rt.getIDTransporte();
                    DNI = rt.getDNI();
                    Fecha = rt.getFecha();
                    precio = rt.getPrecio();
                    st.executeUpdate("INSERT INTO empleado VALUES ('" + IDPaquete + "','" + DNI + "','" +
                            Fecha + "','" + precio + "')");
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
    }
}
