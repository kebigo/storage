package TodoElProyecto;

public class reservaPaquete {
    protected int IDPaquete;
    protected String DNI;
    protected FechaT5 fecha;
    protected double precio;

    public reservaPaquete() {
        this.IDPaquete = 0;
        this.DNI = "";
        this.fecha = new FechaT5();
        this.precio = 0;
    }

    public reservaPaquete(reservaPaquete r) {
        this.IDPaquete = r.IDPaquete;
        this.DNI = r.DNI;
        this.fecha = new FechaT5(r.fecha);
        this.precio = r.precio;
    }

    public reservaPaquete(int i, String d, FechaT5 f, double p) {
        this.IDPaquete = i;
        this.DNI = d;
        this.fecha = new FechaT5(f);
        this.precio = p;
    }

    public reservaPaquete(int i, String d, double p) {
        this.IDPaquete = i;
        this.DNI = d;
        this.fecha = new FechaT5();
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

    public FechaT5 getFecha() {
        return this.fecha;
    }

    public void setFecha(FechaT5 fecha) {
        this.fecha = new FechaT5(fecha);
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
        System.out.println("Fecha: " + fecha);
        System.out.println("Precio: " + precio);
        System.out.println("****************************");
    }
}
