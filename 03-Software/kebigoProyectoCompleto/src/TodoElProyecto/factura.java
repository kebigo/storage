package TodoElProyecto;
import java.util.ArrayList;

public class factura implements facturacion {
    protected int IDFactura;
    protected String DNI;
    protected FechaT5 fecha;
    protected ArrayList<LineaFactura> lineasfactura = new ArrayList<>();
    protected int total;

    public factura() {
        this.IDFactura = 0;
        this.DNI = "";
        this.fecha = new FechaT5();
        this.lineasfactura = new ArrayList<LineaFactura>();
    }

    public factura(factura f) {
        this.IDFactura = f.IDFactura;
        this.DNI = f.DNI;
        this.fecha = new FechaT5(f.fecha);
        this.lineasfactura = f.lineasfactura;
    }

    public factura(int i, String d, FechaT5 f, int t, ArrayList<LineaFactura> array) {
        this.IDFactura = i;
        this.DNI = d;
        this.fecha = new FechaT5(f);
        this.lineasfactura = array;
    }

    public factura(int i, String d, int t, ArrayList<LineaFactura> array) {
        this.IDFactura = i;
        this.DNI = d;
        this.fecha = new FechaT5();
        this.lineasfactura = array;
    }

    public void añadirLinea(String Codigo, double Total) {
        lineasfactura.add(new LineaFactura(Codigo, Total));
    }

    public void print() {
        System.out.println();
        System.out.println("**********************************************************");
        System.out.println("IDFactura: " + IDFactura);
        System.out.println("DNI: " + DNI);
        System.out.println("Fecha: " + fecha);

        for (LineaFactura l : lineasfactura) {
            System.out.println(l);
        }
        System.out.println(calcularTotal());
        System.out.println("**********************************************************");
    }

    @Override
    public double calcularTotal() {
        double totalLinea = 0;
        for (int i = 0; i < lineasfactura.size(); i++) {

            totalLinea = +lineasfactura.get(i).totalLinea;

        }
        double total = totalLinea + (totalLinea * IVA);
        return total;
    }

    public int getIDFactura() {
        return this.IDFactura;
    }

    public void setIDFactura(int IDFactura) {
        this.IDFactura = IDFactura;
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
        this.fecha = fecha;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
