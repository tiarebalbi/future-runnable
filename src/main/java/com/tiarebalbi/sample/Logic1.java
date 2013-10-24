package com.tiarebalbi.sample;

import com.tiarebalbi.annotation.Runnable;

public class Logic1 {

	@Runnable
	public void executar() {
		for(int i = 0; i< 300;i++) {
			System.out.println("Virou : " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
