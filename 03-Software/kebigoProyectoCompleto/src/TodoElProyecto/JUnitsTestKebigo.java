package TodoElProyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class JUnitsTestKebigo {
Scanner teclado = new Scanner(System.in);
	@Test
	void testEsAdministrador() {
		empleado e = new empleado("11111111A","Kevin", "Patiño", "saikonogameryt@gmail.com", "+34666666666", "patata", "informatica", "administrador");
		boolean estrue = e.esAdministrador(e);
		assertTrue(estrue);
		empleado a = new empleado("11111111A","Kevin", "Patiño", "saikonogameryt@gmail.com", "+34666666666", "patata", "informatica", "empleado");
		boolean esfalse = e.esAdministrador(a);
		assertFalse(esfalse);
		empleado c = new empleado(a);
		assertTrue(c instanceof empleado);
		assertEquals(c.getDNI(), a.getDNI());
	}
	@Test
	void testgetterssetters() {
		empleado e = new empleado();
		e.setDNI("11111111A");
		e.setNombre("Kevin");
		e.setApellido("Patiño");
		e.setEmail("saikono@gmail.com");
		e.setContrasena("patata");
		e.setTelefono("+34666666666");
		e.setDepartamento("informatica");
		e.setRol("administrador");
		assertEquals("11111111A",e.getDNI());
		assertEquals("Kevin",e.getNombre());
		assertEquals("Patiño",e.getApellido());
		assertEquals("saikono@gmail.com",e.getEmail());
		assertEquals("patata",e.getContrasena());
		assertEquals("+34666666666",e.getTelefono());
		assertEquals("informatica",e.getDepartamento());
		assertEquals("administrador",e.getRol());
	}
	@Test
	void test() {
		empleado a = new empleado("11111111A","Kevin", "Patiño", "saikonogameryt@gmail.com", "+34666666666", "patata", "informatica", "empleado");
		empleado c = new empleado();
		a.print();
		assertNotNull(c);
	}

}
