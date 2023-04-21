package TodoElProyecto;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class reservaAlojamiento {
    protected int IDAlojamiento;
    protected String DNI;
    protected Date fecha;
    protected double precio;

    public reservaAlojamiento() {
        this.IDAlojamiento = 0;
        this.DNI = "";
        this.fecha = new Date(0000-00-00);
        this.precio = 0;
    }

    public reservaAlojamiento(reservaAlojamiento r) {
        this.IDAlojamiento = r.IDAlojamiento;
        this.DNI = r.DNI;
        this.fecha = r.fecha;
        this.precio = r.precio;
    }

    public reservaAlojamiento(int i, String d, Date f, double p) {
        this.IDAlojamiento = i;
        this.DNI = d;
        this.fecha = f;
        this.precio = p;
    }

    public reservaAlojamiento(int i, String d, double p) {
        this.IDAlojamiento = i;
        this.DNI = d;
        this.fecha = new Date(0000-00-00);
        this.precio = p;
    }

    public int getIDAlojamiento() {
        return this.IDAlojamiento;
    }

    public void setIDAlojamiento(int IDAlojamiento) {
        this.IDAlojamiento = IDAlojamiento;
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
        System.out.println("IDAlojamiento: " + IDAlojamiento);
        System.out.println("DNI: " + DNI);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formato.format(fecha);
        System.out.println("Fecha: " + fechaString);
        System.out.println("Precio : " + precio);
    }
}
