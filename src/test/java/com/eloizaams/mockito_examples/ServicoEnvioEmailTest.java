package com.eloizaams.mockito_examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTest {
	
	@Mock
	private PlataformaDeEnvio plataforma;
	
	@InjectMocks
	private ServicoEnvioEmail servico;
	
	@Captor
	private ArgumentCaptor<Email> captor;

	@Test
	void validaDadosEnviadosParaPlataforma() {
		String enderecoEmail = "usuario@test.com";
		String mensagem = "Olá mundo - teste mensagem";
		boolean ehFormatoHtml = false;
		
		servico.enviaEmail(enderecoEmail, mensagem, ehFormatoHtml);
		
		Mockito.verify(plataforma).enviaEmail(captor.capture());
		
		Email emailCapturado = captor.getValue();
		
		Assertions.assertEquals(enderecoEmail, emailCapturado.getEnderecoEmail());
		Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
		Assertions.assertEquals(Formato.TEXTO, emailCapturado.getFormato());
	}
}
