package com.eloizaams.mockito_examples;

import java.util.List;
import java.util.SplittableRandom;

public class GeradorDeNumeros {
	
	private static SplittableRandom random = new SplittableRandom();

	private GeradorDeNumeros() {
	}

	
	public static List<Integer> geraNumerosAleatorios(int tamanhoLista){
		return random.ints().boxed().limit(tamanhoLista).toList();
	}
	
	public static List<Integer> geraNumerosAleatorios(){
		return random.ints().boxed().limit(random.nextInt(10)).toList();
	}
	
	
}
