package com.tiarebalbi.sample;

import com.tiarebalbi.annotation.Runnable;

public class Logic1 {

	@Runnable
	public void executar(int tamanho) {
		for(int i = 0; i< tamanho;i++) {
			System.out.println("Virou : " + i);
		}
	}
	
}
