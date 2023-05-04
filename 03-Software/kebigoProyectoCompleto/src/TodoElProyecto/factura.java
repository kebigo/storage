package TodoElProyecto;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Constructor para el factura
 */

public class factura implements facturacion, Serializable {
    protected int IDFactura;
    protected String DNI;
    protected String fecha;
    protected ArrayList<LineaFactura> lineasfactura = new ArrayList<>();
    protected double total;

    public factura() {
        this.IDFactura = 0;
        this.DNI = "";
        this.fecha = "";
        this.lineasfactura = new ArrayList<LineaFactura>();
    }

    public factura(factura f) {
        this.IDFactura = f.IDFactura;
        this.DNI = f.DNI;
        this.fecha = f.fecha;
        this.lineasfactura = f.lineasfactura;
    }

    public factura(int i, String d, String f, ArrayList<LineaFactura> array) {
        this.IDFactura = i;
        this.DNI = d;
        this.fecha = f;
        this.lineasfactura = array;
    }

    public factura(int i, String d, int t, ArrayList<LineaFactura> array) {
        this.IDFactura = i;
        this.DNI = d;
        this.fecha = "";
        this.lineasfactura = array;
    }
/**
 * Metodo que agrega el codigo del producto y el precio total de este
 * @param Codigo Recoge un int para añadirlo como codigo
 * @param Total Recoge el total de la suma del precio para agregarlo a la factura
 */
    public void anadirLinea(int Codigo, double Total) {
        lineasfactura.add(new LineaFactura(Codigo, Total));
    }
    /**
     * Metodo para sacar por pantalla la informacion de la factura
     */
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
    /**
     * Metodo que calcula el total de la factura
     * @return total Devuelve el total de las operaciones junto al iva
     */
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

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
