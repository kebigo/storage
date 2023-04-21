package TodoElProyecto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;


public class prueba {
    public static void main(String[] args) {
        LocalDate fechaLocalDate = LocalDate.now();
        Date fecha = java.sql.Date.valueOf(fechaLocalDate);
        Date fehchaa = fecha;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaLocalDate.format(formato);
        System.out.println(fechaFormateada);
        System.out.println(
        fehchaa
        );
    }
}
