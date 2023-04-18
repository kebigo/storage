package TodoElProyecto;

public class reservaTransporte {
    protected int IDTransporte;
    protected String DNI;
    protected FechaT5 fecha;
    protected double precio;

    public reservaTransporte() {
        this.IDTransporte = 0;
        this.DNI = "";
        this.fecha = new FechaT5();
        this.precio = 0;
    }

    public reservaTransporte(reservaTransporte r) {
        this.IDTransporte = r.IDTransporte;
        this.DNI = r.DNI;
        this.fecha = new FechaT5(r.fecha);
        this.precio = r.precio;
    }

    public reservaTransporte(int i, String d, FechaT5 f, double p) {
        this.IDTransporte = i;
        this.DNI = d;
        this.fecha = new FechaT5(f);
        this.precio = p;
    }

    public reservaTransporte(int i, String d, double p) {
        this.IDTransporte = i;
        this.DNI = d;
        this.fecha = new FechaT5();
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
        System.out.println("IDTransporte: " + IDTransporte);
        System.out.println("DNI: " + DNI);
        System.out.println("Fecha: " + fecha);
        System.out.println("Precio : " + precio);
    }
}