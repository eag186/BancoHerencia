package ar.edu.unlam.pb2;

public class Cuenta {

	private Integer numero;
	protected Double saldo;
	private Cliente cliente;

	public Cuenta(Integer numero, Double saldo, Cliente cliente) {
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Boolean extraer(Double dineroAExtraer) {
		Boolean resultado = false;
		if(this.saldo >= dineroAExtraer) {
			this.saldo -= dineroAExtraer;
			resultado = true;
		}
		return resultado;
	}
	
	public void depositar(Double dineroADepositar) {
		this.saldo += dineroADepositar;
	}

}
