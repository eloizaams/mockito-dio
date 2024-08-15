package com.eloizaams.mockito_examples;

import static org.mockito.Mockito.mockitoSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import net.bytebuddy.asm.Advice.Argument;

@ExtendWith(MockitoExtension.class)
public class ContaTest {

	@Spy
	private Conta conta = new Conta(1000);
	
	@Test
	void validarOrdemDeChamadas() {
		conta.pagarBoleto(300);
		
		InOrder inOrder = Mockito.inOrder(conta);
		inOrder.verify(conta).pagarBoleto(ArgumentMatchers.anyInt());
		inOrder.verify(conta).validaSaldo(ArgumentMatchers.anyInt());
		inOrder.verify(conta).debita(ArgumentMatchers.anyInt());
		inOrder.verify(conta).enviaCreditoParaEmissor(ArgumentMatchers.anyInt());
	}
	
	@Test
	void validarQuantidadeDeChamadas() {
		
		conta.validaSaldo(300);
		conta.validaSaldo(500);
		conta.validaSaldo(600);
	
		Mockito.verify(conta, Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());
	}
	
	@Test
	void retornaTrueParaQualquerValorNaValidacaoDeSaldo() {
		Mockito.doNothing().when(conta).validaSaldo(ArgumentMatchers.anyInt());
		conta.validaSaldo(2500);
	}
		
}
