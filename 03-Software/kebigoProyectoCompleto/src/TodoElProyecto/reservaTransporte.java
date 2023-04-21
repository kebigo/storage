package TodoElProyecto;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class reservaTransporte {
    protected int IDTransporte;
    protected String DNI;
    protected Date fecha;
    protected double precio;

    public reservaTransporte() {
        this.IDTransporte = 0;
        this.DNI = "";
        this.fecha = new Date(0000-00-00);
        this.precio = 0;
    }

    public reservaTransporte(reservaTransporte r) {
        this.IDTransporte = r.IDTransporte;
        this.DNI = r.DNI;
        this.fecha = r.fecha;
        this.precio = r.precio;
    }

    public reservaTransporte(int i, String d, Date f, double p) {
        this.IDTransporte = i;
        this.DNI = d;
        this.fecha = f;
        this.precio = p;
    }

    public reservaTransporte(int i, String d, double p) {
        this.IDTransporte = i;
        this.DNI = d;
        this.fecha = new Date(0000-00-00);
        this.precio = p;
    }

    public int getIDTransporte() {
        return this.IDTransporte;
    }

    public void setIDTransporte(int IDTransporte) {
        this.IDTransporte = IDTransporte;
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
        System.out.println("IDTransporte: " + IDTransporte);
        System.out.println("DNI: " + DNI);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formato.format(fecha);
        System.out.println("Fecha: " + fechaString);
        System.out.println("Precio : " + precio);
    }
}