package TodoElProyecto;
import java.util.Scanner;

public class viajero extends persona {
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String telefono;
    protected String Contraseña;
    protected int vacunasCOVID;

    public viajero() {
        super();
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = "";
        this.Contraseña = "";
        this.vacunasCOVID = 0;
    }

    public viajero(viajero v) {
        super(v);
        this.nombre = v.nombre;
        this.apellido = v.apellido;
        this.email = v.email;
        this.telefono = v.telefono;
        this.Contraseña = v.Contraseña;
        this.vacunasCOVID = v.vacunasCOVID;
    }

    public viajero(String d, String n, String a, String e, String t, String c, int v) {
        super(d);
        this.nombre = n;
        this.apellido = a;
        this.email = e;
        this.telefono = t;
        this.Contraseña = c;
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

    public String getContraseña() {
        return this.Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    @Override
    public void print() {
        System.out.println(super.toString()+ "Nombre: " + nombre + "\n" +
        "Apellido: " + apellido + "\n" + "Email: " + email + "\n" + "Telefono: " + telefono + "\n" + "vacunasCOVID: " + vacunasCOVID + "]");
        System.out.println("**********************************************");
    }

    @Override
    public void leer(Scanner teclado) {
        System.out.println("Nombre viajero");
        this.nombre = teclado.nextLine().toLowerCase();
    }

}