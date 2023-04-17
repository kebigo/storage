package TodoElProyecto;

public class reservaAlojamiento {
    protected int IDAlojamiento;
    protected String DNI;
    protected FechaT5 fecha;
    protected double precio;

    public reservaAlojamiento(){
        this.IDAlojamiento = 0;
        this.DNI = "";
        this.fecha = new FechaT5();
        this.precio = 0;
    }
    public reservaAlojamiento(reservaAlojamiento r){
        this.IDAlojamiento = r.IDAlojamiento;
        this.DNI = r.DNI;
        this.fecha = new FechaT5(r.fecha);
        this.precio = r.precio;
    }
    public reservaAlojamiento(int i, String d, FechaT5 f, double p){
        this.IDAlojamiento = i;
        this.DNI = d;
        this.fecha = new FechaT5(f);
        this.precio = p;
    }
    public reservaAlojamiento(int i, String d, double p){
        this.IDAlojamiento = i;
        this.DNI = d;
        this.fecha = new FechaT5();
        this.precio = p;
    }
    public void print(){
        System.out.println("IDAlojamiento: "+IDAlojamiento);
        System.out.println("DNI: "+DNI);
        System.out.println("Fecha: "+fecha);
        System.out.println("Precio : "+precio);
    }
}
