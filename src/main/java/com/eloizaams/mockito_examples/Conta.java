package com.eloizaams.mockito_examples;

public class Conta {
	
	public int saldo;

	public Conta(int saldo) {
		this.saldo = saldo;
	}
	

	public void pagarBoleto(int valorAPagar) {
		validaSaldo(valorAPagar);
		debita(valorAPagar);
		enviaCreditoParaEmissor(valorAPagar);
	}


	public void validaSaldo(int valorAPagar) {
		if(valorAPagar > saldo) {
			throw new IllegalStateException("Saldo insuficiente");
		}
	}


	public void debita(int valorAPagar) {

		saldo -= valorAPagar;
	}


	public void enviaCreditoParaEmissor(int valorAPagar) {
		//envia valor para emissor do boleto 	
	}

}
