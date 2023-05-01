package TodoElProyecto;
import java.util.Scanner;

public class transporte {
    protected int idTransporte;
    protected double precio;
    protected String tipo;
    protected String destino;
    protected String origen;
    protected int puntuacion;
    protected String extras;

    public transporte() {
        this.idTransporte = 0;
        this.precio = 0;
        this.tipo = "";
        this.destino = "";
        this.origen = "";
        this.puntuacion = 0;
        this.extras = "";
    }

    public transporte(transporte t) {
        this.idTransporte = t.idTransporte;
        this.precio = t.precio;
        this.tipo = t.tipo;
        this.destino = t.destino;
        this.origen = t.origen;
        this.puntuacion = t.puntuacion;
        this.extras = t.extras;
    }

    public transporte(int i, double p, String t, String d, String o, int pu, String e) {
        this.idTransporte = i;
        this.precio = p;
        this.tipo = t;
        this.destino = d;
        this.origen = o;
        this.puntuacion = pu;
        this.extras = e;
    }

    public int getIdTransporte() {
        return this.idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getExtras() {
        return this.extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }
    public void print(){
        System.out.println("IDTransporte: "+idTransporte);
        System.out.println("Tipo: "+tipo);
        System.out.println("Origen: "+origen);
        System.out.println("Destino: "+destino);
        System.out.println("Extras: "+puntuacion);
        System.out.println("Extras: "+extras);
        System.out.println("Precio: "+precio);
        System.out.println("*****************************");
    }
    public void leer(Scanner teclado){
            System.out.println("Identificador del transporte");
            this.idTransporte = teclado.nextInt();
            teclado.nextLine();
            System.out.println("tipo de transporte");
            this.tipo = teclado.nextLine().toLowerCase();
            System.out.println("origen de viaje");
            this.origen = teclado.nextLine().toLowerCase();
            System.out.println("destino de viaje");
            this.destino = teclado.nextLine().toLowerCase();
            System.out.println("Que extras contiene?");
            this.extras = teclado.nextLine().toLowerCase();
            System.out.println("Que puntuacion contiene?");
            this.puntuacion = teclado.nextInt();
            System.out.println("precio?");
            this.precio = teclado.nextInt();
            System.out.println("Se agrego el transporte correctamente");
            /*
             * TryAndCatch
             */
    }
    
}