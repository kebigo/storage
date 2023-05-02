package TodoElProyecto;

import java.util.Scanner;

/**
 * Constructor para el alojamiento
 */
public class alojamiento {
    protected int idAlojamiento;
    protected double precio;
    protected String tipo;
    protected String destino;
    protected int puntuacion;
    protected String extra;
    protected String instalaciones;

    public alojamiento() {
        this.idAlojamiento = 0;
        this.precio = 0;
        this.tipo = "";
        this.destino = "";
        this.puntuacion = 0;
        this.extra = "";
        this.instalaciones = "";
    }

    public alojamiento(alojamiento a) {
        this.idAlojamiento = a.idAlojamiento;
        this.precio = a.precio;
        this.tipo = a.tipo;
        this.destino = a.destino;
        this.puntuacion = a.puntuacion;
        this.extra = a.extra;
        this.instalaciones = a.instalaciones;
    }

    public alojamiento(int i, double p, String t, String d, int pu, String e, String in) {
        this.idAlojamiento = i;
        this.precio = p;
        this.tipo = t;
        this.destino = d;
        this.puntuacion = pu;
        this.extra = e;
        this.instalaciones = in;
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

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getInstalaciones() {
        return this.instalaciones;
    }

    public void setInstalaciones(String instalaciones) {
        this.instalaciones = instalaciones;
    }
    /**
     * Metodo para pasar toda la informacion por pantalla
     * No devuelven nada
     */
    public void print(){
        System.out.println("IDAlojamiento: "+idAlojamiento);
        System.out.println("Tipo: "+tipo);
        System.out.println("Destino: "+destino);
        System.out.println("Puntuación: "+puntuacion);
        System.out.println("Instalaciones: "+instalaciones);
        System.out.println("Extras: "+extra);
        System.out.println("Precio: "+precio);
        System.out.println("********************************");
    }
    /**
     * Metodo que lee toda la informacion del viajero por teclado
     * @param teclado El parametro teclado define que la informacion será ingresada mediante un Scanner
     */
    public void leer(Scanner teclado){
        System.out.println("Identificador del alojamiento");
        this.idAlojamiento = teclado.nextInt();
        teclado.nextLine();
        System.out.println("tipo de alojamiento");
        this.tipo = teclado.nextLine().toLowerCase();
        System.out.println("Donde Se Ubica El Alojamiento");
        this.destino = teclado.nextLine().toLowerCase();
        System.out.println("Que extras contiene?");
        this.extra = teclado.nextLine().toLowerCase();
        System.out.println("precio?");
        this.precio = teclado.nextInt();
        System.out.println("Se agrego el usuario correctamente");
}
}
