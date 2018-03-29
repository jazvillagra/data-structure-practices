import static org.junit.Assert.*;

import org.junit.Test;

public class ValidacionAntesDeEntregar {

	private CalculoStock cs = new CalculoStockImpl();
	
	@Test
	public void pruebaCaso1() {
		String[] listaLibros = new String[] {"ABCDE 20", "CDFEG 50", "BXYZQ 25", "BTSQZ 89", "DFGHJ 60"};
		String[] listaPrimerasLetras = new String[] {"A", "B", "C", "W"};
		String listaResultado = cs.resumenStockLibreria(listaLibros, listaPrimerasLetras);
		assertEquals("(A : 20) - (B : 114) - (C : 50) - (W : 0)", listaResultado);
	}
	
	@Test
	public void pruebaCaso2() {
		String[] listaLibros = new String[] {};
		String[] listaPrimerasLetras = new String[] {"A", "B", "C", "W"};
		String listaResultado = cs.resumenStockLibreria(listaLibros, listaPrimerasLetras);
		assertEquals("", listaResultado);
	}
	
	@Test
	public void pruebaCaso3() {
		String[] listaLibros = new String[] {"ABCDE 20", "CDFEG 50", "BXYZQ 25", "BTSQZ 89", "DFGHJ 60"};
		String[] listaPrimerasLetras = new String[] {};
		String listaResultado = cs.resumenStockLibreria(listaLibros, listaPrimerasLetras);
		assertEquals("", listaResultado);
	}
	
	@Test
	public void pruebaCaso4() {
		String[] listaLibros = null;
		String[] listaPrimerasLetras = new String[] {"A", "B", "C", "W"};
		String listaResultado = cs.resumenStockLibreria(listaLibros, listaPrimerasLetras);
		assertEquals("", listaResultado);
	}
	
	@Test
	public void pruebaCaso5() {
		String[] listaLibros = new String[] {"ABCDE 20", "CDFEG 50", "BXYZQ 25", "BTSQZ 89", "DFGHJ 60"};
		String[] listaPrimerasLetras = null;
		String listaResultado = cs.resumenStockLibreria(listaLibros, listaPrimerasLetras);
		assertEquals("", listaResultado);
	}

	@Test
	public void pruebaCaso6() {
		String[] listaLibros = null;
		String[] listaPrimerasLetras = null;
		String listaResultado = cs.resumenStockLibreria(listaLibros, listaPrimerasLetras);
		assertEquals("", listaResultado);
	}
	
	@Test
	public void pruebaCaso7() {
		String[] listaLibros = new String[] {"ABCDE 00", "CDFEG 00", "BXYZQ 00", "BTSQZ 00", "DFGHJ 00"};
		String[] listaPrimerasLetras = new String[] {"A", "B", "C", "W"};
		String listaResultado = cs.resumenStockLibreria(listaLibros, listaPrimerasLetras);
		assertEquals("(A : 0) - (B : 0) - (C : 0) - (W : 0)", listaResultado);		
	}	
	
	@Test
	public void pruebaCaso8() {
		ListaEnlazada l = new ListaEnlazada();
		l.agregarElemento("A", 30L);
		l.agregarElemento("A", 20L);
		l.agregarElemento("A", 10L);
		assertEquals(new Long(30), l.recuperarElemento("A"));
	}
	
	@Test
	public void pruebaCaso9() {
		ListaEnlazada l = new ListaEnlazada();
		l.agregarElemento("A", 20L);
		l.agregarElemento("A", 10L);
		l.agregarElemento("B", 10L);
		l.agregarElemento("C", 10L);
		assertEquals(new Long(20), l.recuperarElemento("A"));
		assertEquals(new Long(10), l.recuperarElemento("B"));
		assertEquals(new Long(10), l.recuperarElemento("C"));
	}
	
	@Test
	public void pruebaCaso10() {
		ListaEnlazada l = new ListaEnlazada();
		l.agregarElemento("A", 10L);
		assertNull(l.recuperarElemento("B"));		
	}
		
}
