package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

	@Test
	public void queSePuedaCrearUnBanco() {
		// Preparación
		String nombre = "Unlam";

		// Ejecución
		Banco nuevo = new Banco(nombre);

		// Validación
		assertEquals(nombre, nuevo.getNombre());
	}

	@Test
	public void queSePuedaCrearUnCliente() {
		// Preparación
		Integer dni = 32480349;
		String nombre = "Julian";

		// Ejecución
		Cliente cliente = new Cliente(dni, nombre);

		// Validación
		assertEquals(dni, cliente.getDni());
		assertEquals(nombre, cliente.getNombre());
	}

	// Cuenta Sueldo
	@Test
	public void queSePuedaCrearUnaCuentaSueldo() {
		// Preparación
		Cliente cliente = new Cliente(32480349, "Julian");
		Double saldoInicial = 1000.0;
		Integer numero = 1;
		// Ejecución
		CuentaSueldo nueva = new CuentaSueldo(numero, saldoInicial, cliente);

		// Validación
		assertEquals(cliente, nueva.getCliente());
		assertEquals(1000.00, nueva.getSaldo(), 0.01);
		assertEquals(numero, nueva.getNumero());
	}

	@Test
	public void queSePuedaAgregarUnaCuentaSueldoAlBanco() {
		// Preparación
		Banco unlam = new Banco("Unlams");
		Cliente cliente = new Cliente(32480349, "Julian");

		Double saldoInicial = 1000.0;
		Integer numero = 1;

		CuentaSueldo nueva = new CuentaSueldo(numero, saldoInicial, cliente);

		// Ejecución
		assertTrue(unlam.agregarCuenta(nueva));

		// Validación
		assertNotNull(unlam.buscarCuentaSueldo(numero));
		assertEquals(nueva, unlam.buscarCuentaSueldo(numero));
	}

	@Test
	public void queSePuedaExtraerDineroDeUnaCuentaSueldo() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Double saldoInicial = 1000.0;
		Integer numero = 1;
		Double dineroAExtraer = 500.0;
		Boolean resultado;
		Double saldoEsperado = 500.0;

		CuentaSueldo nueva = new CuentaSueldo(numero, saldoInicial, cliente);

		// Ejecución
		unlam.agregarCuenta(nueva);
		resultado = nueva.extraer(dineroAExtraer);

		// Validación
		assertTrue(resultado);
		assertEquals(saldoEsperado, nueva.getSaldo());
	}

	@Test
	public void queSePuedaDepositarDineroEnUnaCuentaSueldo() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Double saldoInicial = 1000.0;
		Integer numero = 1;
		Double dineroADepositar = 500.0;
		Double saldoEsperado = 1500.0;

		CuentaSueldo nueva = new CuentaSueldo(numero, saldoInicial, cliente);

		// Ejecución
		unlam.agregarCuenta(nueva);
		nueva.depositar(dineroADepositar);

		// Validación
		assertEquals(saldoEsperado, nueva.getSaldo());
	}

	@Test
	public void queSeNoPuedaExtraerMasDineroQueElSaldoDisponibleDeUnaCuentaSueldo() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Double saldoInicial = 1000.0;
		Integer numero = 1;
		Double dineroAExtraer = 1500.0;
		Boolean resultado;
		Double saldoEsperado = 1000.0;

		CuentaSueldo nueva = new CuentaSueldo(numero, saldoInicial, cliente);

		// Ejecución
		unlam.agregarCuenta(nueva);
		resultado = nueva.extraer(dineroAExtraer);

		// Validación
		assertFalse(resultado);
		assertEquals(saldoEsperado, nueva.getSaldo());
	}

	// Caja de Ahorro

	@Test
	public void queSePuedaCrearUnaCajaDeAhorro() {
		// Preparación
		Cliente cliente = new Cliente(32480349, "Julian");
		Integer numero = 1;

		// Ejecución
		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// Validación
		assertEquals(cliente, nueva.getCliente());
		assertEquals(0.00, nueva.getSaldo(), 0.01);
		assertEquals(numero, nueva.getNumero());
	}

	@Test
	public void queSePuedaAgregarUnaCajaDeAhorroAlBanco() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");
		Integer numero = 1;

		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// Ejecución
		unlam.agregarCuenta(nueva);

		// Validación
		assertNotNull(unlam.buscarCajaDeAhorro(numero));
		assertEquals(nueva, unlam.buscarCajaDeAhorro(numero));
	}

	@Test
	public void queSePuedaDepositarDineroEnUnaCajaDeAhorro() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Integer numero = 1;
		Double dineroADepositar = 500.0;
		Double saldoEsperado = 500.0;

		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// Ejecución
		unlam.agregarCuenta(nueva);
		nueva.depositar(dineroADepositar);

		// Validación
		assertEquals(saldoEsperado, nueva.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDineroDeUnaCajaDeAhorro() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Integer numero = 1;
		Double dineroADepositar = 1000.0;
		Double dineroAExtraer = 500.0;
		Boolean resultado;
		Double saldoEsperado = 500.0;

		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// Ejecución
		assertTrue(unlam.agregarCuenta(nueva));
		nueva.depositar(dineroADepositar);
		resultado = nueva.extraer(dineroAExtraer);

		// Validación
		assertTrue(resultado);
		assertEquals(saldoEsperado, nueva.getSaldo());
	}

	@Test
	public void queSeNoPuedaExtraerMasDineroQueElSaldoDisponibleDeUnaCajaDeAhorro() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Integer numero = 1;
		Double dineroAExtraer = 1500.0;
		Boolean resultado;
		Double saldoEsperado = 0.0;

		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// Ejecución
		unlam.agregarCuenta(nueva);
		resultado = nueva.extraer(dineroAExtraer);

		// Validación
		assertFalse(resultado);
		assertEquals(saldoEsperado, nueva.getSaldo());
	}

	@Test
	public void queEnLaSextaExtraccionSeApliqueUnCostoDe6PesosEnUnaCajaDeAhorro() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Integer numero = 1;
		Double dineroADepositar = 15000.0;
		Double dineroAExtraer = 1500.0;
		Double saldoEsperado = 5994.0;

		CajaDeAhorro nueva = new CajaDeAhorro(numero, cliente);

		// Ejecución
		unlam.agregarCuenta(nueva);
		nueva.depositar(dineroADepositar);
		nueva.extraer(dineroAExtraer);
		nueva.extraer(dineroAExtraer);
		nueva.extraer(dineroAExtraer);
		nueva.extraer(dineroAExtraer);
		nueva.extraer(dineroAExtraer);
		nueva.extraer(dineroAExtraer);

		// Validación
		assertEquals(saldoEsperado, nueva.getSaldo());
	}

	// Cuenta Corriente
	@Test
	public void queSePuedaCrearUnaCuentaCorriente() {
		// Preparación
		Cliente cliente = new Cliente(32480349, "Julian");
		Integer numero = 1;
		Double descubiertoMaximo = 1500.0;

		// Ejecución
		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// Validación
		assertEquals(cliente, nueva.getCliente());
		assertEquals(0.00, nueva.getSaldo(), 0.01);
		assertEquals(numero, nueva.getNumero());
	}

	@Test
	public void queSePuedaAgregarUnaCuentaCorrienteAlBanco() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");
		Integer numero = 1;
		Double descubiertoMaximo = 1500.0;
		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// Ejecución
		unlam.agregarCuenta(nueva);

		// Validación
		assertNotNull(unlam.buscarCuentaCorriente(numero));
		assertEquals(nueva, unlam.buscarCuentaCorriente(numero));
	}

	@Test
	public void queSePuedaDepositarDineroEnUnaCuentaCorriente() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Integer numero = 1;
		Double descubiertoMaximo = 1500.0;
		Double dineroADepositar = 1500.0;
		Double saldoEsperado = 1500.0;

		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// Ejecución
		unlam.agregarCuenta(nueva);
		nueva.depositar(dineroADepositar);

		// Validación
		assertEquals(saldoEsperado, nueva.getSaldo());
	}

	@Test
	public void queSePuedaExtraerDineroDeUnaCuentaCorriente() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Integer numero = 1;
		Double descubiertoMaximo = 1500.0;
		Double dineroADepositar = 1000.0;
		Double dineroAExtraer = 500.0;
		Boolean resultado;
		Double saldoEsperado = 500.0;

		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// Ejecución
		assertTrue(unlam.agregarCuenta(nueva));
		nueva.depositar(dineroADepositar);
		resultado = nueva.extraer(dineroAExtraer);

		// Validación
		assertTrue(resultado);
		assertEquals(saldoEsperado, nueva.getSaldo());
	}

	@Test
	public void queSePuedaExtraerMasDineroQueElSaldoDisponibleDeUnaCuentaCorriente() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Integer numero = 1;
		Double dineroADepositar = 1500.0;
		Double descubiertoMaximo = 1500.0;
		Double dineroAExtraer = 1500.0;
		Boolean resultado;
		Double saldoEsperado = 0.0;

		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// Ejecución
		unlam.agregarCuenta(nueva);
		nueva.depositar(dineroADepositar);
		resultado = nueva.extraer(dineroAExtraer);

		// Validación
		assertTrue(resultado);
		assertEquals(saldoEsperado, nueva.getSaldo());
	}

	@Test
	public void queNoSePuedaExtraerMasDineroQueElSaldoDisponibleMasElDescubiertoDeUnaCuentaCorriente() {
		// Preparación
		Banco unlam = new Banco("Unlam");
		Cliente cliente = new Cliente(32480349, "Julian");

		Integer numero = 1;
		Double descubiertoMaximo = 1500.0;
		Double dineroAExtraer = 3000.0;
		Boolean resultado;
		Double saldoEsperado = 0.0;

		CuentaCorriente nueva = new CuentaCorriente(numero, cliente, descubiertoMaximo);

		// Ejecución
		unlam.agregarCuenta(nueva);
		resultado = nueva.extraer(dineroAExtraer);

		// Validación
		assertFalse(resultado);
		assertEquals(saldoEsperado, nueva.getSaldo());
	}
}