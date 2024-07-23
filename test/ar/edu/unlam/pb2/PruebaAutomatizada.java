package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class PruebaAutomatizada {

	@Test
	public void queSePuedaCrearUnaFigurita() {
		Figurita figurita1 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		Integer codigoEsperado = 22;
		String grupoEsperado = "A";
		String seleccionEsperada = "Argentina";
		String jugadorEsperado = "Lautaro Martinez";
		Double valorEsperado = 35000.0;
		assertEquals(codigoEsperado, figurita1.getCodigo());
		assertEquals(grupoEsperado, figurita1.getLetraGrupo());
		assertEquals(seleccionEsperada, figurita1.getSeleccion());
		assertEquals(jugadorEsperado, figurita1.getNombreJugador());
		assertEquals(valorEsperado, figurita1.getValorDelJugador());
	}
	
	@Test
	public void queSePuedaCrearUnAdministrador() {
		Usuario admin = new Administrador("Agustin", 21, 43453523);
		String adminNombre = "Agustin";
		Integer edadAdmin = 21;
		Integer dniAdmin = 43453523;
		assertEquals(adminNombre, admin.getNombre());
		assertEquals(edadAdmin, admin.getEdad());
		assertEquals(dniAdmin, admin.getDni());
	}
	
	@Test
	public void queSePuedaCrearUnUsuarioFinal() {
		Usuario userFinal = new UsuarioFinal("Simon", 6, 42342321);
		String userNombre = "Simon";
		Integer edadUser = 6;
		Integer dniUser = 42342321;
		assertEquals(userNombre, userFinal.getNombre());
		assertEquals(edadUser, userFinal.getEdad());
		assertEquals(dniUser, userFinal.getDni());
	}
	
	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() {
		Usuario admin = new Administrador("Agustin", 21, 43453523);
		Figurita figurita1 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		Boolean agregarFigurita = admin.agregarFigurita(figurita1);
		Integer figuritasEsperadas = 1;
		assertTrue(agregarFigurita);
		assertEquals(figuritasEsperadas, admin.cantidadDeFiguritas());
	}
	
	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() {
		Usuario userFinal = new UsuarioFinal("Simon", 6, 42342321);
		Figurita figurita2 = new Figurita(10, "A", "Argentina", "Lionel Messi", 90000.0);
		Boolean agregarFigurita = userFinal.agregarFigurita(figurita2);
		Integer figuritasEsperadas = 1;
		assertTrue(agregarFigurita);
		assertEquals(figuritasEsperadas, userFinal.cantidadDeFiguritas());
	}
	
	@Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() {
		Sistema principal = new Sistema();
		Figurita figurita1 = new Figurita(10, "A", "Argentina", "Lionel Messi", 90000.0);
		Figurita figurita2 = new Figurita(9, "D", "Brasil", "Vinicius", 95000.0);
		Figurita figurita3 = new Figurita(20, "B", "Venezuela", "Valencia", 8000.0);
		principal.agregarFigurita(figurita1);
		principal.agregarFigurita(figurita2);
		principal.agregarFigurita(figurita3);
		TreeSet<Figurita> figuritasOrdenadasPorCodigo = principal.devolverFiguritasOrdenadosPorCodigo();
		TreeSet<Figurita> figuritasOrdenadasPorGrupo = principal.devolverFiguritasOrdenadosPorGrupo();
		TreeSet<Figurita> figuritasOrdenadasPorSeleccion = principal.devolverFiguritasOrdenadosPorSeleccion();
		assertEquals(figurita2, figuritasOrdenadasPorCodigo.first());
		assertEquals(figurita3, figuritasOrdenadasPorCodigo.last());
		assertEquals(figurita1, figuritasOrdenadasPorSeleccion.first());
		assertEquals(figurita3, figuritasOrdenadasPorSeleccion.last());
		assertEquals(figurita1, figuritasOrdenadasPorGrupo.first());
		assertEquals(figurita2, figuritasOrdenadasPorGrupo.last());
	}
	
	@Test (expected = CodigoExistenteException.class)
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws CodigoExistenteException {
		Administrador admin = new Administrador("Agustin", 21, 43453523);
		Figurita figurita1 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		Figurita figurita2 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		Boolean agregarFigurita1 = admin.darDeAltaCodigo(figurita1, figurita2);
		assertTrue(agregarFigurita1);
	}
	
	@Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() {
		Usuario userFinal = new UsuarioFinal("Simon", 6, 42342321);
		Figurita figurita1 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		Figurita figurita2 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		Boolean agregarFigurita1 = userFinal.agregarFigurita(figurita1);
		Boolean agregarFigurita2 = userFinal.agregarFigurita(figurita2);
		assertTrue(agregarFigurita1);
		assertTrue(agregarFigurita2);
	}
	
	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws FiguritaRepetidaException {
		UsuarioFinal userFinal = new UsuarioFinal("Simon", 6, 42342321);
		Figurita figurita1 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		userFinal.agregarFigurita(figurita1);
		Boolean agregarFigurita1 = userFinal.pegarFigurita(figurita1);
		assertTrue(agregarFigurita1);
	}
	
	@Test (expected = FiguritaRepetidaException.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaRepetidaException {
		UsuarioFinal userFinal = new UsuarioFinal("Simon", 6, 42342321);
		Figurita figurita1 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		userFinal.agregarFigurita(figurita1);
		Boolean agregarFigurita1 = userFinal.pegarFigurita(figurita1);
		Boolean agregarFigurita2 = userFinal.pegarFigurita(figurita1);
		assertTrue(agregarFigurita1);
		assertFalse(agregarFigurita2);
	}
	
	@Test
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws FiguritaNoDisponibleException, FiguritaRepetidaException {
		UsuarioFinal userFinal1 = new UsuarioFinal("Simon", 6, 42342321);
		UsuarioFinal userFinal2 = new UsuarioFinal("Leo", 45, 4343244);
		Figurita figurita1 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		Figurita figurita2 = new Figurita(9, "D", "Brasil", "Vinicius", 95000.0);
		userFinal1.agregarFigurita(figurita1);
		userFinal2.agregarFigurita(figurita2);
		Boolean intercambioExitoso = userFinal1.intercambiarFiguritas(userFinal2, figurita1, figurita2);

        assertTrue(intercambioExitoso);
	}
	
	@Test (expected = FiguritaNoDisponibleException.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws FiguritaNoDisponibleException, FiguritaRepetidaException {
		UsuarioFinal userFinal1 = new UsuarioFinal("Simon", 6, 42342321);
		UsuarioFinal userFinal2 = new UsuarioFinal("Leo", 45, 4343244);
		Figurita figurita1 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		Figurita figurita2 = new Figurita(9, "D", "Brasil", "Vinicius", 95000.0);
		userFinal2.agregarFigurita(figurita1);
		userFinal1.agregarFigurita(figurita2);
		Boolean intercambioErroneo = userFinal1.intercambiarFiguritas(userFinal2, figurita1, figurita2);
		assertFalse(intercambioErroneo);
	}
	
	@Test (expected = FiguritaNoDisponibleException.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws FiguritaNoDisponibleException, FiguritaRepetidaException {
		UsuarioFinal userFinal1 = new UsuarioFinal("Simon", 6, 42342321);
		UsuarioFinal userFinal2 = new UsuarioFinal("Leo", 45, 4343244);
		Figurita figurita1 = new Figurita(22, "A", "Argentina", "Lautaro Martinez", 35000.0);
		Figurita figurita2 = new Figurita(9, "D", "Brasil", "Vinicius", 95000.0);
		userFinal1.agregarFigurita(figurita1);
		userFinal2.agregarFigurita(figurita2);
		userFinal1.pegarFigurita(figurita1);
		Boolean intercambioExitoso = userFinal1.intercambiarFiguritas(userFinal2, figurita1, figurita2);
        assertFalse(intercambioExitoso);
	}

}
