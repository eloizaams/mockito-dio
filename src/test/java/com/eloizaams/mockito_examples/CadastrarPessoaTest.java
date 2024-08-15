package com.eloizaams.mockito_examples;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTest {
	
	
	@Mock
	private ApiDosCorreios apiDosCorreios;
	
	@InjectMocks
	private CadastrarPessoa cadastrarPessoa;
	
	@Test
	void validarDadosCadastro() {
		DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG","Barbacena","Rua Principal","700","centro");
		
		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);
		
		Pessoa eloiza = cadastrarPessoa.cadastrarPessoa("Eloiza", "99999999", LocalDate.now(), "3620000" );
		assertEquals("Eloiza", eloiza.getName());
		assertEquals("99999999", eloiza.getDocumento());
		assertEquals( LocalDate.now(), eloiza.getNascimento());
		assertEquals(dadosLocalizacao.getUf(), eloiza.getEndereco().getUf());
		assertEquals(dadosLocalizacao.getCidade(), eloiza.getEndereco().getCidade());
		assertEquals(dadosLocalizacao.getLogradouro(), eloiza.getEndereco().getLogradouro());
		assertEquals(dadosLocalizacao.getComplemento(), eloiza.getEndereco().getComplemento());
		assertEquals(dadosLocalizacao.getBairro(), eloiza.getEndereco().getBairro());
	}
	
	@Test
	void lancarExcessaoQuandoChamarApiDosCorreios() {
		
		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);
		
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("Eloiza", "99999999", LocalDate.now(), "3620000" ));
	}
	

}
