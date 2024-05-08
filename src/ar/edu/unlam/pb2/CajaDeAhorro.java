package ar.edu.unlam.pb2;

public class CajaDeAhorro extends Cuenta {

	private Integer cantidadDeExtracciones;
	private final Integer CANTIDAD_DE_EXTRACCIONES_SIN_COSTO;
	private final Double MULTA;

	public CajaDeAhorro(Integer numero, Cliente cliente) {
		super(numero, 0.0, cliente);
		this.cantidadDeExtracciones = 0;
		this.CANTIDAD_DE_EXTRACCIONES_SIN_COSTO = 5;
		this.MULTA = 6.0;
	}

	// SobreEscritura
	public Boolean extraer(Double dineroAExtraer) {
		Boolean resultado = false;
	    this.cantidadDeExtracciones++;
	    
	    if (cantidadDeExtracciones > CANTIDAD_DE_EXTRACCIONES_SIN_COSTO) {
	        dineroAExtraer += this.MULTA; // Se suma el costo adicional después de la quinta extracción
	    }
	    
	    if (this.saldo >= dineroAExtraer) {
	        this.saldo -= dineroAExtraer;
	        resultado = true;
	    }
	    return resultado;
	}

}
