package TodoElProyecto;

public class agenciaMain {
    import java.sql.*;
    import java.util.ArrayList;
    import java.util.Scanner;
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
                    idTransporte = (int) rs.getObject("DNI");
                    precio = (double) rs.getObject("nombre");
                    tipo = (String) rs.getObject("apellido");
                    destino = (String) rs.getObject("email");
                    origen = (String) rs.getObject("telefono");
                    puntuacion = (int) rs.getObject("contrasena");
                    extras = (String) rs.getObject("departamento");
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
                    idAlojamiento = (int) rs.getObject("DNI");
                    precio = (double) rs.getObject("nombre");
                    tipo = (String) rs.getObject("apellido");
                    destino = (String) rs.getObject("email");
                    puntuacion = (int) rs.getObject("telefono");
                    extra = (String) rs.getObject("contrasena");
                    instalaciones = (String) rs.getObject("departamento");
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
                    idPaquete = (int) rs.getObject("DNI");
                    idTransporte = (int) rs.getObject("nombre");
                    idAlojamiento = (int) rs.getObject("apellido");
                    precio = (double) rs.getObject("email");
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
            FechaT5 fecha = new FechaT5();
            double precio = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    IDAlojamiento = (int) rs.getObject("DNI");
                    DNI = (String) rs.getObject("nombre");
                    fecha = (FechaT5) rs.getObject("apellido");
                    precio = (double) rs.getObject("email");
                    reservaAlojamientos.add(new reservaAlojamiento(IDAlojamiento, DNI, fecha, precio));
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
            FechaT5 fecha = new FechaT5();
            double precio = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    IDTransporte = (int) rs.getObject("DNI");
                    DNI = (String) rs.getObject("nombre");
                    fecha = (FechaT5) rs.getObject("apellido");
                    precio = (double) rs.getObject("email");
                    reservaTransportes.add(new reservaTransporte(IDTransporte, DNI, fecha, precio));
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
            FechaT5 fecha = new FechaT5();
            double precio = 0;
            if (rs.first()) {
                // si hay registros
                // vuelvo al primero
                rs.beforeFirst();
                // recorro registro a registro el ResultSet
                while (rs.next()) {
                    IDPaquete = (int) rs.getObject("DNI");
                    DNI = (String) rs.getObject("nombre");
                    fecha = (FechaT5) rs.getObject("apellido");
                    precio = (double) rs.getObject("email");
                    reservaPaquetes.add(new reservaPaquete(IDPaquete, DNI, fecha, precio));
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
}
