package TodoElProyecto;

    import java.util.Scanner;

public class empleado extends persona {
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String telefono;
    protected String Contraseña;
    protected String departamento;
    protected String rol;

    public empleado() {
        super();
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = "";
        this.Contraseña = "";
        this.departamento = "";
        this.rol = "";
    }

    public empleado(empleado e) {
        super(e);
        this.nombre = e.nombre;
        this.apellido = e.apellido;
        this.email = e.email;
        this.telefono = e.telefono;
        this.Contraseña = e.Contraseña;
        this.departamento = e.departamento;
        this.rol = e.rol;
    }

    public empleado(String d, String n, String a, String e, String t, String c, String de, String r) {
        super(d);
        this.nombre = n;
        this.apellido = a;
        this.email = e;
        this.telefono = t;
        this.Contraseña = c;
        this.departamento = de;
        this.rol = r;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return this.Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    @Override
    public void print() {
        System.out.println(super.toString() + "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" + "Email: " + email + "\n" + "Telefono: " + telefono + "\n"
                +"Contraseña"+Contraseña+"\n"+ "Departamento: " + departamento + "\n" + "Rol" + rol + "]");
        System.out.println("**********************************************");
    }

    @Override
    public void leer(Scanner teclado) {
        System.out.println("Nombre empelado");
        this.nombre = teclado.nextLine().toLowerCase();
        System.out.println("Apellido empleado");
        this.apellido = teclado.nextLine().toLowerCase();
        System.out.println("Email");
        this.email = teclado.nextLine().toLowerCase();
        System.out.println("Telefono");
        this.telefono = teclado.nextLine().toLowerCase();
        String Contraseña1,Contraseña2;
        boolean Coincide = false;
        while (Contraseña.isEmpty() || !Coincide) {
            System.out.println("Contraseña Usuario");
            Contraseña1 = teclado.next();
            if (!Contraseña1.isEmpty()) {
                System.out.println("Escriba de nuevo su contraseña");
                Contraseña2 = teclado.next();
                if (Contraseña1.equals(Contraseña2)) {
                    System.out.println("Se ha agregado su contraseña correctamente");
                    this.Contraseña = Contraseña1;
                    Coincide = true;
                }
                else{
                    System.out.println("La contraseña no coincide");
                    System.out.println("Vuelva a intentarlo");;
                    Coincide = false;
                    Contraseña1 = "";
                    Contraseña2 = "";
                }
            }
        }
        System.out.println("En que departamento trabaja?");
        this.departamento = teclado.nextLine().toLowerCase();
        System.out.println("Que rol toma?");
        this.rol = teclado.nextLine().toLowerCase();
        System.out.println("Se agrego el usuario correctamente");
    }
}
