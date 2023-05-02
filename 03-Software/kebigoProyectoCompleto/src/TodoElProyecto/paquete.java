package TodoElProyecto;

import java.util.Scanner;

/**
 * Constructor para el paquete
 */
public class paquete {
    protected int idPaquete;
    protected int idTransporte;
    protected int idAlojamiento;
    protected double precio;

    public paquete() {
        this.idPaquete = 0;
        this.idTransporte = 0;
        this.idAlojamiento = 0;
        this.precio = 0;
    }

    public paquete(paquete p) {
        this.idPaquete = p.idPaquete;
        this.idTransporte = p.idTransporte;
        this.idAlojamiento = p.idAlojamiento;
        this.precio = p.precio;
    }

    public paquete(int p, int t, int a, double pr) {
        this.idPaquete = p;
        this.idTransporte = t;
        this.idAlojamiento = a;
        this.precio = pr;
    }

    public int getIdPaquete() {
        return this.idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getIdTransporte() {
        return this.idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public int getIdAlojamiento() {
        return this.idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return ("IDPaquete: "+idPaquete+"\n"+"IDTrasporte: "+idTransporte+"\n"+"IDAlojamiento: "+idAlojamiento+"\n"+"Precio: "+precio);
    }
    /**
     * Metodo para pasar toda la informacion por pantalla
     * No devuelven nada
     */
    public void print(){
        System.out.println("IDAlojamiento: "+idPaquete);
        System.out.println("IDAlojamiento: "+idAlojamiento);
        System.out.println("IDAlojamiento: "+idTransporte);
        System.out.println("Precio: "+precio);
        System.out.println("********************************");
    }
    /**
     * Metodo que lee toda la informacion del viajero por teclado
     * @param teclado El parametro teclado define que la informacion será ingresada mediante un Scanner
     */
    public void leer(Scanner teclado){
        System.out.println("Identificador del alojamiento");
        this.idPaquete = teclado.nextInt();
        System.out.println("tipo de alojamiento");
        this.idTransporte = teclado.nextInt();
        System.out.println("Donde Se Ubica El Alojamiento");
        this.idAlojamiento = teclado.nextInt();
        System.out.println("precio?");
        this.precio = teclado.nextInt();
        System.out.println("Se agrego el usuario correctamente");
}

}
