package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Banco {

	private String nombre;
	private ArrayList<CuentaSueldo> cuentasSueldo;
	private ArrayList<CajaDeAhorro> cajasDeAhorro;
	private ArrayList<CuentaCorriente> cuentasCorriente;

	public Banco(String nombre) {
		this.nombre = nombre;
		this.cuentasSueldo = new ArrayList<>();
		this.cajasDeAhorro = new ArrayList<>();
		this.cuentasCorriente = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<CuentaSueldo> getCuentasSueldo() {
		return cuentasSueldo;
	}

	public ArrayList<CajaDeAhorro> getCajasDeAhorro() {
		return cajasDeAhorro;
	}

	public void setCajasDeAhorro(ArrayList<CajaDeAhorro> cajasDeAhorro) {
		this.cajasDeAhorro = cajasDeAhorro;
	}

	public ArrayList<CuentaCorriente> getCuentasCorriente() {
		return cuentasCorriente;
	}

	public Boolean agregarCuenta(CuentaSueldo nueva) {
		return cuentasSueldo.add(nueva);
	}
	
	public Boolean agregarCuenta(CajaDeAhorro nueva) {
		return cajasDeAhorro.add(nueva);
	}
	
	public Boolean agregarCuenta(CuentaCorriente nueva) {
		return cuentasCorriente.add(nueva);
	}

	public CuentaSueldo buscarCuentaSueldo(Integer numero) {
		for(CuentaSueldo actual: cuentasSueldo) {
			if (actual.getNumero().equals(numero)) {
				return actual;
			}
		}
		return null;		
	}
	
	public CajaDeAhorro buscarCajaDeAhorro(Integer numero) {
		for(CajaDeAhorro actual: cajasDeAhorro) {
			if (actual.getNumero().equals(numero)) {
				return actual;
			}
		}
		return null;		
	}
	
	public CuentaCorriente buscarCuentaCorriente(Integer numero) {
		for(CuentaCorriente actual: cuentasCorriente) {
			if (actual.getNumero().equals(numero)) {
				return actual;
			}
		}
		return null;		
	}

	

}
