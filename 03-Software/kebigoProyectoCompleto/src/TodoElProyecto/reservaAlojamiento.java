package TodoElProyecto;


/**
 * Constructor para el reserva de alojamiento
 */
public class reservaAlojamiento {
    protected int IDAlojamiento;
    protected String DNI;
    protected String fecha;
    protected double precio;

    public reservaAlojamiento() {
        this.IDAlojamiento = 0;
        this.DNI = "";
        this.fecha = "";
        this.precio = 0;
    }

    public reservaAlojamiento(reservaAlojamiento r) {
        this.IDAlojamiento = r.IDAlojamiento;
        this.DNI = r.DNI;
        this.fecha = r.fecha;
        this.precio = r.precio;
    }

    public reservaAlojamiento(int i, String d, String f, double p) {
        this.IDAlojamiento = i;
        this.DNI = d;
        this.fecha = f;
        this.precio = p;
    }

    public reservaAlojamiento(int i, String d, double p) {
        this.IDAlojamiento = i;
        this.DNI = d;
        this.fecha = "";
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

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Metodo que pasa toda la informacion del viajero por pantalla
     */
    public void print() {
        System.out.println("IDAlojamiento: " + IDAlojamiento);
        System.out.println("DNI: " + DNI);
        System.out.println("Fecha: " + fecha);
        System.out.println("Precio : " + precio);
    }
}
