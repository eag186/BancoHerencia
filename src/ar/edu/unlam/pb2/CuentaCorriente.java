package ar.edu.unlam.pb2;

public class CuentaCorriente extends Cuenta {

	private Double descubiertoMaximo;
	private Double descubiertoActual;
	private Double deuda;

	public CuentaCorriente(Integer numero, Cliente cliente, Double descubiertoMaximo) {
		super(numero, 0.0, cliente);
		this.descubiertoMaximo = 1500.0;
		this.descubiertoActual = 0.0;
		this.deuda = 0.0;
	}

	public Double getDescubiertoMaximo() {
		return descubiertoMaximo;
	}

	public void setDescubiertoMaximo(Double descubiertoMaximo) {
		this.descubiertoMaximo = descubiertoMaximo;
	}

	public Double getDescubiertoActual() {
		return descubiertoActual;
	}

	public void setDescubiertoActual(Double descubiertoActual) {
		this.descubiertoActual = descubiertoActual;
	}

	public Double getDeuda() {
		return deuda;
	}

	public void setDeuda(Double deuda) {
		this.deuda = deuda;
	}

	// Sobreescritura
	public Boolean extraer(Double dineroAExtraer) {
		  Boolean resultado = false;
	
		    Double descubiertoDisponible = descubiertoMaximo - descubiertoActual;

		    if (dineroAExtraer <= saldo + descubiertoDisponible - deuda) {
		      
		        if (saldo >= dineroAExtraer) {
		            saldo -= dineroAExtraer;
		        } else {		           
		            Double montoDescubiertoUtilizado = dineroAExtraer - saldo;
		            Double comision = montoDescubiertoUtilizado * 0.05;
		            deuda += montoDescubiertoUtilizado + comision;
		            saldo = 0.0;
		            descubiertoActual += montoDescubiertoUtilizado;
		        }
		        resultado = true;
		    }
		    return resultado;
	}
}
