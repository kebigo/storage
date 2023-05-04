package TodoElProyecto;
import java.util.Scanner;
/**
 * Constructor para el viajero
 */
public class viajero extends persona {
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String telefono;
    protected String Contrasena;
    protected int vacunasCOVID;

    /**
     * Constructor para la inforamacion sobre el usuario viajero
     */
    public viajero() {
        super();
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = "";
        this.Contrasena = "";
        this.vacunasCOVID = 0;
    }

    public viajero(viajero v) {
        super(v);
        this.nombre = v.nombre;
        this.apellido = v.apellido;
        this.email = v.email;
        this.telefono = v.telefono;
        this.Contrasena = v.Contrasena;
        this.vacunasCOVID = v.vacunasCOVID;
    }

    public viajero(String d, String n, String a, String e, String t, String c, int v) {
        super(d);
        this.nombre = n;
        this.apellido = a;
        this.email = e;
        this.telefono = t;
        this.Contrasena = c;
        this.vacunasCOVID = v;
    }

    public int getVacunasCOVID() {
        return this.vacunasCOVID;
    }

    public void setVacunasCOVID(int vacunasCOVID) {
        this.vacunasCOVID = vacunasCOVID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return this.Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    @Override
    /**
     * Metodo que pasa toda la informacion del viajero por pantalla
     */
    public void print() {
        System.out.println(super.toString()+ "Nombre: " + nombre + "\n" +
        "Apellido: " + apellido + "\n" + "Email: " + email + "\n" + "Telefono: " + telefono + "\n" + "vacunasCOVID: " + vacunasCOVID + "]");
        System.out.println("**********************************************");
    }
    /**
     * Metodo que lee toda la informacion del viajero por teclado
     * @param teclado El parametro teclado define que la informacion será ingresada mediante un Scanner
     */
    @Override
    public void leer(Scanner teclado) {
        teclado.nextLine();
        System.out.println("DNI");
        this.DNI = teclado.nextLine().toUpperCase();
        System.out.println("Nombre viajero");
        this.nombre = teclado.nextLine().toLowerCase();
        System.out.println("Apellido viajero");
        this.apellido = teclado.nextLine().toLowerCase();
        System.out.println("Email viajero");
        this.email = teclado.nextLine().toLowerCase();
        System.out.println("Constraseña viajero");
        this.Contrasena = teclado.nextLine();
        System.out.println("Telefono viajero");
        this.telefono = teclado.nextLine().toLowerCase();
        System.out.println("VacunasCOVID viajero");
        this.vacunasCOVID = teclado.nextInt();
    }

}