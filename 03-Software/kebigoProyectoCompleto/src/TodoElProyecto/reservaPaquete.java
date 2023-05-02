package TodoElProyecto;


/**
 * Constructor para el reservaPaquete
 */
public class reservaPaquete {
    protected int IDPaquete;
    protected String DNI;
    protected String fecha;
    protected double precio;

    public reservaPaquete() {
        this.IDPaquete = 0;
        this.DNI = "";
        this.fecha = "";
        this.precio = 0;
    }

    public reservaPaquete(reservaPaquete r) {
        this.IDPaquete = r.IDPaquete;
        this.DNI = r.DNI;
        this.fecha = r.fecha;
        this.precio = r.precio;
    }

    public reservaPaquete(int i, String d, String f, double p) {
        this.IDPaquete = i;
        this.DNI = d;
        this.fecha = f;
        this.precio = p;
    }

    public reservaPaquete(int i, String d, double p) {
        this.IDPaquete = i;
        this.DNI = d;
        this.fecha = "";
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
        System.out.println("IDPaquete: " + IDPaquete);
        System.out.println("DNI: " + DNI);
        System.out.println("Fecha: " + fecha);
        System.out.println("Precio: " + precio);
        System.out.println("****************************");
    }
}
