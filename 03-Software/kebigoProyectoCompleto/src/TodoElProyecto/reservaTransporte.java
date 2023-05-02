package TodoElProyecto;


/**
 * Constructor para el reservaTransporte
 */
public class reservaTransporte {
    protected int IDTransporte;
    protected String DNI;
    protected String fecha;
    protected double precio;

    public reservaTransporte() {
        this.IDTransporte = 0;
        this.DNI = "";
        this.fecha = "";
        this.precio = 0;
    }

    public reservaTransporte(reservaTransporte r) {
        this.IDTransporte = r.IDTransporte;
        this.DNI = r.DNI;
        this.fecha = r.fecha;
        this.precio = r.precio;
    }

    public reservaTransporte(int i, String d, String f, double p) {
        this.IDTransporte = i;
        this.DNI = d;
        this.fecha = f;
        this.precio = p;
    }

    public reservaTransporte(int i, String d, double p) {
        this.IDTransporte = i;
        this.DNI = d;
        this.fecha = "";
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
        System.out.println("IDTransporte: " + IDTransporte);
        System.out.println("DNI: " + DNI);
        System.out.println("Fecha: " + fecha);
        System.out.println("Precio : " + precio);
    }
}