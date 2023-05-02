package TodoElProyecto;

import java.util.Scanner;

/**
 * Constructor para el persona, CLASE abstracta
 */

public abstract class persona {
    protected String DNI;
    

    public persona() {
        this.DNI = "";
    }

    public persona(persona p) {
        this.DNI = p.DNI;
    }

    public persona(String d) {
        this.DNI = d;
    }

    public String getDNI() {
        return this.DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
/**
 * Metodos abstracto de leer y pasar por pantalla (print)
 */
    public abstract void print();
    public abstract void leer(Scanner teclado);

    @Override
    public String toString() {
        return ("Persona:[DNI: "+DNI+"\n");
    }

}

