package TodoElProyecto;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class reservaPaquete {
    protected int IDPaquete;
    protected String DNI;
    protected Date fecha;
    protected double precio;

    public reservaPaquete() {
        this.IDPaquete = 0;
        this.DNI = "";
        this.fecha = new Date(0000-00-00);
        this.precio = 0;
    }

    public reservaPaquete(reservaPaquete r) {
        this.IDPaquete = r.IDPaquete;
        this.DNI = r.DNI;
        this.fecha = r.fecha;
        this.precio = r.precio;
    }

    public reservaPaquete(int i, String d, Date f, double p) {
        this.IDPaquete = i;
        this.DNI = d;
        this.fecha = f;
        this.precio = p;
    }

    public reservaPaquete(int i, String d, double p) {
        this.IDPaquete = i;
        this.DNI = d;
        this.fecha = new Date(0000-00-00);
        this.precio = p;
    }

    public int getIDPaquete() {
        return this.IDPaquete;
    }

    public void setIDPaquete(int IDPaquete) {
        this.IDPaquete = IDPaquete;
    }

    public String getDNI() {
        return this.DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void print() {
        System.out.println("IDPaquete: " + IDPaquete);
        System.out.println("DNI: " + DNI);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formato.format(fecha);
        System.out.println("Fecha: " + fechaString);
        System.out.println("Precio: " + precio);
        System.out.println("****************************");
    }
}
